package no.hvl.dat108.shopping.service;

import no.hvl.dat108.shopping.model.Shoppingitem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingService {

    private static List<Shoppingitem> items = new ArrayList<>();

    static {
        items.add(new Shoppingitem(1, "Melk"));
        items.add(new Shoppingitem(2, "Brød"));
        items.add(new Shoppingitem(3, "Syltetøy"));
    }

    public List<Shoppingitem> retrieveShoppingitems() { return items; }

    public void addShoppingitem(String name) {
        items.add(new Shoppingitem(items.size() + 1, name));
    }

    public void deleteShoppingitem(int id) {
        items.removeIf(item -> item.getId() == id);
    }

    public Shoppingitem getItem(int id) {
        Shoppingitem itemToGet = null;
        for(Shoppingitem item : items) {
            if (item.getId() == id) itemToGet = item; break;
        }
        return itemToGet;
    }
}
