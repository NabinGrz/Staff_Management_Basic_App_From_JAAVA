//Creation of class StaffHire
    class StaffHire{
     
        //variable create    
    String designation,jobType;
    int vacancyNumber;
    
    
//creation of constructor that takes paramaters of string, string and integer data type
    public StaffHire(int vacancyNumber, String designation, String jobType) {
        this.designation = designation;
        this.jobType = jobType;
        this.vacancyNumber = vacancyNumber;
        
    }
//accessor method to get Designation
     public String getDesignation() {
        return designation;
    }
//setter method to set Designation
    public void setDesignation(String designation) {
        this.designation = designation;
    }
//accessor method to get JobType   
    public String getJobType() {
        return jobType;
    }
//setter method to set JobType
    public void setJobType(String jobType) {
        this.jobType = jobType;
    }
//accessor method to get VacancyNumber     
    public int getVacancyNumber() {
        return vacancyNumber;
    }
//setter method to set VacancyNumber
    public void setVacancyNumber(int vacancyNumber) {
        this.vacancyNumber = vacancyNumber;
    }
   //method to print/display details of the Staff Hire
   
    public void displayStaffHire(){
        
        System.out.println("Designation : "+ designation);
        System.out.println("Job Type : "+jobType);
        System.out.println("VacancyNumber : "+vacancyNumber);
    }
}