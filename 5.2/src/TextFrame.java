import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

/**
 A class for displaying the model as a column of textfields in a frame.
 */
public class TextFrame extends JFrame
{
    /**
     Constructs a JFrame that contains the textfields containing the data
     in the model.
     @param d the model to display
     */
    public TextFrame(DataModel d)
    {
        dataModel = d;

        final Container contentPane = this.getContentPane();
        setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        ArrayList<Double> a = dataModel.getData();
        fieldList = new JTextField[a.size()];

        final int FIELD_WIDTH = 11;
        for (int i = 0; i < a.size(); i++)
        {
            JTextField textField = new JTextField(a.get(i).toString(),FIELD_WIDTH);
            //textField.addActionListener(l);
            add(textField);
            fieldList[i] = textField;
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    DataModel dataModel;
    JTextField[] fieldList;
}