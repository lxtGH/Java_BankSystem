package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Bank;
import classes.BankAccount;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EnterFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;


	/**
	 * Create the frame.
	 */
	public EnterFrame(Bank bank) {
		this.setVisible(true);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("AccountNum");
		lblNewLabel.setBounds(69, 88, 81, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PIN code");
		lblNewLabel_1.setBounds(69, 133, 66, 15);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(186, 85, 81, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(186, 130, 81, 21);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int accountNum = Integer.parseInt(textField.getText());
				int pin  = Integer.parseInt(passwordField.getText().toString());
				if(!bank.isExist(accountNum)){
					System.out.println("No exist this num");
					return;
				}
				if(!bank.isMatch(accountNum, pin)){
					System.out.println("account number and PIN not match");
					return;
				}
				BankAccount account = bank.getAccountByNum(accountNum);
				new MainFrame(account, bank);
				dispose();
			}
		});
		btnNewButton.setBounds(186, 183, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setBounds(186, 216, 93, 23);
		contentPane.add(btnBack);
		
		JLabel lblPleaseInputThe = new JLabel("Please Input the informantion");
		lblPleaseInputThe.setBounds(128, 23, 224, 35);
		contentPane.add(lblPleaseInputThe);
	}
}
