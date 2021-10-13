package com.example.tomcattest.servise;

import com.example.tomcattest.model.Group;
import com.example.tomcattest.repository.GroupRepository;
import com.example.tomcattest.repository.mapper.GroupMapper;
import com.example.tomcattest.servise.dto.GroupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component("groupServiceImpl")
public class GroupServiceImpl implements GroupService {

    private GroupRepository groupRepository;
    private GroupMapper groupMapper;

    public GroupServiceImpl() {

    }

    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository, GroupMapper groupMapper) {
        this.groupRepository = groupRepository;
        this.groupMapper = groupMapper;
    }

    @Transactional
    @Override
    public GroupDTO save(GroupDTO groupDTO) {
        Group group = groupMapper.mapToGroup(groupDTO);
        return groupMapper.mapToGroupDTO(groupRepository.save(group));
    }

    @Transactional
    @Override
    public List<GroupDTO> getAll() {
        return groupRepository.getAll()
                .stream()
                .map(g->groupMapper.mapToGroupDTO(g))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void removeById(Long id) {
        groupRepository.deleteById(id);
    }

    @Transactional
    @Override
    public GroupDTO saveById(Long id) {
        Optional<Group> finded = groupRepository.findById(id);
        return finded.map(group -> groupMapper.mapToGroupDTO(group)).orElse(null);
    }

    @Override
    public GroupDTO updateById(Long id, GroupDTO groupDTO) {
        Optional<Group> finded = groupRepository.findById(id);
        Group group =   groupMapper.mapToGroup( groupDTO);
        groupRepository.save(finded.get());
        return groupMapper.mapToGroupDTO(finded.get());
    }
}
