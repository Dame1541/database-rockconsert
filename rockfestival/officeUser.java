package rockFestival;

        import java.awt.EventQueue;

        import javax.swing.*;
        import javax.swing.border.EmptyBorder;
        import java.awt.Color;
        import java.awt.Font;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import javax.swing.border.LineBorder;

public class officeUser extends JFrame {

    private JPanel contentPane;
    private JTable scheduleTable;
    private JTextField txtBandName;
    private JTextField tvtMemberName;
    private JButton submit;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    officeUser frame = new officeUser();
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
    public officeUser() {
        setTitle("Mörtfors Rock Festival - Office");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(80, 20, 1200, 1000);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //SCHEDULE RUTA
        scheduleTable = new JTable();
        scheduleTable.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
        scheduleTable.setToolTipText("gsdgsegsegse");
        scheduleTable.setBackground(Color.WHITE);
        scheduleTable.setBounds(80, 500, 1200 - 85 - 85, 500 - 85 - 85); //startar på x = 80, samt border 5
        contentPane.add(scheduleTable);

        JLabel lblSchedule = new JLabel("Schedule");
        lblSchedule.setForeground(new Color(178, 34, 34));
        lblSchedule.setFont(new Font("Helvetica Neue", Font.BOLD, 22));
        lblSchedule.setBackground(Color.WHITE);
        lblSchedule.setBounds(500, 470, 200, 16);
        contentPane.add(lblSchedule);

        JLabel lblTitel = new JLabel();
        lblTitel.setForeground(new Color(178, 34, 34));
        lblTitel.setFont(new Font("Helvetica Neue", Font.BOLD, 42));
        lblTitel.setText("Mörtfors Rock Festival - Booking");
        lblTitel.setBounds(290, 20, 860, 72);
        ImageIcon logo = new ImageIcon("images/rockestival.png");
        lblTitel.setIcon(logo);
        contentPane.add(lblTitel);

        //bOOK RUTA
        JPanel pnlBook = new JPanel();
        pnlBook.setBackground(Color.WHITE);
        pnlBook.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
        pnlBook.setBounds(80, 110, 1200 - 85 - 85, 300);
        contentPane.add(pnlBook);
        pnlBook.setLayout(null);

        JLabel lblBand = new JLabel("Band:");
        lblBand.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
        lblBand.setForeground(new Color(178, 34, 34));
        lblBand.setBounds(70, 10, 200, 72);
        pnlBook.add(lblBand);

        JLabel lblPersonnel = new JLabel("Personnel:");
        lblPersonnel.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
        lblPersonnel.setForeground(new Color(178, 34, 34));
        lblPersonnel.setBounds(70 + 320, 10, 200, 72);
        pnlBook.add(lblPersonnel);

        JLabel lblStage = new JLabel("Stage:");
        lblStage.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
        lblStage.setForeground(new Color(178, 34, 34));
        lblStage.setBounds(70 + 300 + 300, 10, 200, 72);
        pnlBook.add(lblStage);

//submit button

        submit = new JButton();
        this.submit.addActionListener(new BookingListener());
        submit.setBounds(70 + 360 + 400, 10 + 72, 100, 20);
        pnlBook.add(submit);


        //3 COMBO BOXES
        JComboBox combo1 = new JComboBox();
        String[] theBands = {"Abba", "U2", "Metallica",
                "The rolling stones", "The eagles"};
        for (int i = 0; i < theBands.length; i++) {
            combo1.addItem(theBands[i]);
            combo1.setBounds(70, 10 + 72, 200, 20);
            pnlBook.add(combo1);
        }

        JComboBox combo2 = new JComboBox();
        String[] thePersonnel = {"Amanda Eriksson", "Ramy Behnam", "Jonas Drewling",
                "Elena Tayar"};

        JComboBox combo3 = new JComboBox();
        String[] theStages = {"Mallorca", "Swedband Station", "Konserthuset",
                "Opera", "Malmö Live"};
    }

    private class BookingListener implements ActionListener {
        private BookingListener() {
        }

        public void actionPerformed(ActionEvent ae) {
            submit.setBackground(Color.BLACK);
            JOptionPane.showMessageDialog(contentPane, "You have booked a band, personnel and a stage");
            //nu sätta in saker i mitt table
            //band, personnel, stage + tid
            //for Mallorca stage and 14:00, add band + personnel. behöver alltså få tag på det so mfinns i mina arrayer
            //if chosen stage + time, add band + personnel as a String: "Abba" and "Amanda".
            //how take this from the database? get connection, then get object, variable from database? 
        }
    }
}
