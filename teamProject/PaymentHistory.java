package teamProject;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PaymentHistory {
   
   public static JFrame PaymentHistoryMainFrame = new JFrame("����������ȸ");
   
   public PaymentHistory(){
      
   
      PaymentHistoryMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      PaymentHistoryPanel PaymentHistoryMainPanel = new PaymentHistoryPanel();
      
      PaymentHistoryMainFrame.getContentPane().add(PaymentHistoryMainPanel);
      
      PaymentHistoryMainFrame.setLocationRelativeTo(null); // ȭ�� �߾����� ������ ��ġ
      PaymentHistoryMainFrame.setPreferredSize(new Dimension(PaymentHistoryMainPanel.getSize()));
      
      JButton btnNewButton = new JButton("�ڷ�");
	  btnNewButton.setFont(new Font("����", Font.BOLD, 20));
	  btnNewButton.setBounds(10, 10, 79, 39);
	  PaymentHistoryMainPanel.add(btnNewButton);
	
	  btnNewButton.addActionListener(new ActionListener() {

		  @Override
		  public void actionPerformed(ActionEvent e) {
		  	  // TODO Auto-generated method stub
		  	  PaymentHistoryMainFrame.setVisible(false);
//			  PaymentHistoryMainFrame.dispose();
		  }
	  });
      
      PaymentHistoryMainFrame.setResizable(false);   // â ũ�� ���� �Ұ�
      PaymentHistoryMainFrame.pack();
      PaymentHistoryMainFrame.setVisible(true);
   }
}