package com.ecor.reach.spring.template.employment.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ecor.reach.spring.template.employment.models.Employment;

public interface EmploymentDao extends CrudRepository<Employment, Integer> {

    /**
     * Gets count of Employment records.
     * @return count of Employment records
     */
    @Query("SELECT COUNT(*) FROM Employment")
    Integer getCount();
}
