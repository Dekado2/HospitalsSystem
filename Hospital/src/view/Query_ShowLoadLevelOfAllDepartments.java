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
import model.Department;
import model.Doctor;
import model.Hospital;
import model.Person;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Query_ShowLoadLevelOfAllDepartments extends JPanel {
	private  int iteration;
	private static DefaultTableModel tableModel;
	private HashMap<Department, String >  result=new HashMap<Department, String > ();
	private JTable table;
	/**
	 * Create the panel.
	 */
	public Query_ShowLoadLevelOfAllDepartments(MainMenu mm) {
		setBackground(Color.WHITE);
		setLayout(null);
		

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 765, 84);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblAddPerson = new JLabel("Show load level of all departments");
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
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(51, 60, 650, 270);
		scrollPane.setBackground(Color.WHITE);
		panel_1.add(scrollPane);
		tableModel = new DefaultTableModel() {

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		String header[] = new String[] {"Hospital Name","Department name","Free beds in department","status"};
		 tableModel.setColumnIdentifiers(header);
		 table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 10));
		 table.getTableHeader().setBackground(Color.WHITE);
		 setLayout(null);
		 table.setModel(tableModel);
		 table.setRowHeight(25);
		 
		  //Set table dimensions
		    TableColumnModel columnModel = table.getColumnModel();
		    columnModel.getColumn(0).setPreferredWidth(150);
		    columnModel.getColumn(1).setPreferredWidth(200);
		    columnModel.getColumn(2).setPreferredWidth(150);
		    columnModel.getColumn(3).setPreferredWidth(200);
		    
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setPreferredScrollableViewportSize(table.getPreferredSize()); 
			

	}
	public void refreshComp(){
		
		initTableData();
		
	}
	
	private void initTableData(){
		if (iteration ==0) {
		 	iteration++;
			}

		//Following code clear table (used while browsing between orders)
		tableModel =(DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);

		//Following code gets all orders details for selected order id and updates table rows
		result = Logic.getInstance().ShowLoadLevelOfAllDepartments();
		
		
	
		String hospitalName;

		for(Map.Entry<Department,String> d: result.entrySet()) {
			Vector<Object> data = new Vector<Object>();
		 	hospitalName=d.getKey().getHospital().getName();
		 	data.add(hospitalName);
		 	data.add(d.getKey().getDepartmentName());
		 	String[] tmp = d.getValue().split(",",2);
		 	String [] freeBeds= tmp[0].split(":",2);
		 	String [] status= tmp[1].split(":",2);
		 	if(freeBeds[0].equals("FreeBedsInDepartment"))
		 		data.add(freeBeds[1]);
		 	if(status[0].equals("Status"))
		 		data.add(status[1]);
		 	
		    tableModel.addRow(data);
		 	
		    }

	 	// 	First row is been focused and selected by default
	    table.changeSelection(0, 0, false, false);
	    table.requestFocus();
	   
	 	//Notifies all listeners that all cell values in the table's rows may have changed.
	 	tableModel.fireTableDataChanged();
	
	 
	}
}
