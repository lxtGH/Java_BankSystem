package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Bank;
import classes.CreditAgency;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class LogIn extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	public static void main(String[] args) {
		LogIn frame = new LogIn();
		frame.setVisible(true);
	}
	
	/**
	 * Launch the whole project
	 */
	public LogIn() {
		Bank bank = new Bank();
		CreditAgency agency = new CreditAgency();
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("LogIn");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EnterFrame(bank);
			}
		});
		btnNewButton.setBounds(142, 86, 154, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Create Account");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CreateAccountFrame(bank,agency);
			}
		});
		btnNewButton_1.setBounds(142, 134, 154, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("quit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bank.writeActiveListToCSV("Files/account.csv");
				dispose();
			}
		});
		btnNewButton_2.setBounds(331, 210, 93, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblWelcomeToOur = new JLabel("Welcome To Our Bank");
		lblWelcomeToOur.setBounds(142, 25, 196, 15);
		contentPane.add(lblWelcomeToOur);
	}
}
