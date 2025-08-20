package com.ecor.reach.spring.template.renting_details.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ecor.reach.spring.template.renting_details.models.RentingDetails;

public interface RentingDetailsDao extends CrudRepository<RentingDetails, Integer> {

    /**
     * Gets count of renting details.
     * @return count of renting details
     */
    @Query("SELECT COUNT(*) FROM RentingDetails")
    Integer getCount();
}
