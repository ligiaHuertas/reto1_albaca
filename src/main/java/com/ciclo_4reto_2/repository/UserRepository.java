/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ciclo_4reto_2.repository;

import com.ciclo_4reto_2.crudReposirory.UserCrudRepository;
import com.ciclo_4reto_2.modelo.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Maria ligia Huertas moreno
 */
@Repository
public class UserRepository {
     @Autowired
    private UserCrudRepository userCrudRepository;
    /**
     *  metodo retorna lista de ususarios con GetAll ase uso de findAll
     * @return 
     */
    
    public List<User> getAll(){
        return (List<User>) userCrudRepository. findAll();    
    }
    /**
     * metodo getuser recibe un id y retorna un opcional
     * @param id
     * @return 
     */
    public Optional<User> getUser(int id){
        return userCrudRepository.findById(id);
    }
    /**
     * metodo que actualiza e insertar datos
     * @param user
     * @return 
     */
    public User save(User user){
        return userCrudRepository.save(user);
    }
    /**
     * metodo que verifica si existe  o sino existe el email
     * @param email
     * @return 
     */
    public boolean existEmail(String email){
        Optional<User> usuario= userCrudRepository.findByEmail(email);   
        return !usuario.isEmpty();
    }  
    
    /**
     * metodo verifica si el email coinside con el password
     * @param email
     * @param password
     * @return 
     */
    public Optional<User> autenticarUsuario(String email, String password){
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
    
}
