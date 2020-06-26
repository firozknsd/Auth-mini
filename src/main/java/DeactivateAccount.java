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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JRadioButton;
public class DeactivateAccount extends JPanel implements ActionListener {
	public JFrame frame;
	private JPasswordField txtCurrentPassword;
	private JButton btnDeactivateAccount,btnClear;
	private JEditorPane commentPane;
	private JRadioButton rdbtnNotUsefull,rdbtnMovingToOther,rdbtnAnyOtherReason;
	private JPanel panelDeactivate;
	
	private String currentPassword="",comment="";
	
	public DeactivateAccount() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(358, 30, 913, 724);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panelDeactivate = new JPanel();
		panelDeactivate.setLayout(null);
		panelDeactivate.setBackground(Color.GRAY);
		panelDeactivate.setBounds(255, 67, 409, 572);
		frame.getContentPane().add(panelDeactivate);
		
		JLabel lblCurrentPassword = new JLabel("Current Password");
		lblCurrentPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCurrentPassword.setBounds(55, 97, 141, 34);
		panelDeactivate.add(lblCurrentPassword);
		
		txtCurrentPassword = new JPasswordField();
		txtCurrentPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCurrentPassword.setBounds(55, 142, 200, 39);
		panelDeactivate.add(txtCurrentPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConfirmPassword.setBounds(55, 211, 129, 34);
		panelDeactivate.add(lblConfirmPassword);
		
		JLabel lblDeactivateAccount = new JLabel("Deactivate Account");
		lblDeactivateAccount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDeactivateAccount.setBounds(55, 40, 185, 39);
		panelDeactivate.add(lblDeactivateAccount);
		
		btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnClear.setBounds(275, 500, 91, 37);
		panelDeactivate.add(btnClear);
		btnClear.addActionListener(this);
		
		btnDeactivateAccount = new JButton("Deactivate Account");
		btnDeactivateAccount.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDeactivateAccount.setBounds(55, 497, 200, 42);
		panelDeactivate.add(btnDeactivateAccount);
		btnDeactivateAccount.addActionListener(this);
		
		commentPane = new JEditorPane();
		commentPane.setBounds(55, 364, 200, 84);
		commentPane.setVisible(false);
		panelDeactivate.add(commentPane);
		
		ButtonGroup group = new ButtonGroup();
		
		rdbtnMovingToOther = new JRadioButton("Moving To Other");
		rdbtnMovingToOther.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnMovingToOther.setBackground(Color.GRAY);
		rdbtnMovingToOther.setBounds(55, 284, 145, 27);
		panelDeactivate.add(rdbtnMovingToOther);
		rdbtnMovingToOther.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ie){
            	commentPane.setVisible(false);
            }
        });
		
		rdbtnAnyOtherReason = new JRadioButton("Any Other Reason");
		rdbtnAnyOtherReason.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnAnyOtherReason.setBackground(Color.GRAY);
		rdbtnAnyOtherReason.setBounds(55, 314, 155, 27);
		panelDeactivate.add(rdbtnAnyOtherReason);
		rdbtnAnyOtherReason.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ie){
            	commentPane.setVisible(true);
            }
        });
		
		rdbtnNotUsefull = new JRadioButton("Not Usefull");
		rdbtnNotUsefull.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNotUsefull.setBackground(Color.GRAY);
		rdbtnNotUsefull.setBounds(55, 254, 145, 27);
		panelDeactivate.add(rdbtnNotUsefull);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rdbtnNotUsefull.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ie){
            	commentPane.setVisible(false);
            }
        });
		
		group.add(rdbtnMovingToOther);
        group.add(rdbtnAnyOtherReason);
        group.add(rdbtnNotUsefull);
		
		frame.setUndecorated(true);
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		
		currentPassword = txtCurrentPassword.getText();
		
		if(rdbtnNotUsefull.isSelected()) {
			comment = "Not usefull.";
		} else if(rdbtnMovingToOther.isSelected()) {
			comment = "Moving to other.";
		} else {
			comment = commentPane.getText();
		}
		
		if(btnDeactivateAccount==actionEvent.getSource()) {
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
			commentPane.setText("");
		}
	}
}
