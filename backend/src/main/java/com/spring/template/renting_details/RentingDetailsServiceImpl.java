package com.ecor.reach.spring.template.renting_details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecor.reach.spring.template.renting_details.dao.RentingDetailsDao;
import com.ecor.reach.spring.template.renting_details.models.RentingDetails;

@Service
public class RentingDetailsServiceImpl implements RentingDetailsService {
    @Autowired
    private RentingDetailsDao dao;

    @Override
    public String add(RentingDetails newData) {
        try {
            dao.save(newData);
        } catch (Exception e) {
            return e.getMessage();
        }

        return "Saved";
    }

    @Override
    public RentingDetails get(Integer id) {
        return dao.findById(id).get();
    }

    @Override
    public String update(RentingDetails updated) {
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
    public Iterable<RentingDetails> all() {
        return dao.findAll();
    }

    @Override
    public Integer count() {
        return dao.getCount();
    }
}
