package rockFestival;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class viewerUser extends JFrame {
	
//	JPanel
	private JPanel contentPane;
	private JPanel pnlBand = new JPanel();
	private JPanel pnlMember = new JPanel();
	
//JTextArea
	JTextArea taMemberInfo = new JTextArea();
	JTextArea taBandMembers = new JTextArea();

//	JLables
	private JLabel lblSchedule = new JLabel("Schedule");
	private JLabel lblBands = new JLabel("Bands");
	private JLabel lblMember = new JLabel("Member");
	private JLabel lblTitel = new JLabel();
	private JLabel lblBName = new JLabel("Band name:");
	private JLabel lblBCountry = new JLabel("Country:");
	private JLabel lblBMembers = new JLabel("Members:");
	private JLabel lblEnterBandName = new JLabel("Enter band name");
	private JLabel lblBandName = new JLabel("");
	private JLabel lblBandCountry = new JLabel("");
	private JLabel lblEnterMemberName = new JLabel("Enter member name");
	private JLabel lblMName = new JLabel("Member name:");
	private JLabel lblMInfo = new JLabel("Info:");
	private JLabel lblMemberName = new JLabel("");
	
//	JTable
	private  JTable scheduleTable;

//	JButtons
	JButton btnBandSearch = new JButton("Search");
	JButton btnMemberSearch = new JButton("Search");
	
//  JTextField
	private JTextField txtBandName;
	private JTextField txtMemberName;
	
	
	public viewerUser() {
		initComponents();
		showSchedule();
	}
	
	
	public ArrayList<Schedule> scheduleList(){
		ArrayList<Schedule> scheduleList = new ArrayList<>();
		try {
			Class.forName("org.postgresql.Driver");
			Connection c = (Connection) DriverManager.getConnection("jdbc:postgresql://pgserver.mah.se/rock_festival_g26", "m10p2724", "ogn810b8");
			System.out.println("Database Opened successfyllt");
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("select b.band_name, b.country, s.scene_name, s.start_time, s.finish_time, s.date\n" + 
					"from bands as b\n" + 
					"inner join schedule as s on b.band_name = s.band_name;");
			Schedule schedule;
			while (rs.next()) {
				schedule = new Schedule(rs.getString("band_name"), rs.getString("country"), rs.getString("scene_name"), rs.getString("start_time"), rs.getString("finish_time"), rs.getString("date"));
				scheduleList.add(schedule);
			}
			rs.close();
			stmt.close();
			c.close();
			}catch (Exception e1) {
				System.out.println(e1);
			}
			System.out.println("Operation successfully");	
			return scheduleList;
	}
	
	public void showSchedule() {
		ArrayList<Schedule> sList = scheduleList();
		DefaultTableModel model = (DefaultTableModel)scheduleTable.getModel(); 
		model.setColumnCount(6);
		Object[] row = new Object[6];
		for(int i=0; i<sList.size(); i++) {
			row[0] = sList.get(i).getBand();
			row[1] = sList.get(i).getCountry(); 
			row[2] = sList.get(i).getScene(); 
			row[3] = sList.get(i).getStart(); 
			row[4] = sList.get(i).getFinish(); 
			row[5] = sList.get(i).getDate(); 
			model.addRow(row);
		}
	}

	/**
	 * Create the frame.
	 */
	public void initComponents() {
		setTitle("Mörtfors Rock Festival");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 1000);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scheduleTable = new JTable();
		scheduleTable.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		scheduleTable.setToolTipText("gsdgsegsegse");
		scheduleTable.setBackground(Color.WHITE);
		scheduleTable.setBounds(400, 180, 768, 766);
		contentPane.add(scheduleTable);
		
		lblSchedule.setForeground(new Color(178, 34, 34));
		lblSchedule.setFont(new Font("Helvetica Neue", Font.BOLD, 22));
		lblSchedule.setBackground(Color.WHITE);
		lblSchedule.setBounds(750, 145, 100, 16);
		contentPane.add(lblSchedule);
		
		lblBands.setForeground(new Color(178, 34, 34));
		lblBands.setFont(new Font("Helvetica Neue", Font.BOLD, 22));
		lblBands.setBackground(Color.WHITE);
		lblBands.setBounds(165, 145, 70, 16);
		contentPane.add(lblBands);
		
		lblMember.setForeground(new Color(178, 34, 34));
		lblMember.setFont(new Font("Helvetica Neue", Font.BOLD, 22));
		lblMember.setBackground(Color.WHITE);
		lblMember.setBounds(155, 570, 90, 16);
		contentPane.add(lblMember);
		
		lblTitel.setForeground(new Color(178, 34, 34));
		lblTitel.setFont(new Font("Helvetica Neue", Font.BOLD, 42));
		lblTitel.setText("Mörtfors Rock Festival");
		lblTitel.setBounds(370, 40, 460, 72);
		contentPane.add(lblTitel);
		
		pnlBand.setBackground(Color.WHITE);
		pnlBand.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		pnlBand.setBounds(32, 180, 336, 358);
		contentPane.add(pnlBand);
		pnlBand.setLayout(null);
		
		txtBandName = new JTextField();
		txtBandName.setToolTipText("");
		txtBandName.setForeground(Color.BLACK);
		txtBandName.setBounds(32, 50, 188, 45);
		pnlBand.add(txtBandName);
		txtBandName.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		txtBandName.setColumns(10);
		
		lblBName.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
		lblBName.setForeground(new Color(178, 34, 34));
		lblBName.setBounds(35, 115, 80, 16);
		pnlBand.add(lblBName);
		
		lblBCountry.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
		lblBCountry.setForeground(new Color(178, 34, 34));
		lblBCountry.setBounds(35, 155, 61, 16);
		pnlBand.add(lblBCountry);
		
		lblBMembers.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
		lblBMembers.setForeground(new Color(178, 34, 34));
		lblBMembers.setBounds(35, 195, 65, 16);
		pnlBand.add(lblBMembers);
		
		lblEnterBandName.setFont(new Font("Helvetica Neue", Font.ITALIC, 12));
		lblEnterBandName.setForeground(Color.LIGHT_GRAY);
		lblEnterBandName.setBounds(42, 32, 110, 16);
		pnlBand.add(lblEnterBandName);
		
		lblBandName.setBounds(127, 115, 175, 18);
		pnlBand.add(lblBandName);
		
		lblBandCountry.setBounds(108, 155, 195, 16);
		pnlBand.add(lblBandCountry);
		
		btnBandSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taBandMembers.setText("");

				String members;
				try {
					Class.forName("org.postgresql.Driver");
					Connection c = (Connection) DriverManager.getConnection("jdbc:postgresql://pgserver.mah.se/rock_festival_g26", "m10p2724", "ogn810b8");
					System.out.println("Database Opened successfyllt");
					
					Statement stmt = c.createStatement();
					ResultSet rs = stmt.executeQuery("select b.band_name, b.country, m.member_name "
							+ "from bands as b "
							+ "inner join band_member as bm on b.band_name = bm.band_name "
							+ "inner join member as m on bm.member_id = m.member_id "
							+ "where b.band_name = '"+txtBandName.getText()+"'");
					
					while (rs.next()) {
						String bandName = rs.getString("band_name");
						String  country= rs.getString("country");
						members = rs.getString("member_name");
						
						lblBandName.setText(bandName);
						lblBandCountry.setText(country);
						taBandMembers.append(members +"\n" );
					}
					
					rs.close();
					stmt.close();
					c.close();
					}catch (Exception e1) {
						System.out.println(e1);
					}
					System.out.println("Operation successfully");
			}
		});
		btnBandSearch.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
		btnBandSearch.setBounds(232, 50, 72, 45);
		pnlBand.add(btnBandSearch);
		
		taBandMembers = new JTextArea(5,20);
		taBandMembers.setTabSize(100);
		taBandMembers.setLineWrap(true);
		taBandMembers.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		taBandMembers.setEditable(false);
		taBandMembers.setBounds(35, 226, 266, 103);
		pnlBand.add(taBandMembers);

		
		pnlMember.setBackground(Color.WHITE);
		pnlMember.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		pnlMember.setLayout(null);
		pnlMember.setBounds(32, 606, 336, 340);
		contentPane.add(pnlMember);
		
		txtMemberName = new JTextField();
		txtMemberName.setForeground(Color.BLACK);
		txtMemberName.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		txtMemberName.setColumns(10);
		txtMemberName.setBounds(34, 50, 188, 45);
		pnlMember.add(txtMemberName);
		
		lblEnterMemberName.setForeground(Color.LIGHT_GRAY);
		lblEnterMemberName.setFont(new Font("Helvetica Neue", Font.ITALIC, 12));
		lblEnterMemberName.setBounds(42, 32, 120, 16);
		pnlMember.add(lblEnterMemberName);
		
		lblMName.setForeground(new Color(178, 34, 34));
		lblMName.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
		lblMName.setBounds(35, 115, 95, 16);
		pnlMember.add(lblMName);
		
		lblMInfo.setForeground(new Color(178, 34, 34));
		lblMInfo.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
		lblMInfo.setBounds(35, 155, 65, 16);
		pnlMember.add(lblMInfo);
		
		lblMemberName.setBounds(142, 114, 162, 18);
		pnlMember.add(lblMemberName);
		btnMemberSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("org.postgresql.Driver");
					Connection c = (Connection) DriverManager.getConnection("jdbc:postgresql://pgserver.mah.se/rock_festival_g26", "m10p2724", "ogn810b8");
					System.out.println("Database Opened successfyllt");
					
					Statement stmt = c.createStatement();
					ResultSet rs = stmt.executeQuery("select * from member where member_name = '"+txtMemberName.getText()+"'");
			
					while (rs.next()) {						
						String memberName = rs.getString("member_name");
						String  info= rs.getString("info");
						
						lblMemberName.setText(memberName);
						taMemberInfo.setText(info);						
					}
					rs.close();
					stmt.close();
					c.close();
					}catch (Exception e1) {
						System.out.println(e1);
					}
					System.out.println("Operation successfully");
			}
		});
		
		btnMemberSearch.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
		btnMemberSearch.setBounds(232, 50, 72, 45);
		pnlMember.add(btnMemberSearch);
		taMemberInfo.setLineWrap(true);
		taMemberInfo.setEditable(false);
		taMemberInfo.setBounds(35, 187, 266, 121);
		pnlMember.add(taMemberInfo);
	}
}
