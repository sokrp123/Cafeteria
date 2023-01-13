//package model;
package teamProject.model;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private List<Menu> menus = new ArrayList<>();

    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    public List<Menu> getMenus() {
        return menus;
    }
}
