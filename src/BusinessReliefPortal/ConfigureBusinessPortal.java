/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessReliefPortal;

import BusinessReliefPortal.Borrower.Borrower;
import BusinessReliefPortal.Business.Business;
import BusinessReliefPortal.Employee.Employee;
import BusinessReliefPortal.Employee.EmployeeDirectory;
import BusinessReliefPortal.Enterprise.BusinessEnterprise;
import BusinessReliefPortal.Enterprise.CustomerSupportEnterprise;
import BusinessReliefPortal.Enterprise.Enterprise;
import BusinessReliefPortal.Enterprise.FundManagementEnterprise;
import BusinessReliefPortal.Enterprise.ProposalManagementEnterprise;
import BusinessReliefPortal.Enterprise.UserAndVerificationEnterprise;
import BusinessReliefPortal.Lender.Lender;
import BusinessReliefPortal.Network.Network;
import BusinessReliefPortal.Organization.AuditingOrg;
import BusinessReliefPortal.Organization.LicensePermissionOrg;
import BusinessReliefPortal.Organization.Organization;
import BusinessReliefPortal.Organization.OrganizationDirectory;
import BusinessReliefPortal.Organization.PrivateBusinessOrg;
import BusinessReliefPortal.Organization.ProposalOrg;
import BusinessReliefPortal.Organization.PublicBusinessPortfolioOrg;
import BusinessReliefPortal.Organization.QueryResolutionOrg;
import BusinessReliefPortal.Organization.TreasuryOrg;
import BusinessReliefPortal.Organization.UserIdentifyOrg;
import BusinessReliefPortal.UserAccount.UserAccount;

/**
 *
 * @author ritvikparamkusham
 */
public class ConfigureBusinessPortal {

