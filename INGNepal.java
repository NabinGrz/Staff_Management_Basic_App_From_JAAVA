/*
 INGNepal class contains graphical user interface (GUI) and ArrayList
 for a system that stores details of vacancy and hired staff details in the list. 
 The class contain a main method and a constructor
 
 Name: Nabin Gurung
 Group: C12
 Date: 2020-4-17
 
*/

//importing different awt,swing classes
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

//importing array list class
import java.util.ArrayList;

//creating class and implementing ActionListener interface 
public class INGNepal implements ActionListener
	{
    
	//creating different instance variables
    private String desigNationForFullTime,jobTypeForFullTime,staffNameForFullTime,joiningDateForFullTime,qualificationForFullTime,appointedByForFullTime,wagesPerHourForFullTime;
	private int vacNumForFullTime,salaryForFullTime,workingHourForFullTime;
	private String yearFullTime,monthFullTime,dayFullTime;
	
	private String desigNationForPartTime,jobTypeForPartTime,staffNameForPartTime,joiningDateForPartTime,qualificationForPartTime,appointedByForPartTime,radioButton_Morning,radioButton_Day;	
	private int vacNumForPartTime,workingHourForPartTime,salaryForPartTime,wagesPerHourForPartTime;
	private String yearPartTime,monthPartTime,dayPartTime;
	
	private String workingShiftsRadioButton;
	private String jobTypeCheckBox_FT,jobTypeCheckBox_PT;
	
	//creating different instance variables for GUI
	private JFrame frameStaffHire;
	private JPanel myPanel;
    
	private JTextField txtFieldForVacancyNum_FT,txtFieldForVacancyNum_2_FT,txtFieldForStaffNam_FT,txtFieldForDesignation_FT,txtFieldForWgsPerHr_FT,txtFieldForAppointedBy_FT,txtFieldForSalaryFT;
	private JTextField txtFieldForVacancyNum_PT,txtFieldForVacancyNum_2_PT,txtFieldForStaffNam_PT,txtFieldForDesignation_PT,txtFieldForWgsPerHr_PT,txtFieldForAppointedBy_PT,txtFieldToTerminate;
	private JCheckBox checkBoxFullTime_FT,checkBoxPartTime_FT,checkBoxFullTime_PT,checkBoxPartTime_PT;
	private JRadioButton radioButton_Morning_PT,radioButton_Day_PT;
	private JComboBox<Object> comboBoxWorkingHour_FT,comboBoxQualification_FT,comboBoxWorkingHour_PT,comboBoxQualification_PT,cmbYear_FT,cmbMonth_FT,cmbDay_FT,cmbYear_PT,cmbMonth_PT,cmbDay_PT;
	private JMenuBar menuBar;
	private JMenu fileMenu,exitMenu,searchMenu,aboutMenu,addMenu,appointMenu,displayMenu;
	private JMenuItem openMenuItem,saveMenuItem,clearMenuItem,exitMenuItem,fullMenuItem,partMenuItem,fullTimeToAppoint,partTimeToAppoint,fullTimeDisplayItem,partTimeDisplayItem;
	private JButton btnClear,btnDisplay,btnAppointFullTime,btnAddFullTime,btnAppointPartTime,btnAddPartTime,btnTerminate,btnTest;
    
    //making array list of "StaffHire" type
    ArrayList <StaffHire> list=new ArrayList<StaffHire>();
    
    public static void main(String[] args)
    {
        INGNepal object=new INGNepal();
        object.myGUI();  //calling method
    }
    
    //creating non-parameterized constructor
    //creating GUI inside constructor
    public void myGUI() 
    {
    	//creating frame
        frameStaffHire=new JFrame("Staff Hire");
        frameStaffHire.setVisible(true);
        frameStaffHire.setResizable(true);
        frameStaffHire.setBounds(293, 1, 820, 780);

        JPanel myPanel=new JPanel();
        myPanel.setLayout(null);
  
        Color cframe=new Color(176, 196, 222);
        myPanel.setBackground(cframe);
                        
        frameStaffHire.add(myPanel);      
        frameStaffHire.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //creating menubar
        menuBar=new JMenuBar();
        menuBar.setBackground(Color.lightGray);
        frameStaffHire.setJMenuBar(menuBar);
                

        fileMenu=new JMenu("File");
        menuBar.add(fileMenu);
        
    		saveMenuItem=new JMenuItem("Save");
    		fileMenu.add(saveMenuItem);               
                                             
    		clearMenuItem=new JMenuItem("Clear");
    		clearMenuItem.addActionListener(this);
    		fileMenu.add(clearMenuItem);
        
        displayMenu=new JMenu("Display");
        menuBar.add(displayMenu);
        	
        	fullTimeDisplayItem=new JMenuItem("Full Time");
        	fullTimeDisplayItem.addActionListener(this);
        	displayMenu.add(fullTimeDisplayItem);
        		
        	partTimeDisplayItem=new JMenuItem("Part Time");
        	partTimeDisplayItem.addActionListener(this);
        	displayMenu.add(partTimeDisplayItem);
 
        addMenu=new JMenu("Add");
        menuBar.add(addMenu);
        
        	fullMenuItem=new JMenuItem("Full Time");
        	fullMenuItem.addActionListener(this);
        	addMenu.add(fullMenuItem);
        	
        	partMenuItem=new JMenuItem("Part Time");
        	partMenuItem.addActionListener(this);
        	addMenu.add(partMenuItem);
                
        appointMenu=new JMenu("Appoint");
        menuBar.add(appointMenu);
        
        	fullTimeToAppoint=new JMenuItem("Full Time");
        	fullTimeToAppoint.addActionListener(this);
        	appointMenu.add(fullTimeToAppoint);
        	
        	partTimeToAppoint=new JMenuItem("Part Time");
        	partTimeToAppoint.addActionListener(this);
        	appointMenu.add(partTimeToAppoint);

        searchMenu=new JMenu("Search");
        menuBar.add(searchMenu);

        aboutMenu=new JMenu("Edit");
        menuBar.add(aboutMenu);
        
        exitMenu=new JMenu("Exit");
        menuBar.add(exitMenu);   
        

//creating different labels in full time staff hire portion
        JLabel lblVacancyNumber = new JLabel("Vacancy Number:");
        lblVacancyNumber.setFont(new Font("Arial", Font.BOLD, 17));
        lblVacancyNumber.setBounds(42, 70, 190, 20);
        myPanel.add(lblVacancyNumber);
        
        JLabel lblVacancyNumber2 = new JLabel("Vacancy Number:");
        lblVacancyNumber2.setFont(new Font("Arial", Font.BOLD, 17));
        lblVacancyNumber2.setBounds(430, 70, 190, 20);
        myPanel.add(lblVacancyNumber2);
        
        JLabel lblStaffhire = new JLabel("For Full Time Staff Hire");
        lblStaffhire.setFont(new Font("Arial", Font.BOLD, 25));
        lblStaffhire.setBounds(40, 35, 300, 20);
        myPanel.add(lblStaffhire);

        JLabel lblStaffName = new JLabel("Staff Name:");
        lblStaffName.setFont(new Font("Arial", Font.PLAIN, 13));
        lblStaffName.setBounds(430, 120, 100, 20);
        myPanel.add(lblStaffName);
        
        JLabel lblJobType = new JLabel("Job Type:");
        lblJobType.setFont(new Font("Arial", Font.PLAIN, 13));
        lblJobType.setBounds(40, 120, 100, 20);
        myPanel.add(lblJobType);

        JLabel lblDesgination = new JLabel("Desgination:");
        lblDesgination.setFont(new Font("Arial", Font.PLAIN, 13));
        lblDesgination.setBounds(40, 151, 100, 20);
        myPanel.add(lblDesgination);
        
        JLabel lblWorkingHour = new JLabel("Working Hour:");
        lblWorkingHour.setFont(new Font("Arial", Font.PLAIN, 13));
        lblWorkingHour.setBounds(40, 182, 100, 20);
        myPanel.add(lblWorkingHour);
  
        JLabel lblWagesPerHour = new JLabel("Wages Per Hour:");
        lblWagesPerHour.setFont(new Font("Arial", Font.PLAIN, 13));
        lblWagesPerHour.setBounds(430, 182, 150, 20);
        myPanel.add(lblWagesPerHour);
    
        JLabel lblQualification = new JLabel("Qualification:");
        lblQualification.setFont(new Font("Arial", Font.PLAIN, 13));
        lblQualification.setBounds(430, 151, 100, 20);
        myPanel.add(lblQualification);
        
        JLabel lblJoiningDate = new JLabel("Joining Date:");
        lblJoiningDate.setFont(new Font("Arial", Font.PLAIN, 13));
        lblJoiningDate.setBounds(430, 213, 150, 18);
        myPanel.add(lblJoiningDate);
        
        JLabel lblAppointedBy = new JLabel("Appointed By:");
        lblAppointedBy.setFont(new Font("Arial", Font.PLAIN, 13));
        lblAppointedBy.setBounds(430, 244, 150, 18);
        myPanel.add(lblAppointedBy);

        JLabel lblSalary = new JLabel("Salary:");
        lblSalary.setFont(new Font("Arial", Font.PLAIN, 13));
        lblSalary.setBounds(40, 213, 100, 20);
        myPanel.add(lblSalary);

//creating different labels in part time staff hire portion
        JLabel lblTitleParTime = new JLabel("For Part Time Staff Hire");
        lblTitleParTime.setFont(new Font("Arial", Font.BOLD, 25));
        lblTitleParTime.setBounds(42, 345, 300, 20);
        myPanel.add(lblTitleParTime);
        
        JLabel lblVacancyNumberPT = new JLabel("Vacancy Number:");
        lblVacancyNumberPT.setFont(new Font("Arial", Font.BOLD, 17));
        lblVacancyNumberPT.setBounds(42, 390, 190, 20);
        myPanel.add(lblVacancyNumberPT);
      
        JLabel lblVacancyNumber2PT = new JLabel("Vacancy Number:");
        lblVacancyNumber2PT.setFont(new Font("Arial", Font.BOLD, 17));
        lblVacancyNumber2PT.setBounds(430, 390, 190, 20);
        myPanel.add(lblVacancyNumber2PT);

        JLabel lblStaffNamePT = new JLabel("Staff Name:");
        lblStaffNamePT.setFont(new Font("Arial", Font.PLAIN, 13));
        lblStaffNamePT.setBounds(430, 440, 100, 20);
        myPanel.add(lblStaffNamePT);
        
        JLabel lblJobTypePT = new JLabel("Job Type:");
        lblJobTypePT.setFont(new Font("Arial", Font.PLAIN, 13));
        lblJobTypePT.setBounds(40,440,100,20);
        myPanel.add(lblJobTypePT);

        JLabel lblDesginationPT = new JLabel("Desgination:");
        lblDesginationPT.setFont(new Font("Arial", Font.PLAIN, 13));
        lblDesginationPT.setBounds(40, 471, 100, 20);
        myPanel.add(lblDesginationPT);
        
        JLabel lblWorkingHourPT = new JLabel("Working Hour:");
        lblWorkingHourPT.setFont(new Font("Arial", Font.PLAIN, 13));
        lblWorkingHourPT.setBounds(40, 502, 100, 20);
        myPanel.add(lblWorkingHourPT);
        
        JLabel lblWorkingShiftsPT = new JLabel("Working Shifts:");
        lblWorkingShiftsPT.setFont(new Font("Arial", Font.PLAIN, 13));
        lblWorkingShiftsPT.setBounds(40, 533, 100, 20);
        myPanel.add(lblWorkingShiftsPT);
        
        JLabel lblWagesPerHourPT = new JLabel("Wages Per Hour:");
        lblWagesPerHourPT.setFont(new Font("Arial", Font.PLAIN, 13));
        lblWagesPerHourPT.setBounds(40, 564, 150, 20);
        myPanel.add(lblWagesPerHourPT);
    
        JLabel lblQualificationPT = new JLabel("Qualification:");
        lblQualificationPT.setFont(new Font("Arial", Font.PLAIN, 13));
        lblQualificationPT.setBounds(430, 471, 100, 20);
        myPanel.add(lblQualificationPT);
        
        JLabel lblJoiningDatePT = new JLabel("Joining Date:");
        lblJoiningDatePT.setFont(new Font("Arial", Font.PLAIN, 13));
        lblJoiningDatePT.setBounds(430, 502, 150, 20);
        myPanel.add(lblJoiningDatePT);
        
        JLabel lblAppointedByPT = new JLabel("Appointed By:");
        lblAppointedByPT.setFont(new Font("Arial", Font.PLAIN, 13));
        lblAppointedByPT.setBounds(430, 533, 150, 20);
        myPanel.add(lblAppointedByPT);

        JLabel lblVacancyNumberTerminate = new JLabel("Vacancy Number:");
        lblVacancyNumberTerminate.setFont(new Font("Arial", Font.PLAIN, 13));
        lblVacancyNumberTerminate.setBounds(40, 670, 150, 20);
        myPanel.add(lblVacancyNumberTerminate);


//creating different text fields in full time staff hire portion

        txtFieldForVacancyNum_FT = new JTextField();
        txtFieldForVacancyNum_FT.setBounds(191, 70, 68, 25);
        myPanel.add(txtFieldForVacancyNum_FT); 

        txtFieldForVacancyNum_2_FT = new JTextField();
        txtFieldForVacancyNum_2_FT.setBounds(579, 70, 68, 25);
        myPanel.add(txtFieldForVacancyNum_2_FT);  

        txtFieldForStaffNam_FT = new JTextField();
        txtFieldForStaffNam_FT.setBounds(579, 120, 200, 25);
        myPanel.add(txtFieldForStaffNam_FT);

        txtFieldForDesignation_FT = new JTextField();
        txtFieldForDesignation_FT.setBounds(190, 151, 200, 25);
        myPanel.add(txtFieldForDesignation_FT);

        txtFieldForWgsPerHr_FT = new JTextField();
        txtFieldForWgsPerHr_FT.setBounds(579, 182, 200, 25);
        myPanel.add(txtFieldForWgsPerHr_FT);

        txtFieldForAppointedBy_FT = new JTextField();
        txtFieldForAppointedBy_FT.setBounds(579, 244, 200, 25);
        myPanel.add(txtFieldForAppointedBy_FT);

        txtFieldForSalaryFT = new JTextField();
        txtFieldForSalaryFT.setBounds(190, 213, 200, 25);
        myPanel.add(txtFieldForSalaryFT);
        

//creating different text fields in part time staff hire portion 

        txtFieldForVacancyNum_PT = new JTextField();
        txtFieldForVacancyNum_PT.setBounds(191, 390, 68, 25);
        myPanel.add(txtFieldForVacancyNum_PT); 

        txtFieldForVacancyNum_2_PT = new JTextField();
        txtFieldForVacancyNum_2_PT.setBounds(579, 390, 68, 25);
        myPanel.add(txtFieldForVacancyNum_2_PT);  

        txtFieldForStaffNam_PT = new JTextField();
        txtFieldForStaffNam_PT.setBounds(579, 440, 200, 25);
        myPanel.add(txtFieldForStaffNam_PT);

        txtFieldForDesignation_PT = new JTextField();
        txtFieldForDesignation_PT.setBounds(190, 471, 200, 25);
        myPanel.add(txtFieldForDesignation_PT);

        txtFieldForWgsPerHr_PT = new JTextField();
        txtFieldForWgsPerHr_PT.setBounds(191, 564, 200, 25);
        myPanel.add(txtFieldForWgsPerHr_PT);

        txtFieldForAppointedBy_PT = new JTextField();
        txtFieldForAppointedBy_PT.setBounds(579, 533, 200, 25);
        myPanel.add(txtFieldForAppointedBy_PT);

        txtFieldToTerminate = new JTextField();
        txtFieldToTerminate.setBounds(152, 666, 68, 25);
        myPanel.add(txtFieldToTerminate);
        
 
//creating different check boxes
 
        checkBoxFullTime_FT = new JCheckBox("Full Time");
        Color cfull1=new Color(176, 196, 222);
        checkBoxFullTime_FT.setBackground(cfull1);
        checkBoxFullTime_FT.setBounds(190, 120, 80, 23);         
        myPanel.add(checkBoxFullTime_FT);
        
        checkBoxPartTime_FT = new JCheckBox("Part Time");
        Color cpart1=new Color(176, 196, 222);
        checkBoxPartTime_FT.setBackground(cpart1);
        checkBoxPartTime_FT.setBounds(270, 120, 80, 23);
        myPanel.add(checkBoxPartTime_FT);
        
        

        checkBoxFullTime_PT = new JCheckBox("Full Time");
        Color cfull2=new Color(176, 196, 222);
        checkBoxFullTime_PT.setBackground(cfull2);
        checkBoxFullTime_PT.setBounds(190, 440, 80, 23);         
        myPanel.add(checkBoxFullTime_PT);
        
        checkBoxPartTime_PT = new JCheckBox("Part Time");
        Color cpart2=new Color(176, 196, 222);
        checkBoxPartTime_PT.setBackground(cpart2);
        checkBoxPartTime_PT.setBounds(270, 440, 80, 23);
        myPanel.add(checkBoxPartTime_PT);
        
//creating radiobutton       
        
        radioButton_Morning_PT = new JRadioButton("Morning");
        Color m2=new Color(176, 196, 222);
        radioButton_Morning_PT.setBackground(m2);
        radioButton_Morning_PT.setBounds(191, 533, 80, 27);
        myPanel.add(radioButton_Morning_PT);
        
        radioButton_Day_PT = new JRadioButton("Day");
        Color d2=new Color(176, 196, 222);
        radioButton_Day_PT.setBackground(d2);
        radioButton_Day_PT.setBounds(271, 533, 68, 27);
        myPanel.add(radioButton_Day_PT);

        
//creating different Combo Boxes

        String workinghour[]= {"6","7","8","9","10","11","12","13","14"};
        comboBoxWorkingHour_FT = new JComboBox<Object>(workinghour);
        comboBoxWorkingHour_FT.setBounds(190, 182, 50, 20);
        myPanel.add(comboBoxWorkingHour_FT);

        String qualification[]= {"SLC","+2","Bachelor","Master"};
        comboBoxQualification_FT = new JComboBox<Object>(qualification);
        comboBoxQualification_FT.setBounds(579, 150, 90, 25);
        myPanel.add(comboBoxQualification_FT);


        String workinghourPT[]= {"6","7","8","9","10","11","12","13","14"};
        comboBoxWorkingHour_PT = new JComboBox<Object>(workinghourPT);
        comboBoxWorkingHour_PT.setBounds(190, 502, 50, 20);
        myPanel.add(comboBoxWorkingHour_PT);

        String qualificationPT[]= {"SLC","+2","Bachelor","Master"};
        comboBoxQualification_PT = new JComboBox<Object>(qualificationPT);
        comboBoxQualification_PT.setBounds(579, 471, 90, 25);
        myPanel.add(comboBoxQualification_PT);
        
        
        
        String year[]={"1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013","2014","2015","2016","2017","2018","2019","2020","2021"};
        cmbYear_FT=new JComboBox<Object>(year);
        cmbYear_FT.setBounds(579, 213, 60, 25);
        myPanel.add(cmbYear_FT);
        
        String month[]={"January","February","March","April","May","June","July","August","September","October","November","December"};
        cmbMonth_FT=new JComboBox<Object>(month);
        cmbMonth_FT.setBounds(639, 213, 80, 25);
        myPanel.add(cmbMonth_FT);
        
        String day[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        cmbDay_FT=new JComboBox<Object>(day);
        cmbDay_FT.setBounds(719, 213, 50, 25);
        myPanel.add(cmbDay_FT);
        
        
        String yearPT[]={"1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013","2014","2015","2016","2017","2018","2019","2020","2021"};
        cmbYear_PT=new JComboBox<Object>(yearPT);
        cmbYear_PT.setBounds(579, 502, 60, 25);
        myPanel.add(cmbYear_PT);
        
        String monthPT[]={"January","February","March","April","May","June","July","August","September","October","November","December"};
        cmbMonth_PT=new JComboBox<Object>(monthPT);
        cmbMonth_PT.setBounds(639, 502, 80, 25);
        myPanel.add(cmbMonth_PT);
        
        String dayPT[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        cmbDay_PT=new JComboBox<Object>(dayPT);
        cmbDay_PT.setBounds(719, 502, 50, 25);
        myPanel.add(cmbDay_PT);
        
    
       
//creating different Buttons     

        btnClear = new JButton("Clear");
        btnClear.addActionListener(this);       
        btnClear.setBounds(660, 662, 140, 30);
        myPanel.add(btnClear);
        
        btnDisplay = new JButton("Display");
        btnDisplay.setBounds(515, 662, 140, 30);
        btnDisplay.addActionListener(this);
        myPanel.add(btnDisplay);

        btnAddFullTime = new JButton("Add Vacancy For Full Time Staff");
        btnAddFullTime.setBounds(38, 280,240, 35);
        btnAddFullTime.addActionListener(this);
        myPanel.add(btnAddFullTime);
        
        btnAddPartTime = new JButton("Add Vacancy For Part Time Staff");
        btnAddPartTime.setBounds(40, 600, 240, 35);
        btnAddPartTime.addActionListener(this);
        myPanel.add(btnAddPartTime);

        btnAppointFullTime = new JButton("Appoint For Full Time Staff");
        btnAppointFullTime.setBounds(430,280, 250, 35);
        btnAppointFullTime.addActionListener(this);
        myPanel.add(btnAppointFullTime);

        btnAppointPartTime = new JButton("Appoint For Part Time Staff");
        btnAppointPartTime.setBounds(430, 600, 250, 35);
        btnAppointPartTime.addActionListener(this);
        myPanel.add(btnAppointPartTime);

       
        btnTerminate = new JButton("Terminate");
        btnTerminate.addActionListener(this);       
        btnTerminate.setBounds(228, 662, 150, 35);
        myPanel.add(btnTerminate);

       
    }

    
    @Override
    //Overriding actionPerformed method of ActionListener interface 
    public void actionPerformed(ActionEvent e) 
    {	
    	
    	//when specific radio button "radioButton_Morning_PT" is selected,then setting "radioButton_Day_PT" radio button to false
    	if(radioButton_Morning_PT.isSelected()) {
    		radioButton_Day_PT.setSelected(false);
    	}
    	if(radioButton_Day_PT.isSelected()) {
    		radioButton_Morning_PT.setSelected(false);
    	}
    	
    	//when specific radio button 'radioButton_Morning_PT" is selected,then assigning "workingShiftsRadioButton" value to "workingShiftsRadioButton"
    	workingShiftsRadioButton="";
    	if(radioButton_Morning_PT.isSelected()) {
    		workingShiftsRadioButton="Morning";
    	}
    	if(radioButton_Day_PT.isSelected()) {
    		workingShiftsRadioButton="Day";
    	}

    	
    	
    	jobTypeCheckBox_FT="";
    	if(checkBoxFullTime_FT.isSelected()) {
    		checkBoxPartTime_FT.setSelected(false);
    	}
    	if(checkBoxPartTime_FT.isSelected()) {
    		checkBoxFullTime_FT.setSelected(false);
    	}
    	
    	if(checkBoxFullTime_FT.isSelected()) {
    		jobTypeCheckBox_FT="Full Time";
    	}
    	if(checkBoxPartTime_FT.isSelected()) {
    		jobTypeCheckBox_FT="Part Time";
    	}
    	

    	
    	jobTypeCheckBox_PT="";
    	if(checkBoxFullTime_PT.isSelected()) {
    		checkBoxPartTime_PT.setSelected(false);
    	}
    	if(checkBoxPartTime_PT.isSelected()) {
    		checkBoxFullTime_PT.setSelected(false);
    	}
    	
    	if(checkBoxFullTime_PT.isSelected()) {
    		jobTypeCheckBox_PT="Full Time";
    	}
    	if(checkBoxPartTime_PT.isSelected()) {
    		jobTypeCheckBox_PT="Part Time";
    	}

    	
    	
    	
    	
        if(e.getSource()==btnClear) {
        	//when "Clear" button is clicked,then all the provided values in radio button,text field,check box and combo box are set to empty

            txtFieldForVacancyNum_FT.setText("");
            txtFieldForStaffNam_FT.setText("");
            txtFieldForDesignation_FT.setText("");
            txtFieldForStaffNam_FT.setText("");
            txtFieldForWgsPerHr_FT.setText("");
            txtFieldForAppointedBy_FT.setText("");
            txtFieldForSalaryFT.setText("");
            txtFieldForVacancyNum_2_FT.setText("");
  
            radioButton_Morning_PT.setSelected(false);
            radioButton_Day_PT.setSelected(false);
            
            cmbYear_FT.setSelectedIndex(0);
            cmbMonth_FT.setSelectedIndex(0);
            cmbDay_FT.setSelectedIndex(0);
            comboBoxWorkingHour_FT.setSelectedIndex(0);
            comboBoxQualification_FT.setSelectedIndex(0);

            checkBoxFullTime_FT.setSelected(false);
            checkBoxPartTime_FT.setSelected(false);
            checkBoxFullTime_PT.setSelected(false);
            checkBoxPartTime_PT.setSelected(false);
            
            txtFieldForVacancyNum_PT.setText("");
            txtFieldForStaffNam_PT.setText("");
            txtFieldForDesignation_PT.setText("");
            txtFieldForStaffNam_PT.setText("");
            txtFieldForWgsPerHr_PT.setText("");
            txtFieldToTerminate.setText("");
            txtFieldForAppointedBy_PT.setText("");
            txtFieldForVacancyNum_2_PT.setText("");
            
            cmbYear_PT.setSelectedIndex(0);
            cmbMonth_PT.setSelectedIndex(0);
            cmbDay_PT.setSelectedIndex(0);
            comboBoxQualification_PT.setSelectedIndex(0);
            comboBoxWorkingHour_PT.setSelectedIndex(0);
                            
        }
        if(e.getSource()==clearMenuItem) {
        	
        	//when "Clear" Menu Item is clicked,then all the provided values in radio button,text field,check box and combo box are set to empty
        	
            txtFieldForVacancyNum_FT.setText("");
            txtFieldForStaffNam_FT.setText("");
            txtFieldForDesignation_FT.setText("");
            txtFieldForStaffNam_FT.setText("");
            txtFieldForWgsPerHr_FT.setText("");
            txtFieldForAppointedBy_FT.setText("");
            txtFieldForSalaryFT.setText("");
            txtFieldForVacancyNum_2_FT.setText("");
  
            radioButton_Morning_PT.setSelected(false);
            radioButton_Day_PT.setSelected(false);
            
            cmbYear_FT.setSelectedIndex(0);
            cmbMonth_FT.setSelectedIndex(0);
            cmbDay_FT.setSelectedIndex(0);
            comboBoxWorkingHour_FT.setSelectedIndex(0);
            comboBoxQualification_FT.setSelectedIndex(0);

            checkBoxFullTime_FT.setSelected(false);
            checkBoxPartTime_FT.setSelected(false);
            checkBoxFullTime_PT.setSelected(false);
            checkBoxPartTime_PT.setSelected(false);
            
            txtFieldForVacancyNum_PT.setText("");
            txtFieldForStaffNam_PT.setText("");
            txtFieldForDesignation_PT.setText("");
            txtFieldForStaffNam_PT.setText("");
            txtFieldForWgsPerHr_PT.setText("");
            txtFieldToTerminate.setText("");
            txtFieldForAppointedBy_PT.setText("");
            txtFieldForVacancyNum_2_PT.setText("");
            
            cmbYear_PT.setSelectedIndex(0);
            cmbMonth_PT.setSelectedIndex(0);
            cmbDay_PT.setSelectedIndex(0);
            comboBoxQualification_PT.setSelectedIndex(0);
            comboBoxWorkingHour_PT.setSelectedIndex(0);
        }
        
        if(e.getSource()==fullMenuItem) {
        	
        	//when "Full" Menu Item is clicked,then all the provided values in radio button,text field,check box and combo box are set to empty
        	
        	try {
          	  vacNumForFullTime=Integer.parseInt(txtFieldForVacancyNum_FT.getText());               
          	  desigNationForFullTime=txtFieldForDesignation_FT.getText();
                		String wh=(comboBoxWorkingHour_FT.getSelectedItem()).toString(); 
                workingHourForFullTime=Integer.parseInt(wh);            	 
          	  salaryForFullTime=Integer.parseInt(txtFieldForSalaryFT.getText());          

                  boolean duplicateVacancyNum=false;
                      for(StaffHire var:list){
                  if(var.getVacancyNumber()==vacNumForFullTime){
                      duplicateVacancyNum=true;
                      break;
                  }
                      }
          if(duplicateVacancyNum==false){
              FullTimeStaffHire objectFullTime=new FullTimeStaffHire(vacNumForFullTime, desigNationForFullTime,jobTypeCheckBox_FT,salaryForFullTime,workingHourForFullTime);
                  list.add(objectFullTime);
              JOptionPane.showMessageDialog(frameStaffHire,"Vacancy has been added in Full Time.Thank You!");
          }else{
               JOptionPane.showMessageDialog(frameStaffHire,"Vacancy Number you have entered is already added.Please input new vacancy number. "); 
          }

             }catch(NumberFormatException exp){          
             JOptionPane.showMessageDialog(frameStaffHire,"Invalid Input,Please Try Again!"); 
          }
        	
        }
        
        if(e.getSource()==fullTimeToAppoint) {
        	
        	//when "Appoint Full Time" button is clicked,then following things should happen
            try {
             
            	//getting and converting values of text field,combo box to string
            	
         	   vacNumForFullTime=Integer.parseInt(txtFieldForVacancyNum_2_FT.getText()); 
         	   staffNameForFullTime=txtFieldForStaffNam_FT.getText();
         	   		yearFullTime = (cmbYear_FT.getSelectedItem()).toString();
         	   		monthFullTime = (cmbMonth_FT.getSelectedItem()).toString();
         	   		dayFullTime = (cmbDay_FT.getSelectedItem()).toString();
                 
               joiningDateForFullTime = yearFullTime+"/"+monthFullTime+"/"+dayFullTime;
                  	String wh=(comboBoxWorkingHour_FT.getSelectedItem()).toString(); 
                  	//String wh = getSelectedItem(comboBoxWorkingHour_FT) CONVERT TO STRING
               workingHourForFullTime=Integer.parseInt(wh); 
               qualificationForFullTime=(comboBoxQualification_FT.getSelectedItem()).toString();
               wagesPerHourForFullTime=txtFieldForWgsPerHr_FT.getText();
               appointedByForFullTime=txtFieldForAppointedBy_FT.getText();
             
             boolean foundVacancyNum=false;
             //iterating array list
             for(StaffHire staffHire:list) {
                 if(staffHire.getVacancyNumber()==vacNumForFullTime) {
                     foundVacancyNum=true;
                     // using "instanceof" to check if object is in FullTimeStaffHire class
                     if(staffHire instanceof FullTimeStaffHire) { 
                         FullTimeStaffHire h=(FullTimeStaffHire)staffHire;
                         if(h.isJoined()==true){
                             JOptionPane.showMessageDialog(frameStaffHire,"Staff has been hired already!!");
                         }else{
                            h.hireFullTimeStaff(staffNameForFullTime,joiningDateForFullTime,qualificationForFullTime,appointedByForFullTime);
                           JOptionPane.showMessageDialog(frameStaffHire,"Staff has been hired in Full Time.Thank You!!");
                           break;
                         }
                     }else{
                         JOptionPane.showMessageDialog(frameStaffHire,"Not for fulltime staff Hire");
                         break;
                     }
                 }
            
             }
             
             if(!foundVacancyNum){
                 JOptionPane.showMessageDialog(frameStaffHire,"Invalid Vacancy Number,Please Try Again!");
                 
             }
             
             }catch(Exception e3) {
                 JOptionPane.showMessageDialog(frameStaffHire,"Invalid Input,Please Try Again!"); 
             }
        }
        
        if(e.getSource()==partTimeToAppoint) {
        	
        	try {
                
                vacNumForPartTime=Integer.parseInt(txtFieldForVacancyNum_2_PT.getText()); 
                staffNameForPartTime=txtFieldForStaffNam_PT.getText();
                	yearPartTime = (cmbYear_PT.getSelectedItem()).toString();
                	monthPartTime = (cmbMonth_PT.getSelectedItem()).toString();
                	dayPartTime = (cmbDay_PT.getSelectedItem()).toString();                 
                joiningDateForPartTime = yearPartTime+"/"+monthPartTime+"/"+dayPartTime;                
                qualificationForPartTime=(comboBoxQualification_PT.getSelectedItem()).toString();
                radioButton_Morning=(radioButton_Morning_PT.getText()).toString();
                radioButton_Day=(radioButton_Day_PT.getText()).toString();
                	String WagesPrHr=(txtFieldForWgsPerHr_PT.getText());
                wagesPerHourForPartTime=Integer.parseInt(WagesPrHr);
                appointedByForPartTime=txtFieldForAppointedBy_PT.getText();
                
                boolean foundVacancyNum=false;
                for(StaffHire staffHire:list) {
                    if(staffHire.getVacancyNumber()==vacNumForPartTime) {
                        foundVacancyNum=true;
                        if(staffHire instanceof PartTimeStaffHire) {  //instanceof help to check,if the object is present in FTSH
                            PartTimeStaffHire h2=(PartTimeStaffHire)staffHire;
                            if(h2.isHasJoined()==true){
                                JOptionPane.showMessageDialog(frameStaffHire,"Staff has been hired already!!");
                            }else{
                               h2.hirePartTimeStaff(staffNameForPartTime,joiningDateForPartTime,qualificationForPartTime,appointedByForPartTime);
                              JOptionPane.showMessageDialog(frameStaffHire,"Staff has been hired in Part Time.Thank You!!");
                              break;
                            }
                        }else{
                            JOptionPane.showMessageDialog(frameStaffHire,"Not for Part time staff Hire");
                            break;
                        }
                   }
               }
            
                
                if(!foundVacancyNum){
                    JOptionPane.showMessageDialog(frameStaffHire,"Invalid Vacancy Number,Please Try Again!");
                }
                
                
            	}catch(Exception e3) {
                    JOptionPane.showMessageDialog(frameStaffHire,"Invalid Input,Please Try Again!"); 
                }
        }
        
        if(e.getSource()==fullTimeDisplayItem) {
        	
        	for(StaffHire staffHire:list) {
    			if(staffHire instanceof FullTimeStaffHire) {
    				FullTimeStaffHire o1=(FullTimeStaffHire)staffHire;
    				o1.displayStaffHire();
    			}
        	}
        	System.exit(0);
        }
        
        if(e.getSource()==partTimeDisplayItem) {
        	
        	for(StaffHire staffHire:list) {
    			if(staffHire instanceof PartTimeStaffHire) {
    				PartTimeStaffHire o1=(PartTimeStaffHire)staffHire;
    				o1.displayStaffHire();
    			}
        	}
        	System.exit(0);
        }

        if(e.getSource()==partMenuItem) {
        	
        	try {
            	vacNumForPartTime=Integer.parseInt(txtFieldForVacancyNum_PT.getText());               //converting String value entered in text field into Integer
                desigNationForPartTime=txtFieldForDesignation_PT.getText();                                                 
                	String wh_P=(comboBoxWorkingHour_PT.getSelectedItem()).toString();  
                workingHourForPartTime=Integer.parseInt(wh_P); 
                	String WagesPrHr=(txtFieldForWgsPerHr_PT.getText());
                wagesPerHourForPartTime=Integer.parseInt(WagesPrHr);  

                boolean duplicateVacancyNumParTime=false;
                    for(StaffHire staffHire:list){
                if(staffHire.getVacancyNumber()==vacNumForPartTime){
                    duplicateVacancyNumParTime=true;
                    break;
                }
                    }
        if(duplicateVacancyNumParTime==false){
            PartTimeStaffHire obj=new PartTimeStaffHire(vacNumForPartTime, desigNationForPartTime,jobTypeCheckBox_PT,workingHourForPartTime,wagesPerHourForPartTime,workingShiftsRadioButton);
                list.add(obj);
            JOptionPane.showMessageDialog(frameStaffHire,"Vacancy has been added in Part Time.Thank You!");
        }else{
             JOptionPane.showMessageDialog(frameStaffHire,"Vacancy Number you have entered is already added.Please input new vacancy number. "); 
        }
       
        	}catch(NumberFormatException expe)	{
        			JOptionPane.showMessageDialog(frameStaffHire,"Invalid Input!Please try again");
        	}
        	
        	
        }

            if(e.getSource()==btnAddFullTime) {
            	
              try {
            	  vacNumForFullTime=Integer.parseInt(txtFieldForVacancyNum_FT.getText());               
            	  desigNationForFullTime=txtFieldForDesignation_FT.getText();
                  		String wh=(comboBoxWorkingHour_FT.getSelectedItem()).toString(); 
                  workingHourForFullTime=Integer.parseInt(wh);            	 
            	  salaryForFullTime=Integer.parseInt(txtFieldForSalaryFT.getText());          

                    boolean duplicateVacancyNum=false;
                        for(StaffHire var:list){
                    if(var.getVacancyNumber()==vacNumForFullTime){
                        duplicateVacancyNum=true;
                        break;
                    }
               }
            if(duplicateVacancyNum==false){
                FullTimeStaffHire obj=new FullTimeStaffHire(vacNumForFullTime, desigNationForFullTime,jobTypeCheckBox_FT,salaryForFullTime,workingHourForFullTime);
                    list.add(obj);
                JOptionPane.showMessageDialog(frameStaffHire,"Vacancy has been added in Full Time.Thank You!");
            }else{
                 JOptionPane.showMessageDialog(frameStaffHire,"Vacancy Number you have entered is already added.Please input new vacancy number. "); 
            }

            }catch(NumberFormatException exp){          
               JOptionPane.showMessageDialog(frameStaffHire,"Invalid Input,Please Try Again!"); 
            }

           }
            
/*------------------------------------------------------------------------------------------------------------------------------*/
            if(e.getSource()==btnAddPartTime) {

            		try {
                	vacNumForPartTime=Integer.parseInt(txtFieldForVacancyNum_PT.getText());               //converting String value entered in text field into Integer
                    desigNationForPartTime=txtFieldForDesignation_PT.getText();                                                 
                    	String wh_P=(comboBoxWorkingHour_PT.getSelectedItem()).toString();  
                    workingHourForPartTime=Integer.parseInt(wh_P); 
                    	String WagesPrHr=(txtFieldForWgsPerHr_PT.getText());
                    wagesPerHourForPartTime=Integer.parseInt(WagesPrHr);  

                    boolean duplicateVacancyNumParTime=false;
                        for(StaffHire var_P:list){
                    if(var_P.getVacancyNumber()==vacNumForPartTime){
                        duplicateVacancyNumParTime=true;
                        break;
                    }
               }
            if(duplicateVacancyNumParTime==false){
                PartTimeStaffHire obj=new PartTimeStaffHire(vacNumForPartTime, desigNationForPartTime,jobTypeCheckBox_PT,workingHourForPartTime,wagesPerHourForPartTime,workingShiftsRadioButton);
                    list.add(obj);
                JOptionPane.showMessageDialog(frameStaffHire,"Vacancy has been added in Part Time.Thank You!");
            }else{
                 JOptionPane.showMessageDialog(frameStaffHire,"Vacancy Number you have entered is already added.Please input new vacancy number. "); 
            }
           
            		}catch(NumberFormatException expe)	{
            			JOptionPane.showMessageDialog(frameStaffHire,"Invalid Input!Please try again");
            		}
            		
            }
/*------------------------------------------------------------------------------------------------------------------------------*/          
            
            if(e.getSource()==btnAppointFullTime) {

               try {
                
            	   vacNumForFullTime=Integer.parseInt(txtFieldForVacancyNum_2_FT.getText()); 
            	   staffNameForFullTime=txtFieldForStaffNam_FT.getText();
            	   yearFullTime = (cmbYear_FT.getSelectedItem()).toString();
            	   monthFullTime = (cmbMonth_FT.getSelectedItem()).toString();
            	   dayFullTime = (cmbDay_FT.getSelectedItem()).toString();
                    
                     joiningDateForFullTime = yearFullTime+"/"+monthFullTime+"/"+dayFullTime;
                     	String wh=(comboBoxWorkingHour_FT.getSelectedItem()).toString(); 
                     workingHourForFullTime=Integer.parseInt(wh); 
                     qualificationForFullTime=(comboBoxQualification_FT.getSelectedItem()).toString();
                     wagesPerHourForFullTime=txtFieldForWgsPerHr_FT.getText();
                     appointedByForFullTime=txtFieldForAppointedBy_FT.getText();
                
                boolean foundVacancyNum=false;
                for(StaffHire obj:list) {
                    if(obj.getVacancyNumber()==vacNumForFullTime) {
                        foundVacancyNum=true;
                        if(obj instanceof FullTimeStaffHire) {  //instanceof help to check,if the object is present in FTSH
                            FullTimeStaffHire h=(FullTimeStaffHire)obj;
                            if(h.isJoined()==true){
                                JOptionPane.showMessageDialog(frameStaffHire,"Staff has been hired already!!");
                            }else{
                               h.hireFullTimeStaff(staffNameForFullTime,joiningDateForFullTime,qualificationForFullTime,appointedByForFullTime);
                              JOptionPane.showMessageDialog(frameStaffHire,"Staff has been hired in Full Time.Thank You!!");
                              break;
                            }
                        }else{
                            JOptionPane.showMessageDialog(frameStaffHire,"Not for fulltime staff Hire");
                            break;
                        }
                    }
               
                }
                
                if(!foundVacancyNum){
                    JOptionPane.showMessageDialog(frameStaffHire,"Invalid Vacancy Number,Please Try Again!");
                    
                }
                
                }catch(Exception e3) {
                    JOptionPane.showMessageDialog(frameStaffHire,"Invalid Input,Please Try Again!"); 
                }
            
            }
            
/*--------------------------------------------------------------------------------------------------*/
            if(e.getSource()==btnAppointPartTime) {

             try {
                
                vacNumForPartTime=Integer.parseInt(txtFieldForVacancyNum_2_PT.getText()); 
                staffNameForPartTime=txtFieldForStaffNam_PT.getText();
                	yearPartTime = (cmbYear_PT.getSelectedItem()).toString();
                	monthPartTime = (cmbMonth_PT.getSelectedItem()).toString();
                	dayPartTime = (cmbDay_PT.getSelectedItem()).toString();                 
                joiningDateForPartTime = yearPartTime+"/"+monthPartTime+"/"+dayPartTime;                
                qualificationForPartTime=(comboBoxQualification_PT.getSelectedItem()).toString();
                radioButton_Morning=(radioButton_Morning_PT.getText()).toString();
                radioButton_Day=(radioButton_Day_PT.getText()).toString();
                	String WagesPrHr=(txtFieldForWgsPerHr_PT.getText());
                wagesPerHourForPartTime=Integer.parseInt(WagesPrHr);
                appointedByForPartTime=txtFieldForAppointedBy_PT.getText();
                
                boolean foundVacancyNum=false;
                for(StaffHire obj:list) {
                    if(obj.getVacancyNumber()==vacNumForPartTime) {
                        foundVacancyNum=true;
                        if(obj instanceof PartTimeStaffHire) {
                            PartTimeStaffHire h2=(PartTimeStaffHire)obj;
                            if(h2.isHasJoined()==true){
                                JOptionPane.showMessageDialog(frameStaffHire,"Staff has been hired already!!");
                            }else{
                               h2.hirePartTimeStaff(staffNameForPartTime,joiningDateForPartTime,qualificationForPartTime,appointedByForPartTime);
                              JOptionPane.showMessageDialog(frameStaffHire,"Staff has been hired in Part Time.Thank You!!");
                              break;
                            }
                        }else{
                            JOptionPane.showMessageDialog(frameStaffHire,"Not for Part time staff Hire");
                            break;
                        }
                        }
               }
            
                
                if(!foundVacancyNum){
                    JOptionPane.showMessageDialog(frameStaffHire,"Invalid Vacancy Number,Please Try Again!");
                }
                
                
            }
                catch(Exception e3) {
                    JOptionPane.showMessageDialog(frameStaffHire,"Invalid Input,Please Try Again!"); 
                }
            
        }
            
            
            
            
            
            
            if(e.getSource()==btnTerminate) {
            	
            	try {
            		int vacNumToTerminate=Integer.parseInt(txtFieldToTerminate.getText());
            			
            			for(StaffHire objectTerminate:list) {
            					
						if(objectTerminate.getVacancyNumber()==vacNumToTerminate) {
													
            				if(objectTerminate instanceof PartTimeStaffHire) {
            					PartTimeStaffHire ptsh=(PartTimeStaffHire)objectTerminate;
            					if(ptsh.isTerminated()==false) {
            						ptsh.terminatePartTimeStaff();
            						JOptionPane.showMessageDialog(frameStaffHire, "Staff Terminated");	
            						break;
            					}
            					else{
            					JOptionPane.showMessageDialog(frameStaffHire, "Staff is already Terminated");
            						break;
            				}
            			
            			}
            			}else if(objectTerminate.getVacancyNumber()!=vacNumToTerminate){
            				JOptionPane.showMessageDialog(frameStaffHire, "Invalid Vacancy Number,Please Try Again!");
            				
            			}
            	}
			
            	}
            
            	catch(Exception exp3) {          		
            		JOptionPane.showMessageDialog(frameStaffHire, "Invalid Input,Please Try Again!");            		
            	}

            	
            }
            
            if(e.getSource()==btnDisplay) {  
            	
            	//iterating arraylist
            	//using instanceof to check the presence of object in list 
            		for(StaffHire Object2:list) {
            			if(Object2 instanceof FullTimeStaffHire) {
            				FullTimeStaffHire o1=(FullTimeStaffHire)Object2;
            				o1.displayStaffHire();            				
            			}
            			if(Object2 instanceof PartTimeStaffHire) {
            				PartTimeStaffHire o2=(PartTimeStaffHire)Object2;
            				o2.displayStaffHire();
            		}

            		System.exit(0);                           
            }
            
            }
            
    }
            
    }
    

    
    

