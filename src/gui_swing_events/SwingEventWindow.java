package gui_swing_events;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingEventWindow implements ActionListener {
    private int rdoChecked = 1; // Default to the first radio button
    private JFrame frame;
    private JTextField txtInput;
    private JTextField txtResult;

    public SwingEventWindow() {
        frame = new JFrame("Swing Events");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new GridLayout(6, 1));
        JPanel panel1 = new JPanel();
        JLabel lblMain = new JLabel("Excel Functions");
        panel1.add(lblMain);
        JPanel panel2 = new JPanel();
        JLabel lblRequest = new JLabel("Enter numbers separated by a space: ");
        txtInput = new JTextField(20);
        panel2.add(lblRequest);
        panel2.add(txtInput);

        JPanel panel3 = new JPanel();
        JRadioButton rdoTotal = new JRadioButton("Total");
        JRadioButton rdoAvg = new JRadioButton("Average");
        JRadioButton rdoMax = new JRadioButton("Maximum");
        JRadioButton rdoMin = new JRadioButton("Minimum");

        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(rdoTotal);
        btnGroup.add(rdoAvg);
        btnGroup.add(rdoMax);
        btnGroup.add(rdoMin);

        rdoTotal.addActionListener(this);
        rdoAvg.addActionListener(this);
        rdoMax.addActionListener(this);
        rdoMin.addActionListener(this);

        panel3.add(rdoTotal);
        panel3.add(rdoAvg);
        panel3.add(rdoMax);
        panel3.add(rdoMin);

        JPanel panel4 = new JPanel();
        JButton btnCalculate = new JButton("Calculate");
        btnCalculate.addActionListener(this);
        panel4.add(btnCalculate);

        JPanel panel5 = new JPanel();
        JLabel lblResult = new JLabel("Result: ");
        txtResult = new JTextField(10);
        txtResult.setEditable(false);
        panel5.add(lblResult);
        panel5.add(txtResult);

        mainPanel.add(panel1);
        mainPanel.add(panel2);
        mainPanel.add(panel3);
        mainPanel.add(panel4);
        mainPanel.add(panel5);
        frame.add(mainPanel);
    }

    public void runSwingEventWindow() {
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JRadioButton) {
            JRadioButton selectedRadioButton = (JRadioButton) e.getSource();

            if (selectedRadioButton.getText().equals("Total")) {
                rdoChecked = 1;
            } else if (selectedRadioButton.getText().equals("Average")) {
                rdoChecked = 2;
            } else if (selectedRadioButton.getText().equals("Maximum")) {
                rdoChecked = 3;
            } else if (selectedRadioButton.getText().equals("Minimum")) {
                rdoChecked = 4;
            }
        } else if (e.getActionCommand().equals("Calculate")) {
            String input = txtInput.getText();
            Excel excel = new Excel(input);

            double result = 0.0;

            switch (rdoChecked) {
                case 1:
                    result = excel.findTotal();
                    break;
                case 2:
                    result = excel.findAvg();
                    break;
                case 3:
                    result = excel.findMax();
                    break;
                case 4:
                    result = excel.findMin();
                    break;
            }
            txtResult.setText(String.valueOf(result));
        }
    }
}
