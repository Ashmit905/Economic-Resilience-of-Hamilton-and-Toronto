package com.ecor.reach.spring.template.controllers;

import com.ecor.reach.spring.template.employment.EmploymentService;
import com.ecor.reach.spring.template.employment.models.Employment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/employment")
public class EmploymentController {
    private EmploymentService service;

    @Autowired
    EmploymentController(EmploymentService es) {
        this.service = es;
    }

    /**
     * Add a record.
     * @param newData the record to add
     * @return status
     */
    @PostMapping("/")
    public String add(@RequestBody Employment newData) {
        return service.add(newData);
    }

    /**
     * Get a record.
     * @param id ID of the record to get
     * @return the record
     */
    @GetMapping("/{id}")
    public Employment get(@PathVariable Integer id) {
        return service.get(id);
    }

    /**
     * Update a record.
     * @param updated the record to update
     * @return status
     */
    @PutMapping("/")
    public String update(@RequestBody Employment updated) {
        return service.update(updated);
    }

    /**
     * Delete a record.
     * @param id ID of the record to delete
     * @return status
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        return service.delete(id);
    }

    /**
     * Get all records.
     * @return all records
     */
    @GetMapping("/all")
    public Iterable<Employment> all() {
        return service.all();
    }

    /**
     * Get count of records.
     * @return record count
     */
    @GetMapping("/count")
    public Integer count() {
        return service.count();
    }

    @GetMapping("/schooln/{id}")
    private Integer getSchoolN(@PathVariable Integer id) {
        return service.get(id).getSchoolN();
    }

    @GetMapping("/unemployed/{id}")
    private Integer getDurationUnemployed(@PathVariable Integer id) {
        return service.get(id).getDurationUnemployed();
    }
}
