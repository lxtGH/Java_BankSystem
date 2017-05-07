package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Bank;
import classes.BankAccount;
import classes.CreditAgency;
import classes.CurrentAccount;
import classes.Customer;
import classes.JuniorAccount;
import classes.SaverAccount;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class CreateAccountFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JComboBox comboBox;

	/**
	 * this frame is for user to create the new account by checking the credit agency
	 * @param bank 
	 * @param agency
	 */
	public CreateAccountFrame(Bank bank,CreditAgency agency) {
		this.setVisible(true);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(193, 56, 83, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(193, 97, 83, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(99, 59, 73, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(99, 100, 73, 15);
		contentPane.add(lblAddress);
		
		JLabel lblAccountnum = new JLabel("AccountNum");
		lblAccountnum.setBounds(99, 143, 77, 15);
		contentPane.add(lblAccountnum);
		
		textField_2 = new JTextField();
		textField_2.setBounds(193, 140, 83, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"CurrentAccount", "SaverAccount", "JuniorAccount"}));
		comboBox.setBounds(176, 20, 118, 21);
		contentPane.add(comboBox);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(99, 23, 54, 15);
		contentPane.add(lblType);
		
		JLabel lblBirth = new JLabel("Birth");
		lblBirth.setBounds(42, 178, 41, 15);
		contentPane.add(lblBirth);
		
		textField_3 = new JTextField();
		textField_3.setBounds(125, 175, 41, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(213, 175, 46, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(290, 175, 54, 21);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblYear = new JLabel("year");
		lblYear.setBounds(99, 178, 54, 15);
		contentPane.add(lblYear);
		
		JLabel lblMonth = new JLabel("month");
		lblMonth.setBounds(176, 178, 54, 15);
		contentPane.add(lblMonth);
		
		JLabel lblDay = new JLabel("day");
		lblDay.setBounds(264, 178, 30, 15);
		contentPane.add(lblDay);
		
		JButton btnNewButton = new JButton("create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText().toString();
				
				if(!agency.ifCredit(name)){
					JOptionPane.showMessageDialog(null,"You are not a credit account, you can enroll", "alert", JOptionPane.ERROR_MESSAGE); 
					rollback();
					return;
				}
				String address = textField_1.getText().toString();
				int accountNum = Integer.parseInt(textField_2.getText().trim().toString());
				if(bank.isExist(accountNum)){
					JOptionPane.showMessageDialog(null,"the Account number has been used", "alert", JOptionPane.ERROR_MESSAGE); 
					rollback();
					return;
				}
				int year =Integer.parseInt(textField_3.getText().toString());
				int month = Integer.parseInt(textField_4.getText().toString());
				int day = Integer.parseInt(textField_5.getText().toString());
				Customer customer = new Customer(name,address,year,month,day);
				BankAccount bankAccount=null;
				String temp = comboBox.getSelectedItem().toString();
				if(temp.equals("CurrentAccount")){
					 bankAccount = new CurrentAccount(accountNum,customer);
				}else if(temp.equals("SaverAccount")){
					 bankAccount = new SaverAccount(accountNum, customer);
				}else if(temp.equals("JuniorAccount")){
					Calendar now =Calendar.getInstance();
					int dif=now.get(Calendar.YEAR)-Integer.parseInt(textField_3.getText());
					if(dif>18){
						JOptionPane.showMessageDialog(null,  "You are an adult , can have junior account", "alert",JOptionPane.ERROR_MESSAGE); 
						System.out.println("You are an adult , can have junior account");
						return;
					}
					 bankAccount = new JuniorAccount(accountNum, customer);
				}
				bank.getActiveList().add(bankAccount);
				JOptionPane.showMessageDialog(null,"Your account number is "+accountNum
						+" Your PIN number is"+bankAccount.getPin(),"success!",JOptionPane.DEFAULT_OPTION);
				
			}
		});
		btnNewButton.setBounds(126, 216, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setBounds(249, 216, 93, 23);
		contentPane.add(btnBack);
		
		JLabel lblMustBeA = new JLabel("Must be a number");
		lblMustBeA.setBounds(286, 143, 118, 15);
		contentPane.add(lblMustBeA);
		
	}
	void rollback(){
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		textField_5.setText("");
	}
	
}
