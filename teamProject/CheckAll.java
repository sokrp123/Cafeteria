package teamProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class CheckAll extends JFrame {
	public static JFrame frame = new JFrame("주문 확인");
	public static JPanel panel = new JPanel();
	public static JPanel contentPane;

	
	public CheckAll(Cafeteria c1, Cafeteria c2) {
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 534, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("주문 확인");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		lblNewLabel.setBounds(193, 10, 163, 62);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("뒤로");
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 20));
		btnNewButton.setBounds(12, 10, 79, 39);
		contentPane.add(btnNewButton);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBounds(12, 96, 496, 431);
        
        
        btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
        });
		
		contentPane.add(scrollPane);
		frame.add(contentPane);
	}
}