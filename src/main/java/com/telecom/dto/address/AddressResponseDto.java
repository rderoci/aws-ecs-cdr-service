package com.telecom.dto.address;

public record AddressResponseDto(String street,
                                 String number,
                                 String complement,
                                 String neighborhood,
                                 String city,
                                 String state) {
}
