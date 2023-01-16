/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessReliefPortal.Proposal;

import BusinessReliefPortal.Borrower.Borrower;
import java.util.ArrayList;

/**
 *
 * @author ankitgoyal
 */
public class ProposalDirectory {
    
    ArrayList<Proposal> proposalDirectory;

    public ProposalDirectory() {
        this.proposalDirectory = new ArrayList<>();
    }

    public ArrayList<Proposal> getProposalDirectory() {
        return proposalDirectory;
    }

    public void setProposalDirectory(ArrayList<Proposal> proposalDirectory) {
        this.proposalDirectory = proposalDirectory;
    }
    
    public Proposal createProposal(String funderId, Borrower borrower, String proposalStatus){
        int propID = getProposalDirectory().size()+1;
        Proposal proposal = new Proposal(propID,funderId,borrower,proposalStatus);
        proposalDirectory.add(proposal);
        return proposal;
    }
    
}
