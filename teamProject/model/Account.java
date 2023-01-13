//package model;
package teamProject.model;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private String id;
    private String pw;
    private int[][] orderCnt;
    private List<Reservation> reservations = new ArrayList<>();
    public List<Reservation> getReservations() {
        return reservations;
    }

    public Account(String id, String pw) {
        this.id = id;
        this.pw = pw;
        orderCnt = new int[3][3];
        orderCnt[0] = new int[3];
        orderCnt[1] = new int[3];
        orderCnt[2] = new int[3];
    }

    public int[][] getOrderCnt() {
        return orderCnt;
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public void resetOrderCnt() {
        orderCnt = new int[3][3];
        orderCnt[0] = new int[3];
        orderCnt[1] = new int[3];
        orderCnt[2] = new int[3];
    }
}
