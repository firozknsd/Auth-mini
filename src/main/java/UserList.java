import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JScrollPane;
public class UserList extends JPanel implements ActionListener {
	public JFrame frame;
	private JPanel panelUserList;
	
	private String currentPassword="",comment="";
	private JTable table;
	private JScrollPane scrollPane;
	
	public UserList() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(358, 30, 913, 724);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String []metaData = {"Id","FirstName","LastName","Gender","Dob","Phone","Email","Status","Role","Remark"};
		
		for(int i=0;i<10;i++) {
				System.out.print(metaData[i]+"\t");
		}
		UserDAO userDao = new UserDAO();
		ArrayList<User> arrayList = (ArrayList<User>) userDao.list();
		
		String data[][] = new String[arrayList.size()][10];
		
		
		panelUserList = new JPanel();
		panelUserList.setLayout(null);
		panelUserList.setBackground(Color.GRAY);
		panelUserList.setBounds(116, 67, 667, 572);
		frame.getContentPane().add(panelUserList);
		
		JLabel lblUserList = new JLabel("User List");
		lblUserList.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUserList.setBounds(55, 40, 82, 39);
		panelUserList.add(lblUserList);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 121, 558, 330);
		panelUserList.add(scrollPane);
		
		table = new JTable(data,metaData);
		scrollPane.setViewportView(table);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setUndecorated(true);
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		
	}
}
