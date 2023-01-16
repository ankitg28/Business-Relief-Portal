/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BusinessReliefPortal.FundManagement;

/**
 *
 * @author ritvikparamkusham
 */
public interface FundsInterface {
    public static float totalFunds = 5000;
    public static float essentialFunds = (float) (0.70*totalFunds);
    public static float nonessentialFunds = (float) (0.30*totalFunds);
    
     public abstract float getTotalfunds();

    public abstract void addToTotalfunds(float totalfunds);

    public abstract float getEssentialfunds();
    public void setEssentialfunds(float essentialfunds);

    public float getNonessentialfunds();

    public void setNonessentialfunds(float nonessentialfunds);
   
    public float useEssentialFunds(float essentialFundsAmount);
    
     public float useNonEssentialFunds(float nonessentialFundsAmount);
     public boolean checkZeroTotalBalance();
    
}
