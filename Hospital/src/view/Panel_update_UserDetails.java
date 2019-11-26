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
import model.Room;
import model.User;

import java.awt.BorderLayout;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Panel_update_UserDetails extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private String userName;
    private JTextArea tfUserName;
    private JTextArea tfPassword;
    private JTextArea tfSecretAnswer;
    private JTextArea tfFirstName;
    private JTextArea tfSurname;
    private JComboBox<String> cbUserType;
    private JComboBox<String> cbSecretQuestion;
    
	/**
	 * Create the panel.
	 */
	public Panel_update_UserDetails(String userName, MainMenu mm) {
		this.userName = userName;
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
		
		tfUserName = new JTextArea();
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
		tfUserName.setText(userName);
		tfUserName.setEnabled(false);
		JLabel lblHospitalId = new JLabel("User Type:");
		lblHospitalId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHospitalId.setBounds(0, -1, 120, 17);
		panel_13.add(lblHospitalId);
		
		cbUserType = new JComboBox<String>();
		cbUserType.setModel(new DefaultComboBoxModel(new String[] {"admin", "secretary", "doctor"}));
		cbUserType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbUserType.setBackground(Color.WHITE);
		cbUserType.setBounds(151, -1, 120, 26);
		panel_13.add(cbUserType);
		cbUserType.setEnabled(false);
		JPanel panel_15 = new JPanel();
		panel_15.setLayout(null);
		panel_15.setBackground(Color.WHITE);
		panel_15.setBounds(47, 211, 448, 26);
		add(panel_15);
		
		JLabel lblDepartmentId = new JLabel("Secret Question:");
		lblDepartmentId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDepartmentId.setBounds(0, -1, 160, 17);
		panel_15.add(lblDepartmentId);
		
		cbSecretQuestion = new JComboBox<String>();
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
		
		tfSurname = new JTextArea();
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
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(413, 67, 352, 26);
		add(panel_3);
		
		JLabel lblDisplayFirstName = new JLabel("Display First Name:");
		lblDisplayFirstName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDisplayFirstName.setBounds(10, 0, 156, 17);
		panel_3.add(lblDisplayFirstName);
		
		tfFirstName = new JTextArea();
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
		
		tfPassword = new JTextArea();
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
		
		tfSecretAnswer = new JTextArea();
		tfSecretAnswer.setFont(new Font("Arial", Font.PLAIN, 14));
		tfSecretAnswer.setBounds(144, 4, 283, 15);
		panel_5.add(tfSecretAnswer);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(144, 24, 283, 2);
		panel_5.add(separator_4);
		
		JButton backButton = new JButton("Back");
		backButton.setIcon(new ImageIcon(Panel_update_UserDetails.class.getResource("/view/icons/back-arrow.png")));
		
		backButton.setForeground(Color.WHITE);
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		backButton.setBackground(new Color(70, 130, 180));
		backButton.setBounds(476, 345, 120, 41);
		add(backButton);
		
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mm.getViewUsers().setVisible(true);
				Panel_update_UserDetails.this.setVisible(false);
			}
		});
		
		JButton updateButton = new JButton("Update");
		updateButton.setIcon(new ImageIcon(Panel_update_UserDetails.class.getResource("/view/icons/refresh-arrows.png")));
		
		updateButton.setForeground(Color.WHITE);
		updateButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		updateButton.setEnabled(false);
		updateButton.setBackground(Color.LIGHT_GRAY);
		updateButton.setBounds(608, 345, 120, 41);
		add(updateButton);
		
		
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = {"Yes","No"};
				int n = JOptionPane.showOptionDialog(null, "Are you sure you want to update the user?","Update User",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[1]);
				if (n==0)
				{
					 Logic.getInstance().UpdateUser(tfUserName.getText(), tfPassword.getText() , tfFirstName.getText() , tfSurname.getText(), cbUserType.getSelectedItem().toString(), cbSecretQuestion.getSelectedItem().toString(), tfSecretAnswer.getText());
						JOptionPane.showMessageDialog(null, "User " + tfUserName.getText() + " has successfully been updated!");
						mm.getViewUsers().setVisible(true);
					    mm.getViewUsers().refreshComp();
						Panel_update_UserDetails.this.setVisible(false);		
				}
			}
		});
		
		if (userName!=null)
			fetch();
		
        mm.getBtnView().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Panel_update_UserDetails.this.setVisible(false);
				
			}
		});
		
		DocumentListener docListener = new DocumentListener() {
			@Override
			public void changedUpdate(DocumentEvent arg0) {
				emptyFields(tfUserName, tfPassword, tfFirstName, tfSurname, tfSecretAnswer, updateButton);	
			}
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				emptyFields(tfUserName, tfPassword, tfFirstName, tfSurname, tfSecretAnswer, updateButton);	
			}
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				emptyFields(tfUserName, tfPassword, tfFirstName, tfSurname, tfSecretAnswer, updateButton);	
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
	
private void fetch() {
		
		User user = Logic.getInstance().getUserDetailsForReset(userName);

		if (userName!=null)
		{
			tfUserName.setText(user.getUsername());
			tfPassword.setText(user.getPassword());
			tfFirstName.setText(user.getDisplayFirstName());
			tfSurname.setText(user.getDisplayLastName());
			cbUserType.setSelectedItem(user.getType());
			cbSecretQuestion.setSelectedItem(user.getSecretQuestion());
			tfSecretAnswer.setText(user.getSecretAnswer());
		}
    }
}
