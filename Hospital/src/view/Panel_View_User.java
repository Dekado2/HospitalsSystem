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
import model.Department;
import model.Hospital;
import model.Patient;
import model.Person;
import model.Room;
import model.User;

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

public class Panel_View_User extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static DefaultTableModel tableModel;
	private ArrayList<User> users=new ArrayList<User>();
	private JButton btnUpdate;
	private  int iteration;
	private String userName;
	private JTable table;
	private Panel_update_UserDetails updateUser;

	/**
	 * Create the panel.
	 */
	public Panel_View_User(MainMenu mm) {
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));
		setLayout(null);
	
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 765, 39);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblAddPerson = new JLabel("View Users");
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
					JOptionPane.showMessageDialog(null, "You must first select a user from the table!");
				else
				{
					updateUser = new Panel_update_UserDetails(table.getModel().getValueAt(table.getSelectedRow(), 0).toString(),mm);
					mm.getContentPane().add(updateUser);
					updateUser.setBounds(261, 156, 765, 414);
					updateUser.setVisible(true);
					Panel_View_User.this.setVisible(false);
					Panel_View_User.this.setEnabled(false);
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnUpdate.setBounds(631, 328, 123, 37);
		panel_1.add(btnUpdate);
		btnUpdate.setIcon(new ImageIcon(Panel_View_User.class.getResource("/view/icons/refresh-arrows.png")));
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
		 String header[] = new String[] { "Username", "Password" , "User Display First Name", "User Display Surname", "User Type", "Secret Question", "Secret Answer"};
		 tableModel.setColumnIdentifiers(header);
		 table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 10));
		 table.getTableHeader().setBackground(Color.WHITE);
		 setLayout(null);
		 table.setModel(tableModel);
		 table.setRowHeight(25);
		  //Set table dimensions
		    TableColumnModel columnModel = table.getColumnModel();
		    columnModel.getColumn(0).setPreferredWidth(100);
		    columnModel.getColumn(1).setPreferredWidth(100);
		    columnModel.getColumn(2).setPreferredWidth(132);
		    columnModel.getColumn(3).setPreferredWidth(132);
		    columnModel.getColumn(4).setPreferredWidth(100);
		    columnModel.getColumn(5).setPreferredWidth(200);
		    columnModel.getColumn(6).setPreferredWidth(200);
		
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			JButton btnRemove = new JButton("Remove");
			btnRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Object[] options = {"Yes","No"};
					int n = JOptionPane.showOptionDialog(null, "Are you sure you want to remove the selected user?","Remove User",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[1]);
					if (n==0)
					{
						if (table.getSelectionModel().isSelectionEmpty())
							JOptionPane.showMessageDialog(null, "You must first select a user from the table!");
						else if (table.getModel().getValueAt(table.getSelectedRow(), 0).equals("admin"))
							JOptionPane.showMessageDialog(null, "You cannot remove the user: admin!");
						else if (table.getModel().getValueAt(table.getSelectedRow(), 4).equals("admin") && mm.getUser().getUsername().equals(table.getModel().getValueAt(table.getSelectedRow(), 0)))
							JOptionPane.showMessageDialog(null, "You cannot remove a user that you are logged in with!");
						else
						{
							userName = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
							Logic.getInstance().removeUser(userName);
			  				refreshComp();
			  				JOptionPane.showMessageDialog(null,"User "+ userName + " removed successfully!");
						}
					}
				}
			});
			btnRemove.setIcon(new ImageIcon(Panel_View_User.class.getResource("/view/icons/rubbish-bin.png")));
			btnRemove.setForeground(Color.WHITE);
			btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 17));
			btnRemove.setBackground(new Color(70, 130, 180));
			btnRemove.setBounds(502, 328, 123, 37);
			panel_1.add(btnRemove);
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
		tableModel =(DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);

		//Following code gets all orders details for selected order id and updates table rows
		users = Logic.getInstance().getAllUsers();
		int i=0;
		
	 	while (i<users.size()){
	    Vector<Object> data = new Vector<Object>();
	 
	   
	    data.add(users.get(i).getUsername());
	    data.add(users.get(i).getPassword());
	    data.add(users.get(i).getDisplayFirstName());
	    data.add(users.get(i).getDisplayLastName());
	    data.add(users.get(i).getType());
	    data.add(users.get(i).getSecretQuestion());
	    data.add(users.get(i).getSecretAnswer());
	 
	    i++;
	    tableModel.addRow(data);
	 	}
	 	//-------------------

	 	
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
		Panel_View_User.tableModel = tableModel;
	}








	public JTable getTable() {
		return table;
	}


	public JButton getBtnUpdate() {
		return btnUpdate;
	}

	/*public Panel_update_RoomDetails getUpdateRoom() {
		return updateRoom;
	}*/
	
}
