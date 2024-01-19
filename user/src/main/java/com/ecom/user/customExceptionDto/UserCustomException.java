package com.ecom.user.customExceptionDto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCustomException {

    private String timestamp;
    private int status;
    private String error;
    private String path;


}
