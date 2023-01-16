/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessReliefPortal.Network;

import BusinessReliefPortal.Enterprise.EnterpriseDirectory;
import BusinessReliefPortal.Organization.Organization;
import BusinessReliefPortal.Organization.QueryResolutionOrg;
import BusinessReliefPortal.Proposal.Proposal;
import BusinessReliefPortal.Proposal.ProposalDirectory;
import BusinessReliefPortal.UserAccount.UserAccount;
import BusinessReliefPortal.WorkRequest.WorkQueue;
import BusinessReliefPortal.WorkRequest.WorkRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ankitgoyal
 */
public class Network {

    private String networkName;
    private EnterpriseDirectory enterpriseDirectory;//Enterprises are part of a network 
    public Map<Integer, WorkRequest> workQueueNetwork;
    private ProposalDirectory proposalDirectory;
    private Map<Integer,QueryResolutionOrg> queriesNetwork;
   

    public Map<Integer, Proposal> proposalNetwork;
    
    public Map<Integer,UserAccount>  userAccountsNetwork;
    //To access a specific enterprise we need to which network it does belong to 
    //so while configuring a business we shall enterprise to a network

    public Network() {

        this.enterpriseDirectory = new EnterpriseDirectory();
        this.proposalDirectory = new ProposalDirectory();

    }

    public Network(String networkName, EnterpriseDirectory entDirObj) {
        this.networkName = networkName;
        this.enterpriseDirectory = new EnterpriseDirectory();
        this.proposalDirectory = new ProposalDirectory();

    }

    public ProposalDirectory getProposalDirectory() {
        return proposalDirectory;
    }

    public void setProposalDirectory(ProposalDirectory proposalDirectory) {
        this.proposalDirectory = proposalDirectory;
    }

    public String getNetworkName() {
        return networkName;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    public EnterpriseDirectory getEntDirObj() {
        return enterpriseDirectory;
    }

    public void setEntDirObj(EnterpriseDirectory entDirObj) {
        this.enterpriseDirectory = entDirObj;
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public void setEnterpriseDirectory(EnterpriseDirectory enterpriseDirectory) {
        this.enterpriseDirectory = enterpriseDirectory;
    }

    public Map<Integer, UserAccount> getUserAccountsNetwork() {
        return userAccountsNetwork;
    }

    public void setUserAccountsNetwork(Map<Integer, UserAccount> UserAccounts) {
        this.userAccountsNetwork = UserAccounts;
    }

    public Map<Integer, WorkRequest> getWorkQueueNetwork() {
        return this.workQueueNetwork;
    }

    public void setWorkQueueNetwork(Map<Integer, WorkRequest> workQueue) {
        this.workQueueNetwork = workQueue;
    }
    
     public void setQueriesNetwork(Map<Integer, QueryResolutionOrg> queriesNetwork) {
        this.queriesNetwork = queriesNetwork;
    }

    public Map<Integer, QueryResolutionOrg> getQueriesNetwork() {
        return queriesNetwork;
    }
    
    //method with proposal ID in workRequest Name
    public WorkRequest genWorkRequests(int proposalID,String senderID,String receiverID,UserAccount.RoleType sender, UserAccount.RoleType receiver, Organization.Type senderOrg, Organization.Type receiverOrg, String status, String message) {
        int workReqid;
        this.workQueueNetwork = getWorkQueueNetwork();
        try {
            workReqid = this.workQueueNetwork.size() + 1;

        } catch (java.lang.NullPointerException e) {
            workReqid = 1;
            this.workQueueNetwork = new HashMap<>();
        }
        
     WorkRequest workReqAdd = new WorkRequest(workReqid, senderID, receiverID, sender, receiver, senderOrg, receiverOrg, status, message);
      
     workReqAdd.setWorkRequestName(String.valueOf(proposalID));
     this.workQueueNetwork.put(workReqid, workReqAdd);

        return workReqAdd;
    }
    
    
     public WorkRequest genWorkRequests(String senderID,String receiverID,UserAccount.RoleType sender, UserAccount.RoleType receiver, Organization.Type senderOrg, Organization.Type receiverOrg, String status, String message) {
        int workReqid;
        this.workQueueNetwork = getWorkQueueNetwork();
        try {
            workReqid = this.workQueueNetwork.size() + 1;

        } catch (java.lang.NullPointerException e) {
            workReqid = 1;
            this.workQueueNetwork = new HashMap<>();
        }
        
     WorkRequest workReqAdd = new WorkRequest(workReqid, senderID, receiverID, sender, receiver, senderOrg, receiverOrg, status, message);
        this.workQueueNetwork.put(workReqid, workReqAdd);

        return workReqAdd;
    }
    

    public WorkRequest addWorkRequests(UserAccount.RoleType sender, UserAccount.RoleType receiver, Organization.Type senderOrg, Organization.Type receiverOrg, String status, String message) {
        int workReqid;
        this.workQueueNetwork = getWorkQueueNetwork();
        try {
            workReqid = this.workQueueNetwork.size() + 1;

        } catch (java.lang.NullPointerException e) {
            workReqid = 1;
            this.workQueueNetwork = new HashMap<>();
        }

        WorkRequest workReqAdd = new WorkRequest(workReqid, sender, receiver, senderOrg, receiverOrg, status, message);
        this.workQueueNetwork.put(workReqid, workReqAdd);

        return workReqAdd;
    }

    public  Map<Integer, Proposal> getProposalNetwork() {
        return this.proposalNetwork;
    }

    public  void setProposalNetwork(Map<Integer, Proposal> proposalNetwork) {
        this.proposalNetwork = proposalNetwork;
    }

    public Proposal addProposal() {
        int propID;
        this.proposalNetwork = getProposalNetwork();
        try {
             propID = this.proposalNetwork.size() + 1;

        } catch (java.lang.NullPointerException e) {
            propID = 1;
            this.proposalNetwork = new HashMap<>();
        }
        Proposal proposalAdd = new Proposal();
        proposalAdd.setProposalId(propID);
        
        this.proposalNetwork.put(propID, proposalAdd);
        return proposalAdd;
    }
    
      public void addUserAccountToNetwork(UserAccount ua) {
        int accountId;
        this.userAccountsNetwork = getUserAccountsNetwork();
        try {
             accountId = this.userAccountsNetwork.size() + 1;

        } catch (java.lang.NullPointerException e) {
            accountId = 1;
            this.userAccountsNetwork = new HashMap<>();
        }
        this.userAccountsNetwork.put(accountId, ua);
    }
    
      
       public void addQueriesToNetwork(QueryResolutionOrg query) {
        int queryID;
        this.queriesNetwork = getQueriesNetwork();
        try {
             queryID = this.queriesNetwork.size() + 1;

        } catch (java.lang.NullPointerException e) {
            queryID = 1;
            this.queriesNetwork = new HashMap<>();
        }
        query.setQueryId(queryID);
        this.queriesNetwork.put(queryID, query);
    }
    

    @Override
    public String toString() {
        return networkName;
    }

}
