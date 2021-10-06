package com.example.tomcattest.servise.dto;

import com.example.tomcattest.model.Group;

import java.util.List;
import java.util.Objects;

public class GroupDTO {
    private Long id;
    private String name;
    private Group parentGroup;
    private List<ItemDTO> items;
    private List<GroupDTO> groups;

    public GroupDTO() {
    }

    public GroupDTO(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGroups(List<GroupDTO> groups) {
        this.groups = groups;
    }

    public List<GroupDTO> getGroups() {
        return groups;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setParentGroup(Group parentGroup) {
        this.parentGroup = parentGroup;
    }

    public Group getParentGroup() {
        return parentGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupDTO groupDTO = (GroupDTO) o;
        return Objects.equals(id, groupDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "GroupDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", GroupName='" + parentGroup + '\'' +
                '}';
    }
}

