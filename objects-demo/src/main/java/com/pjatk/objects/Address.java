package com.pjatk.objects;

import java.util.ArrayList;
import java.util.Objects;

public class Address {
    int id;
    String name;
    String postalCode;
    ArrayList<String> addressLines = new ArrayList<>();

    public Address(int id, String name, String postalCode) {
        this.id = id;
        this.name = name;
        this.postalCode = postalCode;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public ArrayList<String> getAddressLines() {
        return addressLines;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id == address.id && Objects.equals(name, address.name) && Objects.equals(postalCode, address.postalCode) && Objects.equals(addressLines, address.addressLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, postalCode, addressLines);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", addressLines=" + addressLines +
                '}';
    }
}
