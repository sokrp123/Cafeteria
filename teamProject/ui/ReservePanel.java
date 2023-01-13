//package ui;
package teamProject.ui;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class ReservePanel extends  JPanel{
    public ReservePanel(FoodReserveFrame foodReserveFrame) {
        setLayout(null);

        JButton backBtn = new JButton("�ڷ�");
        backBtn.setBounds(10, 10, 100, 30);
        backBtn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                foodReserveFrame.setOtherContentPane(0);
            }
        });
        add(backBtn);

        JLabel jLabel = new JLabel("�ֹ��� ���ϴ� �Ĵ� ����");
        jLabel.setBounds(120, 10, 150, 30);
        add(jLabel);

        JButton reserveBtn1 = new JButton("�����ϱ�");
        reserveBtn1.setBounds(120, 150, 100, 30);
        reserveBtn1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                foodReserveFrame.setSelectedRestaurant(0);
                foodReserveFrame.setOtherContentPane(3);
            }
        });
        add(reserveBtn1);

        jLabel = new JLabel("�Ĵ�1");
        jLabel.setBounds(240, 150, 100, 30);
        add(jLabel);

        JButton reserveBtn2 = new JButton("�����ϱ�");
        reserveBtn2.setBounds(120, 250, 100, 30);
        reserveBtn2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                foodReserveFrame.setSelectedRestaurant(1);
                foodReserveFrame.setOtherContentPane(3);
            }
        });
        add(reserveBtn2);

        jLabel = new JLabel("�Ĵ�2");
        jLabel.setBounds(240, 250, 100, 30);
        add(jLabel);

        JButton reserveBtn3 = new JButton("�����ϱ�");
        reserveBtn3.setBounds(120, 350, 100, 30);
        reserveBtn3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                foodReserveFrame.setSelectedRestaurant(2);
                foodReserveFrame.setOtherContentPane(3);
            }
        });
        add(reserveBtn3);

        jLabel = new JLabel("�Ĵ�3");
        jLabel.setBounds(240, 350, 100, 30);
        add(jLabel);

    }
}
