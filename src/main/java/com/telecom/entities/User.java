package com.telecom.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Document(collection = "user")
@Data
@Getter
@Setter
@EqualsAndHashCode(exclude = {"gender", "birthDate"})
public class User {

    protected enum Gender {
        MALE("m"),
        FEMALE("f"),
        OTHER("o");
        private String symbol;

        Gender(String symbol) {
            this.symbol = symbol;
        }

        public String getSymbol() {
            return symbol;
        }
    }

    @Id
    private String id;
    @NotBlank
    private String taxId;
    @Indexed
    @NotBlank
    private String msisdn;
    @NotBlank
    private String firstName;
    @NotBlank
    private String surname;
    private Gender gender;
    private LocalDate birthDate;

    public User() {}

    public User(String firstName, String surname, Gender gender, LocalDate birthDate) {
        this.firstName = firstName;
        this.surname = surname;
        this.gender = gender;
        this.birthDate = birthDate;
    }

}
