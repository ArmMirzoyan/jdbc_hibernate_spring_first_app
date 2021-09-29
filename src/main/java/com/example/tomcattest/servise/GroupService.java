package com.example.tomcattest.servise;

import com.example.tomcattest.model.Group;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GroupService {
    void add(Group group);

    List<Group> getAll();

    void removeById(int id);

    Group getById(int id);
}
