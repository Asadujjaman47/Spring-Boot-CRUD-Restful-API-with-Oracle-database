package com.CURD.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "employees3")
public class Employee {

    @Id
    @GeneratedValue(generator="employee_id_sequence")
    @SequenceGenerator(name="employee_id_sequence",
            sequenceName="employee_id_sequence", allocationSize=1)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email_address", nullable = false)
    private String emailId;

}
