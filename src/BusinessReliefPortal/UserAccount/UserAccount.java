/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessReliefPortal.UserAccount;

import BusinessReliefPortal.Employee.Employee;
import BusinessReliefPortal.WorkRequest.WorkQueue;
import BusinessReliefPortal.WorkRequest.WorkRequest;
import java.util.ArrayList;

/**
 *
 * @author ankitgoyal
 */
public class UserAccount {
    private String userName;
    private String password;
    private RoleType roleType;

    public UserAccount() {
    }

    
     public enum RoleType{

             //Funds Enterprise
        TREASURER("TREASURER"),//ADDS and view funds
        FUNDMANAGER("FUND MANAGER"),//Manages FUNDS for Govt and LENder - proposal funds deduction
        
        //User and Verification Enterprise 
        REGISTERADMIN("User Registration Manager"),//Enterprise Admin
        LENDER("Lender"),
        BORROWER("Borrower"),
        
        //Proposal and Verification Management Enterprise
        PROPOSALADMIN("Proposal Admin"),//Validates proposals from Borrower -- Proposal Org
        VALIDATOR("Validator"),//Employee validation - lender, borrower -- Audting Org
        
        
        //Business Enterprise     
        PUBLICBUSINESSADMIN("Public Business Admin"), //Public Business org
        PRIVATEBUSINESSADMIN("Private Business Manager"),//Private business org
        
        //Query Enterprise
        QUERYMANAGER("Query Manager"),
        
        SYSTEADMIN("System Admin"),
        
        
//        
//        LENDERFUNDMANAGER("Lender Fund Manager"),
//        GOVERNMENTPROPOSALHEAD("Government Proposal Head"),
//        BORROWERPROPOSALMANAGER("Borrower Proposal Manager"),
//        USERADMINAMANAGEMENT("User Admin Management"),
//        LICENSINGADMIN("Licensing Admin"),
//        QUERYRESOLUTIONADMIN("Query Resolution Admin"),
        NONE("NONE");
        private String value;
        private RoleType(String value){
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
    
    public UserAccount(String userName, String password, RoleType role) {
        this.userName = userName;
        this.password = userName.concat("@123");
        this.roleType = role;
    }
      public UserAccount(String userName, RoleType role) {
        this.userName = userName;
        this.password = userName.concat("@123");
        this.roleType = role;
    }

//    public UserAccount(String userName, String password, String role) {
//        this.userName = userName;
//        this.password = password;
//        //this.roleType = roleType;
//        this.role = role;
//      //  this.workQueueID = workQueueID;
//    }
    
    
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

 

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public RoleType getRoleType() {
        return roleType;
    }

}
