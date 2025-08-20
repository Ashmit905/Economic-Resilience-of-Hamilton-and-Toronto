package com.ecor.reach.spring.template.housing;

import com.ecor.reach.spring.template.housing.models.Housing;

public interface HousingService {
    /**
     * Adds housing records.
     * @param newData the data to add
     * @return success message
     */
    String add(Housing newData);
    /**
     * Gets a housing record.
     * @param id the ID of the record
     * @return success message
     */
    Housing get(Integer id);
    /**
     * Updates a housing record.
     * @param updated the record to update
     * @return success message
     */
    String update(Housing updated);
    /**
     * Deletes a housing record.
     * @param id the ID to delete
     * @return success message
     */
    String delete(Integer id);
    /**
     * Get all housing records.
     * @return all records
     */
    Iterable<Housing> all();
    /**
     * Get the count of all housing records.
     * @return the count
     */
    Integer count();
}
