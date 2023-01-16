/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessReliefPortal.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author ankitgoyal
 */
public class EnterpriseDirectory {
    
    private ArrayList<Enterprise> enterpriseList;

    public EnterpriseDirectory() {
        enterpriseList = new ArrayList<>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }
    
    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType type,String address){
        
        Enterprise enterprise = null;
        
        if(type == Enterprise.EnterpriseType.CUSTOMERSUPPORTENTERPRISE)
        {
            enterprise = new CustomerSupportEnterprise(name);
            enterpriseList.add(enterprise);
        }
        
        else if(type == Enterprise.EnterpriseType.BUSINESSENTERPRISE)
        {
            enterprise = new BusinessEnterprise(name);
            enterpriseList.add(enterprise);
        }
        
        else if(type == Enterprise.EnterpriseType.FUNDMANAGEMENTENTERPRISE)
        {
            enterprise = new FundManagementEnterprise(name);
            enterpriseList.add(enterprise);
            
        }
        else if(type == Enterprise.EnterpriseType.PROPOSALMANAGEMENTENTERPRISE)
        {
            enterprise = new ProposalManagementEnterprise(name);
            enterpriseList.add(enterprise);
            
        }
        
        else if(type == Enterprise.EnterpriseType.USERANDVERIFICATIONENTERPRISE)
        {
            enterprise = new UserAndVerificationEnterprise(name);
            enterpriseList.add(enterprise);
            
        }
        
        return enterprise;
    }
    
    
    
}
