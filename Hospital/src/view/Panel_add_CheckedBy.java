package view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.OptionPaneUI;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

import com.toedter.calendar.DateUtil;
import com.toedter.calendar.IDateEvaluator;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;

import controller.Logic;
import model.Department;
import model.Doctor;
import model.Hospital;
import model.MedicalEvent;
import model.Person;

import java.awt.BorderLayout;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.util.Date;
import java.util.HashMap;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ItemEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class Panel_add_CheckedBy extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<MedicalEvent> events;
	private ArrayList<Person> patients;
	private ArrayList<Doctor> doctors;
	private String doctorName;
	private String patientID;
	private int eventCode;
	private int shiftNumber;
	private JComboBox<String> cbID;
	private JComboBox<String> cbDoctorName;
	private JComboBox<String> cbShiftType;
	private JComboBox<String> cbShiftDay;
	private JTextArea tfBloodPres2 ;
	private JTextArea tfBloodPres1;
	private JComboBox<String> cbEventDesc ;
	private JDateChooser checkDate ;
	private JTextArea tfPatName;
	JTextArea tfDoctorID;
	JTextArea tfBodyTemp;


	/**
	 * Create the panel.
	 */
	public Panel_add_CheckedBy(MainMenu mm, String patientID,String hospitalId,String hospName,String departName,String eventDesc) {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 765, 39);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblAddPerson = new JLabel("Add Check- up");
		lblAddPerson.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblAddPerson.setForeground(new Color(25, 25, 112));
		lblAddPerson.setBounds(43, 6, 207, 33);
		panel.add(lblAddPerson);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(47, 67, 292, 26);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblName = new JLabel("Patient ID:");
		lblName.setBounds(0, 0, 108, 17);
		panel_1.add(lblName);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		cbID = new JComboBox<String>();
		cbID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbID.setBackground(Color.WHITE);
		cbID.setBounds(113, 0, 179, 26);
		panel_1.add(cbID);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(47, 108, 292, 26);
		add(panel_2);
		
		JLabel lblSurName = new JLabel("Doctor Name:");
		lblSurName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSurName.setBounds(0, 0, 120, 17);
		panel_2.add(lblSurName);
		
		cbDoctorName = new JComboBox<String>();
		cbDoctorName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbDoctorName.setBackground(Color.WHITE);
		cbDoctorName.setBounds(113, 0, 179, 26);
		panel_2.add(cbDoctorName);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(47, 147, 292, 26);
		add(panel_3);
		
		JLabel lblId = new JLabel("Shift type:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblId.setBounds(0, -1, 109, 17);
		panel_3.add(lblId);
		
		cbShiftType = new JComboBox<String>();
		cbShiftType.setModel(new DefaultComboBoxModel(new String[] {"Morning ", "Evening"}));
		cbShiftType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbShiftType.setBackground(Color.WHITE);
		cbShiftType.setBounds(113, 0, 179, 26);
		panel_3.add(cbShiftType);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(47, 190, 292, 26);
		add(panel_4);
		
		JLabel lblCity = new JLabel("Day in week:");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCity.setBounds(0, -1, 116, 17);
		panel_4.add(lblCity);
		
		cbShiftDay = new JComboBox<String>();
		cbShiftDay.setModel(new DefaultComboBoxModel(new String[] {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}));
		cbShiftDay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbShiftDay.setBackground(Color.WHITE);
		cbShiftDay.setBounds(113, 0, 179, 26);
		panel_4.add(cbShiftDay);
		
		ButtonGroup bg = new ButtonGroup();
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(399, 190, 321, 26);
		add(panel_6);
		
		JLabel lblPhone = new JLabel("Blood pressure:");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPhone.setBounds(0, -1, 138, 17);
		panel_6.add(lblPhone);
		
		tfBloodPres2 = new JTextArea();
		tfBloodPres2.setFont(new Font("Arial", Font.PLAIN, 14));
		tfBloodPres2.setBounds(235, 4, 55, 15);
		panel_6.add(tfBloodPres2);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(148, 24, 173, 2);
		panel_6.add(separator_5);
		
		tfBloodPres1 = new JTextArea();
		tfBloodPres1.setFont(new Font("Arial", Font.PLAIN, 14));
		tfBloodPres1.setBounds(151, 4, 55, 15);
		panel_6.add(tfBloodPres1);
		
		JLabel lblSasasa = new JLabel("  /");
		lblSasasa.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSasasa.setBounds(212, 2, 32, 25);
		panel_6.add(lblSasasa);
		
		JPanel panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_11.setBackground(Color.WHITE);
		panel_11.setBounds(47, 314, 292, 55);
		add(panel_11);
		
		JLabel lblDateOfBirth = new JLabel("Check time:");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDateOfBirth.setBounds(0, 0, 118, 27);
		panel_11.add(lblDateOfBirth);
		
		checkDate = new JDateChooser();
		checkDate.setBackground(Color.WHITE);
		checkDate.setBounds(115, 0, 177, 39);
		panel_11.add(checkDate);
		
		JButton buttonAdd = new JButton("Add");
		buttonAdd.setIcon(new ImageIcon(Panel_add_CheckedBy.class.getResource("/view/icons/add.png")));
		
		buttonAdd.setEnabled(false);
		buttonAdd.setForeground(new Color(255, 255, 255));
		buttonAdd.setBackground(Color.LIGHT_GRAY);
		buttonAdd.setBounds(571, 343, 129, 41);
		add(buttonAdd);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(399, 67, 321, 26);
		add(panel_7);
		
		JLabel lblPatientName = new JLabel("Patient Name:");
		lblPatientName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPatientName.setBounds(0, -1, 125, 17);
		panel_7.add(lblPatientName);
		
		tfPatName = new JTextArea();
		tfPatName.setFont(new Font("Arial", Font.PLAIN, 14));
		tfPatName.setBounds(151, 4, 170, 15);
		panel_7.add(tfPatName);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(148, 24, 173, 2);
		panel_7.add(separator);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBackground(Color.WHITE);
		panel_8.setBounds(399, 108, 321, 26);
		add(panel_8);
		
		JLabel lblDoctorId = new JLabel("Doctor ID:");
		lblDoctorId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDoctorId.setBounds(0, -1, 91, 17);
		panel_8.add(lblDoctorId);
		
		tfDoctorID = new JTextArea();
		tfDoctorID.setFont(new Font("Arial", Font.PLAIN, 14));
		tfDoctorID.setBounds(151, 4, 170, 15);
		panel_8.add(tfDoctorID);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(148, 24, 173, 2);
		panel_8.add(separator_1);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBackground(Color.WHITE);
		panel_9.setBounds(399, 147, 321, 26);
		add(panel_9);
		
		JLabel label = new JLabel("Body temprature:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(0, -1, 150, 17);
		panel_9.add(label);
		
		tfBodyTemp = new JTextArea();
		tfBodyTemp.setFont(new Font("Arial", Font.PLAIN, 14));
		tfBodyTemp.setBounds(151, 4, 170, 15);
		panel_9.add(tfBodyTemp);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(148, 24, 173, 2);
		panel_9.add(separator_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(47, 270, 292, 26);
		add(panel_5);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDescription.setBounds(0, 0, 120, 17);
		panel_5.add(lblDescription);
		
		cbEventDesc = new JComboBox<String>();
		cbEventDesc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbEventDesc.setBackground(Color.WHITE);
		cbEventDesc.setBounds(113, 0, 179, 26);
		panel_5.add(cbEventDesc);
		
		
		
		patients = Logic.getInstance().getPatients();
		for (int i=0; i<patients.size();i++) {
			cbID.insertItemAt(patients.get(i).getId(), i);
		}
		
		JTextArea dep = new JTextArea();
		events = Logic.getInstance().getMedicalEvents(departName);
		doctors=Logic.getInstance().getDoctorsOfHospitalID(hospitalId);
		for (int i=0; i<events.size();i++) {
			String d= events.get(i).getDescription();
			cbEventDesc.insertItemAt(d, i);
		}
		for (int i=0; i<doctors.size();i++) {
			String FullName="Dr "+ doctors.get(i).getFirstName()+" "+ doctors.get(i).getSurName();
			cbDoctorName.insertItemAt(FullName, i);
		}
		cbDoctorName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setDoctorName(cbDoctorName.getSelectedItem().toString());
				fetch();
			}
		});
		cbEventDesc.setEnabled(false);
		cbEventDesc.setSelectedItem(eventDesc);
		
		setPatientID(patientID);
		cbID.setEnabled(false);
		cbID.setSelectedItem(patientID);
		
		tfPatName.setText(Logic.getInstance().getName(patientID));
		tfPatName.setEditable(false);
		tfDoctorID.setEditable(false);
		JButton btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon(Panel_add_CheckedBy.class.getResource("/view/icons/back-arrow.png")));
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(new Color(70, 130, 180));
		btnBack.setBounds(434, 343, 129, 41);
		add(btnBack);
		if(!tfPatName.isEditable())
			tfPatName.setForeground(Color.DARK_GRAY);
		if(!tfDoctorID.isEditable())
			tfDoctorID.setForeground(Color.DARK_GRAY);
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mm.getViewHos().setVisible(true);
				mm.getViewHos().setEnabled(true);
				 Panel_add_CheckedBy.this.setVisible(false);
				 Panel_add_CheckedBy.this.setEnabled(false);
			}
		});
		
       mm.getBtnView().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Panel_add_CheckedBy.this.setVisible(false);
				
			}
		});

		DocumentListener docListener = new DocumentListener() {
			@Override
			public void changedUpdate(DocumentEvent arg0) {
				emptyFields(cbID,  cbDoctorName, cbShiftType,  tfBloodPres2 ,   tfBloodPres1, cbEventDesc,  checkDate,  tfPatName,  tfDoctorID,  tfBodyTemp,  dep,  buttonAdd);
				
			}
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				emptyFields(cbID,  cbDoctorName, cbShiftType,  tfBloodPres2 ,   tfBloodPres1, cbEventDesc,  checkDate,  tfPatName,  tfDoctorID,  tfBodyTemp,  dep,  buttonAdd);
				
			}
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				emptyFields(cbID,  cbDoctorName, cbShiftType,  tfBloodPres2 ,   tfBloodPres1, cbEventDesc,  checkDate,  tfPatName,  tfDoctorID,  tfBodyTemp,  dep,  buttonAdd);
			}
        };
