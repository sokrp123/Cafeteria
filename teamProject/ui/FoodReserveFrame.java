//package ui;
package teamProject.ui;

import teamProject.model.Account;
import teamProject.model.Menu;
import teamProject.model.Reservation;
import teamProject.model.Restaurant;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodReserveFrame extends JFrame {
    private FoodReserveFrame foodReserveFrame;

    private Account nowAccount;
    private Map<String, Account> accounts = new HashMap<>();
    private HashMap<Integer, JPanel> jPanelHashMap = new HashMap<>();
    private List<Restaurant> restaurants = new ArrayList<>();

    private int selectedRestaurant = 0;

    public void removeReservation(int orderId) {
        List<Reservation> reservations = nowAccount.getReservations();
        for (Reservation reservation : reservations) {
            if (reservation.getOrderId() == orderId) {
                reservations.remove(reservation);
                break;
            }
        }
    }

    public int getSelectedRestaurant() {
        return selectedRestaurant;
    }

    public void setSelectedRestaurant(int selectedRestaurant) {
        this.selectedRestaurant = selectedRestaurant;
    }

    public Account getNowAccount() {
        return nowAccount;
    }

    public void setNowAccount(Account nowAccount) {
        this.nowAccount = nowAccount;
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public FoodReserveFrame() {
        super("TradingClient");

        Restaurant restaurant1 = new Restaurant();
        restaurant1.addMenu(new Menu(5, new ArrayList<String>() {
            {
                add("짜장");
               
            }
        }));
        restaurant1.addMenu(new Menu(5, new ArrayList<String>() {
            {
                add("야끼우동");
               
            }
        }));
        restaurant1.addMenu(new Menu(5, new ArrayList<String>() {
            {
                add("짜장면");
                
            }
        }));

        Restaurant restaurant2 = new Restaurant();
        restaurant2.addMenu(new Menu(5, new ArrayList<String>() {
            {
                add("한식1");
               
            }
        }));
        restaurant2.addMenu(new Menu(5, new ArrayList<String>() {
            {
                add("일식1");
               
            }
        }));
        restaurant2.addMenu(new Menu(5, new ArrayList<String>() {
            {
                add("중식1");
             
            }
        }));

        Restaurant restaurant3 = new Restaurant();
        restaurant3.addMenu(new Menu(5, new ArrayList<String>() {
            {
                add("한식1");
                
             
            }
        }));
        restaurant3.addMenu(new Menu(5, new ArrayList<String>() {
            {
                add("일식1");
              
               
            }
        }));
        restaurant3.addMenu(new Menu(5, new ArrayList<String>() {
            {
                add("중식1");
             
            }
        }));
        restaurants.add(restaurant1);
        restaurants.add(restaurant2);
        restaurants.add(restaurant3);

        setLayout(new FlowLayout());
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(520, 600);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        jPanelHashMap.put(0, new LoginPanel(this));
        jPanelHashMap.put(1, new ReservePanel(this));
        jPanelHashMap.put(2, new LoginPanel(this));
        jPanelHashMap.put(3, new MenuPanel(this));
        jPanelHashMap.put(10, new ReserveDetailPanel(this));

        setContentPane(jPanelHashMap.get(0));

        setVisible(true);
    }

    public void setOtherContentPane(int index) {
        if (index == 3) {
            setContentPane(new MenuPanel(this));
        } else if (index == 10) {
            ReserveDetailPanel reserveDetailPanel = new ReserveDetailPanel(this);
            reserveDetailPanel.onShowThisPanel();
            setContentPane(reserveDetailPanel);
        } else {
            setContentPane(jPanelHashMap.get(index));
        }
        revalidate();
    }
}