package com.example.pocio.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class Client extends Person {

    private String clientId;
    private Address address;

    @Builder
    public Client(int age, String name, String lastName, List<Car> cars, String clientId) {
        super(age, name, lastName, cars);
        this.clientId = clientId;
    }

    @Data
    class Address { //inner class
        private String address;

        public void show()
        {
            System.out.println("In a nested class method");
        }
    }

    @Override
    public String getInitials() {
        return this.getName().charAt(0) + ". " + this.getLastName().charAt(0) + "." ;
    }

    public String getFullName2() {
        return super.getFullName();
    }


}
