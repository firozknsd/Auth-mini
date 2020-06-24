import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingConstants;
import javax.swing.border.Border;

import java.awt.CardLayout;
public class Welcome implements MouseListener,ActionListener {
	JFrame frame;
	JLabel lblDeactivateAccount,lblChangePassword;
	JPanel panelScreen;
	CardLayout card;
	JLabel lblUserList;
	
	public Welcome() {
		
	}
	public Welcome(String role) {
		initialize(role);
	}
	private void initialize(String role) {
		
		frame = new JFrame();
		frame.setBounds(0,0,1280,760);
		frame.getContentPane().setLayout(null);
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(Color.LIGHT_GRAY);
		menuPanel.setBounds(0, 0, 350, 722);
		menuPanel.setLayout(null);
		frame.getContentPane().add(menuPanel);
		
		lblChangePassword = new JLabel("Change Password");
		lblChangePassword.setForeground(Color.BLACK);
		lblChangePassword.setBackground(Color.WHITE);
		lblChangePassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblChangePassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChangePassword.setBounds(0, 264, 350, 60);
		menuPanel.add(lblChangePassword);
		
		lblDeactivateAccount= new JLabel("Deactivate Account");
		lblDeactivateAccount.setForeground(Color.BLACK);
		lblDeactivateAccount.setBackground(Color.LIGHT_GRAY);
		lblDeactivateAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeactivateAccount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDeactivateAccount.setBounds(0, 326, 350, 60);
		menuPanel.add(lblDeactivateAccount);
		
		lblUserList = new JLabel("User List");
		lblUserList.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserList.setForeground(Color.BLACK);
		lblUserList.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUserList.setBackground(Color.LIGHT_GRAY);
		lblUserList.setBounds(0, 387, 350, 60);
		if(role.equals("Admin")) {
			menuPanel.add(lblUserList);
		}
		
		lblDeactivateAccount.addMouseListener(this);
		lblChangePassword.addMouseListener(this);
		lblUserList.addMouseListener(this);
		
		panelScreen = new JPanel();
		ChangePassword changePassword = new ChangePassword();
		DeactivateAccount deactivateAccount = new DeactivateAccount();
		UserList userList = new UserList();
		panelScreen.setLayout(new CardLayout());
		panelScreen.add("ChangePassword",changePassword);
		panelScreen.add("DeactivateAccount",deactivateAccount);
		panelScreen.add("UserList",userList);
		panelScreen.setBounds(349, 0, 915, 722);
		frame.getContentPane().add(panelScreen);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent mouseEvent) {
		if(lblDeactivateAccount==mouseEvent.getSource()) {
			new DeactivateAccount();
		} else if(lblChangePassword==mouseEvent.getSource()) {
			new ChangePassword();
		} else if(lblUserList==mouseEvent.getSource()) {
			new UserList();
		}
	}
	@Override
	public void mouseEntered(MouseEvent mouseEvent) {
		if(lblDeactivateAccount==mouseEvent.getSource()) {
			lblDeactivateAccount.setFont(new Font("Tahoma", Font.PLAIN, 24));
			Border blackLine = BorderFactory.createLineBorder(Color.BLACK);
			lblDeactivateAccount.setBorder(blackLine);
		} else if(lblChangePassword==mouseEvent.getSource()) {
			Border blackLine = BorderFactory.createLineBorder(Color.BLACK);
			lblChangePassword.setBorder(blackLine);
			lblChangePassword.setFont(new Font("Tahoma", Font.PLAIN, 24));
		} else if(lblUserList==mouseEvent.getSource()) {
			Border blackLine = BorderFactory.createLineBorder(Color.BLACK);
			lblUserList.setBorder(blackLine);
			lblUserList.setFont(new Font("Tahoma", Font.PLAIN, 24));
		}
	}
	@Override
	public void mouseExited(MouseEvent mouseEvent) {
		if(lblDeactivateAccount==mouseEvent.getSource()) {
			lblDeactivateAccount.setBorder(null);
			lblDeactivateAccount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		} else if(lblChangePassword==mouseEvent.getSource()) {
			lblChangePassword.setBorder(null);
			lblChangePassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		} else if(lblUserList==mouseEvent.getSource()) {
			lblUserList.setBorder(null);
			lblUserList.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if(lblChangePassword==actionEvent.getSource()) {
			card.show(panelScreen,"ChangePassword");
			frame.setTitle("Change password");
		} else if(lblDeactivateAccount==actionEvent.getSource()) {
			card.show(panelScreen,"DeactivateAccount");
			frame.setTitle("Deactivate Account");
		} else if(lblUserList==actionEvent.getSource()) {
			card.show(panelScreen,"UserList");
			frame.setTitle("User list");
		}
	}
}
