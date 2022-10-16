package no.hvl.dat108.shopping.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Shoppingitem {

    private int id;
    private String name;

    public Shoppingitem() {}

    public Shoppingitem(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shoppingitem item = (Shoppingitem) o;
        if (id != item.id) return false;
        return id == item.id;
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

}
