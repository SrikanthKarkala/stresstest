package com.homedepot.stresstest;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Employee {



    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;

    public Employee() {
    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }




    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Employee employee = (Employee) object;
        return java.util.Objects.equals(getFirstName(), employee.getFirstName()) &&
                java.util.Objects.equals(getLastName(), employee.getLastName());
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), getFirstName(), getLastName());
    }



}
