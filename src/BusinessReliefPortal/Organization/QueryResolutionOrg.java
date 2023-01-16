/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessReliefPortal.Organization;

import BusinessReliefPortal.Employee.Employee;

/**
 *
 * @author ankitgoyal
 */
public class QueryResolutionOrg extends Organization{
    
    private int queryId;
    private String requestor;
    private String message;
    private String reply;

    public QueryResolutionOrg( String requestor, String message) {
        this.requestor = requestor;
        this.message = message;
    }

    public QueryResolutionOrg() {
    }

  
    public QueryResolutionOrg(String requestor, String message, String name) {
       
        super(Organization.Type.QUERYRESOLUTIONORG.getValue());
        this.requestor = requestor;
        this.message = message;
    }

    public int getQueryId() {
        return queryId;
    }

    public void setQueryId(int queryId) {
        this.queryId = queryId;
    }

    public String getRequestor() {
        return requestor;
    }

    public void setRequestor(String requestor) {
        this.requestor = requestor;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
