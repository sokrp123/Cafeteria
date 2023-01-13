//package ui;
package teamProject.ui;
import teamProject.model.Reservation;
import teamProject.model.Restaurant;
import teamProject.model.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class MenuPanel extends JPanel {
    private static int orderId = 1;
    private JLabel[] stocks = {new JLabel("0"), new JLabel("0"), new JLabel("0")};
    private JLabel[] orders = {new JLabel("0"), new JLabel("0"), new JLabel("0")};
    private JLabel total;

    public MenuPanel(FoodReserveFrame foodReserveFrame) {
        setLayout(null);

        JButton backBtn = new JButton("뒤로");
        backBtn.setBounds(10, 10, 100, 30);
        backBtn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] orderCnt = foodReserveFrame.getNowAccount().getOrderCnt()[foodReserveFrame.getSelectedRestaurant()];
                if(orderCnt[0] == 0 && orderCnt[1] == 0 && orderCnt[2] ==0) {
                    foodReserveFrame.setOtherContentPane(1);
                    return;
                }
                foodReserveFrame.getNowAccount().getReservations().add(new Reservation(foodReserveFrame.getSelectedRestaurant(), orderCnt, orderId++));
                foodReserveFrame.getNowAccount().resetOrderCnt();
                foodReserveFrame.setOtherContentPane(1);
            }
        });
        add(backBtn);

        JLabel jLabel = new JLabel("오늘의 메뉴");
        jLabel.setBounds(250, 10, 150, 30);
        add(jLabel);

        jLabel = new JLabel("한식");
        jLabel.setBounds(100, 100, 50, 30);
        add(jLabel);

        jLabel = new JLabel("일식");
        jLabel.setBounds(250, 100, 50, 30);
        add(jLabel);

        jLabel = new JLabel("양식");
        jLabel.setBounds(400, 100, 50, 30);
        add(jLabel);

        List<Restaurant> restaurantList = foodReserveFrame.getRestaurants();

        int[] orderCnt;
        if (foodReserveFrame.getNowAccount() == null) {
            orderCnt = new int[]{0, 0, 0};
        } else {
            orderCnt = foodReserveFrame.getNowAccount().getOrderCnt()[foodReserveFrame.getSelectedRestaurant()];
        }

        Restaurant restaurant = restaurantList.get(foodReserveFrame.getSelectedRestaurant());
        int i = 0;
        for (Menu menu : restaurant.getMenus()) {
            int j = 0;
            for (String menuStr : menu.getMenus()) {
                jLabel = new JLabel(menuStr);
                jLabel.setBounds(100 + 150 * i, 140 + 20 * j, 50, 30);
                add(jLabel);
                j++;
            }
            jLabel = new JLabel("남은 재고량 : ");
            jLabel.setBounds(70 + 150 * i, 340, 100, 30);
            add(jLabel);

            stocks[i].setText(String.valueOf(menu.getStockCnt()));
            stocks[i].setBounds(150 + 150 * i, 340, 50, 30);
            add(stocks[i]);

            jLabel = new JLabel("주문 : ");
            jLabel.setBounds(70 + 150 * i, 390, 100, 30);
            add(jLabel);

            orders[i].setText(String.valueOf(orderCnt[i]));
            orders[i].setBounds(110 + 150 * i, 390, 50, 30);
            add(orders[i]);
            i++;
        }

        JButton pButton1 = new JButton("+");
        pButton1.setBounds(140, 370, 50, 30);
        pButton1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = 0;
                int[] orderCnt = foodReserveFrame.getNowAccount().getOrderCnt()[foodReserveFrame.getSelectedRestaurant()];
                Menu menu = restaurantList.get(foodReserveFrame.getSelectedRestaurant()).getMenus().get(index);
                int stockCount = menu.getStockCnt();
                if (orderCnt[index] < 4 && stockCount > 0) {
                    menu.setStockCnt(stockCount - 1);
                    stocks[index].setText(String.valueOf(stockCount - 1));
                    orders[index].setText(String.valueOf(++orderCnt[index]));
                    total.setText(String.format("총 주문 : 한식 %d개, 일식 %d개, 중식 %d개", orderCnt[0], orderCnt[1], orderCnt[2]));
                }
            }
        });
        add(pButton1);

        JButton mButton1 = new JButton("-");
        mButton1.setBounds(140, 410, 50, 30);
        mButton1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = 0;
                int[] orderCnt = foodReserveFrame.getNowAccount().getOrderCnt()[foodReserveFrame.getSelectedRestaurant()];
                if (orderCnt[index] > 0) {
                    Menu menu = restaurantList.get(foodReserveFrame.getSelectedRestaurant()).getMenus().get(index);
                    int stockCount = menu.getStockCnt();
                    menu.setStockCnt(stockCount + 1);
                    stocks[index].setText(String.valueOf(stockCount + 1));
                    orders[index].setText(String.valueOf(--orderCnt[index]));

                    total.setText(String.format("총 주문 : 한식 %d개, 일식 %d개, 중식 %d개", orderCnt[0], orderCnt[1], orderCnt[2]));
                }
            }
        });
        add(mButton1);

        JButton pButton2 = new JButton("+");
        pButton2.setBounds(290, 370, 50, 30);
        pButton2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = 1;
                int[] orderCnt = foodReserveFrame.getNowAccount().getOrderCnt()[foodReserveFrame.getSelectedRestaurant()];
                Menu menu = restaurantList.get(foodReserveFrame.getSelectedRestaurant()).getMenus().get(index);
                int stockCount = menu.getStockCnt();
                if (orderCnt[index] < 4 && stockCount > 0) {
                    menu.setStockCnt(stockCount - 1);
                    stocks[index].setText(String.valueOf(stockCount - 1));
                    orders[index].setText(String.valueOf(++orderCnt[index]));
                    total.setText(String.format("총 주문 : 한식 %d개, 일식 %d개, 중식 %d개", orderCnt[0], orderCnt[1], orderCnt[2]));
                }
            }
        });
        add(pButton2);

        JButton mButton2 = new JButton("-");
        mButton2.setBounds(290, 410, 50, 30);
        mButton2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = 1;
                int[] orderCnt = foodReserveFrame.getNowAccount().getOrderCnt()[foodReserveFrame.getSelectedRestaurant()];
                if (orderCnt[index] > 0) {
                    Menu menu = restaurantList.get(foodReserveFrame.getSelectedRestaurant()).getMenus().get(index);
                    int stockCount = menu.getStockCnt();
                    menu.setStockCnt(stockCount + 1);
                    stocks[index].setText(String.valueOf(stockCount + 1));
                    orders[index].setText(String.valueOf(--orderCnt[index]));

                    total.setText(String.format("총 주문 : 한식 %d개, 일식 %d개, 중식 %d개", orderCnt[0], orderCnt[1], orderCnt[2]));
                }
            }
        });
        add(mButton2);

        JButton pButton3 = new JButton("+");
        pButton3.setBounds(440, 370, 50, 30);
        pButton3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = 2;
                int[] orderCnt = foodReserveFrame.getNowAccount().getOrderCnt()[foodReserveFrame.getSelectedRestaurant()];
                Menu menu = restaurantList.get(foodReserveFrame.getSelectedRestaurant()).getMenus().get(index);
                int stockCount = menu.getStockCnt();
                if (orderCnt[index] < 4 && stockCount > 0) {
                    menu.setStockCnt(stockCount - 1);
                    stocks[index].setText(String.valueOf(stockCount - 1));
                    orders[index].setText(String.valueOf(++orderCnt[index]));
                    total.setText(String.format("총 주문 : 한식 %d개, 일식 %d개, 중식 %d개", orderCnt[0], orderCnt[1], orderCnt[2]));
                }
            }
        });
        add(pButton3);

        JButton mButton3 = new JButton("-");
        mButton3.setBounds(440, 410, 50, 30);
        mButton3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = 2;
                int[] orderCnt = foodReserveFrame.getNowAccount().getOrderCnt()[foodReserveFrame.getSelectedRestaurant()];
                if (orderCnt[index] > 0) {
                    Menu menu = restaurantList.get(foodReserveFrame.getSelectedRestaurant()).getMenus().get(index);
                    int stockCount = menu.getStockCnt();
                    menu.setStockCnt(stockCount + 1);
                    stocks[index].setText(String.valueOf(stockCount + 1));
                    orders[index].setText(String.valueOf(--orderCnt[index]));

                    total.setText(String.format("총 주문 : 한식 %d개, 일식 %d개, 중식 %d개", orderCnt[0], orderCnt[1], orderCnt[2]));
                }
            }
        });
        add(mButton3);

        total = new JLabel(String.format("총 주문 : 한식 %d개, 일식 %d개, 중식 %d개", orderCnt[0], orderCnt[1], orderCnt[2]));
        total.setBounds(150, 460, 400, 30);
        add(total);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.drawRect(65, 140 , 100, 200);
        g.drawRect(215, 140 , 100, 200);
        g.drawRect(365, 140 , 100, 200);
    }
}

