package view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;

import controller.Logic;

import java.awt.BorderLayout;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Panel_add_Patient extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String firstName;
	String surName;
	String id;
	String city;
	String street;
	String birthday;
	String phoneNumber;
	String contactID;
	String bloodType;
	String careFacility;
	String gender;
	boolean contactSwitch = false;

	/**
	 * Create the panel.
	 */
	public Panel_add_Patient(MainMenu mm) {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 765, 39);
		add(panel);
		panel.setLayout(null);
		
		JLabel titleAddPerson = new JLabel("Add Patient");
		titleAddPerson.setFont(new Font("Tahoma", Font.PLAIN, 30));
		titleAddPerson.setForeground(new Color(25, 25, 112));
		titleAddPerson.setBounds(46, 6, 207, 33);
		panel.add(titleAddPerson);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(47, 67, 268, 26);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblName = new JLabel("First Name:");
		lblName.setBounds(0, 0, 102, 17);
		panel_1.add(lblName);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JTextArea tfFirstName = new JTextArea();
		tfFirstName.setFont(new Font("Arial", Font.PLAIN, 14));
		tfFirstName.setBounds(98, 4, 170, 15);
		panel_1.add(tfFirstName);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(95, 24, 173, 2);
		panel_1.add(separator);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(47, 108, 268, 26);
		add(panel_2);
		
		JLabel lblSurName = new JLabel("Sur Name:");
		lblSurName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSurName.setBounds(0, 0, 90, 17);
		panel_2.add(lblSurName);
		
		JTextArea tfSurName = new JTextArea();
		tfSurName.setFont(new Font("Arial", Font.PLAIN, 14));
		tfSurName.setBounds(98, 4, 170, 15);
		panel_2.add(tfSurName);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(95, 24, 173, 2);
		panel_2.add(separator_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(47, 147, 268, 26);
		add(panel_3);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblId.setBounds(0, -1, 80, 17);
		panel_3.add(lblId);
		
		JTextArea tfID = new JTextArea();
		tfID.setFont(new Font("Arial", Font.PLAIN, 14));
		tfID.setBounds(98, 4, 170, 15);
		panel_3.add(tfID);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(95, 24, 173, 2);
		panel_3.add(separator_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(47, 190, 268, 26);
		add(panel_4);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCity.setBounds(0, -1, 80, 17);
		panel_4.add(lblCity);
		
		JTextArea tfCity = new JTextArea();
		tfCity.setFont(new Font("Arial", Font.PLAIN, 14));
		tfCity.setBounds(98, 4, 170, 15);
		panel_4.add(tfCity);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(95, 24, 173, 2);
		panel_4.add(separator_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(47, 230, 268, 26);
		add(panel_5);
		
		JLabel lblStreet = new JLabel("Street:");
		lblStreet.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStreet.setBounds(0, -1, 80, 17);
		panel_5.add(lblStreet);
		
		JTextArea tfStreet = new JTextArea();
		tfStreet.setFont(new Font("Arial", Font.PLAIN, 14));
		tfStreet.setBounds(98, 4, 170, 15);
		panel_5.add(tfStreet);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(95, 24, 173, 2);
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
		
		JRadioButton radioButtonFemale = new JRadioButton("F");
		radioButtonFemale.setSelected(true);
		radioButtonFemale.setBackground(new Color(255, 255, 255));
		radioButtonFemale.setFont(new Font("Tahoma", Font.PLAIN, 14));
		radioButtonFemale.setBounds(77, 0, 62, 39);
		panel_7.add(radioButtonFemale);
		
		JRadioButton radioButtonMale = new JRadioButton("M");
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
		panel_8.setBounds(399, 108, 340, 26);
		add(panel_8);
		
		JLabel lblBloodType = new JLabel("Blood Type:");
		lblBloodType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBloodType.setBounds(0, 0, 134, 17);
		panel_8.add(lblBloodType);
		
		JComboBox cbBloodType = new JComboBox();
		cbBloodType.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "O", "AB"}));
		cbBloodType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbBloodType.setToolTipText("A\r\nB\r\nO\r\nAB");
		cbBloodType.setBackground(new Color(255, 255, 255));
		cbBloodType.setBounds(149, 0, 165, 26);
		panel_8.add(cbBloodType);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBackground(Color.WHITE);
		panel_9.setBounds(399, 147, 340, 26);
		add(panel_9);
		
		JLabel lblCareFacility = new JLabel("Care Facility:");
		lblCareFacility.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCareFacility.setBounds(0, -1, 123, 17);
		panel_9.add(lblCareFacility);
		
		JComboBox cbCareFacility = new JComboBox();
		cbCareFacility.setModel(new DefaultComboBoxModel(new String[] {"Clalit", "Maccabi", "Leumit", "Meuhedet"}));
		cbCareFacility.setToolTipText("A\r\nB\r\nO\r\nAB");
		cbCareFacility.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbCareFacility.setBackground(Color.WHITE);
		cbCareFacility.setBounds(149, 0, 165, 26);
		panel_9.add(cbCareFacility);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBackground(Color.WHITE);
		panel_10.setBounds(399, 230, 340, 26);
		add(panel_10);
		
		JLabel lblContactId = new JLabel("Contact ID:");
		lblContactId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContactId.setBounds(0, -1, 109, 17);
		panel_10.add(lblContactId);
		
		JTextArea tfContactID = new JTextArea();
		tfContactID.setFont(new Font("Arial", Font.PLAIN, 14));
		tfContactID.setBounds(155, 4, 170, 15);
		panel_10.add(tfContactID);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(152, 24, 173, 2);
		panel_10.add(separator_6);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(399, 190, 340, 26);
		add(panel_6);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPhone.setBounds(0, -1, 91, 17);
		panel_6.add(lblPhone);
		
		JTextArea tfPhoneNumber = new JTextArea();
		tfPhoneNumber.setFont(new Font("Arial", Font.PLAIN, 14));
		tfPhoneNumber.setBounds(155, 4, 170, 15);
		panel_6.add(tfPhoneNumber);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(152, 24, 173, 2);
		panel_6.add(separator_5);
		
		JPanel panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_11.setBackground(Color.WHITE);
		panel_11.setBounds(47, 269, 292, 55);
		add(panel_11);
		
		JLabel lblDateOfBirth = new JLabel("Date of birth:");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDateOfBirth.setBounds(0, 0, 118, 27);
		panel_11.add(lblDateOfBirth);
		
		JDateChooser birthDate = new JDateChooser();
		birthDate.setBounds(115, 0, 177, 39);
		panel_11.add(birthDate);
		
		JButton buttonAdd = new JButton("Add");
		buttonAdd.setIcon(new ImageIcon(Panel_add_Patient.class.getResource("/view/icons/add.png")));
		buttonAdd.setEnabled(false);
		buttonAdd.setForeground(new Color(255, 255, 255));
		buttonAdd.setBackground(Color.LIGHT_GRAY);
		buttonAdd.setBounds(538, 339, 129, 41);
		add(buttonAdd);
		
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!contactSwitch)
				{
				Object[] options = {"Yes","No"};
				int n = JOptionPane.showOptionDialog(null, "Are you sure you want to add the patient?","Add Patient",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[1]);
				if (n==0)
				{
					boolean contactExists = true;
					boolean patientExists = Logic.getInstance().PatientExists(tfID.getText());
					if (tfContactID.getText().length()==9)
					    contactExists = Logic.getInstance().ContactExists(tfContactID.getText());
					if (tfID.getText().length()!=9)
						JOptionPane.showMessageDialog(null, "Invalid ID format! Please input 9 numbers");
					else if (tfContactID.getText().length()>0 && tfContactID.getText().length()!=9)
						JOptionPane.showMessageDialog(null, "Invalid Contact ID format! Please input 9 numbers");
					else if (tfPhoneNumber.getText().length()<9 || tfPhoneNumber.getText().length()>10)
						JOptionPane.showMessageDialog(null, "Invalid Phone Number! Please input 9/10 numbers");
					else if (!tfPhoneNumber.getText().startsWith("05"))
						JOptionPane.showMessageDialog(null, "Invalid Phone Number! A valid phone number begins with 05");
					else if (patientExists)
						JOptionPane.showMessageDialog(null, "Patient " + tfID.getText() + " already exists!");
					else
					{
						if (!contactExists)
						{
							Object[] options1 = {"Yes","No"};
							int n1 = JOptionPane.showOptionDialog(null, "Contact not found, would you like to add him/her?","Add Contact",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[1]);
							if (n1==0)
							{
								firstName = tfFirstName.getText();
								surName = tfSurName.getText();
								id = tfID.getText();
								city = tfCity.getText();
								street = tfStreet.getText();
								birthday = ((JTextField)birthDate.getDateEditor().getUiComponent()).getText();
								phoneNumber = tfPhoneNumber.getText();
								contactID = tfContactID.getText();
								bloodType = cbBloodType.getSelectedItem().toString();
								careFacility = cbCareFacility.getSelectedItem().toString();
								if (radioButtonFemale.isSelected())
									gender = radioButtonFemale.getText();
								else
									gender = radioButtonMale.getText();
								titleAddPerson.setText("Add Contact");
								tfFirstName.setText("");
							    tfSurName.setText("");
							    tfID.setText(contactID);
								tfID.setEnabled(false);
							    tfCity.setText("");
							    tfStreet.setText("");
							    ((JTextField)birthDate.getDateEditor().getUiComponent()).setText("");
							    tfPhoneNumber.setText("");
							    tfContactID.setText("");
							    panel_10.setVisible(false);
							    panel_10.setEnabled(false);
							    cbBloodType.setSelectedIndex(0);
							    cbCareFacility.setSelectedIndex(0);
							    radioButtonFemale.setSelected(true);
							    radioButtonMale.setSelected(false);
							    contactSwitch = true;
							}
                            
						}
						else
						{
						Date bday =  new java.sql.Date(birthDate.getDate().getTime());
					if (radioButtonFemale.isSelected())
					Logic.getInstance().AddPerson(tfID.getText(), tfFirstName.getText(), tfSurName.getText(),
							bday , tfCity.getText(), tfStreet.getText(), "F" , tfPhoneNumber.getText(), cbBloodType.getSelectedItem().toString(), cbCareFacility.getSelectedItem().toString());
					else
						Logic.getInstance().AddPerson(tfID.getText(), tfFirstName.getText(), tfSurName.getText(),
								bday , tfCity.getText(), tfStreet.getText(), "M" , tfPhoneNumber.getText(), cbBloodType.getSelectedItem().toString(), cbCareFacility.getSelectedItem().toString());
					    Logic.getInstance().AddPatient(tfID.getText());
					    JOptionPane.showMessageDialog(null, tfFirstName.getText() + " " + tfSurName.getText() + " has successfully been added as a Patient!");
					    mm.getViewP().refreshComp();
					    tfFirstName.setText("");
					    tfSurName.setText("");
					    tfID.setText("");
					    tfCity.setText("");
					    tfStreet.setText("");
					    ((JTextField)birthDate.getDateEditor().getUiComponent()).setText("");
					    tfPhoneNumber.setText("");
					    tfContactID.setText("");
					    tfContactID.setEnabled(true);
					    cbBloodType.setSelectedIndex(0);
					    cbCareFacility.setSelectedIndex(0);
						}
					}		
				}
			  }
				else
				{
					Object[] options = {"Yes","No"};
					int n = JOptionPane.showOptionDialog(null, "Are you sure you want to add the contact?","Add Contact",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[1]);
					if (n==0)
					{
						if (tfID.getText().length()!=9)
							JOptionPane.showMessageDialog(null, "Invalid ID format! Please input 9 numbers");
						else if (tfPhoneNumber.getText().length()<9 || tfPhoneNumber.getText().length()>10)
							JOptionPane.showMessageDialog(null, "Invalid Phone Number! Please input 9/10 numbers");
						else if (!tfPhoneNumber.getText().startsWith("05"))
							JOptionPane.showMessageDialog(null, "Invalid Phone Number! A valid phone number begins with 05");
						else if (Calendar.getInstance().getTime().getYear()-birthDate.getDate().getYear()<16)
							JOptionPane.showMessageDialog(null, "The contact must be at least 16 years old!");
						else
						{
							Date bday =  new java.sql.Date(birthDate.getDate().getTime());
						if (radioButtonFemale.isSelected())
						Logic.getInstance().AddPerson(tfID.getText(), tfFirstName.getText(), tfSurName.getText(),
								bday , tfCity.getText(), tfStreet.getText(), "F" , tfPhoneNumber.getText(), cbBloodType.getSelectedItem().toString(), cbCareFacility.getSelectedItem().toString());
						else
							Logic.getInstance().AddPerson(tfID.getText(), tfFirstName.getText(), tfSurName.getText(),
									bday , tfCity.getText(), tfStreet.getText(), "M" , tfPhoneNumber.getText(), cbBloodType.getSelectedItem().toString(), cbCareFacility.getSelectedItem().toString());
						    JOptionPane.showMessageDialog(null, tfFirstName.getText() + " " + tfSurName.getText() + " has successfully been added as a contact!");
						    titleAddPerson.setText("Add Person");
						    tfFirstName.setText(firstName);
						    tfSurName.setText(surName);
						    tfID.setText(id);
						    tfID.setEnabled(true);
						    tfCity.setText(city);
						    tfStreet.setText(street);
						    ((JTextField)birthDate.getDateEditor().getUiComponent()).setText(birthday);
						    tfPhoneNumber.setText(phoneNumber);
						    tfContactID.setText(contactID);
						    panel_10.setVisible(true);
						    tfContactID.setEnabled(false);
						    cbBloodType.setSelectedItem(bloodType);
						    cbCareFacility.setSelectedItem(careFacility);
						    if (gender.equals("F")){
						    radioButtonFemale.setSelected(true);
						    radioButtonMale.setSelected(false);
						    }
						    else if (gender.equals("M")){
						    	radioButtonMale.setSelected(true);
						    	radioButtonFemale.setSelected(false);
						    }
						    
						    contactSwitch = false;   
						}		
					}
				}
			}
		});
		
       mm.getBtnView().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Panel_add_Patient.this.setVisible(false);
				
			}
		});
		
		DocumentListener docListener = new DocumentListener() {
			@Override
			public void changedUpdate(DocumentEvent arg0) {
				emptyFields(tfFirstName, tfSurName, tfID, tfCity, tfStreet, birthDate, radioButtonFemale, radioButtonMale, tfPhoneNumber, buttonAdd);
				
			}
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				emptyFields(tfFirstName, tfSurName, tfID, tfCity, tfStreet, birthDate, radioButtonFemale, radioButtonMale, tfPhoneNumber, buttonAdd);
				
			}
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				emptyFields(tfFirstName, tfSurName, tfID, tfCity, tfStreet, birthDate, radioButtonFemale, radioButtonMale, tfPhoneNumber, buttonAdd);
				
			}
        };
         
tfFirstName.getDocument().addDocumentListener(docListener);
tfSurName.getDocument().addDocumentListener(docListener);
tfID.getDocument().addDocumentListener(docListener);
tfCity.getDocument().addDocumentListener(docListener);
tfStreet.getDocument().addDocumentListener(docListener);
((JTextField)birthDate.getDateEditor().getUiComponent()).getDocument().addDocumentListener(docListener);
tfPhoneNumber.getDocument().addDocumentListener(docListener);

	}
	
	public void emptyFields(JTextArea firstName, JTextArea surName, JTextArea id, JTextArea city, JTextArea street, JDateChooser birthDate, JRadioButton female, JRadioButton male, JTextArea phone, JButton add)
	{
		String birthDateText = ((JTextField)birthDate.getDateEditor().getUiComponent()).getText();
		Color birthDateColor = ((JTextField)birthDate.getDateEditor().getUiComponent()).getForeground();
		if (female.isSelected() || male.isSelected())
			if (firstName.getText().equals("") || surName.getText().equals("") || id.getText().equals("") || city.getText().equals("") || street.getText().equals("") ||
					birthDateText.length()<2 || birthDateColor.equals(Color.red) || phone.getText().equals(""))
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
}
