package com.telecom.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "address")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class Address {

    @Id
    private String id;
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;

}
