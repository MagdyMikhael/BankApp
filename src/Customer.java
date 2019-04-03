
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author engmagdymoheb
 */
public class Customer implements Serializable {

    /**
     * @return the ssn
     */
    public String getSsn() {
        return ssn;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    

    private final String firstName;
    private final String lastName;
    private final String ssn;
    private final Account account;

    Customer(String firstName, String lastName, String ssn, Account account) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.ssn=ssn;
        this.account=account;
    }
    
    public String toString(){
        return "\n Customer Informations \n"+
                "First Name : "+getFirstName()+"\n"+
                "Last Name : "+getLastName()+"\n"+
                "SSN : "+getSsn()+"\n"+
                getAccount();
    }
    
    public String basicInfo(){
        return 
                " First Name : "+getFirstName()+
                " Last Name : "+getLastName()+
                " SSN : "+getSsn()+
                " Account Number : "+account.getAccountNumber()+"\n";
                
    }
    /**
     * @return the account
     */
    public Account getAccount() {
        return account;
    }
}
