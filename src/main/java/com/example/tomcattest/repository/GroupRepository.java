package com.example.tomcattest.repository;

import com.example.tomcattest.model.Group;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GroupRepository {

    private final SessionFactory sessionFactory;

    private GroupRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public Optional<Group> getGroup(long groupId) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        // Hibernate query to get group by id
        // equivalent sql query: select * from group where id = ?;
        // equivalent JPQL query: select i from Group i where id = :id;
        // Group is the name of the Entity defined by @Entity annotation
        Query<Group> query = session.createQuery(
                "select g from Group g" +
                        " where g.id = :id ",
                Group.class);
        query.setParameter("id", groupId);
        // Execute the query and get single result
        Group group = query.getSingleResult();

        transaction.commit();
        session.close();

        return Optional.ofNullable(group);
    }

    private static GroupRepository sInstance;

    private final List<Group> groups = new ArrayList<>();

    public void addGroup(Group group) {
        this.groups.add(group);
    }

    public void addGroupAll(List<Group> groups) {
        this.groups.addAll(groups);
    }

    public Group findGroupById(int groupId) {
        for (Group group : groups) {
            if (group.getId() == groupId) {
                return group;
            }
        }

        return null;
    }

    public List<Group> getGroupsHierarchy() {
        List<Group> rootGroups = new ArrayList<>();

        for (Group group : groups) {
            if (group.getParentGroup() == null) {
                rootGroups.add(group);
            }
        }

        return rootGroups;
    }

}
