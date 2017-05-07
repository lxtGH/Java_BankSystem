package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.BankAccount;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;



	/**
	 * this frame to suspend or unsuspend  the current account
	 * @param account
	 */
	public CheckFrame(BankAccount account) {
		this.setVisible(true);
		setBounds(100, 100, 413, 259);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please input the PIN code");
		lblNewLabel.setBounds(101, 46, 249, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblPin = new JLabel("PIN");
		lblPin.setBounds(96, 75, 54, 15);
		contentPane.add(lblPin);
		
		textField = new JTextField();
		textField.setBounds(142, 71, 109, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Suspend");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pin = Integer.parseInt(textField.getText().toString());
				if(pin==account.getPin()){
					JOptionPane.showMessageDialog(null, "You account has been suspended");
					account.setSuspended(true);
					return;
				}else {
					JOptionPane.showMessageDialog(null, "wrong pin number");
					return;
				}
			}
		});
		btnNewButton.setBounds(78, 127, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(142, 187, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("UnSuspend");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pin = Integer.parseInt(textField.getText().toString());
				if(pin==account.getPin()){
					JOptionPane.showMessageDialog(null, "You account has been unsuspended");
					account.setSuspended(false);
					return;
				}else {
					JOptionPane.showMessageDialog(null, "wrong pin number");
					return;
				}
			}
		});
		btnNewButton_2.setBounds(205, 127, 93, 23);
		contentPane.add(btnNewButton_2);
	}

}
