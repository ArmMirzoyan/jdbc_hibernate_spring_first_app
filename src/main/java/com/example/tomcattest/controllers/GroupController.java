package com.example.tomcattest.controllers;

import com.example.tomcattest.model.Group;
import com.example.tomcattest.servise.GroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping
    public void add(Group group) {
        groupService.add(group);
    }

    @GetMapping
    public List<Group> getAll() {
        return groupService.getAll();
    }

    @DeleteMapping("/{id}")
    public void removeById(int id) {
        groupService.removeById(id);
    }

    @GetMapping("/{id}")
    public Group getById(int id) {
        return groupService.getById(id);
    }
}
