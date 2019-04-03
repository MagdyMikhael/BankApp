
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author engmagdymoheb
 */
public class WithdrawMenu extends javax.swing.JDialog {

    private Customer customer;
    private Bank bank;
    /**
     * Creates new form DepositMenu
     */
    public WithdrawMenu(java.awt.Frame parent, boolean modal,Bank bank,Customer customer) {
        super(parent, modal);
        initComponents();
        this.customer=customer;
        setLocationRelativeTo(parent);
        this.bank=bank;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        depositLabel = new javax.swing.JLabel();
        amountField = new javax.swing.JTextField();
        withdrawButton = new javax.swing.JButton();
        canelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Deposit Menu");
        getContentPane().setLayout(new java.awt.GridLayout(2, 2, 5, 5));

        depositLabel.setText("Withdraw Amount : ");
        getContentPane().add(depositLabel);

        amountField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountFieldActionPerformed(evt);
            }
        });
        getContentPane().add(amountField);

        withdrawButton.setText("Withdraw");
        withdrawButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawButtonActionPerformed(evt);
            }
        });
        getContentPane().add(withdrawButton);

        canelButton.setText("Cancel");
        canelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(canelButton);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void amountFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amountFieldActionPerformed

    private void canelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canelButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_canelButtonActionPerformed

    private void withdrawButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawButtonActionPerformed
        // TODO add your handling code here:
        StringBuilder warnings=new StringBuilder();
        //verify the deposit field isn't empty
        if(amountField.getText().isEmpty()){
            warnings.append("withdraw amount is required .\n");
        }else{
            //verify the deposit is positive number
            double amount = 0;
            try {
                amount = Bank.round(Double.parseDouble(amountField.getText()), 2);
                int result = JOptionPane.showConfirmDialog(this, "Withdraw $" + String.format("%.2f", amount) + " from the account?\nTransaction Fee: $" + String.format("%.2f", bank.getTransactionFee(customer.getAccount().getAccountType())));
                if(result == JOptionPane.OK_OPTION){
                    try {
                        //make the withdraw
                        bank.withdraw(customer.getAccount().getAccountNumber(), amount);
                        this.dispose();
                     
                    } catch (InsufficientFundsException ex) {
                        warnings.append("Insufficient fund to complete the transaction \n");
                    }
                    
                }
                
            } catch (NumberFormatException e) {
                warnings.append("withdraw must be a number\n ");
            }
            
        }
        if(warnings.length()>0){
            JOptionPane.showMessageDialog(this,warnings,"Input warning",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_withdrawButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amountField;
    private javax.swing.JButton canelButton;
    private javax.swing.JLabel depositLabel;
    private javax.swing.JButton withdrawButton;
    // End of variables declaration//GEN-END:variables
}