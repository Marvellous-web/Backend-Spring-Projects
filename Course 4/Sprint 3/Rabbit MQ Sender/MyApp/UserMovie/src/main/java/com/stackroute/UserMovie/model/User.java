package com.stackroute.UserMovie.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor@NoArgsConstructor@Data@Document
public class User {
    @Id
    private  String emailId;
    private String name,address;
    private List<Movie> movieList;

}
