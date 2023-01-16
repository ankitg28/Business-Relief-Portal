/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessReliefPortal.Enterprise;

import BusinessReliefPortal.Employee.Employee;
import BusinessReliefPortal.Organization.Organization;
import BusinessReliefPortal.Organization.OrganizationDirectory;
import BusinessReliefPortal.UserAccount.UserAccount;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ankitgoyal
 */
public abstract class Enterprise {
    
    private EnterpriseType enterpriseType;
    private OrganizationDirectory organizationDirectory;
    private Map<Integer,Employee> employeeDirectory;

    public Enterprise() {
        
    }
    
    public Enterprise(String name, EnterpriseType type) {
//        super(name);
        this.enterpriseType = type;
        organizationDirectory = new OrganizationDirectory();
    }
    
    public enum EnterpriseType{
       BUSINESSENTERPRISE("Business Enterprise"),
       FUNDMANAGEMENTENTERPRISE("Fund Management Enterprise"),
       PROPOSALMANAGEMENTENTERPRISE("Proposal Management Enterprise"),
       USERANDVERIFICATIONENTERPRISE("User and Verification Enterprise"),
       CUSTOMERSUPPORTENTERPRISE("Customer Support Enterprise");
        
        private String value;

        private EnterpriseType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }
    
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
    
     public void setEmployees(String name,String email,String status,Organization.Type orgType, UserAccount userAccount){
          Employee emp = new Employee(name,email,status,orgType);
          emp.setUserAccount(userAccount);
          
        Employee addEmployee = addEmployee(emp);
        Map<Integer, Employee> empDir = getEmployeeDirectory();
        try {
            int empId = empDir.size() + 1;//dummy
        } catch (java.lang.NullPointerException e) {
            empDir = new HashMap<>();
        }
        empDir.put(emp.getEmployeeId(), emp);

        this.setEmployeeDirectory(empDir);
          
     }
    
    
}
