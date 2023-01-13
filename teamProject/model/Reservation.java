//package model;
package teamProject.model;
public class Reservation {
    private int orderId;
    private int restaurantNum;
    private int[] orderCnt;

    public Reservation(int restaurantNum, int[] orderCnt, int orderId) {
        this.restaurantNum = restaurantNum;
        this.orderCnt = orderCnt;
        this.orderId = orderId;
    }

    public int getRestaurantNum() {
        return restaurantNum;
    }

    public void setRestaurantNum(int restaurantNum) {
        this.restaurantNum = restaurantNum;
    }

    public int[] getOrderCnt() {
        return orderCnt;
    }

    public void setOrderCnt(int[] orderCnt) {
        this.orderCnt = orderCnt;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
