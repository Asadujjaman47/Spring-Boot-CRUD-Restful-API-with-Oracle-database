package com.CURD.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@Getter
public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;

//    public ErrorDetails(Date timestamp, String message, String details) {
//        super();
//        this.timestamp = timestamp;
//        this.message = message;
//        this.details = details;
//    }
//
//    public Date getTimestamp() {
//        return timestamp;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public String getDetails() {
//        return details;
//    }
}
