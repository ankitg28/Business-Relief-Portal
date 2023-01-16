/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessReliefPortal.Employee;

import BusinessReliefPortal.Organization.Organization;
import BusinessReliefPortal.Person.Person;
import BusinessReliefPortal.UserAccount.UserAccount;
import BusinessReliefPortal.WorkRequest.WorkQueue;

/**
 *
 * @author ritvikparamkusham
 */
public class Employee extends Person{

    private int employeeId;
    private Organization.Type belongsToOrg;

    public Employee() {
        super(null, null, null, null);
    }

    public Employee(String name, String email, String activeStatus) {
        super(name, email,activeStatus);
    }
    
     public Employee(String name, String email,  String activeStatus,Organization.Type belongsToOrg) {
        super(name, email,  activeStatus);
        this.belongsToOrg = belongsToOrg;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
     
     

}
