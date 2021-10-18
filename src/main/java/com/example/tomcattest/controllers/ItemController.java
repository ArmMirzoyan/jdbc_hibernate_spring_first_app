package com.example.tomcattest.controllers;

import com.example.tomcattest.servise.ItemService;
import com.example.tomcattest.servise.dto.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<? extends ItemDTO> getAll(@RequestParam int offset,
                                          @RequestParam int limit,
                                          @RequestParam(required = false) String sortBy) {
        return itemService.getAll(offset, limit, sortBy);
    }

    @GetMapping("/search")
    public List<? extends ItemDTO> search(@RequestParam String name) {
        return itemService.find(name);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDTO> getItem(@PathVariable Long id) {
        return ResponseEntity.of(itemService.getItem(id));
    }

    @PutMapping("/{id}")
    public ItemDTO updateById(@RequestBody ItemDTO itemDTO) {
        return itemService.create(itemDTO);
    }

    @PostMapping
    public @ResponseBody
    ItemDTO create(@RequestBody @Valid ItemDTO itemDTO) {
        return itemService.create(itemDTO);
    }

    @Transactional
    public void deleteById(long id) {
        itemService.delete(id);
    }
}