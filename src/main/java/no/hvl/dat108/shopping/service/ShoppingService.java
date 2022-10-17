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
        // Was considering the use of UUID for the Shoppingitem.id,
        // but couldn't make the delete functionality work with it.
        items.add(new Shoppingitem((int)Math.floor(Math.random()*99999999), name));
    }

    public void deleteShoppingitem(int id) {
        items.removeIf(item -> item.getId() == id);
    }

}
