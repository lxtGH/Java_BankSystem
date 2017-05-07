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

public class CloseAccountFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;



	/**
	 * Create the frame.
	 */
	public CloseAccountFrame(BankAccount account) {
		this.setVisible(true);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PIN code");
		lblNewLabel.setBounds(93, 78, 72, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(156, 75, 93, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pin = Integer.parseInt(textField.getText());
				if(pin == account.getPin()){
					if((int)account.getBalance()==0)
					{
					JOptionPane.showMessageDialog(null,"Your account has been closed");
					account.setActive(false);
					}
					else {
						JOptionPane.showMessageDialog(null,"Your account balance is not zero!!");
						return;
					}
				}else
				{
					JOptionPane.showMessageDialog(null, "You get wrong PIN code");
					return;
				}
			}
		});
		btnNewButton.setBounds(156, 141, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(account.isActive()){
					JOptionPane.showMessageDialog(null,"Your account is active already");
				}
				else {
					account.setActive(true);
					JOptionPane.showMessageDialog(null,"Your account is active now!");
				}
			}
		});
		btnNewButton_1.setBounds(156, 174, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setBounds(156, 212, 93, 23);
		contentPane.add(btnNewButton_2);
	}

}
