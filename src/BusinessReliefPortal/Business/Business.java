/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessReliefPortal.Business;

import BusinessReliefPortal.Organization.Organization;

/**
 *
 * @author ankitgoyal
 */
public class Business {
    
    private int businessId;
    private static int count = 1;
    private String businessName;
    private String businessDescription;
    private String businessType; // essential or non-essential
    private businessType busType;
    private Organization.Type orgType;
    private String lenderID;
    private String businessLocation; // This can be used to store google maps location

//    public Business() {
//        businessId = count;
//        count++;
//    }
    
      
    
    
    public enum businessType{
          Essential("Essential Business"),
          NonEssential("Non Essential Business");
        
        private String value;
        
        private businessType(String value){
            this.value = value;
        }
        
        public String getValue(){
            return value;
        }
    }
    
     public Business(int businessId) {
       this.businessId = count;
    }

    public Business() {
    }
       

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public int getBusinessId() {
        return businessId;
    }

    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Business.count = count;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessDescription() {
        return businessDescription;
    }

    public void setBusinessDescription(String businessDescription) {
        this.businessDescription = businessDescription;
    }

    public Organization.Type getOrgType() {
        return orgType;
    }

    public void setOrgType(Organization.Type orgType) {
        this.orgType = orgType;
    }

    public String getLenderID() {
        return lenderID;
    }

    public void setLenderID(String lenderID) {
        this.lenderID = lenderID;
    }

    public String getBusinessLocation() {
        return businessLocation;
    }

    public void setBusinessLocation(String businessLocation) {
        this.businessLocation = businessLocation;
    }

    @Override
    public String toString() {
        return String.valueOf(businessId);
    }
    
    
    
}
