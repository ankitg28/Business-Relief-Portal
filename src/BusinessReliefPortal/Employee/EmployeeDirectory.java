/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessReliefPortal.Employee;

import java.util.ArrayList;

/**
 *
 * @author ritvikparamkusham
 */
public class EmployeeDirectory {
    
    private ArrayList<Employee> employeeList;
    
    public EmployeeDirectory() {
        employeeList = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    
    public void createEmployee(Employee e){
        
        employeeList.add(e);
       
    }
}
