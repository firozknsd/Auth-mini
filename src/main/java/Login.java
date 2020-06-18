import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;

public class Login implements ActionListener {
	private JFrame frame;
	private JPanel panelLogin;
	private JLabel lblEmail_1;
	private JTextField txtEmail;
	private JLabel lblPassword_1;
	private JPasswordField txtPassword;
	private JButton btnLogin;
	private JButton btnSignUp;
	private JLabel lblLogin;
	
	private String email="",password="",role="";
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Login() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1280, 760);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Login");
		frame.getContentPane().setLayout(null);
	
		panelLogin = new JPanel();
		panelLogin.setBackground(Color.GRAY);
		panelLogin.setBounds(441, 146, 428, 437);
		panelLogin.setLayout(null);
		frame.getContentPane().add(panelLogin);
		
		lblEmail_1 = new JLabel("Email");
		lblEmail_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail_1.setBounds(55, 97, 55, 34);
		panelLogin.add(lblEmail_1);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmail.setBounds(55, 142, 200, 39);
		panelLogin.add(txtEmail);
		
		lblPassword_1 = new JLabel("Password ");
		lblPassword_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword_1.setBounds(55, 207, 83, 34);
		panelLogin.add(lblPassword_1);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPassword.setBounds(55, 252, 200, 39);
		panelLogin.add(txtPassword);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(55, 343, 135, 42);
		panelLogin.add(btnLogin);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		btnSignUp = new JButton("SignUp");
		btnSignUp.setBounds(231, 346, 135, 37);
		panelLogin.add(btnSignUp);
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		btnSignUp.addActionListener(this);
		btnLogin.addActionListener(this);
		
		lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLogin.setBounds(55, 29, 55, 34);
		panelLogin.add(lblLogin);
			
		frame.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		
		email = txtEmail.getText();
		password = txtPassword.getText();
		
		//List<User> user = UserDAO.list();
		
		if(btnSignUp==actionEvent.getSource()) {
			frame.setVisible(false);
			new SignUp();
		} else if(btnLogin==actionEvent.getSource()) {
			if(!email.equals("") && !password.equals("")) {
				
				//Take email & password by hibernate method and feel it on place of double quotes
				if(email.equals("") && password.equals("")) {
					if(role.equals("Admin")) {
						frame.setVisible(false);
						new WelcomeWithUserList();
					} else if(role.equals("Standard User")) {
						frame.setVisible(false);
						new Welcome();
					} else {
						new JOptionPane().showMessageDialog(panelLogin,"Something is wrong...!");
					}
				}
			} else if(email.equals("")) {
				new JOptionPane().showMessageDialog(panelLogin,"Enter email...!");
			} else if(password.equals("")) {
				new JOptionPane().showMessageDialog(panelLogin,"Enter password...!");
			}
		}
	}
}

