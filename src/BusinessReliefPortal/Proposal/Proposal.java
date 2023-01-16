/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessReliefPortal.Proposal;

import BusinessReliefPortal.Borrower.Borrower;

/**
 *
 * @author ankitgoyal
 */
public class Proposal {
    
    private int proposalId;
    private String funderId;
    private Borrower borrower;
    private String proposalStatus;
    private double requestedFundAmount;
    private String comments;
    private int businessIdByFunder;
    static int proposalcount=1;

    public Proposal(int proposalid,String funderId, Borrower borrower, String proposalStatus) {
        this.proposalId = proposalid;
        this.funderId = funderId;
        this.borrower = borrower;
        this.proposalStatus = proposalStatus;
        this.requestedFundAmount = 0.0;
        proposalcount++;
    }

    public Proposal( Borrower borrower, String proposalStatus, double requestedFundAmount, String comments) {
   
        this.funderId = funderId;
        this.borrower = borrower;
        this.proposalStatus = proposalStatus;
        this.requestedFundAmount = requestedFundAmount;
        this.comments = comments;
    }
    
    

    public Proposal() {
        this.proposalId = proposalcount;
        this.requestedFundAmount = 0.0;
        proposalcount++;
    }

    public int getProposalId() {
        return proposalId;
    }

    public void setProposalId(int proposalId) {
        this.proposalId = proposalId;
    }

    public String getFunderId() {
        return funderId;
    }

    public void setFunderId(String funderId) {
        this.funderId = funderId;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }

    public String getProposalStatus() {
        return proposalStatus;
    }

    public void setProposalStatus(String proposalStatus) {
        this.proposalStatus = proposalStatus;
    }

    public double getRequestedFundAmount() {
        return requestedFundAmount;
    }

    public void setRequestedFundAmount(double requestedFundAmount) {
        this.requestedFundAmount = requestedFundAmount;
    }

    public static int getProposalcount() {
        return proposalcount;
    }

    public static void setProposalcount(int proposalcount) {
        Proposal.proposalcount = proposalcount;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getBusinessIdByFunder() {
        return businessIdByFunder;
    }

    public void setBusinessIdByFunder(int businessIdByFunder) {
        this.businessIdByFunder = businessIdByFunder;
    }
    

    @Override
    public String toString() {
        return String.valueOf(proposalId);
    }
    
    
    
}
