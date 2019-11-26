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
import javax.swing.table.TableModel;
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
import model.Patient;

import java.awt.BorderLayout;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ItemEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class Panel_update_DoctorDetails extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Hospital> hospitals;
	private JTextArea tfFirstName;
	private JTextArea tfSurName;
	private JTextArea tfID;
	private JTextArea tfCity;
	private JComboBox cbCareFacility;
	private JTextArea tfStreet;
	private JRadioButton radioButtonFemale;
	private JRadioButton radioButtonMale;
	private JComboBox cbBloodType;
	private JTextArea tfPhoneNumber;
	private JDateChooser birthDate;
	private JCheckBox cbIsManager;
	private JComboBox<String> cbDepartmentName;
	private JComboBox<String> cbDepartmentID;
	private JComboBox<String> cbHospitalName;
	private JComboBox<String> cbHospitalID;
	private JDateChooser graduationDate;
	private String docID;
	private JButton btnBack;

	/**
	 * Create the panel.
	 */
	public Panel_update_DoctorDetails(String docID,MainMenu mm ) {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setDocID(docID);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 765, 39);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblAddPerson = new JLabel("Update Doctor");
		lblAddPerson.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblAddPerson.setForeground(new Color(25, 25, 112));
		lblAddPerson.setBounds(43, 6, 207, 33);
		panel.add(lblAddPerson);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(43, 48, 292, 26);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblName = new JLabel("First Name:");
		lblName.setBounds(0, 0, 108, 17);
		panel_1.add(lblName);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		tfFirstName = new JTextArea();
		tfFirstName.setFont(new Font("Arial", Font.PLAIN, 14));
		tfFirstName.setBounds(122, 4, 170, 15);
		panel_1.add(tfFirstName);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(119, 24, 173, 2);
		panel_1.add(separator);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(43, 89, 292, 26);
		add(panel_2);
		
		JLabel lblSurName = new JLabel("Sur Name:");
		lblSurName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSurName.setBounds(0, 0, 90, 17);
		panel_2.add(lblSurName);
		
		tfSurName = new JTextArea();
		tfSurName.setFont(new Font("Arial", Font.PLAIN, 14));
		tfSurName.setBounds(122, 4, 170, 15);
		panel_2.add(tfSurName);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(119, 24, 173, 2);
		panel_2.add(separator_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(43, 128, 292, 26);
		add(panel_3);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblId.setBounds(0, -1, 80, 17);
		panel_3.add(lblId);
		
		tfID = new JTextArea();
		tfID.setFont(new Font("Arial", Font.PLAIN, 14));
		tfID.setBounds(122, 4, 170, 15);
		tfID.setEditable(false);
		tfID.setForeground(Color.gray);
		panel_3.add(tfID);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(119, 24, 173, 2);
		panel_3.add(separator_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(43, 171, 292, 26);
		add(panel_4);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCity.setBounds(0, -1, 80, 17);
		panel_4.add(lblCity);
		
		tfCity = new JTextArea();
		tfCity.setFont(new Font("Arial", Font.PLAIN, 14));
		tfCity.setBounds(122, 4, 170, 15);
		panel_4.add(tfCity);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(119, 24, 173, 2);
		panel_4.add(separator_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(43, 211, 292, 26);
		add(panel_5);
		
		JLabel lblStreet = new JLabel("Street:");
		lblStreet.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStreet.setBounds(0, -1, 80, 17);
		panel_5.add(lblStreet);
		
		tfStreet = new JTextArea();
		tfStreet.setFont(new Font("Arial", Font.PLAIN, 14));
		tfStreet.setBounds(122, 4, 170, 15);
		panel_5.add(tfStreet);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(119, 24, 173, 2);
		panel_5.add(separator_4);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(399, 54, 268, 39);
		add(panel_7);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGender.setBounds(0, 11, 80, 17);
		panel_7.add(lblGender);
		
		radioButtonFemale = new JRadioButton("Female");
		radioButtonFemale.setSelected(true);
		radioButtonFemale.setBackground(new Color(255, 255, 255));
		radioButtonFemale.setFont(new Font("Tahoma", Font.PLAIN, 14));
		radioButtonFemale.setBounds(77, 0, 82, 39);
		panel_7.add(radioButtonFemale);
		
		radioButtonMale = new JRadioButton("Male");
		radioButtonMale.setFont(new Font("Tahoma", Font.PLAIN, 14));
		radioButtonMale.setBackground(Color.WHITE);
		radioButtonMale.setBounds(161, 0, 62, 39);
		panel_7.add(radioButtonMale);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(radioButtonMale);
		bg.add(radioButtonFemale);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBackground(Color.WHITE);
		panel_8.setBounds(399, 108, 321, 26);
		add(panel_8);
		
		JLabel lblBloodType = new JLabel("Blood Type:");
		lblBloodType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBloodType.setBounds(0, 0, 130, 17);
		panel_8.add(lblBloodType);
		
		cbBloodType = new JComboBox();
		cbBloodType.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "O", "AB"}));
		cbBloodType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbBloodType.setToolTipText("A\r\nB\r\nO\r\nAB");
		cbBloodType.setBackground(new Color(255, 255, 255));
		cbBloodType.setBounds(156, 0, 165, 26);
		panel_8.add(cbBloodType);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBackground(Color.WHITE);
		panel_9.setBounds(399, 147, 321, 26);
		add(panel_9);
		
		JLabel lblCareFacility = new JLabel("Care Facility:");
		lblCareFacility.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCareFacility.setBounds(0, -1, 130, 17);
		panel_9.add(lblCareFacility);
		
		cbCareFacility = new JComboBox();
		cbCareFacility.setModel(new DefaultComboBoxModel(new String[] {"Clalit", "Leumit", "Maccabi", "Meuhedet"}));
		cbCareFacility.setToolTipText("A\r\nB\r\nO\r\nAB");
		cbCareFacility.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbCareFacility.setBackground(Color.WHITE);
		cbCareFacility.setBounds(156, 0, 165, 26);
		panel_9.add(cbCareFacility);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(399, 190, 321, 26);
		add(panel_6);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPhone.setBounds(0, -1, 91, 17);
		panel_6.add(lblPhone);
		
		tfPhoneNumber = new JTextArea();
		tfPhoneNumber.setFont(new Font("Arial", Font.PLAIN, 14));
		tfPhoneNumber.setBounds(151, 4, 170, 15);
		panel_6.add(tfPhoneNumber);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(148, 24, 173, 2);
		panel_6.add(separator_5);
		
		JPanel panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_11.setBackground(Color.WHITE);
		panel_11.setBounds(43, 250, 292, 46);
		add(panel_11);
		
		JLabel lblDateOfBirth = new JLabel("Date of birth:");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDateOfBirth.setBounds(0, 0, 118, 27);
		panel_11.add(lblDateOfBirth);
		
		birthDate = new JDateChooser();
		birthDate.setBackground(Color.WHITE);
		birthDate.setBounds(115, 0, 177, 39);
		panel_11.add(birthDate);
		
		JPanel panel_12 = new JPanel();
		panel_12.setLayout(null);
		panel_12.setBackground(Color.WHITE);
		panel_12.setBounds(399, 227, 321, 46);
		add(panel_12);
		
		JLabel lblDateOfGraduation = new JLabel("Date of graduation:");
		lblDateOfGraduation.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDateOfGraduation.setBounds(0, 0, 164, 27);
		panel_12.add(lblDateOfGraduation);
		
		graduationDate = new JDateChooser();
		graduationDate.setBackground(Color.WHITE);
		graduationDate.setBounds(157, 0, 164, 39);
		panel_12.add(graduationDate);
		
		JPanel panel_13 = new JPanel();
		panel_13.setLayout(null);
		panel_13.setBackground(Color.WHITE);
		panel_13.setBounds(37, 298, 298, 26);
		add(panel_13);
		
		JLabel lblHospitalId = new JLabel("Hospital Name:");
		lblHospitalId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHospitalId.setBounds(0, -1, 137, 17);
		panel_13.add(lblHospitalId);
		
		cbHospitalName = new JComboBox<String>();
		
		cbHospitalName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbHospitalName.setBackground(Color.WHITE);
		cbHospitalName.setBounds(163, 0, 135, 26);
		panel_13.add(cbHospitalName);
		
		JPanel panel_14 = new JPanel();
		panel_14.setLayout(null);
		panel_14.setBackground(Color.WHITE);
		panel_14.setBounds(399, 278, 149, 26);
		add(panel_14);
		
		JLabel lblManager = new JLabel("Manager:");
		lblManager.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblManager.setBounds(0, 0, 80, 22);
		panel_14.add(lblManager);
		
		cbIsManager = new JCheckBox("");
		cbIsManager.setBackground(new Color(255, 255, 255));
		cbIsManager.setBounds(86, 0, 41, 22);
		panel_14.add(cbIsManager);
		
		JPanel panel_15 = new JPanel();
		panel_15.setLayout(null);
		panel_15.setBackground(Color.WHITE);
		panel_15.setBounds(37, 335, 358, 26);
		add(panel_15);
		
		JLabel lblDepartmentId = new JLabel("Department Name:");
		lblDepartmentId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDepartmentId.setBounds(0, -1, 157, 17);
		panel_15.add(lblDepartmentId);
		
		cbDepartmentName = new JComboBox<String>();
			
		cbDepartmentName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbDepartmentName.setBackground(Color.WHITE);
		cbDepartmentName.setBounds(163, 0, 186, 26);
		panel_15.add(cbDepartmentName);
		
		cbHospitalID = new JComboBox<String>();
		cbHospitalID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbHospitalID.setBackground(Color.WHITE);
		cbHospitalID.setBounds(47, 397, 115, 26);
		add(cbHospitalID);
		cbHospitalID.setVisible(false);
		
		cbDepartmentID = new JComboBox<String>();
		cbDepartmentID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbDepartmentID.setBackground(Color.WHITE);
		cbDepartmentID.setBounds(230, 397, 155, 26);
		add(cbDepartmentID);
		cbDepartmentID.setVisible(false);
		
		JButton buttonUpdate = new JButton("Update");
		
		
		buttonUpdate.setIcon(new ImageIcon(Panel_update_DoctorDetails.class.getResource("/view/icons/refresh-arrows.png")));
		buttonUpdate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		buttonUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object[] options = {"Yes","No"};
				int n = JOptionPane.showOptionDialog(null, "Are you sure you want to update the doctor?","Update Doctor",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[1]);
				if (n==0)
				{
					
					if (birthDate.getDate().after(graduationDate.getDate()))
                        JOptionPane.showMessageDialog(null, "Birth Date must come before Graduation Date!");
					else if (Calendar.getInstance().getTime().getYear()-birthDate.getDate().getYear()<18)
						JOptionPane.showMessageDialog(null, "The doctor must be at least 18 years old!");
					else if (graduationDate.getDate().getYear()-birthDate.getDate().getYear()<18)
						JOptionPane.showMessageDialog(null, "The doctor is too young to be a graduate!");
					else if (tfID.getText().length()!=9)
						JOptionPane.showMessageDialog(null, "Invalid ID format! Please input 9 numbers");
					else if (tfPhoneNumber.getText().length()<9 || tfPhoneNumber.getText().length()>10)
						JOptionPane.showMessageDialog(null, "Invalid Phone Number! Please input 9/10 numbers");
				
					else if (cbIsManager.isSelected())
					{
						String d = Logic.getInstance().getDepartmentManager(cbHospitalID.getSelectedItem().toString(), cbDepartmentID.getSelectedItem().toString());
						if (d!=null && !d.equals(tfID.getText()))
						JOptionPane.showMessageDialog(null, "There is already a manager in the selected department!");
						else
						{
							    Date bday =  new java.sql.Date(birthDate.getDate().getTime());
							if (radioButtonFemale.isSelected())
							Logic.getInstance().UpdatePerson(tfID.getText(), tfFirstName.getText(), tfSurName.getText(),
									bday , tfCity.getText(), tfStreet.getText(), "F" , tfPhoneNumber.getText(), cbBloodType.getSelectedItem().toString(), cbCareFacility.getSelectedItem().toString(),null);
							else
								Logic.getInstance().UpdatePerson(tfID.getText(), tfFirstName.getText(), tfSurName.getText(),
										bday , tfCity.getText(), tfStreet.getText(), "M" , tfPhoneNumber.getText(), cbBloodType.getSelectedItem().toString(), cbCareFacility.getSelectedItem().toString(),null);
							    Date gday = new java.sql.Date(graduationDate.getDate().getTime());
							    Logic.getInstance().UpdateDoctor(tfID.getText(), gday, cbIsManager.isSelected(), cbHospitalID.getSelectedItem().toString(), cbDepartmentID.getSelectedItem().toString());
							    JOptionPane.showMessageDialog(null, tfFirstName.getText() + " " + tfSurName.getText() + " has successfully been updated as a Doctor!");          
							    mm.getviewD().setVisible(true);
							    mm.getviewD().refreshComp(mm);
								Panel_update_DoctorDetails.this.setVisible(false);
						}
							
					}
					else
					{
						Date bday =  new java.sql.Date(birthDate.getDate().getTime());
					if (radioButtonFemale.isSelected())
					Logic.getInstance().UpdatePerson(tfID.getText(), tfFirstName.getText(), tfSurName.getText(),
							bday , tfCity.getText(), tfStreet.getText(), "F" , tfPhoneNumber.getText(), cbBloodType.getSelectedItem().toString(), cbCareFacility.getSelectedItem().toString(),null);
					else
						Logic.getInstance().UpdatePerson(tfID.getText(), tfFirstName.getText(), tfSurName.getText(),
								bday , tfCity.getText(), tfStreet.getText(), "M" , tfPhoneNumber.getText(), cbBloodType.getSelectedItem().toString(), cbCareFacility.getSelectedItem().toString(),null);
					    Date gday = new java.sql.Date(graduationDate.getDate().getTime());
					    Logic.getInstance().UpdateDoctor(tfID.getText(), gday, cbIsManager.isSelected(), cbHospitalID.getSelectedItem().toString(), cbDepartmentID.getSelectedItem().toString());
					    JOptionPane.showMessageDialog(null, tfFirstName.getText() + " " + tfSurName.getText() + " has successfully been added as a Doctor!");
					    mm.getviewD().setVisible(true);
					    mm.getviewD().refreshComp(mm);
						Panel_update_DoctorDetails.this.setVisible(false);
					
					}		
				}
			}
		});
		buttonUpdate.setEnabled(false);
		buttonUpdate.setForeground(new Color(255, 255, 255));
		buttonUpdate.setBackground(Color.LIGHT_GRAY);
		buttonUpdate.setBounds(618, 374, 120, 41);
		add(buttonUpdate);
		
		btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon(Panel_update_DoctorDetails.class.getResource("/view/icons/back-arrow.png")));
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBack.setBackground(new Color(70, 130, 180));
		btnBack.setBounds(493, 374, 120, 41);
		add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mm.getviewD().setVisible(true);
				Panel_update_DoctorDetails.this.setVisible(false);
			}
		});
		
		JTextArea dep = new JTextArea();
		
		hospitals = Logic.getInstance().getHospitals();
		for (int i=0; i<hospitals.size();i++)
			cbHospitalName.insertItemAt(hospitals.get(i).getName(), i);
		for (int i=0; i<hospitals.size();i++)
			cbHospitalID.insertItemAt(hospitals.get(i).getHospitalID(), i);
		
		if (mm.getUser().getType().equals("doctor"))
		{
			cbHospitalName.setEnabled(false);
			cbHospitalName.setSelectedItem(Logic.getInstance().getDoctorDetails(docID).getHospital().getName());
		}
		if (mm.getUser().getType().equals("doctor"))
		{
		cbHospitalName.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				cbDepartmentName.removeAllItems();
				cbDepartmentID.removeAllItems();
				dep.setText("");
				for (Hospital hospital : hospitals)
					if (hospital.getName().equals(cbHospitalName.getSelectedItem().toString()))
				cbHospitalID.setSelectedItem(hospital.getHospitalID());
				for (int i=0;i<hospitals.size();i++)
				{
					if (hospitals.get(i).getName().equals(cbHospitalName.getSelectedItem().toString()))
						for (int j=0;j<hospitals.get(i).getDepartments().size();j++){
							cbDepartmentName.insertItemAt(hospitals.get(i).getDepartments().get(j).getDepartmentName(), j);
							cbDepartmentID.insertItemAt(hospitals.get(i).getDepartments().get(j).getDepartmentID(), j);
						}
				}
				cbDepartmentName.setSelectedItem(Logic.getInstance().getDoctorDetails(docID).getDepartment().getDepartmentName());
			}
		});
		}
		if (mm.getUser().getType().equals("doctor"))
		{
			//System.out.println(Logic.getInstance().getDoctorDetails(mm.getUser().getUsername()).getDepartment().getDepartmentName());
			cbDepartmentName.setEnabled(false);
			cbDepartmentName.setSelectedItem(Logic.getInstance().getDoctorDetails(mm.getUser().getUsername()).getDepartment().getDepartmentName());
		}
		cbHospitalName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbDepartmentName.removeAllItems();
				cbDepartmentID.removeAllItems();
				dep.setText("");
				for (Hospital hospital : hospitals)
					if (hospital.getName().equals(cbHospitalName.getSelectedItem().toString()))
				cbHospitalID.setSelectedItem(hospital.getHospitalID());
				for (int i=0;i<hospitals.size();i++)
				{
					if (hospitals.get(i).getName().equals(cbHospitalName.getSelectedItem().toString()))
						for (int j=0;j<hospitals.get(i).getDepartments().size();j++){
							cbDepartmentName.insertItemAt(hospitals.get(i).getDepartments().get(j).getDepartmentName(), j);
							cbDepartmentID.insertItemAt(hospitals.get(i).getDepartments().get(j).getDepartmentID(), j);
						}
				}
			}
		});
		
		cbDepartmentName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbDepartmentName.getItemCount()>0)
				dep.setText(cbDepartmentName.getSelectedItem().toString());
				for (Hospital hospital : hospitals)
					if (hospital.getHospitalID().equals(cbHospitalID.getSelectedItem().toString()))
						for (Department dep : hospital.getDepartments())
							if (cbDepartmentName.getItemCount()>0 && dep.getDepartmentName().equals(cbDepartmentName.getSelectedItem().toString()))
				cbDepartmentID.setSelectedItem(dep.getDepartmentID());
			}
		});
		
      mm.getBtnAdd().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Panel_update_DoctorDetails.this.setVisible(false);
				
			}
		});
		
		if(docID!=null)
			fetch();
		DocumentListener docListener = new DocumentListener() {
			@Override
			public void changedUpdate(DocumentEvent arg0) {
				emptyFields(tfFirstName, tfSurName, tfID, tfCity, tfStreet, birthDate, graduationDate, radioButtonFemale, radioButtonMale, tfPhoneNumber, dep, buttonUpdate);
				
			}
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				emptyFields(tfFirstName, tfSurName, tfID, tfCity, tfStreet, birthDate, graduationDate, radioButtonFemale, radioButtonMale, tfPhoneNumber, dep, buttonUpdate);
				
			}
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				emptyFields(tfFirstName, tfSurName, tfID, tfCity, tfStreet, birthDate, graduationDate, radioButtonFemale, radioButtonMale, tfPhoneNumber, dep, buttonUpdate);
				
			}
        };
	dep.getDocument().addDocumentListener(docListener);          
	tfFirstName.getDocument().addDocumentListener(docListener);
	tfSurName.getDocument().addDocumentListener(docListener);
	tfID.getDocument().addDocumentListener(docListener);
	tfCity.getDocument().addDocumentListener(docListener);
	tfStreet.getDocument().addDocumentListener(docListener);
	((JTextField)birthDate.getDateEditor().getUiComponent()).getDocument().addDocumentListener(docListener);
	((JTextField)graduationDate.getDateEditor().getUiComponent()).getDocument().addDocumentListener(docListener);
	tfPhoneNumber.getDocument().addDocumentListener(docListener);
	}
	
	public void emptyFields(JTextArea firstName, JTextArea surName, JTextArea id, JTextArea city, JTextArea street, JDateChooser birthDate, JDateChooser graduationDate, JRadioButton female, JRadioButton male, JTextArea phone, JTextArea dep, JButton add)
	{
		String birthDateText = ((JTextField)birthDate.getDateEditor().getUiComponent()).getText();
		Color birthDateColor = ((JTextField)birthDate.getDateEditor().getUiComponent()).getForeground();
		String graduationDateText = ((JTextField)graduationDate.getDateEditor().getUiComponent()).getText();
		Color graduationDateColor = ((JTextField)graduationDate.getDateEditor().getUiComponent()).getForeground();
		if (female.isSelected() || male.isSelected())
			if (firstName.getText().equals("") || surName.getText().equals("") || id.getText().equals("") || city.getText().equals("") || street.getText().equals("") ||
					birthDateText.length()<2 || birthDateColor.equals(Color.red) || graduationDateText.length()<2 || graduationDateColor.equals(Color.red)
					|| phone.getText().equals("") || dep.getText().equals(""))
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
private void fetch() {
		
		Doctor d=Logic.getInstance().getDoctorDetails(this.docID);
		if (d.getId()!=null)
		{
			tfFirstName.setText(d.getFirstName());
			tfSurName.setText(d.getSurName());
			tfID.setText(d.getId());
			tfCity.setText(d.getCity());
			tfStreet.setText(d.getStreet());
			tfPhoneNumber.setText(d.getPhoneNumber());
			birthDate.setDate(d.getDateOfBirth());
			graduationDate.setDate(d.getDateOfGraduation());
			cbIsManager.setSelected(d.isManager());
			if(d.getGender().equals("F"))
				radioButtonFemale.setSelected(true);
			if(d.getGender().equals("M"))
				radioButtonMale.setSelected(true);
			cbBloodType.setSelectedItem(d.getBloodType());
			cbCareFacility.setSelectedItem(d.getCareFacility());
			cbHospitalName.setSelectedItem(d.getHospital().getName());
			cbHospitalID.setSelectedItem(d.getHospital().getHospitalID());
			cbDepartmentName.setSelectedItem(d.getDepartment().getDepartmentName());
			cbDepartmentID.setSelectedItem(d.getDepartment().getDepartmentID());
		}
}


	public JButton getBtnBack() {
	return btnBack;
}

public void setBtnBack(JButton btnBack) {
	this.btnBack = btnBack;
}

	public String getDocID() {
		return docID;
	}

	public void setDocID(String docID) {
		this.docID = docID;
	}
}
