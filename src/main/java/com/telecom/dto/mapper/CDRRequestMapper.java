package com.telecom.dto.mapper;

import com.telecom.dto.cdr.CDRRequestDto;
import com.telecom.entities.CDR;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CDRRequestMapper {

    public CDR toEntity(CDRRequestDto dto) {
        return CDR.newInstance( dto.msisdnFrom(),
                                dto.msisdnTo(),
                                dto.callDate().toLocalDate(),
                                dto.callDate().toLocalTime());
    }

}
