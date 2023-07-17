package com.stackroute.ProductApp.service;

import com.stackroute.ProductApp.exception.UserAlreadyException;
import com.stackroute.ProductApp.model.Product;
import com.stackroute.ProductApp.model.User;
import com.stackroute.ProductApp.repository.UserProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserProductRepository userProductRepository;
    @Override
    public User addUser(User user) throws UserAlreadyException {
        if(userProductRepository.findById(user.getEmail()).isPresent())
        {
            throw new UserAlreadyException();
        }
        else
        {
            return userProductRepository.insert(user);
        }

    }

    @Override
    public User getUserDetails(String eid) {
        return userProductRepository.findById(eid).get();
    }

    @Override
    public User addProducts(Product product, String eid) {
        User user1=userProductRepository.findById(eid).get();
        user1.getProduct().add(product);
        // get current user by usinjg request.emailid
        // add product to current user.products
        // save current user back to db



            return userProductRepository.save(user1);

    }


}
