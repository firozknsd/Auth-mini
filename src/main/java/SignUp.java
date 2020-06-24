import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

public class SignUp implements ActionListener {

	private JFrame frame;
	private JPanel panelInfo;
	private JLabel lblFirstName;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtDOB;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JPasswordField txtPassword;
	private JPasswordField txtConfirmPassword;
	private JButton btnSubmit;
	private JRadioButton rdbtnMale,rdbtnFemale;
	
	private int id=0;
	private String firstName="",lastName="",gender="",phone="",email="",password="",confirmPassword="",status="Unactive",role="",remark="";
	private Date dob=null;
	private Timestamp timestamp;
	//operations.delete(8);
	public SignUp() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.setBounds(0, 0, 1280, 760);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("SignUp");
		frame.getContentPane().setLayout(null);
		
		panelInfo = new JPanel();
		panelInfo.setBorder(null);
		panelInfo.setBackground(Color.LIGHT_GRAY);
		panelInfo.setBounds(305, 34, 662, 656);
		panelInfo.setLayout(null);
		frame.getContentPane().add(panelInfo);
		
		lblFirstName = new JLabel("First name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFirstName.setBounds(84, 89, 95, 28);
		panelInfo.add(lblFirstName);
		
		txtFirstName = new JTextField();
		txtFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(84, 128, 192, 39);
		panelInfo.add(txtFirstName);
		
		txtLastName = new JTextField();
		txtLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtLastName.setColumns(10);
		txtLastName.setBounds(387, 127, 192, 39);
		panelInfo.add(txtLastName);
		
		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName.setBounds(387, 88, 83, 28);
		panelInfo.add(lblLastName);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGender.setBounds(387, 196, 67, 28);
		panelInfo.add(lblGender);
		
		JLabel lblDateOfBirth = new JLabel("Date of birth ");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDateOfBirth.setBounds(84, 197, 105, 28);
		panelInfo.add(lblDateOfBirth);
		
		txtDOB = new JTextField();
		txtDOB.setToolTipText("YYYY-MM-DD");
		txtDOB.setText("YYYY-MM-DD");
		txtDOB.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDOB.setColumns(10);
		txtDOB.setBounds(84, 236, 192, 39);
		panelInfo.add(txtDOB);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBackground(Color.LIGHT_GRAY);
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnMale.setBounds(387, 233, 67, 39);
		panelInfo.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBackground(Color.LIGHT_GRAY);
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnFemale.setBounds(485, 235, 94, 39);
		panelInfo.add(rdbtnFemale);
		
		buttonGroup.add(rdbtnMale);
		buttonGroup.add(rdbtnFemale);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhone.setBounds(387, 318, 95, 28);
		panelInfo.add(lblPhone);
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPhone.setColumns(10);
		txtPhone.setBounds(387, 351, 192, 39);
		panelInfo.add(txtPhone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(84, 319, 61, 28);
		panelInfo.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmail.setColumns(10);
		txtEmail.setBounds(84, 352, 192, 39);
		panelInfo.add(txtEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(84, 446, 89, 28);
		panelInfo.add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(84, 479, 192, 39);
		panelInfo.add(txtPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm password ");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConfirmPassword.setBounds(387, 445, 145, 28);
		panelInfo.add(lblConfirmPassword);
		
		txtConfirmPassword = new JPasswordField();
		txtConfirmPassword.setBounds(387, 479, 192, 39);
		panelInfo.add(txtConfirmPassword);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSubmit.setBounds(84, 573, 162, 50);
		panelInfo.add(btnSubmit);
		btnSubmit.addActionListener(this);
		
		JLabel lblRegistration = new JLabel("Registration");
		lblRegistration.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRegistration.setBounds(84, 30, 113, 28);
		panelInfo.add(lblRegistration);
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if(btnSubmit==actionEvent.getSource()) {
			
			firstName = txtFirstName.getText();
			lastName = txtLastName.getText();
			
			if(rdbtnMale.isSelected() == false && rdbtnFemale.isSelected() == false) {
				new JOptionPane().showMessageDialog(panelInfo,"Choose gender...!");
			} else {
				if(rdbtnMale.isSelected() == true) {
					gender="Male";
				} else {
					gender="Female";
				}
			}
			try {
				dob = new SimpleDateFormat("yyyy-MM-dd").parse(txtDOB.getText());
				timestamp = new Timestamp(dob.getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			phone = txtPhone.getText();
			email = txtEmail.getText();
			password = txtPassword.getText();
			confirmPassword = txtConfirmPassword.getText();
			status = "Active";
			role = "Standard user";
			remark = "Blank";
			if(!firstName.equals("") && !lastName.equals("") && dob!=null && gender!="" && !phone.equals("") && !email.equals("") && !password.equals("") && !confirmPassword.equals("") && status.equals("Active")) {
				if(password.equals(confirmPassword)) {
					UserDAO userDao = new UserDAO();
					int id = userDao.insert(new User(firstName,lastName,gender,dob,phone,email,password,status,role,remark));
					if(id!=0) {
						new JOptionPane().showMessageDialog(panelInfo,"Successfully Sigh Up...!");
						frame.setVisible(false);
						new Login();
					}
				} else {
					new JOptionPane().showMessageDialog(panelInfo,"Password did not match!!");
				}
			} else {
				new JOptionPane().showMessageDialog(panelInfo,"Fill all fields");
			}
		}
	}
}
