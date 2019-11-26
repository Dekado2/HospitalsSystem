package view;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


import javax.swing.JSeparator;
import com.toedter.calendar.JDateChooser;

import controller.Logic;
import model.Hospitalized;
import model.MedicalEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class SubPanel_updateHospitalization extends JPanel {
	JPanel entCodeP;
	private String patientID;
	private int eventCode;
	private ArrayList<MedicalEvent> events;
	private String hospitalId;
	private String departmentId;
	private Integer roomNumber;
	JButton btnUpdate ;
	JComboBox<String> cbSeverity;
	JTextArea tfNumOfDays;
	JDateChooser dateChooser ;
	JTextArea tfEventCode;
	JComboBox<String> cbDesc;
	
	

	/**
	 * Create the panel.
	 */
	public SubPanel_updateHospitalization(MainMenu mm,Panel_update_HospitalizationDetails updateHosp,String patientID, int eventCode,String hospitalID,String departmentID,String roomNumber) {
		setBackground(Color.WHITE);
		setLayout(null);
		setPatientID(patientID);
		setEventCode(eventCode);
		this.patientID=patientID;
		this.hospitalId=hospitalID;
		this.departmentId=departmentID;
		this.roomNumber=Integer.valueOf(roomNumber);
		JPanel panelMedicalEvent = new JPanel();
		panelMedicalEvent.setBackground(Color.WHITE);
		panelMedicalEvent.setBounds(0, 40, 765, 298);
		add(panelMedicalEvent);
		panelMedicalEvent.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(53, 13, 327, 39);
		panelMedicalEvent.add(panel_1);
		panel_1.setBackground(Color.WHITE);
		panel_1.setLayout(null);
		
		JLabel lblPatientId = new JLabel("Description:");
		lblPatientId.setBounds(0, 0, 106, 22);
		lblPatientId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(lblPatientId);
		
		cbDesc = new JComboBox<String>();
		cbDesc.setEnabled(false);
		cbDesc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbDesc.setBackground(Color.WHITE);
		cbDesc.setBounds(106, 0, 221, 39);
		panel_1.add(cbDesc);
		JTextArea dep=new JTextArea();
		
		entCodeP = new JPanel();
		entCodeP.setBounds(53, 65, 327, 39);
		panelMedicalEvent.add(entCodeP);
		entCodeP.setLayout(null);
		entCodeP.setBackground(Color.WHITE);
		
		JLabel lblEventCode = new JLabel("Event code:");
		lblEventCode.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEventCode.setBounds(0, 0, 114, 22);
		entCodeP.add(lblEventCode);
		
		tfEventCode = new JTextArea();
		tfEventCode.setFont(new Font("Courier New", Font.PLAIN, 12));
		tfEventCode.setBounds(141, 0, 169, 23);
		tfEventCode.setEditable(false);
		if(!tfEventCode.isEditable())
			tfEventCode.setForeground(Color.gray);
		entCodeP.add(tfEventCode);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(141, 26, 170, 5);
		entCodeP.add(separator_2);
		
		JPanel severityP = new JPanel();
		severityP.setBackground(Color.WHITE);
		severityP.setBounds(53, 115, 327, 39);
		panelMedicalEvent.add(severityP);
		severityP.setLayout(null);
		
		JLabel label = new JLabel("Severity Level:");
		label.setBounds(0, 0, 142, 22);
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		severityP.add(label);
		
		cbSeverity = new JComboBox<String>();
		cbSeverity.setModel(new DefaultComboBoxModel<String>(new String[] {"","1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		cbSeverity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbSeverity.setBackground(Color.WHITE);
		cbSeverity.setBounds(153, 0, 75, 39);
		severityP.add(cbSeverity);
		
		JPanel numOfDays = new JPanel();
		numOfDays.setBounds(412, 65, 327, 39);
		panelMedicalEvent.add(numOfDays);
		numOfDays.setBackground(Color.WHITE);
		numOfDays.setLayout(null);
		
		JLabel label_1 = new JLabel("Number of days:");
		label_1.setBounds(0, 0, 150, 22);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		numOfDays.add(label_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(144, 26, 170, 5);
		numOfDays.add(separator_1);
		
		tfNumOfDays = new JTextArea();
		tfNumOfDays.setFont(new Font("Courier New", Font.PLAIN, 12));
		tfNumOfDays.setBounds(144, 0, 169, 23);
		numOfDays.add(tfNumOfDays);
		 
		 JPanel dateOfArrivalP = new JPanel();
		 dateOfArrivalP.setBounds(412, 13, 327, 39);
		 panelMedicalEvent.add(dateOfArrivalP);
		 dateOfArrivalP.setLayout(null);
		 dateOfArrivalP.setBackground(Color.WHITE);
		 
		 JLabel lblDateOfArrival = new JLabel("Date of arrival:");
		 lblDateOfArrival.setFont(new Font("Tahoma", Font.PLAIN, 18));
		 lblDateOfArrival.setBounds(0, 0, 142, 22);
		 dateOfArrivalP.add(lblDateOfArrival);
		 
		 dateChooser = new JDateChooser();
		 dateChooser.setBounds(156, 0, 171, 39);
		 dateOfArrivalP.add(dateChooser);
		
		JLabel lblPleaseChooseThe = new JLabel("Please choose the desired medical event:");
		lblPleaseChooseThe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPleaseChooseThe.setBounds(44, 12, 613, 33);
		add(lblPleaseChooseThe);
		
		JButton backBtn = new JButton("Back");
	
		backBtn.setBounds(445, 344, 144, 41);
		add(backBtn);
		
			backBtn.setBackground(new Color(70, 130, 180));
			backBtn.setForeground(Color.WHITE);
			backBtn.setIcon(new ImageIcon(SubPanel_updateHospitalization.class.getResource("/view/icons/back-arrow.png")));
			backBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
			backBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					updateHosp.setVisible(true);
					updateHosp.setEnabled(true);
					 SubPanel_updateHospitalization.this.setVisible(false);
					 SubPanel_updateHospitalization.this.setEnabled(false);
				}
			});
			btnUpdate =new JButton("Update");
			btnUpdate.setBackground(Color.LIGHT_GRAY);
			btnUpdate.setEnabled(false);
			btnUpdate.setBounds(595, 344, 144, 41);
			add(btnUpdate);
			btnUpdate.setIcon(new ImageIcon(SubPanel_updateHospitalization.class.getResource("/view/icons/refresh-arrows.png")));
			btnUpdate.setForeground(Color.WHITE);
			btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
			
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					
					Object[] options = {"Yes","No"};
					int n = JOptionPane.showOptionDialog(null, "Are you sure you want to update the hospitalization?","Update Hospitalization",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[1]);
					if (n==0)
					{
						 int numOfAvailableBedsInAroom=0;
						try {
						  Integer.valueOf(tfNumOfDays.getText());
						  numOfAvailableBedsInAroom=Logic.getInstance().getRoomOccupation(hospitalId,departmentId,roomNumber.toString());
						if (Integer.valueOf(tfNumOfDays.getText())<1)
							JOptionPane.showMessageDialog(null, "Invalid number of days");
						else if(numOfAvailableBedsInAroom<0)
							JOptionPane.showMessageDialog(null, "No beds available in this room, please choose another room");
						else
						{
							 Date dateOfArrival =  new java.sql.Date(dateChooser.getDate().getTime());
							 Logic.getInstance().updateHospitalization(getPatientID(), getEventCode(), tfNumOfDays.getText(), dateOfArrival, cbSeverity.getSelectedItem().toString(), hospitalId, departmentId,Integer.valueOf( roomNumber));
							 JOptionPane.showMessageDialog(null, "Hospitalization of " +  patientID+ " has successfully been updated!");
							 mm.getViewHos().refreshComp(mm);
							 SubPanel_updateHospitalization.this.setVisible(false);
							 mm.getViewHos().setVisible(true);

						     updateHosp.getCbHospitalID().setSelectedIndex(0);

							 
							}
						}
						catch (NumberFormatException ex) {
							JOptionPane.showMessageDialog(null, "Number of days number must be a number!");
						}	
					}
					
				}
			});
			
				
		events=updateHosp.getEvents();
		
		for (int i=0; i<events.size();i++) {
			cbDesc.insertItemAt(events.get(i).getDescription(), i);
		}
		JTextArea dep2=new JTextArea();
		cbDesc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cbDesc.getItemCount()>0)
					dep2.setText(cbDesc.getSelectedItem().toString());
				for (int i=0; i<events.size();i++) {
					if(cbDesc.getSelectedItem().toString().equals(events.get(i).getDescription())) {
						tfEventCode.setEnabled(false);
						tfEventCode.setText(((Integer)events.get(i).getEventCode()).toString());
						setEventCode(Integer.parseInt(tfEventCode.getText().toString()));
						 
					}
						
				}
				
			}
		});
		cbSeverity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cbSeverity.getItemCount()>0)
					dep.setText(cbSeverity.getSelectedItem().toString());
				
			}
		});
		updateHosp.getCbID().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (updateHosp.getCbID().getItemCount()>0)
				dep.setText(updateHosp.getCbID().getSelectedItem().toString());
			}
		});
		updateHosp.getCbHospitalID().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (updateHosp.getCbHospitalID().getItemCount()>0)
				dep.setText(updateHosp.getCbHospitalID().getSelectedItem().toString());
			}
		});
		updateHosp.getCbDepartmentID().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (updateHosp.getCbDepartmentID().getItemCount()>0)
				dep.setText(updateHosp.getCbDepartmentID().getSelectedItem().toString());
			}
		});
		updateHosp.getCbRoomNum().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (updateHosp.getCbRoomNum().getItemCount()>0)
				dep.setText(updateHosp.getCbRoomNum().getSelectedItem().toString());
			}
		});
	
		
		

	DocumentListener docListener = new DocumentListener() {
		@Override
		public void changedUpdate(DocumentEvent arg0) {
			emptyFields(updateHosp.getCbID(), tfEventCode, tfNumOfDays, dateChooser, cbSeverity,updateHosp.getCbHospitalID(), updateHosp.getCbHospitalID(), updateHosp.getCbRoomNum(), dep,dep2, btnUpdate);
			
		}
		@Override
		public void insertUpdate(DocumentEvent arg0) {
			emptyFields(updateHosp.getCbID(), tfEventCode, tfNumOfDays, dateChooser, cbSeverity,updateHosp.getCbHospitalID(), updateHosp.getCbHospitalID(), updateHosp.getCbRoomNum(), dep,dep2, btnUpdate);
			
		}
		@Override
		public void removeUpdate(DocumentEvent arg0) {
			emptyFields(updateHosp.getCbID(), tfEventCode, tfNumOfDays, dateChooser, cbSeverity,updateHosp.getCbHospitalID(), updateHosp.getCbHospitalID(), updateHosp.getCbRoomNum(), dep,dep2, btnUpdate);
			
		}
    };
    dep.getDocument().addDocumentListener(docListener);
    dep2.getDocument().addDocumentListener(docListener);          
    tfEventCode.getDocument().addDocumentListener(docListener);
    tfNumOfDays.getDocument().addDocumentListener(docListener);
    ((JTextField)dateChooser.getDateEditor().getUiComponent()).getDocument().addDocumentListener(docListener);

    if(patientID!=null)
    	fetch2();
}

