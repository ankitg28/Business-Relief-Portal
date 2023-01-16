/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessReliefPortal.Lender;

import BusinessReliefPortal.Business.Business;
import BusinessReliefPortal.Person.Person;
import java.util.ArrayList;

/**
 *
 * @author ankitgoyal
 */
public class LenderDirectory {
    
    private ArrayList<Lender> lenderDirectory;

    public LenderDirectory() {
        this.lenderDirectory = new ArrayList<>();
    }

    public ArrayList<Lender> getLenderDirectory() {
        return lenderDirectory;
    }

    public void setLenderDirectory(ArrayList<Lender> lenderDirectory) {
        this.lenderDirectory = lenderDirectory;
    }
    
//    public Lender addLender(Person person){
//        //Lender lender = new Lender(person);
////        lenderDirectory.add(lender);
////        return lender;
//    }
    
//    public void addBusiness(Business business, Lender lender){
//        for(Lender searchLender: lenderDirectory){
//            if(searchLender.getPerson().getName() == lender.getPerson().getName()){
//                searchLender.getSupportedBusinesses().add(business);
//                return;
//            }
//        }
//    }
    
}
