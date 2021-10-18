package com.example.tomcattest.servise;

import com.example.tomcattest.model.Item;
import com.example.tomcattest.pagination.MyPageable;
import com.example.tomcattest.repository.ItemRepository;
import com.example.tomcattest.repository.mapper.GroupMapper;
import com.example.tomcattest.repository.mapper.ItemDTOMapper;
import com.example.tomcattest.repository.mapper.ItemMapper;
import com.example.tomcattest.servise.dto.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;
    private ItemMapper itemMapper;
    private GroupMapper groupMapper;

    public ItemServiceImpl() {
    }

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
        this.groupMapper = groupMapper;
    }

    @Override
    @Transactional
    public ItemDTO create(ItemDTO itemDTO) {
        Item entity = itemMapper.mapToItem(itemDTO);
        itemRepository.save(entity);
        return ItemDTOMapper.mapToDTO(entity).orElse(null);
    }

    @Override
    public Item update(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public boolean delete(Long id) {
        if (!itemRepository.existsById(id)) {
            return false;
        }

        itemRepository.deleteById(id);

        return true;
    }

    @Override
    public Optional<ItemDTO> getItem(Long id) {
        Optional<Item> item = itemRepository.findById(id);

        return ItemDTOMapper.mapToDTO(item.orElse(null));
    }

    @Override
    public List<? extends ItemDTO> getAll(int offset, int limit, String sortBy) {
        MyPageable customPageable;
        Sort sort;
        if (sortBy != null) {
            sort = Sort.by(sortBy);
        } else sort = Sort.unsorted();
        customPageable = new MyPageable(offset, limit, sort);
        Page<Item> items = itemRepository.findAll(customPageable);
        return items.getContent()
                .stream()
                .map(i->itemMapper.mapToItemDTO(i))
                .collect(Collectors.toList());
    }

    @Override
    public List<? extends ItemDTO> find(String name) {
        Specification<Item> specification = Specification.where(null);

        return ItemDTOMapper
                .mapToDTOs(itemRepository
                        .find(name, 300));
    }
}