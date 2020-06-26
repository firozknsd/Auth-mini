import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
public class UserList extends JPanel implements ActionListener {
	public JFrame frame;
	private JPanel panelUserList;
	
	private String currentPassword="",comment="";
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnDeleteRecord;
	
	public UserList() {
		initialize();
	}
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(358, 30, 913, 724);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		
		btnDeleteRecord = new JButton("Delete Record");
		btnDeleteRecord.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDeleteRecord.setBounds(449, 479, 164, 39);
		panelUserList.add(btnDeleteRecord);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setUndecorated(true);
		frame.setVisible(true);
		btnDeleteRecord.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		
		UserDAO userDao = new UserDAO();
		ArrayList<User> arrayList = (ArrayList<User>) userDao.list();
		System.out.println(arrayList.get(table.getSelectedRow()).getId());
		
		if(btnDeleteRecord==actionEvent.getSource()) {
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
