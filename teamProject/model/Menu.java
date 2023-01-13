//package model;
package teamProject.model;
import java.util.List;

public class Menu {
    private int stockCnt;
    private List<String> menus;

    public Menu(int stockCnt, List<String> menus) {
        this.stockCnt = stockCnt;
        this.menus = menus;
    }

    public void setStockCnt(int stockCnt) {
        this.stockCnt = stockCnt;
    }

    public void setMenus(List<String> menus) {
        this.menus = menus;
    }

    public int getStockCnt() {
        return stockCnt;
    }

    public List<String> getMenus() {
        return menus;
    }

    public void addStockCnt(int cnt) {
        this.stockCnt += cnt;
    }
}
