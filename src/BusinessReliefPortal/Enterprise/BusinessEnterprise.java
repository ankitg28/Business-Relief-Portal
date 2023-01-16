/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessReliefPortal.Enterprise;

import Business.DB4OUtil.DB4OUtil;
import BusinessReliefPortal.Business.Business;
import BusinessReliefPortal.BusinessReliefSystem;
import BusinessReliefPortal.Network.Network;
import UserInterface.Main.LoginPage;
import java.util.ArrayList;

/**
 *
 * @author ritvikparamkusham
 */
public class BusinessEnterprise extends Enterprise {

    private ArrayList<Business> businessDir;
    DB4OUtil db40 = DB4OUtil.getInstance();

    public BusinessEnterprise(String name) {
        super(name, EnterpriseType.BUSINESSENTERPRISE);
        businessDir = new ArrayList<>();
    }

    public BusinessEnterprise() {
    }

    public ArrayList<Business> getBusinessDir() {
        return businessDir;
    }

    public void setBusinessDir(ArrayList<Business> businessDir) {
        this.businessDir = businessDir;
    }

    public Business addBusiness(int businessID) {
        // int lastBusId = getLatestBusinessID();
        Business business = new Business(Business.getCount());
//        BusinessReliefSystem.getBusinessReliefSystem().getBusinessDirectory().getBusinessDir().add(business); 
        businessDir.add(business);
        businessID++;
        Business.setCount(businessID);
        return business;

    }

    public Business addBusinesses(int id) {
        int lastBusId = getLatestBusinessID();
        Business business = new Business();
        businessDir.add(business);
        business.setBusinessId(lastBusId);
        return business;

    }

    //method to search businessess by category of essential or non essential businesses
    public Business findBusinessByType(String type) {
        for (Business br : BusinessReliefSystem.getBusinessReliefSystem().getBusinessDirectory().getBusinessDir()) {
            if (br.getBusinessType().equalsIgnoreCase(type)) {
                return br;
            }
        }
        return null;
    }

    public int findBusinessByName(String businessName) {
        for (Business br : BusinessReliefSystem.getBusinessReliefSystem().getBusinessDirectory().getBusinessDir()) {
            if (br.getBusinessName().equalsIgnoreCase(businessName)) {
                return br.getBusinessId();
            }
        }
        return 0;
    }

    public int getLatestBusinessID() {
        int lastBusID = Business.getCount();
        
       
          BusinessReliefSystem system = LoginPage.system;
        for (Network nw : system.getNetworkList()) {
            if ("Boston".equals(nw.getNetworkName())) {
                for (Enterprise ent : nw.getEntDirObj().getEnterpriseList()) {
                    if (ent.getEnterpriseType() == Enterprise.EnterpriseType.BUSINESSENTERPRISE) {
                        BusinessEnterprise busEnt = (BusinessEnterprise) ent;
                        ArrayList<Business> businessDir = busEnt.getBusinessDir();
                        lastBusID = businessDir.get(businessDir.size() - 1).getBusinessId() + 1;

                        return lastBusID;

                    }
                }
            }
        }
        return lastBusID;
    }
    
    public void removeBusiness(int lenderBusId){
      for(Business bus: businessDir){
          if (bus.getBusinessId()==lenderBusId) {
              businessDir.remove(bus);
          }
      }
    }

    // method to search businessess owned by government or a lender
//    public Business findbyOwner(String ownerName){
//        for(Business br:BusinessReliefSystem.getBusinessReliefSystem().getBusinessDirectory().getBusinessDir()){
//            if(br.getBusinessOf().equalsIgnoreCase(ownerName)){
//                return br;
//            }
//        }
//        return null;
//    }
//    
}
