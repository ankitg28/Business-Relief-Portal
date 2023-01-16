/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessReliefPortal.Enterprise;

import BusinessReliefPortal.Borrower.Borrower;
import BusinessReliefPortal.Lender.Lender;
import BusinessReliefPortal.Person.Person;
import BusinessReliefPortal.UserAccount.UserAccount;
import BusinessReliefPortal.UserAccount.UserAccountDirectory;
import java.util.ArrayList;

/**
 *
 * @author ankitgoyal
 */
public class UserAndVerificationEnterprise extends Enterprise{
    
    private ArrayList<Borrower> borrowerDirectory;
    private ArrayList<Lender> lenderDirectory;
    private ArrayList<Person> personDirectory;
    private UserAccountDirectory userAccountDirectory;
    
    public UserAndVerificationEnterprise(String name) {
        super(name, EnterpriseType.USERANDVERIFICATIONENTERPRISE);{
    }
        this.userAccountDirectory = new UserAccountDirectory();
        this.borrowerDirectory = new ArrayList<>();
        this.lenderDirectory = new ArrayList<>();
        this.personDirectory = new ArrayList<>();
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public void setUserAccountDirectory(UserAccountDirectory userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }

    
    public ArrayList<Borrower> getBorrowerDirectory() {
        return borrowerDirectory;
    }

    public void setBorrowerDirectory(ArrayList<Borrower> borrowerDirectory) {
        this.borrowerDirectory = borrowerDirectory;
    }

    public ArrayList<Lender> getLenderDirectory() {
        return lenderDirectory;
    }

    public void setLenderDirectory(ArrayList<Lender> lenderDirectory) {
        this.lenderDirectory = lenderDirectory;
    }

    public ArrayList<Person> getPersonDirectory() {
        return personDirectory;
    }

    public void setPersonDirectory(ArrayList<Person> personDirectory) {
        this.personDirectory = personDirectory;
    }
    
     public Person addPerson(Person person){
        personDirectory.add(person);
        return person;
    }
    
    public Person addPerson(String name, String email, String profilePic,  String activeStatus){
        Person person = new Person( name,  email,  profilePic,   activeStatus);
        //person.setUserAccount(createPersonCredentials(name,role));
        personDirectory.add(person);
        return person;
    }
    
    public UserAccount createPersonCredentials(String username, UserAccount.RoleType personRoleType){
        UserAccount newUserAccount  = new UserAccount();
        newUserAccount.setUserName(username);
        newUserAccount.setPassword("123");
        newUserAccount.setRoleType(personRoleType);
        userAccountDirectory.getUserAccountList().add(newUserAccount);
        return newUserAccount;
    }
    
    public Lender addLender(String lenderID,String name, String email, String profilePic, UserAccount.RoleType roleType, String activeStatus){
        Lender lender = new Lender(lenderID,name,email,profilePic,roleType,activeStatus);
        lenderDirectory.add(lender);
        return lender;
    }
    
    // Should we pick personId to link a borrower to a person??
    public Borrower addBorrower(String borrowerID,String name, String email, String profilePic, UserAccount.RoleType roleType, String activeStatus)
    {
        Borrower borrower = new Borrower(borrowerID,name,email,profilePic,roleType,activeStatus);
        borrowerDirectory.add(borrower);
        return borrower;
    }
    
    
    
    
    
    
}
