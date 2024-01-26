package items;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;


public class Chest implements Iterable<Item> {
    private List<Item> items;

    public Chest(){
        this.items = new ArrayList<Item>();
    }
    
    @Override
    public Iterator<Item> iterator() {
        return items.iterator();
    }
}
