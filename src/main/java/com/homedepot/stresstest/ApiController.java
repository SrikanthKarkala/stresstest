package com.homedepot.stresstest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getEmployees(){

        return employeeRepository.findAll();
    }


    @GetMapping("/employees/{id}")
    public Employee retrieveEmployee(@PathVariable Long id){

       Optional<Employee> employee = employeeRepository.findById(id);
       if(!employee.isPresent()){
           System.out.print("ID - "+id);
       }
       return employee.get();

    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable Long id){

        Optional<Employee> employee = employeeRepository.findById(id);
        if(!employee.isPresent()){
            System.out.print("ID - "+id);
        }

        employeeRepository.deleteById(id);
    }


    @PostMapping("/employees")
    public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeRepository.save(employee);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedEmployee.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee, @PathVariable long id) {

        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        if (!employeeOptional.isPresent())
            return ResponseEntity.notFound().build();

        employee.setId(id);

        employeeRepository.save(employee);

        return ResponseEntity.noContent().build();
    }



}

