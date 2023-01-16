/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessReliefPortal.Borrower;

import BusinessReliefPortal.Person.Person;
import BusinessReliefPortal.UserAccount.UserAccount;

/**
 *
 * @author ankitgoyal
 */
public class Borrower extends Person{
   // private Person person;
    private String borrowerId;
    private int businessId;
    private static int count = 1;
    private String businessName;
    private String businessDescription;
    private String businessLocation; // This can be used to store google maps location
    private int employeeCount;
    private double revenue;
    private double employeeAverageSalary;
    private double requestedFund;
    private UserAccount borrowerAccount;
    private String agreementPath="";

//    public Borrower(){
//        businessId = count;
//        count++;
//       // this.person = person;
//    }

    public Borrower(int businessId, String businessName, String businessDescription, String businessLocation, int employeeCount, double revenue, double employeeAverageSalary, double requestedFund, String name, String email, String profilePic, UserAccount.RoleType roleType, String activeStatus) {
        super(name, email, profilePic, activeStatus);
        this.businessId = businessId;
        this.businessName = businessName;
        this.businessDescription = businessDescription;
        this.businessLocation = businessLocation;
        this.employeeCount = employeeCount;
        this.revenue = revenue;
        this.employeeAverageSalary = employeeAverageSalary;
        this.requestedFund = requestedFund;
    }
    
    public Borrower(String borrowerID,String name, String email, String profilePic, UserAccount.RoleType roleType, String activeStatus) {
        super(name, email, profilePic, activeStatus);      
        this.borrowerId = borrowerID;
        this.businessId = 0;
        this.businessName = "";
        this.businessDescription = "";
        this.businessLocation = "";
        this.employeeCount = 0;
        this.revenue = 0;
        this.employeeAverageSalary = 0;
        this.requestedFund = 0;
    }

    public Borrower(String borrowerId, int businessId, String businessName, String businessDescription, String businessLocation, int employeeCount, double revenue, double employeeAverageSalary, double requestedFund, UserAccount borrowerAccount, String name, String email, String profilePic, UserAccount.RoleType roleType, String activeStatus) {
        super(name, email, profilePic, activeStatus);
        this.borrowerId = borrowerId;
        this.businessId = businessId;
        this.businessName = businessName;
        this.businessDescription = businessDescription;
        this.businessLocation = businessLocation;
        this.employeeCount = employeeCount;
        this.revenue = revenue;
        this.employeeAverageSalary = employeeAverageSalary;
        this.requestedFund = requestedFund;
        this.borrowerAccount = borrowerAccount;
    }
    

    public void setBorrowerId(String borrowerId) {
        this.borrowerId = borrowerId;
    }

    public String getBorrowerId() {
        return borrowerId;
    }
    
    public int getBusinessId() {
        return businessId;
    }

    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Borrower.count = count;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessDescription() {
        return businessDescription;
    }

    public void setBusinessDescription(String businessDescription) {
        this.businessDescription = businessDescription;
    }

    public String getBusinessLocation() {
        return businessLocation;
    }

    public void setBusinessLocation(String businessLocation) {
        this.businessLocation = businessLocation;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public double getEmployeeAverageSalary() {
        return employeeAverageSalary;
    }

    public void setEmployeeAverageSalary(double employeeAverageSalary) {
        this.employeeAverageSalary = employeeAverageSalary;
    }

//    public Person getPerson() {
//        return person;
//    }
//
//    public void setPerson(Person person) {
//        this.person = person;
//    }

    public double getRequestedFund() {
        return requestedFund;
    }

    public void setRequestedFund(double requestedFund) {
        this.requestedFund = requestedFund;
    }

    public UserAccount getBorrowerAccount() {
        return borrowerAccount;
    }

    public void setBorrowerAccount(UserAccount borrowerAccount) {
        this.borrowerAccount = borrowerAccount;
    }

    public String getAgreementPath() {
        return agreementPath;
    }

    public void setAgreementPath(String agreementPath) {
        this.agreementPath = agreementPath;
    }
    
    
    

    @Override
    public String toString() {
        return  String.valueOf(businessId) ;
    } 
    
}
