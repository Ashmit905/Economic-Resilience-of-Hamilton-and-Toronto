package com.ecor.reach.spring.template.renting_details;

import com.ecor.reach.spring.template.renting_details.models.RentingDetails;

public interface RentingDetailsService {
    /**
     * Adds renting details.
     * @param newData the data to add
     * @return success message
     */
    String add(RentingDetails newData);
    /**
     * Gets renting details.
     * @param id the ID of the details
     * @return success message
     */
    RentingDetails get(Integer id);
    /**
     * Updates renting details.
     * @param updated the details to update
     * @return success message
     */
    String update(RentingDetails updated);
    /**
     * Deletes a renting details.
     * @param id the ID to delete
     * @return success message
     */
    String delete(Integer id);
    /**
     * Get all renting details.
     * @return all renting details
     */
    Iterable<RentingDetails> all();
    /**
     * Get the count of all renting details.
     * @return the count
     */
    Integer count();
}
