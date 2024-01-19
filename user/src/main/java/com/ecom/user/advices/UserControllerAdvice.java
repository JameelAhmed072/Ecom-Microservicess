package com.ecom.user.advices;

import com.ecom.user.customExceptionDto.UserCustomException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.SimpleDateFormat;
import java.util.Date;

@ControllerAdvice
public class UserControllerAdvice {
    private HttpServletRequest request;
    public UserControllerAdvice(HttpServletRequest request) {
        this.request = request;
    }
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public UserCustomException handle500Exception(Exception e){
        UserCustomException userCustomException  = new UserCustomException();

        userCustomException.setError(e.getMessage());
        userCustomException.setPath(request.getRequestURI());
        userCustomException.setStatus(500);
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.ms.ss").format(new Date());
        userCustomException.setTimestamp(timeStamp);

        return userCustomException;
    }

}
