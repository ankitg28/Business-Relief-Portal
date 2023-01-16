/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessReliefPortal.Organization;

import BusinessReliefPortal.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author ritvikparamkusham
 */
public class OrganizationDirectory {

    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public Organization createOrganization(Type type) {
        Organization org = null;
        if (type.getValue().equals(Type.AUDITINGORG.getValue())) {
            org = new AuditingOrg();
            organizationList.add(org);
        }
//        if (type.getValue().equals(Type.BORROWERREQUESTPROCESSINGORG.getValue())) {
//            org = new BorrowerRequestProcessingOrg();
//            organizationList.add(org);
//        }
//        if (type.getValue().equals(Type.LENDERFUNDERORG.getValue())) {
//            org = new LenderFunderOrg();
//            organizationList.add(org);
//        }
        if (type.getValue().equals(Type.LICENSEPERMISSIONORG.getValue())) {
            org = new LicensePermissionOrg();
            organizationList.add(org);
        }
        if (type.getValue().equals(Type.PRIVATEBUSINESSORG.getValue())) {
            org = new PrivateBusinessOrg();
            organizationList.add(org);
        }
        if (type.getValue().equals(Type.PROPOSALORG.getValue())) {
            org = new ProposalOrg();
            organizationList.add(org);
        }
        if (type.getValue().equals(Type.PUBLICBUSINESSPORTFOLIOORG.getValue())) {
            org = new PublicBusinessPortfolioOrg();
            organizationList.add(org);
        }
        if (type.getValue().equals(Type.QUERYRESOLUTIONORG.getValue())) {
            org = new QueryResolutionOrg();
            organizationList.add(org);
        }
        if (type.getValue().equals(Type.TREASURYORG.getValue())) {
            org = new TreasuryOrg();
            organizationList.add(org);
        }
        if (type.getValue().equals(Type.USERIDENTIFYORG.getValue())) {
            org = new UserIdentifyOrg();
            organizationList.add(org);
        }

        org.setOrgType(type);
        return org;
    }

}
