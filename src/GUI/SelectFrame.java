package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Bank;
import classes.BankAccount;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;



	/**
	 * Create the frame.
	 */
	public SelectFrame(Bank bank) {
		this.setVisible(true);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(213, 176, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Enter");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int acc_num = Integer.parseInt(textField.getText());
				int pin = Integer.parseInt((passwordField.getText().toString()));
				if(!bank.isExist(acc_num)){
					JOptionPane.showMessageDialog(null, "No such account");
					return;
				}
				if(!bank.isMatch(acc_num, pin)){
					JOptionPane.showMessageDialog(null, "Wrong PIN code!!");
					return;
				}
				BankAccount account =bank.getAccountByNum(acc_num);
				if(account.isSuspended()){
					JOptionPane.showMessageDialog(null, "Your account has been suspended!");
					return;
				}
				new WithdrawFrame(account);
			}
		});
		btnNewButton_1.setBounds(94, 176, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Account number");
		lblNewLabel.setBounds(53, 66, 113, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PIN code");
		lblNewLabel_1.setBounds(53, 106, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(153, 63, 85, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(153, 100, 85, 21);
		contentPane.add(passwordField);
		
		JLabel lblPleaseInputAccount = new JLabel("Please input account number and PIN code for withdraw");
		lblPleaseInputAccount.setBounds(52, 21, 352, 15);
		contentPane.add(lblPleaseInputAccount);
	}
}
