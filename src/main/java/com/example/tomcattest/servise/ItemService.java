package com.example.tomcattest.servise;

import com.example.tomcattest.model.Item;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ItemService {
    void add(Item item);

    List<Item> getAll();

    void removeById(int id);

    Item getById(int id);

    void updateById(Item item);

    void deleteById(int id);
}
