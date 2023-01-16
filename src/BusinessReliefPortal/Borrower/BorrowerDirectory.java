/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessReliefPortal.Borrower;

import BusinessReliefPortal.Person.Person;
import java.util.ArrayList;

/**
 *
 * @author ankitgoyal
 */
public class BorrowerDirectory {
    
    private ArrayList<Borrower> borrowerDirectory;

    public BorrowerDirectory() {
        this.borrowerDirectory = new ArrayList<>();
    }

    
    public ArrayList<Borrower> getBorrowerDirectory() {
        return borrowerDirectory;
    }

    public void setBorrowerDirectory(ArrayList<Borrower> borrowerDirectory) {
        this.borrowerDirectory = borrowerDirectory;
    }
    
//    public Borrower addBorrower(Person person){
//        Borrower borrower = new Borrower(person);
//        borrowerDirectory.add(borrower);
//        return borrower;
//    }
    
}
