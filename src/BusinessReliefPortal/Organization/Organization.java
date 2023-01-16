/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessReliefPortal.Organization;

import BusinessReliefPortal.Employee.Employee;
import BusinessReliefPortal.Employee.EmployeeDirectory;
import BusinessReliefPortal.Proposal.Proposal;
import BusinessReliefPortal.UserAccount.UserAccount;
import BusinessReliefPortal.UserAccount.UserAccountDirectory;
import BusinessReliefPortal.WorkRequest.WorkQueue;
import BusinessReliefPortal.WorkRequest.WorkRequest;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ritvikparamkusham
 */
public class Organization {

    private String name;
    private WorkQueue workQueue;
    private Type orgType;
    private Map<Integer,WorkRequest>  workQueueMap;
    private Map<Integer,Employee> employeeDirectory;
   // private EmployeeDirectory employeeDirectory;//This is the directory of employee which belong to a specific ORG
    //private UserAccountDirectory userAccountDirectory;
    //This is directory with UserName,Passwords and roles-- Employees will have login details in here and roles assigned
    //during the course of application

    public enum Type{
         AUDITINGORG("Auditing Organization"),
        PRIVATEBUSINESSORG("Private Business Organization"),
        PUBLICBUSINESSPORTFOLIOORG("Public Business Organization"),
        
        BORROWERREQUESTPROCESSINGORG("Borrower Request Processing Organization"),
       // LENDERFUNDERORG("Lender Funder Organization"),
        LICENSEPERMISSIONORG("Licence and Permission Organization"),
        PROPOSALORG("Proposal Organization"),
        QUERYRESOLUTIONORG("Query Resolution Organization"),
        TREASURYORG("Treasury Organization"),
        NONE("NONE"),
        USERIDENTIFYORG("User Identity Organization");     
        
        
        private String value;
        
        private Type(String value){
            this.value = value;
        }
        
        public String getValue(){
            return value;
        }
         
    }
    
    public Organization() {

    }

    public Organization(String name) {
        this.name = name;
        this.workQueue = new WorkQueue();
        //this.userAccountDirectory = new UserAccountDirectory();
    }

    public Type getOrgType() {
        return orgType;
    }

    public void setOrgType(Type orgType) {
        this.orgType = orgType;
    }
    
    
    
    
    @Override
    public String toString() {
        return "Organization{" + "name=" + name + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

//    public EmployeeDirectory getEmployeeDirectory() {
//        return employeeDirectory;
//    }
//
//    public void setEmployeeDirectory(EmployeeDirectory employeeDirectory) {
//        this.employeeDirectory = employeeDirectory;
//    }

    public Map<Integer, Employee> getEmployeeDirectory() {
        return employeeDirectory;
    }

    public void setEmployeeDirectory(Map<Integer, Employee> employeeDirectory) {
        this.employeeDirectory = employeeDirectory;
    }
    
    public Employee addEmployee(Employee emp){
           int empId;
        this.employeeDirectory = getEmployeeDirectory();
        try {
        empId = this.employeeDirectory.size() + 1;            
        } catch (java.lang.NullPointerException e) {
            empId = 1;
            this.employeeDirectory = new HashMap<>();
        }  
            emp.setId(empId);
            emp.setEmployeeId(empId);
        this.employeeDirectory.put(empId, emp);
        return emp; 
    }
    
}
