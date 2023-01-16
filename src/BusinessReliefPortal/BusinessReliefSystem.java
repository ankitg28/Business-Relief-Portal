/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessReliefPortal;

import BusinessReliefPortal.Borrower.BorrowerDirectory;
import BusinessReliefPortal.Business.Business;
import BusinessReliefPortal.Business.BusinessDirectory;
import BusinessReliefPortal.Enterprise.BusinessEnterprise;
import BusinessReliefPortal.Enterprise.Enterprise;
import BusinessReliefPortal.Enterprise.UserAndVerificationEnterprise;
import BusinessReliefPortal.Lender.Lender;
import BusinessReliefPortal.Lender.LenderDirectory;
import BusinessReliefPortal.Network.Network;
import BusinessReliefPortal.Organization.Organization;
import BusinessReliefPortal.Organization.PublicBusinessPortfolioOrg;
import BusinessReliefPortal.Organization.TreasuryOrg;
import BusinessReliefPortal.Person.PersonDirectory;
import BusinessReliefPortal.Proposal.ProposalDirectory;
import BusinessReliefPortal.WorkRequest.WorkQueue;
import BusinessReliefPortal.WorkRequest.WorkRequest;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ankitgoyal
 */
    public class BusinessReliefSystem {
     private ArrayList<Network> networkList;
     private static BusinessReliefSystem businessReliefSystem;
     private BorrowerDirectory  borrowerDirectory;
     private LenderDirectory lenderDirectory;
     private ProposalDirectory proposalDirectory;
     private BusinessDirectory businessDirectory;
     private PersonDirectory personDirectory;
    // private WorkQueue workQueue;
     
     
     public static BusinessReliefSystem getInstance() 
     {
        if (businessReliefSystem == null) 
        {
           businessReliefSystem = new BusinessReliefSystem();
        }
        return businessReliefSystem;
    }
    
     public BusinessReliefSystem()
    {
//        super(null);
        networkList=new ArrayList<>();
        borrowerDirectory=new BorrowerDirectory();
        lenderDirectory=new LenderDirectory();
        proposalDirectory=new ProposalDirectory();
        personDirectory = new PersonDirectory();
    }

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }

    public void setPersonDirectory(PersonDirectory personDirectory) {
        this.personDirectory = personDirectory;
    }

    
     
    public BusinessDirectory getBusinessDirectory() {
        return businessDirectory;
    }
    
    public void setBusinessDirectory(BusinessDirectory businessDirectory) {
        this.businessDirectory = businessDirectory;
    }

    
    public BorrowerDirectory getBorrowerDirectory() {
        return borrowerDirectory;
    }

    public void setBorrowerDirectory(BorrowerDirectory borrowerDirectory) {
        this.borrowerDirectory = borrowerDirectory;
    }

    public LenderDirectory getLenderDirectory() {
        return lenderDirectory;
    }

    public void setLenderDirectory(LenderDirectory lenderDirectory) {
        this.lenderDirectory = lenderDirectory;
    }

    public ProposalDirectory getProposalDirectory() {
        return proposalDirectory;
    }

    public void setProposalDirectory(ProposalDirectory proposalDirectory) {
        this.proposalDirectory = proposalDirectory;
    }
    
     public static BusinessReliefSystem getBusinessReliefSystem() {
        return businessReliefSystem;
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(Network network) {
        
        this.networkList.add(network);
    }
    
    public Network addNetwork()
    {
        Network n = new Network();
        networkList.add(n);
        return n;
    }
    
     public HashMap<String,Integer> TotalFundsDistribution(){
            HashMap<String,Integer> fundsDist = new HashMap<String,Integer>();
            for (Network nw : networkList) {
            if ("Boston".equalsIgnoreCase(nw.getNetworkName())) {
                for (Enterprise en : nw.getEntDirObj().getEnterpriseList()) {
                    if (en.getEnterpriseType() == Enterprise.EnterpriseType.FUNDMANAGEMENTENTERPRISE) {
                        for (Organization org : en.getOrganizationDirectory().getOrganizationList()) {
                            if (org.getOrgType() == Organization.Type.TREASURYORG) {
                                TreasuryOrg treasury = (TreasuryOrg) org;
                                fundsDist.put("Government",(int) treasury.totalFunds);
                            }
                        }

                    }
                    if(en.getEnterpriseType() == Enterprise.EnterpriseType.USERANDVERIFICATIONENTERPRISE){
                        UserAndVerificationEnterprise userEnt = (UserAndVerificationEnterprise) en;
                        for (Lender len : userEnt.getLenderDirectory()) {
                            fundsDist.put(len.getLenderID(),(int) len.getFundingAmount());
                        }
                    }
                }
                
            }
        }
            return fundsDist;
    }
     
    
     
    public int totalLenderAmountFunded(){
        int totalLenderFunds = 0;
        for (Network nw : networkList) {
            if ("Boston".equals(nw.getNetworkName())) {
                for (Enterprise ent : nw.getEntDirObj().getEnterpriseList()) {
                    System.out.println("inent");
                    if (ent.getEnterpriseType() == Enterprise.EnterpriseType.USERANDVERIFICATIONENTERPRISE) {
                        UserAndVerificationEnterprise userEnt = (UserAndVerificationEnterprise) ent;
                        for (Lender len : userEnt.getLenderDirectory()) {
                            totalLenderFunds+=len.getFundingAmount();
                        }
                        return totalLenderFunds;
                    }
                }
            }
        }
        return 0;
    }
    
    public HashMap<String,Integer> BusinessDistribution(){
            HashMap<String,Integer> BusinessDist = new HashMap<String,Integer>();
            int publicbusinesscnt = 0;
            int privatebusinesscnt = 0;
            for (Network nw : networkList) {
            if ("Boston".equalsIgnoreCase(nw.getNetworkName())) {
                for (Enterprise en : nw.getEntDirObj().getEnterpriseList()) {
                   if (en.getEnterpriseType() == Enterprise.EnterpriseType.BUSINESSENTERPRISE) {
                        BusinessEnterprise busEnt = (BusinessEnterprise) en;
                        ArrayList<Business> businessList = busEnt.getBusinessDir();
                        for (Business bus : businessList) {
                            if(bus.getOrgType() == Organization.Type.PUBLICBUSINESSPORTFOLIOORG){
//                                
                               publicbusinesscnt+=1; 
                            }
                            else
                            {
                                privatebusinesscnt+=1;
                            }

                        }
                    }
                }
                
            }
        }
            BusinessDist.put("Government",publicbusinesscnt);
            BusinessDist.put("Lenders",privatebusinesscnt);
            return BusinessDist;
    }
    
    
}
