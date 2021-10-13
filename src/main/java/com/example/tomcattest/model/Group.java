package com.example.tomcattest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "group") // table name is "group" for PostgreSQL
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_id_seq")
    @SequenceGenerator(name = "group_id_seq", sequenceName = "group_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parentGroup")
    private List<Item> items = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parentGroup")
    @JsonBackReference
    private Group parentGroup;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "parentGroup")
    @JsonManagedReference
    private List<Group> subGroups = new ArrayList<>();

    public Group() {
    }

    public Group(long id, String name) {
        this.id = id;
        this.name = name;
        this.subGroups = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        this.items.add(item);
        item.setParentGroup(this);
    }

    public void setParentGroup(Group parentGroup) {
        this.parentGroup = parentGroup;
    }

    public Group getParentGroup() {
        return parentGroup;
    }

    public void addSubGroup(Group group) {
        this.subGroups.add(group);
        group.setParentGroup(this);
    }

    public void setSubGroups(List<Group> groups) {
        this.subGroups = groups;
    }

    public List<Group> getSubGroups() {
        return subGroups;
    }

    public void addItems(List<Item> items) {
        for (Item item : items) {
            addItem(item);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return id == group.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentGroup=" + parentGroup +
                ", groups=" + subGroups +
                ", items=" + items +
                '}';
    }
}
