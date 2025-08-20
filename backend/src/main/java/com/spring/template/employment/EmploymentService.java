package com.ecor.reach.spring.template.employment;

import com.ecor.reach.spring.template.employment.models.Employment;

public interface EmploymentService {
    /**
     * Adds Employment records.
     * @param newData the data to add
     * @return success message
     */
    String add(Employment newData);
    /**
     * Gets a Employment record.
     * @param id the ID of the record
     * @return success message
     */
    Employment get(Integer id);
    /**
     * Updates a Employment record.
     * @param updated the record to update
     * @return success message
     */
    String update(Employment updated);
    /**
     * Deletes a Employment record.
     * @param id the ID to delete
     * @return success message
     */
    String delete(Integer id);
    /**
     * Get all Employment records.
     * @return all records
     */
    Iterable<Employment> all();
    /**
     * Get the count of all Employment records.
     * @return the count
     */
    Integer count();
}
