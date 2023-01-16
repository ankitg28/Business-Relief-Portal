/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessReliefPortal.WorkRequest;

import BusinessReliefPortal.Organization.Organization;
import BusinessReliefPortal.UserAccount.UserAccount;

/**
 *
 * @author ritvikparamkusham
 */
public class WorkRequest {

    private int workRequestID;
    private String workRequestName;
    
    private String message;
    
    private String senderID;
    private String receiverID;
    
    private UserAccount.RoleType sender;
    private UserAccount.RoleType receiver;   
    
    private Organization.Type senderOrg;
    private Organization.Type receiverOrg;
    
    private String status;

    public WorkRequest() {
    }

    public int getWorkRequestID() {
        return workRequestID;
    }

    public void setWorkRequestID(int workRequestID) {
        this.workRequestID = workRequestID;
    }

    public String getWorkRequestName() {
        return workRequestName;
    }

    public void setWorkRequestName(String workRequestName) {
        this.workRequestName = workRequestName;
    }

    public Organization.Type getSenderOrg() {
        return senderOrg;
    }

    public void setSenderOrg(Organization.Type senderOrg) {
        this.senderOrg = senderOrg;
    }

    public Organization.Type getReceiverOrg() {
        return receiverOrg;
    }

    public void setReceiverOrg(Organization.Type receiverOrg) {
        this.receiverOrg = receiverOrg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserAccount.RoleType getSender() {
        return sender;
    }

    public void setSender(UserAccount.RoleType sender) {
        this.sender = sender;
    }

    public UserAccount.RoleType getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount.RoleType receiver) {
        this.receiver = receiver;
    }

    public String getSenderID() {
        return senderID;
    }

    public void setSenderID(String senderID) {
        this.senderID = senderID;
    }

    public String getReceiverID() {
        return receiverID;
    }

    public void setReceiverID(String receiverID) {
        this.receiverID = receiverID;
    }

     public WorkRequest(int workReqId,String senderID,String receiverID, UserAccount.RoleType sender,UserAccount.RoleType receiver, Organization.Type senderOrg, Organization.Type receiverOrg, String status,String message) {
        this.workRequestID = workReqId;
        this.senderID = senderID;
        this.receiverID = receiverID;
        this.sender = sender;
        this.receiver = receiver;
        this.senderOrg = senderOrg;
        this.receiverOrg = receiverOrg;
        this.status = status;
        this.message = message;
        this.workRequestName ="";
    }
    
    public WorkRequest(int workReqId,UserAccount.RoleType sender,UserAccount.RoleType receiver, Organization.Type senderOrg, Organization.Type receiverOrg, String status,String message) {
        this.workRequestID = workReqId;
        this.sender = sender;
        this.receiver = receiver;
        this.senderOrg = senderOrg;
        this.receiverOrg = receiverOrg;
        this.status = status;
        this.message = message;
        this.workRequestName ="";
    }
    
    public WorkRequest changeWorkRequest(WorkRequest workReq,UserAccount.RoleType sender, UserAccount.RoleType receiver, Organization.Type senderOrg, Organization.Type receiverOrg, String status, String message){
        workReq.setSender(sender);
        workReq.setReceiver(receiver);
        workReq.setSenderOrg(senderOrg);
        workReq.setReceiverOrg(receiverOrg);
        workReq.setStatus(status);
        workReq.setMessage(message);
        
        return workReq;
    }
    
     public WorkRequest changeStatMessOfWorkRequest(WorkRequest workReq, String status,String message){
         
        workReq.setStatus(status);
        workReq.setMessage(message);
         return workReq;
     }
    
    
}
