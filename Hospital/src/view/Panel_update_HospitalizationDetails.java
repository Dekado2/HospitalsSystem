package view;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import controller.Logic;
import model.Department;
import model.Hospital;
import model.Hospitalized;
import model.MedicalEvent;
import model.Person;
import model.Room;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import javax.swing.JSeparator;

public class Panel_update_HospitalizationDetails extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Hospital> hospitals;
	private ArrayList<Department> departments= new ArrayList<Department>();
	private ArrayList<Person> patients;
	private ArrayList<MedicalEvent> events= new ArrayList<>();
	private Integer eventCode;
	SubPanel_updateHospitalization subUpdate;
	private JComboBox <String> cbHospitalName;
	private JComboBox <String> cbDepartmentName ;
	private JComboBox <Integer> cbRoomNum;
	private JComboBox <String> cbID ;
	private JComboBox <String> cbHospitalID;
	private JComboBox <String> cbDepartmentID;
	private JPanel patIDP;
	private JPanel hospIDP;
	private JButton btnBack;
	JPanel depIDP;
	JPanel RoomNumP;
	JPanel panelDepName;
	JPanel panelHospName;
	JButton proceedBtn;
	private String patientID ;
	private String hospitalID;
	private String departmentID;
	private String roomNumber;



	JTextArea tfDepName ;
	Hospital Htemp;
	boolean patientisSelected=false;
	boolean roomisSelected=false;
	boolean hospitalisSelected=false;
	boolean departmentisSelected=false;

	/**
	 * Create the panel.
	 */
	public Panel_update_HospitalizationDetails(String patientID,Integer eventCode,MainMenu mm) {
		
		setBackground(Color.WHITE);
		setLayout(null);
		setPatientID(patientID);
		setEventCode(eventCode);
		Hospitalized h=Logic.getInstance().getHospitalizationDetails(this.patientID, this.eventCode);
		hospitalID = h.getRoom().getHospital().getHospitalID();
		departmentID = h.getRoom().getDepartment().getDepartmentID();
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 765, 39);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Hospitalization");
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(43, 6, 311, 33);
		panel.add(lblNewLabel);
		
		JPanel panelM = new JPanel();
		panelM.setBackground(Color.WHITE);
		panelM.setBounds(0, 40, 765, 298);
		add(panelM);
		panelM.setLayout(null);
		
		patIDP = new JPanel();
		patIDP.setBounds(53, 13, 327, 39);
		panelM.add(patIDP);
		patIDP.setBackground(Color.WHITE);
		patIDP.setLayout(null);
		
		JLabel lblPatientId = new JLabel("Patient ID:");
		lblPatientId.setBounds(0, 0, 106, 22);
		lblPatientId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		patIDP.add(lblPatientId);
		
		cbID = new JComboBox<String>();
		cbID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				patientisSelected=true;
				setPatientID(cbID.getSelectedItem().toString());
			}
		});
		cbID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbID.setBackground(Color.WHITE);
		cbID.setBounds(158, 1, 169, 26);
		patIDP.add(cbID);
		
		hospIDP = new JPanel();
		hospIDP.setBounds(53, 69, 327, 39);
		panelM.add(hospIDP);
		hospIDP.setLayout(null);
		hospIDP.setBackground(Color.WHITE);
		
		cbHospitalName = new JComboBox<String>();
		cbHospitalName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbHospitalName.setBackground(Color.WHITE);
		cbHospitalName.setBounds(158, 0, 169, 26);
		hospIDP.add(cbHospitalName);
		
		JLabel lblHospitalName = new JLabel("Hospital name:");
		lblHospitalName.setBounds(0, 2, 131, 22);
		hospIDP.add(lblHospitalName);
		lblHospitalName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		depIDP = new JPanel();
		depIDP.setBounds(53, 136, 327, 39);
		panelM.add(depIDP);
		depIDP.setLayout(null);
		depIDP.setBackground(Color.WHITE);
		
		cbDepartmentName = new JComboBox<String>();
		cbDepartmentName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbDepartmentName.setBackground(Color.WHITE);
		cbDepartmentName.setBounds(158, 0, 169, 26);
		depIDP.add(cbDepartmentName);
		
		JLabel lblDepartmentName = new JLabel("Department name:");
		lblDepartmentName.setBounds(0, 2, 159, 22);
		depIDP.add(lblDepartmentName);
		lblDepartmentName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		RoomNumP = new JPanel();
		RoomNumP.setBounds(53, 203, 327, 39);
		panelM.add(RoomNumP);
		RoomNumP.setLayout(null);
		RoomNumP.setBackground(Color.WHITE);
		
		JLabel lblRoomNumber = new JLabel("Room Number:");
		lblRoomNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRoomNumber.setBounds(0, 0, 131, 22);
		RoomNumP.add(lblRoomNumber);
		
		cbRoomNum = new JComboBox<Integer>();
		cbRoomNum.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbRoomNum.setBackground(Color.WHITE);
		cbRoomNum.setBounds(158, 1, 169, 26);
		RoomNumP.add(cbRoomNum);
		
		panelDepName = new JPanel();
		panelDepName.setLayout(null);
		panelDepName.setBackground(Color.WHITE);
		panelDepName.setBounds(412, 136, 353, 39);
		panelM.add(panelDepName);
		panelDepName.setVisible(false);
		
		tfDepName = new JTextArea();
		tfDepName.setEditable(false);
		tfDepName.setFont(new Font("Courier New", Font.PLAIN, 12));
		tfDepName.setBounds(154, 8, 169, 15);
		panelDepName.add(tfDepName);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(154, 26, 170, 5);
		panelDepName.add(separator_1);
		
		JLabel lblDepartmentId = new JLabel("Department ID:");
		lblDepartmentId.setBounds(-32, 2, 131, 22);
		panelDepName.add(lblDepartmentId);
		lblDepartmentId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		panelHospName = new JPanel();
		panelHospName.setLayout(null);
		panelHospName.setBackground(Color.WHITE);
		panelHospName.setBounds(412, 69, 353, 39);
		panelM.add(panelHospName);
		panelHospName.setVisible(false);
		
		JTextArea tfHospName = new JTextArea();
		tfHospName.setEditable(false);
		tfHospName.setFont(new Font("Courier New", Font.PLAIN, 12));
		tfHospName.setBounds(154, 8, 169, 15);
		panelHospName.add(tfHospName);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(154, 26, 170, 5);
		panelHospName.add(separator);
		
		JLabel lblHospitalId = new JLabel("Hospital ID:");
		lblHospitalId.setBounds(-19, 2, 106, 22);
		panelHospName.add(lblHospitalId);
		lblHospitalId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
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
		
		btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon(Panel_update_HospitalizationDetails.class.getResource("/view/icons/back-arrow.png")));
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBack.setEnabled(true);
		btnBack.setBackground(new Color(70,130,180));
		btnBack.setBounds(291, 344, 144, 41);
		add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mm.getViewHos().setVisible(true);
				Panel_update_HospitalizationDetails.this.setVisible(false);
			}
		});
		
		mm.getBtnAdd().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Panel_update_HospitalizationDetails.this.setVisible(false);
				
			}
		});
		
		proceedBtn = new JButton("Proceed");
		proceedBtn.setBounds(445, 344, 144, 41);
		add(proceedBtn);
		proceedBtn.setEnabled(false);
					
		proceedBtn.setBackground(Color.LIGHT_GRAY);
		proceedBtn.setForeground(Color.WHITE);
		proceedBtn.setIcon(new ImageIcon(Panel_update_HospitalizationDetails.class.getResource("/view/icons/forward-arrow.png")));
		proceedBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
	
		proceedBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				subUpdate= new SubPanel_updateHospitalization( mm,Panel_update_HospitalizationDetails.this, patientID,eventCode,hospitalID , departmentID, roomNumber);
				
				mm.getContentPane().add(subUpdate);
				Panel_update_HospitalizationDetails.this.setVisible(false);
				Panel_update_HospitalizationDetails.this.setEnabled(false);
				subUpdate.setBounds(261, 156, 765, 414);
				subUpdate.setVisible(true);
				subUpdate.setLayout(null);			
			}
		});
	
		
		JTextArea dep = new JTextArea();
		hospitals=Logic.getInstance().getHospitals();
		
		for (int i=0; i<hospitals.size();i++)
			cbHospitalName.insertItemAt(hospitals.get(i).getName(), i);
		for (int i=0; i<hospitals.size();i++)
			cbHospitalID.insertItemAt(hospitals.get(i).getHospitalID(), i);
		
		if (mm.getUser().getType().equals("doctor"))
		{
			cbHospitalName.setEnabled(false);
			cbHospitalName.setSelectedItem(Logic.getInstance().getHospitalizationDetails(patientID, eventCode).getRoom().getHospital().getName());
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
				cbDepartmentName.setSelectedItem(Logic.getInstance().getHospitalizationDetails(patientID, eventCode).getRoom().getDepartment().getDepartmentName());
			}
		});
		}
		if (mm.getUser().getType().equals("doctor"))
		{
			cbDepartmentName.setEnabled(false);
			cbDepartmentName.setSelectedItem(Logic.getInstance().getDoctorDetails(mm.getUser().getUsername()).getDepartment().getDepartmentName());
		}
		
	
		cbHospitalName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				hospitalisSelected=true;
				departmentisSelected=false;
				roomisSelected=false;
				proceedBtn.setEnabled(false);
				proceedBtn.setBackground(Color.LIGHT_GRAY);
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
							departments=Logic.getInstance().getDepartmentsOfHospital(cbHospitalID.getSelectedItem().toString(), hospitals.get(i));
							Htemp = hospitals.get(i);
						}
					
				}
			}
		});
		
		JTextArea dep1 = new JTextArea();
		cbDepartmentName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				departmentisSelected=true;
				roomisSelected=false;
				proceedBtn.setEnabled(false);
				proceedBtn.setBackground(Color.LIGHT_GRAY);
				cbRoomNum.removeAllItems();
				dep1.setText("");
				if(!tfDepName.isEditable())tfDepName.setForeground(Color.GRAY);
				
				if (cbDepartmentName.getItemCount()>0)
					dep.setText(cbDepartmentName.getSelectedItem().toString());
					for (Hospital hospital : hospitals)
						if (hospital.getHospitalID().equals(cbHospitalID.getSelectedItem().toString()))
							for (Department dep : hospital.getDepartments())
								if (cbDepartmentName.getItemCount()>0 && dep.getDepartmentName().equals(cbDepartmentName.getSelectedItem().toString())){
					cbDepartmentID.setSelectedItem(dep.getDepartmentID());
					events=Logic.getInstance().getMedicalEvents(dep.getDepartmentName());
								}
				
						for (int j=0;j<departments.size();j++) {
							if (cbHospitalName.getItemCount()>0 && cbDepartmentName.getItemCount()>0 && departments.get(j).getHospital().getHospitalID().equals(cbHospitalID.getSelectedItem().toString()) && departments.get(j).getDepartmentID().equals(cbDepartmentID.getSelectedItem().toString())) {
								for(int k=0; k< departments.get(j).getRooms().size();k++) {
									cbRoomNum.insertItemAt(departments.get(j).getRooms().get(k).getRoomNumber(), k);
									
							}
								}
						}
					}
				
			
		});
		patients = Logic.getInstance().getPatients();
		for (int i=0; i<patients.size();i++) {
			cbID.insertItemAt(patients.get(i).getId(), i);
		}

		cbRoomNum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dep1.setText("");
				if (cbRoomNum.getItemCount()>0 ) {
					dep1.setText(cbRoomNum.getSelectedItem().toString());
					setRoomNumber(cbRoomNum.getSelectedItem().toString());
					roomisSelected=true;
				
				}
				if(patientisSelected && roomisSelected && hospitalisSelected && departmentisSelected ) {
					proceedBtn.setEnabled(true);
					proceedBtn.setBackground(new Color(70, 130, 180));
				}
			}
		});
	
	
	
		if(patientID!=null &&eventCode!=null) 
			fetch();
		

	}



	private void fetch() {
		
		Hospitalized h=Logic.getInstance().getHospitalizationDetails(this.patientID, this.eventCode);
		

		if (h.getPatient()!=null && h.getMedicalEvent()!=null)
		{
			cbID.setSelectedItem(h.getPatient().getId());
			cbHospitalName.setSelectedItem(h.getRoom().getHospital().getName());
			cbDepartmentName.setSelectedItem(h.getRoom().getDepartment().getDepartmentName());
			cbRoomNum.setSelectedItem((Integer)h.getRoom().getRoomNumber());
		}
	}
	public ArrayList<MedicalEvent> getEvents() {
		return events;
	}

	public JComboBox<String> getCbHospitalID() {
		return cbHospitalName;
	}

	public JComboBox<String> getCbDepartmentID() {
		return cbDepartmentName;
	}

	public JComboBox<Integer> getCbRoomNum() {
		return cbRoomNum;
	}

	public JComboBox<String> getCbID() {
		return cbID;
	}


	public JPanel getPanelHospName() {
		return panelHospName;
	}

	public JButton getProceedBtn() {
		return proceedBtn;
	}

	
	public JTextArea getTfDepName() {
		return tfDepName;
	}

	public Hospital getHtemp() {
		return Htemp;
	}




	public String getPatientID() {
		return patientID;
	}




	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}




	public String getHospitalID() {
		return hospitalID;
	}




	public void setHospitalID(String hospitalID) {
		this.hospitalID = hospitalID;
	}




	public String getDepartmentID() {
		return departmentID;
	}




	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}




	public String getRoomNumber() {
		return roomNumber;
	}




	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}



	public Integer getEventCode() {
		return eventCode;
	}



	public void setEventCode(Integer eventCode) {
		this.eventCode = eventCode;
	}
}
