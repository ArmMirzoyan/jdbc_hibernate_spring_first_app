package com.example.tomcattest.mock;

import com.example.tomcattest.model.Generactive;
import com.example.tomcattest.model.Item;
import com.example.tomcattest.model.StockItem;
import com.example.tomcattest.util.idgenerator.IdGenerator;
import com.example.tomcattest.util.idgenerator.Type;
import com.example.tomcattest.util.namegenerator.Casing;
import com.example.tomcattest.util.namegenerator.NameGen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class ItemMock {

    private static final NameGen NAME_GEN = NameGen.start()
            .withSeparator(" ")
            .withCasing(Casing.CAPITALIZE)
            .adjective()
            .noun();

    public static Item getItem(Class<? extends Item> clazz) {
        Item item;
        if (clazz == Generactive.class) {
            item = new Generactive(IdGenerator.getNext(Type.GROUP),
                    generateRandomPrice(), NAME_GEN.get());
        } else {
            item =  new StockItem(IdGenerator.getNext(Type.GROUP),
                    generateRandomPrice(), NAME_GEN.get());
        }

        return item;
    }

    public static List<Item> getItems(int count) {
        List<Item> rv = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            rv.add(getItem(i % 2 == 0 ? Generactive.class : StockItem.class));
        }

        return rv;
    }

    private static int generateRandomPrice() {
        return new Random().nextInt(8) * 100;
    }

    private ItemMock() {

    }
}
