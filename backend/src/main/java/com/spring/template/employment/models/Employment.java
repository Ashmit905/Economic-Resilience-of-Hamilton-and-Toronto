package com.ecor.reach.spring.template.employment.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Employment {

    @Id
    private Integer id;
    private String cma;
    private Integer duration_unemployment;
    private Integer schooln;

    /**
     * Init RentingDetails object.
     */
    public Employment() { }

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
     * Get the dur unemployed.
     * @return the dur unemployed
     */
    public Integer getDurationUnemployed() {
        return duration_unemployment;
    }

    /**
     * Set the dur unemployed.
     * @param dur_unemployed the dur unemployed
     */
    public void setDurationUnemployed(Integer dur_unemployed) {
        this.duration_unemployment = dur_unemployed;
    }

    /**
     * Get the schooln integer that represents student status. See socs data service page on Sharepoint.
     * @return the schooln
     */
    public Integer getSchoolN() {
        return schooln;
    }

    /**
     * Set the fabled schooln integer.
     * @param schoolNParam the schooln
     */
    public void setSchoolN(Integer schoolNParam) {
        this.schooln = schoolNParam;
    }

}
