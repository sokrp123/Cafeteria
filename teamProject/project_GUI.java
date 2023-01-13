package teamProject;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class project_GUI extends JFrame {
   
   private static final long serialVersionUID = 1L;
   private JPanel contentPane;

//    GUI 실행
   public static void runSelection(Cafeteria c1, Cafeteria c2) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               project_GUI frame = new project_GUI(c1,c2);
               frame.setLocationRelativeTo(null);
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   //frame 설정
   public project_GUI(Cafeteria c1, Cafeteria c2) {
	   Date from = new Date();
	   SimpleDateFormat transFormat = new SimpleDateFormat("HH:mm:ss");
	   String to = transFormat.format(from);
	   
	   c1.menu1orders = 0;
       c1.menu2orders = 0;
       c1.menu3orders = 0;
       c1.totalCash = 0;
       
       c2.menu1orders = 0;
       c2.menu2orders = 0;
       c2.menu3orders = 0;
       c2.totalCash = 0;
	   
      System.out.println(c1.getName());
      System.out.println("c1.menu1orders : "+c1.menu1orders);
      System.out.println("c1.menu1remains : "+c1.menu1remains);
            
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 530, 524);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      // 학생회관 버튼 
      JButton btnToCafeteria1 = new JButton("학생회관");
      btnToCafeteria1.setBounds(146, 127, 221, 89);
      btnToCafeteria1.setFont(new Font("굴림", Font.BOLD, 25));
      
      JPanel selectPage = new JPanel();
      selectPage.setBounds(0, 0, 526, 487);
      contentPane.add(selectPage);
      selectPage.setVisible(true);
      
      selectPage.setLayout(null);
      selectPage.add(btnToCafeteria1);
      
      JLabel lblNewLabel_6 = new JLabel("\uC8FC\uBB38\uC744 \uC6D0\uD558\uB294 \uC2DD\uB2F9\uC744 \uC120\uD0DD\uD558\uC2DC\uC624.");
      lblNewLabel_6.setBounds(100, 10, 394, 30);
      lblNewLabel_6.setFont(new Font("굴림", Font.BOLD, 25));
      selectPage.add(lblNewLabel_6);
      
      
      // 명진당 버튼 
      JButton btnToCafeteria2 = new JButton("\uBA85\uC9C4\uB2F9");
      btnToCafeteria2.setBounds(146, 272, 221, 89);
      btnToCafeteria2.setFont(new Font("굴림", Font.BOLD, 25));
      selectPage.add(btnToCafeteria2);
      
      JPanel orderPage1 = new JPanel();
      orderPage1.setBounds(0, 0, 516, 487);
      contentPane.add(orderPage1);
      orderPage1.setLayout(null);
      orderPage1.setVisible(false); 
      
      
      JButton btnToGoBack = new JButton("\uB4A4\uB85C");
      btnToGoBack.setBounds(12, 10, 64, 49);
      orderPage1.add(btnToGoBack);
      
      JLabel lblNewLabel = new JLabel("\uC624\uB298\uC758 \uBA54\uB274");
      lblNewLabel.setFont(new Font("굴림", Font.BOLD, 25));
      lblNewLabel.setBounds(177, 7, 161, 49);
      orderPage1.add(lblNewLabel);
      
      JLabel lblNewLabel_1 = new JLabel("\uBC31\uBC18");
      lblNewLabel_1.setFont(new Font("궁서", Font.BOLD, 25));
      lblNewLabel_1.setBounds(40, 58, 79, 49);
      orderPage1.add(lblNewLabel_1);
      
      JLabel lblNewLabel_1_1 = new JLabel("\uC77C\uD488");
      lblNewLabel_1_1.setFont(new Font("궁서", Font.BOLD, 25));
      lblNewLabel_1_1.setBounds(210, 58, 79, 49);
      orderPage1.add(lblNewLabel_1_1);
      
      JLabel lblNewLabel_1_2 = new JLabel("\uC591\uC2DD");
      lblNewLabel_1_2.setFont(new Font("궁서", Font.BOLD, 25));
      lblNewLabel_1_2.setBounds(384, 58, 79, 49);
      orderPage1.add(lblNewLabel_1_2);
      
      JLabel lblNewLabel_2 = new JLabel(c1.m1_1);
      lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
      lblNewLabel_2.setBounds(30, 140, 99, 40);
      orderPage1.add(lblNewLabel_2);
      
      JLabel lblNewLabel_2_1 = new JLabel(c1.m1_2);
      lblNewLabel_2_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
      lblNewLabel_2_1.setBounds(30, 170, 99, 40);
      orderPage1.add(lblNewLabel_2_1);
      
      JLabel lblNewLabel_2_2 = new JLabel(c1.m1_3);
      lblNewLabel_2_2.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
      lblNewLabel_2_2.setBounds(30, 200, 99, 40);
      orderPage1.add(lblNewLabel_2_2);
      
      JLabel lblNewLabel_2_3 = new JLabel(c1.m1_4);
      lblNewLabel_2_3.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
      lblNewLabel_2_3.setBounds(30, 230, 99, 40);
      orderPage1.add(lblNewLabel_2_3);
      
      JLabel lblNewLabel_2_4 = new JLabel(c1.m2_1);
      lblNewLabel_2_4.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
      lblNewLabel_2_4.setBounds(200, 140, 99, 40);
      orderPage1.add(lblNewLabel_2_4);
      
      JLabel lblNewLabel_2_5 = new JLabel(c1.m2_2);
      lblNewLabel_2_5.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
      lblNewLabel_2_5.setBounds(200, 170, 99, 40);
      orderPage1.add(lblNewLabel_2_5);
      
      JLabel lblNewLabel_2_6 = new JLabel(c1.m2_3);
      lblNewLabel_2_6.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
      lblNewLabel_2_6.setBounds(200, 200, 99, 40);
      orderPage1.add(lblNewLabel_2_6);
      
      JLabel lblNewLabel_2_7 = new JLabel(c1.m2_4);
      lblNewLabel_2_7.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
      lblNewLabel_2_7.setBounds(200, 230, 99, 40);
      orderPage1.add(lblNewLabel_2_7);
      
      JLabel lblNewLabel_2_4_1 = new JLabel(c1.m3_1);
      lblNewLabel_2_4_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
      lblNewLabel_2_4_1.setBounds(370, 140, 99, 40);
      orderPage1.add(lblNewLabel_2_4_1);
      
      JLabel lblNewLabel_2_4_2 = new JLabel(c1.m3_2);
      lblNewLabel_2_4_2.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
      lblNewLabel_2_4_2.setBounds(370, 170, 99, 40);
      orderPage1.add(lblNewLabel_2_4_2);
      
      JLabel lblNewLabel_2_4_3 = new JLabel(c1.m3_3);
      lblNewLabel_2_4_3.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
      lblNewLabel_2_4_3.setBounds(370, 200, 99, 40);
      orderPage1.add(lblNewLabel_2_4_3);
      
      JLabel lblNewLabel_2_4_4 = new JLabel(c1.m3_4);
      lblNewLabel_2_4_4.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
      lblNewLabel_2_4_4.setBounds(370, 230, 99, 40);
      orderPage1.add(lblNewLabel_2_4_4);
      
      JLabel lblNewLabel_3 = new JLabel("\uB0A8\uC740 \uC7AC\uACE0\uB7C9 :");
      lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 13));
      lblNewLabel_3.setBounds(10, 300, 99, 33);
      orderPage1.add(lblNewLabel_3);
      
      JLabel lblNewLabel_3_1 = new JLabel("\uB0A8\uC740 \uC7AC\uACE0\uB7C9 :");
      lblNewLabel_3_1.setFont(new Font("굴림", Font.BOLD, 13));
      lblNewLabel_3_1.setBounds(190, 300, 99, 33);
      orderPage1.add(lblNewLabel_3_1);
      
      JLabel lblNewLabel_3_2 = new JLabel("\uB0A8\uC740 \uC7AC\uACE0\uB7C9 :");
      lblNewLabel_3_2.setFont(new Font("굴림", Font.BOLD, 13));
      lblNewLabel_3_2.setBounds(360, 300, 99, 33);
      orderPage1.add(lblNewLabel_3_2);
      
      JLabel c1m1remains = new JLabel("80");
      c1m1remains.setFont(new Font("굴림", Font.BOLD, 15));
      c1m1remains.setBounds(100, 300, 36, 39);
      orderPage1.add(c1m1remains);
      
      JLabel c1m2remains = new JLabel("80");
      c1m2remains.setFont(new Font("굴림", Font.BOLD, 15));
      c1m2remains.setBounds(280, 300, 36, 39);
      orderPage1.add(c1m2remains);
      
      JLabel c1m3remains = new JLabel("80");
      c1m3remains.setFont(new Font("굴림", Font.BOLD, 15));
      c1m3remains.setBounds(450, 300, 36, 39);
      orderPage1.add(c1m3remains);
      
      JLabel c1m1orders = new JLabel("0");
      c1m1orders.setFont(new Font("굴림", Font.BOLD, 25));
      c1m1orders.setBounds(40, 359, 36, 49);
      orderPage1.add(c1m1orders);
      
      JLabel c1m2orders = new JLabel("0");
      c1m2orders.setFont(new Font("굴림", Font.BOLD, 25));
      c1m2orders.setBounds(210, 359, 36, 49);
      orderPage1.add(c1m2orders);
      
      JLabel c1m3orders = new JLabel("0");
      c1m3orders.setFont(new Font("굴림", Font.BOLD, 25));
      c1m3orders.setBounds(384, 359, 36, 49);
      orderPage1.add(c1m3orders);
      
      JLabel totalCash1 = new JLabel("0");
      totalCash1.setFont(new Font("굴림", Font.BOLD, 30));
      totalCash1.setBounds(13, 429, 276, 58);
      orderPage1.add(totalCash1);
      
      JButton goBackBtn = new JButton("뒤로");
      goBackBtn.setFont(new Font("굴림", Font.BOLD, 20));
      goBackBtn.setBounds(12, 10, 79, 39);
	  selectPage.add(goBackBtn);
	  
	  goBackBtn.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
		  
	  });
      
      
      c1m1remains.setText(String.valueOf(c1.menu1remains));
      JButton c1m1plus = new JButton("+");   //식당 1 메뉴 1 플러스
      c1m1plus.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            c1.clickPlusRemains(1, 1);
            c1.clickPlusOrders(1, 1);
            if (c1.menu1remains < 0) {
               c1.clickMinusOrders(1, 1);
               c1.clickMinusRemains(1, 1);
               c1.countTotalCash(-c1.menu1price);
            }
            c1.countTotalCash(c1.menu1price);
            c1m1remains.setText(String.valueOf(c1.menu1remains));
            c1m1orders.setText(String.valueOf(c1.menu1orders));
            totalCash1.setText(String.valueOf(c1.getTotalCash()));
         }
      });
      c1m1plus.setFont(new Font("굴림", Font.BOLD, 14));
      c1m1plus.setBounds(96, 350, 47, 33);
      orderPage1.add(c1m1plus);
      
      c1m2remains.setText(String.valueOf(c1.menu2remains));
      JButton c1m2plus = new JButton("+");   //식당 1 메뉴 2 플러스
      c1m2plus.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            c1.clickPlusRemains(1, 2);
            c1.clickPlusOrders(1, 2);
            if (c1.menu2remains < 0) {
               c1.clickMinusOrders(1, 2);
               c1.clickMinusRemains(1, 2);
               c1.countTotalCash(-c1.menu2price);
            }
            c1.countTotalCash(c1.menu2price);
            c1m2remains.setText(String.valueOf(c1.menu2remains));
            c1m2orders.setText(String.valueOf(c1.menu2orders));
            totalCash1.setText(String.valueOf(c1.getTotalCash()));
         }
      });
      c1m2plus.setFont(new Font("굴림", Font.BOLD, 14));
      c1m2plus.setBounds(277, 350, 47, 33);
      orderPage1.add(c1m2plus);
      
      
      c1m3remains.setText(String.valueOf(c1.menu3remains));
      JButton c1m3plus = new JButton("+");   //식당 1 메뉴 3 플러스
      c1m3plus.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            c1.clickPlusRemains(1, 3);
            c1.clickPlusOrders(1, 3);
            if (c1.menu3remains < 0) {
               c1.clickMinusOrders(1, 3);
               c1.clickMinusRemains(1, 3);
               c1.countTotalCash(-c1.menu3price);
            }
            c1.countTotalCash(c1.menu3price);
            c1m3remains.setText(String.valueOf(c1.menu3remains));
            c1m3orders.setText(String.valueOf(c1.menu3orders));
            totalCash1.setText(String.valueOf(c1.getTotalCash()));
         }
      });
      c1m3plus.setFont(new Font("굴림", Font.BOLD, 14));
      c1m3plus.setBounds(445, 350, 47, 33);
      orderPage1.add(c1m3plus);
      
      c1m1remains.setText(String.valueOf(c1.menu1remains));
      JButton c1m1minus = new JButton("-");   //식당 1 메뉴 1 마이너스
      c1m1minus.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            c1.clickMinusRemains(1, 1);
            c1.clickMinusOrders(1, 1);
            if (c1.menu1orders < 0) {
               c1.clickPlusOrders(1, 1);
               c1.clickPlusRemains(1, 1);
               c1.countTotalCash(c1.menu1price);
            }
            c1.countTotalCash(-c1.menu1price);
            c1m1remains.setText(String.valueOf(c1.menu1remains));
            c1m1orders.setText(String.valueOf(c1.menu1orders));
            totalCash1.setText(String.valueOf(c1.getTotalCash()));
         }
      });
      c1m1minus.setFont(new Font("굴림", Font.BOLD, 14));
      c1m1minus.setBounds(96, 390, 47, 33);
      orderPage1.add(c1m1minus);
      
      
      c1m2remains.setText(String.valueOf(c1.menu2remains));
      JButton c1m2minus = new JButton("-");   //식당 1 메뉴 2 마이너스
      c1m2minus.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            c1.clickMinusRemains(1, 2);
            c1.clickMinusOrders(1, 2);
            if (c1.menu2orders < 0) {
               c1.clickPlusOrders(1, 2);
               c1.clickPlusRemains(1, 2);
               c1.countTotalCash(c1.menu2price);
            }
            c1.countTotalCash(-c1.menu2price);
            c1m2remains.setText(String.valueOf(c1.menu2remains));
            c1m2orders.setText(String.valueOf(c1.menu2orders));
            totalCash1.setText(String.valueOf(c1.getTotalCash()));
         }
      });
      c1m2minus.setFont(new Font("굴림", Font.BOLD, 14));
      c1m2minus.setBounds(277, 390, 47, 33);
      orderPage1.add(c1m2minus);
      
      
      c1m3remains.setText(String.valueOf(c1.menu3remains));
      JButton c1m3minus = new JButton("-");   //식당 1 메뉴 3 마이너스
      c1m3minus.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            c1.clickMinusRemains(1, 3);
            c1.clickMinusOrders(1, 3);
            if (c1.menu3orders < 0) {
               c1.clickPlusOrders(1, 3);
               c1.clickPlusRemains(1, 3);
               c1.countTotalCash(c1.menu3price);
            }
            c1.countTotalCash(-c1.menu3price);
            c1m3remains.setText(String.valueOf(c1.menu3remains));
            c1m3orders.setText(String.valueOf(c1.menu3orders));
            totalCash1.setText(String.valueOf(c1.getTotalCash()));
         }
      });
      c1m3minus.setFont(new Font("굴림", Font.BOLD, 14));
      c1m3minus.setBounds(445, 390, 47, 33);
      orderPage1.add(c1m3minus);
      
      JLabel lblNewLabel_4 = new JLabel("3000\uC6D0");
      lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 20));
      lblNewLabel_4.setBounds(30, 104, 88, 40);
      orderPage1.add(lblNewLabel_4);
      
      JLabel lblNewLabel_4_1 = new JLabel("3500\uC6D0");
      lblNewLabel_4_1.setFont(new Font("굴림", Font.BOLD, 20));
      lblNewLabel_4_1.setBounds(201, 104, 88, 40);
      orderPage1.add(lblNewLabel_4_1);
      
      JLabel lblNewLabel_4_2 = new JLabel("4000\uC6D0");
      lblNewLabel_4_2.setFont(new Font("굴림", Font.BOLD, 20));
      lblNewLabel_4_2.setBounds(370, 104, 88, 40);
      orderPage1.add(lblNewLabel_4_2);
      
      btnToGoBack.addActionListener(new ActionListener() { // 식당 1 뒤로가기 버튼
         public void actionPerformed(ActionEvent e) {
            orderPage1.setVisible(false);
            selectPage.setVisible(true);
            c1.totalZero();
            c1.setCafeteria(c1.menu1remains+c1.menu1orders, c1.menu2remains+c1.menu2orders, 
                  c1.menu3remains+c1.menu3orders, 0, 0, 0, 
                  c1.menu1price, c1.menu2price, c1.menu3price, c1.cafeteriaName);
            c1m1orders.setText(String.valueOf(c1.menu1orders));
            c1m1remains.setText(String.valueOf(c1.menu1remains));
            c1m2orders.setText(String.valueOf(c1.menu2orders));
            c1m2remains.setText(String.valueOf(c1.menu2remains));
            c1m3orders.setText(String.valueOf(c1.menu3orders));
            c1m3remains.setText(String.valueOf(c1.menu3remains));
            totalCash1.setText(String.valueOf(c1.getTotalCash()));
         }
      });
      
      JPanel orderPage2 = new JPanel();
      orderPage2.setBounds(0, 0, 516, 487);
      contentPane.add(orderPage2);
      orderPage2.setLayout(null);
      orderPage2.setVisible(false);
      
      JLabel c2m1remains = new JLabel("80");
      c2m1remains.setFont(new Font("굴림", Font.BOLD, 15));
      c2m1remains.setBounds(88, 181, 32, 43);
      orderPage2.add(c2m1remains);
      
      JLabel c2m2remains = new JLabel("80");
      c2m2remains.setFont(new Font("굴림", Font.BOLD, 15));
      c2m2remains.setBounds(266, 181, 32, 43);
      orderPage2.add(c2m2remains);
      
      JLabel c2m3remains = new JLabel("80");
      c2m3remains.setFont(new Font("굴림", Font.BOLD, 15));
      c2m3remains.setBounds(436, 181, 32, 43);
      orderPage2.add(c2m3remains);
      
      JLabel c2m1orders = new JLabel("0");
      c2m1orders.setFont(new Font("굴림", Font.BOLD, 30));
      c2m1orders.setBounds(45, 234, 55, 64);
      orderPage2.add(c2m1orders);
      
      JLabel c2m2orders = new JLabel("0");
      c2m2orders.setFont(new Font("굴림", Font.BOLD, 30));
      c2m2orders.setBounds(211, 234, 55, 64);
      orderPage2.add(c2m2orders);
      
      JLabel c2m3orders = new JLabel("0");
      c2m3orders.setFont(new Font("굴림", Font.BOLD, 30));
      c2m3orders.setBounds(386, 234, 55, 64);
      orderPage2.add(c2m3orders);
      
      JLabel totalCash2 = new JLabel("0");
      totalCash2.setFont(new Font("굴림", Font.BOLD, 30));
      totalCash2.setBounds(35, 401, 220, 64);
      orderPage2.add(totalCash2);
      
      JButton btnToGoBack_1_1 = new JButton("\uB4A4\uB85C"); // 식당 2 뒤로가기 버튼
      btnToGoBack_1_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            orderPage2.setVisible(false);
            selectPage.setVisible(true);
            c2.totalZero();
            c2.setCafeteria(c2.menu1remains+c2.menu1orders, c2.menu2remains+c2.menu2orders, 
                  c2.menu3remains+c2.menu3orders, 0, 0, 0, 
                  c2.menu1price, c2.menu2price, c2.menu3price, c2.cafeteriaName);
            c2m1orders.setText(String.valueOf(c2.menu1orders));
            c2m1remains.setText(String.valueOf(c2.menu1remains));
            c2m2orders.setText(String.valueOf(c2.menu2orders));
            c2m2remains.setText(String.valueOf(c2.menu2remains));
            c2m3orders.setText(String.valueOf(c2.menu3orders));
            c2m3remains.setText(String.valueOf(c2.menu3remains));
            totalCash2.setText(String.valueOf(c2.getTotalCash()));
         }
      });
      btnToGoBack_1_1.setBounds(12, 10, 63, 46);
      orderPage2.add(btnToGoBack_1_1);
      
      JLabel lblNewLabel_7_1 = new JLabel("\uC624\uB298\uC758 \uBA54\uB274");
      lblNewLabel_7_1.setFont(new Font("굴림", Font.BOLD, 25));
      lblNewLabel_7_1.setBounds(163, 6, 161, 49);
      orderPage2.add(lblNewLabel_7_1);
      
      JLabel lblNewLabel_8_3 = new JLabel(c2.m1_1);
      lblNewLabel_8_3.setFont(new Font("궁서", Font.BOLD, 25));
      lblNewLabel_8_3.setBounds(45, 66, 94, 37);
      orderPage2.add(lblNewLabel_8_3);
      
      JLabel lblNewLabel_8_4 = new JLabel(c2.m2_1);
      lblNewLabel_8_4.setFont(new Font("궁서", Font.BOLD, 25));
      lblNewLabel_8_4.setBounds(173, 65, 131, 37);
      orderPage2.add(lblNewLabel_8_4);
      
      JLabel lblNewLabel_8_5 = new JLabel(c2.m3_1);
      lblNewLabel_8_5.setFont(new Font("궁서", Font.BOLD, 25));
      lblNewLabel_8_5.setBounds(366, 66, 102, 37);
      orderPage2.add(lblNewLabel_8_5);
      
      JLabel lblNewLabel_9_3 = new JLabel("\uB0A8\uC740 \uC7AC\uACE0\uB7C9 : ");
      lblNewLabel_9_3.setFont(new Font("굴림", Font.BOLD, 12));
      lblNewLabel_9_3.setBounds(12, 181, 76, 43);
      orderPage2.add(lblNewLabel_9_3);
      
      JLabel lblNewLabel_9_4 = new JLabel("\uB0A8\uC740 \uC7AC\uACE0\uB7C9 : ");
      lblNewLabel_9_4.setFont(new Font("굴림", Font.BOLD, 12));
      lblNewLabel_9_4.setBounds(190, 181, 76, 43);
      orderPage2.add(lblNewLabel_9_4);
      
      JLabel lblNewLabel_9_5 = new JLabel("\uB0A8\uC740 \uC7AC\uACE0\uB7C9 : ");
      lblNewLabel_9_5.setFont(new Font("굴림", Font.BOLD, 12));
      lblNewLabel_9_5.setBounds(355, 181, 76, 43);
      orderPage2.add(lblNewLabel_9_5);
      
      
      // 학생회관 버튼 이벤트 처리
      btnToCafeteria1.addActionListener(new ActionListener() { // 식당 1 선택
         public void actionPerformed(ActionEvent e) {
            selectPage.setVisible(false);
            orderPage1.setVisible(true);
         }
      });
      
      // 명진당 버튼 이벤트 처리 
      btnToCafeteria2.addActionListener(new ActionListener() { // 식당 2 선택
         public void actionPerformed(ActionEvent e) {
            selectPage.setVisible(false);
            orderPage2.setVisible(true);
         }
      });
      
      c2m1remains.setText(String.valueOf(c2.menu1remains));
      JButton c2m1plus = new JButton("+");   //식당 2 메뉴 1 플러스
      c2m1plus.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            c2.clickPlusRemains(1, 1);
            c2.clickPlusOrders(1, 1);
            if (c2.menu1remains < 0) {
               c2.clickMinusOrders(1, 1);
               c2.clickMinusRemains(1, 1);
               c2.countTotalCash(-c2.menu1price);
            }
            c2.countTotalCash(c2.menu1price);
            c2m1remains.setText(String.valueOf(c2.menu1remains));
            c2m1orders.setText(String.valueOf(c2.menu1orders));
            totalCash2.setText(String.valueOf(c2.getTotalCash()));
         }
      });
      c2m1plus.setFont(new Font("굴림", Font.BOLD, 14));
      c2m1plus.setBounds(88, 234, 47, 33);
      orderPage2.add(c2m1plus);
      
      c2m2remains.setText(String.valueOf(c2.menu2remains));
      JButton c2m2plus = new JButton("+");   //식당 2 메뉴 2 플러스
      c2m2plus.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            c2.clickPlusRemains(1, 2);
            c2.clickPlusOrders(1, 2);
            if (c2.menu2remains < 0) {
               c2.clickMinusOrders(1, 2);
               c2.clickMinusRemains(1, 2);
               c2.countTotalCash(-c2.menu2price);
            }
            c2.countTotalCash(c2.menu2price);
            c2m2remains.setText(String.valueOf(c2.menu2remains));
            c2m2orders.setText(String.valueOf(c2.menu2orders));
            totalCash2.setText(String.valueOf(c2.getTotalCash()));
         }
      });
      c2m2plus.setFont(new Font("굴림", Font.BOLD, 14));
      c2m2plus.setBounds(251, 234, 47, 33);
      orderPage2.add(c2m2plus);
      
      c2m3remains.setText(String.valueOf(c2.menu3remains));
      JButton c2m3plus = new JButton("+");   //식당 2 메뉴 3 플러스
      c2m3plus.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            c2.clickPlusRemains(1, 3);
            c2.clickPlusOrders(1, 3);
            if (c2.menu3remains < 0) {
               c2.clickMinusOrders(1, 3);
               c2.clickMinusRemains(1, 3);
               c2.countTotalCash(-c2.menu3price);
            }
            c2.countTotalCash(c2.menu3price);
            c2m3remains.setText(String.valueOf(c2.menu3remains));
            c2m3orders.setText(String.valueOf(c2.menu3orders));
            totalCash2.setText(String.valueOf(c2.getTotalCash()));
         }
      });
      c2m3plus.setFont(new Font("굴림", Font.BOLD, 14));
      c2m3plus.setBounds(421, 234, 47, 33);
      orderPage2.add(c2m3plus);
      
      c2m1remains.setText(String.valueOf(c2.menu1remains));
      JButton c2m1minus = new JButton("-");   //식당 2 메뉴 1 마이너스
      c2m1minus.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            c2.clickMinusRemains(1, 1);
            c2.clickMinusOrders(1, 1);
            if (c2.menu1orders < 0) {
               c2.clickPlusOrders(1, 1);
               c2.clickPlusRemains(1, 1);
               c2.countTotalCash(c2.menu1price);
            }
            c2.countTotalCash(-c2.menu1price);
            c2m1remains.setText(String.valueOf(c2.menu1remains));
            c2m1orders.setText(String.valueOf(c2.menu1orders));
            totalCash2.setText(String.valueOf(c2.getTotalCash()));
         }
      });
      c2m1minus.setFont(new Font("굴림", Font.BOLD, 14));
      c2m1minus.setBounds(88, 275, 47, 33);
      orderPage2.add(c2m1minus);
      
      c2m2remains.setText(String.valueOf(c2.menu2remains));
      JButton c2m2minus = new JButton("-");   //식당 2 메뉴 2 마이너스
      c2m2minus.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            c2.clickMinusRemains(1, 2);
            c2.clickMinusOrders(1, 2);
            if (c2.menu2orders < 0) {
               c2.clickPlusOrders(1, 2);
               c2.clickPlusRemains(1, 2);
               c2.countTotalCash(c2.menu2price);
            }
            c2.countTotalCash(-c2.menu2price);
            c2m2remains.setText(String.valueOf(c2.menu2remains));
            c2m2orders.setText(String.valueOf(c2.menu2orders));
            totalCash2.setText(String.valueOf(c2.getTotalCash()));
         }
      });
      c2m2minus.setFont(new Font("굴림", Font.BOLD, 14));
      c2m2minus.setBounds(251, 277, 47, 33);
      orderPage2.add(c2m2minus);
      
      c2m3remains.setText(String.valueOf(c2.menu3remains));
      JButton c2m3minus = new JButton("-");   //식당 2 메뉴 3 마이너스
      c2m3minus.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            c2.clickMinusRemains(1, 3);
            c2.clickMinusOrders(1, 3);
            if (c2.menu3orders < 0) {
               c2.clickPlusOrders(1, 3);
               c2.clickPlusRemains(1, 3);
               c2.countTotalCash(c2.menu3price);
            }
            c2.countTotalCash(-c2.menu3price);
            c2m3remains.setText(String.valueOf(c2.menu3remains));
            c2m3orders.setText(String.valueOf(c2.menu3orders));
            totalCash2.setText(String.valueOf(c2.getTotalCash()));
         }
      });
      c2m3minus.setFont(new Font("굴림", Font.BOLD, 14));
      c2m3minus.setBounds(421, 277, 47, 33);
      orderPage2.add(c2m3minus);
      
      JLabel lblNewLabel_5 = new JLabel("4500\uC6D0");
      lblNewLabel_5.setFont(new Font("굴림", Font.BOLD, 20));
      lblNewLabel_5.setBounds(45, 112, 87, 46);
      orderPage2.add(lblNewLabel_5);
      
      JLabel lblNewLabel_5_1 = new JLabel("4500\uC6D0");
      lblNewLabel_5_1.setFont(new Font("굴림", Font.BOLD, 20));
      lblNewLabel_5_1.setBounds(217, 112, 87, 46);
      orderPage2.add(lblNewLabel_5_1);
      
      JLabel lblNewLabel_5_2 = new JLabel("4500\uC6D0");
      lblNewLabel_5_2.setFont(new Font("굴림", Font.BOLD, 20));
      lblNewLabel_5_2.setBounds(376, 113, 87, 46);
      orderPage2.add(lblNewLabel_5_2);
      
      JFrame frame2 = new JFrame("Order Success");
      JPanel panel2 = new JPanel();
      JLabel lastlabel = new JLabel("주문이 완료되었습니다.");
      
      JButton lastbutton = new JButton("OK");
      
      panel2.add(lastlabel);
      panel2.add(lastbutton);
      frame2.add(panel2);
      
      frame2.setResizable(false);   //프레임 사이즈 변경 가능 여부
      frame2.setVisible(false);      
      frame2.setPreferredSize(new Dimension(300, 800));   
      frame2.setSize(300,80);      
      frame2.setLocationRelativeTo(null);   //실행 시 중간에 위치
      frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      ActionListener listener = new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            
            
            // frame2 : 오더성공 알림창
            frame2.dispose();
            dispose();
         }
         
      };
      lastbutton.addActionListener(listener);
      //////////////////////////////////////////////
      JFrame frame3 = new JFrame("Order Failed");
      JPanel panel3 = new JPanel();
      JLabel lastlabel1 = new JLabel("주문을 하지 않았습니다.");
      
      JButton lastbutton1 = new JButton("OK");
      
      panel3.add(lastlabel1);
      panel3.add(lastbutton1);
      frame3.add(panel3);
      
      frame3.setResizable(false);   //프레임 사이즈 변경 가능 여부
      frame3.setVisible(false);      
      frame3.setPreferredSize(new Dimension(300, 800));   
      frame3.setSize(300,80);      
      frame3.setLocationRelativeTo(null);   //실행 시 중간에 위치
      frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      ActionListener listener1 = new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            
            
            // frame2 : 오더성공 알림창
            frame3.dispose();
         }
         
      };
      lastbutton1.addActionListener(listener1);
      
      JPanel smallpanel = new JPanel();
      smallpanel.setSize(534, 100);
      
      JLabel orderInfo = new JLabel();
      JLabel dateInfo = new JLabel(to);
      JButton noOrderBtn = new JButton("주문 취소");
      Font font = new Font("궁서", Font.BOLD, 15);
      smallpanel.add(dateInfo);
      smallpanel.add(orderInfo);
      smallpanel.add(noOrderBtn);
      
      noOrderBtn.addActionListener(new ActionListener() {	//예약 취소 버튼

  		@Override
  		public void actionPerformed(ActionEvent e) {
  			CheckAll.panel.remove(smallpanel);
  			CheckAll.panel.revalidate();
  			CheckAll.panel.repaint();
  			PaymentHistoryPanel.removeHistory(from);
  			c1.menu1remains += c1.menu1orders;
  			c1.menu2remains += c1.menu2orders;
  			c1.menu3remains += c1.menu3orders;
  			c2.menu1remains += c2.menu1orders;
  			c2.menu2remains += c2.menu2orders;
  			c2.menu3remains += c2.menu3orders;
  			c1.totalPayment -= c1.totalCash;
  			c2.totalPayment -= c2.totalCash;
  		}
      });
      
      JButton orderSuccess1 = new JButton("\uC8FC\uBB38 \uC644\uB8CC"); // 식당 1 주문완료
      orderSuccess1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 if (c1.totalCash == 0) {
        		 System.out.println("주문을 하지 않았습니다.");
        		 frame3.setVisible(true);
        	 }
        	 else {
	            frame2.setVisible(true);
	            System.out.println(to + c1.getName() + c1.getTotalCash() + "원");
	            orderInfo.setText(c1.cafeteriaName + " 백반(" + c1.menu1orders + ") 일품(" + c1.menu2orders + 
	            		") 양식(" + c1.menu3orders + ") 총 액=" + c1.totalCash);
	            
	            orderInfo.setFont(font);
	            CheckAll.panel.add(smallpanel);
	            
	            c1.countTotalPayment(c1.totalCash);
	            PaymentHistoryPanel.HistoryStackPush(c1,from);
        	 }
            
         }
      });
      orderSuccess1.setFont(new Font("굴림", Font.BOLD, 15));
      orderSuccess1.setBounds(305, 447, 211, 40);
      orderPage1.add(orderSuccess1);
      
      JButton orderSuccess2 = new JButton("\uC8FC\uBB38 \uC644\uB8CC"); // 식당 2 주문완료
      orderSuccess2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 if (c2.totalCash == 0) {
        		 System.out.println("주문을 하지 않았습니다.");
        		 frame3.setVisible(true);
        	 }
        	 else {
        		 frame2.setVisible(true);
        		 orderInfo.setText(c2.cafeteriaName + " " + "메뉴1" + "(" + c2.menu1orders + ") " + "메뉴2" + "(" + 
        		 c2.menu2orders + ") " + "메뉴3" + "(" + c2.menu3orders + ") 총 액=" + c2.totalCash);
                 System.out.println(to + "\n" + c2.getName() + c2.getTotalCash() + "원");
                 
                 orderInfo.setFont(font);
 	             CheckAll.panel.add(smallpanel);
        
                 c2.countTotalPayment(c2.totalCash);
                 PaymentHistoryPanel.HistoryStackPush(c2,from);
        	 }
            
         }
      });
   
      orderSuccess2.setFont(new Font("굴림", Font.BOLD, 30));
      orderSuccess2.setBounds(293, 401, 211, 62);
      orderPage2.add(orderSuccess2);
      dispose();
   }
}