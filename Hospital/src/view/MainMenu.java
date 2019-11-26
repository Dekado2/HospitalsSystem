package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Logic;
import model.User;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JOptionPane;

import javax.swing.JScrollPane;
import javax.swing.JList;

public class MainMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;
	private Panel_add_Doctor addD;
	private Panel_add_Patient addP;
	private Panel_add_Room addR;
	private Panel_add_Vacations addVacations;
	private Panel_View_Doctor viewD;
	private Panel_View_Patient viewP;
	private Panel_View_Room viewR;
	private Panel_View_Hosp viewHos;
	private Panel_View_Vacations viewVacations;
	private Panel_update_PatientDetails updatePDetails;
	private Panel_addHospitalization addHos;
	private Panel_Statistics stat;
	private Panel_add_User addUser;
	private Panel_View_User viewUser;
    private User user;
    private Query_ShowDoctorsWorkingInHaifa docworkinInHaifa;
	private Query_ShowPatientsWithASeverityLevelOf10ORWereHospitalizedMoreThan3Times patsWithSLvl10OHosp3Times;
	private Query_ShowHospitalsStatusRegardingDoctorsInfectionInEmergencyCareInThePastMonth hosStatusDocInfection;
	private Query_ShowDoctorsWhoAreInvitedToTheNationalSurgeryConvention docInSurgeryCermony;
	private Query_ShowDoctorDepartmentHospitalizedPatientsLastTestResults patTestResults;
	private Query_ShowBusyDoctors busyDoc;
	private Query_ShowEveryMonthsHospitalForThePastYearWithMostProfits hospMostProfits;
	private Query_ShowEveryHospitalDetails allHospDetails;
	private Query_ShowPeopleWithRareBloodType rareBloodType;
	private Query_ShowLoadLevelOfAllDepartments loadLevel;
	private Query_ShowHypochondriacs hypo;
	private boolean DocisClicked=false;
	private boolean patIsClicked=false;
	private boolean roomIsClicked=false;
	private boolean HosIsClicked=false;
	private boolean vacIsClicked=false;
	private boolean qIsClicked=false;
	private boolean userIsClicked=false;
	JButton btnAdd;
	JButton btnView;

	/**
	 * Create the frame.
	 */
	public MainMenu(String username, String password) {
		setTitle("S.A Hospitals Systems");
		user = Logic.getInstance().getUserDetails(username, password);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1058, 660);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		
		panel.setBounds(0, 121, 262, 526);
		contentPane.add(panel);
		panel.setLayout(null);
		JPanel DocMng = new JPanel();
		DocMng.setBackground(new Color(240, 248, 255));

		DocMng.setBounds(0, 0, 262, 47);
		panel.add(DocMng);
		DocMng.setLayout(null);
		
		JLabel lblDfddf = new JLabel("");
		lblDfddf.setIcon(new ImageIcon(MainMenu.class.getResource("/view/icons/first-aid-kit.png")));
		lblDfddf.setBounds(10, 0, 30, 47);
		DocMng.add(lblDfddf);
		
		JLabel lblHospitalManagement = new JLabel("Doctor Management");
		lblHospitalManagement.setForeground(new Color(102, 102, 102));
		lblHospitalManagement.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHospitalManagement.setBounds(51, 0, 201, 47);
		DocMng.add(lblHospitalManagement);
		
		JPanel patientMng = new JPanel();

		patientMng.setLayout(null);
		patientMng.setBackground(new Color(240, 248, 255));
		patientMng.setBounds(0, 46, 262, 47);
		panel.add(patientMng);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MainMenu.class.getResource("/view/icons/user11.png")));
		label.setBounds(10, 0, 30, 47);
		patientMng.add(label);
		
		JLabel btn_person = new JLabel("Patient Management");
		btn_person.setForeground(new Color(102, 102, 102));
		btn_person.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_person.setBounds(51, 0, 201, 47);
		patientMng.add(btn_person);
		
		JPanel roomMng = new JPanel();

		roomMng.setLayout(null);
		roomMng.setBackground(new Color(240, 248, 255));
		roomMng.setBounds(0, 93, 262, 47);
		panel.add(roomMng);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(MainMenu.class.getResource("/view/icons/bed.png")));
		label_3.setBounds(10, 0, 30, 47);
		roomMng.add(label_3);
		
		JLabel lblRoomManagement = new JLabel("Room Management");
		lblRoomManagement.setForeground(new Color(102, 102, 102));
		lblRoomManagement.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRoomManagement.setBounds(51, 0, 201, 47);
		roomMng.add(lblRoomManagement);
		
		JPanel btn_HosMng = new JPanel();
	
		btn_HosMng.setLayout(null);
		btn_HosMng.setBackground(new Color(240, 248, 255));
		btn_HosMng.setBounds(0, 140, 262, 47);
		panel.add(btn_HosMng);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(MainMenu.class.getResource("/view/icons/ambulance (1).png")));
		label_1.setBounds(10, 0, 30, 47);
		btn_HosMng.add(label_1);
		
		JLabel lblHospitalizedPatientsManagement = new JLabel("Hospitalization Management");
		lblHospitalizedPatientsManagement.setForeground(new Color(102, 102, 102));
		lblHospitalizedPatientsManagement.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHospitalizedPatientsManagement.setBounds(51, 0, 211, 47);
		btn_HosMng.add(lblHospitalizedPatientsManagement);
		
		JPanel vacationBtn = new JPanel();
		vacationBtn.setLayout(null);
		vacationBtn.setBackground(new Color(240, 248, 255));
		vacationBtn.setBounds(0, 188, 262, 47);
		panel.add(vacationBtn);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(MainMenu.class.getResource("/view/icons/calendar-with-a-clock-time-tools.png")));
		label_5.setBounds(10, 0, 30, 47);
		vacationBtn.add(label_5);
		
		JLabel lblDoctorVacations = new JLabel("Vacations");
		lblDoctorVacations.setForeground(new Color(102, 102, 102));
		lblDoctorVacations.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDoctorVacations.setBounds(51, 0, 211, 47);
		vacationBtn.add(lblDoctorVacations);
		
		JPanel queriesBtn = new JPanel();
		queriesBtn.setLayout(null);
		queriesBtn.setBackground(new Color(240, 248, 255));
		queriesBtn.setBounds(0, 282, 262, 47);
		panel.add(queriesBtn);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(MainMenu.class.getResource("/view/icons/question-mark-on-a-circular-black-background.png")));
		label_6.setBounds(10, 0, 30, 47);
		queriesBtn.add(label_6);
		
		JLabel lblQueries = new JLabel("Queries");
		lblQueries.setForeground(new Color(102, 102, 102));
		lblQueries.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQueries.setBounds(51, 0, 211, 47);
		queriesBtn.add(lblQueries);
		
		JPanel dashBtn = new JPanel();
		dashBtn.setLayout(null);
		dashBtn.setBackground(new Color(240, 248, 255));
		dashBtn.setBounds(0, 235, 262, 47);
		panel.add(dashBtn);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(MainMenu.class.getResource("/view/icons/computer.png")));
		label_7.setBounds(10, 0, 30, 47);
		dashBtn.add(label_7);
		
		JLabel lblDashboard = new JLabel("Dashboard");
		lblDashboard.setForeground(new Color(102, 102, 102));
		lblDashboard.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDashboard.setBounds(51, 0, 211, 47);
		dashBtn.add(lblDashboard);
		
		JScrollPane qList = new JScrollPane();
		qList.setBounds(0, 330, 262, 88);
		panel.add(qList);
		
		JList<String> list = new JList<String>();
		list.setFont(new Font("Tahoma", Font.PLAIN, 11));
		qList.setViewportView(list);
		qList.setVisible(false);
		qList.setBackground(Color.WHITE);
		list.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Show doctors working in Haifa",
            		"Show patients with a severity level of 10 OR were hospitalized more than 3 times in the past year",
            		"Show doctors who are invited to the National Surgery Convention",
            		"Show hospitals' status regarding doctors' infection in Emergency Care in the past month",
            		"Show busy doctors",
            		"Show doctor's department's hospitalized patients' last test results in doctor's last vacation day",
            		"Show every month's hospital for the past year with most profits from hospitalizations",
            		"Show every hospital's details (departments, manager, number of doctors)",
            		"Show people with rare blood type",
            		"Show load level of all departments",
            		"Show hypochondriacs "};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
		
		JPanel UserMng = new JPanel();
		UserMng.setLayout(null);
		UserMng.setBackground(new Color(240, 248, 255));
		if (user.getType().equals("admin")){
		UserMng.setBounds(0, 282, 262, 47);
		queriesBtn.setBounds(0, 330, 262, 47);
		qList.setBounds(0, 378, 262, 96);
		panel.add(UserMng);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(MainMenu.class.getResource("/view/icons/usermng.png")));
		label_8.setBounds(10, 0, 30, 47);
		UserMng.add(label_8);
		
		JLabel lblUserManagement = new JLabel("User Management");
		lblUserManagement.setForeground(new Color(102, 102, 102));
		lblUserManagement.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUserManagement.setBounds(51, 0, 201, 47);
		UserMng.add(lblUserManagement);
		}
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 102, 204));
		panel_1.setBounds(0, 0, 1052, 118);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(59, 28, 113, 102);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(22, 21, 64, 73);
		lblNewLabel.setIcon(new ImageIcon(MainMenu.class.getResource("/view/icons/man-user.png")));
		panel_2.add(lblNewLabel);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 102, 204));
		panel_4.setBounds(849, 72, 177, 46);
		panel_1.add(panel_4);
		panel_4.setLayout(null);

		JPanel logOut_btn = new JPanel();
	
		logOut_btn.setBackground(new Color(0, 102, 204));
		logOut_btn.setLayout(null);
		logOut_btn.setBounds(140, 0, 37, 45);
		panel_4.add(logOut_btn);
		
		JLabel label_4 = new JLabel("");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Object[] options = {"Yes","No"};
				int n = JOptionPane.showOptionDialog(null, "Are you sure you want to log out?","Log Out",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[1]);
				if (n==0)
				{
					LoginScreen login = new LoginScreen();
					login.setVisible(true);
					dispose();
				}
			}
		});
		label_4.setIcon(new ImageIcon(MainMenu.class.getResource("/view/icons/logout.png")));
		label_4.setBounds(0, 0, 47, 41);
		logOut_btn.add(label_4);
		JLabel lblHelloUser = new JLabel();
		if (user.getDisplayFirstName()!=null && user.getDisplayLastName()!=null)
		    lblHelloUser = new JLabel("Hello, " + user.getDisplayFirstName() + " " + user.getDisplayLastName() + "!");
		else if (user.getDisplayFirstName()==null && user.getDisplayLastName()!=null)
			lblHelloUser = new JLabel("Hello, " + user.getDisplayLastName() + "!");
		else if (user.getDisplayFirstName()!=null && user.getDisplayLastName()==null)
			lblHelloUser = new JLabel("Hello, " + user.getDisplayFirstName() + "!");
		lblHelloUser.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblHelloUser.setForeground(Color.WHITE);
		lblHelloUser.setBounds(209, 57, 312, 33);
		panel_1.add(lblHelloUser);
		
		
		
	
		if (user.getType().equals("doctor"))
		{
			patientMng.setVisible(false);
			roomMng.setVisible(false);
			queriesBtn.setVisible(false);
			btn_HosMng.setBounds(0, 46, 262, 47);
			vacationBtn.setBounds(0, 93, 262, 47);
			dashBtn.setBounds(0, 140, 262, 47);
		}
		else if (user.getType().equals("secretary"))
		{
			roomMng.setVisible(false);
			dashBtn.setVisible(false);
			btn_HosMng.setBounds(0, 93, 262, 47);
			vacationBtn.setBounds(0, 140, 262, 47);
			queriesBtn.setBounds(0, 188, 262, 47);
			qList.setBounds(0, 235, 262, 90);
		}
		JPanel open = new JPanel();
		open.setBackground(new Color(255, 255, 255));
		open.setBounds(261, 116, 793, 41);
		contentPane.add(open);
		open.setLayout(null);
		open.setVisible(false);
		open.setEnabled(false);
