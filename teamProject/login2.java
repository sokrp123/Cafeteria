package teamProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.swing.*;
import java.awt.*;

public class login2 extends JFrame {//ȸ������ȭ��
	public login2(){
		  	JPanel p = new JPanel();
		  	Label l1= new Label("�̸�");	
	        Label l2 = new Label("���̵�(�й�)");
	        Label l3= new Label("�н�����");
	        add(l1);
	        add(l2);
	        add(l3);
	        TextField t1 = new TextField();
	        TextField t2 = new TextField();
	        TextField t3 = new TextField();
	        add(t1);
	        add(t2);
	        add(t3);
	        t3.setEchoChar('*');
	        JButton j1 = new JButton("����");
	        JButton j2 = new JButton("���");
	        add(j1);
	        add(j2);
	        l1.setBounds(40, 10, 40, 40);
	        l2.setBounds(40, 50, 70, 40);
	        l3.setBounds(40,90,60,40);
	        t1.setBounds(120, 10, 200, 30);
	        t2.setBounds(120, 50, 200, 30);
	        t3.setBounds(120, 90, 200, 30);
	        j1.setBounds(125, 330, 80, 30);
	        j2.setBounds(240, 330, 80, 30); 
	    add(p);
		setSize(500,500);
		setTitle("ȸ������");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setVisible(true);
       j1.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent T) {//ȸ������ ������ ����
			try{
				BufferedWriter buf = new BufferedWriter(new FileWriter("ȸ�����.txt",true));
				buf.write(t1.getText()+"/");
				buf.write(t2.getText()+"/");
				buf.write(t3.getText()+"\n");
				buf.close();
				JOptionPane.showMessageDialog(null, "ȸ�������� �����մϴ�!!");
				dispose();
			}catch (Exception ex){
				JOptionPane.showMessageDialog(null, "ȸ�����Կ� �����Ͽ����ϴ�.");
			}
		}
	});
       j2.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
       });
	}    
}