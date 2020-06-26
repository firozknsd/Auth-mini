import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPasswordField;
import javax.swing.JButton;
public class ChangePassword extends JPanel implements ActionListener {
	public JFrame frame;
	private JPasswordField txtCurrentPassword;
	private JButton btnChangePassword,btnClear;
	private JPasswordField txtNewPassword;
	private JPasswordField txtConfirmPassword;
	JPanel panelChange;
	
	private String currentPassword="",newPassword="",confirmPassword="";
	
	public ChangePassword() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(358, 30, 913, 724);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panelChange = new JPanel();
		panelChange.setLayout(null);
		panelChange.setBackground(Color.GRAY);
		panelChange.setBounds(255, 67, 409, 542);
		frame.getContentPane().add(panelChange);
		
		JLabel lblCurrentPassword = new JLabel("Current Password");
		lblCurrentPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCurrentPassword.setBounds(55, 97, 141, 34);
		panelChange.add(lblCurrentPassword);
		
		txtCurrentPassword = new JPasswordField();
		txtCurrentPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCurrentPassword.setBounds(55, 142, 200, 39);
		panelChange.add(txtCurrentPassword);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewPassword.setBounds(55, 207, 141, 34);
		panelChange.add(lblNewPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConfirmPassword.setBounds(55, 331, 129, 34);
		panelChange.add(lblConfirmPassword);
		
		JLabel lblChangePassword = new JLabel("ChangePassword");
		lblChangePassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChangePassword.setBounds(55, 40, 185, 39);
		panelChange.add(lblChangePassword);
		
		btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnClear.setBounds(275, 464, 91, 37);
		panelChange.add(btnClear);
		btnClear.addActionListener(this);
		
		btnChangePassword = new JButton("Change Password");
		btnChangePassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnChangePassword.setBounds(55, 461, 200, 42);
		panelChange.add(btnChangePassword);
		btnChangePassword.addActionListener(this);
		
		txtNewPassword = new JPasswordField();
		txtNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNewPassword.setBounds(55, 252, 200, 39);
		panelChange.add(txtNewPassword);
		
		txtConfirmPassword = new JPasswordField();
		txtConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtConfirmPassword.setBounds(55, 376, 200, 39);
		panelChange.add(txtConfirmPassword);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setUndecorated(true);
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		
		currentPassword = txtCurrentPassword.getText();
		newPassword = txtNewPassword.getText();
		confirmPassword = txtConfirmPassword.getText();
		
		if(btnChangePassword==actionEvent.getSource()) {
			int index = 0;
			UserDAO userDao = new UserDAO();
			ArrayList<User> ArrayList = (ArrayList<User>) userDao.list();
				for(int i=0;i<ArrayList.size();i++) {
					if(ArrayList.get(i).getPassword().equals(currentPassword)) {
						index = i;
					}
				}
			if(ArrayList.get(index).getPassword().equals(currentPassword)) {
				if(newPassword.equals(confirmPassword)) {
					User user = ArrayList.get(index);
					userDao.update(user,newPassword);
					new JOptionPane().showMessageDialog(panelChange,"Changed password successfully...!");
					txtCurrentPassword.setText("");
					txtNewPassword.setText("");
					txtConfirmPassword.setText("");
				} else {
					new JOptionPane().showMessageDialog(panelChange,"New password did not match!!");
				} 
			} else {
				new JOptionPane().showMessageDialog(panelChange,"Current password is not correct...!");
			}
		} else if(btnClear==actionEvent.getSource()) {
			txtCurrentPassword.setText("");
			txtNewPassword.setText("");
			txtConfirmPassword.setText("");
		}
	}
}
