package com.telecom.dto.cdr;

import com.telecom.dto.user.UserFromResponseDto;
import com.telecom.dto.user.UserToResponseDto;

import java.time.LocalDateTime;
import java.util.Objects;

public class CDRRequestDto {
    private String id;
    private String msisdnFrom;
    private String msisdnTo;
    private LocalDateTime callDate;
    private UserFromResponseDto userFromResponseDto;
    private UserToResponseDto userToResponseDto;

    public CDRRequestDto(String id,
                         String msisdnFrom,
                         String msisdnTo,
                         LocalDateTime callDate,
                         UserFromResponseDto userFromResponseDto,
                         UserToResponseDto userToResponseDto) {
        this.id = id;
        this.msisdnFrom = msisdnFrom;
        this.msisdnTo = msisdnTo;
        this.callDate = callDate;
        this.userFromResponseDto = userFromResponseDto;
        this.userToResponseDto = userToResponseDto;
    }

    public String id() {
        return id;
    }

    public String msisdnFrom() {
        return msisdnFrom;
    }

    public String msisdnTo() {
        return msisdnTo;
    }

    public LocalDateTime callDate() {
        return callDate;
    }

    public UserFromResponseDto userFromResponseDto() {
        return userFromResponseDto;
    }

    public UserToResponseDto userToResponseDto() {
        return userToResponseDto;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (CDRRequestDto) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.msisdnFrom, that.msisdnFrom) &&
                Objects.equals(this.msisdnTo, that.msisdnTo) &&
                Objects.equals(this.callDate, that.callDate) &&
                Objects.equals(this.userFromResponseDto, that.userFromResponseDto) &&
                Objects.equals(this.userToResponseDto, that.userToResponseDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, msisdnFrom, msisdnTo, callDate, userFromResponseDto, userToResponseDto);
    }

    @Override
    public String toString() {
        return "CDRRequestDto[" +
                "id=" + id + ", " +
                "msisdnFrom=" + msisdnFrom + ", " +
                "msisdnTo=" + msisdnTo + ", " +
                "callDate=" + callDate + ", " +
                "userFromResponseDto=" + userFromResponseDto + ", " +
                "userToResponseDto=" + userToResponseDto + ']';
    }

}
