package com.example.tomcattest.controllers;


import com.example.tomcattest.model.Item;
import com.example.tomcattest.model.Generactive;
import com.example.tomcattest.servise.GenerativeService;
import com.example.tomcattest.servise.dto.GeneractiveDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/generative")
public class GenerativeController {

    private final GenerativeService generativeService;

    @Autowired
    public GenerativeController(GenerativeService generativeService) {
        this.generativeService = generativeService;
    }

    @GetMapping
    public List<Generactive> getAll() {
        return generativeService.getAll();
    }

    @PostMapping
    public Generactive add(@RequestBody GeneractiveDTO sendedItem) throws JsonProcessingException {
        return generativeService.save(sendedItem);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        generativeService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Item getById(@PathVariable long id) {
        return generativeService.getById(id);
    }

    @PutMapping("/{id}")
    public Generactive updateById(@PathVariable long id, @RequestBody GeneractiveDTO updatedItem) {
        return generativeService.updateById(id, updatedItem);
    }

    @GetMapping("/search")
    public List<Generactive> searchWithMinAndMaxPrices(@RequestParam int priceFrom, @RequestParam int priceTo) {
        return generativeService.getItemsWithPriceFromTo(priceFrom, priceTo);
    }
}
