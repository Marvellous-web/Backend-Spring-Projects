package com.stackroute.AuthenticationApp.feignClient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor
public class SignUpData {
    private String emailId,password,name,address;
}
