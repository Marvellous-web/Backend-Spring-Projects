package com.stackroute.AuthenticationApp.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "Movie-App", url = "localhost:8091")
public interface UserProxy {
    @PostMapping("/movieApp/addUser")
    public abstract ResponseEntity<?> sendUserDataToProductApp(@RequestBody UserDto userDto);
}
