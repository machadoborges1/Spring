package com.hmbn.rest_spring_boot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hmbn.rest_spring_boot.model.Person;
import com.hmbn.rest_spring_boot.services.PersonServices;
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices service;
    ///private PersonServices service = new PersonServices();

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable(value = "id") Long id) {
        return service.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody Person person) {
        return service.create(person);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@RequestBody Person person) {
        return service.update(person);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build(); // retorno 204
    }

    /*
        @RequestMapping(method=RequestMethod.GET,
                produces = MediaType.APPLICATION_JSON_VALUE)
        public List<Person> findAll() {
            return service.findAll();
        }

        @RequestMapping(value = "/{id}",
                method=RequestMethod.GET,
                produces = MediaType.APPLICATION_JSON_VALUE)
        public Person findById(@PathVariable(value = "id") Long id) {
            return service.findById(id);
        }

        @RequestMapping(method=RequestMethod.POST,
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
        public Person create(@RequestBody Person person) {
            return service.create(person);
        }

        @RequestMapping(method=RequestMethod.PUT,
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
        public Person update(@RequestBody Person person) {
            return service.update(person);
        }


        @RequestMapping(value = "/{id}",
                method=RequestMethod.DELETE)
        public void delete(@PathVariable(value = "id") Long id) {
            service.delete(id);
        }
    */
}
