package UAP;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Queue;
import java.util.Stack;

public class coba2 {
    private JFrame frame;
    private JTextField nameField, nimField, gradeField;
    private JButton addButton, sortButton, clearButton;
    private JTextArea outputArea;
    private Queue<Student> studentQueue;
    private Stack<Student> studentStack;

    public coba2() {
        studentQueue = new java.util.LinkedList<>();
        studentStack = new java.util.Stack<>();

        frame = new JFrame("Program Mengurutkan Nilai Mahasiswa");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

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
        addButton = new JButton("Tambah Mahasiswa");
        addButton.addActionListener(new AddButtonListener());
        buttonPanel.add(addButton);
        sortButton = new JButton("Urutkan Mahasiswa");
        sortButton.addActionListener(new SortButtonListener());
        buttonPanel.add(sortButton);
        clearButton = new JButton("Hapus Mahasiswa");
        clearButton.addActionListener(new ClearButtonListener());
        buttonPanel.add(clearButton);

        // Create output panel
        outputArea = new JTextArea(10, 20);
        outputArea.setEditable(false);

        // Add components to frame
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(new JScrollPane(outputArea), BorderLayout.SOUTH);

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
                studentQueue.add(student);
                studentStack.push(student);
                nameField.setText("");
                nimField.setText("");
                gradeField.setText("");
            }
        }
    }

    private class SortButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            bubbleSort(studentQueue);
            outputArea.setText("");
            for (Student student : studentQueue) {
                outputArea.append(student.toString() + "\n");
            }
        }
    }

    private class ClearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            studentQueue.clear();
            studentStack.clear();
            outputArea.setText("");
        }
    }

    private void bubbleSort(Queue<Student> queue) {
        int n = queue.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                Student s1 = queue.poll();
                Student s2 = queue.poll();
                if (s1.getGrade() > s2.getGrade()) {
                    queue.add(s2);
                    queue.add(s1);
                } else {
                    queue.add(s1);
                    queue.add(s2);
                }
            }
        }
    }

    private class Student {
        private String name;
        private String nim;
        private double grade;

        public Student(String name, String nim, double grade) {
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
                new coba2();
            }
        });
    }
}
