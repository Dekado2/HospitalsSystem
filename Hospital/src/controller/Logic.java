package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import model.CheckedBy;
import model.Department;
import model.Doctor;
import model.Hospital;
import model.Hospitalized;
import model.MedicalEvent;
import model.MedicalEventType;
import model.Patient;
import model.Person;
import model.Room;
import model.Shift;
import model.User;
import model.WorksInShift;
import utils.ConnectionConst;

public class Logic {
	
	private static Logic instance;
	
	private Logic() {};
	
	public static Logic getInstance()
	{
		if (instance==null)
			instance=new Logic();
		return instance;
	}

	public ArrayList<Person> getPersons()
	{
		ArrayList<Person> people = new ArrayList<Person>();
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call getPersons}");
			cstmt.execute();
			rs = cstmt.getResultSet();
			while (rs.next())
			{
			    int i=1;	
				Person p = new Person (rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getDate(i++), rs.getString(i++), rs.getString(i++)
						, rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), null);
				people.add(p);
			}
		}
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
			ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		return people;
    }
	
	public ArrayList<MedicalEvent> getMedicalEvents( String departmentName)
	{
		ArrayList<MedicalEvent> events = new ArrayList<MedicalEvent>();
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call getMedicalEvents(?)}");
			cstmt.setString("departmentName", departmentName);
			cstmt.execute();
			rs = cstmt.getResultSet();
			while (rs.next())
			{
			    int i=1;	
				MedicalEvent e = new MedicalEvent(rs.getInt(i++), rs.getString(i++),new MedicalEventType(rs.getInt(i++)));
				events.add(e);
			}
		}
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
			ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		return events;
    }
	
	public ArrayList<Hospital> getHospitals()
	{
		ArrayList<Hospital> hospitals = new ArrayList<Hospital>();
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call getHospitals}");
			cstmt.execute();
			rs = cstmt.getResultSet();
			while (rs.next())
			{
			    int i=1;	
				Hospital h = new Hospital (rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++));
			    h.setDepartments(Logic.getInstance().getDepartmentsOfHospital(h.getHospitalID(),h));
				hospitals.add(h);
			}
		}
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		return hospitals;
    }
	
	public ArrayList<Department> getDepartmentsOfHospital(String hospitalID, Hospital hospital)
	{
		ArrayList<Department> departments = new ArrayList<Department>();
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call getDepartmentsOfHospital(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("hospitalID", hospitalID);
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
	        while (rs.next()) {
	        	int i=1;
	        	Department d = new Department (hospital, rs.getString(i++), rs.getString(i++), rs.getInt(i++));
	        	d.setRooms(Logic.getInstance().getRooms(d.getHospital().getHospitalID(),d.getDepartmentID()));
	            departments.add(d);
	        }
	    }
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		return departments;
    }
	public ArrayList<Person> getPatients()
	{
		ArrayList<Person> patients = new ArrayList<Person>();
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call getPatients}");
			cstmt.execute();
			rs = cstmt.getResultSet();
			while (rs.next())
			{
			    int i=1;	
			    
				Patient p = new Patient (rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getDate(i++), rs.getString(i++),
						rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++),new Person(rs.getString(i++)));
			  
				patients.add(p);
			}
		}
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		return patients;	
	}
	
	public ArrayList<Doctor> getDoctors()
	{
		ArrayList<Doctor> doctors = new ArrayList<Doctor>();
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call getDoctors}");
			cstmt.execute();
			rs = cstmt.getResultSet();
			while (rs.next())
			{
			    int i=1;
			   
				Doctor doc = new Doctor (rs.getString(i++), rs.getString(i++), rs.getString(i++), 
						rs.getDate(i++),rs.getString(i++),rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++),new Person(rs.getString(i++)),rs.getDate(i++),rs.getBoolean(i++),new Hospital(rs.getString(i++),rs.getString(i++)),new Department(rs.getString(i++),rs.getString(i++)));
				doctors.add(doc);
			}
		}
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		return doctors;	
	}
	
	public ArrayList<Doctor> getDoctorsOfHospitalID(String hospitalID)
	{
		ArrayList<Doctor> doctors = new ArrayList<Doctor>();
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call getDoctorsOfHospitalID(?)}");
			cstmt.setString("hospitalID", hospitalID);
			cstmt.execute();
			rs = cstmt.getResultSet();
			while (rs.next())
			{
			    int i=1;
			   
				Doctor doc = new Doctor (rs.getString(i++), rs.getString(i++), rs.getString(i++), 
						rs.getDate(i++),rs.getString(i++),rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++),new Person(rs.getString(i++)),rs.getDate(i++),rs.getBoolean(i++),new Hospital(rs.getString(i++),rs.getString(i++)),new Department(rs.getString(i++),rs.getString(i++)));
				doctors.add(doc);
			}
		}
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		return doctors;	
	}
	
	public ArrayList<Room> getRooms( String hospitalID, String departmentID)
	{
		Room r=null;
		ArrayList<Room> rooms = new ArrayList<Room>();
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call getRooms(?,?)}");
			cstmt.setString("hospitalID", hospitalID);
			cstmt.setString("departmentID", departmentID);
			cstmt.execute();
			rs = cstmt.getResultSet();
			while (rs.next())
			{
			    int i=1;	
			    r = new Room(new Hospital(rs.getString(i++)),new Department(rs.getString(i++)), rs.getInt(i++), rs.getInt(i++));
				rooms.add(r);
			}
		}
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		return rooms;	
	}
	
	public ArrayList<Room> getAllRooms()
	{
		Room r=null;
		ArrayList<Room> rooms = new ArrayList<Room>();
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call getAllRooms}");
			
			cstmt.execute();
			rs = cstmt.getResultSet();
			while (rs.next())
			{
			    int i=1;
			    r = new Room(new Hospital(rs.getString(i++),rs.getString(i++)),new Department(rs.getString(i++),rs.getString(i++)), rs.getInt(i++), rs.getInt(i++));
				rooms.add(r);
			}
		}
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		return rooms;	
	}
	
	public ArrayList<Hospitalized> getHospitalized()
	{
		ArrayList<Hospitalized> hospitalized = new ArrayList<Hospitalized>();
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call getHospitalized}");
			cstmt.execute();
			rs = cstmt.getResultSet();
			while (rs.next())
			{
			    int i=1;	
			    Hospitalized h = new Hospitalized(new Patient(rs.getString(i++)), new MedicalEvent(rs.getInt(i++),rs.getString(i++)), rs.getInt(i++), rs.getDate(i++), rs.getInt(i++), new Room(new Hospital(rs.getString(i++),rs.getString(i++)), new Department(rs.getString(i++),rs.getString(i++)), rs.getInt(i++)));
				hospitalized.add(h);
			
			}
		}
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		return hospitalized;	
	}
	
	public ArrayList<Hospitalized> getHospitalizedOfHospitalID(String hospitalID)
	{
		ArrayList<Hospitalized> hospitalized = new ArrayList<Hospitalized>();
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call getHospitalizedOfHospitalID(?)}");
			cstmt.setString("hospitalID", hospitalID);
			cstmt.execute();
			rs = cstmt.getResultSet();
			while (rs.next())
			{
			    int i=1;	
			    Hospitalized h = new Hospitalized(new Patient(rs.getString(i++)), new MedicalEvent(rs.getInt(i++),rs.getString(i++)), rs.getInt(i++), rs.getDate(i++), rs.getInt(i++), new Room(new Hospital(rs.getString(i++),rs.getString(i++)), new Department(rs.getString(i++),rs.getString(i++)), rs.getInt(i++)));
				hospitalized.add(h);
			
			}
		}
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		return hospitalized;	
	}
	
	public Patient getPatientDetails(String ID)
	{
		Patient patient = null;
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call getPatientDetails(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, 				ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("patientID", ID);
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
	        while (rs.next()) {
	        	int i=1;
				patient = new Patient (rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getDate(i++), rs.getString(i++),
						rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++),new Person(rs.getString(i++)));
			}
		}
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		return patient;	
	}
	
	public boolean DepartmentHasManager(String hospitalID, String departmentID)
	{
		int res=0;
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call DepartmentHasManager(?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, 					ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("departmentID", departmentID);
			cstmt.setString("hospitalID", hospitalID);
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
	        while (rs.next()) {
	        	int i=1;
	        	res = rs.getInt(i++);
	        }
	    }
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		if (res==0)
			return false;
		return true;
    }
	
	public boolean ContactExists(String id)
	{
		int res=0;
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call ContactExists(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, 					ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("id", id);
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
	        while (rs.next()) {
	        	int i=1;
	        	res = rs.getInt(i++);
	        }
	    }
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		if (res==0)
			return false;
		return true;
    }
	
	public boolean PatientExists(String patientID)
	{
		int res=0;
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call PatientExists(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, 					ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("ID", patientID);
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
	        while (rs.next()) {
	        	int i=1;
	        	res = rs.getInt(i++);
	        }
	    }
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		if (res==0)
			return false;
		return true;
    }
	
	
	
	public boolean DoctorExists(String doctorID)
	{
		int res=0;
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call DoctorExists(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, 				ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("ID", doctorID);
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
	        while (rs.next()) {
	        	int i=1;
	        	res = rs.getInt(i++);
	        }
	    }
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		if (res==0)
			return false;
		return true;
    }
	
	public void AddPerson(String id, String firstName, String surName, Date birthDate, String city, String street, String gender, String phone, String bloodType, String careFacility)
	{
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call AddPerson(?,?,?,?,?,?,?,?,?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, 					ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("ID", id);
			cstmt.setString("firstName", firstName);
			cstmt.setString("surName", surName);
			cstmt.setDate("dateOfBirth", (java.sql.Date) birthDate);
			cstmt.setString("city", city);
			cstmt.setString("street", street);
			cstmt.setString("gender", gender);
			cstmt.setString("phone", phone);
			cstmt.setString("bloodType", bloodType);
			cstmt.setString("careFacility", careFacility);
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
	    }
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
    }
	
	public void AddDoctor(String doctorID, Date graduationDate, boolean manager, String hospitalID, String departmentID)
	{
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call AddDoctor(?,?,?,?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("ID", doctorID);
			cstmt.setDate("graduationDate", (java.sql.Date) graduationDate);
			cstmt.setBoolean("manager", manager);
			cstmt.setString("hospitalID", hospitalID);
			cstmt.setString("departmentID", departmentID);
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
	    }
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
    }
	
	public void AddPatient(String patientID)
	{
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call AddPatient(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("ID", patientID);
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
	    }
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
    }
	
	public boolean RoomExists(String hospitalID, String departmentID, String roomNumber)
	{
		int res=0;
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call RoomExists(?,?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("hospitalID", hospitalID);
			cstmt.setString("departmentID", departmentID);
			cstmt.setString("roomNumber", roomNumber);
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
	        while (rs.next()) {
	        	int i=1;
	        	res = rs.getInt(i++);
	        }
	    }
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		if (res==0)
			return false;
		return true;
    }
	
	public void AddRoom(String hospitalID, String departmentID, String roomNumber, String bedsAmount)
	{
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call AddRoom(?,?,?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("hospitalID", hospitalID);
			cstmt.setString("departmentID", departmentID);
			cstmt.setString("roomNumber", roomNumber);
			cstmt.setString("bedsAmount", bedsAmount);
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
	    }
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
    }
	
	public Room getRoomDetails(String hospitalID, String departmentID, String roomNumber)
	{
		Room r=null;
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call getRoomDetails(?,?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("hospitalID", hospitalID);
			cstmt.setString("departmentID", departmentID);
			cstmt.setString("roomNumber", roomNumber);
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
	        while (rs.next()) {
	        	int i=1;
				r = new Room(new Hospital(rs.getString(i++),rs.getString(i++)),new Department(rs.getString(i++),rs.getString(i++)), rs.getInt(i++), rs.getInt(i++));
				
			}
		}
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		
		return r;
    }
	
	
	public Doctor getDoctorDetails(String ID)
	{
		Doctor doc = null;
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call getDoctorDetails(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("doctorID", ID);
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
	        while (rs.next()) {
	        	int i=1;
	        	doc = new Doctor (rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getDate(i++), rs.getString(i++),
						rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++),new Person(rs.getString(i++)),
						rs.getDate(i++),rs.getBoolean(i++),new Hospital(rs.getString(i++),rs.getString(i++)),new Department(rs.getString(i++),rs.getString(i++)));
			}
		}
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		return doc;	
	}
	
	
	public Hospitalized getHospitalizationDetails(String patientID,int eventCode)
	{
		
		Hospitalized hos=null;
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call getHospitalizationDetails(?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("patientID", patientID);
			cstmt.setInt("eventCode", eventCode);
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
			while (rs.next())
			{
			    int i=1;	
			    hos = new Hospitalized(new Patient(rs.getString(i++)), new MedicalEvent(rs.getInt(i++),rs.getString(i++)), rs.getInt(i++), rs.getDate(i++), rs.getInt(i++), new Room(new Hospital(rs.getString(i++),rs.getString(i++)), new Department(rs.getString(i++),rs.getString(i++)), rs.getInt(i++)));
			
			
			}
		}
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		return hos;	
	}
	
	
	public ArrayList<Date> getDoctorVacations(String doctorID)
	{
		ArrayList<Date> vacationDates = new ArrayList<Date>();
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call getDoctorVacations(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("doctorID", doctorID);
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
	        while (rs.next()) {
	        	int i=1;
	            vacationDates.add(rs.getDate(i++));
	        }
	    }
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		return vacationDates;
    }
	
	public void AddVacationDay(String doctorID, Date vacationDay)
	{
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call AddVacationDay(?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("doctorID", doctorID);
			cstmt.setDate("vacationDate", (java.sql.Date) vacationDay);
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
	    }
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
    }
	
	public void RemoveVacation(String doctorID, Date vacationDay)
	{
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call RemoveVacation(?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("doctorID", doctorID);
			cstmt.setDate("vacationDate", (java.sql.Date) vacationDay);
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
	    }
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
    }
	
	public void UpdatePerson(String id, String firstName, String surName, Date dateOfBirth, String city, String street, String gender, String phone, String bloodType, String careFacility,String contactID)
	{
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call UpdatePatient(?,?,?,?,?,?,?,?,?,?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, 					ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("ID", id);
			cstmt.setString("firstName", firstName);
			cstmt.setString("surName", surName);
			cstmt.setDate("dateOfBirth", (java.sql.Date) dateOfBirth);
			cstmt.setString("city", city);
			cstmt.setString("street", street);
			cstmt.setString("gender", gender);
			cstmt.setString("phone", phone);
			cstmt.setString("bloodType", bloodType);
			cstmt.setString("careFacility", careFacility);
			if(contactID!=null)
				cstmt.setString("contactID", contactID);
			else
				cstmt.setString("contactID", null);
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
	    }
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
    }
	
	public void removePerson(String ID)
	{
	
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call removePerson(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, 				ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("ID", ID);
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
	    }
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
    }
	public boolean removePatient(String patientID)
	{
		
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call removePatient(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, 				ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("patientID", patientID);
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
	    }
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		return true;
    }
	
	public boolean removeDoctor(String doctorID)
	{
		
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call removeDoctor(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, 				ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("doctorID", doctorID);
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
	    }
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		return true;
    }
	
	public void UpdateRoom(String hospitalID, String departmentID, String roomNumber, String bedsAmount)
	{
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call UpdateRoom(?,?,?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("hospitalID", hospitalID);
			cstmt.setString("departmentID", departmentID);
			cstmt.setString("roomNumber", roomNumber);
			cstmt.setString("bedsAmount", bedsAmount);
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
	    }
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
    }
	
	public void removeRoom(String hospitalID, String departmentID, int roomNumber)
	{
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call removeRoom(?,?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("hospitalID", hospitalID);
			cstmt.setString("departmentID", departmentID);
			cstmt.setInt("roomNumber", roomNumber);
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
	    }
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
    }
	
	public void UpdateDoctor(String doctorID, Date dateOfGraduation, boolean manager, String hospitalID, String departmentID)
	{
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call UpdateDoctor(?,?,?,?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("doctorID", doctorID);
			cstmt.setDate("dateOfGraduation", (java.sql.Date) dateOfGraduation);
			cstmt.setBoolean("manager", manager);
			cstmt.setString("hospitalID", hospitalID);
			cstmt.setString("departmentID", departmentID);
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
	    }
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
    }
	
	public String getDepartmentManager(String hospitalID, String departmentID)
	{
		String res=null;
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call getDepartmentManager(?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, 					ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("departmentID", departmentID);
			cstmt.setString("hospitalID", hospitalID);
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
	        while (rs.next()) {
	        	int i=1;
	        	res = rs.getString(i++);
	        }
	    }
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		
	return res;

    }
	

	public boolean isWorkingInShift(String doctorID)
	{
		boolean res=false;
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call isWorkingInShift(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, 					ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("doctorID", doctorID);
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
	        while (rs.next()) {
	        	int i=1;
	        	if(!rs.getBoolean(i++)) {
	        		res=false;
	        	}
	        	else break;
	        }
	        res=true;
	    }
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
	/*	if (res.equals("False"))
			return false;*/
		return res;
    }
	
	public void removeDoctorShifts(String doctorID)
	{
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call removeDoctorShifts(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("doctorID", doctorID);
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
	    }
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
    }
	
	public void removeDoctorVacations(String doctorID)
	{
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call removeDoctorVacations(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("doctorID", doctorID);
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
	    }
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
    }
	
	public void removeDoctorHospitalizations(String patientID)
	{
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call removeDoctorHospitalizations(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("patientID", patientID);
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
	    }
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
    }
	
	public int getRoomOccupation(String hospitalID, String departmentID, String roomNumber)
	{
		int res=0;
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call getRoomOccupation(?,?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("hospitalID", hospitalID);
			cstmt.setString("departmentID", departmentID);
			cstmt.setString("roomNumber", roomNumber);
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
	        while (rs.next()) {
	        	int i=1;
	        	res = rs.getInt(i++);
	        }
	    }
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		
		return res;
    }
	
	
	public void AddHospitalization(String patientID, int eventCode, String numberOfDays,Date dateOfArrival,String severityLevel, String hospitalID, String departmentID,int roomNumber)
	{
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call AddHospitalization(?,?,?,?,?,?,?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("patientID",patientID );
			cstmt.setInt("eventCode",eventCode );
			cstmt.setString("numberOfDays",numberOfDays );
			cstmt.setDate("dateOfArrival",(java.sql.Date) dateOfArrival);
			cstmt.setString("severityLevel",severityLevel );
			cstmt.setString("hospitalID", hospitalID);
			cstmt.setString("departmentID", departmentID);
			cstmt.setInt("roomNumber",roomNumber );
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
	    }
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
    }
	
	public boolean HospitalizationExists(String patientID, int eventCode)
	{
		int res=0;
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call HospitalizationExists(?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, 				ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("patientID", patientID);
			cstmt.setInt("eventCode", eventCode);
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
	        while (rs.next()) {
	        	int i=1;
	        	res = rs.getInt(i++);
	        }
	    }
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		if (res==0)
			return false;
		return true;
    }
	
	
	public void removeHospitalization(String patientID, int eventCode)
	{
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call removeHospitalization(?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("patientID", patientID);
			cstmt.setInt("eventCode", eventCode);
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
	    }
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
    }
	public void updateHospitalization(String patientID, int eventCode, String numberOfDays,Date dateOfArrival,String severityLevel, String hospitalID, String departmentID,int roomNumber)
	{
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call updateHospitalization(?,?,?,?,?,?,?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("patientID",patientID );
			cstmt.setInt("eventCode",eventCode );
			cstmt.setString("numberOfDays",numberOfDays );
			cstmt.setDate("dateOfArrival",(java.sql.Date) dateOfArrival);
			cstmt.setString("severityLevel",severityLevel );
			cstmt.setString("hospitalID", hospitalID);
			cstmt.setString("departmentID", departmentID);
			cstmt.setInt("roomNumber",roomNumber );
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
	    }
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
    }
	
	//////////////////////////////////////////////////////////////////////////////////////////////////
	public HashMap<String,Integer> getHospitalizedByMedicalEvents()
	{
		HashMap<String,Integer> results = new HashMap<String,Integer>();
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call HospitalizedByMedicalEvents}");
			cstmt.execute();
			rs = cstmt.getResultSet();
			while (rs.next())
			{
			    int i=1;
			    results.put(rs.getString(i++), rs.getInt(i++));
			}
		}
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
			ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		return results;
    }
	
	public HashMap<Integer,HashMap<String,Integer>> getHospitalsProfitOfLast3years()
	{
		HashMap<Integer,HashMap<String,Integer>> results = new HashMap<Integer,HashMap<String,Integer>>();
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call HospitalsProfitOfLast3Years}");
			cstmt.execute();
			rs = cstmt.getResultSet();
			while (rs.next())
			{
			    int i=1;
			    Integer year = rs.getInt(i++);
			    if (!results.containsKey(year))
			    results.put(year, new HashMap<String,Integer>());
			    String hospitalName = rs.getString(i++);
			    Integer profit = rs.getInt(i++);
			    if (!results.get(year).containsKey(hospitalName))
			    results.get(year).put(hospitalName, profit);
			    
			}
		}
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
			ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		return results;
    }
	
	public HashMap<String,Integer> getMedicalEventsAverageSeverityLevel()
	{
		HashMap<String,Integer> results = new HashMap<String,Integer>();
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call MedicalEventsAverageSeverityLevel}");
			cstmt.execute();
			rs = cstmt.getResultSet();
			while (rs.next())
			{
			    int i=1;
			    results.put(rs.getString(i++), rs.getInt(i++));
			}
		}
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
			ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		return results;
    }
	
	public HashMap<String,HashMap<String,ArrayList<ArrayList<Integer>>>> getHospitalsDepartmentsOccupation()
	{
		HashMap<String,HashMap<String,ArrayList<ArrayList<Integer>>>> results = new HashMap<String,HashMap<String,ArrayList<ArrayList<Integer>>>>();
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call HospitalsDepartmentsOccupation}");
			cstmt.execute();
			rs = cstmt.getResultSet();
			while (rs.next())
			{
			    int i=1;
			    String hospitalName = rs.getString(i++);
			    if (!results.containsKey(hospitalName))
			    results.put(hospitalName, new HashMap<String,ArrayList<ArrayList<Integer>>>());
			    String departmentName = rs.getString(i++);
			    if (!results.get(hospitalName).containsKey(departmentName)){
			    results.get(hospitalName).put(departmentName, new ArrayList<ArrayList<Integer>>());
			    for (int j=0;j<3;j++)
			    	results.get(hospitalName).get(departmentName).add(new ArrayList<Integer>());
			    }
			    results.get(hospitalName).get(departmentName).get(0).add(rs.getInt(i++));
			    results.get(hospitalName).get(departmentName).get(1).add(rs.getInt(i++));
			    results.get(hospitalName).get(departmentName).get(2).add(rs.getInt(i++));			    
			}
		}
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
			ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		return results;
    }
	
	public HashMap<String,HashMap<String,ArrayList<Date>>> getHospitalDoctorsVacations(String hospitalName)
	{
		HashMap<String,HashMap<String,ArrayList<Date>>> vacations = new HashMap<String,HashMap<String,ArrayList<Date>>>();
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call getHospitalDoctorsVacations(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("hospitalName", hospitalName);
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
	        while (rs.next()) {
	        	int i=1;
	        	String id = rs.getString(i++);
	        	if (!vacations.containsKey(id))
	        		vacations.put(id, new HashMap<String,ArrayList<Date>>());
	        	String name = rs.getString(i++);
	        	if (!vacations.get(id).containsKey(name))
	        		vacations.get(id).put(name, new ArrayList<Date>());
	        	vacations.get(id).get(name).add(rs.getDate(i++));
	        }
	    }
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		return vacations;
    }
	
	public HashMap<String, String> getDoctorsOfHospital(String hospitalName)
	{
		HashMap<String, String> doctors = new HashMap<String, String>();
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call getDoctorsOfHospital(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("hospitalName", hospitalName);
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
	        while (rs.next()) {
	        	int i=1;
	        	doctors.put(rs.getString(i++), rs.getString(i++));
	        }
	    }
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		return doctors;
    }
	
	public ArrayList<ArrayList<Integer>> getHospitalizationNumberVSAgeForMale()
	{
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call HospitalizationNumberVSAgeForMale}");
			cstmt.execute();
			rs = cstmt.getResultSet();
			 for (int j=0;j<2;j++)
			    	results.add(j, new ArrayList<Integer>());
			while (rs.next())
			{
			    int i=1;			   
			    results.get(0).add(rs.getInt(i++));
			    results.get(1).add(rs.getInt(i++));
			}
		}
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
			ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		return results;
    }
	
	public ArrayList<ArrayList<Integer>> getHospitalizationNumberVSAgeForFemale()
	{
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call HospitalizationNumberVSAgeForFemale}");
			cstmt.execute();
			rs = cstmt.getResultSet();
			 for (int j=0;j<2;j++)
			    	results.add(j, new ArrayList<Integer>());
			while (rs.next())
			{
			    int i=1;			   
			    results.get(0).add(rs.getInt(i++));
			    results.get(1).add(rs.getInt(i++));
			}
		}
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
			ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		return results;
    }
	
	public boolean userExists(String userName, String pass)
	{
		int res=0;
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call UserExists(?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("userName", userName);
			cstmt.setString("password", pass);
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
	        while (rs.next()) {
	        	int i=1;
	        	res = rs.getInt(i++);
	        }
	    }
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		if (res==0)
			return false;
		return true;
    }
	
	public boolean userExistsByUserName(String userName)
	{
		int res=0;
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call userExistsByUserName(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("userName", userName);
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
	        while (rs.next()) {
	        	int i=1;
	        	res = rs.getInt(i++);
	        }
	    }
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		if (res==0)
			return false;
		return true;
    }
	
	public User getUserDetails(String userName, String pass)
	{
		User user = null;
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call getUserDetails(?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("userName", userName);
			cstmt.setString("password", pass);
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
	        while (rs.next()) {
	        	int i=1;
				user = new User (rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++));
			}
		}
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		return user;	
	}
	
	public User getUserDetailsForReset(String userName)
	{
		User user = null;
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call getUserDetailsForReset(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("userName", userName);
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
	        while (rs.next()) {
	        	int i=1;
				user = new User (rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++));
			}
		}
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		return user;	
	}
	
	public void UpdateUser(String userName, String pass, String displayFirstName, String displaySurName, String userType, String secretQuestion, String secretAnswer)
	{
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call UpdateUser(?,?,?,?,?,?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("userName", userName);
			cstmt.setString("password", pass);
			cstmt.setString("displayFirstName", displayFirstName);
			cstmt.setString("displaySurName", displaySurName);
			cstmt.setString("userType", userType);
			cstmt.setString("secretQuestion", secretQuestion);
			cstmt.setString("secretAnswer", secretAnswer);
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
	    }
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
    }
	
	public ArrayList<Person> showDoctorsWorkingInHaifa()
	{
		ArrayList<Person> doctors = new ArrayList<Person>();
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call showDoctorsWorkingInHaifa}");
			cstmt.execute();
			rs = cstmt.getResultSet();
			while (rs.next())
			{
			    int i=1;
			   
				Doctor doc = new Doctor (rs.getString(i++), rs.getString(i++), rs.getString(i++), 
						rs.getDate(i++),rs.getString(i++),rs.getString(i++), rs.getString(i++), 
						rs.getString(i++),rs.getString(i++), rs.getString(i++),new Person(rs.getString(i++)),rs.getDate(i++),
						rs.getBoolean(i++),new Hospital(rs.getString(i++)),new Department(rs.getString(i++)));
			
				doctors.add(doc);
			}
		}
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		return doctors;	
	}
	
	public ArrayList<Person> ShowPatientsWithASeverityLevelOf10ORWereHospitalizedMoreThan3Times()
	{
		ArrayList<Person> patients = new ArrayList<Person>();
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call ShowPatientsWithASeverityLevelOf10ORWereHospitalizedMoreThan3Times}");
			cstmt.execute();
			rs = cstmt.getResultSet();
			while (rs.next())
			{
			    int i=1;
			   
				Patient p = new Patient(rs.getString(i++));
				String fName=rs.getString(i++);
				String surName=rs.getString(i++);
				p.setFirstName(fName);
				p.setSurName(surName);
				patients.add(p);
			}
		}
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		return patients;	
	}
	
	
	public HashMap<Person,String> ShowDoctorsWhoAreInvitedToTheNationalSurgeryConvention()
	{
		 HashMap<Person,String>  result = new  HashMap<Person,String> ();
		Person p=null;
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call ShowDoctorsWhoAreInvitedToTheNationalSurgeryConvention}");
			cstmt.execute();
			rs = cstmt.getResultSet();
			while (rs.next())
			{
			    int i=1;	
			    p= new Person(rs.getString(i++));
			    p.setFirstName(rs.getString(i++));
			    p.setSurName(rs.getString(i++));
			    String hospitalName =rs.getString(i++);
			    result.put(p, hospitalName);
			}
		}
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		return result;
    }
	
	public HashMap<Hospital,String> ShowHospitalsStatusRegardingDoctorsInfectionInEmergencyCareInThePastMonth()
	{
		 HashMap<Hospital,String>  result = new  HashMap<Hospital,String> ();
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call ShowHospitalsStatusRegardingDoctorsInfectionInEmergencyCareInThePastMonth}");
			cstmt.execute();
			rs = cstmt.getResultSet();
			while (rs.next())
			{
			    int i=1;	
			    Hospital h= new Hospital(rs.getString(i++));
			    h.setName(rs.getString(i++));
			    String hospitalStatus =rs.getString(i++);
			    result.put(h,hospitalStatus);
			}
		}
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		return result;
    }
	
	public HashMap<Person,String> ShowBusyDoctors()
	{
		 HashMap<Person,String>  result = new  HashMap<Person,String> ();
		Person doc=null;
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call ShowBusyDoctors}");
			cstmt.execute();
			rs = cstmt.getResultSet();
			while (rs.next())
			{
			    int i=1;	
			    doc= new Person(rs.getString(i++));
			    doc.setFirstName(rs.getString(i++));
			    doc.setSurName(rs.getString(i++));
			    String hospitalName =rs.getString(i++);
			    result.put(doc, hospitalName);
			}
		}
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		return result;
    }
	
	public ArrayList<CheckedBy> ShowDoctorDepartmentHospitalizedPatientsLastTestResults(String doctorID)
	{
		ArrayList<CheckedBy>  result = new  ArrayList<CheckedBy>  ();
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call ShowDoctorDepartmentHospitalizedPatientsLastTestResults(?)}");
			cstmt.setString("doctorID", doctorID);
			cstmt.execute();
			rs = cstmt.getResultSet();
			while (rs.next())
			{
			    int i=1;	
			    Hospitalized patientHospitalized=new Hospitalized(new Patient(rs.getString(i++)), new MedicalEvent(rs.getInt(i++)));
			    Doctor d= new Doctor(doctorID);
			    WorksInShift ws=new WorksInShift(d,new Shift(rs.getInt(i++)));
			    patientHospitalized.getPatient().setFirstName(rs.getString(i++));
			    patientHospitalized.getPatient().setSurName(rs.getString(i++));
			    
			    CheckedBy ch = new CheckedBy(patientHospitalized, ws, rs.getDate(i++), Double.valueOf(rs.getString(i++)), rs.getString(i++));
			    result.add(ch);
			}
		}
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		return result;
    }
	
	public  ArrayList<String>  ShowEveryMonthsHospitalForThePastYearWithMostProfits()
	{
		ArrayList<String> result = new  ArrayList<String>();
		
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call ShowEveryMonthsHospitalForThePastYearWithMostProfits}");
			cstmt.execute();
			rs = cstmt.getResultSet();
			while (rs.next())
			{
			    int i=1;	
			    String hospitalName=rs.getString(i++);
			    String month= rs.getString(i++);
			    String hospitalProfits =rs.getString(i++);
			    String tmp="HospitalName:"+hospitalName +","+ "Month:"+month+","+"HospitalProfits:"+hospitalProfits;
			    result.add(tmp);
			}
		}
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		return result;
    }
	
	
	public HashMap<Department,String> ShowEveryHospitalDetails()
	{
		 HashMap<Department,String>  result = new  HashMap<Department,String> ();
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call ShowEveryHospitalDetails}");
			cstmt.execute();
			rs = cstmt.getResultSet();
			while (rs.next())
			{
			    int i=1;	
			    Hospital h= new Hospital(rs.getString(i++));
			    h.setName(rs.getString(i++));
			    Department d= new Department(rs.getString(i++));
			    d.setDepartmentName(rs.getString(i++));
			    d.setHospital(h);
			    String numOfDoctors= rs.getString(i++);
			    result.put(d,numOfDoctors);
			}
		}
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		return result;
    }
	
	public String getName(String ID)
	{
		String res=null;
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call getName(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, 					ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("ID", ID);
		
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
	        while (rs.next()) {
	        	int i=1;
	        	res = rs.getString(i++);
	        }
	    }
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		
	return res;

    }
	
	
	public ArrayList<Person> ShowPeopleWithRareBloodType()
	{
		ArrayList<Person> people = new ArrayList<Person>();
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call ShowPeopleWithRareBloodType}");
			cstmt.execute();
			rs = cstmt.getResultSet();
			while (rs.next())
			{
			    int i=1;	
				Person p = new Person (rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getDate(i++), rs.getString(i++), rs.getString(i++)
						, rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), new Person(rs.getString(i++)));
				people.add(p);
			}
		}
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
			ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		return people;
    }
	

	
	public HashMap<Department, String > ShowLoadLevelOfAllDepartments()
	{
		HashMap<Department, String >   results = new  HashMap<Department, String >  ();
	
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call ShowLoadLevelOfAllDepartments}");
			cstmt.execute();
			rs = cstmt.getResultSet();
			while (rs.next())
			{
			    int i=1;
			    Hospital h =new Hospital(rs.getString(i++));
			    String hospitalName = rs.getString(i++);
			    h.setName(hospitalName);
			    Department dep= new Department(rs.getString(i++));
			    dep.setDepartmentName(rs.getString(i++));
			    dep.setHospital(h);
			    String tmp= "FreeBedsInDepartment:"+ rs.getString(i++)+","+"Status:"+rs.getString(i++);
			    results.put(dep, tmp);		
			   
			 			    
			}
		}
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		return results;
    }
	
	public ArrayList<Person> ShowHypochondriacs(String patientID)
	{
		
		ArrayList<Person>  result = new  ArrayList<Person>  ();
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call ShowHypochondriacs(?)}");
			cstmt.setString("patientID", patientID);
			cstmt.execute();
			rs = cstmt.getResultSet();
			while (rs.next())
			{
			    int i=1;	
			    Person p=new Person(rs.getString(i++));
			    if(patientID!=null) {
			    p.setFirstName(rs.getString(i++));
			    p.setSurName(rs.getString(i++));
			    p.setPhoneNumber(rs.getString(i++));
			    }
			   
			    result.add(p);
			}
		}
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		return result;
    }
	
	public ArrayList<User> getAllUsers()
	{
		ArrayList<User> users = new ArrayList<User>();
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call getAllUsers}");
			cstmt.execute();
			rs = cstmt.getResultSet();
			while (rs.next())
			{
			    int i=1;	
				User user = new User(rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getString(i++));
				users.add(user);
			}
		}
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
			ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		return users;
    }
	
	public void AddUser(String userName, String pass, String firstName, String surName, String userType, String secretQuestion, String secretAnswer)
	{
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call AddUser(?,?,?,?,?,?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("userName", userName);
			cstmt.setString("password", pass);
			cstmt.setString("firstName", firstName);
			cstmt.setString("surName", surName);
			cstmt.setString("userType", userType);
			cstmt.setString("secretQuestion", secretQuestion);
			cstmt.setString("secretAnswer", secretAnswer);
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
	    }
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
    }
	
	public void removeUser(String userName)
	{
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call removeUser(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString("userName", userName);
			boolean results = cstmt.execute();
			int rowsAffected = 0;
			
			while (results || rowsAffected != -1) {
	            if (results) {
	                rs = cstmt.getResultSet();
	                break;
	            } else {
	                rowsAffected = cstmt.getUpdateCount();
	            }
	            results = cstmt.getMoreResults();
	        }
	    }
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
    }
	
	
	public ArrayList<Hospitalized> getCurrentHospitalized()
	{
		ArrayList<Hospitalized> hospitalized = new ArrayList<Hospitalized>();
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call getCurrentHospitalized}");
			cstmt.execute();
			rs = cstmt.getResultSet();
			while (rs.next())
			{
			    int i=1;	
			    Hospitalized h = new Hospitalized(new Patient(rs.getString(i++)), new MedicalEvent(rs.getInt(i++),rs.getString(i++)), rs.getInt(i++), rs.getDate(i++), rs.getInt(i++), new Room(new Hospital(rs.getString(i++),rs.getString(i++)), new Department(rs.getString(i++),rs.getString(i++)), rs.getInt(i++)));
				hospitalized.add(h);
			
			}
		}
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		return hospitalized;	
	}
	
	public ArrayList<Hospitalized> getCurrentHospitalizedOfHospitalID(String hospitalID)
	{
		ArrayList<Hospitalized> hospitalized = new ArrayList<Hospitalized>();
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url =ConnectionConst.URL;
			String username = ConnectionConst.USER;
			String password = ConnectionConst.PASSWORD;
			Class.forName(ConnectionConst.Server);
			Connection conn = DriverManager.getConnection(url,username, password);
			cstmt = conn.prepareCall("{call getCurrentHospitalizedOfHospitalID(?)}");
			cstmt.setString("hospitalID", hospitalID);
			cstmt.execute();
			rs = cstmt.getResultSet();
			while (rs.next())
			{
			    int i=1;	
			    Hospitalized h = new Hospitalized(new Patient(rs.getString(i++)), new MedicalEvent(rs.getInt(i++),rs.getString(i++)), rs.getInt(i++), rs.getDate(i++), rs.getInt(i++), new Room(new Hospital(rs.getString(i++),rs.getString(i++)), new Department(rs.getString(i++),rs.getString(i++)), rs.getInt(i++)));
				hospitalized.add(h);
			
			}
		}
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           ex2.printStackTrace();
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				ex3.printStackTrace();
			}
		}
	  }
		return hospitalized;	
	}
	
}
