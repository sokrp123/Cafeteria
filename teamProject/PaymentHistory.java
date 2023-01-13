package teamProject;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PaymentHistory {
   
   public static JFrame PaymentHistoryMainFrame = new JFrame("결제내역조회");
   
   public PaymentHistory(){
      
   
      PaymentHistoryMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      PaymentHistoryPanel PaymentHistoryMainPanel = new PaymentHistoryPanel();
      
      PaymentHistoryMainFrame.getContentPane().add(PaymentHistoryMainPanel);
      
      PaymentHistoryMainFrame.setLocationRelativeTo(null); // 화면 중앙으로 프레임 배치
      PaymentHistoryMainFrame.setPreferredSize(new Dimension(PaymentHistoryMainPanel.getSize()));
      
      JButton btnNewButton = new JButton("뒤로");
	  btnNewButton.setFont(new Font("굴림", Font.BOLD, 20));
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
      
      PaymentHistoryMainFrame.setResizable(false);   // 창 크기 조절 불가
      PaymentHistoryMainFrame.pack();
      PaymentHistoryMainFrame.setVisible(true);
   }
}