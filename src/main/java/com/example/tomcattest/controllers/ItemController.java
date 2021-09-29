package com.example.tomcattest.controllers;

import com.example.tomcattest.model.Item;
import com.example.tomcattest.servise.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    @PostMapping
    public void add(Item item) {
        itemService.add(item);
    }

    @GetMapping
    public List<Item> getAll() {
        return itemService.getAll();
    }

    @DeleteMapping("/{id}")
    public void removeById(int id) {
        itemService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Item getById(int id) {
        return itemService.getById(id);
    }

    @PutMapping("/{id}")
    public void updateById(Item item) {
        itemService.updateById(item);
    }

    @PostMapping("{/id}")
    public void deleteById(int id) {
        itemService.deleteById(id);
    }

}
