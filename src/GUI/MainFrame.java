package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Bank;
import classes.BankAccount;
import classes.CurrentAccount;
import classes.JuniorAccount;
import classes.SaverAccount;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1;

	/**
	 * this frame is main function that bank provides for user
	 * @param account
	 * @param bank
	 */
	public MainFrame(BankAccount account,Bank bank) {
		this.setVisible(true);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Deposit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DepositFrame(account, bank);
			}
		});
		btnNewButton.setBounds(25, 51, 132, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Withdraw");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelectFrame(bank);
			}
		});
		btnNewButton_1.setBounds(25, 84, 132, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Suspend");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CheckFrame(account);
			}
		});
		btnNewButton_2.setBounds(25, 117, 132, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnClear = new JButton("ClearFunds");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bank.setUnclearedMoney();
			}
		});
		btnClear.setBounds(238, 192, 118, 23);
		contentPane.add(btnClear);
		
		JButton btnCloseaccount = new JButton("CloseAccount");
		btnCloseaccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CloseAccountFrame(account);
			}
		});
		btnCloseaccount.setBounds(25, 159, 132, 23);
		contentPane.add(btnCloseaccount);
		
		JLabel lblNewLabel = new JLabel("For Bank:");
		lblNewLabel.setBounds(238, 150, 93, 15);
		contentPane.add(lblNewLabel);
		
		JButton btnUnsuspend = new JButton("UnSuspend");
		btnUnsuspend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CheckFrame(account);
			}
		});
		btnUnsuspend.setBounds(25, 192, 132, 23);
		contentPane.add(btnUnsuspend);
		
		JLabel lblForConsumer = new JLabel("For Consumer");
		lblForConsumer.setBounds(25, 24, 110, 15);
		contentPane.add(lblForConsumer);
		
		JLabel lblBanksystem = new JLabel("Bank System");
		lblBanksystem.setBounds(145, 10, 132, 15);
		contentPane.add(lblBanksystem);
		
		lblNewLabel_1 = new JLabel("type");
		lblNewLabel_1.setBounds(238, 55, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblBalance = new JLabel("balance");
		lblBalance.setBounds(238, 88, 54, 15);
		contentPane.add(lblBalance);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(302, 59, 93, 15);
		if(account instanceof CurrentAccount){
			lblNewLabel_2.setText("Current Account");
		}else if(account instanceof JuniorAccount){
			lblNewLabel_2.setText("JuniorAccount");
		}else{
			lblNewLabel_2.setText("SaverAccount");
		}
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("bankAccount");
		lblNewLabel_3.setBounds(302, 88, 54, 15);
		lblNewLabel_3.setText(account.getBalance()+"");
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_3 = new JButton("refresh");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_3.setText(account.getBalance()+"");
			}
		});
		btnNewButton_3.setBounds(238, 117, 93, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setBounds(331, 225, 93, 23);
		contentPane.add(btnBack);
	}
}
