/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessReliefPortal.Employee;

/**
 *
 * @author ankitgoyal
 */
    public abstract class Role {
    
    public enum RoleType{
        
        PUBLICBUSINESSPORTFOLIOADMIN("Public Business Portfolio Admin"),
        LENDERBUSINESSMANAGER("Lender Business Manager"),
        TREASURER("TREASURER"),
        LENDERFUNDMANAGER("Lender Fund Manager"),
        GOVERNMENTPROPOSALHEAD("Government Proposal Head"),
        BORROWERPROPOSALMANAGER("Borrower Proposal Manager"),
        THIRDPARTYPROPOSALMANAGER("Third Party Proposal Manager"),
        LENDER("Lender"),
        BORROWER("Borrower"),
        USERADMINAMANAGEMENT("User Admin Management"),
        LICENSINGADMIN("Licensing Admin"),
        QUERYRESOLUTIONADMIN("Query Resolution Admin");
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
//    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
//            UserAccount account, 
//            EmergencySystem system,Network network,Enterprise enterprise);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
    }
