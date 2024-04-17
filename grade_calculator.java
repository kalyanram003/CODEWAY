
// Student grade Calculator

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class grade_calculator extends JFrame {
    private JLabel lblNumSubjects, lblMarks, lblMarks1,headlabel;
    private JTextField txtNumSubjects, txtMarks;
    private JButton btnCalculate;
    private JTextArea txtResult;

    public grade_calculator() {
        setTitle("Grade Calculator");
        setSize(700, 700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);


        headlabel = new JLabel("STUDENT GRADE CALCULATOR");
        headlabel.setBounds(130, 40, 450, 75);
        Border border=BorderFactory.createLineBorder(Color.gray,10); 
        headlabel.setHorizontalTextPosition(JLabel.CENTER);
        headlabel.setVerticalTextPosition(JLabel.TOP);
        headlabel.setForeground(Color.red);
        headlabel.setFont(new Font("Consolas",Font.BOLD,32));
        headlabel.setBackground(Color.gray);
        headlabel.setBorder(border);
        headlabel.setOpaque(true);

        add(headlabel);


        lblNumSubjects = new JLabel("Enter the number of subjects:");
        lblNumSubjects.setBounds(130, 157, 200, 20);
        add(lblNumSubjects);

        

        txtNumSubjects = new JTextField();
        txtNumSubjects.setBounds(320, 150, 100, 30);
        add(txtNumSubjects);

        lblMarks = new JLabel("Enter Total marks obtained : ");
        
        lblMarks.setBounds(255, 250, 250, 20);
        add(lblMarks);

        lblMarks1 = new JLabel("Eg:If number of subjects are 3 then Total marks = subject1 + subject2 + subject3.....");

        lblMarks1.setBounds(150, 220, 550, 20);
        add(lblMarks1);

        txtMarks = new JTextField();
        txtMarks.setBounds(70, 290, 550, 30);
        add(txtMarks);

        btnCalculate = new JButton("Calculate");
        btnCalculate.setBounds(270, 360, 150, 50);
        add(btnCalculate);

        txtResult = new JTextArea();
        txtResult.setBounds(150, 450, 380, 170);
        txtResult.setEditable(false);
        add(txtResult);

        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateGrade();
            }
        });
    }

    private void calculateGrade() {
        int numSubjects = Integer.parseInt(txtNumSubjects.getText());
        String[] marksText = txtMarks.getText().split(" ");
        int totalMarks = 0;
        for (String mark : marksText) {
            totalMarks += Integer.parseInt(mark);
        }
        double averagePercentage = (double) totalMarks / numSubjects;

        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else if (averagePercentage >= 50) {
            grade = 'E';
        } else {
            grade = 'F';
        }

        String result = "Total Marks: " + totalMarks + "\nAverage Percentage: " + averagePercentage + "\nGrade: " + grade;
        txtResult.setText(result);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new grade_calculator().setVisible(true);
            }
        });
    }
}

