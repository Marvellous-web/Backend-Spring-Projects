package com.stackroute.ProductApp.service;


import com.stackroute.ProductApp.exception.UserAlreadyException;
import com.stackroute.ProductApp.model.Product;
import com.stackroute.ProductApp.model.User;

import java.util.List;

public interface UserService {
    public abstract User addUser(User user) throws UserAlreadyException;
//    public abstract User loginCheck(String id,String password);

    public abstract User getUserDetails(String eid);

    public abstract User addProducts(Product product,String eid);














}
