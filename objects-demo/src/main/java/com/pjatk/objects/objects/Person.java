package com.pjatk.objects;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Person {
        String name;
        int id;
        LocalDate dateOfBirth;
        ArrayList<Address> addresses = new ArrayList<>();

        public Person(int id, String name, LocalDate dateOfBirth) {
            this.id = id;
            this.name = name;
            this.dateOfBirth = dateOfBirth;
        }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public ArrayList<Address> getAddresses() {
        return addresses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String toString() {
        return String.format("(%d, %s, %s)", id, name, dateOfBirth);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name) && Objects.equals(dateOfBirth, person.dateOfBirth) && Objects.equals(addresses, person.addresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dateOfBirth, addresses);
    }



    public Person copy() {
        Person copy = new Person(this.id, this.name, this.dateOfBirth);
        for (Address address : this.addresses) {
            Address addressCopy = new Address(address.getId(), address.getName(), address.getPostalCode());
            addressCopy.getAddressLines().addAll(address.getAddressLines());
            copy.getAddresses().add(addressCopy);
        }
        return copy;
    }
}


