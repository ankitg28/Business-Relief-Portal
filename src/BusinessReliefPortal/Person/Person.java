/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessReliefPortal.Person;

import BusinessReliefPortal.Organization.Organization;
import BusinessReliefPortal.Organization.QueryResolutionOrg;
import BusinessReliefPortal.UserAccount.UserAccount;
import BusinessReliefPortal.WorkRequest.WorkRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ankitgoyal
 */
public class Person {

    private int id;
    static int personcount = 0;
    private String name;
    private String email;
    private String profilePic;
    //private UserAccount.RoleType roleType;
    private String activeStatus;
    // private ArrayList<Integer> workId;
    private Map<Integer, WorkRequest> personWorkQueue;
    private Map<Integer, QueryResolutionOrg> personQueries;

    private UserAccount userAccount;

//    public Person() {
//        this.id = personcount;
//        personcount++;
//        this.activeStatus = false;
//    }
    public Person(String name, String email, String profilePic, String activeStatus) {
        this.name = name;
        this.email = email;
        this.profilePic = profilePic;
        // this.roleType = roleType;
        this.id = personcount;
        personcount++;
        this.activeStatus = activeStatus;
        this.personWorkQueue = new HashMap<>();
        this.personQueries = new HashMap<>();

    }

    public Person(String name, String email, String activeStatus) {
        this.name = name;
        this.email = email;
        // this.roleType = roleType;
        this.id = personcount;
        personcount++;
        this.activeStatus = activeStatus;
        this.personWorkQueue = new HashMap<>();

    }

//    public void setWorkId(ArrayList<Integer> workId) {
//        this.workId = workId;
//    }
//
//    public ArrayList<Integer> getWorkId() {
//        return workId;
//    }
    public Map<Integer, WorkRequest> getPersonWorkQueue() {
        return personWorkQueue;
    }

    public void setPersonWorkQueue(Map<Integer, WorkRequest> personWorkQueue) {
        this.personWorkQueue = personWorkQueue;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount UserAccount) {
        this.userAccount = UserAccount;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getPersoncount() {
        return personcount;
    }

    public static void setPersoncount(int personcount) {
        Person.personcount = personcount;
    }
//
//    public UserAccount.RoleType getRoleType() {
//        return roleType;
//    }
//
//    public void setRoleType(UserAccount.RoleType roleType) {
//        this.roleType = roleType;
//    }

    public void setPersonQueries(Map<Integer, QueryResolutionOrg> personQueries) {
        this.personQueries = personQueries;
    }

    public Map<Integer, QueryResolutionOrg> getPersonQueries() {
        return personQueries;
    }

    public void addWorkReqToPerson(WorkRequest wr) {
        int workReq;
        try {
            workReq = personWorkQueue.size();
            workReq = wr.getWorkRequestID();

        } catch (java.lang.NullPointerException e) {
            workReq = wr.getWorkRequestID();
            personWorkQueue = new HashMap<>();
        }

        personWorkQueue.put(workReq, wr);
    }

    public void addQueryToPerson(QueryResolutionOrg queryAdd) {
        int queryId;
        try {
            queryId = personQueries.size();
            queryId = queryAdd.getQueryId();

        } catch (java.lang.NullPointerException e) {

            personQueries = new HashMap<>();
        }
        
            queryId = queryAdd.getQueryId();

        personQueries.put(queryId, queryAdd);
    }

}
