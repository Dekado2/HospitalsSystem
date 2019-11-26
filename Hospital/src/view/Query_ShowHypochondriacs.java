package view;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

public class Query_ShowHypochondriacs extends JPanel {
	private  int iteration;
	private static DefaultTableModel tableModel;
	private ArrayList<Person> result=new ArrayList<Person>();
	private ArrayList<Person> patients=new ArrayList<Person>();
	
	private String patientID;
	
	private String patientName;
	private JTable table;
	JTextArea tfPatientID;
	JComboBox<String> cbPatients;
	/**
	 * Create the panel.
	 */
	public Query_ShowHypochondriacs(MainMenu mm) {
		setBackground(Color.WHITE);
		setLayout(null);
		

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 765, 84);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblAddPerson = new JLabel("Show hypochondriacs");
		lblAddPerson.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblAddPerson.setForeground(new Color(25, 25, 112));
		lblAddPerson.setBounds(40, 6, 725, 33);
		panel.add(lblAddPerson);
		
		
		
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
		scrollPane.setBounds(47, 152, 600, 200);
		scrollPane.setBackground(Color.WHITE);
		panel_1.add(scrollPane);
		tableModel = new DefaultTableModel() {

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		String header[] = new String[] { "Patient ID","First Name", "Sur Name","Phone"};
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
		    
		   
		
		   
		    
		
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setPreferredScrollableViewportSize(table.getPreferredSize()); 
			
			JLabel lblPleaseChooseDoctor = new JLabel("Please choose a patient from the list:");
			lblPleaseChooseDoctor.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblPleaseChooseDoctor.setBackground(Color.WHITE);
			lblPleaseChooseDoctor.setBounds(194, 50, 416, 33);
			panel_1.add(lblPleaseChooseDoctor);
			
			cbPatients = new JComboBox();
			cbPatients.setFont(new Font("Tahoma", Font.PLAIN, 20));
			cbPatients.setBackground(Color.WHITE);
			cbPatients.setBounds(204, 82, 266, 39);
			panel_1.add(cbPatients);
			
			JPanel panel_doctorID = new JPanel();
			panel_doctorID.setBounds(10, 107, 283, 45);
			panel_1.add(panel_doctorID);
			panel_doctorID.setBackground(Color.WHITE);
			panel_doctorID.setLayout(null);
			
			JLabel lblDoctorId = new JLabel("Patient ID:");
			lblDoctorId.setFont(new Font("Arial", Font.BOLD, 14));
			lblDoctorId.setBounds(0, 0, 95, 33);
			panel_doctorID.add(lblDoctorId);
			
			tfPatientID = new JTextArea();
			tfPatientID.setEditable(false);
			tfPatientID.setFont(new Font("Arial", Font.PLAIN, 14));
			tfPatientID.setBounds(82, 0, 186, 26);
			panel_doctorID.add(tfPatientID);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(82, 28, 180, 2);
			panel_doctorID.add(separator);
			panel_doctorID.setVisible(false);
			if(!tfPatientID.isEditable())
				tfPatientID.setForeground(Color.gray);
			
			patients=Logic.getInstance().getPatients();
			panel_doctorID.setVisible(false);
			cbPatients.insertItemAt("Show all hypochondriacs", 0);
			for (int i=0; i<patients.size();i++) {
				String FullName= patients.get(i).getFirstName()+" "+ patients.get(i).getSurName();
				cbPatients.insertItemAt(FullName, i+1);

			}
			cbPatients.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
	
					setPatientName(cbPatients.getSelectedItem().toString());
						fetch();
				}
			});
			
		
	}
	public void refreshComp(){
		
		initTableData();
		
	}
	public void fetch(){
			for(Person p: patients) {
				String fullName= p.getFirstName()+" "+ p.getSurName();
				if(fullName.equals(patientName)) {
					tfPatientID.setText(p.getId());
					setPatientID(p.getId());
				}
			}
			if (patientName.equals("Show all hypochondriacs"))
				setPatientID(null);
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
		result = Logic.getInstance().ShowHypochondriacs(patientID);
		Person patient=null;
		if (cbPatients.getSelectedItem().toString().equals("Show all hypochondriacs"))
		for (int i=0;i<result.size();i++)
		{
				patient = Logic.getInstance().getPatientDetails(result.get(i).getId());
				result.get(i).setFirstName(patient.getFirstName());
				result.get(i).setSurName(patient.getSurName());
				result.get(i).setPhoneNumber(patient.getPhoneNumber());
		}
		int i=0;
		Person pat;
	 	while(i<result.size()) {
	 		
		    Vector<Object> data = new Vector<Object>();
		    pat=result.get(i);
		    data.add(pat.getId());
		    data.add(pat.getFirstName());
		    data.add(pat.getSurName());
		    data.add(pat.getPhoneNumber());
		    
		    
		    i++;
		    tableModel.addRow(data);
	 	}

	 	
	 	// 	First row is been focused and selected by default
	    table.changeSelection(0, 0, false, false);
	    table.requestFocus();
	    
	 	//Notifies all listeners that all cell values in the table's rows may have changed.
	 	tableModel.fireTableDataChanged();
	if (result.size()==0)
		if (!cbPatients.getSelectedItem().toString().equals("Show all hypochondriacs"))
		JOptionPane.showMessageDialog(null, cbPatients.getSelectedItem().toString() + " is not a hypochondriac!");
		else
			JOptionPane.showMessageDialog(null, "There are currently no hypochondriacs!");	
	 
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}


	public String getPatientID() {
		return patientID;
	}
	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}	
	
}
