package com.ecor.reach.spring.template.controllers;

import com.ecor.reach.spring.template.renting_details.RentingDetailsService;
import com.ecor.reach.spring.template.renting_details.models.RentingDetails;

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
@RequestMapping(path = "/api/rentingDetails")
public class RentingDetailsController {
    private RentingDetailsService service;

    @Autowired
    RentingDetailsController(RentingDetailsService es) {
        this.service = es;
    }

    @PostMapping("/")
    private String add(@RequestBody RentingDetails newData) {
        return service.add(newData);
    }

    @GetMapping("/{id}")
    private RentingDetails get(@PathVariable Integer id) {
        return service.get(id);
    }

    @PutMapping("/")
    private String update(@RequestBody RentingDetails updated) {
        return service.update(updated);
    }

    @DeleteMapping("/{id}")
    private String delete(@PathVariable Integer id) {
        return service.delete(id);
    }

    @GetMapping("/all")
    private Iterable<RentingDetails> all() {
        return service.all();
    }

    @GetMapping("/count")
    private Integer count() {
        return service.count();
    }
}
