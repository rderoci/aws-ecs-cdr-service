package com.telecom.dto.user;

import java.time.LocalDateTime;

/**
 *
 * @param taxId
 * @param firstName
 * @param surname
 * @param birthDate
 */
public record UserToResponseDto(String taxId,
                                String firstName,
                                String surname,
                                String birthDate) {
}