    public static BusinessReliefSystem configure() {
        BusinessReliefSystem system = BusinessReliefSystem.getInstance();

        Network networkBoston = system.addNetwork();
        networkBoston.setNetworkName("Boston");
        
//        ArrayList<Network> networkList = system.getNetworkList();
                
        //Creating Enterprises in Boston
        CustomerSupportEnterprise customerSuppEnt = (CustomerSupportEnterprise) networkBoston.getEntDirObj().createAndAddEnterprise("Customer Support Enterprise", Enterprise.EnterpriseType.CUSTOMERSUPPORTENTERPRISE, "Boston Customer Support Enterprise");

        BusinessEnterprise businessEnt = (BusinessEnterprise) networkBoston.getEntDirObj().createAndAddEnterprise("Business Enterprise", Enterprise.EnterpriseType.BUSINESSENTERPRISE, "Boston Business Enterprise");
        
        FundManagementEnterprise fundMngEnt = (FundManagementEnterprise) networkBoston.getEntDirObj().createAndAddEnterprise("Fund Management Enterprise", Enterprise.EnterpriseType.FUNDMANAGEMENTENTERPRISE, "Boston Fund Management Enterprise");
       
        ProposalManagementEnterprise proposalMngEnt = (ProposalManagementEnterprise) networkBoston.getEntDirObj().createAndAddEnterprise("Proposal Management Enterprise", Enterprise.EnterpriseType.PROPOSALMANAGEMENTENTERPRISE, "Boston Proposal Management Enterprise");

        UserAndVerificationEnterprise userVeriEnt = (UserAndVerificationEnterprise) networkBoston.getEntDirObj().createAndAddEnterprise("User and Verification Enterprise", Enterprise.EnterpriseType.USERANDVERIFICATIONENTERPRISE, "Boston Proposal Management Enterprise");

        //Creating Organizations in Enterprises
        OrganizationDirectory customerSuppOrgDir = customerSuppEnt.getOrganizationDirectory();
        QueryResolutionOrg queryResOrg = (QueryResolutionOrg) customerSuppOrgDir.createOrganization(Organization.Type.QUERYRESOLUTIONORG);
        
        OrganizationDirectory businessOrgDir = businessEnt.getOrganizationDirectory();
        PublicBusinessPortfolioOrg publicBusOrg = (PublicBusinessPortfolioOrg) businessOrgDir.createOrganization(Organization.Type.PUBLICBUSINESSPORTFOLIOORG);
        PrivateBusinessOrg privateBusOrg = (PrivateBusinessOrg) businessOrgDir.createOrganization(Organization.Type.PRIVATEBUSINESSORG);
        
        
        OrganizationDirectory fundMngOrgDir = fundMngEnt.getOrganizationDirectory();
        TreasuryOrg treasuryOrg = (TreasuryOrg) fundMngOrgDir.createOrganization(Organization.Type.TREASURYORG);
       // LenderFunderOrg lenderFundOrg = (LenderFunderOrg) fundMngOrgDir.createOrganization(Organization.Type.LENDERFUNDERORG);

        OrganizationDirectory proposalMngOrgDir = proposalMngEnt.getOrganizationDirectory();
        ProposalOrg proposalOrg = (ProposalOrg) proposalMngOrgDir.createOrganization(Organization.Type.PROPOSALORG);
       // BorrowerRequestProcessingOrg borrrowerOrg = (BorrowerRequestProcessingOrg) proposalMngOrgDir.createOrganization(Organization.Type.BORROWERREQUESTPROCESSINGORG);
        AuditingOrg auditingOrg = (AuditingOrg) proposalMngOrgDir.createOrganization(Organization.Type.AUDITINGORG);

        OrganizationDirectory userVeriOrgDir = userVeriEnt.getOrganizationDirectory();
        UserIdentifyOrg userOrg = (UserIdentifyOrg) userVeriOrgDir.createOrganization(Organization.Type.USERIDENTIFYORG);
        LicensePermissionOrg licenseOrg = (LicensePermissionOrg) userVeriOrgDir.createOrganization(Organization.Type.LICENSEPERMISSIONORG);
        
        
        treasuryOrg.setName("Treasury Organization");
       
        //setEmployees(String name,String email,String status,Organization.Type orgType, UserAccount userAccount)
        //Creating employees at enterprise level and Assigning them to Organizations
        //Manages FUNDS - ADD and VIEW Funds 
        UserAccount treasurerUA = new UserAccount("Treasurer", UserAccount.RoleType.TREASURER);
        //key 1
        fundMngEnt.setEmployees("Treasurer", "treasurer@gmail.com", "Active", Organization.Type.TREASURYORG, treasurerUA);
        //2
        UserAccount fundManagerUA = new UserAccount("FundManager", UserAccount.RoleType.FUNDMANAGER);
        fundMngEnt.setEmployees("FUND MANAGER", "fundmanager@gmail.com", "Active", Organization.Type.TREASURYORG, fundManagerUA);

        //1
        UserAccount registerAdminUA = new UserAccount("RegisterAdmin", UserAccount.RoleType.REGISTERADMIN);
        userVeriEnt.setEmployees("Register Admin", "registeradmin@gmail.com", "Active", Organization.Type.USERIDENTIFYORG, registerAdminUA);

        //1
        UserAccount proposalAdminUA = new UserAccount("ProposalAdmin", UserAccount.RoleType.PROPOSALADMIN);
        proposalMngEnt.setEmployees("Proposal Admin", "proposaladmin@gmail.com", "Active", Organization.Type.PROPOSALORG, proposalAdminUA);
        //2
        UserAccount validatorUA = new UserAccount("Validator", UserAccount.RoleType.VALIDATOR);
        proposalMngEnt.setEmployees("Validator", "validator@gmail.com", "Active", Organization.Type.AUDITINGORG, validatorUA);

        //1
        UserAccount publicBusinessManagerUA = new UserAccount("PublicBusinessManager", UserAccount.RoleType.PUBLICBUSINESSADMIN);
        businessEnt.setEmployees("Public Business Manager", "publicBusinessManager@gmail.com", "Active", Organization.Type.PUBLICBUSINESSPORTFOLIOORG, publicBusinessManagerUA);
        //2
        UserAccount privateBusinessManagerUA = new UserAccount("PrivateBusinessManager", UserAccount.RoleType.PRIVATEBUSINESSADMIN);
        businessEnt.setEmployees("Private Business Manager", "privateBusinessManager@gmail.com", "Active", Organization.Type.PRIVATEBUSINESSORG, privateBusinessManagerUA);
        
         //1
        UserAccount queryManager = new UserAccount("QueryManager", UserAccount.RoleType.QUERYMANAGER);
        customerSuppEnt.setEmployees("Query Manager", "queryManager@gmail.com", "Active", Organization.Type.QUERYRESOLUTIONORG, queryManager);
      
        
         UserAccount systemAdminUA = new UserAccount("SystemAdmin", UserAccount.RoleType.SYSTEADMIN);
        
        
        //saving all user accounts to network - Donot change this order
        networkBoston.addUserAccountToNetwork(treasurerUA);//1
        networkBoston.addUserAccountToNetwork(fundManagerUA);//2
        networkBoston.addUserAccountToNetwork(registerAdminUA);//3
        networkBoston.addUserAccountToNetwork(proposalAdminUA);//4
        networkBoston.addUserAccountToNetwork(validatorUA);//5
        networkBoston.addUserAccountToNetwork(publicBusinessManagerUA);//6
        networkBoston.addUserAccountToNetwork(privateBusinessManagerUA);//7
        networkBoston.addUserAccountToNetwork(queryManager);//8
        networkBoston.addUserAccountToNetwork(systemAdminUA);//8
        
        
        
        
        //creating some essential and non essential businessess for government
        Business essential_food = businessEnt.addBusiness(Business.getCount());
        Business essential_healthcare = businessEnt.addBusiness(Business.getCount());
        Business essential_electricity = businessEnt.addBusiness(Business.getCount());
        
        Business nonessential_fashion = businessEnt.addBusiness(Business.getCount());
        Business nonessential_furniture = businessEnt.addBusiness(Business.getCount());
        Business nonessential_electronics = businessEnt.addBusiness(Business.getCount());
        
        essential_food.setBusinessName("Food");
        essential_food.setBusinessType("Essential");
        essential_food.setOrgType(Organization.Type.PUBLICBUSINESSPORTFOLIOORG);
        essential_food.setBusinessDescription("Government Food Business");
        essential_food.setBusinessLocation("Boston");
        
        essential_healthcare.setBusinessName("Healthcare");
        essential_healthcare.setBusinessType("Essential");
        essential_healthcare.setOrgType(Organization.Type.PUBLICBUSINESSPORTFOLIOORG);
        essential_healthcare.setBusinessDescription("Government Healthcare Business");
        essential_healthcare.setBusinessLocation("Boston");
       
        essential_electricity.setBusinessName("Electricity");
        essential_electricity.setBusinessType("Essential");
        essential_electricity.setOrgType(Organization.Type.PUBLICBUSINESSPORTFOLIOORG);
        essential_electricity.setBusinessDescription("Government Electricity Business");
        essential_electricity.setBusinessLocation("Boston");
        
        nonessential_fashion.setBusinessName("Fashion");
        nonessential_fashion.setBusinessType("NonEssential");
        nonessential_fashion.setOrgType(Organization.Type.PUBLICBUSINESSPORTFOLIOORG);
        nonessential_fashion.setBusinessDescription("Government Fashion Business");
        nonessential_fashion.setBusinessLocation("Boston");
        
        nonessential_furniture.setBusinessName("Furniture");
        nonessential_furniture.setBusinessType("NonEssential");
        nonessential_furniture.setOrgType(Organization.Type.PUBLICBUSINESSPORTFOLIOORG);
        nonessential_furniture.setBusinessDescription("Government Furniture Business");
        nonessential_furniture.setBusinessLocation("Boston");
        
        nonessential_electronics.setBusinessName("Electronics");
        nonessential_electronics.setBusinessType("NonEssential");
        nonessential_electronics.setOrgType(Organization.Type.PUBLICBUSINESSPORTFOLIOORG);
        nonessential_electronics.setBusinessDescription("Government Electronics Business");
        nonessential_electronics.setBusinessLocation("Boston");
        
        
        //creating some essential and non essential businessess for Lender1
        Business essential_healthcare1 = businessEnt.addBusiness(Business.getCount());
        Business essential_electricity1 = businessEnt.addBusiness(Business.getCount());
        
        Business nonessential_fashion1 = businessEnt.addBusiness(Business.getCount());
        Business nonessential_furniture1 = businessEnt.addBusiness(Business.getCount());
        Business nonessential_electronics1 = businessEnt.addBusiness(Business.getCount());
        
//        
//        essential_healthcare1.setBusinessName("Healthcare");
//        essential_healthcare1.setBusinessType("Essential");
//        essential_healthcare1.setOrgType(Organization.Type.PRIVATEBUSINESSORG);
//        //essential_food1.setLender(lender);
//        essential_healthcare1.setBusinessDescription("Lender1 Healthcare Business");
//        essential_healthcare1.setBusinessLocation("Boston");
//       
//        essential_electricity1.setBusinessName("Electricity");
//        essential_electricity1.setBusinessType("Essential");
//        essential_electricity1.setOrgType(Organization.Type.PRIVATEBUSINESSORG);
//        //essential_food1.setLender(lender);
//        essential_electricity1.setBusinessDescription("Lender1 Electricity Business");
//        essential_electricity1.setBusinessLocation("Boston");
//        
//        nonessential_fashion1.setBusinessName("Fashion");
//        nonessential_fashion1.setBusinessType("NonEssential");
//        nonessential_fashion1.setOrgType(Organization.Type.PRIVATEBUSINESSORG);
//        //essential_food1.setLender(lender);
//        nonessential_fashion1.setBusinessDescription("Lender1 Fashion Business");
//        nonessential_fashion1.setBusinessLocation("Boston");
//        
//        nonessential_furniture1.setBusinessName("Furniture");
//        nonessential_furniture1.setBusinessType("NonEssential");
//        nonessential_furniture1.setOrgType(Organization.Type.PRIVATEBUSINESSORG);
//        //essential_food1.setLender(lender);
//        nonessential_furniture1.setBusinessDescription("Lender1 Furniture Business");
//        nonessential_furniture1.setBusinessLocation("Boston");
//        
//        nonessential_electronics1.setBusinessName("Electronics");
//        nonessential_electronics1.setBusinessType("NonEssential");
//        nonessential_electronics1.setOrgType(Organization.Type.PRIVATEBUSINESSORG);
//        //essential_food1.setLender(lender);
//        nonessential_electronics1.setBusinessDescription("Lender1 Electronics Business");
//        nonessential_electronics1.setBusinessLocation("Boston");
//        
        //<<<<<<<<<<<<<<<<<<< Adding Lenders >>>>>>>>>>>>>>>>>>>
        
        //creating the first lender
        //userVeriEnt.addPerson("lender1", "ankit.28.goyal@gmail.com", "abcd", "Lender", false);
        //creating a new lender object
        Lender lender1 = userVeriEnt.addLender("Lender1","Ankit", "ankit.28.goyal@gmail.com", "abcd", UserAccount.RoleType.LENDER, "Initial");
         //creating a useraccount based on Lender ID
        UserAccount newUserAccount1 = userVeriEnt.createPersonCredentials("Lender1", UserAccount.RoleType.LENDER);    
        // assigning the useraccount credentials to lender
        lender1.setUserAccount(newUserAccount1);
        lender1.setActiveStatus("Approved");
        lender1.setRevenue(60000);
        lender1.setFundingAmount(20000);
        lender1.setTaxAmountPaid(7000);
        lender1.setInterestRate(7);
        lender1.setInterestStartYears(2);
        lender1.setSupportedBusinessId(essential_food.getBusinessId());
       //Adding business for Lender1
        Business bottleLender1 = businessEnt.addBusiness(Business.getCount());
        bottleLender1.setBusinessName("Bottle");
        bottleLender1.setOrgType(Organization.Type.PRIVATEBUSINESSORG);
        bottleLender1.setLenderID(lender1.getLenderID());
        bottleLender1.setBusinessDescription("Lender1 Bottle Business");
        bottleLender1.setBusinessLocation("Boston");
        lender1.setLenderBusiness(bottleLender1);
  
        //creating the second lender
        // userVeriEnt.addPerson("lender2", "ankit.28.goyal@gmail.com", "abcd", "Lender", false);x
        //creating a new lender object
        Lender lender2 = userVeriEnt.addLender("Lender2","AnkitGoyal", "ankit.28.goyal@gmail.com", "abcd", UserAccount.RoleType.LENDER, "Initial");
         //creating a useraccount based on Lender ID
        UserAccount newUserAccount2 = userVeriEnt.createPersonCredentials("Lender2", UserAccount.RoleType.LENDER);
        // assigning the useraccount credentials to lender
        lender2.setUserAccount(newUserAccount2);
        
        lender2.setActiveStatus("Approved");
        lender2.setRevenue(30000);
        lender2.setFundingAmount(10000);
        lender2.setTaxAmountPaid(5000);
        lender2.setInterestRate(7);
        lender2.setInterestStartYears(2);
        lender2.setSupportedBusinessId(essential_healthcare.getBusinessId());
//       Adding business for lender2
        Business watcheslender2 = businessEnt.addBusiness(Business.getCount());
        watcheslender2.setBusinessName("watches");
       // essFoodlender2.setBusinessType("Essential");
        watcheslender2.setOrgType(Organization.Type.PRIVATEBUSINESSORG);
        watcheslender2.setLenderID(lender2.getLenderID());
        watcheslender2.setBusinessDescription("lender2 watches Business");
        watcheslender2.setBusinessLocation("Boston");
        lender2.setLenderBusiness(watcheslender2);
        
        //<<<<<<<<<<<<<<<<<<< Adding Borrowers >>>>>>>>>>>>>>>>>>>
        
        //creating the first borrower 
        Borrower newBorrower1 = userVeriEnt.addBorrower("Borrower1","Ritvik", "ritvik.param@gmail.com", "abcd", UserAccount.RoleType.BORROWER, "Approved");
       
        //creating a useraccount based on Borrower ID
        UserAccount newUserAccount3 = userVeriEnt.createPersonCredentials("Borrower1", UserAccount.RoleType.BORROWER);
        // assigning the useraccount credentials to Borrower
        newBorrower1.setBorrowerAccount(newUserAccount3);
        
        
        //creating the second borrower
      //  userVeriEnt.addPerson("borrower2", "ritvik.param@gmail.com", "abcd", "Borrower", false);
        //creating a new lender object
        Borrower newBorrower2 = userVeriEnt.addBorrower("Borrower2","RitvikParamkusham", "ritvik.param@gmail.com", "abcd", UserAccount.RoleType.BORROWER, "Approved");       
        //creating a useraccount based on person credentials
        UserAccount newUserAccount4 = userVeriEnt.createPersonCredentials("Borrower2", UserAccount.RoleType.BORROWER);
        // assigning the useraccount credentials to lender
        newBorrower2.setBorrowerAccount(newUserAccount4);
   

        return system;
        
        

    }
    
}
