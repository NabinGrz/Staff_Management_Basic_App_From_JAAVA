

    class FullTimeStaffHire extends StaffHire {
    	int salary,workingHour;
    	String staffName,joiningDate,qualification,appointedBy;
    	boolean hasJoined;


    public FullTimeStaffHire(int vacancyNumber, String designation, String jobType, int salary, int workingHour) {
        super(vacancyNumber, designation, jobType);
        this.workingHour = workingHour;
        this.salary = salary;
        
        staffName="";
        qualification = "";
        appointedBy = "";
        joiningDate = "";
        hasJoined = false;
    }
    
    //asscessor method to get WorkingHour    
    public int getWorkingHour() {
        return workingHour;
    }
    //refer to workingHour of a constructor.
    public void setWorkingHour(int workingHour) {
        this.workingHour = workingHour;
    }
    
    
    //asscessor method to get Salary
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;        
    }
    
    
    
    //asscessor method to get StaffName
    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
    
    
    
    //asscessor method to get Qualification
        public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
    
    
    
    
    //asscessor method to get AppointedBy
        public String getAppointedBy() {
        return appointedBy;
    }

    public void setAppointedBy(String appointedBy) {
        this.appointedBy = appointedBy;
    }
    
    
    
    
    //asscessor method to get JoiningDate
    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }
    
    
    
    

    public boolean isJoined() {
        return hasJoined;
    }
    //asscessor method to get Joined
    public void setJoined(boolean joined) {
        this.hasJoined = joined;
    }
    
    
    
    

    public int salary(int salary){
        if (hasJoined==false){
            this.workingHour = salary;
        }
        else{
            System.out.println("Staff has been appointed already.");
            System.out.println();
        }
        return salary;
    }
    
    
    
    
    public int workingHour(int workingHour){
        if (hasJoined==false){
            this.workingHour = workingHour;
        }else {
            System.out.println("Staff has been appointed already.");
            System.out.println();
        }
        return workingHour;
    }
   
    
    

    public void hireFullTimeStaff(String staffName, String joiningDate, String qualification, String appointedBy){
        if (hasJoined == false){
            this.staffName = staffName;
            this.appointedBy = appointedBy;
            this.qualification = qualification;  
            this.joiningDate = joiningDate;
            this.hasJoined = true;
        } else {
            System.out.println("Staff has been appointed already.");
            System.out.println();
        }
    }
   
    
    @Override
    public void displayStaffHire(){
        if (hasJoined==true){
        	System.out.println("Full Time Staff Details:");
        	System.out.println("--------------------------");
        	System.out.println("Staff Name: " + staffName);
        	System.out.println("Qualification: " + qualification);
        		super.displayStaffHire();
        	System.out.println("Salary: " +salary);
        	System.out.println("Working Hour: " + workingHour);        
        	System.out.println("Appointed By: " + appointedBy);                
        	System.out.println("Joining Date: " + joiningDate);
        	System.out.println();
        }
    }
}