dep.getDocument().addDocumentListener(docListener);
((JTextField)checkDate.getDateEditor().getUiComponent()).getDocument().addDocumentListener(docListener);
tfBloodPres2.getDocument().addDocumentListener(docListener);

	}
	
	
	
	public void fetch(){
		
		for(Doctor d: doctors) {
			String fullName="Dr "+ d.getFirstName()+" "+ d.getSurName();
			if(fullName.equals(doctorName)) {
				tfDoctorID.setText(d.getId());
				
			}
		}
	
	

}
	
	public void emptyFields(JComboBox<String> cbID, JComboBox<String> cbDoctorName, JComboBox<String> cbShiftType, JTextArea tfBloodPres2 ,  JTextArea tfBloodPres1, JComboBox<String> cbEventDesc, JDateChooser checkDate, JTextArea tfPatName, JTextArea tfDoctorID, JTextArea tfBodyTemp, JTextArea dep, JButton add)
	{
		String checkDateText = ((JTextField)checkDate.getDateEditor().getUiComponent()).getText();
		Color checkDateColor = ((JTextField)checkDate.getDateEditor().getUiComponent()).getForeground();
	
		
			if (tfBloodPres2.getText().equals("") || tfBloodPres1.getText().equals("") || tfPatName.getText().equals("") || tfDoctorID.getText().equals("") 
					|| checkDateText.length()<2 || checkDateColor.equals(Color.red))
			{
				add.setEnabled(false);
				add.setBackground(Color.LIGHT_GRAY);
			}
			else
			{
				add.setEnabled(true);
				add.setBackground(new Color (70,130,180));
			}
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getPatientID() {
		return patientID;
	}

	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}
	
	
}
