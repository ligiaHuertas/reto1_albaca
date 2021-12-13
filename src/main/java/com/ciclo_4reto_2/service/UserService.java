/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ciclo_4reto_2.service;

import com.ciclo_4reto_2.modelo.User;
import com.ciclo_4reto_2.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Maria Ligia Huertas Moreno
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    /**
     * 
     * @return 
     */
    public List<User> getAll(){
        return userRepository.getAll();
        
    }
    /**
     * 
     * @param id
     * @return 
     */
    public Optional<User> getUser(int id){
        return userRepository.getUser(id);
    }
    /**
     * metodo
     * @param user
     * @return 
     */
    public User save(User user){
        if(user.getId()== null){
            if(existEmail(user.getEmail())== false){
                return userRepository.save(user);
            }else{
                return user;
            }
        }else{
            return user;
        }
    }
    /**
     * 
     * @param email
     * @return 
     */
    public boolean existEmail(String email){
       return userRepository.existEmail(email);
    }
    /**
     * si usuario no existe lo crea
     * @param email
     * @param password
     * @return 
     */
    public User autenticarUsuario(String email, String password){
        Optional<User> usuario = userRepository.autenticarUsuario(email, password);
        if(usuario.isEmpty()){
        return new User(email, password, "NO DEFINIDO");
        
        }else{
            return usuario.get();
        }
    }
    
}
