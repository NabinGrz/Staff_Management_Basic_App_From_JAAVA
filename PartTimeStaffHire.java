
//creation of new class PartTimeStaffHire that is a sub class of StaffHire class
public class PartTimeStaffHire extends StaffHire {
    
    String staffName,joiningDate,qualification,appointedBy,shifts;
    int workingHour,wagesPerHour;
    boolean isTerminated,hasJoined;

    //constructor with six parameters in which three are inherited from StaffHire superclass
    public PartTimeStaffHire(int vacancyNumber, String designation, String jobType, int workingHour, int wagesPerHour, String shifts) {
        super(vacancyNumber, designation, jobType);
        
        this.wagesPerHour = wagesPerHour;
        this.workingHour = workingHour;
        this.shifts = shifts;
        staffName="";
        appointedBy = "";
        qualification = "";        
        joiningDate = "";
        isTerminated = false;
        hasJoined = false;
        
    }

    //accessor methods getter and setter
    public int getWagesPerHour() {
        return wagesPerHour;
    }

    public void setWagesPerHour(int wagesPerHour) {
        this.wagesPerHour = wagesPerHour;
    }
    public int getWorkingHour() {
        return workingHour;
    }

    public void setWorkingHour(int workingHour) {
        this.workingHour = workingHour;
    }



    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

     public String getAppointedBy() {
        return appointedBy;
    }

    public void setAppointedBy(String appointedBy) {
        this.appointedBy = appointedBy;
    }
    public String getJoiningDate() {
        return joiningDate;
    }
     public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }
   

    public String getShifts() {
        return shifts;
    }

    public void setShifts(String shifts) {
        this.shifts = shifts;
    }

    public boolean isHasJoined() {
        return hasJoined;
    }

    public void setHasJoined(boolean hasJoined) {
        this.hasJoined = hasJoined;
    }
    public boolean isTerminated() {
        return isTerminated;
    }

    public void setTerminated(boolean terminated) {
        isTerminated = terminated;
    }
  
    // Setting condition methods:
    public void setNewShifts(String shifts){
        if (hasJoined != true){
            this.shifts= shifts;
        } else {
            System.out.println("Staff has been already appointed.");
            System.out.println();
        }
    }
    //method for hiring Part Time Staff that takes parameters of  String and Boolean
 //the method checks the truth value of variable hasJoined
 //if value is false then it prints the staff name,appointedby,qualification,joiningdate
 //if value is false then it displays "Staff has been apointed already"
    public void hirePartTimeStaff(String staffName, String joiningDate, String qualification, String appointedBy){
        if (hasJoined == false){
            this.staffName = staffName;
            this.qualification = qualification;            
            this.appointedBy = appointedBy;
            this.joiningDate = joiningDate;
            this.hasJoined = true;
        } else {
            System.out.println("Staff has been already appointed.");
            System.out.println();
        }
    }
    //method for terminating Part Time Staff
 //the method checks the truth value of variable isTerminated
 //if value is true then it prints the staff name,appointedby,qualification,joiningdate
 //if value is true then it displays "Staff terminated"
    public void terminatePartTimeStaff(){
        if(isTerminated==true){
            System.out.println("Staff terminated");
        } else {
            isTerminated = true;
            hasJoined = false;
            this.staffName = "";            
            this.qualification = "";
            this.appointedBy = "";
            this.joiningDate = "";
        }
    }
 //super keyword is used to invoke immediate parent class(StaffHre) constructor,method.
   //method to print/display details of the Staff Hire
   
    @Override
    public void displayStaffHire(){
        if (hasJoined==true){
        	System.out.println("Part Time Staff Details:"); 
        	System.out.println("--------------------------");
            System.out.println("Staff Name: " + staffName);
            System.out.println("Qualification: " + qualification);
            	super.displayStaffHire();
            System.out.println("Wages per hour: " + wagesPerHour);
            System.out.println("Working Hour: " + workingHour);           
            System.out.println("Income per day: "+ (workingHour*wagesPerHour));
            System.out.println("Appointed By: " + appointedBy);
            System.out.println("Joining Date: " + joiningDate);
            System.out.println("Working Shifts:" +shifts);
            System.out.println();
        }
    }

}
