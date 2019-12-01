package view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.OptionPaneUI;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

import com.toedter.calendar.DateUtil;
import com.toedter.calendar.IDateEvaluator;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;

import controller.Logic;
import model.Doctor;
import model.Hospital;

import java.awt.BorderLayout;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.util.Date;
import java.util.HashMap;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ItemEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class Panel_add_Vacations extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Date> vacationDates;
    private Date date;
    private boolean bool = false;
    private boolean boolAdmin = false;
    private JCalendar vacationDate;
    private ArrayList<Hospital> hospitals;
    HashMap<String,HashMap<String,ArrayList<Date>>> vacations;
    private ArrayList<Date> dates = new ArrayList<Date>();
    private Date date2;
    private HashMap<String,String> doctors;
    private boolean adminLoggedIn = true;
    private boolean trigger = false;
    private JComboBox<String> cbHospitalName;
	/**
	 * Create the panel.
	 */
	public Panel_add_Vacations(MainMenu mm) {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 765, 39);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblAddVacation = new JLabel("Add Vacation");
		lblAddVacation.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblAddVacation.setForeground(new Color(25, 25, 112));
		lblAddVacation.setBounds(43, 6, 207, 33);
		panel.add(lblAddVacation);
		
		
		
		cbHospitalName = new JComboBox<String>();
		cbHospitalName.setToolTipText("Select a hospital to view all doctors vacations in the selected hospital.");
		cbHospitalName.setBounds(563, 18, 117, 20);
		panel.add(cbHospitalName);
		
		JLabel lblHospitalName = new JLabel("Select a hospital:");
		lblHospitalName.setToolTipText("Select a hospital to view all doctors vacations in the selected hospital.");
		lblHospitalName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHospitalName.setBounds(439, 18, 113, 14);
		panel.add(lblHospitalName);
		
		JPanel panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_11.setBackground(Color.WHITE);
		panel_11.setBounds(49, 62, 662, 294);
		add(panel_11);
		
		vacationDate = new JCalendar();
		vacationDate.getMonthChooser().getComboBox().setBackground(Color.WHITE);
		vacationDate.getDayChooser().getDayPanel().setBackground(new Color(240, 248, 255));
		vacationDate.getDayChooser().setToolTipText("");
		vacationDate.setBackground(Color.WHITE);
		vacationDate.getDayChooser().setAlwaysFireDayProperty(false);
		vacationDate.getDayChooser().setDay(1);
		vacationDate.getDayChooser().setWeekOfYearVisible(false);
		vacationDate.setBounds(0, 0, 662, 294);
		panel_11.add(vacationDate);
		
		// if admin is logged in, otherwise hide
		hospitals = Logic.getInstance().getHospitals();
		for (int i=0; i<hospitals.size();i++)
			cbHospitalName.addItem(hospitals.get(i).getName());
		
		if (mm.getUser().getType().equals("doctor"))
		{
			cbHospitalName.setEnabled(false);
			cbHospitalName.setSelectedItem(Logic.getInstance().getDoctorDetails(mm.getUser().getUsername()).getHospital().getName());
		}
		
		// if admin is logged in
		vacations = Logic.getInstance().getHospitalDoctorsVacations(cbHospitalName.getSelectedItem().toString());
		//else - line below
		vacationDates = Logic.getInstance().getDoctorVacations("305911853");
		Date dt = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.DATE, 1);
		dt = c.getTime();
		dt.setHours(0);
		dt.setMinutes(0);
		dt.setSeconds(0);
		vacationDate.setMinSelectableDate(dt);
		
		JComboBox<String> cbDoctorsOfSelectedHospital = new JComboBox<String>();
		cbDoctorsOfSelectedHospital.setBounds(563, 18, 117, 20);
		
		vacationDate.addPropertyChangeListener(new PropertyChangeListener() {
	          @Override
	          public void propertyChange(PropertyChangeEvent evt) {
	             date =  new java.sql.Date(vacationDate.getDate().getTime());
	                Date dt = new Date();
					Calendar c = Calendar.getInstance();
					dt.setHours(0);
					dt.setMinutes(0);
					dt.setSeconds(0);
					c.set(Calendar.DAY_OF_MONTH, 1);
					c.set(Calendar.MONTH, vacationDate.getMonthChooser().getMonth());
					dt = c.getTime();
					for (Date d : vacationDates)
					{
						Calendar cal = Calendar.getInstance();
						cal.setTime(d);
						Calendar cal2 = Calendar.getInstance();
						cal2.setTime(dt);
						int day = cal.get(Calendar.DAY_OF_MONTH);
						int day2= cal2.get(Calendar.DAY_OF_MONTH);
						int month = cal.get(Calendar.MONTH);
						int month2 = cal2.get(Calendar.MONTH);
						int year = cal.get(Calendar.YEAR);
						int year2 = cal2.get(Calendar.YEAR);
						if (day==day2 && month==month2 && year==year2)
						{
							vacationDate.getYearChooser().setYear(0);
							vacationDate.getYearChooser().setYear(year2);
					        break;
						}
					}
					if (trigger==false){
						trigger = true;
					vacationDate.getYearChooser().setYear(0);
					vacationDate.getYearChooser().setYear(Calendar.getInstance().get(Calendar.YEAR)); 
					}
					cbHospitalName.setSelectedItem(cbHospitalName.getSelectedItem());
	          }
	      });
		
		vacationDate.getDayChooser().addDateEvaluator(new IDateEvaluator()
				{
					@Override
					public Color getInvalidBackroundColor() {
						return new Color(135,206,235);
					}

					@Override
					public Color getInvalidForegroundColor() {
						return null;
					}

					@Override
					public String getInvalidTooltip() {
						return null;
					}

					@Override
					public Color getSpecialBackroundColor() {
						return new Color(135,206,235);
					}

					@Override
					public Color getSpecialForegroundColor() {
						return null;
					}

					@Override
					public String getSpecialTooltip() {
						String s = "<html> Doctors on vacation on ";
						for (String id : vacations.keySet())
							for (String name : vacations.get(id).keySet()){
								for (int i=0;i<vacations.get(id).get(name).size();i++)
								for (Date d : dates)
									if (vacations.get(id).get(name).get(i).equals(d)){
										if (!s.contains("are:")){
										date2 =  new java.sql.Date(d.getTime());
										s = s + date2 + " are: <br> ";
										}
								s = s + " " + name + " <br> ";
									}
								}
						s = s + "</html>";
						dates = new ArrayList<Date>();
						return s;
					}

					@Override
					public boolean isInvalid(Date arg0) {
						return false;
						
						
					}

					@Override
					public boolean isSpecial(Date arg0) {
						for (String id : vacations.keySet())
							for (String name : vacations.get(id).keySet())
							for (Date d : vacations.get(id).get(name))
								if (arg0.equals(d)){
									dates.add(arg0);
									return true;
								}
							return false;
					}
			
				});
		c.set(Calendar.DAY_OF_MONTH, 1);
		dt = c.getTime();
		vacationDate.setDate(dt);
		
		cbHospitalName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vacations = Logic.getInstance().getHospitalDoctorsVacations(cbHospitalName.getSelectedItem().toString());
				int num = getVacationDate().getMonthChooser().getMonth();
				getVacationDate().getMonthChooser().setMonth(0);
				getVacationDate().getMonthChooser().setMonth(num);
			}
		});
		
		JButton buttonAdd = new JButton("Add");
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object[] options = {"Yes","No"};
				int n = JOptionPane.showOptionDialog(null, "Are you sure you want to register the selected day as a day off?","Register Vacation Day",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[1]);
				if (n==0)
				{	
					Date dt = new Date();
					Calendar c = Calendar.getInstance();
					c.setTime(dt);
					c.add(Calendar.DATE, 1);
					dt = c.getTime();
					dt.setHours(0);
					dt.setMinutes(0);
					dt.setSeconds(0);	
					for (Date d : vacationDates)
					{
						Calendar cal = Calendar.getInstance();
						cal.setTime(d);
						Calendar cal2 = Calendar.getInstance();
						cal2.setTime(date);
						int day = cal.get(Calendar.DAY_OF_MONTH);
						int day2= cal2.get(Calendar.DAY_OF_MONTH);
						int month = cal.get(Calendar.MONTH);
						int month2 = cal2.get(Calendar.MONTH);
						int year = cal.get(Calendar.YEAR);
						int year2 = cal2.get(Calendar.YEAR);
						if (day==day2 && month==month2 && year==year2)
						{
					    bool = true;
					    break;
						}
					}
					if (date.before(dt))
						JOptionPane.showMessageDialog(null, "You must first select a valid date!");
					else if (bool == true && adminLoggedIn == false) // && not admin but doctor logged in
					{
						JOptionPane.showMessageDialog(null, date + " is already registered as a day off!");
						bool=false;
						c.set(Calendar.DAY_OF_MONTH, 1);
						dt = c.getTime();
						int num = vacationDate.getMonthChooser().getMonth();
						vacationDate.setDate(dt);
						vacationDate.getMonthChooser().setMonth(0);
						vacationDate.getMonthChooser().setMonth(num);
						
					}
					else
					{
					// if admin does this
						if (adminLoggedIn==true){
							trigger=true;
						doctors = Logic.getInstance().getDoctorsOfHospital(cbHospitalName.getSelectedItem().toString());
						for (String id : doctors.keySet())
							cbDoctorsOfSelectedHospital.addItem(doctors.get(id) + " (" + id + ") ");
						String[] choices = new String[cbDoctorsOfSelectedHospital.getItemCount()];
							for (int i=0;i<cbDoctorsOfSelectedHospital.getItemCount();i++)
								choices[i] = cbDoctorsOfSelectedHospital.getItemAt(i);
							String input = (String) JOptionPane.showInputDialog(null, "Please select a doctor to register the vacation date to: ",
							        "Adding Vacation Date to Doctor", JOptionPane.QUESTION_MESSAGE, null, // Use
                                    // default
                                    // icon
                                    choices, // Array of choices
                                    choices[0]); // Initial choice
							if (input!=null){
								vacationDates = Logic.getInstance().getDoctorVacations(input.substring(input.indexOf("(")+1, input.indexOf(")")));
								for (Date d : vacationDates)
								{
								Calendar cal = Calendar.getInstance();
								cal.setTime(d);
								Calendar cal2 = Calendar.getInstance();
								cal2.setTime(date);
								int day = cal.get(Calendar.DAY_OF_MONTH);
								int day2= cal2.get(Calendar.DAY_OF_MONTH);
								int month = cal.get(Calendar.MONTH);
								int month2 = cal2.get(Calendar.MONTH);
								int year = cal.get(Calendar.YEAR);
								int year2 = cal2.get(Calendar.YEAR);
								if (day==day2 && month==month2 && year==year2)
								{
								    boolAdmin = true;
								    break;
								  }
								}
								if (boolAdmin==true)
								{
									JOptionPane.showMessageDialog(null, input.substring(0, input.indexOf(" (")) + " already has a registered day off on " + date + "!");
									boolAdmin=false;
									c.set(Calendar.DAY_OF_MONTH, 1);
									dt = c.getTime();
									int num = vacationDate.getMonthChooser().getMonth();
									vacationDate.setDate(dt);
									vacationDate.getMonthChooser().setMonth(0);
									vacationDate.getMonthChooser().setMonth(num);
									cbDoctorsOfSelectedHospital.removeAllItems();
								}
								else
								{
						Logic.getInstance().AddVacationDay(input.substring(input.indexOf("(")+1, input.indexOf(")")), date); // need to change according to choice of doctor id
	                    JOptionPane.showMessageDialog(null, date + " has successfully been registered as a day off for doctor " + input.substring(0, input.indexOf(" (")) + "!");
						vacations = Logic.getInstance().getHospitalDoctorsVacations(cbHospitalName.getSelectedItem().toString()); // need to change according to whichever doctor logs in
						dt = new Date();
						c = Calendar.getInstance();
						c.setTime(dt);
						c.add(Calendar.DATE, 1);
						dt = c.getTime();
						dt.setHours(0);
						dt.setMinutes(0);
						dt.setSeconds(0);
						vacationDate.setMinSelectableDate(dt);
						c.set(Calendar.DAY_OF_MONTH, 1);
						dt = c.getTime();
						int num = vacationDate.getMonthChooser().getMonth();
						vacationDate.setDate(dt);
						vacationDate.getMonthChooser().setMonth(0);
						vacationDate.getMonthChooser().setMonth(num);
						cbDoctorsOfSelectedHospital.removeAllItems();
								}
							}
					}
				  }
				}
			}
		});
		buttonAdd.setIcon(new ImageIcon(Panel_add_Vacations.class.getResource("/view/icons/add.png")));
		buttonAdd.setForeground(Color.WHITE);
		buttonAdd.setBackground(new Color(70,130,180));
		buttonAdd.setBounds(313, 367, 129, 41);
		add(buttonAdd);
		
        mm.getBtnView().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Panel_add_Vacations.this.setVisible(false);
				
			}
		});

	}
	public ArrayList<Date> getVacationDates() {
		return vacationDates;
	}
	public void setVacationDates(ArrayList<Date> vacationDates) {
		this.vacationDates = vacationDates;
	}
	public JCalendar getVacationDate() {
		return vacationDate;
	}
	public void setVacationDate(JCalendar vacationDate) {
		this.vacationDate = vacationDate;
	}
	public JComboBox<String> getCbHospitalName() {
		return cbHospitalName;
	}
	public void setCbHospitalName(JComboBox<String> cbHospitalName) {
		this.cbHospitalName = cbHospitalName;
	}
	
}
