package com.telecom.dto.user;

import com.telecom.dto.address.AddressResponseDto;

/**
 * This Record represents the User from which a call was originated by the Operator "RomuloRocha Telecom".
 * In this case we will have the information regard user Address
 * @param taxId
 * @param firstName
 * @param surname
 * @param birthDate
 * @param addressResponseDTO
 */
public record UserFromResponseDto(String taxId,
                                  String firstName,
                                  String surname,
                                  String birthDate,
                                  AddressResponseDto addressResponseDTO) {
}
