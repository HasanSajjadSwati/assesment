package com.example.demo.utils;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HttpResponse {
	
    private Date timestamp;
    
    private int status;
    
    private String error;
    
    private String message;
    
    private Object data;
    
    private String path;
    
    public HttpResponse(String requestUri) {
        this.timestamp = DateTimeUtil.currentTimestamp();
        this.path = requestUri;
    }
    public void setStatus(HttpStatus status) {
        this.status = status.value();
        this.message = status.getReasonPhrase();
    }
    

}
