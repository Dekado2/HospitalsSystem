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

public class Panel_add_Room extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Hospital> hospitals;

	/**
	 * Create the panel.
	 */
	public Panel_add_Room(MainMenu mm) {
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 765, 39);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblAddPerson = new JLabel("Add Room\r\n");
		lblAddPerson.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblAddPerson.setForeground(new Color(25, 25, 112));
		lblAddPerson.setBounds(46, 6, 207, 33);
		panel.add(lblAddPerson);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(47, 67, 315, 26);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblName = new JLabel("Room Number:");
		lblName.setBounds(0, 0, 129, 17);
		panel_1.add(lblName);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JTextArea tfRoomNumber = new JTextArea();
		tfRoomNumber.setFont(new Font("Arial", Font.PLAIN, 14));
		tfRoomNumber.setBounds(134, 4, 170, 15);
		panel_1.add(tfRoomNumber);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(131, 24, 173, 2);
		panel_1.add(separator);
		
		JPanel panel_13 = new JPanel();
		panel_13.setLayout(null);
		panel_13.setBackground(Color.WHITE);
		panel_13.setBounds(47, 103, 298, 26);
		add(panel_13);
		
		JLabel lblHospitalId = new JLabel("Hospital Name:");
		lblHospitalId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHospitalId.setBounds(0, -1, 120, 17);
		panel_13.add(lblHospitalId);
		
		JComboBox<String> cbHospitalName = new JComboBox<String>();
		cbHospitalName.setToolTipText("A\r\nB\r\nO\r\nAB");
		cbHospitalName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbHospitalName.setBackground(Color.WHITE);
		cbHospitalName.setBounds(151, -1, 112, 26);
		panel_13.add(cbHospitalName);
		
		JPanel panel_15 = new JPanel();
		panel_15.setLayout(null);
		panel_15.setBackground(Color.WHITE);
		panel_15.setBounds(47, 138, 315, 26);
		add(panel_15);
		
		JLabel lblDepartmentId = new JLabel("Department Name:");
		lblDepartmentId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDepartmentId.setBounds(0, -1, 160, 17);
		panel_15.add(lblDepartmentId);
		
		JComboBox<String> cbDepartmentName = new JComboBox<String>();
		cbDepartmentName.setToolTipText("A\r\nB\r\nO\r\nAB");
		cbDepartmentName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbDepartmentName.setBackground(Color.WHITE);
		cbDepartmentName.setBounds(154, -1, 151, 26);
		panel_15.add(cbDepartmentName);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(47, 175, 315, 26);
		add(panel_2);
		
		JLabel lblBedsAmount = new JLabel("Beds Amount:");
		lblBedsAmount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBedsAmount.setBounds(0, 0, 129, 17);
		panel_2.add(lblBedsAmount);
		
		JTextArea tfBedsAmount = new JTextArea();
		tfBedsAmount.setFont(new Font("Arial", Font.PLAIN, 14));
		tfBedsAmount.setBounds(134, 4, 170, 15);
		panel_2.add(tfBedsAmount);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(131, 24, 173, 2);
		panel_2.add(separator_1);
		
		JTextArea dep = new JTextArea();
		
		JComboBox<String> cbHospitalID = new JComboBox<String>();
		cbHospitalID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbHospitalID.setBackground(Color.WHITE);
		cbHospitalID.setBounds(47, 397, 115, 26);
		add(cbHospitalID);
		cbHospitalID.setVisible(false);
		
		JComboBox<String> cbDepartmentID = new JComboBox<String>();
		cbDepartmentID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbDepartmentID.setBackground(Color.WHITE);
		cbDepartmentID.setBounds(230, 397, 155, 26);
		add(cbDepartmentID);
		cbDepartmentID.setVisible(false);
		
		hospitals = Logic.getInstance().getHospitals();
		for (int i=0; i<hospitals.size();i++)
			cbHospitalName.insertItemAt(hospitals.get(i).getName(), i);
		for (int i=0; i<hospitals.size();i++)
			cbHospitalID.insertItemAt(hospitals.get(i).getHospitalID(), i);
		
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
		
		
		
		JButton addButton = new JButton("Add");
		addButton.setIcon(new ImageIcon(Panel_add_Room.class.getResource("/view/icons/add.png")));
		addButton.setEnabled(false);
		addButton.setForeground(new Color(255, 255, 255));
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean bool;
				Object[] options = {"Yes","No"};
				int n = JOptionPane.showOptionDialog(null, "Are you sure you want to add the room?","Add Room",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[1]);
				if (n==0)
				{
					try {
						Integer.valueOf(tfBedsAmount.getText());
						Integer.valueOf(tfRoomNumber.getText());
						bool = Logic.getInstance().RoomExists(cbHospitalID.getSelectedItem().toString(), cbDepartmentID.getSelectedItem().toString(), tfRoomNumber.getText());
					if (Integer.valueOf(tfBedsAmount.getText())<=0)
                        JOptionPane.showMessageDialog(null, "Beds amount must be a number above 0");
					else if (bool==true)
						JOptionPane.showMessageDialog(null, "Room " + tfRoomNumber.getText() + " already exists in the selected department!");
					else
					{
						Logic.getInstance().AddRoom(cbHospitalID.getSelectedItem().toString(), cbDepartmentID.getSelectedItem().toString(), tfRoomNumber.getText(), tfBedsAmount.getText());
						JOptionPane.showMessageDialog(null, "Room " + tfRoomNumber.getText() + " has successfully been added!");
						mm.getviewR().refreshComp();
						tfRoomNumber.setText("");
						tfBedsAmount.setText("");
					    cbHospitalName.setSelectedIndex(0);
					}
				 }
					catch (NumberFormatException ex) {
						try {
							Integer.valueOf(tfBedsAmount.getText());
							JOptionPane.showMessageDialog(null, "Room number must be a number!");
						}
						catch (NumberFormatException ex2) {
							JOptionPane.showMessageDialog(null, "Beds amount must be a number!");
						}
					}					
				}
			}
		});
		addButton.setBackground(Color.LIGHT_GRAY);
		addButton.setBounds(193, 285, 129, 41);
		add(addButton);

        mm.getBtnView().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Panel_add_Room.this.setVisible(false);
				
			}
		});
		
		DocumentListener docListener = new DocumentListener() {
			@Override
			public void changedUpdate(DocumentEvent arg0) {
				emptyFields(tfRoomNumber, tfBedsAmount, dep, addButton);
				
			}
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				emptyFields(tfRoomNumber, tfBedsAmount, dep, addButton);
				
			}
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				emptyFields(tfRoomNumber, tfBedsAmount, dep, addButton);
				
			}
        };
dep.getDocument().addDocumentListener(docListener);          
tfRoomNumber.getDocument().addDocumentListener(docListener);
tfBedsAmount.getDocument().addDocumentListener(docListener);
		
	}
	
	public void emptyFields(JTextArea roomNumber, JTextArea bedsAmount, JTextArea dep, JButton add)
	{
			if (roomNumber.getText().equals("") || bedsAmount.getText().equals("") || dep.getText().equals(""))
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
