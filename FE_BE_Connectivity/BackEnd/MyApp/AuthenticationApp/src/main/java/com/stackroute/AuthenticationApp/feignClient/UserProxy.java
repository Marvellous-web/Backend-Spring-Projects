package com.stackroute.AuthenticationApp.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name = "movie-app" , url = "localhost=8091")
public interface UserProxy {
    @PostMapping("/addUser")
    public abstract ResponseEntity<?> sendUserDtoToMovieApp(@RequestBody UserDto userDto);

}
