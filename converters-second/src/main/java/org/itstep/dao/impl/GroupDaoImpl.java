package org.itstep.dao.impl;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.itstep.dao.AbstractDao;
import org.itstep.dao.GroupDao;
import org.itstep.model.Groups;
import org.itstep.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class GroupDaoImpl extends AbstractDao<Groups, Integer> implements GroupDao {

    protected GroupDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory, Groups.class);
    }


//    final SessionFactory sessionFactory;
//
//    @Autowired
//    public GroupDaoImpl(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    @Override
//    public Integer save(String data) {
//
//        return null;
//    }
//
//    @Override
//    public void update(String data) {
//
//    }
//
//    @Override
//    public boolean delete(String data) {
//
//        return false;
//    }
//
//    @Override
//    public List<String> findAll() {
//        List<String> groups = null;
//        try (Session session = sessionFactory.openSession()) {
//            log.debug("Session opened");
//            groups = session.createQuery("select s.group from Student s", String.class).getResultList();
//            log.debug("Query by id");
//        } catch (Exception ex) {
//            log.error(ex.getLocalizedMessage(), ex);
//        }
//        return groups;
//    }
//
//    @Override
//    public String getOne(Integer integer) {
//
//        return null;
//    }
//
//    @Override
//    public boolean deleteById(Integer integer) {
//        return false;
//    }
}
