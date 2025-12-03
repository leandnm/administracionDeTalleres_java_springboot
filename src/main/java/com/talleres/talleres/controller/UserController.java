package com.talleres.talleres.controller;

import com.talleres.talleres.dto.UserRequest;
import com.talleres.talleres.model.User;
import com.talleres.talleres.repository.UserRepository;
import com.talleres.talleres.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController{

    @Autowired
    public UserRepository userRepository;


    @GetMapping("/{id}")
    public ApiResponse getUserById(@PathVariable Long id){

        System.out.println(id);

        Optional<User> usuarioSolicitado = userRepository.findById(id);

        if (usuarioSolicitado.isEmpty()){
            return ApiResponse.errorNotFound("Usuario no encontrado");
        }
        User usuario = usuarioSolicitado.get();

        return ApiResponse.success("Usuario encontrado",usuario);

    }

    @PostMapping("/save")
    public ApiResponse guardarUser(@RequestBody UserRequest user){

        User fulano = new User();
        fulano.setName(user.getName());
        fulano.setAge(user.getAge());
        fulano.setEmail(user.getEmail());

        userRepository.save(fulano);

        return ApiResponse.success("Usuario Agregado", fulano);
    }

    @PutMapping("/{id}")
    public ApiResponse actualizarUsuario(@PathVariable Long id, @RequestBody UserRequest user) {

        Optional<User> dataUser = userRepository.findById(id);

        if (dataUser.isEmpty()) {
            return ApiResponse.errorNotFound("Usuario no encontrado");
        }

        User usuario = dataUser.get();

        usuario.setName(user.getName());
        usuario.setAge(user.getAge());
        usuario.setEmail(user.getEmail());

        userRepository.save(usuario);

        return ApiResponse.success("Usuario Actualizado", usuario);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse eliminarUsuario(@PathVariable Long id){

        userRepository.deleteById(id);

        return ApiResponse.success("El usuario ha sido eliminado", null);
    }

}
