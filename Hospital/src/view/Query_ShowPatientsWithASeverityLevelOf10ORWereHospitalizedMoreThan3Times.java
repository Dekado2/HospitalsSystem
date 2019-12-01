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
import model.Doctor;
import model.Person;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

public class Query_ShowPatientsWithASeverityLevelOf10ORWereHospitalizedMoreThan3Times extends JPanel {
	private  int iteration;
	private static DefaultTableModel tableModel;
	private ArrayList<Person> patients=new ArrayList<Person>();
	private JTable table;
	/**
	 * Create the panel.
	 */
	public Query_ShowPatientsWithASeverityLevelOf10ORWereHospitalizedMoreThan3Times(MainMenu mm) {
		setBackground(Color.WHITE);
		setLayout(null);
		

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 765, 84);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblAddPerson = new JLabel("Show patients with a severity level of 10 OR ");
		lblAddPerson.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblAddPerson.setForeground(new Color(25, 25, 112));
		lblAddPerson.setBounds(40, 6, 725, 33);
		panel.add(lblAddPerson);
		
		JLabel lblWereHospitalizedMore = new JLabel("were hospitalized more than 3 times in the past year");
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
		scrollPane.setBounds(51, 60, 450, 100);
		scrollPane.setBackground(Color.WHITE);
		panel_1.add(scrollPane);
		tableModel = new DefaultTableModel() {

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		String header[] = new String[] { "Patient Id","First name", "Sur name"};
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
		patients = Logic.getInstance().ShowPatientsWithASeverityLevelOf10ORWereHospitalizedMoreThan3Times();
		int i=0;
		String patient;
	 	while (i<patients.size()){
		    Vector<Object> data = new Vector<Object>();
		    patient=patients.get(i).getId();
		    data.add(patients.get(i).getId());
		    data.add(patients.get(i).getFirstName());
		    data.add(patients.get(i).getSurName());
		    i++;
		    tableModel.addRow(data);
	 	}

	 	
	 	// 	First row is been focused and selected by default
	    table.changeSelection(0, 0, false, false);
	    table.requestFocus();
	   
	 	//Notifies all listeners that all cell values in the table's rows may have changed.
	 	tableModel.fireTableDataChanged();
	
	 
	}
}
