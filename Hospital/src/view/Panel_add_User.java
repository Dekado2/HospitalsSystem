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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;

import controller.Logic;
import model.Department;
import model.Doctor;
import model.Hospital;

import java.awt.BorderLayout;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Panel_add_User extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Panel_add_User(MainMenu mm) {
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 765, 39);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblAddPerson = new JLabel("Add User");
		lblAddPerson.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblAddPerson.setForeground(new Color(25, 25, 112));
		lblAddPerson.setBounds(46, 6, 207, 33);
		panel.add(lblAddPerson);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(47, 67, 315, 26);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblName = new JLabel("Username:");
		lblName.setBounds(0, 0, 129, 17);
		panel_1.add(lblName);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JTextArea tfUserName = new JTextArea();
		tfUserName.setFont(new Font("Arial", Font.PLAIN, 14));
		tfUserName.setBounds(134, 4, 170, 15);
		panel_1.add(tfUserName);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(131, 24, 173, 2);
		panel_1.add(separator);
		
		JPanel panel_13 = new JPanel();
		panel_13.setLayout(null);
		panel_13.setBackground(Color.WHITE);
		panel_13.setBounds(47, 161, 298, 26);
		add(panel_13);
		
		JLabel lblHospitalId = new JLabel("User Type:");
		lblHospitalId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHospitalId.setBounds(0, -1, 120, 17);
		panel_13.add(lblHospitalId);
		
		JComboBox<String> cbUserType = new JComboBox<String>();
		cbUserType.setModel(new DefaultComboBoxModel(new String[] {"admin", "secretary", "doctor"}));
		cbUserType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbUserType.setBackground(Color.WHITE);
		cbUserType.setBounds(151, -1, 120, 26);
		panel_13.add(cbUserType);
		
		JPanel panel_15 = new JPanel();
		panel_15.setLayout(null);
		panel_15.setBackground(Color.WHITE);
		panel_15.setBounds(47, 211, 448, 26);
		add(panel_15);
		
		JLabel lblDepartmentId = new JLabel("Secret Question:");
		lblDepartmentId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDepartmentId.setBounds(0, -1, 160, 17);
		panel_15.add(lblDepartmentId);
		
		JComboBox<String> cbSecretQuestion = new JComboBox<String>();
		cbSecretQuestion.setModel(new DefaultComboBoxModel(new String[] {"What is your favorite movie?", "What is your favorite color?", "Where were you born?", "What is your favorite plant?"}));
		cbSecretQuestion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbSecretQuestion.setBackground(Color.WHITE);
		cbSecretQuestion.setBounds(154, -1, 286, 26);
		panel_15.add(cbSecretQuestion);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(413, 115, 352, 26);
		add(panel_2);
		
		JLabel lblBedsAmount = new JLabel("Display Surname:");
		lblBedsAmount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBedsAmount.setBounds(10, 0, 156, 17);
		panel_2.add(lblBedsAmount);
		
		JTextArea tfSurname = new JTextArea();
		tfSurname.setFont(new Font("Arial", Font.PLAIN, 14));
		tfSurname.setBounds(172, 0, 170, 15);
		panel_2.add(tfSurname);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(169, 20, 173, 2);
		panel_2.add(separator_1);
		
		cbUserType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		cbSecretQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		
		
		JButton addButton = new JButton("Add");
		addButton.setIcon(new ImageIcon(Panel_add_User.class.getResource("/view/icons/add.png")));
		addButton.setEnabled(false);
		addButton.setForeground(new Color(255, 255, 255));
		
		addButton.setBackground(Color.LIGHT_GRAY);
		addButton.setBounds(324, 318, 129, 41);
		add(addButton);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(413, 67, 352, 26);
		add(panel_3);
		
		JLabel lblDisplayFirstName = new JLabel("Display First Name:");
		lblDisplayFirstName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDisplayFirstName.setBounds(10, 0, 156, 17);
		panel_3.add(lblDisplayFirstName);
		
		JTextArea tfFirstName = new JTextArea();
		tfFirstName.setFont(new Font("Arial", Font.PLAIN, 14));
		tfFirstName.setBounds(172, 0, 170, 15);
		panel_3.add(tfFirstName);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(169, 20, 173, 2);
		panel_3.add(separator_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(47, 113, 315, 26);
		add(panel_4);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(0, 0, 129, 17);
		panel_4.add(lblPassword);
		
		JTextArea tfPassword = new JTextArea();
		tfPassword.setFont(new Font("Arial", Font.PLAIN, 14));
		tfPassword.setBounds(134, 4, 170, 15);
		panel_4.add(tfPassword);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(131, 24, 173, 2);
		panel_4.add(separator_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(47, 259, 437, 26);
		add(panel_5);
		
		JLabel lblSecretAnswer = new JLabel("Secret Answer:");
		lblSecretAnswer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSecretAnswer.setBounds(0, 0, 141, 17);
		panel_5.add(lblSecretAnswer);
		
		JTextArea tfSecretAnswer = new JTextArea();
		tfSecretAnswer.setFont(new Font("Arial", Font.PLAIN, 14));
		tfSecretAnswer.setBounds(144, 4, 283, 15);
		panel_5.add(tfSecretAnswer);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(144, 24, 283, 2);
		panel_5.add(separator_4);

		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean bool,boolDoc;
				Object[] options = {"Yes","No"};
				int n = JOptionPane.showOptionDialog(null, "Are you sure you want to add the User?","Add User",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[1]);
				if (n==0)
				{
						bool = Logic.getInstance().userExistsByUserName(tfUserName.getText());
						boolDoc = Logic.getInstance().DoctorExists(tfUserName.getText());
					 if (bool==true)
						JOptionPane.showMessageDialog(null, "User " + tfUserName.getText() + " already exists!");
					 else if (bool==false && cbUserType.getSelectedItem().toString().equals("doctor") && boolDoc==false)
						 JOptionPane.showMessageDialog(null, "                                Doctor " + tfUserName.getText() + " doesn't exist!\nYou must first add him as a doctor before you can create him a user!");
					 else if (bool==false && !cbUserType.getSelectedItem().toString().equals("doctor") && boolDoc==true)
							JOptionPane.showMessageDialog(null, "User " + tfUserName.getText() + " is a doctor and so must be his/her user type!");
					 else if (bool==false && cbUserType.getSelectedItem().toString().equals("doctor") && boolDoc==true)
					 {
						 Doctor doc = Logic.getInstance().getDoctorDetails(tfUserName.getText());
						 if (doc.isManager()==false)
							 JOptionPane.showMessageDialog(null, "Doctor " + tfUserName.getText() + " is not a manager!");
						 else
						 {
							 Logic.getInstance().AddUser(tfUserName.getText(), tfPassword.getText() , tfFirstName.getText() , tfSurname.getText(), cbUserType.getSelectedItem().toString(), cbSecretQuestion.getSelectedItem().toString(), tfSecretAnswer.getText());
								JOptionPane.showMessageDialog(null, "User " + tfUserName.getText() + " has successfully been added!");
								mm.getViewUsers().refreshComp();
								tfUserName.setText("");
								tfPassword.setText("");
								tfFirstName.setText("");						
								tfSurname.setText("");
							    cbUserType.setSelectedIndex(0);
							    cbSecretQuestion.setSelectedIndex(0);
							    tfSecretAnswer.setText("");
						 }
					 }
					else if(bool==false)
					{
						Logic.getInstance().AddUser(tfUserName.getText(), tfPassword.getText() , tfFirstName.getText() , tfSurname.getText(), cbUserType.getSelectedItem().toString(), cbSecretQuestion.getSelectedItem().toString(), tfSecretAnswer.getText());
						JOptionPane.showMessageDialog(null, "User " + tfUserName.getText() + " has successfully been added!");
						mm.getViewUsers().refreshComp();
						tfUserName.setText("");
						tfPassword.setText("");
						tfFirstName.setText("");						
						tfSurname.setText("");
					    cbUserType.setSelectedIndex(0);
					    cbSecretQuestion.setSelectedIndex(0);
					    tfSecretAnswer.setText("");
					}
				 }
		      }					
		});
		
        mm.getBtnView().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Panel_add_User.this.setVisible(false);
				
			}
		});
		
		DocumentListener docListener = new DocumentListener() {
			@Override
			public void changedUpdate(DocumentEvent arg0) {
				emptyFields(tfUserName, tfPassword, tfFirstName, tfSurname, tfSecretAnswer, addButton);	
			}
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				emptyFields(tfUserName, tfPassword, tfFirstName, tfSurname, tfSecretAnswer, addButton);	
			}
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				emptyFields(tfUserName, tfPassword, tfFirstName, tfSurname, tfSecretAnswer, addButton);	
			}
        };  
        
tfUserName.getDocument().addDocumentListener(docListener);
tfPassword.getDocument().addDocumentListener(docListener);
tfFirstName.getDocument().addDocumentListener(docListener);
tfSurname.getDocument().addDocumentListener(docListener);
tfSecretAnswer.getDocument().addDocumentListener(docListener);
		
	}
	
	public void emptyFields(JTextArea userName, JTextArea password, JTextArea firstName, JTextArea surname, JTextArea secretAnswer, JButton add)
	{
			if (userName.getText().length()<4 || password.getText().length()<4 || firstName.getText().equals("") || surname.getText().equals("")
					|| secretAnswer.getText().equals(""))
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
