import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
public class UserList extends JPanel implements ActionListener {
	public JFrame frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserList window = new UserList();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public UserList() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(358, 30, 913, 724);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUuserList = new JLabel("User List");
		lblUuserList.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblUuserList.setBounds(342, 119, 106, 62);
		frame.getContentPane().add(lblUuserList);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setUndecorated(true);
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
