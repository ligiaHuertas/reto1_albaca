/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ciclo_4reto_2.Controller;

import com.ciclo_4reto_2.modelo.User;
import com.ciclo_4reto_2.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Maria Ligia huertas Moreno
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {
     @Autowired
    private UserService service;
     /**
      * 
      * @return 
      */
    
     @GetMapping("/all")
    public List<User> getAll(){
       return service.getAll();
        
    }
    /**
     * 
     * @param user
     * @return 
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user){
        return service.save(user);
    }

    /**
     * 
     * @param email
     * @return 
     */
    
    @GetMapping("/{email}")
    public boolean existEmail(@PathVariable("email") String email){
        return service.existEmail(email);
        
    }
    /**
     * 
     * @param email
     * @param password
     * @return 
     */
    @GetMapping("/{email}/{password}")
    public User auternticateUser(@PathVariable("email")String email, @PathVariable("password") String password){
        return service.autenticarUsuario(email,password);
    }
    
    
}
