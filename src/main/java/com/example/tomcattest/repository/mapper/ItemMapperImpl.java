package com.example.tomcattest.repository.mapper;

import com.example.tomcattest.model.Item;
import com.example.tomcattest.servise.dto.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class ItemMapperImpl implements ItemMapper{
    private   GroupMapper groupMapper;
    private ItemMapperImpl() {
    }

    @Autowired
    public ItemMapperImpl(GroupMapper groupMapper) {
        this.groupMapper = groupMapper;
    }

    @Override
    public Item mapToItem(ItemDTO itemDTO) {
        Item item = new Item();
        item.setId(itemDTO.getId());
        item.setCurrency(itemDTO.getCurrency());
        if(itemDTO.getParentDTO()!=null) item.setParentGroup(groupMapper.mapToGroup(itemDTO.getParentDTO()));
        item.setName(itemDTO.getName());
        item.setBasePrice(itemDTO.getBasePrice());
        item.setImageUrl(itemDTO.getImage_url());
        return  item;
    }

    @Override
    public ItemDTO mapToItemDTO(Item item) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(item.getId());
        if(item.getParentGroup()!=null)  itemDTO.setId(item.getParentGroup().getId());
        itemDTO.setCurrency(item.getCurrency());
        itemDTO.setBasePrice(item.getBasePrice());
        itemDTO.setImage_url(item.getImage_url());
        itemDTO.setName(item.getName());
        return itemDTO;

    }
}
