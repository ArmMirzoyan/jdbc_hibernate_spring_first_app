package com.example.tomcattest.controllers;

import com.example.tomcattest.servise.GroupService;
import com.example.tomcattest.servise.dto.GroupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {
    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping
    public GroupDTO save(@RequestBody GroupDTO group) {
        return groupService.save(group);
    }

    @GetMapping
    public List<GroupDTO> getAll() {
        return groupService.getAll();
    }

    @PutMapping("/{id}")
    public GroupDTO updateById(@PathVariable Long id, @RequestBody GroupDTO updatedGroup) {
        return groupService.updateById(id, updatedGroup);
    }

    @DeleteMapping("/{id}")
    public void removeById(Long id) {
        groupService.removeById(id);
    }

    @GetMapping("/{id}")
    public GroupDTO getById(Long id) {
        return groupService.saveById(id);
    }
}
