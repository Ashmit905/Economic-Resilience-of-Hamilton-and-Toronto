package com.ecor.reach.spring.template.housing.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Housing {

    @Id
    private Integer id;
    private Integer year;
    private Integer month;
    private String cma;

    private Integer singles_starts;
    private Integer semis_starts;
    private Integer row_starts;
    private Integer apt_other_starts;

    private Integer singles_complete;
    private Integer semis_complete;
    private Integer row_complete;
    private Integer apt_other_complete;

    /**
     * Init RentingDetails object.
     */
    public Housing() { }

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
     * Get - self explanatory.
     */
    public Integer getSinglesStarts() {
        return singles_starts;
    }

    /**
     * Set - self explanatory.
     * @param toSet to set
     */
    public void setSinglesStarts(Integer toSet) {
        this.singles_starts = toSet;
    }

    /**
     * Get - self explanatory.
     */
    public Integer getSemisStarts() {
        return semis_starts;
    }

    /**
     * Set - self explanatory.
     * @param toSet to set
     */
    public void setSemisStarts(Integer toSet) {
        this.semis_starts = toSet;
    }

    /**
     * Get - self explanatory.
     */
    public Integer getRowStarts() {
        return row_starts;
    }

    /**
     * Set - self explanatory.
     * @param toSet to set
     */
    public void setRowStarts(Integer toSet) {
        this.row_starts = toSet;
    }

    /**
     * Get - self explanatory.
     */
    public Integer getAptOtherStarts() {
        return apt_other_starts;
    }

    /**
     * Set - self explanatory.
     * @param toSet to set
     */
    public void setAptOtherStarts(Integer toSet) {
        this.apt_other_starts = toSet;
    }

    /**
     * Get - self explanatory.
     */
    public Integer getSinglesComplete() {
        return singles_complete;
    }

    /**
     * Set - self explanatory.
     * @param toSet to set
     */
    public void setSinglesComplete(Integer toSet) {
        this.singles_complete = toSet;
    }

    /**
     * Get - self explanatory.
     */
    public Integer getSemisComplete() {
        return semis_complete;
    }

    /**
     * Set - self explanatory.
     * @param toSet to set
     */
    public void setSemisComplete(Integer toSet) {
        this.semis_complete = toSet;
    }

    /**
     * Get - self explanatory.
     */
    public Integer getRowComplete() {
        return row_complete;
    }

    /**
     * Set - self explanatory.
     * @param toSet to set
     */
    public void setRowComplete(Integer toSet) {
        this.row_complete = toSet;
    }

    /**
     * Get - self explanatory.
     */
    public Integer getAptOtherComplete() {
        return apt_other_complete;
    }

    /**
     * Set - self explanatory.
     * @param toSet to set
     */
    public void setAptOtherComplete(Integer toSet) {
        this.apt_other_complete = toSet;
    }

}
