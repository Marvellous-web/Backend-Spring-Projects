package com.stackroute.MongoRepository.CustomerService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.MongoRepository.CustomerService.controller.CustomerController;
import com.stackroute.MongoRepository.CustomerService.model.Customer;
import com.stackroute.MongoRepository.CustomerService.model.Product;
import com.stackroute.MongoRepository.CustomerService.service.CustomerService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.awt.print.Book;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {
    @Mock
    private CustomerService customerService;
    @InjectMocks
    CustomerController customerController;
    @Autowired
    private MockMvc mockMvc;
    private Customer customer;
    private Product product;
    @BeforeEach
    public void setup()
    {
        customer=new Customer("101","Gopal","888798",product);
        product=new Product("01","Electronic","SmartWatch");
        mockMvc= MockMvcBuilders.standaloneSetup(customerController).build();
    }
    @AfterEach
    public void clean(){
        customer=null;
        product=null;
    }
    @Test
    public void TestControllerAddCustomerSuccess() throws Exception{
        when(customerService.addCustomer(customer)).thenReturn(customer);
        mockMvc.perform(
                post("/addCustomer").
                        contentType(MediaType.APPLICATION_JSON).content(convertToJson(customer))).
                andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
        verify(customerService,times(1)).addCustomer(customer);


    }

    private static String convertToJson(final Object object) {
        String result = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            result = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e)
        {
        throw new RuntimeException(e);
    }
        return result;

    }



}

