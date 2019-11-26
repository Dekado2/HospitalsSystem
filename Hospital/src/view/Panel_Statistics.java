package view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.CategorySeriesLabelGenerator;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RefineryUtilities;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;

import controller.Logic;
import model.Hospital;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Panel_Statistics extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HashMap<String,Integer> hospitalizedByMedicalEvents = new HashMap<String,Integer>();
	private HashMap<Integer,HashMap<String,Integer>> hospitalsProfitOfLast3Years = new HashMap<Integer,HashMap<String,Integer>>();
	private HashMap<String,Integer> medicalEventsAverageSeverityLevel = new HashMap<String,Integer>();
	private HashMap<String,HashMap<String,ArrayList<ArrayList<Integer>>>> hospitalsDepartmentsOccupation = new HashMap<String,HashMap<String,ArrayList<ArrayList<Integer>>>>();
	private ArrayList<ArrayList<Integer>> hospitalizationNumberVSAgeForMale = new ArrayList<ArrayList<Integer>>();
	private ArrayList<ArrayList<Integer>> hospitalizationNumberVSAgeForFemale = new ArrayList<ArrayList<Integer>>();

	/**
	 * Create the panel.
	 */
	public Panel_Statistics(MainMenu mm) {
		
		setForeground(new Color(255, 255, 255));
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(-20, -20, 1677, 1573);
		add(panel);
		panel.setLayout(null);
		panel.add(createHospitalizedByMedicalEventsPanel());
		panel.add(createHospitalsProfitOfLast3YearsPanel());
		panel.add(createMedicalEventsAverageSeverityLevelPanel());
		panel.add(createHospitalsDepartmentsOccupationPanel());
		panel.add(createhospitalizationNumberVSAgeForEachGenderPanel());
		refreshData();
		
	}
	
	    private void refreshData () {
		hospitalizedByMedicalEvents = Logic.getInstance().getHospitalizedByMedicalEvents();
		hospitalsProfitOfLast3Years = Logic.getInstance().getHospitalsProfitOfLast3years();
		medicalEventsAverageSeverityLevel = Logic.getInstance().getMedicalEventsAverageSeverityLevel();
		hospitalsDepartmentsOccupation = Logic.getInstance().getHospitalsDepartmentsOccupation();
		hospitalizationNumberVSAgeForMale = Logic.getInstance().getHospitalizationNumberVSAgeForMale();
		hospitalizationNumberVSAgeForFemale = Logic.getInstance().getHospitalizationNumberVSAgeForFemale();
	}
	
	private static JFreeChart createHospitalizedByMedicalEventsChart( PieDataset dataset ) {
	    JFreeChart chart = ChartFactory.createPieChart(      
	       "Hospitalizations By Medical Events",   // chart title 
	       dataset,          // data    
	       true,             // include legend   
	       true, 
	       false);
	     PiePlot plot = (PiePlot) chart.getPlot();
	     plot.setBackgroundPaint(new Color(218,247,197));
		 PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
		            "{0}: {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0.00%"));
		       plot.setLabelGenerator(gen);
	    return chart;
	}
	    
		private PieDataset createHospitalizedByMedicalEventsDataset( ) {
		      DefaultPieDataset dataset = new DefaultPieDataset( );
		      refreshData();
		      for (String s : hospitalizedByMedicalEvents.keySet())
		      dataset.setValue( s , hospitalizedByMedicalEvents.get(s) );  
		      return dataset;         
		   }
		
		 public JPanel createHospitalizedByMedicalEventsPanel( ) {
		      JFreeChart chart = createHospitalizedByMedicalEventsChart(createHospitalizedByMedicalEventsDataset( ) );  
		      chart.setBackgroundPaint(new Color(232,253,255));
		      ChartPanel chartPanel = new ChartPanel( chart );
		      chartPanel.setBounds(31, 22, 477, 361);
		      chartPanel.setMinimumDrawHeight(250);
		      return chartPanel; 
		   }
		 
		 private static JFreeChart createHospitalsProfitOfLast3YearsChart( CategoryDataset dataset ) {
			    JFreeChart chart = ChartFactory.createBarChart(      
			    	       "Hospitals Profit for the past 3 years",
					       "Hospital Name",
					       "Profit",
					       dataset,
					       PlotOrientation.VERTICAL, 
					       true, 
					       true, 
					       false);
			      CategoryPlot plot = (CategoryPlot) chart.getPlot();
			      plot.setBackgroundPaint(new Color(220,220,220));
			      ChartPanel chartPanel = new ChartPanel( chart );        
			      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );    
			    return chart;
			}
			    
				private CategoryDataset createHospitalsProfitOfLast3YearsDataset( ) {
					  DefaultCategoryDataset  dataset = new DefaultCategoryDataset ( );
				      refreshData();
				      for (Integer year : hospitalsProfitOfLast3Years.keySet())
				    	for (String hospitalName : hospitalsProfitOfLast3Years.get(year).keySet())
				      dataset.setValue( hospitalsProfitOfLast3Years.get(year).get(hospitalName) , hospitalName,  year);
				      return dataset;         
				   }
		 
		 public JPanel createHospitalsProfitOfLast3YearsPanel( ) {
		      JFreeChart chart = createHospitalsProfitOfLast3YearsChart(createHospitalsProfitOfLast3YearsDataset( ) );  
		      chart.setBackgroundPaint(new Color(246,255,228));
		      ChartPanel chartPanel = new ChartPanel( chart );
		      chartPanel.setBounds(505, 23, 798, 296);
		      chartPanel.setMinimumDrawHeight(250);
		      return chartPanel; 
		   }
		 
		 private static JFreeChart createMedicalEventsAverageSeverityLevelChart( CategoryDataset dataset ) {
			    JFreeChart chart = ChartFactory.createBarChart(      
			    	       "Medical Events - Average Severity Level",
					       "Medical event",
					       "Severity Level",
					       dataset,
					       PlotOrientation.HORIZONTAL, 
					       true, 
					       true, 
					       false);
			      CategoryPlot plot = (CategoryPlot) chart.getPlot();
			      plot.setBackgroundPaint(new Color(220,220,220));
			      ChartPanel chartPanel = new ChartPanel( chart );        
			      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );    
			    return chart;
			}
			    
				private CategoryDataset createMedicalEventsAverageSeverityLevelDataset( ) {
					  DefaultCategoryDataset  dataset = new DefaultCategoryDataset ( );
				      refreshData();
				    	for (String medicalEvent : medicalEventsAverageSeverityLevel.keySet())
				    	{
				    		Object[] a = medicalEventsAverageSeverityLevel.entrySet().toArray();
				    		Arrays.sort(a, new Comparator() {
				    		    public int compare(Object o1, Object o2) {
				    		    	if (!(((Map.Entry<String, Integer>) o2).getValue()).equals(((Map.Entry<String, Integer>) o1).getValue()))
				    		        return ((Map.Entry<String, Integer>) o2).getValue()
				    		                   .compareTo(((Map.Entry<String, Integer>) o1).getValue());
				    		    	else
				    		    		return ((Map.Entry<String, Integer>) o1).getKey()
					    		                   .compareTo(((Map.Entry<String, Integer>) o2).getKey());
				    		    }
				    		});
				    		for (Object e : a) {
				    		    dataset.setValue( ((Map.Entry<String, Integer>) e).getValue(), ((Map.Entry<String, Integer>) e).getKey(), "");
				    		}
				            
				    	}
				      return dataset;         
				   }
		 
		 public JPanel createMedicalEventsAverageSeverityLevelPanel( ) {
		      JFreeChart chart = createMedicalEventsAverageSeverityLevelChart(createMedicalEventsAverageSeverityLevelDataset( ) );  
		      chart.setBackgroundPaint(new Color(228,228,255));
		      ChartPanel chartPanel = new ChartPanel( chart );
		      chartPanel.setBounds(31, 383, 477, 254);
		      chartPanel.setMinimumDrawHeight(250);
		      return chartPanel; 
		   }
		 
		 private JFreeChart createHospitalsDepartmentsOccupationChart( CategoryDataset dataset ) {
			    JFreeChart chart = ChartFactory.createBarChart(      
			    	       "Hospitals Departments Current Bed Occupation",
					       "Department Name",
					       "Occupation Percentage",
					       dataset,
					       PlotOrientation.VERTICAL, 
					       true, 
					       true, 
					       false);
			      CategoryPlot plot = (CategoryPlot) chart.getPlot();
			      plot.setBackgroundPaint(new Color(204, 204, 255));
			      plot.getDomainAxis().setTickLabelFont(new Font("Tahoma", Font.PLAIN, 9));
			      ValueAxis yAxis = chart.getCategoryPlot().getRangeAxis();
			      yAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
	    			
    			  plot = (CategoryPlot) chart.getPlot();
			      BarRenderer renderer = (BarRenderer) plot.getRenderer();
			   
			      renderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator(){
			    	    @Override
			    	    public String generateToolTip(CategoryDataset dataset, int row, int column) {
			    	        String s = super.generateToolTip(dataset, row, column);
			    	        int b = s.indexOf('(', 1) + 1;
			    	        int e = s.indexOf(',');
			    	        String str = s.substring(e, s.indexOf(")"));
			    	        String str2 = str.substring(str.indexOf(" ")+1, str.length());
			    	        return (s + "% (" + hospitalsDepartmentsOccupation.get(s.substring(b+1,e)).get(str2).get(1).get(0)
						    		+ " out of " + hospitalsDepartmentsOccupation.get(s.substring(b+1,e)).get(str2).get(0).get(0) + " beds)");
			    	    }
			    	});
			      renderer.setLegendItemToolTipGenerator( new CategorySeriesLabelGenerator() {
					
					@Override
					public String generateLabel(CategoryDataset dataset, int arg1) {
						String s = dataset.getRowKey(arg1) + " : No empty departments!";
						for (String departmentName : hospitalsDepartmentsOccupation.get(dataset.getRowKey(arg1)).keySet())
				    		if (hospitalsDepartmentsOccupation.get(dataset.getRowKey(arg1)).get(departmentName).get(2).get(0)==0){
				    			if (s.contains("No empty departments!"))
				    					s = "<html>";
				    			s = s + dataset.getRowKey(arg1) + " : " + departmentName + " is empty (" 
				    		+ hospitalsDepartmentsOccupation.get(dataset.getRowKey(arg1)).get(departmentName).get(1).get(0) + " out of " +
				    		hospitalsDepartmentsOccupation.get(dataset.getRowKey(arg1)).get(departmentName).get(0).get(0) + " beds)" + " <br> ";
				    		}
						if (!s.contains("No empty departments!"))
						s= s + "</html>";
						return s;
					}
				});
			      ChartPanel chartPanel = new ChartPanel( chart );        
			      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );    
			    return chart;
			}
			    
				private CategoryDataset createHospitalsDepartmentsOccupationDataset( ) {
					  DefaultCategoryDataset  dataset = new DefaultCategoryDataset ( );
				      refreshData();
				      for (String hospitalName : hospitalsDepartmentsOccupation.keySet()){
				    	for (String departmentName : hospitalsDepartmentsOccupation.get(hospitalName).keySet()){
				      dataset.setValue( hospitalsDepartmentsOccupation.get(hospitalName).get(departmentName).get(2).get(0) , hospitalName,  departmentName);
				    	}
				      }
				      return dataset;         
				   }
		 
		 public JPanel createHospitalsDepartmentsOccupationPanel( ) {
		      JFreeChart chart = createHospitalsDepartmentsOccupationChart(createHospitalsDepartmentsOccupationDataset( ) );  
		      chart.setBackgroundPaint(new Color(255,227,227));
		      ChartPanel chartPanel = new ChartPanel( chart );
		      chartPanel.setToolTipText("\"\"");
		      chartPanel.setDomainZoomable(true);
		      chartPanel.setDisplayToolTips(true);
		      chartPanel.setBounds(31, 637, 1272, 264);
		      chartPanel.setMinimumDrawHeight(250);
		      return chartPanel; 
		   }
		 
		 private static JFreeChart createHospitalizationNumberVSAgeForEachGenderChart( XYDataset  dataset ) {
			    JFreeChart chart = ChartFactory.createXYLineChart(      
			    	       "Number of Hospitalizations in Relation to Age",
					       "Age",
					       "Number of Hospitalizations",
					       dataset,
					       PlotOrientation.VERTICAL, 
					       true, 
					       true, 
					       false);
			      XYPlot plot = chart.getXYPlot();
			      XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
			      renderer.setSeriesPaint(0, new Color(153,204,255));
			      renderer.setSeriesPaint(1, new Color(255,153,153));
			      renderer.setSeriesStroke(0, new BasicStroke(2.0f));
			      renderer.setSeriesStroke(1, new BasicStroke(2.0f));
			      plot.setOutlinePaint(Color.LIGHT_GRAY);
			      plot.setOutlineStroke(new BasicStroke(2.0f));
			      plot.setRenderer(renderer);
			      plot.setBackgroundPaint(Color.WHITE);
			      plot.setRangeGridlinesVisible(true);
			      plot.setRangeGridlinePaint(Color.BLACK);
			      plot.setDomainGridlinesVisible(true);
			      plot.setDomainGridlinePaint(Color.BLACK);
			      ValueAxis yAxis = chart.getXYPlot().getRangeAxis();
			      yAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
			      ChartPanel chartPanel = new ChartPanel( chart ); 
			      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );    
			    return chart;
			}
			    
				private XYDataset createhospitalizationNumberVSAgeForEachGenderDataset( ) {
					  XYSeriesCollection dataset = new XYSeriesCollection();
					  XYSeries series1 = new XYSeries("Male");
					  XYSeries series2 = new XYSeries("Female");
				      refreshData();
				      for (int i=0;i<hospitalizationNumberVSAgeForMale.get(0).size();i++)
				      series1.add( hospitalizationNumberVSAgeForMale.get(0).get(i), hospitalizationNumberVSAgeForMale.get(1).get(i));
				      for (int i=0;i<hospitalizationNumberVSAgeForFemale.get(0).size();i++)
					      series2.add( hospitalizationNumberVSAgeForFemale.get(0).get(i), hospitalizationNumberVSAgeForFemale.get(1).get(i));
				      dataset.addSeries(series1);
				      dataset.addSeries(series2);
				      return dataset;         
				   }
				
		 public JPanel createhospitalizationNumberVSAgeForEachGenderPanel( ) {
		      JFreeChart chart = createHospitalizationNumberVSAgeForEachGenderChart(createhospitalizationNumberVSAgeForEachGenderDataset( ) );  
		      chart.setBackgroundPaint(new Color(240,255,226));
		      ChartPanel chartPanel = new ChartPanel( chart );
		      chartPanel.setBounds(505, 318, 798, 319);
		      chartPanel.setMinimumDrawHeight(250);
		      return chartPanel; 
		   }
		 
}
