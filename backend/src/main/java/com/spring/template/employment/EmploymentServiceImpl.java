package com.ecor.reach.spring.template.employment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecor.reach.spring.template.employment.dao.EmploymentDao;
import com.ecor.reach.spring.template.employment.models.Employment;

@Service
public class EmploymentServiceImpl implements EmploymentService {
    @Autowired
    private EmploymentDao dao;

    @Override
    public String add(Employment newData) {
        try {
            dao.save(newData);
        } catch (Exception e) {
            return e.getMessage();
        }

        return "Saved";
    }

    @Override
    public Employment get(Integer id) {
        return dao.findById(id).get();
    }

    @Override
    public String update(Employment updated) {
        try {
            dao.save(updated);
        } catch (Exception exception) {
            return exception.getMessage();
        }
        return "Updated";
    }

    @Override
    public String delete(Integer id) {
        try {
            dao.deleteById(id);
        } catch (Exception exception) {
            return exception.getMessage();
        }
        return "Deleted";
    }

    @Override
    public Iterable<Employment> all() {
        return dao.findAll();
    }

    @Override
    public Integer count() {
        return dao.getCount();
    }
}
