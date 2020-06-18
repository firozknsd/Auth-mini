import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingConstants;
import java.awt.CardLayout;
public class WelcomeWithUserList implements MouseListener,ActionListener {
	JFrame frame;
	JLabel lblDeactivateAccount,lblChangePassword;
	JPanel panelScreen;
	CardLayout card;
	private JLabel lblUserList;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeWithUserList window = new WelcomeWithUserList();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public WelcomeWithUserList() {
		initialize();
	}
	private void initialize() {
		
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
		menuPanel.add(lblUserList);
		
		lblDeactivateAccount.addMouseListener(this);
		lblChangePassword.addMouseListener(this);
		
		panelScreen = new JPanel();
		panelScreen.setLayout(new CardLayout());
		panelScreen.add("ChangePassword",new ChangePassword());
		panelScreen.add("DeactivateAccount",new DeactivateAccount());
		panelScreen.add("UserList",new UserList());
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
		}
	}
	@Override
	public void mouseEntered(MouseEvent mouseEvent) {
		if(lblDeactivateAccount==mouseEvent.getSource()) {
			lblDeactivateAccount.setBackground(Color.CYAN);
		} else if(lblChangePassword==mouseEvent.getSource()) {
			lblChangePassword.setBackground(Color.CYAN);
		}
	}
	@Override
	public void mouseExited(MouseEvent mouseEvent) {
		if(lblDeactivateAccount==mouseEvent.getSource()) {
			lblDeactivateAccount.setBackground(Color.BLACK);
		} else if(lblChangePassword==mouseEvent.getSource()) {
			lblChangePassword.setBackground(Color.CYAN);
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
		} else if(lblDeactivateAccount==actionEvent.getSource()) {
			card.show(panelScreen,"DeactivateAccount");
		} else if(lblUserList==actionEvent.getSource()) {
			card.show(panelScreen,"UserList");
		}
	}
}
