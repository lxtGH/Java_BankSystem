package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.BankAccount;
import classes.CurrentAccount;
import classes.JuniorAccount;
import classes.SaverAccount;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WithdrawFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	

	/**
	 * this frame is for withdraw the money
	 * @param account
	 */
	public WithdrawFrame(BankAccount account) {
		this.setVisible(true);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(169, 81, 123, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Type");
		lblNewLabel.setBounds(106, 25, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("account");
		if(account instanceof CurrentAccount){
			lblNewLabel_2.setText("Current Account");
		}else if(account instanceof JuniorAccount){
			lblNewLabel_2.setText("JuniorAccount");
		}else{
			lblNewLabel_2.setText("SaverAccount");
		}
		
		
		lblNewLabel_2.setBounds(172, 25, 120, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblWithdrawAmount = new JLabel("Withdraw Amount");
		lblWithdrawAmount.setBounds(57, 84, 111, 15);
		contentPane.add(lblWithdrawAmount);
		
		JButton btnNewButton = new JButton("Withdraw");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double amount= Double.parseDouble(textField.getText());
				if(account instanceof JuniorAccount ){
					JuniorAccount temp = (JuniorAccount)account;
					if(!temp.ifWithdraw(amount)){
						JOptionPane.showMessageDialog(null, "You have not enough amount to witdraw");
						return;
					}
					temp.withdraw(amount);
				}else if(account instanceof SaverAccount){
					SaverAccount temp = (SaverAccount)account;
					if(!temp.ifWithdraw(amount)){
						JOptionPane.showMessageDialog(null, "You have not enough amount to witdraw");
						return;
					}
					JOptionPane.showMessageDialog(null, "You need wait for 7 days to get the amount!");//give the notice
					temp.withdraw(amount);
				}else{
					CurrentAccount temp = (CurrentAccount) account;
					if(!temp.ifWithdraw(amount)){
						JOptionPane.showMessageDialog(null,"You have run out of overdraftLimits!");
						return;
					}
					temp.withdraw(amount);
				}
				JOptionPane.showMessageDialog(null, "Success! You balance is "+account.getBalance());
				textField.setText(""); // roll back
			}
		});
		btnNewButton.setBounds(169, 140, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(172, 228, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnBalance = new JButton("balance");
		btnBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double balance = account.getBalance();
				JOptionPane.showMessageDialog(null, "Balance:"+balance);
				return;
			}
		});
		btnBalance.setBounds(169, 185, 93, 23);
		contentPane.add(btnBalance);
	}

}
