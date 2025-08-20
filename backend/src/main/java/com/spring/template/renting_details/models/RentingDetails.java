package com.ecor.reach.spring.template.renting_details.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class RentingDetails {
    private Integer year;

    private Integer month;
    private String cma;

    @Id
    private Integer id;

    private Integer is_completed = 0;

    private Integer units_1_5;
    private Integer units_6_19;
    private Integer units_20_49;
    private Integer units_50_99;
    private Integer units_100_199;
    private Integer units_200_plus;

    private Integer structure_1_5;
    private Integer structure_6_19;
    private Integer structure_20_49;
    private Integer structure_50_99;
    private Integer structure_100_199;
    private Integer structure_200_plus;

    private Integer total;

    /**
     * Init RentingDetails object.
     */
    public RentingDetails() { }

    /**
     * Get the year for these renting details.
     * @return the year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * Set the year for these renting details.
     * @param year_param the year
     */
    public void setYear(Integer year_param) {
        this.year = year_param;
    }

    /**
     * Get the month for these renting details.
     * @return the month
     */
    public Integer getMonth() {
        return month;
    }

    /**
     * Set the month for these renting details.
     * @param month_param the month
     */
    public void setMonth(Integer month_param) {
        this.month = month_param;
    }

    /**
     * Get whether this is completed or not.
     * @return 0 false, 1 true
     */
    public Integer getCompletion() {
        return is_completed;
    }

    /**
     * Set whether this is completed or not.
     * @param completion_param 0 false, 1 true
     */
    public void setCompletion(Integer completion_param) {
        this.is_completed = completion_param;
    }

    /**
     * Get the ID.
     * @return the ID
     */
    public Integer getID() {
        return id;
    }

    /**
     * Set the ID.
     * @param id_param the ID
     */
    public void setID(Integer id_param) {
        this.id = id_param;
    }

    /**
     * Get the CMA.
     * @return the CMA
     */
    public String getCMA() {
        return cma;
    }

    /**
     * Set the CMA.
     * @param cma_param the CMA
     */
    public void setCMA(String cma_param) {
        this.cma = cma_param;
    }

    /**
     * Get the total renting details.
     * @return the total renting details
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * Set the total renting details.
     * @param total_param the total renting details
     */
    public void setTotal(Integer total_param) {
        this.total = total_param;
    }

    /**
     * Set the units_1_5.
     * @param units_1_5_param the units_1_5
     */
    public void setUnits_1_5(Integer units_1_5_param) {
        this.units_1_5 = units_1_5_param;
    }

    /**
     * Get the units_1_5.
     * @return the units_1_5
     */
    public Integer getUnits_1_5() {
        return units_1_5;
    }

    /**
     * Set the units_6_19.
     * @param units_6_19_param the units_6_19
     */
    public void setUnits_6_19(Integer units_6_19_param) {
        this.units_6_19 = units_6_19_param;
    }

    /**
     * Get the units_6_19.
     * @return the units_6_19
     */
    public Integer getUnits_6_19() {
        return units_6_19;
    }

    /**
     * Set the units_20_49.
     * @param units_20_49_param the units_20_49
     */
    public void setUnits_20_49(Integer units_20_49_param) {
        this.units_20_49 = units_20_49_param;
    }

    /**
     * Get the units_20_49.
     * @return the units_20_49
     */
    public Integer getUnits_20_49() {
        return units_20_49;
    }

    /**
     * Set the units_50_99.
     * @param units_50_99_param the units_50_99
     */
    public void setUnits_50_99(Integer units_50_99_param) {
        this.units_50_99 = units_50_99_param;
    }

    /**
     * Get the units_50_99.
     * @return the units_50_99
     */
    public Integer getUnits_50_99() {
        return units_50_99;
    }

    /**
     * Set the units_100_199.
     * @param units_100_199_param the units_100_199
     */
    public void setUnits_100_199(Integer units_100_199_param) {
        this.units_100_199 = units_100_199_param;
    }

    /**
     * Get the units_100_199.
     * @return the units_100_199
     */
    public Integer getUnits_100_199() {
        return units_100_199;
    }

    /**
     * Set the units_200_plus.
     * @param units_200_plus_param the units_200_plus
     */
    public void setUnits_200_plus(Integer units_200_plus_param) {
        this.units_200_plus = units_200_plus_param;
    }

    /**
     * Get the units_200_plus.
     * @return the units_200_plus
     */
    public Integer getUnits_200_plus() {
        return units_200_plus;
    }

    // ABOVE UNITS, BELOW STRUCTURE

    /**
     * Set the structure_1_5.
     * @param structure_1_5_param the structure_1_5
     */
    public void setStructure_1_5(Integer structure_1_5_param) {
        this.structure_1_5 = structure_1_5_param;
    }

    /**
     * Get the structure_1_5.
     * @return the structure_1_5
     */
    public Integer getStructure_1_5() {
        return structure_1_5;
    }

    /**
     * Set the structure_6_19.
     * @param structure_6_19_param the structure_6_19
     */
    public void setStructure_6_19(Integer structure_6_19_param) {
        this.structure_6_19 = structure_6_19_param;
    }

    /**
     * Get the structure_6_19.
     * @return the structure_6_19
     */
    public Integer getStructure_6_19() {
        return structure_6_19;
    }

    /**
     * Set the structure_20_49.
     * @param structure_20_49_param the structure_20_49
     */
    public void setStructure_20_49(Integer structure_20_49_param) {
        this.structure_20_49 = structure_20_49_param;
    }

    /**
     * Get the structure_20_49.
     * @return the structure_20_49
     */
    public Integer getStructure_20_49() {
        return structure_20_49;
    }

    /**
     * Set the structure_50_99.
     * @param structure_50_99_param the structure_50_99
     */
    public void setStructure_50_99(Integer structure_50_99_param) {
        this.structure_50_99 = structure_50_99_param;
    }

    /**
     * Get the structure_50_99.
     * @return the structure_50_99
     */
    public Integer getstructure_50_99() {
        return structure_50_99;
    }

    /**
     * Set the structure_100_199.
     * @param structure_100_199_param the structure_100_199
     */
    public void setStructure_100_199(Integer structure_100_199_param) {
        this.structure_100_199 = structure_100_199_param;
    }

    /**
     * Get the structure_100_199.
     * @return the structure_100_199
     */
    public Integer getStructure_100_199() {
        return structure_100_199;
    }

    /**
     * Set the structure_200_plus.
     * @param structure_200_plus_param the structure_200_plus
     */
    public void setStructure_200_plus(Integer structure_200_plus_param) {
        this.structure_200_plus = structure_200_plus_param;
    }

    /**
     * Get the structure_200_plus.
     * @return the structure_200_plus
     */
    public Integer getStructure_200_plus() {
        return structure_200_plus;
    }
}
