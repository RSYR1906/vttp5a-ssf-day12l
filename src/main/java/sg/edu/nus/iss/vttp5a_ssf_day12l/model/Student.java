package sg.edu.nus.iss.vttp5a_ssf_day12l.model;

import lombok.Data;

@Data
public class Student {

    Integer id;
    String firstName;
    String lastName;
    Long birthDate;
    String email;
    String address;

    public Student(Integer id, String firstName, String lastName, Long birthDate, String email, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.address = address;
    }

}
