package com.ecor.reach.spring.template.controllers;

import com.ecor.reach.spring.template.housing.HousingService;
import com.ecor.reach.spring.template.housing.models.Housing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/housing")
public class HousingController {
    private HousingService service;

    @Autowired
    HousingController(HousingService es) {
        this.service = es;
    }

    @PostMapping("/")
    private @ResponseBody String add(@RequestBody Housing newData) {
        return service.add(newData);
    }

    @GetMapping("/{id}")
    private @ResponseBody Housing get(@PathVariable Integer id) {
        return service.get(id);
    }

    @PutMapping("/")
    private @ResponseBody String update(@RequestBody Housing updated) {
        return service.update(updated);
    }

    @DeleteMapping("/{id}")
    private @ResponseBody String delete(@PathVariable Integer id) {
        return service.delete(id);
    }

    @GetMapping("/all")
    private @ResponseBody Iterable<Housing> all() {
        return service.all();
    }

    @GetMapping("/count")
    private @ResponseBody Integer count() {
        return service.count();
    }
}
