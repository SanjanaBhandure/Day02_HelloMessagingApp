package com.greetingapp.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    String firstName;
    String lastName;

    @Override
    public String toString() {
        String str = (firstName != null) ? firstName + " " : "";
        str += (lastName != null) ? lastName : "";
        return str.trim();
    }
}