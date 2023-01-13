//package ui;
package teamProject.ui;
import teamProject.layout.WrapLayout;
import teamProject.model.Menu;
import teamProject.model.Reservation;
import teamProject.model.Restaurant;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReserveDetailPanel extends JPanel {
    private JButton backButton;
    private JPanel centerPanel;
    private final Map<Integer, ReserveListPanel> reserveListPanels;
    private FoodReserveFrame foodReserveFrame;

    ReserveDetailPanel(FoodReserveFrame foodReserveFrame) {
        this.foodReserveFrame = foodReserveFrame;
        reserveListPanels = new HashMap<Integer, ReserveListPanel>();
        setLayout(new BorderLayout());
        addTopPanel();
        addCenterPanel();
        backButton.addActionListener(e -> {
            foodReserveFrame.setOtherContentPane(0);
        });
    }

    public void onShowThisPanel() {
        for (Reservation reservation : foodReserveFrame.getNowAccount().getReservations()) {
            addReserveTables(reservation, foodReserveFrame.getRestaurants().get(reservation.getRestaurantNum()));
        }
    }

    private void addTopPanel() {
        JPanel topPanel = new JPanel();
        topPanel.setLayout(null);
        topPanel.setPreferredSize(new Dimension(520, 60));
        backButton = new JButton("뒤로");
        backButton.setBounds(10, 10, 70, 40);
        topPanel.add(backButton);
        JLabel titleLabel = new JLabel("예약 내역", JLabel.CENTER);
        titleLabel.setFont(new Font(titleLabel.getFont().getFontName(), Font.PLAIN, 30));
        titleLabel.setBounds(100, 10, 320, 30);
        topPanel.add(titleLabel);
        add(topPanel, BorderLayout.NORTH);
    }

    JScrollPane jScrollPane;

    private void addCenterPanel() {
        centerPanel = new JPanel();
        centerPanel.setLayout(new WrapLayout());
        jScrollPane = new JScrollPane(centerPanel);
        jScrollPane.getVerticalScrollBar().setUnitIncrement(20);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        add(jScrollPane, BorderLayout.CENTER);
    }

    public void addReserveTables(Reservation reservation, Restaurant restaurant) {
        if (reserveListPanels.containsKey(reservation.getOrderId())) {
            return;
        }
        ReserveListPanel jPanel = new ReserveListPanel(reservation, restaurant, rollbackReservation -> {
            //예약번호 n에 대한 예약제거 처리 필요
            List<Restaurant> restaurantList = foodReserveFrame.getRestaurants();
            Restaurant rollbackRestaurant = restaurantList.get(rollbackReservation.getRestaurantNum());
            List<Menu> rollbackMenus = rollbackRestaurant.getMenus();
            rollbackMenus.get(0).addStockCnt(rollbackReservation.getOrderCnt()[0]);
            rollbackMenus.get(1).addStockCnt(rollbackReservation.getOrderCnt()[1]);
            rollbackMenus.get(2).addStockCnt(rollbackReservation.getOrderCnt()[2]);

            foodReserveFrame.removeReservation(rollbackReservation.getOrderId());
            centerPanel.remove(reserveListPanels.get(rollbackReservation.getOrderId()));//ui에서 제거
            reserveListPanels.remove(rollbackReservation.getOrderId());//ui 관리 리스트에서 제거
            centerPanel.revalidate();
            centerPanel.repaint();
        });
        jPanel.setPreferredSize(new Dimension(480, 150));
        jPanel.setSize(new Dimension(480, 150));
        reserveListPanels.put(reservation.getOrderId(), jPanel);
        centerPanel.add(jPanel);
        centerPanel.revalidate();
    }

}
