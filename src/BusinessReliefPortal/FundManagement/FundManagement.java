/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessReliefPortal.FundManagement;

/**
 *
 * @author ankitgoyal
 */

public class FundManagement {
    private float totalfunds;
    private float essentialfunds;
    private float nonessentialfunds;

    public FundManagement() {
        this.totalfunds = 100;
        this.essentialfunds = (float) (0.70 * this.totalfunds);
        this.nonessentialfunds = (float) (0.30* this.totalfunds);
       
    }

    public float getTotalfunds() {
        return totalfunds;
    }

    public void setTotalfunds(float totalfunds) {
        this.totalfunds+=totalfunds;
        this.essentialfunds = (float) (0.70 * this.totalfunds);
        this.nonessentialfunds = (float) (0.30* this.totalfunds);
    }

    public float getEssentialfunds() {
        return essentialfunds;
    }

    public void setEssentialfunds(float essentialfunds) {
        this.essentialfunds = essentialfunds;
    }

    public float getNonessentialfunds() {
        return nonessentialfunds;
    }

    public void setNonessentialfunds(float nonessentialfunds) {
        this.nonessentialfunds = nonessentialfunds;
    }
   
    public float useEssentialFunds(float essentialFundsAmount){
        essentialfunds-=essentialFundsAmount;
        totalfunds-=essentialFundsAmount;
        return essentialfunds;
    }
    
     public float useNonEssentialFunds(float nonessentialFundsAmount){
        nonessentialfunds-=nonessentialFundsAmount;
        totalfunds-=nonessentialFundsAmount;
        return nonessentialfunds;
    }
    
     public boolean checkZeroTotalBalance(){
      if(totalfunds<=0) 
        {
          return true;
        }
      else
        {
          return false;
        }
    }
     
}
