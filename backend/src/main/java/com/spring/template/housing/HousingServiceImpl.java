package com.ecor.reach.spring.template.housing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecor.reach.spring.template.housing.dao.HousingDao;
import com.ecor.reach.spring.template.housing.models.Housing;

@Service
public class HousingServiceImpl implements HousingService {
    @Autowired
    private HousingDao dao;

    @Override
    public String add(Housing newData) {
        try {
            dao.save(newData);
        } catch (Exception e) {
            return e.getMessage();
        }

        return "Saved";
    }

    @Override
    public Housing get(Integer id) {
        return dao.findById(id).get();
    }

    @Override
    public String update(Housing updated) {
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
    public Iterable<Housing> all() {
        return dao.findAll();
    }

    @Override
    public Integer count() {
        return dao.getCount();
    }
}
