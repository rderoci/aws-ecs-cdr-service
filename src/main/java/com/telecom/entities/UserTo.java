package com.telecom.entities;

import lombok.*;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@Data
@Getter
@Setter
@TypeAlias("UserTo")
public class UserTo extends User {

}
