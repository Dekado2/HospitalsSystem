package view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.util.Date;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.JComboBox;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;


import controller.Logic;
import model.Doctor;
import model.Hospitalized;
import model.Patient;
import model.Person;

import java.awt.BorderLayout;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Panel_View_Doctor extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static DefaultTableModel tableModel;
	private ArrayList<Doctor> doctors=new ArrayList<Doctor>();
	private JButton btnUpdate;
	private  int iteration;
	private boolean isSelcted;
	private String doctorID;
	private JTable table;
	private Panel_update_DoctorDetails updateDoctor;

	/**
	 * Create the panel.
	 */
	public Panel_View_Doctor(MainMenu mm) {
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));
		setLayout(null);
	
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 765, 39);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblAddPerson = new JLabel("View doctors");
		lblAddPerson.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblAddPerson.setForeground(new Color(25, 25, 112));
		lblAddPerson.setBounds(46, 6, 207, 33);
		panel.add(lblAddPerson);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 40, 765, 380);
		add(panel_1);
		panel_1.setLayout(null);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectionModel().isSelectionEmpty())
					JOptionPane.showMessageDialog(null, "You must first select a doctor from the table!");
				else
				{
					 updateDoctor = new Panel_update_DoctorDetails(table.getModel().getValueAt(table.getSelectedRow(), 0).toString(),mm);
					mm.getContentPane().add(updateDoctor);
					updateDoctor.setBounds(261, 156, 765, 414);
					updateDoctor.setVisible(true);
					mm.getAddP().setVisible(false);
					mm.getAddR().setVisible(false);
					mm.getAddHos().setVisible(false);
					mm.getAddHos().setEnabled(false);
					Panel_View_Doctor.this.setVisible(false);
					Panel_View_Doctor.this.setEnabled(false);
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnUpdate.setBounds(631, 328, 123, 37);
		panel_1.add(btnUpdate);
		btnUpdate.setIcon(new ImageIcon(Panel_View_Doctor.class.getResource("/view/icons/refresh-arrows.png")));
		btnUpdate.setForeground(new Color(255, 255, 255));
	
		btnUpdate.setBackground(new Color(70, 130, 180));
		
	
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  
		table.setBackground(Color.WHITE);
	
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(13, 0, 752, 325);
		scrollPane.setBackground(Color.WHITE);
		panel_1.add(scrollPane);
		tableModel = new DefaultTableModel() {

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		String header[] = new String[] { "Doctor ID", "First name", "Sur name", "Date of birth", "City","Street","Gender","Phone","Blood type","Care facility","Date of Graduation","Manager","HospitalID","Hospital Name", "DepartmentID", "Department Name"};
		 tableModel.setColumnIdentifiers(header);
		 table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 10));
		 table.getTableHeader().setBackground(Color.WHITE);
		 setLayout(null);
		 table.setModel(tableModel);
		 table.setRowHeight(25);
		 
		  //Set table dimensions
		    TableColumnModel columnModel = table.getColumnModel();
		    columnModel.getColumn(0).setWidth(200);
		    columnModel.getColumn(1).setPreferredWidth(120);
		    columnModel.getColumn(2).setPreferredWidth(120);
		    columnModel.getColumn(3).setPreferredWidth(120);
		    columnModel.getColumn(4).setPreferredWidth(120);
		    columnModel.getColumn(5).setPreferredWidth(120);
		    columnModel.getColumn(6).setPreferredWidth(80);
		    columnModel.getColumn(7).setPreferredWidth(120);
		    columnModel.getColumn(8).setPreferredWidth(80);
		    columnModel.getColumn(9).setPreferredWidth(100);
		    columnModel.getColumn(10).setPreferredWidth(110);
		    columnModel.getColumn(11).setPreferredWidth(120);
		    columnModel.getColumn(12).setPreferredWidth(100);
		    columnModel.getColumn(13).setPreferredWidth(100);
		    columnModel.getColumn(14).setPreferredWidth(100);
		    columnModel.getColumn(15).setPreferredWidth(100);
		
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setPreferredScrollableViewportSize(table.getPreferredSize()); 
			
			
			
			JButton btnRemove = new JButton("Remove");
			
			btnRemove.setIcon(new ImageIcon(Panel_View_Doctor.class.getResource("/view/icons/rubbish-bin.png")));
			btnRemove.setForeground(Color.WHITE);
			btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 17));
			btnRemove.setBackground(new Color(70, 130, 180));
			btnRemove.setBounds(502, 328, 123, 37);
			panel_1.add(btnRemove);
			btnRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Object[] options = {"Yes","No"};
					ArrayList<Hospitalized> hosp= new ArrayList<Hospitalized>();
					ArrayList<Date> vacationDates = new ArrayList<Date>();
					ArrayList<Person> patients = new ArrayList<Person>();
					 boolean docWorksInSHift=false;
					 boolean hasVacation=false;
					 boolean isHospitalized=false;
					 int isPatient=-1;
					Person dTmp= new Person(table.getModel().getValueAt(table.getSelectedRow(), 0).toString());
					int n = JOptionPane.showOptionDialog(null, "Are you sure you want to remove the selected doctor?","Remove Doctor",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[1]);
					if (n==0)
					{
						if (table.getSelectionModel().isSelectionEmpty())
							JOptionPane.showMessageDialog(null, "You must first select a doctor from the table!");
						else
						{
							//לטפל במקרה של CheckedBy
							hosp=Logic.getInstance().getHospitalized();
							patients=Logic.getInstance().getPatients();
							
							for(Person p:patients)
								if(p.getId().equals(dTmp.getId()))
									isPatient=1;
							for(Hospitalized h: hosp)
								if(h.getPatient().getId().equals(dTmp.getId()))
									isHospitalized=true;
							vacationDates=Logic.getInstance().getDoctorVacations(dTmp.getId());
							if(!vacationDates.isEmpty())
								hasVacation=true;
							 docWorksInSHift=Logic.getInstance().isWorkingInShift(dTmp.getId());
							 
							 if(isPatient>=0) {
								 if(isHospitalized)
									 Logic.getInstance().removeDoctorHospitalizations(dTmp.getId());
								 Logic.getInstance().removePatient(dTmp.getId());
							 }
							 if(hasVacation)
								 Logic.getInstance().removeDoctorVacations(dTmp.getId());
							 if(docWorksInSHift)
								 Logic.getInstance().removeDoctorShifts(dTmp.getId());
							Logic.getInstance().removeDoctor(dTmp.getId());
							Logic.getInstance().removePerson(dTmp.getId());
			  				refreshComp(mm);
			  				JOptionPane.showMessageDialog(null,"Doctor "+ dTmp.getId() + " removed successfully!");	
						}
					}
				}
			});
				
		
		
			
	}
	


	public void refreshComp(MainMenu mm){
		
		initTableData(mm);
		
	}
	
	private void initTableData(MainMenu mm){
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
		if (!mm.getUser().getType().equals("doctor"))
		doctors = Logic.getInstance().getDoctors();
		else
			doctors = Logic.getInstance().getDoctorsOfHospitalID(Logic.getInstance().getDoctorDetails(mm.getUser().getUsername()).getHospital().getHospitalID());
		int i=0;
		String doctor;
	 	while (i<doctors.size()){
	    Vector<Object> data = new Vector<Object>();
	    doctor=doctors.get(i).getId();
	    data.add(doctors.get(i).getId());
	    setDoctorID(doctor);
	 
	    data.add(doctors.get(i).getFirstName());
	    data.add(doctors.get(i).getSurName());
	    data.add(doctors.get(i).getDateOfBirth());
	    data.add(doctors.get(i).getCity());
	    data.add(doctors.get(i).getStreet());
	    data.add(doctors.get(i).getGender());
	    data.add(doctors.get(i).getPhoneNumber());
	    data.add(doctors.get(i).getBloodType());
	    data.add(doctors.get(i).getCareFacility());
	    data.add(((Doctor)doctors.get(i)).getDateOfGraduation());
	    data.add(((Doctor)doctors.get(i)).isManager());
	    data.add(((Doctor)doctors.get(i)).getHospital().getHospitalID());
	    data.add(((Doctor)doctors.get(i)).getHospital().getName());
	    data.add(((Doctor)doctors.get(i)).getDepartment().getDepartmentID());
	    data.add(((Doctor)doctors.get(i)).getDepartment().getDepartmentName());
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
	public static DefaultTableModel getTableModel() {
		return tableModel;
	}





	public static void setTableModel(DefaultTableModel tableModel) {
		Panel_View_Doctor.tableModel = tableModel;
	}


	public   String getPatientID() {
		return doctorID;
	}

	public ArrayList<Doctor> getPatients() {
		return doctors;
	}




	public JTable getTable() {
		return table;
	}






	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}



	public Panel_update_DoctorDetails getUpdateDoctor() {
		return updateDoctor;
	}



	public JButton getBtnUpdate() {
		return btnUpdate;
	}
	public boolean isSelcted() {
		return isSelcted;
	}
}
