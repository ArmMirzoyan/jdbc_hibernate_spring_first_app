package com.example.tomcattest.repository.mapper;

import com.example.tomcattest.model.Item;
import com.example.tomcattest.servise.dto.ItemDTO;

public interface ItemMapper {
    Item mapToItem(ItemDTO itemDTO);

    ItemDTO mapToItemDTO(Item item);

}
