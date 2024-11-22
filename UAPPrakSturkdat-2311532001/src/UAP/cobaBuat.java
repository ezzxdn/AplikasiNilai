package UAP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class cobaBuat {
    private JFrame frame;
    private JTextField nameField, nimField, gradeField;
    private JButton addButton, sortButton, clearButton;
    private JTextArea outputArea;
    private ArrayList<Student> studentList;

    public cobaBuat() {
        studentList = new ArrayList<>();

        frame = new JFrame("Program Mengurutkan Nilai Mahasiswa");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        // Create input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Nama:"));
        nameField = new JTextField();
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("NIM:"));
        nimField = new JTextField();
        inputPanel.add(nimField);
        inputPanel.add(new JLabel("Nilai:"));
        gradeField = new JTextField();
        inputPanel.add(gradeField);

        // Create button panel
        JPanel buttonPanel = new JPanel();
        addButton = new JButton("Tambah");
        addButton.addActionListener(new AddButtonListener());
        buttonPanel.add(addButton);
        sortButton = new JButton("Urutkan");
        sortButton.addActionListener(new SortButtonListener());
        buttonPanel.add(sortButton);
        clearButton = new JButton("Hapus");
        clearButton.addActionListener(new ClearButtonListener());
        buttonPanel.add(clearButton);

        // Create output panel
        outputArea = new JTextArea(10, 20);
        outputArea.setEditable(false);

        // Add components to frame
        frame.getContentPane().add(inputPanel, BorderLayout.NORTH);
        frame.getContentPane().add(buttonPanel, BorderLayout.CENTER);
        frame.getContentPane().add(new JScrollPane(outputArea), BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }

    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String nim = nimField.getText();
            String grade = gradeField.getText();
            if (!name.isEmpty() &&!nim.isEmpty() &&!grade.isEmpty()) {
                Student student = new Student(name, nim, Double.parseDouble(grade));
                studentList.add(student);
                nameField.setText("");
                nimField.setText("");
                gradeField.setText("");
            }
        }
    }

    private class SortButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            bubbleSort(studentList);
            outputArea.setText("");
            for (Student student : studentList) {
                outputArea.append(student.toString() + "\n");
            }
        }
    }

    private class ClearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            studentList.clear();
            outputArea.setText("");
        }
    }

    private void bubbleSort(ArrayList<Student> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).getGrade() > list.get(j + 1).getGrade()) {
                    Student temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    private class Student {
        private String name;
        private String nim;
        private double grade;

        public Student(String name, String npm, double grade) {
            this.name = name;
            this.nim = nim;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public String getNim() {
            return nim;
        }

        public double getGrade() {
            return grade;
        }

        @Override
        public String toString() {
            return "Nama: " + name + ", NIM: " + nim + ", Nilai: " + grade;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new cobaBuat();
            }
        });
    }
}
