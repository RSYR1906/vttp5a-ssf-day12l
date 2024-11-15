package sg.edu.nus.iss.vttp5a_ssf_day12l.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.vttp5a_ssf_day12l.model.Item;

@Repository
public class ItemRepo {

    private static List<Item> itemList;
    
        public static List<Item> getItems() {
            itemList = new ArrayList<>();

        Item item = new Item("Apple mini", 5);
        itemList.add(item);

        item = new Item("Apple Iphone 16 Pro Max", 15);
        itemList.add(item);

        item = new Item("Prism+ Monitor", 2);
        itemList.add(item);

        item = new Item("Airpods Pro", 10);
        itemList.add(item);

        return itemList;

    }
}
