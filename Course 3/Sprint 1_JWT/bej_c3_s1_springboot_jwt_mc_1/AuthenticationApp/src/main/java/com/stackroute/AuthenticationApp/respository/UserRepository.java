package com.stackroute.AuthenticationApp.respository;
import com.stackroute.AuthenticationApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, String> {

    public User findByEmailIdAndPassword(String emailId,String password);


    //OR

    @Query("select s from User s where s.emailId=?1 and s.password=?2")
    public User findBEmailIdAndPassword(String id, String pass);



}
