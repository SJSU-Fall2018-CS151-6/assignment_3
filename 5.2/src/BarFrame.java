import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

/**
 A class that implements an Observer object that displays a barchart view of
 a data model.
 */
public class BarFrame extends JFrame implements ChangeListener
{
    /**
     Constructs a BarFrame object
     @param dataModel the data that is displayed in the barchart
     */
    public BarFrame(DataModel dataModel)
    {
        this.dataModel = dataModel;
        a = dataModel.getData();

        setLocation(0,200);
        setLayout(new BorderLayout());

        Icon barIcon = new Icon()
        {
            public int getIconWidth() { return ICON_WIDTH; }
            public int getIconHeight() { return ICON_HEIGHT; }
            public void paintIcon(Component c, Graphics g, int x, int y)
            {
                Graphics2D g2 = (Graphics2D) g;

                g2.setColor(Color.red);

                double max =  (a.get(0)).doubleValue();
                for (Double v : a)
                {
                    double val = v.doubleValue();
                    if (val > max)
                        max = val;
                }

                double barHeight = getIconHeight() / a.size();

                int i = 0;
                for (Double v : a)
                {
                    double value = v.doubleValue();

                    double barLength = getIconWidth() * value / max;

                    Rectangle2D.Double rectangle = new Rectangle2D.Double
                            (0, barHeight * i, barLength, barHeight);
                    i++;
                    g2.fill(rectangle);
                }
            }
        };

        addMouseListener(new MouseAdapter()
                                 {
                                     public void mousePressed(MouseEvent event)
                                     {
                                         // mouse action goes here
                                         mousePoint = event.getPoint();
                                         double dx = mousePoint.getX();
                                         double dy = mousePoint.getY();
                                     }
                                 });
        add(new JLabel(barIcon));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    /**
     Called when the data in the model is changed.
     @param e the event representing the change
     */
    public void stateChanged(ChangeEvent e)
    {
        a = dataModel.getData();
        repaint();
    }

    private ArrayList<Double> a;
    private DataModel dataModel;

    private static final int ICON_WIDTH = 200;
    private static final int ICON_HEIGHT = 200;
    private Point mousePoint;
}