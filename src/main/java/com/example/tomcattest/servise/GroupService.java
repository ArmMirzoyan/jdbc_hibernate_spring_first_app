package com.example.tomcattest.servise;

import com.example.tomcattest.servise.dto.GroupDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GroupService {
    GroupDTO save(GroupDTO group);

    List<GroupDTO> getAll();

    void removeById(Long id);

    GroupDTO saveById(Long id);

    GroupDTO updateById(Long id, GroupDTO group);
}
