package com.stackroute.ProductApp.controller;

import com.stackroute.ProductApp.exception.UserAlreadyException;
import com.stackroute.ProductApp.model.Product;
import com.stackroute.ProductApp.model.User;
import com.stackroute.ProductApp.repository.UserProductRepository;
import com.stackroute.ProductApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody User user) throws UserAlreadyException
    {
        try {

            user.setProduct(new ArrayList<Product>());
            return new ResponseEntity<>(userService.addUser(user), HttpStatus.OK);
        }
        catch (UserAlreadyException ex)
        {
            ex.printStackTrace();
            throw new UserAlreadyException();

        }


    }
    @GetMapping("/get-user-details")
    public ResponseEntity<?> getUserDetails(HttpServletRequest request)
    {
        String current_user_emailId=(String)request.getAttribute("curr_user_emailid");
        return new ResponseEntity<>(userService.getUserDetails(current_user_emailId),HttpStatus.OK);
    }
    @PostMapping("/add-products")
    public ResponseEntity<?> getProductDetails(@RequestBody Product product,HttpServletRequest request)
    {
        // get current user by usinjg request.emailid
        // add product to current user.products
        // save current user back to db
        String current_user_emailId=(String)request.getAttribute("curr_user_emailid");

        return new ResponseEntity<>(userService.addProducts(product,current_user_emailId),HttpStatus.OK);

    }
}
