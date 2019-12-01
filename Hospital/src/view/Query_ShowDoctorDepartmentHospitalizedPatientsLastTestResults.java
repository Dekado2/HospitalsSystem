package view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import controller.Logic;
import model.CheckedBy;
import model.Doctor;
import model.Person;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JSeparator;

public class Query_ShowDoctorDepartmentHospitalizedPatientsLastTestResults extends JPanel {
	private  int iteration;
	private static DefaultTableModel tableModel;
	private ArrayList<CheckedBy> result=new ArrayList<CheckedBy>();
	private ArrayList<Doctor> doctors=new ArrayList<Doctor>();
	private HashMap<Doctor, String > doctorDetails;
	private String doctorID;
	private String doctorName;
	private JTable table;
	JTextArea tfDoctorID;
	JComboBox<String> cbDoctors;
	/**
	 * Create the panel.
	 */
	public Query_ShowDoctorDepartmentHospitalizedPatientsLastTestResults(MainMenu mm) {
		setBackground(Color.WHITE);
		setLayout(null);
		

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 765, 84);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblAddPerson = new JLabel("Show doctor's department's hospitalized patients'");
		lblAddPerson.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblAddPerson.setForeground(new Color(25, 25, 112));
		lblAddPerson.setBounds(40, 6, 725, 33);
		panel.add(lblAddPerson);
		
		JLabel lblWereHospitalizedMore = new JLabel("last test results in doctor's last vacation day");
		lblWereHospitalizedMore.setForeground(new Color(25, 25, 112));
		lblWereHospitalizedMore.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblWereHospitalizedMore.setBounds(40, 51, 725, 33);
		panel.add(lblWereHospitalizedMore);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 40, 765, 380);
		add(panel_1);
		panel_1.setLayout(null);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  
		table.setBackground(Color.WHITE);
	
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		//scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(47, 152, 700, 200);
		scrollPane.setBackground(Color.WHITE);
		panel_1.add(scrollPane);
		tableModel = new DefaultTableModel() {

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		String header[] = new String[] { "Patient Id","Full name", "Check time","Blood pressure","Body temprature"};
		 tableModel.setColumnIdentifiers(header);
		 table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 10));
		 table.getTableHeader().setBackground(Color.WHITE);
		 setLayout(null);
		 table.setModel(tableModel);
		 table.setRowHeight(25);
		 
		  //Set table dimensions
		    TableColumnModel columnModel = table.getColumnModel();
		    columnModel.getColumn(0).setPreferredWidth(150);
		    columnModel.getColumn(1).setPreferredWidth(150);
		    columnModel.getColumn(2).setPreferredWidth(150);
		    columnModel.getColumn(3).setPreferredWidth(150);
		    columnModel.getColumn(4).setPreferredWidth(150);
		   
		
		   
		    
		
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setPreferredScrollableViewportSize(table.getPreferredSize()); 
			
			JLabel lblPleaseChooseDoctor = new JLabel("Please choose doctor from the list:");
			lblPleaseChooseDoctor.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblPleaseChooseDoctor.setBackground(Color.WHITE);
			lblPleaseChooseDoctor.setBounds(49, 51, 416, 33);
			panel_1.add(lblPleaseChooseDoctor);
			
			cbDoctors = new JComboBox();
			cbDoctors.setFont(new Font("Tahoma", Font.PLAIN, 20));
			cbDoctors.setBackground(Color.WHITE);
			cbDoctors.setBounds(59, 80, 266, 39);
			panel_1.add(cbDoctors);
			
			JPanel panel_doctorID = new JPanel();
			panel_doctorID.setBackground(Color.WHITE);
			panel_doctorID.setBounds(353, 74, 283, 45);
			panel_1.add(panel_doctorID);
			panel_doctorID.setLayout(null);
			
			JLabel lblDoctorId = new JLabel("Doctor ID:");
			lblDoctorId.setFont(new Font("Arial", Font.BOLD, 14));
			lblDoctorId.setBounds(0, 0, 95, 33);
			panel_doctorID.add(lblDoctorId);
			
			tfDoctorID = new JTextArea();
			tfDoctorID.setEditable(false);
			if(!tfDoctorID.isEditable())
				tfDoctorID.setForeground(Color.gray);
			tfDoctorID.setFont(new Font("Arial", Font.PLAIN, 14));
			tfDoctorID.setBounds(82, 0, 186, 26);
			panel_doctorID.add(tfDoctorID);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(82, 28, 180, 2);
			panel_doctorID.add(separator);
			panel_doctorID.setVisible(false);
			
			doctors=Logic.getInstance().getDoctors();
			doctorDetails= new HashMap<Doctor, String>();
			for (int i=0; i<doctors.size();i++) {
				//doctorDetails.put(doctors.get(i),doctors.get(i).getFirstName()+ " "+doctors.get(i).getSurName());
				String FullName="Dr "+ doctors.get(i).getFirstName()+" "+ doctors.get(i).getSurName();
				cbDoctors.insertItemAt(FullName, i);
			}
			cbDoctors.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
	
					panel_doctorID.setVisible(true);
					setDoctorName(cbDoctors.getSelectedItem().toString());
						fetch();
				}
			});
			
		
	}
	public void refreshComp(){
		
		initTableData();
		
	}
	public void fetch(){
			
			for(Doctor d: doctors) {
				String fullName="Dr "+ d.getFirstName()+" "+ d.getSurName();
				if(fullName.equals(doctorName)) {
					tfDoctorID.setText(d.getId());
					setDoctorID(d.getId());
				}
			}
			refreshComp();
		
	
	}
	
	private void initTableData(){
		if (iteration ==0) {
		 	iteration++;
			}

		//Following code clear table (used while browsing between orders)
		tableModel =(DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);

		//Following code gets all orders details for selected order id and updates table rows
		result = Logic.getInstance().ShowDoctorDepartmentHospitalizedPatientsLastTestResults(doctorID);
		int i=0;
		CheckedBy ch;
	 	while(i<result.size()) {
	 		
		    Vector<Object> data = new Vector<Object>();
		    ch=result.get(i);
		    data.add(ch.getHospitalizedPatient().getPatient().getId());
		    String fullName=ch.getHospitalizedPatient().getPatient().getFirstName()+" "+ch.getHospitalizedPatient().getPatient().getSurName();
		    data.add(fullName);
		    data.add(ch.getCheckTime());
		    data.add(ch.getBloodPressure());
		    data.add(ch.getBodyTemp());
		    
		    i++;
		    tableModel.addRow(data);
	 	}

	 	
	 	// 	First row is been focused and selected by default
	    table.changeSelection(0, 0, false, false);
	    table.requestFocus();

	 	//Notifies all listeners that all cell values in the table's rows may have changed.
	 	tableModel.fireTableDataChanged();
	
	 
	}
	public String getDoctorID() {
		return doctorID;
	}
	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	
}
