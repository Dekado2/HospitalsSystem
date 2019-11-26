package view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.JComboBox;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;


import controller.Logic;
import model.Doctor;
import model.Hospital;
import model.Person;

import java.awt.BorderLayout;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Panel_View_Vacations extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static DefaultTableModel tableModel;
	private ArrayList<Date> vacationDates=new ArrayList<Date>();
	private  int iteration;
	private boolean isSelcted;
	private String doctorID;
	private JTable table;
	private ArrayList<Hospital> hospitals;
	HashMap<String,HashMap<String,ArrayList<Date>>> vacations;
	private boolean isAdmin = true;
	private JComboBox<String> cbHospitalName;

	/**
	 * Create the panel.
	 */
	public Panel_View_Vacations(MainMenu mm) {
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));
		setLayout(null);
	
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 765, 39);
		add(panel);
		panel.setLayout(null);
		
		JLabel titleViewVacations = new JLabel("View Vacations");
		titleViewVacations.setFont(new Font("Tahoma", Font.PLAIN, 30));
		titleViewVacations.setForeground(new Color(25, 25, 112));
		titleViewVacations.setBounds(46, 6, 207, 33);
		panel.add(titleViewVacations);
		
		cbHospitalName = new JComboBox<String>();
		cbHospitalName.setToolTipText("Select a hospital to view all doctors vacations in the selected hospital.");
		cbHospitalName.setBounds(563, 11, 117, 20);
		panel.add(cbHospitalName);
		
		JLabel lblHospitalName = new JLabel("Select a hospital:");
		lblHospitalName.setToolTipText("Select a hospital to view all doctors vacations in the selected hospital.");
		lblHospitalName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHospitalName.setBounds(439, 12, 113, 14);
		panel.add(lblHospitalName);
		
		// if admin is logged in, otherwise hide
				hospitals = Logic.getInstance().getHospitals();
				for (int i=0; i<hospitals.size();i++)
					cbHospitalName.addItem(hospitals.get(i).getName());
				
				if (mm.getUser().getType().equals("doctor"))
				{
					cbHospitalName.setEnabled(false);
					cbHospitalName.setSelectedItem(Logic.getInstance().getDoctorDetails(mm.getUser().getUsername()).getHospital().getName());
				}
				
				vacations = Logic.getInstance().getHospitalDoctorsVacations(cbHospitalName.getSelectedItem().toString());
				
				cbHospitalName.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						vacations = Logic.getInstance().getHospitalDoctorsVacations(cbHospitalName.getSelectedItem().toString());
						refreshComp();
					}
				});
		
		tableModel = new DefaultTableModel() {

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		String header[];
		if (isAdmin==false)
		    header = new String[] { "Day", "Month", "Year"};
		else
			header = new String[] {"Doctor ID", "Full Name" , "Day", "Month", "Year"};
		 tableModel.setColumnIdentifiers(header);
		 setLayout(null);
		    
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(Color.WHITE);
			panel_1.setBounds(0, 40, 765, 380);
			add(panel_1);
			panel_1.setLayout(null);
				
	
				
				table = new JTable();
				
					
					table.setFont(new Font("Tahoma", Font.PLAIN, 14));
					//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
					table.setBackground(Color.WHITE);
						JScrollPane scrollPane = new JScrollPane(table);
						scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
						scrollPane.setBounds(13, 0, 752, 325);
						scrollPane.setBackground(Color.WHITE);
						panel_1.add(scrollPane);
						table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 10));
						table.getTableHeader().setBackground(Color.WHITE);
						table.setModel(tableModel);
						table.setRowHeight(25);
						//Set table dimensions
						  TableColumnModel columnModel = table.getColumnModel();
						  columnModel.getColumn(0).setPreferredWidth(25);
						    columnModel.getColumn(1).setPreferredWidth(25);
						    columnModel.getColumn(2).setPreferredWidth(25);
						  table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						  
						  JButton btnRemove = new JButton("Remove");
						  btnRemove.addActionListener(new ActionListener() {
						  	public void actionPerformed(ActionEvent arg0) {
						  		Object[] options = {"Yes","No"};
								int n = JOptionPane.showOptionDialog(null, "Are you sure you want to cancel the selected vacation date?","Cancel Vacation Date",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[1]);
								if (n==0)
								{	
						  		if (table.getSelectionModel().isSelectionEmpty())
									JOptionPane.showMessageDialog(null, "You must first select a date from the table!");
						  		else
						  		{
						  			Calendar cal = Calendar.getInstance();
						  			String monthName ="";
						  			int month = 0, day = 0, year = 0;
						  			if (isAdmin==true)
						  			{
						  			    monthName = (String) table.getValueAt(table.getSelectedRow(), 3);
						  			    day = (Integer) table.getValueAt(table.getSelectedRow(), 2);
						  			    year = (Integer) table.getValueAt(table.getSelectedRow(), 4);
						  			}
						  			else
						  			{
						  				monthName = (String) table.getValueAt(table.getSelectedRow(), 1);
							  			day = (Integer) table.getValueAt(table.getSelectedRow(), 0);
							  			year = (Integer) table.getValueAt(table.getSelectedRow(), 2);
						  			}
						  			if (monthName.equals("January"))
						  				month = 1;
						  			else if (monthName.equals("February"))
						  				month = 2;
						  			else if (monthName.equals("March"))
						  				month = 3;
						  			else if (monthName.equals("April"))
						  				month = 4;
						  			else if (monthName.equals("May"))
						  				month = 5;
						  			else if (monthName.equals("June"))
						  				month = 6;
						  			else if (monthName.equals("July"))
						  				month = 7;
						  			else if (monthName.equals("August"))
						  				month = 8;
						  			else if (monthName.equals("September"))
						  				month = 9;
						  			else if (monthName.equals("October"))
						  				month = 10;
						  			else if (monthName.equals("November"))
						  				month = 11;
						  			else if (monthName.equals("December"))
						  				month = 12;
						  			cal.set(Calendar.YEAR, year);
						  			cal.set(Calendar.MONTH, month-1);
						  			cal.set(Calendar.DAY_OF_MONTH, day);
						  			Date date = cal.getTime();
						  			Date dt = new Date();
						  			Calendar c = Calendar.getInstance();
						  			c.setTime(dt);
						  			c.add(Calendar.DATE, 1);
						  			dt = c.getTime();
						  			dt.setHours(0);
						  			dt.setMinutes(0);
						  			dt.setSeconds(0);
						  			if (date.before(dt)) // maybe allow admin to delete any vacation date, regardless of time
						  				JOptionPane.showMessageDialog(null, "You may not cancel a vacation date that has already passed!");
						  			else
						  			{
						  				date =  new java.sql.Date(date.getTime());
						  				String name = "";
						  				if (isAdmin==false)
						  				Logic.getInstance().RemoveVacation("305911853", date); // need to change according to whichever doctor logs in
						  				else
						  				{
						  					name = (String)table.getValueAt(table.getSelectedRow(), 1);
						  					Logic.getInstance().RemoveVacation((String)table.getValueAt(table.getSelectedRow(), 0), date);
						  				}
						  				refreshComp();
						  				if (isAdmin==false)
						  				JOptionPane.showMessageDialog(null, date + " is no longer a vacation day!");
						  				else
						  					JOptionPane.showMessageDialog(null, name + " no longer has a vacation day on " + date + "!");
						  			}
						  		}
						  	}
						   }
					   });
						  
						  mm.getBtnAdd().addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									Panel_View_Vacations.this.setVisible(false);
									
								}
							});
						  
						  btnRemove.setIcon(new ImageIcon(Panel_View_Vacations.class.getResource("/view/icons/rubbish-bin.png")));
						  btnRemove.setForeground(Color.WHITE);
						  btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 17));
						  btnRemove.setBackground(new Color(70, 130, 180));
						  btnRemove.setBounds(631, 328, 123, 37);
						  panel_1.add(btnRemove);
	}
	


	public void refreshComp(){
		if (isAdmin==false)
		initTableData();
		else
			initAdminTableData();
		
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
		vacationDates = Logic.getInstance().getDoctorVacations("305911853"); // need to change according to whichever doctor logs in
		int i=0;
	 	while (i<vacationDates.size()){
	    Vector<Object> data = new Vector<Object>();
	    Calendar cal = Calendar.getInstance();
		cal.setTime(vacationDates.get(i));
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);
		String monthName = "";
		if (month==1)
			monthName = "January";
		else if (month==2)
			monthName = "February";
		else if (month==3)
			monthName = "March";
		else if (month==4)
			monthName = "April";
		else if (month==5)
			monthName = "May";
		else if (month==6)
			monthName = "June";
		else if (month==7)
			monthName = "July";
		else if (month==8)
			monthName = "August";
		else if (month==9)
			monthName = "September";
		else if (month==10)
			monthName = "October";
		else if (month==11)
			monthName = "November";
		else if (month==12)
			monthName = "December";
	    data.add(day);
	    data.add(monthName);
	    data.add(year);
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
	 	DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	 	centerRenderer.setHorizontalAlignment( JLabel.CENTER );
	 	table.setDefaultRenderer(Object.class, centerRenderer);
	 	
	}
	
	private void initAdminTableData(){
		if (iteration ==0) {
		 	iteration++;
			}

		//Following code clear table (used while browsing between orders)
		tableModel =(DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);

		//Following code gets all orders details for selected order id and updates table rows
		vacations = Logic.getInstance().getHospitalDoctorsVacations(cbHospitalName.getSelectedItem().toString());
		int i=0;
	 	for (String id : vacations.keySet()){
	 		for (String name : vacations.get(id).keySet()){
	 			for (Date d : vacations.get(id).get(name)){
	    Vector<Object> data = new Vector<Object>();
	    data.add(id);
	    data.add(name);
	    Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);
		String monthName = "";
		if (month==1)
			monthName = "January";
		else if (month==2)
			monthName = "February";
		else if (month==3)
			monthName = "March";
		else if (month==4)
			monthName = "April";
		else if (month==5)
			monthName = "May";
		else if (month==6)
			monthName = "June";
		else if (month==7)
			monthName = "July";
		else if (month==8)
			monthName = "August";
		else if (month==9)
			monthName = "September";
		else if (month==10)
			monthName = "October";
		else if (month==11)
			monthName = "November";
		else if (month==12)
			monthName = "December";
	    data.add(day);
	    data.add(monthName);
	    data.add(year);
	    i++;
	    tableModel.addRow(data);
	 			}
	 		}
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
	 	DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	 	centerRenderer.setHorizontalAlignment( JLabel.CENTER );
	 	table.setDefaultRenderer(Object.class, centerRenderer);
	 	
	}
	
	public static DefaultTableModel getTableModel() {
		return tableModel;
	}

	public static void setTableModel(DefaultTableModel tableModel) {
		Panel_View_Vacations.tableModel = tableModel;
	}


	public   String getPatientID() {
		return doctorID;
	}

	public ArrayList<Date> getVacationDates() {
		return vacationDates;
	}

	public JTable getTable() {
		return table;
	}

	public boolean isSelcted() {
		return isSelcted;
	}
	
	public JComboBox<String> getCbHospitalName() {
		return cbHospitalName;
	}

	public void setCbHospitalName(JComboBox<String> cbHospitalName) {
		this.cbHospitalName = cbHospitalName;
	}
	
}
