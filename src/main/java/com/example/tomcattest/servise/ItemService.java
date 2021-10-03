package com.example.tomcattest.servise;

import com.example.tomcattest.model.Item;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ItemService {
    ItemDTO create(ItemDTO item);
    Item update(Item item);
    boolean delete(Long id);
    Optional<ItemDTO> getItem(Long id);
    List<? extends ItemDTO> getAll();
    List<? extends ItemDTO> find(String name);
}
