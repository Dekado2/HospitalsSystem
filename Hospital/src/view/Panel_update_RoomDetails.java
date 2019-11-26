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
import model.Patient;
import model.Room;

import java.awt.BorderLayout;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Panel_update_RoomDetails extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea tfRoomNumber;
	private JTextArea tfBedsAmount;
	private JComboBox<String> cbHospitalName;
	private JComboBox<String> cbDepartmentName;
	private JComboBox<String> cbDepartmentID;
	private JComboBox<String> cbHospitalID;
	private JButton btnBack;
	private String hospitalID;
	private String departID;
	private String roomNumber;
	
	private ArrayList<Hospital> hospitals;

	/**
	 * Create the panel.
	 */
	public Panel_update_RoomDetails(String hospitalID,String departID ,String roomNumber,MainMenu mm) {
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setHospitalID(hospitalID);
		setDepartID(departID);
		setRoomNumber(roomNumber);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 765, 39);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblAddPerson = new JLabel("Update Room\r\n");
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
		
		tfRoomNumber = new JTextArea();
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
		lblHospitalId.setBounds(0, -1, 128, 17);
		panel_13.add(lblHospitalId);
		
		cbHospitalName = new JComboBox<String>();
		cbHospitalName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbHospitalName.setBackground(Color.WHITE);
		cbHospitalName.setBounds(159, -1, 118, 26);
		panel_13.add(cbHospitalName);
	
		
		JPanel panel_15 = new JPanel();
		panel_15.setLayout(null);
		panel_15.setBackground(Color.WHITE);
		panel_15.setBounds(47, 138, 329, 26);
		add(panel_15);
		
		JLabel lblDepartmentId = new JLabel("Department Name:");
		lblDepartmentId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDepartmentId.setBounds(0, -1, 149, 17);
		panel_15.add(lblDepartmentId);
		
		cbDepartmentName = new JComboBox<String>();
		cbDepartmentName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbDepartmentName.setBackground(Color.WHITE);
		cbDepartmentName.setBounds(159, 0, 160, 26);
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
		
		tfBedsAmount = new JTextArea();
		tfBedsAmount.setFont(new Font("Arial", Font.PLAIN, 14));
		tfBedsAmount.setBounds(134, 4, 170, 15);
		panel_2.add(tfBedsAmount);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(131, 24, 173, 2);
		panel_2.add(separator_1);
		
		cbHospitalID = new JComboBox<String>();
		cbHospitalID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbHospitalID.setBackground(Color.WHITE);
		cbHospitalID.setBounds(47, 236, 115, 26);
		add(cbHospitalID);
		cbHospitalID.setVisible(false);
		
		cbDepartmentID = new JComboBox<String>();
		cbDepartmentID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbDepartmentID.setBackground(Color.WHITE);
		cbDepartmentID.setBounds(215, 236, 155, 26);
		add(cbDepartmentID);
		cbDepartmentID.setVisible(false);
		
		JTextArea dep = new JTextArea();
		cbHospitalName.setEnabled(false);
		cbDepartmentName.setEnabled(false);
		tfRoomNumber.setEditable(false);
		cbHospitalName.setForeground(Color.GRAY);
		cbDepartmentName.setForeground(Color.GRAY);
		tfRoomNumber.setForeground(Color.GRAY);
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

		JButton updateButton = new JButton("Update");
		
		updateButton.setIcon(new ImageIcon(Panel_update_RoomDetails.class.getResource("/view/icons/refresh-arrows.png")));
		updateButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		updateButton.setEnabled(false);
	
		updateButton.setForeground(new Color(255, 255, 255));
	
		updateButton.setBackground(Color.LIGHT_GRAY);
		updateButton.setBounds(619, 344, 120, 41);
		add(updateButton);
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Object[] options = {"Yes","No"};
				int n = JOptionPane.showOptionDialog(null, "Are you sure you want to update the room?","Update Room",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[1]);
				if (n==0)
				{
					try {
						Integer.valueOf(tfBedsAmount.getText());
						Integer.valueOf(tfRoomNumber.getText());
						
					if (Integer.valueOf(tfBedsAmount.getText())<=0)
                        JOptionPane.showMessageDialog(null, "Beds amount must be a number above 0");
					
					else
					{
						Logic.getInstance().UpdateRoom(cbHospitalID.getSelectedItem().toString(), cbDepartmentID.getSelectedItem().toString(), tfRoomNumber.getText(), tfBedsAmount.getText());
						JOptionPane.showMessageDialog(null, "Room " + tfRoomNumber.getText() + " has successfully been updated!");
						mm.getviewR().setVisible(true);
					    mm.getviewR().refreshComp();
						Panel_update_RoomDetails.this.setVisible(false);
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
	
		
        mm.getBtnAdd().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Panel_update_RoomDetails.this.setVisible(false);
				
			}
		});
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mm.getviewR().setVisible(true);
				Panel_update_RoomDetails.this.setVisible(false);
			}
		});
	
		btnBack.setIcon(new ImageIcon(Panel_update_PatientDetails.class.getResource("/view/icons/back-arrow.png")));
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(new Color(70, 130, 180));
		btnBack.setBounds(487, 344, 120, 41);
		add(btnBack);
		
		if (hospitalID!=null &&departID!=null && roomNumber!=null)
    		fetch();
		
		DocumentListener docListener = new DocumentListener() {
			@Override
			public void changedUpdate(DocumentEvent arg0) {
				emptyFields(tfRoomNumber, tfBedsAmount, dep, updateButton);
				
			}
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				emptyFields(tfRoomNumber, tfBedsAmount, dep, updateButton);
				
			}
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				emptyFields(tfRoomNumber, tfBedsAmount, dep, updateButton);
				
			}
        };
        dep.getDocument().addDocumentListener(docListener);          
        tfRoomNumber.getDocument().addDocumentListener(docListener);
        tfBedsAmount.getDocument().addDocumentListener(docListener);
	}
	
	
	
private void fetch() {
		
		Room r=Logic.getInstance().getRoomDetails(this.hospitalID,this.departID,this.roomNumber);

		if (r.getHospital()!=null && r.getDepartment()!=null && r.getRoomNumber()>0)
		{
			tfRoomNumber.setText(((Integer)r.getRoomNumber()).toString());
			cbHospitalName.setSelectedItem(r.getHospital().getName());
			cbHospitalID.setSelectedItem(r.getHospital().getHospitalID());
			cbDepartmentName.setSelectedItem(r.getDepartment().getDepartmentName());
			cbDepartmentID.setSelectedItem(r.getDepartment().getDepartmentID());
			tfBedsAmount.setText(((Integer)r.getBedsAmount()).toString());
			
	
		}
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



	public void setHospitalID(String hospitalID) {
		this.hospitalID = hospitalID;
	}



	public void setDepartID(String departID) {
		this.departID = departID;
	}



	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	
}
