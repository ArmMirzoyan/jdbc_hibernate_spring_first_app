package com.example.tomcattest.repository.mapper;


import com.example.tomcattest.model.Group;
import com.example.tomcattest.servise.dto.GroupDTO;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class GroupMapperImpl implements GroupMapper {

    private final ItemMapper itemMapper = new ItemMapperImpl(this);

    public GroupMapperImpl() {

    }

    @Override
    public Group mapToGroup(GroupDTO groupDTO) {
        Group group = new Group();
        group.setId(groupDTO.getId());
        group.setName(groupDTO.getName());
        group.setParentGroup(groupDTO.getParentGroup());

        group.setItems(groupDTO.getItems()
                .stream()
                .map(i -> itemMapper.mapToItem(i))
                .collect(Collectors.toList()));

        group.setSubGroups(groupDTO.getGroups()
                .stream()
                .map(this::mapToGroup)
                .collect(Collectors.toList()));
        return group;
    }

    @Override
    public GroupDTO mapToGroupDTO(Group group) {
        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setId(group.getId());
        groupDTO.setName(group.getName());

        groupDTO.setGroups(group.getSubGroups()
                .stream()
                .map(this::mapToGroupDTO)
                .collect(Collectors.toList()));

        groupDTO.setItems(group.getItems()
                .stream()
                .map(itemMapper::mapToItemDTO)
                .collect(Collectors.toList()));
        return groupDTO;
    }
}