public void emptyFields(JComboBox <String> patientID, JTextArea tfeventCode,JTextArea tfNumOfDays,JDateChooser dateChooser,JComboBox <String> cbSeverity,JComboBox <String> hospitalId, JComboBox <String> departmentId,JComboBox <Integer> roomNumber, JTextArea dep, JTextArea dep2,JButton btnAdd)
{
	String dateOfArrivalText = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
	Color dateOfArrivalColor = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getForeground();
	
	
		if (tfeventCode.getText().equals("") || tfNumOfDays.getText().equals("") || 
				dateOfArrivalText.length()<2 || dateOfArrivalColor.equals(Color.red) || dep2.getText().equals("") || dep.getText().equals(""))
		{
			btnAdd.setEnabled(false);
			btnAdd.setBackground(Color.LIGHT_GRAY);
		}
		else
		{
			 btnAdd.setEnabled(true);
			 btnAdd.setBackground(new Color(70, 130, 180));
		}
}
private void fetch2() {
	Hospitalized h=Logic.getInstance().getHospitalizationDetails(this.patientID, this.eventCode);
	if(h.getMedicalEvent()!=null) {
			tfEventCode.setText(((Integer)h.getMedicalEvent().getEventCode()).toString());
			cbDesc.setSelectedItem(h.getMedicalEvent().getDescription());
			cbSeverity.setSelectedItem(((Integer)h.getSeverityLevel()).toString());
			dateChooser.setDate(h.getDateOfArrival());
			tfNumOfDays.setText(((Integer)h.getNumberOfDays()).toString());
	}
	
}


	

	



	public JPanel getEntCodeP() {
		return entCodeP;
	}



	



	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}



	public int getEventCode() {
		return eventCode;
	}

	public void setEventCode(int eventCode) {
		this.eventCode = eventCode;
	}

	public String getPatientID() {
		return patientID;
	}

	public void setEventCode(Integer eventCode) {
		this.eventCode = eventCode;
	}





	public JButton getBtnAdd() {
		return btnUpdate;
	}





	public void setBtnAdd(JButton btnAdd) {
		this.btnUpdate = btnAdd;
	}
}
