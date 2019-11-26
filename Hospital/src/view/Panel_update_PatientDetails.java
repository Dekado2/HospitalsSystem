package view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;

import controller.Logic;
import model.Patient;

import java.awt.BorderLayout;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Panel_update_PatientDetails extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea txtFName;
	private JTextArea textSurName;
	private JTextArea textID;
	private JTextArea textCity;
	private JTextArea textStreet;
	private JRadioButton rdbtnF;
	private JRadioButton rdbtnM;
	private JComboBox comboBox_BloodT;
	private JComboBox comboBox_CareFacility;
	private JTextArea textContact ;
	private JTextArea textPhone;
	private JDateChooser dateChooser;
	private Panel_View_Patient upPatient;
	private String ptID;
	private JButton btnBack;
	private JButton btnUpdate;
	private Panel_View_Patient updateP;
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
	boolean contactSwitch=false;
	boolean contactExists;



	/**
	 * Create the panel.
	 */
	public Panel_update_PatientDetails(String ptID, MainMenu mm) {
		setFont(new Font("Tahoma", Font.PLAIN, 20));
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		this.ptID=ptID;
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 765, 39);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblUpdatePerson = new JLabel("Update Patient");
		lblUpdatePerson.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblUpdatePerson.setForeground(new Color(25, 25, 112));
		lblUpdatePerson.setBounds(46, 6, 207, 33);
		panel.add(lblUpdatePerson);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(47, 67, 268, 26);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblName = new JLabel("First Name:");
		lblName.setBounds(0, 0, 102, 17);
		panel_1.add(lblName);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		txtFName = new JTextArea();
		txtFName.setFont(new Font("Arial", Font.PLAIN, 14));
		txtFName.setBounds(98, 4, 170, 15);
		panel_1.add(txtFName);
		
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
		
		textSurName = new JTextArea();
		textSurName.setFont(new Font("Arial", Font.PLAIN, 14));
		textSurName.setBounds(98, 4, 170, 15);
		panel_2.add(textSurName);
		
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
		
		textID = new JTextArea();
		textID.setFont(new Font("Arial", Font.PLAIN, 14));
		textID.setBounds(98, 4, 170, 15);
		panel_3.add(textID);
		
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
		
		textCity = new JTextArea();
		textCity.setFont(new Font("Arial", Font.PLAIN, 14));
		textCity.setBounds(98, 4, 170, 15);
		panel_4.add(textCity);
		
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
		
		textStreet = new JTextArea();
		textStreet.setFont(new Font("Arial", Font.PLAIN, 14));
		textStreet.setBounds(98, 4, 170, 15);
		panel_5.add(textStreet);
		
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
		
		rdbtnF = new JRadioButton("F");
		rdbtnF.setBackground(new Color(255, 255, 255));
		rdbtnF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnF.setBounds(77, 0, 62, 39);
		panel_7.add(rdbtnF);
		
		rdbtnM = new JRadioButton("M");
		rdbtnM.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnM.setBackground(Color.WHITE);
		rdbtnM.setBounds(161, 0, 62, 39);
		panel_7.add(rdbtnM);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBackground(Color.WHITE);
		panel_8.setBounds(399, 108, 340, 26);
		add(panel_8);
		
		JLabel lblBloodType = new JLabel("Blood Type:");
		lblBloodType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBloodType.setBounds(0, 0, 134, 17);
		panel_8.add(lblBloodType);
		
		comboBox_BloodT = new JComboBox();
		comboBox_BloodT.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "O", "AB"}));
		comboBox_BloodT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox_BloodT.setToolTipText("A\r\nB\r\nO\r\nAB");
		comboBox_BloodT.setBackground(new Color(255, 255, 255));
		comboBox_BloodT.setBounds(149, 0, 165, 26);
		panel_8.add(comboBox_BloodT);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBackground(Color.WHITE);
		panel_9.setBounds(399, 147, 340, 26);
		add(panel_9);
		
		JLabel lblCareFacility = new JLabel("Care Facility:");
		lblCareFacility.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCareFacility.setBounds(0, -1, 123, 17);
		panel_9.add(lblCareFacility);
		
		comboBox_CareFacility = new JComboBox();
		comboBox_CareFacility.setModel(new DefaultComboBoxModel(new String[] {"\u05DB\u05DC\u05DC\u05D9\u05EA", "\u05DC\u05D0\u05D5\u05DE\u05D9\u05EA", "\u05DE\u05D0\u05D5\u05D7\u05D3\u05EA", "\u05DE\u05DB\u05D1\u05D9"}));
		
		comboBox_CareFacility.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox_CareFacility.setBackground(Color.WHITE);
		comboBox_CareFacility.setBounds(149, 0, 165, 26);
		panel_9.add(comboBox_CareFacility);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBackground(Color.WHITE);
		panel_10.setBounds(399, 190, 340, 26);
		add(panel_10);
		
		JLabel lblContactId = new JLabel("Contact ID:");
		lblContactId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContactId.setBounds(0, -1, 109, 17);
		panel_10.add(lblContactId);
		
		textContact = new JTextArea();
		textContact.setFont(new Font("Arial", Font.PLAIN, 14));
		textContact.setBounds(155, 4, 170, 15);
		panel_10.add(textContact);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(152, 24, 173, 2);
		panel_10.add(separator_6);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(399, 230, 340, 26);
		add(panel_6);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPhone.setBounds(0, -1, 91, 17);
		panel_6.add(lblPhone);
		
		textPhone = new JTextArea();
		textPhone.setFont(new Font("Arial", Font.PLAIN, 14));
		textPhone.setBounds(155, 4, 170, 15);
		panel_6.add(textPhone);
		
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
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(115, 0, 177, 39);
		panel_11.add(dateChooser);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setIcon(new ImageIcon(Panel_update_PatientDetails.class.getResource("/view/icons/refresh-arrows.png")));
		btnUpdate.setBackground(new Color(70, 130, 180));
		btnUpdate.setBounds(597, 339, 120, 41);
		add(btnUpdate);
		textID.setEditable(false);
		if(!textID.isEditable())
			textID.setForeground(Color.gray);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			if (!contactSwitch)
			{
			Object[] options = {"Yes","No"};
			int n = JOptionPane.showOptionDialog(null, "Are you sure you want to update the patient?","Update Patient",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[1]);
			if (n==0)
			{
				contactExists = true;
				
		
				if (textID.getText().length()==9)
				    contactExists = Logic.getInstance().ContactExists(textContact.getText());
				if (textID.getText().length()!=9)
					JOptionPane.showMessageDialog(null, "Invalid ID format! Please input 9 numbers");
				else if (textContact.getText().length()>0 && textContact.getText().length()!=9)
					JOptionPane.showMessageDialog(null, "Invalid Contact ID format! Please input 9 numbers");
				else if (textPhone.getText().length()<9 || textPhone.getText().length()>10)
					JOptionPane.showMessageDialog(null, "Invalid Phone Number! Please input 9/10 numbers");
	
				else
				{
					if (!contactExists && !textContact.getText().equals(""))
					{
						Object[] options1 = {"Yes","No"};
						int n1 = JOptionPane.showOptionDialog(null, "Contact not found, would you like to add him/her?","Add Contact",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[1]);
						if (n1==0)
						{
							firstName = txtFName.getText();
							surName = textSurName.getText();
							id = textID.getText();
							city = textCity.getText();
							street = textStreet.getText();
							birthday = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
							phoneNumber = textPhone.getText();
							contactID = textContact.getText();
							bloodType = comboBox_BloodT.getSelectedItem().toString();
							careFacility = comboBox_CareFacility.getSelectedItem().toString();
							if (rdbtnF.isSelected())
								gender = rdbtnF.getText();
							else
								gender = rdbtnM.getText();
							lblUpdatePerson.setText("Add Contact");
							btnUpdate.setText("Add");
							btnUpdate.setIcon(new ImageIcon(Panel_update_PatientDetails.class.getResource("/view/icons/add.png")));
							txtFName.setText("");
							textSurName.setText("");
							textID.setText(contactID);
							textID.setEnabled(false);
							textCity.setText("");
							textStreet.setText("");
						    ((JTextField)dateChooser.getDateEditor().getUiComponent()).setText("");
						    textPhone.setText("");
						    textContact.setText("");
						    panel_10.setVisible(false);
						    panel_10.setEnabled(false);
						    comboBox_BloodT.setSelectedIndex(0);
						    comboBox_CareFacility.setSelectedIndex(0);
						    rdbtnF.setSelected(true);
						    rdbtnM.setSelected(false);
						    contactSwitch = true;
						}
				
				
                        // change title to add contact, make variables to take previous values of patient and clear them to add contact, then return patient values and set contact id
					}
					else if (!contactExists && textContact.getText().equals("")) {
						
						Date bday =  new java.sql.Date(dateChooser.getDate().getTime());
						if (rdbtnF.isSelected())
						Logic.getInstance().UpdatePerson(textID.getText(), txtFName.getText(), textSurName.getText(),
								bday , textCity.getText(), textStreet.getText(), "F" , textPhone.getText(), comboBox_BloodT.getSelectedItem().toString(), comboBox_CareFacility.getSelectedItem().toString(),null);
						else
							Logic.getInstance().UpdatePerson(textID.getText(), txtFName.getText(), textSurName.getText(),
								bday  , textCity.getText(), textStreet.getText(), "M" , textPhone.getText(), comboBox_BloodT.getSelectedItem().toString(), comboBox_CareFacility.getSelectedItem().toString(),null);
						    JOptionPane.showMessageDialog(null, txtFName.getText() + " " + textSurName.getText() + " has successfully been updated!");
						    mm.getViewP().setVisible(true);
						    mm.getViewP().refreshComp();
							Panel_update_PatientDetails.this.setVisible(false);
						
					}
					else
					{
					Date bday =  new java.sql.Date(dateChooser.getDate().getTime());
				if (rdbtnF.isSelected())
				Logic.getInstance().UpdatePerson(textID.getText(), txtFName.getText(), textSurName.getText(),
						bday , textCity.getText(), textStreet.getText(), "F" , textPhone.getText(), comboBox_BloodT.getSelectedItem().toString(), comboBox_CareFacility.getSelectedItem().toString(),textContact.getText());
				else
					Logic.getInstance().UpdatePerson(textID.getText(), txtFName.getText(), textSurName.getText(),
							bday , textCity.getText(), textStreet.getText(), "M" , textPhone.getText(), comboBox_BloodT.getSelectedItem().toString(), comboBox_CareFacility.getSelectedItem().toString(),textContact.getText());
				    
				    JOptionPane.showMessageDialog(null, txtFName.getText() + " " + textSurName.getText() + " has successfully been updated!");
				    mm.getViewP().setVisible(true);
				    mm.getViewP().refreshComp();
					Panel_update_PatientDetails.this.setVisible(false);
				
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
					if (textID.getText().length()!=9)
						JOptionPane.showMessageDialog(null, "Invalid ID format! Please input 9 numbers");
					else if (textPhone.getText().length()<9 || textPhone.getText().length()>10)
						JOptionPane.showMessageDialog(null, "Invalid Phone Number! Please input 9/10 numbers");
					else if (Calendar.getInstance().getTime().getYear()-dateChooser.getDate().getYear()<16)
						JOptionPane.showMessageDialog(null, "The contact must be at least 16 years old!");
					else
					{
						Date bday =  new java.sql.Date(dateChooser.getDate().getTime());
					if (rdbtnF.isSelected())
					Logic.getInstance().AddPerson(textID.getText(), txtFName.getText(), textSurName.getText(),
							bday , textCity.getText(), textStreet.getText(), "F" , textPhone.getText(), comboBox_BloodT.getSelectedItem().toString(), comboBox_CareFacility.getSelectedItem().toString());
					else
						Logic.getInstance().AddPerson(textID.getText(), txtFName.getText(), textSurName.getText(),
								bday , textCity.getText(), textStreet.getText(), "M" , textPhone.getText(), comboBox_BloodT.getSelectedItem().toString(), comboBox_CareFacility.getSelectedItem().toString());
					    JOptionPane.showMessageDialog(null, txtFName.getText() + " " + textSurName.getText() + " has successfully been added as a contact!");
					    lblUpdatePerson.setText("Add Person");
					  
					    txtFName.setText(firstName);
					    textSurName.setText(surName);
					    textID.setText(id);
					    textID.setEnabled(true);
					    textCity.setText(city);
					    textStreet.setText(street);
					    ((JTextField)dateChooser.getDateEditor().getUiComponent()).setText(birthday);
					    textPhone.setText(phoneNumber);
					    textContact.setText(contactID);
					    panel_10.setVisible(true);
					    textContact.setEnabled(false);
					    comboBox_BloodT.setSelectedItem(bloodType);
					    comboBox_CareFacility.setSelectedItem(careFacility);
					    if (gender.equals("F")){
					    	rdbtnF.setSelected(true);
					    	rdbtnM.setSelected(false);
					    }
					    else if (gender.equals("M")){
					    	rdbtnM.setSelected(true);
					    	rdbtnF.setSelected(false);
					    }
					    
					    contactSwitch = false;   
					}		
				}
			}
		}
	});
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mm.getViewP().setVisible(true);
				 
				mm.getViewP().refreshComp();
				Panel_update_PatientDetails.this.setVisible(false);
			}
		});
	
     mm.getBtnAdd().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Panel_update_PatientDetails.this.setVisible(false);
				
			}
		});
		
		btnBack.setIcon(new ImageIcon(Panel_update_PatientDetails.class.getResource("/view/icons/back-arrow.png")));
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(new Color(70, 130, 180));
		btnBack.setBounds(454, 339, 120, 41);
		add(btnBack);
		
		if (ptID!=null)
		fetch();

	}
	private void fetch() {
		
		Patient p=Logic.getInstance().getPatientDetails(this.ptID);

		if (p.getId()!=null)
		{
			txtFName.setText(p.getFirstName());
			textSurName.setText(p.getSurName());
			textID.setText(p.getId());
			textCity.setText(p.getCity());
			textStreet.setText(p.getStreet());
			textPhone.setText(p.getPhoneNumber());
			dateChooser.setDate(p.getDateOfBirth());
			if(p.getContact()!=null)
				textContact.setText(p.getContact().getId());
			if(p.getGender().equals("F"))
				rdbtnF.setSelected(true);
			if(p.getGender().equals("M"))
				rdbtnM.setSelected(true);
			comboBox_BloodT.setSelectedItem(p.getBloodType());
			comboBox_CareFacility.setSelectedItem(p.getCareFacility());
			
		/*	btnBack.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					updateP=new Panel_Update_Patient();
					MainMenu.getContentPane().add(updateP);
					updateP.setEnabled(true);
					updateP.setVisible(true);
					updateP.refreshComp();
				}
			});*/
		}
	}
	public JTextArea getTxtFName() {
		return txtFName;
	}


	public JTextArea getTextSurName() {
		return textSurName;
	}

	public void setTextSurName(JTextArea textSurName) {
		this.textSurName = textSurName;
	}

	public JTextArea getTextID() {
		return textID;
	}



	public JTextArea getTextCity() {
		return textCity;
	}



	public JTextArea getTextStreet() {
		return textStreet;
	}

	public void setTextStreet(JTextArea textStreet) {
		this.textStreet = textStreet;
	}

	public JRadioButton getRdbtnF() {
		return rdbtnF;
	}

	public void setRdbtnF(JRadioButton rdbtnF) {
		this.rdbtnF = rdbtnF;
	}

	public JRadioButton getRdbtnM() {
		return rdbtnM;
	}

	public void setRdbtnM(JRadioButton rdbtnM) {
		this.rdbtnM = rdbtnM;
	}

	public JComboBox<String> getComboBox_BloodT() {
		return comboBox_BloodT;
	}

	public void setComboBox_BloodT(JComboBox comboBox_BloodT) {
		this.comboBox_BloodT = comboBox_BloodT;
	}

	public JComboBox<String> getComboBox_CareFacility() {
		return comboBox_CareFacility;
	}

	public void setComboBox_CareFacility(JComboBox comboBox_CareFacility) {
		this.comboBox_CareFacility = comboBox_CareFacility;
	}

	public JTextArea getTextContact() {
		return textContact;
	}



	public JTextArea getTextPhone() {
		return textPhone;
	}

	public void setTextPhone(JTextArea textPhone) {
		this.textPhone = textPhone;
	}
	public JButton getBtnBack() {
		return btnBack;
	}
	public JButton getBtnUpdate() {
		return btnUpdate;
	}
	
	
}
