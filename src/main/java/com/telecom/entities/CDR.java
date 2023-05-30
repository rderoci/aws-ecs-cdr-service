package com.telecom.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * CDR = Call Data Record
 */
@Document(collection = "cdr")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CDR {

    @Id
    private String id;
    @NotBlank
    private String msisdnFrom;
    @NotBlank
    private String msisdnTo;
    @NotBlank
    private LocalDate callDate;
    @NotBlank
    private LocalTime callTime;
    private UserFrom userFrom;
    private UserTo userTo;

    public static CDR newInstance(String msisdnFrom,
                                  String msisdnTo,
                                  LocalDate callDate,
                                  LocalTime callTime
                                  ) {
        return new CDR(null,
                        msisdnFrom,
                        msisdnTo,
                        callDate,
                        callTime,
                null,
                null);
    }

}
