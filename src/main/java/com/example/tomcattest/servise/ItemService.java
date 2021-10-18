package com.example.tomcattest.servise;

import com.example.tomcattest.model.Item;
import com.example.tomcattest.servise.dto.ItemDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ItemService {
    ItemDTO create(ItemDTO itemDTO);
    Item update(Item item);
    boolean delete(Long id);
    Optional<ItemDTO> getItem(Long id);
    List<? extends ItemDTO> getAll(int offset, int limit , String sortBy);
    List<? extends ItemDTO> find(String name);
}
