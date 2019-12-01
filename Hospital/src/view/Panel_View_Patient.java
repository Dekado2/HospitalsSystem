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

public class Panel_View_Patient extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static DefaultTableModel tableModel;
	private ArrayList<Person> patients=new ArrayList<Person>();
	private JButton btnUpdate;
	private  int iteration;
	private boolean isSelcted;
	private String patientID;
	private JTable table;
	private Panel_update_PatientDetails updatePatient;

	public Panel_update_PatientDetails getUpdatePatient() {
		return updatePatient;
	}



	/**
	 * Create the panel.
	 */
	public Panel_View_Patient(MainMenu mm) {
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));
		setLayout(null);
	
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 765, 39);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblAddPerson = new JLabel("View patients");
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
					JOptionPane.showMessageDialog(null, "You must first select a patient from the table!");
				else
				{
					updatePatient = new Panel_update_PatientDetails(table.getModel().getValueAt(table.getSelectedRow(), 0).toString(),mm);
					mm.getContentPane().add(updatePatient);
					updatePatient.setBounds(261, 156, 765, 414);
					updatePatient.setVisible(true);
					Panel_View_Patient.this.setVisible(false);
					Panel_View_Patient.this.setEnabled(false);
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnUpdate.setBounds(631, 328, 123, 37);
		panel_1.add(btnUpdate);
		btnUpdate.setIcon(new ImageIcon(Panel_View_Patient.class.getResource("/view/icons/refresh-arrows.png")));
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
		 String header[] = new String[] { "Patient ID", "First name", "Sur name", "Date of birth", "City","Street","Gender","Phone","Blood type","Care facility","Contact ID"};
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
			
			JButton btnRemove = new JButton("Remove");
		
			btnRemove.setIcon(new ImageIcon(Panel_View_Patient.class.getResource("/view/icons/rubbish-bin.png")));
			btnRemove.setForeground(Color.WHITE);
			btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 17));
			btnRemove.setBackground(new Color(70, 130, 180));
			btnRemove.setBounds(502, 328, 123, 37);
			panel_1.add(btnRemove);
			btnRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Object[] options = {"Yes","No"};
					int n = JOptionPane.showOptionDialog(null, "Are you sure you want to remove the selected patient?","Remove Patient",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[1]);
					if (n==0)
					{
						if (table.getSelectionModel().isSelectionEmpty())
							JOptionPane.showMessageDialog(null, "You must first select a patient from the table!");
						else
						{
							Patient pTmp= new Patient(table.getModel().getValueAt(table.getSelectedRow(), 0).toString());
							if(Logic.getInstance().removePatient(table.getModel().getValueAt(table.getSelectedRow(), 0).toString()))
								Logic.getInstance().removePerson(pTmp.getId());
							
			  				refreshComp();
			  				JOptionPane.showMessageDialog(null,"Patient "+ pTmp.getId() + " removed successfully!");	
							
						}
					}
					
				}
			});
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
		patients = Logic.getInstance().getPatients();
		int i=0;
		
	 	while (i<patients.size()){
	    Vector<Object> data = new Vector<Object>();
	 //   patient=patients.get(i).getId();
	    data.add(patients.get(i).getId());
	    //setPatientID(patients.get(i).getId());
	    data.add(patients.get(i).getFirstName());
	    data.add(patients.get(i).getSurName());
	    data.add(patients.get(i).getDateOfBirth());
	    data.add(patients.get(i).getCity());
	    data.add(patients.get(i).getStreet());
	    data.add(patients.get(i).getGender());
	    data.add(patients.get(i).getPhoneNumber());
	    data.add(patients.get(i).getBloodType());
	    data.add(patients.get(i).getCareFacility());
	    data.add(patients.get(i).getContact().getId());
	    i++;
	    tableModel.addRow(data);
	 	}
	 	//-------------------

	 	
	 	// 	First row is been focused and selected by default
	    table.changeSelection(0, 0, false, false);
	    table.requestFocus();

	 	//Notifies all listeners that all cell values in the table's rows may have changed.
	 	tableModel.fireTableDataChanged();
	
	
	 
	}
	public static DefaultTableModel getTableModel() {
		return tableModel;
	}





	public static void setTableModel(DefaultTableModel tableModel) {
		Panel_View_Patient.tableModel = tableModel;
	}


	public   String getPatientID() {
		return patientID;
	}

	public ArrayList<Person> getPatients() {
		return patients;
	}




	public JTable getTable() {
		return table;
	}




	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}

	public JButton getBtnUpdate() {
		return btnUpdate;
	}
	public boolean isSelcted() {
		return isSelcted;
	}
	
	
	
}
