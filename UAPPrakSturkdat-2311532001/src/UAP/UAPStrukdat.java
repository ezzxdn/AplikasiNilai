package UAP;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class UAPStrukdat extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField tfNama, tfNIM, tfNilai;
    private JButton btnTambah, btnUrutkan, btnHapus;
    private JTextArea output;
    private Queue<Student> studentQueue;
    private Stack<Student> studentStack;

    class Student {
        private String nama;
        private String nim;
        private double nilai;

        public Student (String nama, String nim, double nilai) {
            this.nama = nama;
            this.nim = nim;
            this.nilai = nilai;
        }
        public String getnama() {
            return nama;
        }
        public String getnim() {
            return nim;
        }
        public double getnilai() {
            return nilai;
        }
        public String toString() {
            return "Nama:  " + nama + ", NIM: " + nim + ", Nilai: " + nilai;
        }
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UAPStrukdat frame = new UAPStrukdat();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public UAPStrukdat() {
        studentQueue = new LinkedList<>();
        studentStack = new java.util.Stack<>();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 705, 498);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblJudul = new JLabel("DATA NILAI MAHASISWA FTI 2024");
        lblJudul.setHorizontalAlignment(SwingConstants.CENTER);
        lblJudul.setFont(new Font("Times New Roman", Font.BOLD, 30));
        lblJudul.setBounds(85, 11, 527, 46);
        contentPane.add(lblJudul);

        JLabel lblNama = new JLabel("NAMA");
        lblNama.setHorizontalAlignment(SwingConstants.LEFT);
        lblNama.setFont(new Font("Times New Roman", Font.BOLD, 22));
        lblNama.setBounds(45, 81, 82, 26);
        contentPane.add(lblNama);

        JLabel lblNIM = new JLabel("NIM");
        lblNIM.setHorizontalAlignment(SwingConstants.LEFT);
        lblNIM.setFont(new Font("Times New Roman", Font.BOLD, 22));
        lblNIM.setBounds(45, 122, 82, 26);
        contentPane.add(lblNIM);

        JLabel lblJurusan = new JLabel("JURUSAN");
        lblJurusan.setHorizontalAlignment(SwingConstants.LEFT);
        lblJurusan.setFont(new Font("Times New Roman", Font.BOLD, 22));
        lblJurusan.setBounds(45, 159, 124, 26);
        contentPane.add(lblJurusan);

        JLabel lblNilai = new JLabel("NILAI");
        lblNilai.setHorizontalAlignment(SwingConstants.LEFT);
        lblNilai.setFont(new Font("Times New Roman", Font.BOLD, 22));
        lblNilai.setBounds(45, 196, 124, 26);
        contentPane.add(lblNilai);

        tfNama = new JTextField();
        tfNama.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        tfNama.setBounds(216, 80, 435, 26);
        contentPane.add(tfNama);
        tfNama.setColumns(10);

        tfNIM = new JTextField();
        tfNIM.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        tfNIM.setColumns(10);
        tfNIM.setBounds(216, 117, 435, 26);
        contentPane.add(tfNIM);

        tfNilai = new JTextField();
        tfNilai.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        tfNilai.setColumns(10);
        tfNilai.setBounds(216, 196, 435, 26);
        contentPane.add(tfNilai);

        JComboBox cbJurusan = new JComboBox();
        cbJurusan.setModel(new DefaultComboBoxModel(new String[] {"Informatika", "Teknik Komputer", "Sistem Informasi"}));
        cbJurusan.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        cbJurusan.setBounds(216, 159, 435, 22);
        contentPane.add(cbJurusan);

        btnTambah = new JButton("TAMBAH");
        btnTambah.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = tfNama.getText();
                String nim = tfNIM.getText();
                String nilai = tfNilai.getText();
                if (!nama.isEmpty() &&!nim.isEmpty() &&!nilai.isEmpty()) {
                    Student student = new Student(nama, nim, Double.parseDouble(nilai));
                    studentQueue.add(student);
                    studentStack.push(student);
                    tfNama.setText("");
                    tfNIM.setText("");
                    tfNilai.setText("");
                }
            }
        });
        btnTambah.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        btnTambah.setBounds(45, 233, 169, 35);
        contentPane.add(btnTambah);

        btnUrutkan = new JButton("URUTKAN");
        btnUrutkan.addActionListener(new ActionListener() {
            private void bubbleSort(Queue<Student> queue) {
                int n = queue.size();
                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < n - i - 1; j++) {
                        Student s1 = queue.poll();
                        Student s2 = queue.poll();
                        if (s1.getnilai() > s2.getnilai()) {
                            queue.add(s2);
                            queue.add(s1);
                        } else {
                            queue.add(s1);
                            queue.add(s2);
                        }
                    }
                }
            }
            public void actionPerformed(ActionEvent e) {
                bubbleSort(studentQueue);
                output.setText("");
                for (Student student : studentQueue) {
                    output.append(student.toString() + "\n");
                }
            }
        });
        btnUrutkan.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        btnUrutkan.setBounds(263, 233, 169, 35);
        contentPane.add(btnUrutkan);

        btnHapus = new JButton("HAPUS");
        btnHapus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                studentQueue.clear();
                studentStack.clear();
                output.setText("");
            }
        });
        btnHapus.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        btnHapus.setBounds(482, 233, 169, 35);
        contentPane.add(btnHapus);

        output = new JTextArea();
        output.setBounds(10, 277, 671, 173);
        contentPane.add(output);
    }
}