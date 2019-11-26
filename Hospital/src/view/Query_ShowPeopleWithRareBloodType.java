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
import java.util.Vector;

public class Query_ShowPeopleWithRareBloodType extends JPanel {
	private  int iteration;
	private static DefaultTableModel tableModel;
	private ArrayList<Person> people=new ArrayList<Person> ();
	private JTable table;
	/**
	 * Create the panel.
	 */
	public Query_ShowPeopleWithRareBloodType(MainMenu mm) {
		setBackground(Color.WHITE);
		setLayout(null);
		

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 765, 84);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblAddPerson = new JLabel("Show people with rare blood type");
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
		scrollPane.setBounds(51, 60, 650, 310);
		scrollPane.setBackground(Color.WHITE);
		panel_1.add(scrollPane);
		tableModel = new DefaultTableModel() {

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		String header[] = new String[] {"ID" ,"First name", "Sur name", "Date of birth", "City","Street","Gender","Phone","Blood type","Care facility","Contact ID"};
		 tableModel.setColumnIdentifiers(header);
		 table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 10));
		 table.getTableHeader().setBackground(Color.WHITE);
		 setLayout(null);
		 table.setModel(tableModel);
		 table.setRowHeight(25);
		 
		  //Set table dimensions
		    TableColumnModel columnModel = table.getColumnModel();
		    columnModel.getColumn(0).setPreferredWidth(110);
		    columnModel.getColumn(1).setPreferredWidth(120);
		    columnModel.getColumn(2).setPreferredWidth(120);
		    columnModel.getColumn(3).setPreferredWidth(120);
		    columnModel.getColumn(4).setPreferredWidth(120);
		    columnModel.getColumn(5).setPreferredWidth(120);
		    columnModel.getColumn(6).setPreferredWidth(75);
		    columnModel.getColumn(7).setPreferredWidth(120);
		    columnModel.getColumn(8).setPreferredWidth(100);
		    columnModel.getColumn(9).setPreferredWidth(120);
		    columnModel.getColumn(10).setPreferredWidth(110);
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
		  /*  else{

		    	table.getColumnModel().getColumn(0).getCellEditor().stopCellEditing();
		    	table.getColumnModel().getColumn(1).getCellEditor().stopCellEditing();
				table.getColumnModel().getColumn(2).getCellEditor().stopCellEditing();
				table.getColumnModel().getColumn(3).getCellEditor().stopCellEditing();
				table.getColumnModel().getColumn(4).getCellEditor().stopCellEditing();
				table.getColumnModel().getColumn(5).getCellEditor().stopCellEditing();
				table.getColumnModel().getColumn(6).getCellEditor().stopCellEditing();
				table.getColumnModel().getColumn(7).getCellEditor().stopCellEditing();
		    }*/

		//Following code clear table (used while browsing between orders)
		tableModel =(DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);

		//Following code gets all orders details for selected order id and updates table rows
		people = Logic.getInstance().ShowPeopleWithRareBloodType();
		
		int i=0;
		
		while (i<people.size()){
		    Vector<Object> data = new Vector<Object>();
		 //   patient=patients.get(i).getId();
		    data.add(people.get(i).getId());
		    //setPatientID(patients.get(i).getId());
		    data.add(people.get(i).getFirstName());
		    data.add(people.get(i).getSurName());
		    data.add(people.get(i).getDateOfBirth());
		    data.add(people.get(i).getCity());
		    data.add(people.get(i).getStreet());
		    data.add(people.get(i).getGender());
		    data.add(people.get(i).getPhoneNumber());
		    data.add(people.get(i).getBloodType());
		    data.add(people.get(i).getCareFacility());
		    data.add(people.get(i).getContact().getId());
		    i++;
		    tableModel.addRow(data);
		 	}

	 	
	 	// 	First row is been focused and selected by default
	    table.changeSelection(0, 0, false, false);
	    table.requestFocus();
	   
	   /* //set column components
	    setUpProductNameColumnComboBox(table, table.getColumnModel().getColumn(1));
	 	setUpTextEditor(table, 0,tfProductId);
	 	setUpTextEditor(table, 2,tfUnitPrice);
	 	setUpTextEditor(table, 3,tfQuantity);
	 	setUpTextEditor(table, 4,tfDiscount);
	 	setUpTextEditor(table, 5,tfTotal);
*/
	 	//Notifies all listeners that all cell values in the table's rows may have changed.
	 	tableModel.fireTableDataChanged();
	
	 
	}
}
