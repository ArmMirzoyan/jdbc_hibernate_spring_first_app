package com.example.tomcattest.repository.mapper;

import com.example.tomcattest.model.Group;
import com.example.tomcattest.servise.dto.GroupDTO;

public interface GroupMapper {
    Group mapToGroup(GroupDTO groupDTO);
    GroupDTO mapToGroupDTO(Group group);
}
