
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessReliefPortal.Lender;

import BusinessReliefPortal.Business.Business;
import BusinessReliefPortal.Enterprise.BusinessEnterprise;
import BusinessReliefPortal.Enterprise.Enterprise;
import BusinessReliefPortal.Network.Network;
import BusinessReliefPortal.Person.Person;
import BusinessReliefPortal.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author ankitgoyal
 */
public class Lender extends Person{
    
    //private Person person;
    private String LenderID;
    private float totalAmountFunded;
   // private float essentialAmountFunded;
  //  private float nonessentialAmountFunded;
    private float fundingAmount;
    private float revenue;
    private float taxAmountPaid;
    private float interestRate;
    private int interestStartYears;
    private int supportedBusinessId;//govt buisness
    private Business LenderBusiness;
    private UserAccount userAccount;

//    public Lender() {
//        this.supportedBusinesses = new ArrayList<>();
//        //this.person = person;
//    }

    public Lender(String LenderID,String name, String email, String profilePic, UserAccount.RoleType roleType, String activeStatus) {
        super(name, email, profilePic, activeStatus);
        this.LenderID = LenderID;
//        this.totalAmountFunded = 0;
//       // this.essentialAmountFunded =0;
//       // this.nonessentialAmountFunded =0;
//        this.revenue = 0;
//        this.taxAmountPaid = 0;
//        this.interestRate = 0;
//        this.interestStartYears = 0;   
//        this.fundingAmount = 0;
    }

    public Lender(String LenderID,  float revenue,float fundingAmount, float taxAmountPaid, float interestRate, int interestStartTime, UserAccount userAccount, String name, String email, String profilePic, UserAccount.RoleType roleType, String activeStatus) {
        super(name, email, profilePic, activeStatus);
        this.LenderID = LenderID;
        this.revenue = revenue;
        this.taxAmountPaid = taxAmountPaid;
        this.interestRate = interestRate;
        this.interestStartYears = interestStartTime;
        this.userAccount = userAccount;
        this.fundingAmount = fundingAmount;
    }

    public float getFundingAmount() {
        return fundingAmount;
    }

    public void setFundingAmount(float fundingAmount) {
        this.fundingAmount = fundingAmount;
    }
    
    
    public void setLenderID(String LenderID) {
        this.LenderID = LenderID;
    }

    public String getLenderID() {
        return LenderID;
    }   
    
    public float getTotalAmountFunded() {
        return totalAmountFunded;
    }

    public int getSupportedBusinessId() {
        return supportedBusinessId;
    }

    public void setSupportedBusinessId(int supportedBusinessId) {
        this.supportedBusinessId = supportedBusinessId;
    }

    public void setTotalAmountFunded(float totalAmountFunded) {
        this.totalAmountFunded = totalAmountFunded;
    }


    public float getRevenue() {
        return revenue;
    }

    public void setRevenue(float revenue) {
        this.revenue = revenue;
    }

    public float getTaxAmountPaid() {
        return taxAmountPaid;
    }

    public void setTaxAmountPaid(float taxAmountPaid) {
        this.taxAmountPaid = taxAmountPaid;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public int getInterestStartYears() {
        return interestStartYears;
    }

    public void setInterestStartYears(int interestStartYears) {
        this.interestStartYears = interestStartYears;
    }

    public Business getLenderBusiness() {
        return LenderBusiness;
    }

    public void setLenderBusiness(Business LenderBusiness) {
        this.LenderBusiness = LenderBusiness;
    }

    
    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
    
    
    public float deductFunds(float deductAmount){
       
        this.totalAmountFunded = getTotalAmountFunded()+ deductAmount;
        if (getFundingAmount()- deductAmount<0) {
            
        }
        this.fundingAmount = getFundingAmount()- deductAmount;
        return this.fundingAmount;
    
    }

    @Override
    public String toString() {
        return String.valueOf(LenderID);
    }
    
    
}
