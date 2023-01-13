//package ui;
package teamProject.ui;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class ReservePanel extends  JPanel{
    public ReservePanel(FoodReserveFrame foodReserveFrame) {
        setLayout(null);

        JButton backBtn = new JButton("뒤로");
        backBtn.setBounds(10, 10, 100, 30);
        backBtn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                foodReserveFrame.setOtherContentPane(0);
            }
        });
        add(backBtn);

        JLabel jLabel = new JLabel("주문을 원하는 식당 선택");
        jLabel.setBounds(120, 10, 150, 30);
        add(jLabel);

        JButton reserveBtn1 = new JButton("예약하기");
        reserveBtn1.setBounds(120, 150, 100, 30);
        reserveBtn1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                foodReserveFrame.setSelectedRestaurant(0);
                foodReserveFrame.setOtherContentPane(3);
            }
        });
        add(reserveBtn1);

        jLabel = new JLabel("식당1");
        jLabel.setBounds(240, 150, 100, 30);
        add(jLabel);

        JButton reserveBtn2 = new JButton("예약하기");
        reserveBtn2.setBounds(120, 250, 100, 30);
        reserveBtn2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                foodReserveFrame.setSelectedRestaurant(1);
                foodReserveFrame.setOtherContentPane(3);
            }
        });
        add(reserveBtn2);

        jLabel = new JLabel("식당2");
        jLabel.setBounds(240, 250, 100, 30);
        add(jLabel);

        JButton reserveBtn3 = new JButton("예약하기");
        reserveBtn3.setBounds(120, 350, 100, 30);
        reserveBtn3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                foodReserveFrame.setSelectedRestaurant(2);
                foodReserveFrame.setOtherContentPane(3);
            }
        });
        add(reserveBtn3);

        jLabel = new JLabel("식당3");
        jLabel.setBounds(240, 350, 100, 30);
        add(jLabel);

    }
}
