import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KiloConverter extends JFrame {
    private JPanel panel;
    private JLabel messageLabel;
    private JLabel message2Label;
    private JTextField costTextField;
    private JTextField percentTextField;
    private JButton calcButton;
    private JLabel retailPriceOutput;
    private final int WINDOW_WIDTH = 310;
    private final int WINDOW_HEIGHT = 150;

    public KiloConverter(){
        setTitle("Retail Price Calculator");

        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buildPanel();

        add(panel);

        setVisible(true);
    }

    private void buildPanel(){
        messageLabel = new JLabel("Wholesale Cost:");

        costTextField = new JTextField(10);

        message2Label = new JLabel("Markup percentage:");

        percentTextField = new JTextField(10);

        calcButton = new JButton("Calculate");

        retailPriceOutput = new JLabel("$0.00");


        calcButton.addActionListener(new CalcButtonListener());

        panel = new JPanel();

        panel.add(messageLabel);
        panel.add(costTextField);
        panel.add(message2Label);
        panel.add(percentTextField);
        panel.add(calcButton);
        panel.add(retailPriceOutput);
    }

    private class CalcButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String input;
            String retailPrice;
            double markUp;
            String percent;

            input = costTextField.getText();
            percent = percentTextField.getText();
            markUp = Double.parseDouble(input) * Double.parseDouble(percent);

            retailPrice = String.format("%.2f", Double.parseDouble(input) + markUp);

            retailPriceOutput.setText("$" + retailPrice);
        }
    }
}
