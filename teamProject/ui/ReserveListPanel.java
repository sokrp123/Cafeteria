//package ui;
package teamProject.ui;
import teamProject.event.ReserveCancelEvent;
import teamProject.model.Reservation;
import teamProject.model.Restaurant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReserveListPanel extends JPanel {
    public ReserveListPanel(Reservation reservation, Restaurant restaurant, ReserveCancelEvent reserveCancelEvent) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.black));
        JPanel centerPanel = new JPanel();
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        centerPanel.setLayout(new GridLayout(4, 3, 15, 15));

        centerPanel.add(new JLabel("�Ĵ��̸� : ", JLabel.LEFT));
        centerPanel.add(new JLabel("�Ĵ�" + reservation.getRestaurantNum(), JLabel.LEFT));
        centerPanel.add(new JLabel("���� ��ȣ", JLabel.LEFT));

        centerPanel.add(new JLabel("�ѽ� : ", JLabel.LEFT));
        centerPanel.add(new JLabel("(" + reservation.getOrderCnt()[0] + ")" + String.join(", ", restaurant.getMenus().get(0).getMenus()), JLabel.LEFT));
        centerPanel.add(new JLabel(String.valueOf(reservation.getOrderId()), JLabel.LEFT));

        centerPanel.add(new JLabel("�Ͻ� : ", JLabel.LEFT));
        centerPanel.add(new JLabel("(" + reservation.getOrderCnt()[1] + ")" + String.join(", ", restaurant.getMenus().get(1).getMenus()), JLabel.LEFT));
        centerPanel.add(new Container());

        centerPanel.add(new JLabel("��� : ", JLabel.LEFT));
        centerPanel.add(new JLabel("(" + reservation.getOrderCnt()[2] + ")" + String.join(", ", restaurant.getMenus().get(2).getMenus()), JLabel.LEFT));
        JButton cancelButton = new JButton("���� ���");
        centerPanel.add(cancelButton);
        add(centerPanel, BorderLayout.CENTER);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reserveCancelEvent.cancelReserveId(reservation);
            }
        });
    }
}
