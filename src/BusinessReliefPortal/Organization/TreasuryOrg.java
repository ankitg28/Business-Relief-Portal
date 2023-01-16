/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessReliefPortal.Organization;

import BusinessReliefPortal.Employee.Employee;
import BusinessReliefPortal.FundManagement.FundsInterface;
import BusinessReliefPortal.UserAccount.UserAccount;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ritvikparamkusham
 */
public class TreasuryOrg extends Organization {

    public float totalFunds;
    public float essentialFunds;
    public float nonessentialFunds;
    public float totalAmountFunded;

    public TreasuryOrg() {
        super(Organization.Type.TREASURYORG.getValue());
        this.totalFunds = 5000;
        this.essentialFunds = (float) (0.70 * this.totalFunds);
        this.nonessentialFunds = (float) (0.30 * this.totalFunds);
    }

    public float getTotalfunds() {
        return totalFunds;
    }

    public float addToTotalfunds(float funds, int percentage) {

        float essPercent = (float) (percentage * 0.01);
        float nonEssPercent = (float) ((100 - percentage) * 0.01);
        essentialFunds = essentialFunds + (float) (essPercent * funds);
        nonessentialFunds = nonessentialFunds + (float) (nonEssPercent * funds);
        totalFunds += funds;
        return totalFunds;
    }

    public float getEssentialfunds() {
        return essentialFunds;
    }

    public void setEssentialfunds(float essentialfunds) {
        essentialFunds = essentialfunds;
    }

    public float getNonessentialfunds() {
        return nonessentialFunds;
    }

    public void setNonessentialfunds(float nonessentialfunds) {
        nonessentialFunds = nonessentialfunds;
    }

    public float useEssentialFunds(float essentialFundsAmount) {
        essentialFunds -= essentialFundsAmount;
        totalFunds -= essentialFundsAmount;
        return essentialFunds;
    }

    public float useNonEssentialFunds(float nonessentialFundsAmount) {
        nonessentialFunds -= nonessentialFundsAmount;
        totalFunds -= nonessentialFundsAmount;
        return nonessentialFunds;
    }

    public boolean checkZeroTotalBalance() {
        if (totalFunds <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public void setTotalAmountFunded(float totalAmountFunded) {
        this.totalAmountFunded = totalAmountFunded;
    }

    public float getTotalAmountFunded() {
        return totalAmountFunded;
    }
    
    
    
    public float deductFunds(float deductAmount,String businessType){
       
        this.totalAmountFunded = getTotalAmountFunded() + deductAmount;
        this.totalFunds = getTotalfunds() - deductAmount;
        
        if ("Essential".equalsIgnoreCase(businessType)) {
            this.essentialFunds = getEssentialfunds()-deductAmount;
        }else if ("NonEssential".equalsIgnoreCase(businessType)){
            this.essentialFunds = getEssentialfunds()-deductAmount;
        }
        
        return this.totalFunds;
    
    }
    

}
