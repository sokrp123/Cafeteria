package teamProject;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class mainScreen extends JFrame {
   /**
    * 
    */
   private static final long serialVersionUID = 1L;
   private JPanel contentPane;
         public static void runMainscreen() {
            EventQueue.invokeLater(new Runnable() {
               public void run() {
                  try {
                     mainScreen frame = new mainScreen();
                     frame.setLocationRelativeTo(null);
                     frame.setVisible(true);
                  } catch (Exception e) {
                     e.printStackTrace();
                  }
               }
            });
   }

      public mainScreen() {
         
         PaymentHistory f = new PaymentHistory();
         f.PaymentHistoryMainFrame.setVisible(false);

         Cafeteria c1 = new Cafeteria();
         //                 ���       ,   �ֹ���   ,  ��1����   ��2����  ��3 ���� 
         c1.setCafeteria(80, 80, 80, 0, 0, 0, 3000, 3500, 4000, "�л�ȸ��");
         c1.setMenuName1("�Ұ�⹵��", "�Ѱ���ġ", "��������", "����̹�ħ", 
               "������Ű«��", "����", "�ܹ���", "�����", 
               "������ũ", "���⺺��", "�Ľ�Ÿ", "�����߰��");
         
         Cafeteria c2 = new Cafeteria();
         c2.setCafeteria(80, 80, 80, 0, 0, 0, 4500, 4500, 4500, "������");
         c2.setMenuName2("���", "���Ƕ��̽�", "��������");
         
         CheckAll check = new CheckAll(c1, c2);
         check.frame.setVisible(false);
                  
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setBounds(100, 100, 530, 524);
         contentPane = new JPanel();
         contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
         setContentPane(contentPane);
         contentPane.setLayout(null);
         
         JPanel panel = new JPanel();
         panel.setBounds(0, 0, 516, 487);
         contentPane.add(panel);
         panel.setLayout(null);
         
         JButton modifyInfo = new JButton("ȸ������ ����");
         modifyInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               login3 f3 = new login3();
            }
         });
         modifyInfo.setBounds(373, 10, 131, 29);
         panel.add(modifyInfo);
         
         JButton getOrder = new JButton("�ֹ� / ����");
         getOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               project_GUI.runSelection(c1,c2);
            }
         });
         getOrder.setFont(new Font("����", Font.BOLD, 20));
         getOrder.setBounds(122, 83, 265, 82);
         panel.add(getOrder);
         
         JButton checkOrder = new JButton("�ֹ� Ȯ��");
         checkOrder.setFont(new Font("����", Font.BOLD, 20));
         checkOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
               check.frame.setVisible(true);
            }
         });
         checkOrder.setBounds(122, 224, 265, 82);
         panel.add(checkOrder);
         
         JButton getPaymentDetails = new JButton("���� ���� ����");
         getPaymentDetails.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               f.PaymentHistoryMainFrame.setVisible(true);
            }
         });
         getPaymentDetails.setFont(new Font("����", Font.BOLD, 20));
         getPaymentDetails.setBounds(122, 365, 265, 82);
         panel.add(getPaymentDetails);
      }
}