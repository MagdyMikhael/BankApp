/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author engmagdymoheb
 */
public class Savings extends Account{
    
     
     public Savings(int accountId,double initialDeposit) {
        super(accountId);
        this.setBalance(initialDeposit);
        
    }
    
    

    @Override
    public AccountType getAccountType() {
        return AccountType.Savings;
    }
}
