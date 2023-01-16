/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessReliefPortal.WorkRequest;

import BusinessReliefPortal.Organization.Organization;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ritvikparamkusham
 */

//repository of all the workrequests 
// Based on sender and receiver we the tables need to be populated 
public class WorkQueue { 
   private Map<Integer,WorkRequest>  workRequestMap = new HashMap<>();

    public WorkQueue() {
    }
       
//    public  WorkRequest addWorkRequests(Organization sender,Organization receiver, String status,String message){
//        int size = this.workRequestMap.size() + 1;
//        WorkRequest workReqAdd = new WorkRequest(sender,receiver,status,message);
//        workReqAdd.setWorkRequestID(size);
//        this.workRequestMap.put(size,workReqAdd);
//        
//        return workReqAdd;
//    }
    
    
}

