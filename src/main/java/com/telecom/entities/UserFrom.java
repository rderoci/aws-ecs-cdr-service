package com.telecom.entities;

import lombok.*;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "user")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@TypeAlias("UserFrom")
public class UserFrom extends User {

    private Address address;

}