btnAdd = new JButton("Add");
		
		btnAdd.setBackground(new Color(255, 255, 255));
	
		btnAdd.setBounds(0, 0, 396, 41);
		open.add(btnAdd);
		
		btnView = new JButton("View");
	
		btnView.setBackground(new Color(255, 255, 255));
		btnView.setBounds(395, 0, 390, 41);
		open.add(btnView);
		
		addD=new Panel_add_Doctor(this);
		contentPane.add(addD);
		addD.setBounds(261, 156, 765, 414);
		addD.setVisible(false);
		addD.setEnabled(false);
		addD.setLayout(null);
		addP=new Panel_add_Patient(this);
		contentPane.add(addP);
		addP.setBounds(261, 156, 765, 414);
		addP.setVisible(false);
		addP.setEnabled(false);
		addP.setLayout(null);
		addR=new Panel_add_Room(this);
		contentPane.add(addR);
		addR.setBounds(261, 156, 765, 414);
		addR.setVisible(false);
		addR.setEnabled(false);
		addR.setLayout(null);
		viewP=new Panel_View_Patient(this);
		contentPane.add(viewP);
		viewP.setBounds(261, 156, 765, 414);
		viewP.setVisible(false);
		viewP.setEnabled(false);
		viewP.setLayout(null);
		viewD=new Panel_View_Doctor(this);
		contentPane.add(viewD);
		viewD.setBounds(261, 156, 765, 414);
		viewD.setVisible(false);
		viewD.setEnabled(false);
		viewD.setLayout(null);
		viewR=new Panel_View_Room(this);
		contentPane.add(viewR);
		viewR.setBounds(261, 156, 765, 414);
		viewR.setVisible(false);
		viewR.setEnabled(false);
		viewR.setLayout(null);
		addHos=new Panel_addHospitalization(this);
		contentPane.add(addHos);
		addHos.setBounds(261, 156, 765, 414);
		addHos.setVisible(false);
		addHos.setEnabled(false);
		addHos.setLayout(null);
		viewHos=new Panel_View_Hosp(this);
		contentPane.add(viewHos);
		viewHos.setBounds(261, 156, 765, 414);
		viewHos.setVisible(false);
		viewHos.setEnabled(false);
		viewHos.setLayout(null);
		viewVacations=new Panel_View_Vacations(this);
		contentPane.add(viewVacations);
		viewVacations.setBounds(261, 156, 765, 414);
		viewVacations.setVisible(false);
		viewVacations.setEnabled(false);
		viewVacations.setLayout(null);
		addVacations=new Panel_add_Vacations(this);
		contentPane.add(addVacations);
		addVacations.setBounds(261, 156, 765, 414);
		addVacations.setVisible(false);
		addVacations.setEnabled(false);
		addVacations.setLayout(null);
		stat = new Panel_Statistics(this);
		contentPane.add(stat);
		stat.setBounds(255, 118, 1558, 1040);
		stat.setVisible(false);
		stat.setEnabled(false);
		stat.setLayout(null);
		docworkinInHaifa = new Query_ShowDoctorsWorkingInHaifa(this);
		contentPane.add(docworkinInHaifa);
		docworkinInHaifa.setBounds(261, 156, 765, 414);
		docworkinInHaifa.setVisible(false);
		docworkinInHaifa.setEnabled(false);
		docworkinInHaifa.setLayout(null);
		patsWithSLvl10OHosp3Times=new Query_ShowPatientsWithASeverityLevelOf10ORWereHospitalizedMoreThan3Times(this);
		contentPane.add(patsWithSLvl10OHosp3Times);
		patsWithSLvl10OHosp3Times.setBounds(261, 156, 765, 414);
		patsWithSLvl10OHosp3Times.setVisible(false);
		patsWithSLvl10OHosp3Times.setEnabled(false);
		patsWithSLvl10OHosp3Times.setLayout(null);
		docInSurgeryCermony= new Query_ShowDoctorsWhoAreInvitedToTheNationalSurgeryConvention(this);
		contentPane.add(docInSurgeryCermony);
		docInSurgeryCermony.setBounds(261, 156, 765, 414);
		docInSurgeryCermony.setVisible(false);
		docInSurgeryCermony.setEnabled(false);
		docInSurgeryCermony.setLayout(null);
		hosStatusDocInfection= new Query_ShowHospitalsStatusRegardingDoctorsInfectionInEmergencyCareInThePastMonth(this);
		contentPane.add(hosStatusDocInfection);
		hosStatusDocInfection.setBounds(261, 156, 765, 414);
		hosStatusDocInfection.setVisible(false);
		hosStatusDocInfection.setEnabled(false);
		hosStatusDocInfection.setLayout(null);
		busyDoc= new Query_ShowBusyDoctors(this);
		contentPane.add(busyDoc);
		busyDoc.setBounds(261, 156, 765, 414);
		busyDoc.setVisible(false);
		busyDoc.setEnabled(false);
		busyDoc.setLayout(null);
		patTestResults= new Query_ShowDoctorDepartmentHospitalizedPatientsLastTestResults(this);
		contentPane.add(patTestResults);
		patTestResults.setBounds(261, 156, 765, 414);
		patTestResults.setVisible(false);
		patTestResults.setEnabled(false);
		patTestResults.setLayout(null);
		hospMostProfits= new Query_ShowEveryMonthsHospitalForThePastYearWithMostProfits(this);
		contentPane.add(hospMostProfits);
		hospMostProfits.setBounds(261, 156, 765, 414);
		hospMostProfits.setVisible(false);
		hospMostProfits.setEnabled(false);
		hospMostProfits.setLayout(null);
		allHospDetails= new Query_ShowEveryHospitalDetails(this);
		contentPane.add(allHospDetails);
		allHospDetails.setBounds(261, 156, 765, 414);
		allHospDetails.setVisible(false);
		allHospDetails.setEnabled(false);
		allHospDetails.setLayout(null);
		rareBloodType= new Query_ShowPeopleWithRareBloodType(this);		
		contentPane.add(rareBloodType);
		rareBloodType.setBounds(261, 156, 765, 414);
		rareBloodType.setVisible(false);
		rareBloodType.setEnabled(false);
		rareBloodType.setLayout(null);
		loadLevel= new Query_ShowLoadLevelOfAllDepartments(this);
		contentPane.add(loadLevel);
		loadLevel.setBounds(261, 156, 765, 414);
		loadLevel.setVisible(false);
		loadLevel.setEnabled(false);
		loadLevel.setLayout(null);
		hypo= new Query_ShowHypochondriacs(this);
		contentPane.add(hypo);
		hypo.setBounds(261, 156, 765, 414);
		hypo.setVisible(false);
		hypo.setEnabled(false);
		hypo.setLayout(null);
		addUser=new Panel_add_User(this);
		contentPane.add(addUser);
		addUser.setBounds(261, 156, 765, 414);
		addUser.setVisible(false);
		addUser.setEnabled(false);
		addUser.setLayout(null);
		viewUser=new Panel_View_User(this);
		contentPane.add(viewUser);
		viewUser.setBounds(261, 156, 765, 414);
		viewUser.setVisible(false);
		viewUser.setEnabled(false);
		viewUser.setLayout(null);
	
		DocMng.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				DocMng.setBackground(new Color(255, 255, 255));
			}
		});
		DocMng.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				open.setVisible(true);
				open.setEnabled(true);
				addD.setVisible(false);
				addP.setVisible(false);
				addR.setVisible(false);
				addHos.setEnabled(false);
				addHos.setVisible(false);
				stat.setVisible(false);
				stat.setEnabled(false);
				addVacations.setVisible(false);
				addVacations.setEnabled(false);
				viewR.setEnabled(false);
				viewR.setVisible(false);
				viewP.setEnabled(false);
				viewP.setVisible(false);
				viewD.setVisible(false);
				viewHos.setVisible(false);
				viewHos.setEnabled(false);
				viewVacations.setVisible(false);
				viewVacations.setEnabled(false);
				qList.setVisible(false);
				DocMng.setBackground(new Color(255,255,255));
				patientMng.setBackground(new Color(240, 248, 255));
				roomMng.setBackground(new Color(240, 248, 255));
				btn_HosMng.setBackground(new Color(240, 248, 255));
				queriesBtn.setBackground(new Color(240, 248, 255));
				vacationBtn.setBackground(new Color(240, 248, 255));
				dashBtn.setBackground(new Color(240, 248, 255));
				UserMng.setBackground(new Color(240, 248, 255));
				if(viewD.getUpdateDoctor()!=null)
					viewD.getUpdateDoctor().setVisible(false);
				if(viewHos.getUpdateHosp()!=null)
					viewHos.getUpdateHosp().setVisible(false);
				if(viewP.getUpdatePatient()!=null)
					viewP.getUpdatePatient().setVisible(false);
				if(viewR.getUpdateRoom()!=null)
					viewR.getUpdateRoom().setVisible(false);
				DocisClicked=true;
				patIsClicked=false;
				roomIsClicked=false;
				HosIsClicked=false;
				vacIsClicked=false;
				qIsClicked=false;
				userIsClicked=false;
				MainMenu.this.setBounds(100, 100, 1058, 660);
				panel_1.setBounds(0, 0, 1052, 118);
				panel_4.setBounds(849, 72, 177, 46);
				panel.setBounds(0, 121, 262, 526);
				patsWithSLvl10OHosp3Times.setVisible(false);
				docworkinInHaifa.setVisible(false);
				docInSurgeryCermony.setVisible(false);
				hosStatusDocInfection.setVisible(false);
				busyDoc.setVisible(false);
				patTestResults.setVisible(false);
				hospMostProfits.setVisible(false);
				allHospDetails.setVisible(false);
				rareBloodType.setVisible(false);
				loadLevel.setVisible(false);
				hypo.setVisible(false);
				addUser.setVisible(false);
				addUser.setEnabled(false);
				viewUser.setVisible(false);
				viewUser.setEnabled(false);
				setLocationRelativeTo(null);

			}
			@Override
			public void mouseReleased(MouseEvent e) {
				DocMng.setBackground(new Color(240, 248, 255));
				open.setVisible(false);
				open.setEnabled(false);
				DocisClicked=false;
			}
		});
		patientMng.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				open.setVisible(true);
				open.setEnabled(true);
				addD.setVisible(false);
				addP.setVisible(false);
				addR.setVisible(false);
				addHos.setVisible(false);
				stat.setVisible(false);
				stat.setEnabled(false);
				if(addHos.getSubAdd()!=null)
					addHos.getSubAdd().setVisible(false);
				addVacations.setVisible(false);
				addVacations.setEnabled(false);
				viewD.setEnabled(false);
				viewD.setVisible(false);
				viewR.setEnabled(false);
				viewR.setVisible(false);
				viewHos.setVisible(false);
				viewHos.setEnabled(false);
				viewVacations.setVisible(false);
				viewVacations.setEnabled(false);
				qList.setVisible(false);
				if(updatePDetails!=null) {
					updatePDetails.setEnabled(false);
					updatePDetails.setVisible(false);
				}
				if(viewD.getUpdateDoctor()!=null)
					viewD.getUpdateDoctor().setVisible(false);
				if(viewHos.getUpdateHosp()!=null)
					viewHos.getUpdateHosp().setVisible(false);
				if(viewP.getUpdatePatient()!=null)
					viewP.getUpdatePatient().setVisible(false);
				if(viewR.getUpdateRoom()!=null)
					viewR.getUpdateRoom().setVisible(false);
				patientMng.setBackground(Color.WHITE);
				roomMng.setBackground(new Color(240, 248, 255));
				DocMng.setBackground(new Color(240, 248, 255));
				btn_HosMng.setBackground(new Color(240, 248, 255));
				queriesBtn.setBackground(new Color(240, 248, 255));
				vacationBtn.setBackground(new Color(240, 248, 255));
				dashBtn.setBackground(new Color(240, 248, 255));
				UserMng.setBackground(new Color(240, 248, 255));
				patIsClicked=true;
				DocisClicked=false;
				roomIsClicked=false;
				HosIsClicked=false;
				vacIsClicked=false;
				qIsClicked=false;
				userIsClicked=false;
				MainMenu.this.setBounds(100, 100, 1058, 660);
				panel_1.setBounds(0, 0, 1052, 118);
				panel_4.setBounds(849, 72, 177, 46);
				panel.setBounds(0, 121, 262, 526);
				patsWithSLvl10OHosp3Times.setVisible(false);
				docworkinInHaifa.setVisible(false);
				docInSurgeryCermony.setVisible(false);
				hosStatusDocInfection.setVisible(false);
				busyDoc.setVisible(false);
				patTestResults.setVisible(false);
				hospMostProfits.setVisible(false);
				allHospDetails.setVisible(false);
				rareBloodType.setVisible(false);
				loadLevel.setVisible(false);
				hypo.setVisible(false);
				addUser.setVisible(false);
				addUser.setEnabled(false);
				viewUser.setVisible(false);
				viewUser.setEnabled(false);
				setLocationRelativeTo(null);

			}
		});
		roomMng.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				open.setVisible(true);
				open.setEnabled(true);
				addD.setVisible(false);
				addP.setVisible(false);
				addR.setVisible(false);
				stat.setVisible(false);
				stat.setEnabled(false);
				addHos.setVisible(false);
				if(addHos.getSubAdd()!=null)
					addHos.getSubAdd().setVisible(false);
				addVacations.setVisible(false);
				addVacations.setEnabled(false);
				viewD.setEnabled(false);
				viewD.setVisible(false);
				viewP.setEnabled(false);
				viewP.setVisible(false);
				viewHos.setVisible(false);
				viewHos.setEnabled(false);
				viewVacations.setVisible(false);
				viewVacations.setEnabled(false);
				if(viewD.getUpdateDoctor()!=null)
					viewD.getUpdateDoctor().setVisible(false);
				if(viewHos.getUpdateHosp()!=null)
					viewHos.getUpdateHosp().setVisible(false);
				if(viewP.getUpdatePatient()!=null)
					viewP.getUpdatePatient().setVisible(false);
				if(viewR.getUpdateRoom()!=null)
					viewR.getUpdateRoom().setVisible(false);
				qList.setVisible(false);
				patientMng.setBackground(new Color(240, 248, 255));
				DocMng.setBackground(new Color(240, 248, 255));
				btn_HosMng.setBackground(new Color(240, 248, 255));
				queriesBtn.setBackground(new Color(240, 248, 255));
				vacationBtn.setBackground(new Color(240, 248, 255));
				dashBtn.setBackground(new Color(240, 248, 255));
				UserMng.setBackground(new Color(240, 248, 255));
				roomMng.setBackground(Color.WHITE);
				patIsClicked=false;
				DocisClicked=false;
				HosIsClicked=false;
				roomIsClicked=true;
				vacIsClicked=false;
				qIsClicked=false;
				userIsClicked=false;
				MainMenu.this.setBounds(100, 100, 1058, 660);
				panel_1.setBounds(0, 0, 1052, 118);
				panel_4.setBounds(849, 72, 177, 46);
				panel.setBounds(0, 121, 262, 526);
				patsWithSLvl10OHosp3Times.setVisible(false);
				docworkinInHaifa.setVisible(false);
				docInSurgeryCermony.setVisible(false);
				hosStatusDocInfection.setVisible(false);
				busyDoc.setVisible(false);
				patTestResults.setVisible(false);
				hospMostProfits.setVisible(false);
				allHospDetails.setVisible(false);
				rareBloodType.setVisible(false);
				loadLevel.setVisible(false);
				hypo.setVisible(false);
				addUser.setVisible(false);
				addUser.setEnabled(false);
				viewUser.setVisible(false);
				viewUser.setEnabled(false);
				setLocationRelativeTo(null);
			}
		});
		btn_HosMng.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				open.setVisible(true);
				open.setEnabled(true);
				addD.setVisible(false);
				addP.setVisible(false);
				addR.setVisible(false);
				stat.setVisible(false);
				stat.setEnabled(false);
				addHos.setVisible(false);
				if(addHos.getSubAdd()!=null)
					addHos.getSubAdd().setVisible(false);
				addVacations.setVisible(false);
				addVacations.setEnabled(false);
				viewD.setEnabled(false);
				viewD.setVisible(false);
				viewP.setEnabled(false);
				viewP.setVisible(false);
				viewR.setEnabled(false);
				viewR.setVisible(false);
				viewHos.setVisible(false);
				viewHos.setEnabled(false);
				viewVacations.setVisible(false);
				viewVacations.setEnabled(false);
				if(viewD.getUpdateDoctor()!=null)
					viewD.getUpdateDoctor().setVisible(false);
				if(viewHos.getUpdateHosp()!=null)
					viewHos.getUpdateHosp().setVisible(false);
				if(viewP.getUpdatePatient()!=null)
					viewP.getUpdatePatient().setVisible(false);
				if(viewR.getUpdateRoom()!=null)
					viewR.getUpdateRoom().setVisible(false);
				qList.setVisible(false);
				patientMng.setBackground(new Color(240, 248, 255));
				DocMng.setBackground(new Color(240, 248, 255));
				roomMng.setBackground(new Color(240, 248, 255));
				vacationBtn.setBackground(new Color(240, 248, 255));
				queriesBtn.setBackground(new Color(240, 248, 255));
				dashBtn.setBackground(new Color(240, 248, 255));
				UserMng.setBackground(new Color(240, 248, 255));
				btn_HosMng.setBackground(Color.white);
				patIsClicked=false;
				DocisClicked=false;
				roomIsClicked=false;
				HosIsClicked=true;
				vacIsClicked=false;
				qIsClicked=false;
				userIsClicked=false;
				MainMenu.this.setBounds(100, 100, 1058, 660);
				panel_1.setBounds(0, 0, 1052, 118);
				panel_4.setBounds(849, 72, 177, 46);
				panel.setBounds(0, 121, 262, 526);
				patsWithSLvl10OHosp3Times.setVisible(false);
				docworkinInHaifa.setVisible(false);
				docInSurgeryCermony.setVisible(false);
				hosStatusDocInfection.setVisible(false);
				busyDoc.setVisible(false);
				patTestResults.setVisible(false);
				hospMostProfits.setVisible(false);
				allHospDetails.setVisible(false);
				rareBloodType.setVisible(false);
				loadLevel.setVisible(false);
				hypo.setVisible(false);
				addUser.setVisible(false);
				addUser.setEnabled(false);
				viewUser.setVisible(false);
				viewUser.setEnabled(false);
				setLocationRelativeTo(null);
			}
		});
		vacationBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				open.setVisible(true);
				open.setEnabled(true);
				addD.setVisible(false);
				addP.setVisible(false);
				stat.setVisible(false);
				stat.setEnabled(false);
				addR.setVisible(false);
				addHos.setVisible(false);
				if(addHos.getSubAdd()!=null)
					addHos.getSubAdd().setVisible(false);
				addVacations.setVisible(false);
				addVacations.setEnabled(false);
				viewD.setEnabled(false);
				viewD.setVisible(false);
				viewP.setEnabled(false);
				viewP.setVisible(false);
				viewR.setEnabled(false);
				viewR.setVisible(false);
				viewHos.setVisible(false);
				viewHos.setEnabled(false);
				viewVacations.setVisible(false);
				viewVacations.setEnabled(false);
				if(viewD.getUpdateDoctor()!=null)
					viewD.getUpdateDoctor().setVisible(false);
				if(viewHos.getUpdateHosp()!=null)
					viewHos.getUpdateHosp().setVisible(false);
				if(viewP.getUpdatePatient()!=null)
					viewP.getUpdatePatient().setVisible(false);
				if(viewR.getUpdateRoom()!=null)
					viewR.getUpdateRoom().setVisible(false);
				qList.setVisible(false);
				patientMng.setBackground(new Color(240, 248, 255));
				DocMng.setBackground(new Color(240, 248, 255));
				roomMng.setBackground(new Color(240, 248, 255));
				btn_HosMng.setBackground(new Color(240, 248, 255));
				queriesBtn.setBackground(new Color(240, 248, 255));
				dashBtn.setBackground(new Color(240, 248, 255));
				UserMng.setBackground(new Color(240, 248, 255));
				vacationBtn.setBackground(Color.white);
				patIsClicked=false;
				DocisClicked=false;
				roomIsClicked=false;
				HosIsClicked=false;
				vacIsClicked=true;
				qIsClicked=false;
				userIsClicked=false;
				MainMenu.this.setBounds(100, 100, 1058, 660);
				panel_1.setBounds(0, 0, 1052, 118);
				panel_4.setBounds(849, 72, 177, 46);
				panel.setBounds(0, 121, 262, 526);
				patsWithSLvl10OHosp3Times.setVisible(false);
				docworkinInHaifa.setVisible(false);
				docInSurgeryCermony.setVisible(false);
				hosStatusDocInfection.setVisible(false);
				busyDoc.setVisible(false);
				patTestResults.setVisible(false);
				hospMostProfits.setVisible(false);
				allHospDetails.setVisible(false);
				rareBloodType.setVisible(false);
				loadLevel.setVisible(false);
				hypo.setVisible(false);
				addUser.setVisible(false);
				addUser.setEnabled(false);
				viewUser.setVisible(false);
				viewUser.setEnabled(false);
				setLocationRelativeTo(null);

			}
		});
		queriesBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				open.setVisible(false);
				open.setEnabled(false);
				addD.setVisible(false);
				addP.setVisible(false);
				addR.setVisible(false);
				stat.setVisible(false);
				stat.setEnabled(false);
				addHos.setVisible(false);
				if(addHos.getSubAdd()!=null)
					addHos.getSubAdd().setVisible(false);
				addVacations.setVisible(false);
				addVacations.setEnabled(false);
				viewD.setEnabled(false);
				viewD.setVisible(false);
				viewP.setEnabled(false);
				viewP.setVisible(false);
				viewR.setEnabled(false);
				viewR.setVisible(false);
				viewHos.setVisible(false);
				viewHos.setEnabled(false);
				viewVacations.setVisible(false);
				viewVacations.setEnabled(false);
				if(viewD.getUpdateDoctor()!=null)
					viewD.getUpdateDoctor().setVisible(false);
				if(viewHos.getUpdateHosp()!=null)
					viewHos.getUpdateHosp().setVisible(false);
				if(viewP.getUpdatePatient()!=null)
					viewP.getUpdatePatient().setVisible(false);
				if(viewR.getUpdateRoom()!=null)
					viewR.getUpdateRoom().setVisible(false);
				patientMng.setBackground(new Color(240, 248, 255));
				DocMng.setBackground(new Color(240, 248, 255));
				roomMng.setBackground(new Color(240, 248, 255));
				btn_HosMng.setBackground(new Color(240, 248, 255));
				vacationBtn.setBackground(new Color(240, 248, 255));
				dashBtn.setBackground(new Color(240, 248, 255));
				UserMng.setBackground(new Color(240, 248, 255));
				queriesBtn.setBackground(Color.white);
				patIsClicked=false;
				DocisClicked=false;
				roomIsClicked=false;
				HosIsClicked=false;
				vacIsClicked=false;
				userIsClicked=false;
				qList.setVisible(true);
				qList.setEnabled(true);
				MainMenu.this.setBounds(100, 100, 1058, 660);
				panel_1.setBounds(0, 0, 1052, 118);
				panel_4.setBounds(849, 72, 177, 46);
				panel.setBounds(0, 121, 262, 526);
				patsWithSLvl10OHosp3Times.setVisible(false);
				docworkinInHaifa.setVisible(false);
				docInSurgeryCermony.setVisible(false);
				hosStatusDocInfection.setVisible(false);
				busyDoc.setVisible(false);
				patTestResults.setVisible(false);
				hospMostProfits.setVisible(false);
				allHospDetails.setVisible(false);
				rareBloodType.setVisible(false);
				loadLevel.setVisible(false);
				hypo.setVisible(false);
				addUser.setVisible(false);
				addUser.setEnabled(false);
				viewUser.setVisible(false);
				viewUser.setEnabled(false);
				setLocationRelativeTo(null);

			}
		});
		
		dashBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				open.setVisible(false);
				open.setEnabled(false);
				addD.setVisible(false);
				addP.setVisible(false);
				addR.setVisible(false);
				addHos.setVisible(false);
				addVacations.setVisible(false);
				addVacations.setEnabled(false);
				viewD.setEnabled(false);
				viewD.setVisible(false);
				viewP.setEnabled(false);
				viewP.setVisible(false);
				viewR.setEnabled(false);
				viewR.setVisible(false);
				viewHos.setVisible(false);
				viewHos.setEnabled(false);
				viewVacations.setVisible(false);
				viewVacations.setEnabled(false);
				qList.setVisible(false);
				patientMng.setBackground(new Color(240, 248, 255));
				DocMng.setBackground(new Color(240, 248, 255));
				roomMng.setBackground(new Color(240, 248, 255));
				btn_HosMng.setBackground(new Color(240, 248, 255));
				vacationBtn.setBackground(new Color(240, 248, 255));
				queriesBtn.setBackground(new Color(240, 248, 255));
				UserMng.setBackground(new Color(240, 248, 255));
				dashBtn.setBackground(Color.white);
				patIsClicked=false;
				DocisClicked=false;
				roomIsClicked=false;
				HosIsClicked=false;
				vacIsClicked=false;
				qIsClicked=false;
				userIsClicked=false;
				MainMenu.this.setBounds(200, 0, 1558, 1040);
				panel_1.setBounds(0, 0, 1558, 118);
				panel_4.setBounds(1358, 72, 177, 46);
				panel.setBounds(0, 121, 262, 1026);
				stat = new Panel_Statistics(MainMenu.this);
				contentPane.add(stat);
				stat.setBounds(255, 118, 1558, 1040);
				stat.setVisible(true);
				stat.setEnabled(true);
				stat.setLayout(null);
				patsWithSLvl10OHosp3Times.setVisible(false);
				docworkinInHaifa.setVisible(false);
				docInSurgeryCermony.setVisible(false);
				hosStatusDocInfection.setVisible(false);
				busyDoc.setVisible(false);
				patTestResults.setVisible(false);
				hospMostProfits.setVisible(false);
				allHospDetails.setVisible(false);
				rareBloodType.setVisible(false);
				loadLevel.setVisible(false);
				hypo.setVisible(false);
				addUser.setVisible(false);
				addUser.setEnabled(false);
				viewUser.setVisible(false);
				viewUser.setEnabled(false);
				setLocationRelativeTo(null);

			}
			
			
		});
		
		UserMng.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				open.setVisible(true);
				open.setEnabled(true);
				addD.setVisible(false);
				addP.setVisible(false);
				addR.setVisible(false);
				stat.setVisible(false);
				stat.setEnabled(false);
				addHos.setVisible(false);
				if(addHos.getSubAdd()!=null)
					addHos.getSubAdd().setVisible(false);
				addVacations.setVisible(false);
				addVacations.setEnabled(false);
				viewD.setEnabled(false);
				viewD.setVisible(false);
				viewP.setEnabled(false);
				viewP.setVisible(false);
				viewHos.setVisible(false);
				viewHos.setEnabled(false);
				viewVacations.setVisible(false);
				viewVacations.setEnabled(false);
				if(viewD.getUpdateDoctor()!=null)
					viewD.getUpdateDoctor().setVisible(false);
				if(viewHos.getUpdateHosp()!=null)
					viewHos.getUpdateHosp().setVisible(false);
				if(viewP.getUpdatePatient()!=null)
					viewP.getUpdatePatient().setVisible(false);
				if(viewR.getUpdateRoom()!=null)
					viewR.getUpdateRoom().setVisible(false);
				qList.setVisible(false);
				patientMng.setBackground(new Color(240, 248, 255));
				DocMng.setBackground(new Color(240, 248, 255));
				btn_HosMng.setBackground(new Color(240, 248, 255));
				queriesBtn.setBackground(new Color(240, 248, 255));
				vacationBtn.setBackground(new Color(240, 248, 255));
				dashBtn.setBackground(new Color(240, 248, 255));
				roomMng.setBackground(new Color(240, 248, 255));
				UserMng.setBackground(Color.WHITE);
				patIsClicked=false;
				DocisClicked=false;
				HosIsClicked=false;
				roomIsClicked=false;
				vacIsClicked=false;
				qIsClicked=false;
				userIsClicked=true;
				MainMenu.this.setBounds(100, 100, 1058, 660);
				panel_1.setBounds(0, 0, 1052, 118);
				panel_4.setBounds(849, 72, 177, 46);
				panel.setBounds(0, 121, 262, 526);
				patsWithSLvl10OHosp3Times.setVisible(false);
				docworkinInHaifa.setVisible(false);
				docInSurgeryCermony.setVisible(false);
				hosStatusDocInfection.setVisible(false);
				busyDoc.setVisible(false);
				patTestResults.setVisible(false);
				hospMostProfits.setVisible(false);
				allHospDetails.setVisible(false);
				rareBloodType.setVisible(false);
				loadLevel.setVisible(false);
				hypo.setVisible(false);
				addUser.setVisible(false);
				addUser.setEnabled(false);
				viewUser.setVisible(false);
				viewUser.setEnabled(false);
				setLocationRelativeTo(null);

			}
		});
	
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(DocisClicked) {
					addD.setEnabled(true);
					addD.setVisible(true);
					viewD.setEnabled(false);
					viewD.setVisible(false);
					viewP.setEnabled(false);
					viewP.setVisible(false);
					viewR.setVisible(false);
					viewR.setEnabled(false);
					viewHos.setVisible(false);
					viewHos.setEnabled(false);
					stat.setVisible(false);
					stat.setEnabled(false);
					viewVacations.setVisible(false);
					viewVacations.setEnabled(false);
					addP.setEnabled(false);
					addP.setVisible(false);
					addR.setEnabled(false);
					addR.setVisible(false);
					addVacations.setVisible(false);
					addVacations.setEnabled(false);
					if(updatePDetails!=null) {
					updatePDetails.setEnabled(false);
					updatePDetails.setVisible(false);
					}
					addUser.setVisible(false);
					addUser.setEnabled(false);
					viewUser.setVisible(false);
					viewUser.setEnabled(false);
					setLocationRelativeTo(null);

				}
				else if(patIsClicked) {
					addP.setEnabled(true);
					addP.setVisible(true);
					viewP.setEnabled(false);
					viewP.setVisible(false);
					viewD.setEnabled(false);
					viewD.setVisible(false);
					viewR.setVisible(false);
					viewR.setEnabled(false);
					viewHos.setVisible(false);
					viewHos.setEnabled(false);
					stat.setVisible(false);
					stat.setEnabled(false);
					viewVacations.setVisible(false);
					viewVacations.setEnabled(false);
					addD.setEnabled(false);
					addD.setVisible(false);
					addR.setEnabled(false);
					addR.setVisible(false);
					addVacations.setVisible(false);
					addVacations.setEnabled(false);
					if(updatePDetails!=null) {
					updatePDetails.setEnabled(false);
					updatePDetails.setVisible(false);
					}
					addUser.setVisible(false);
					addUser.setEnabled(false);
					viewUser.setVisible(false);
					viewUser.setEnabled(false);
					setLocationRelativeTo(null);

				}
				else if(roomIsClicked) {
					addR.setEnabled(true);
					addR.setVisible(true);
					viewD.setEnabled(false);
					viewD.setVisible(false);
					viewP.setEnabled(false);
					viewP.setVisible(false);
					viewR.setVisible(false);
					viewR.setEnabled(false);
					viewHos.setVisible(false);
					viewHos.setEnabled(false);
					stat.setVisible(false);
					stat.setEnabled(false);
					viewVacations.setVisible(false);
					viewVacations.setEnabled(false);
					addP.setEnabled(false);
					addP.setVisible(false);
					addD.setEnabled(false);
					addD.setVisible(false);
					addVacations.setVisible(false);
					addVacations.setEnabled(false);
					if(updatePDetails!=null) {
					updatePDetails.setEnabled(false);
					updatePDetails.setVisible(false);
					}
					addUser.setVisible(false);
					addUser.setEnabled(false);
					viewUser.setVisible(false);
					viewUser.setEnabled(false);
					setLocationRelativeTo(null);

				}
				else if(HosIsClicked) {
					addHos.setEnabled(true);
					addHos.setVisible(true);
					stat.setVisible(false);
					stat.setEnabled(false);
					addR.setEnabled(false);
					addR.setVisible(false);
					viewD.setEnabled(false);
					viewD.setVisible(false);
					viewP.setEnabled(false);
					viewP.setVisible(false);
					viewR.setVisible(false);
					viewR.setEnabled(false);
					viewHos.setVisible(false);
					viewHos.setEnabled(false);
					if(viewHos.getUpdateHosp()!=null) {
						viewHos.getUpdateHosp().setVisible(false);
						if (viewHos.getUpdateHosp().subUpdate!=null)
						viewHos.getUpdateHosp().subUpdate.setVisible(false);
					}
					viewVacations.setVisible(false);
					viewVacations.setEnabled(false);
					addP.setEnabled(false);
					addP.setVisible(false);
					addD.setEnabled(false);
					addD.setVisible(false);
					addVacations.setVisible(false);
					addVacations.setEnabled(false);
					if(updatePDetails!=null) {
						updatePDetails.setEnabled(false);
						updatePDetails.setVisible(false);
					}	
					addUser.setVisible(false);
					addUser.setEnabled(false);
					viewUser.setVisible(false);
					viewUser.setEnabled(false);
					setLocationRelativeTo(null);

				}
				else if(vacIsClicked) {
					addVacations.setVisible(true);
					addVacations.setEnabled(true);
					addR.setEnabled(false);
					stat.setVisible(false);
					stat.setEnabled(false);
					addR.setVisible(false);
					viewD.setEnabled(false);
					viewD.setVisible(false);
					viewP.setEnabled(false);
					viewP.setVisible(false);
					viewR.setVisible(false);
					viewR.setEnabled(false);
					viewHos.setVisible(false);
					viewHos.setEnabled(false);
					viewVacations.setVisible(false);
					viewVacations.setEnabled(false);
					addP.setEnabled(false);
					addP.setVisible(false);
					addD.setEnabled(false);
					addD.setVisible(false);
					int num = addVacations.getVacationDate().getMonthChooser().getMonth();
					addVacations.getVacationDate().getMonthChooser().setMonth(0);
					addVacations.getVacationDate().getMonthChooser().setMonth(num);
					addVacations.getCbHospitalName().setSelectedItem(viewVacations.getCbHospitalName().getSelectedItem());
					addUser.setVisible(false);
					addUser.setEnabled(false);
					viewUser.setVisible(false);
					viewUser.setEnabled(false);
					setLocationRelativeTo(null);

				}
				else if(qIsClicked) {
					addR.setEnabled(false);
					addR.setVisible(false);
					viewD.setEnabled(false);
					viewD.setVisible(false);
					viewP.setEnabled(false);
					viewP.setVisible(false);
					viewR.setVisible(false);
					viewR.setEnabled(false);
					viewHos.setVisible(false);
					viewHos.setEnabled(false);
					stat.setVisible(false);
					stat.setEnabled(false);
					viewVacations.setVisible(false);
					viewVacations.setEnabled(false);
					addP.setEnabled(false);
					addP.setVisible(false);
					addD.setEnabled(false);
					addD.setVisible(false);
					addVacations.setVisible(false);
					addVacations.setEnabled(false);
					if(updatePDetails!=null) {
					updatePDetails.setEnabled(false);
					updatePDetails.setVisible(false);
					}
					addUser.setVisible(false);
					addUser.setEnabled(false);
					viewUser.setVisible(false);
					viewUser.setEnabled(false);
					setLocationRelativeTo(null);

				}
				else if(userIsClicked) {
					addUser.setVisible(true);
					addUser.setEnabled(true);
					addR.setEnabled(false);
					addR.setVisible(false);
					viewD.setEnabled(false);
					viewD.setVisible(false);
					viewP.setEnabled(false);
					viewP.setVisible(false);
					viewR.setVisible(false);
					viewR.setEnabled(false);
					viewHos.setVisible(false);
					viewHos.setEnabled(false);
					stat.setVisible(false);
					stat.setEnabled(false);
					viewVacations.setVisible(false);
					viewVacations.setEnabled(false);
					addP.setEnabled(false);
					addP.setVisible(false);
					addD.setEnabled(false);
					addD.setVisible(false);
					addVacations.setVisible(false);
					addVacations.setEnabled(false);
					if(updatePDetails!=null) {
					updatePDetails.setEnabled(false);
					updatePDetails.setVisible(false);
					}
					viewUser.setVisible(false);
					viewUser.setEnabled(false);
					setLocationRelativeTo(null);

				}
		
			}
		});
		

		logOut_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logOut_btn.setBackground(new Color(0,153,204));
			}
		});
		
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(DocisClicked) {
					viewD.setEnabled(true);
					viewD.setVisible(true);
					viewP.setEnabled(false);
					viewP.setVisible(false);
					viewR.setVisible(false);
					viewR.setEnabled(false);
					stat.setVisible(false);
					stat.setEnabled(false);
					viewHos.setVisible(false);
					viewHos.setEnabled(false);
					viewVacations.setVisible(false);
					viewVacations.setEnabled(false);
					addP.setEnabled(false);
					addP.setVisible(false);
					addD.setEnabled(false);
					addD.setVisible(false);
					addR.setEnabled(false);
					addR.setVisible(false);
					addVacations.setVisible(false);
					addVacations.setEnabled(false);
					viewD.refreshComp(MainMenu.this);
					addUser.setVisible(false);
					addUser.setEnabled(false);
					viewUser.setVisible(false);
					viewUser.setEnabled(false);
					setLocationRelativeTo(null);

				}
				else if(patIsClicked) {
					viewP.setEnabled(true);
					viewP.setVisible(true);
					viewD.setEnabled(false);
					viewD.setVisible(false);
					stat.setVisible(false);
					stat.setEnabled(false);
					viewR.setVisible(false);
					viewR.setEnabled(false);
					viewHos.setVisible(false);
					viewHos.setEnabled(false);
					viewVacations.setVisible(false);
					viewVacations.setEnabled(false);
					addP.setEnabled(false);
					addP.setVisible(false);
					addD.setEnabled(false);
					addD.setVisible(false);
					addR.setEnabled(false);
					addR.setVisible(false);
					addVacations.setVisible(false);
					addVacations.setEnabled(false);
					viewP.refreshComp();
					addUser.setVisible(false);
					addUser.setEnabled(false);
					viewUser.setVisible(false);
					viewUser.setEnabled(false);
					setLocationRelativeTo(null);

				}
				else if(roomIsClicked) {
					viewR.setEnabled(true);
					viewR.setVisible(true);
					viewP.setEnabled(false);
					viewD.setVisible(false);
					viewD.setEnabled(false);
					viewP.setVisible(false);
					stat.setVisible(false);
					stat.setEnabled(false);
					viewHos.setVisible(false);
					viewHos.setEnabled(false);
					viewVacations.setVisible(false);
					viewVacations.setEnabled(false);
					addP.setEnabled(false);
					addP.setVisible(false);
					addD.setEnabled(false);
					addD.setVisible(false);
					addR.setEnabled(false);
					addR.setVisible(false);
					addVacations.setVisible(false);
					addVacations.setEnabled(false);
					viewR.refreshComp();
					addUser.setVisible(false);
					addUser.setEnabled(false);
					viewUser.setVisible(false);
					viewUser.setEnabled(false);
					setLocationRelativeTo(null);

				}
				else if(HosIsClicked) {
					viewHos.setVisible(true);
					viewHos.setEnabled(true);
					addHos.setEnabled(false);
					stat.setVisible(false);
					stat.setEnabled(false);
					addHos.setVisible(false);
					if(addHos.getSubAdd()!=null) {
						addHos.getSubAdd().setVisible(false);
					}
					if(viewHos.getUpdateHosp()!=null) {
						viewHos.getUpdateHosp().setVisible(false);
						if (viewHos.getUpdateHosp().subUpdate!=null)
						viewHos.getUpdateHosp().subUpdate.setVisible(false);
					}
					addR.setEnabled(false);
					addR.setVisible(false);
					viewD.setEnabled(false);
					viewD.setVisible(false);
					viewP.setEnabled(false);
					viewP.setVisible(false);
					viewR.setVisible(false);
					viewR.setEnabled(false);
					viewVacations.setVisible(false);
					viewVacations.setEnabled(false);
					addP.setEnabled(false);
					addP.setVisible(false);
					addD.setEnabled(false);
					addD.setVisible(false);
					addVacations.setVisible(false);
					addVacations.setEnabled(false);
						if(updatePDetails!=null) {
							updatePDetails.setEnabled(false);
							updatePDetails.setVisible(false);
						}	
						viewHos.refreshComp(MainMenu.this);
						addUser.setVisible(false);
						addUser.setEnabled(false);
						viewUser.setVisible(false);
						viewUser.setEnabled(false);
						setLocationRelativeTo(null);

					}
				else if(vacIsClicked) {
					viewVacations.setVisible(true);
					viewVacations.setEnabled(true);
					addR.setEnabled(false);
					addR.setVisible(false);
					viewD.setEnabled(false);
					stat.setVisible(false);
					stat.setEnabled(false);
					viewD.setVisible(false);
					viewP.setEnabled(false);
					viewP.setVisible(false);
					viewR.setVisible(false);
					viewR.setEnabled(false);
					addP.setEnabled(false);
					addP.setVisible(false);
					addD.setEnabled(false);
					addD.setVisible(false);
					addVacations.setVisible(false);
					addVacations.setEnabled(false);
					viewVacations.getCbHospitalName().setSelectedItem(addVacations.getCbHospitalName().getSelectedItem());
					viewVacations.refreshComp();
					addUser.setVisible(false);
					addUser.setEnabled(false);
					viewUser.setVisible(false);
					viewUser.setEnabled(false);
					setLocationRelativeTo(null);

				}
				
				else if(userIsClicked) {
					viewUser.setVisible(true);
					viewUser.setEnabled(true);
					viewR.setEnabled(false);
					viewR.setVisible(false);
					viewP.setEnabled(false);
					viewD.setVisible(false);
					viewD.setEnabled(false);
					viewP.setVisible(false);
					stat.setVisible(false);
					stat.setEnabled(false);
					viewHos.setVisible(false);
					viewHos.setEnabled(false);
					viewVacations.setVisible(false);
					viewVacations.setEnabled(false);
					addP.setEnabled(false);
					addP.setVisible(false);
					addD.setEnabled(false);
					addD.setVisible(false);
					addR.setEnabled(false);
					addR.setVisible(false);
					addVacations.setVisible(false);
					addVacations.setEnabled(false);
					viewUser.refreshComp();
					addUser.setVisible(false);
					addUser.setEnabled(false);
					setLocationRelativeTo(null);

				}
			
			}
		});
		
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String txt= list.getSelectedValue();
				if(txt.equals("Show doctors working in Haifa")) {
					docworkinInHaifa.setVisible(true);
					viewVacations.setVisible(false);
					viewVacations.setEnabled(false);
					addR.setEnabled(false);
					addR.setVisible(false);
					viewD.setEnabled(false);
					stat.setVisible(false);
					stat.setEnabled(false);
					viewD.setVisible(false);
					viewP.setEnabled(false);
					viewP.setVisible(false);
					viewR.setVisible(false);
					viewR.setEnabled(false);
					addP.setEnabled(false);
					addP.setVisible(false);
					addD.setEnabled(false);
					addD.setVisible(false);
					addVacations.setVisible(false);
					addVacations.setEnabled(false);
					docInSurgeryCermony.setVisible(false);
					hosStatusDocInfection.setVisible(false);
					patsWithSLvl10OHosp3Times.setVisible(false);
					busyDoc.setVisible(false);
					hospMostProfits.setVisible(false);
					allHospDetails.setVisible(false);
					rareBloodType.setVisible(false);
					loadLevel.setVisible(false);
					hypo.setVisible(false);
					docworkinInHaifa.refreshComp();
					setLocationRelativeTo(null);

				}
				else if(txt.equals("Show patients with a severity level of 10 OR were hospitalized more than 3 times in the past year")){
					patsWithSLvl10OHosp3Times.setVisible(true);
					viewVacations.setVisible(false);
					viewVacations.setEnabled(false);
					addR.setEnabled(false);
					addR.setVisible(false);
					viewD.setEnabled(false);
					stat.setVisible(false);
					stat.setEnabled(false);
					viewD.setVisible(false);
					viewP.setEnabled(false);
					viewP.setVisible(false);
					viewR.setVisible(false);
					viewR.setEnabled(false);
					addP.setEnabled(false);
					addP.setVisible(false);
					addD.setEnabled(false);
					addD.setVisible(false);
					addVacations.setVisible(false);
					addVacations.setEnabled(false);
					docworkinInHaifa.setVisible(false);
					docInSurgeryCermony.setVisible(false);
					hosStatusDocInfection.setVisible(false);
					busyDoc.setVisible(false);
					hospMostProfits.setVisible(false);
					allHospDetails.setVisible(false);
					rareBloodType.setVisible(false);
					loadLevel.setVisible(false);
					hypo.setVisible(false);
					patsWithSLvl10OHosp3Times.refreshComp();
					setLocationRelativeTo(null);

				}
				else if(txt.equals("Show doctors who are invited to the National Surgery Convention")) {
					docInSurgeryCermony.setVisible(true);
					viewVacations.setVisible(false);
					viewVacations.setEnabled(false);
					addR.setEnabled(false);
					addR.setVisible(false);
					viewD.setEnabled(false);
					stat.setVisible(false);
					stat.setEnabled(false);
					viewD.setVisible(false);
					viewP.setEnabled(false);
					viewP.setVisible(false);
					viewR.setVisible(false);
					viewR.setEnabled(false);
					addP.setEnabled(false);
					addP.setVisible(false);
					addD.setEnabled(false);
					addD.setVisible(false);
					addVacations.setVisible(false);
					addVacations.setEnabled(false);
					patsWithSLvl10OHosp3Times.setVisible(false);
					docworkinInHaifa.setVisible(false);
					hosStatusDocInfection.setVisible(false);
					busyDoc.setVisible(false);
					hospMostProfits.setVisible(false);
					allHospDetails.setVisible(false);
					rareBloodType.setVisible(false);
					loadLevel.setVisible(false);
					hypo.setVisible(false);
					docInSurgeryCermony.refreshComp();
					setLocationRelativeTo(null);

				}
				else if(txt.equals("Show hospitals' status regarding doctors' infection in Emergency Care in the past month")) {
					hosStatusDocInfection.setVisible(true);
					viewVacations.setVisible(false);
					viewVacations.setEnabled(false);
					addR.setEnabled(false);
					addR.setVisible(false);
					viewD.setEnabled(false);
					stat.setVisible(false);
					stat.setEnabled(false);
					viewD.setVisible(false);
					viewP.setEnabled(false);
					viewP.setVisible(false);
					viewR.setVisible(false);
					viewR.setEnabled(false);
					addP.setEnabled(false);
					addP.setVisible(false);
					addD.setEnabled(false);
					addD.setVisible(false);
					addVacations.setVisible(false);
					addVacations.setEnabled(false);
					patsWithSLvl10OHosp3Times.setVisible(false);
					docworkinInHaifa.setVisible(false);
					docInSurgeryCermony.setVisible(false);
					busyDoc.setVisible(false);
					hospMostProfits.setVisible(false);
					allHospDetails.setVisible(false);
					rareBloodType.setVisible(false);
					loadLevel.setVisible(false);
					hypo.setVisible(false);
					hosStatusDocInfection.refreshComp();
					setLocationRelativeTo(null);

				}
				else if(txt.equals("Show busy doctors")){
					busyDoc.setVisible(true);
					viewVacations.setVisible(false);
					viewVacations.setEnabled(false);
					addR.setEnabled(false);
					addR.setVisible(false);
					viewD.setEnabled(false);
					stat.setVisible(false);
					stat.setEnabled(false);
					viewD.setVisible(false);
					viewP.setEnabled(false);
					viewP.setVisible(false);
					viewR.setVisible(false);
					viewR.setEnabled(false);
					addP.setEnabled(false);
					addP.setVisible(false);
					addD.setEnabled(false);
					addD.setVisible(false);
					addVacations.setVisible(false);
					addVacations.setEnabled(false);
					patsWithSLvl10OHosp3Times.setVisible(false);
					docworkinInHaifa.setVisible(false);
					docInSurgeryCermony.setVisible(false);
					hosStatusDocInfection.setVisible(false);
					hospMostProfits.setVisible(false);
					allHospDetails.setVisible(false);
					rareBloodType.setVisible(false);
					loadLevel.setVisible(false);
					hypo.setVisible(false);
					busyDoc.refreshComp();
					setLocationRelativeTo(null);

					
				}
				else if(txt.equals("Show doctor's department's hospitalized patients' last test results in doctor's last vacation day")) {
					patTestResults.setVisible(true);
					viewVacations.setVisible(false);
					viewVacations.setEnabled(false);
					addR.setEnabled(false);
					addR.setVisible(false);
					viewD.setEnabled(false);
					stat.setVisible(false);
					stat.setEnabled(false);
					viewD.setVisible(false);
					viewP.setEnabled(false);
					viewP.setVisible(false);
					viewR.setVisible(false);
					viewR.setEnabled(false);
					addP.setEnabled(false);
					addP.setVisible(false);
					addD.setEnabled(false);
					addD.setVisible(false);
					addVacations.setVisible(false);
					addVacations.setEnabled(false);
					patsWithSLvl10OHosp3Times.setVisible(false);
					docworkinInHaifa.setVisible(false);
					docInSurgeryCermony.setVisible(false);
					hosStatusDocInfection.setVisible(false);
					busyDoc.setVisible(false);
					hospMostProfits.setVisible(false);
					allHospDetails.setVisible(false);
					rareBloodType.setVisible(false);
					loadLevel.setVisible(false);
					hypo.setVisible(false);
					setLocationRelativeTo(null);

				}
				else if(txt.equals("Show every month's hospital for the past year with most profits from hospitalizations")){
					hospMostProfits.setVisible(true);
					viewVacations.setVisible(false);
					viewVacations.setEnabled(false);
					addR.setEnabled(false);
					addR.setVisible(false);
					viewD.setEnabled(false);
					stat.setVisible(false);
					stat.setEnabled(false);
					viewD.setVisible(false);
					viewP.setEnabled(false);
					viewP.setVisible(false);
					viewR.setVisible(false);
					viewR.setEnabled(false);
					addP.setEnabled(false);
					addP.setVisible(false);
					addD.setEnabled(false);
					addD.setVisible(false);
					addVacations.setVisible(false);
					addVacations.setEnabled(false);
					patsWithSLvl10OHosp3Times.setVisible(false);
					docworkinInHaifa.setVisible(false);
					docInSurgeryCermony.setVisible(false);
					hosStatusDocInfection.setVisible(false);
					busyDoc.setVisible(false);
					patTestResults.setVisible(false);
					allHospDetails.setVisible(false);
					rareBloodType.setVisible(false);
					loadLevel.setVisible(false);
					hypo.setVisible(false);
					hospMostProfits.refreshComp();
					setLocationRelativeTo(null);

				}
				else if(txt.equals("Show every hospital's details (departments, manager, number of doctors)")) {
					allHospDetails.setVisible(true);
					viewVacations.setVisible(false);
					viewVacations.setEnabled(false);
					addR.setEnabled(false);
					addR.setVisible(false);
					viewD.setEnabled(false);
					stat.setVisible(false);
					stat.setEnabled(false);
					viewD.setVisible(false);
					viewP.setEnabled(false);
					viewP.setVisible(false);
					viewR.setVisible(false);
					viewR.setEnabled(false);
					addP.setEnabled(false);
					addP.setVisible(false);
					addD.setEnabled(false);
					addD.setVisible(false);
					addVacations.setVisible(false);
					addVacations.setEnabled(false);
					patsWithSLvl10OHosp3Times.setVisible(false);
					docworkinInHaifa.setVisible(false);
					docInSurgeryCermony.setVisible(false);
					hosStatusDocInfection.setVisible(false);
					busyDoc.setVisible(false);
					patTestResults.setVisible(false);
					hospMostProfits.setVisible(false);
					rareBloodType.setVisible(false);
					loadLevel.setVisible(false);
					hypo.setVisible(false);
					allHospDetails.refreshComp();
					setLocationRelativeTo(null);

				}
				else if(txt.equals("Show people with rare blood type")) {
					rareBloodType.setVisible(true);
					viewVacations.setVisible(false);
					viewVacations.setEnabled(false);
					addR.setEnabled(false);
					addR.setVisible(false);
					viewD.setEnabled(false);
					stat.setVisible(false);
					stat.setEnabled(false);
					viewD.setVisible(false);
					viewP.setEnabled(false);
					viewP.setVisible(false);
					viewR.setVisible(false);
					viewR.setEnabled(false);
					addP.setEnabled(false);
					addP.setVisible(false);
					addD.setEnabled(false);
					addD.setVisible(false);
					addVacations.setVisible(false);
					addVacations.setEnabled(false);
					patsWithSLvl10OHosp3Times.setVisible(false);
					docworkinInHaifa.setVisible(false);
					docInSurgeryCermony.setVisible(false);
					hosStatusDocInfection.setVisible(false);
					busyDoc.setVisible(false);
					patTestResults.setVisible(false);
					hospMostProfits.setVisible(false);
					allHospDetails.setVisible(false);
					loadLevel.setVisible(false);
					hypo.setVisible(false);
					rareBloodType.refreshComp();
					setLocationRelativeTo(null);

				}
				else if(txt.equals("Show load level of all departments")){
					loadLevel.setVisible(true);
					viewVacations.setVisible(false);
					viewVacations.setEnabled(false);
					addR.setEnabled(false);
					addR.setVisible(false);
					viewD.setEnabled(false);
					stat.setVisible(false);
					stat.setEnabled(false);
					viewD.setVisible(false);
					viewP.setEnabled(false);
					viewP.setVisible(false);
					viewR.setVisible(false);
					viewR.setEnabled(false);
					addP.setEnabled(false);
					addP.setVisible(false);
					addD.setEnabled(false);
					addD.setVisible(false);
					addVacations.setVisible(false);
					addVacations.setEnabled(false);
					patsWithSLvl10OHosp3Times.setVisible(false);
					docworkinInHaifa.setVisible(false);
					docInSurgeryCermony.setVisible(false);
					hosStatusDocInfection.setVisible(false);
					busyDoc.setVisible(false);
					patTestResults.setVisible(false);
					hospMostProfits.setVisible(false);
					allHospDetails.setVisible(false);
					rareBloodType.setVisible(false);
					hypo.setVisible(false);
					loadLevel.refreshComp();
					setLocationRelativeTo(null);

				}
				else if(txt.equals("Show hypochondriacs ")) {
					hypo.setVisible(true);
					viewVacations.setVisible(false);
					viewVacations.setEnabled(false);
					addR.setEnabled(false);
					addR.setVisible(false);
					viewD.setEnabled(false);
					stat.setVisible(false);
					stat.setEnabled(false);
					viewD.setVisible(false);
					viewP.setEnabled(false);
					viewP.setVisible(false);
					viewR.setVisible(false);
					viewR.setEnabled(false);
					addP.setEnabled(false);
					addP.setVisible(false);
					addD.setEnabled(false);
					addD.setVisible(false);
					addVacations.setVisible(false);
					addVacations.setEnabled(false);
					patsWithSLvl10OHosp3Times.setVisible(false);
					docworkinInHaifa.setVisible(false);
					docInSurgeryCermony.setVisible(false);
					hosStatusDocInfection.setVisible(false);
					busyDoc.setVisible(false);
					patTestResults.setVisible(false);
					hospMostProfits.setVisible(false);
					allHospDetails.setVisible(false);
					rareBloodType.setVisible(false);
					loadLevel.setVisible(false);
					loadLevel.refreshComp();
					setLocationRelativeTo(null);

				}
            	
			}
		});
		
	
	}

	public Panel_View_Patient getViewP() {
		return viewP;
	}

	public Panel_update_PatientDetails getUpdatePDetails() {
		return updatePDetails;
	}

	public Panel_add_Doctor getAddD() {
		return addD;
	}

	public Panel_add_Patient getAddP() {
		return addP;
	}

	public Panel_add_Room getAddR() {
		return addR;
	}

	public Panel_View_Doctor getviewD() {
		return viewD;
	}

	public Panel_View_Room getviewR() {
		return viewR;
	}
	

	public Panel_View_Hosp getViewHos() {
		return viewHos;
	}

	public Panel_addHospitalization getAddHos() {
		return addHos;
	}

	public Panel_add_Vacations getAddVacations() {
		return addVacations;
	}

	public Panel_View_Vacations getViewVacations() {
		return viewVacations;
	}
	
	public Panel_View_User getViewUsers() {
		return viewUser;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}

	public JButton getBtnView() {
		return btnView;
	}

	public void setBtnView(JButton btnView) {
		this.btnView = btnView;
	}
}
