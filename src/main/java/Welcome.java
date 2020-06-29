import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.CardLayout;
import javax.swing.JPasswordField;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Welcome implements MouseListener,ActionListener {
	private JFrame frame;
	private JLabel lblChangePassword,lblDeactivateAccount,lblUserList;
	private JPanel panelScreen;
	private CardLayout cl_panelChangePassword;
	private JPanel panelChangePassword,panelDeactivateAccount,panelUserList;
	private JPanel panelChange;
	private JLabel lblCurrentPassword;
	private JPasswordField txtCurrentPassword;
	private JLabel lblNewPassword;
	private JLabel lblConfirmPassword;
	private JLabel lblChangePassword_1;
	private JButton btnClear;
	private JButton btnChangePassword;
	private JPasswordField txtNewPassword;
	private JPasswordField txtConfirmPassword;
	private JPanel panelDeactivate;
	private JLabel lblDeactivateAccount_1;
	private JPasswordField txtCurrentPasswordDeactivate;
	private JPanel panelUserList_1;
	private JLabel lblUserList_1;
	private JScrollPane scrollPane;
	private JButton btnDeleteRecord;
	private CardLayout card;
	private JButton btnDeactivateAccount,btnClearDeactivate;
	private JRadioButton rdbtnNotUsefull,rdbtnMovingToOther,rdbtnAnyOtherReason;
	private JEditorPane commentPane;
	private JTable table;
	
	private String currentPassword="",newPassword="",confirmPassword="";
	private String comment="";
	
	public Welcome() {
		
	}
	public Welcome(String role) {
		initialize(role);
	}
	private void initialize(String role) {
		frame = new JFrame();
		frame.setBounds(0, 0, 1280, 760);
		frame.setTitle("Welcome");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(Color.GRAY);
		panelMenu.setBounds(0, 0, 398, 722);
		frame.getContentPane().add(panelMenu);
		panelMenu.setLayout(null);
		
		lblChangePassword = new JLabel("Change Password");
		lblChangePassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChangePassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblChangePassword.setBounds(0, 268, 398, 50);
		panelMenu.add(lblChangePassword);
		
		lblDeactivateAccount = new JLabel("Deactivate Account");
		lblDeactivateAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeactivateAccount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDeactivateAccount.setBounds(0, 319, 398, 50);
		panelMenu.add(lblDeactivateAccount);
		
		lblUserList = new JLabel("User List");
		lblUserList.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserList.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUserList.setBounds(0, 370, 398, 50);
		if(role.equals("Admin")) {
			panelMenu.add(lblUserList);
		}
		
		card = new CardLayout();
		panelScreen = new JPanel();
		panelScreen.setBounds(399, 0, 865, 722);
		panelScreen.setLayout(card);
		frame.getContentPane().add(panelScreen);
		
		panelChangePassword = new JPanel();
		panelChangePassword.setBounds(0, 0, 865, 722);
		panelChangePassword.setLayout(null);
		panelScreen.add(panelChangePassword);
		
		panelChange = new JPanel();
		panelChange.setLayout(null);
		panelChange.setBackground(Color.GRAY);
		panelChange.setBounds(255, 67, 409, 542);
		panelChangePassword.add(panelChange);
		
		lblCurrentPassword = new JLabel("Current Password");
		lblCurrentPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCurrentPassword.setBounds(55, 97, 141, 34);
		panelChange.add(lblCurrentPassword);
		
		txtCurrentPassword = new JPasswordField();
		txtCurrentPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCurrentPassword.setBounds(55, 142, 200, 39);
		panelChange.add(txtCurrentPassword);
		
		lblNewPassword = new JLabel("New Password");
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewPassword.setBounds(55, 207, 141, 34);
		panelChange.add(lblNewPassword);
		
		lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConfirmPassword.setBounds(55, 331, 129, 34);
		panelChange.add(lblConfirmPassword);
		
		lblChangePassword_1 = new JLabel("ChangePassword");
		lblChangePassword_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChangePassword_1.setBounds(55, 40, 185, 39);
		panelChange.add(lblChangePassword_1);
		
		btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnClear.setBounds(275, 464, 91, 37);
		panelChange.add(btnClear);
		
		btnChangePassword = new JButton("Change Password");
		btnChangePassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnChangePassword.setBounds(55, 461, 200, 42);
		panelChange.add(btnChangePassword);
		
		txtNewPassword = new JPasswordField();
		txtNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNewPassword.setBounds(55, 252, 200, 39);
		panelChange.add(txtNewPassword);
		
		txtConfirmPassword = new JPasswordField();
		txtConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtConfirmPassword.setBounds(55, 376, 200, 39);
		panelChange.add(txtConfirmPassword);
		

		panelDeactivateAccount = new JPanel();
		panelDeactivateAccount.setBounds(0, 0, 865, 722);
		panelDeactivateAccount.setLayout(null);
		panelScreen.add(panelDeactivateAccount);
		
		panelDeactivate = new JPanel();
		panelDeactivate.setBackground(Color.GRAY);
		panelDeactivate.setBounds(255, 67, 408, 542);
		panelDeactivate.setLayout(null);
		panelDeactivateAccount.add(panelDeactivate);
		
		lblDeactivateAccount_1 = new JLabel("Deactivate Account");
		lblDeactivateAccount_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDeactivateAccount_1.setBounds(40, 31, 185, 39);
		panelDeactivate.add(lblDeactivateAccount_1);
		
		JLabel lblCurrentPassword_1 = new JLabel("Current Password");
		lblCurrentPassword_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCurrentPassword_1.setBounds(40, 92, 141, 34);
		panelDeactivate.add(lblCurrentPassword_1);
		
		txtCurrentPasswordDeactivate = new JPasswordField();
		txtCurrentPasswordDeactivate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCurrentPasswordDeactivate.setBounds(40, 137, 200, 39);
		panelDeactivate.add(txtCurrentPasswordDeactivate);
		
		JLabel lblConfirmPassword_1 = new JLabel("Confirm Password");
		lblConfirmPassword_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConfirmPassword_1.setBounds(40, 208, 129, 34);
		panelDeactivate.add(lblConfirmPassword_1);
		
		ButtonGroup group = new ButtonGroup();
		
		rdbtnNotUsefull = new JRadioButton("Not Usefull");
		rdbtnNotUsefull.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNotUsefull.setBackground(Color.GRAY);
		rdbtnNotUsefull.setBounds(40, 251, 145, 27);
		panelDeactivate.add(rdbtnNotUsefull);
		rdbtnNotUsefull.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ie){
            	commentPane.setVisible(false);
            }
        });
		
		rdbtnMovingToOther = new JRadioButton("Moving To Other");
		rdbtnMovingToOther.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnMovingToOther.setBackground(Color.GRAY);
		rdbtnMovingToOther.setBounds(40, 281, 145, 27);
		panelDeactivate.add(rdbtnMovingToOther);
		rdbtnMovingToOther.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ie){
            	commentPane.setVisible(false);
            }
        });
		
		rdbtnAnyOtherReason = new JRadioButton("Any Other Reason");
		rdbtnAnyOtherReason.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnAnyOtherReason.setBackground(Color.GRAY);
		rdbtnAnyOtherReason.setBounds(40, 311, 155, 27);
		panelDeactivate.add(rdbtnAnyOtherReason);
		rdbtnAnyOtherReason.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ie){
            	commentPane.setVisible(true);
            }
        });
		
		commentPane = new JEditorPane();
		commentPane.setBounds(40, 354, 200, 84);
		commentPane.setVisible(false);
		panelDeactivate.add(commentPane);
		
		btnDeactivateAccount = new JButton("Deactivate Account");
		btnDeactivateAccount.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDeactivateAccount.setBounds(40, 470, 200, 42);
		panelDeactivate.add(btnDeactivateAccount);
		
		btnClearDeactivate = new JButton("Clear");
		btnClearDeactivate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnClearDeactivate.setBounds(267, 473, 108, 37);
		panelDeactivate.add(btnClearDeactivate);
		
		group.add(rdbtnMovingToOther);
        group.add(rdbtnAnyOtherReason);
        group.add(rdbtnNotUsefull);
		
		panelUserList = new JPanel();
		panelUserList.setBounds(0, 0, 865, 722);
		panelUserList.setLayout(null);
		panelScreen.add(panelUserList);
		
		String []metaData = {"Id","FirstName","LastName","Gender","Dob","Phone","Email","Status","Role","Remark"};
		
		UserDAO userDao = new UserDAO();
		ArrayList<User> arrayList = (ArrayList<User>) userDao.list();
		
		String data[][] = new String[arrayList.size()][10];
		
		for(int i=0 ; i<arrayList.size() ; i++) {
			data[i][0] = Integer.toString(arrayList.get(i).getId());
			data[i][1] = arrayList.get(i).getFirstName();
			data[i][2] = arrayList.get(i).getLastName();
			data[i][3] = arrayList.get(i).getGender();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
			data[i][4] = dateFormat.format(arrayList.get(i).getDob());
			data[i][5] = arrayList.get(i).getPhone();
			data[i][6] = arrayList.get(i).getEmail();
			data[i][7] = arrayList.get(i).getStatus();
			data[i][8] = arrayList.get(i).getRole();
			data[i][9] = arrayList.get(i).getRemark();
			
		}
		
		panelUserList_1 = new JPanel();
		panelUserList_1.setLayout(null);
		panelUserList_1.setBackground(Color.GRAY);
		panelUserList_1.setBounds(100, 67, 667, 572);
		panelUserList.add(panelUserList_1);
		
		lblUserList_1 = new JLabel("User List");
		lblUserList_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUserList_1.setBounds(55, 40, 82, 39);
		panelUserList_1.add(lblUserList_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 121, 558, 330);
		panelUserList_1.add(scrollPane);
		
		table = new JTable(data,metaData);
		scrollPane.setViewportView(table);
		
		btnDeleteRecord = new JButton("Delete Record");
		btnDeleteRecord.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDeleteRecord.setBounds(449, 479, 164, 39);
		panelUserList_1.add(btnDeleteRecord);
		
		panelScreen.add(panelChangePassword,"a");
		panelScreen.add(panelDeactivateAccount,"b");
		panelScreen.add(panelUserList,"c");
		
		lblChangePassword.addMouseListener(this);
		lblDeactivateAccount.addMouseListener(this);
		lblUserList.addMouseListener(this);
		
		btnChangePassword.addActionListener(this);
		btnDeactivateAccount.addActionListener(this);
		btnClearDeactivate.addActionListener(this);
		btnDeleteRecord.addActionListener(this);
		btnClear.addActionListener(this);
		
		
		frame.setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==lblChangePassword) {
			card.show(panelScreen,"a");
		} else if(e.getSource()==lblDeactivateAccount) {
			card.show(panelScreen,"b");
		} else if(e.getSource()==lblUserList) {
			card.show(panelScreen,"c");
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
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		
		if(actionEvent.getSource()==btnChangePassword) {
			
			currentPassword = txtCurrentPassword.getText();
			newPassword = txtNewPassword.getText();
			confirmPassword = txtConfirmPassword.getText();
			
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
		} else if(actionEvent.getSource()==btnDeactivateAccount) {

			currentPassword = txtCurrentPasswordDeactivate.getText();
			
			if(rdbtnNotUsefull.isSelected()) {
				comment = "Not usefull.";
			} else if(rdbtnMovingToOther.isSelected()) {
				comment = "Moving to other.";
			} else {
				comment = commentPane.getText();
			}
			int index = 0;
			UserDAO userDao = new UserDAO();
			ArrayList<User> ArrayList = (ArrayList<User>) userDao.list();
				for(int i=0;i<ArrayList.size();i++) {
					if(ArrayList.get(i).getPassword().equals(currentPassword)) {
						index = i;
					}
				}
			if(ArrayList.get(index).getPassword().equals(currentPassword)) {
				String status = "Deactivate";
				User user = ArrayList.get(index);
				userDao.update(user,status,comment);
				new JOptionPane().showMessageDialog(panelDeactivate,"Your account has been successfully deactivated...!");
				frame.setVisible(false);
				new Login();
			} else {
				new JOptionPane().showMessageDialog(panelDeactivate,"Wrong password...!");
			} 
		} else if(btnClear==actionEvent.getSource()) {
			txtCurrentPassword.setText("");
			txtNewPassword.setText("");
			txtConfirmPassword.setText("");
		} else if(btnClearDeactivate==actionEvent.getSource()) {
			txtCurrentPasswordDeactivate.setText("");
			commentPane.setText("");
		} else if(btnDeleteRecord==actionEvent.getSource()) {
			
			UserDAO userDao = new UserDAO();
			ArrayList<User> arrayList = (ArrayList<User>) userDao.list();
			
			if(table.getSelectedRow()>1) {
				int flag = new JOptionPane().showConfirmDialog(panelUserList,"Are you sure you went to delete this record...?");
				if(flag==0) {
					userDao.delete(arrayList.get(table.getSelectedRow()).getId());
					new JOptionPane().showMessageDialog(panelUserList,"Successfully deleted.");
				}
			} else if(table.getSelectedRow()+1==1) {
				new JOptionPane().showMessageDialog(panelUserList,"Restricted Record..!");
			}
		}
	}
}
