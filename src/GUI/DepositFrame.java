package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Bank;
import classes.BankAccount;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class DepositFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox comboBox;


	/**
	 * this frame is to deposit money from the account
	 * @param account
	 * @param bank
	 */
	public DepositFrame(BankAccount account,Bank bank) {
		this.setVisible(true);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"cleared", "uncleared"}));
		comboBox.setBounds(219, 51, 75, 21);
		contentPane.add(comboBox);
		
		JLabel lblDeposit = new JLabel("Deposit");
		lblDeposit.setBounds(90, 10, 93, 15);
		contentPane.add(lblDeposit);
		
		JLabel lblChooseType = new JLabel("Choose Type");
		lblChooseType.setBounds(90, 51, 101, 15);
		contentPane.add(lblChooseType);
		
		JLabel lblAccountnum = new JLabel("Account Number");
		lblAccountnum.setBounds(83, 92, 108, 15);
		contentPane.add(lblAccountnum);
		
		textField = new JTextField();
		textField.setBounds(219, 89, 66, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblMonney = new JLabel("monney");
		lblMonney.setBounds(108, 133, 54, 15);
		contentPane.add(lblMonney);
		
		textField_1 = new JTextField();
		textField_1.setBounds(219, 130, 66, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnDeposit = new JButton("deposit");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int acc_num  = Integer.parseInt(textField.getText());
				if(!bank.isExist(acc_num)){
					JOptionPane.showMessageDialog(null,  "There is no such account", "alert",JOptionPane.ERROR_MESSAGE);
					return;
				}
				BankAccount account=bank.getAccountByNum(Integer.parseInt(textField.getText()));
				if(account.isSuspended()){
					JOptionPane.showMessageDialog(null,  "You account has been suspended", "alert",JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(comboBox.getSelectedItem().toString().equals("uncleared")){
					 
					account.setUnclear_amount(Integer.parseInt(textField_1.getText()));
					JOptionPane.showMessageDialog(null, "Successfully deposit!"+"Your uncleared balance is"
					+ " "+ account.getUnclear_amount()+"Please wait for bank to clear the amount" );
				}
				else{
					
					account.deposit(Integer.parseInt(textField_1.getText()));
					JOptionPane.showMessageDialog(null, "Successfully deposit!"+"Your balance is"
					+ " "+ account.getBalance() );
				}
				textField.setText("");
				textField_1.setText("");
			}
		});
		btnDeposit.setBounds(98, 194, 93, 23);
		contentPane.add(btnDeposit);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setBounds(219, 194, 93, 23);
		contentPane.add(btnBack);
		
		JLabel lblYourAccountnumber = new JLabel("Your account Number is ");
		lblYourAccountnumber.setBounds(193, 10, 163, 15);
		contentPane.add(lblYourAccountnumber);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(341, 10, 54, 15);
		lblNewLabel.setText(account.getAccNo()+"");
		contentPane.add(lblNewLabel);
	}
}
