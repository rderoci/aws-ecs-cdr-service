package com.telecom.dto.cdr;

import com.telecom.dto.user.UserFromResponseDto;
import com.telecom.dto.user.UserToResponseDto;

import java.util.Objects;

public class CDRResponseDto {
    private String msisdnFrom;
    private String msisdnTo;
    private String callDateTime;
    private UserFromResponseDto userFromResponseDto;
    private UserToResponseDto userToResponseDto;

    public CDRResponseDto(String msisdnFrom,
                          String msisdnTo,
                          String callDateTime,
                          UserFromResponseDto userFromResponseDto,
                          UserToResponseDto userToResponseDto) {
        this.msisdnFrom = msisdnFrom;
        this.msisdnTo = msisdnTo;
        this.callDateTime = callDateTime;
        this.userFromResponseDto = userFromResponseDto;
        this.userToResponseDto = userToResponseDto;
    }

    public String msisdnFrom() {
        return msisdnFrom;
    }

    public String msisdnTo() {
        return msisdnTo;
    }

    public String callDateTime() {
        return callDateTime;
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
        var that = (CDRResponseDto) obj;
        return Objects.equals(this.msisdnFrom, that.msisdnFrom) &&
                Objects.equals(this.msisdnTo, that.msisdnTo) &&
                Objects.equals(this.callDateTime, that.callDateTime) &&
                Objects.equals(this.userFromResponseDto, that.userFromResponseDto) &&
                Objects.equals(this.userToResponseDto, that.userToResponseDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(msisdnFrom, msisdnTo, callDateTime, userFromResponseDto, userToResponseDto);
    }

    @Override
    public String toString() {
        return "CDRResponseDto[" +
                "msisdnFrom=" + msisdnFrom + ", " +
                "msisdnTo=" + msisdnTo + ", " +
                "callDateTime=" + callDateTime + ", " +
                "userFromResponseDto=" + userFromResponseDto + ", " +
                "userToResponseDto=" + userToResponseDto + ']';
    }

}
