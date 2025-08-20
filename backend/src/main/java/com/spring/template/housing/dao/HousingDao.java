package com.ecor.reach.spring.template.housing.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ecor.reach.spring.template.housing.models.Housing;

public interface HousingDao extends CrudRepository<Housing, Integer> {

    /**
     * Gets count of housing records.
     * @return count of housing records
     */
    @Query("SELECT COUNT(*) FROM Housing")
    Integer getCount();
}
