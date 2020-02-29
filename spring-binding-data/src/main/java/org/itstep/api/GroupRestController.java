package org.itstep.api;

import org.itstep.data.GroupRepository;
import org.itstep.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/api/groups")
@RestController
public class GroupRestController {

    GroupRepository groupRepository;

    @Autowired
    public GroupRestController(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @GetMapping
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Group getOneGroup(@PathVariable int id) {
        return groupRepository.find(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public boolean createGroup(@RequestBody Group group) {
        return groupRepository.save(group) > 0;
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public boolean updateGroup(@PathVariable int id, @RequestBody Group group) {
        if (groupRepository.find(id) == null || group == null)
            return false;
        group.setId(id);
        groupRepository.update(group);
        return true;
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public boolean deleteGroup(@PathVariable int id) {
        System.out.println(id);
        return groupRepository.delete(groupRepository.find(id));
    }

}
