/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessReliefPortal.Business;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author ankitgoyal
 */
public class BusinessDirectory {
    
    private ArrayList<Business> businessDir;
    //private Map<Integer,Business> businessMap =  new HashMap<>();;

    public BusinessDirectory() {
        this.businessDir = new ArrayList<>();
    }

    public ArrayList<Business> getBusinessDir() {
        return businessDir;
    }

    public void setBusinessDir(ArrayList<Business> businessDirectory) {
        this.businessDir = businessDirectory;
    }

 
    
    
    
    
//    public Business addNewBusiness(){
//        Business business = new Business();
//        businessDir.add(business);
//        return business;
//    }
//    
//    //method to search businessess by category of essential or non essential businesses
//    public Business findBusinessByType(String type){
//        for(Business br:businessDir){
//            if(br.getBusinessType().equalsIgnoreCase(type)){
//                return br;
//            }
//        }
//        return null;
//    }
//    // method to search businessess owned by government or a lender
//    public Business findbyOwner(String ownerName){
//        for(Business br:businessDir){
//            if(br.getBusinessOf().equalsIgnoreCase(ownerName)){
//                return br;
//            }
//        }
//        return null;
//    }


    
}
