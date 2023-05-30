package com.telecom.dto.mapper;

import com.telecom.dto.address.AddressResponseDto;
import com.telecom.dto.cdr.CDRRequestDto;
import com.telecom.dto.cdr.CDRResponseDto;
import com.telecom.dto.user.UserFromResponseDto;
import com.telecom.dto.user.UserToResponseDto;
import com.telecom.entities.CDR;
import org.mapstruct.Mapper;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public abstract class CDRResponseMapper {

    SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat sdfDateTime = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public CDRResponseDto toDto(CDR cdr) {
        AddressResponseDto addressResponseDTO = null;
        if (cdr.getUserFrom().getAddress() != null) {
            addressResponseDTO = new AddressResponseDto(
                    cdr.getUserFrom().getAddress().getStreet(),
                    cdr.getUserFrom().getAddress().getNumber(),
                    cdr.getUserFrom().getAddress().getComplement(),
                    cdr.getUserFrom().getAddress().getNeighborhood(),
                    cdr.getUserFrom().getAddress().getCity(),
                    cdr.getUserFrom().getAddress().getState()
            );
        }

        UserFromResponseDto userFromResponseDto = null;
        if(cdr.getUserFrom() != null) {
            userFromResponseDto = new UserFromResponseDto(
                    cdr.getUserFrom().getTaxId(),
                    cdr.getUserFrom().getFirstName(),
                    cdr.getUserFrom().getSurname(),
                    sdfDate.format(cdr.getUserFrom().getBirthDate()),
                    addressResponseDTO
            );
        }

        UserToResponseDto userToResponseDto = null;
        if(cdr.getUserTo() != null) {
            userToResponseDto = new UserToResponseDto(
                    cdr.getUserTo().getTaxId(),
                    cdr.getUserTo().getFirstName(),
                    cdr.getUserTo().getSurname(),
                    sdfDate.format(cdr.getUserFrom().getBirthDate())
            );
        }

        CDRResponseDto dto = new CDRResponseDto(
                cdr.getMsisdnFrom(),
                cdr.getMsisdnTo(),
                sdfDateTime.format(LocalDateTime.of(cdr.getCallDate(), cdr.getCallTime())),
                userFromResponseDto,
                userToResponseDto
        );

        return dto;
    }

}
