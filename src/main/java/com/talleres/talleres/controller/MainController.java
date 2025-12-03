package com.talleres.talleres.controller;

import com.talleres.talleres.model.User;
import com.talleres.talleres.model.Vehicle;
import com.talleres.talleres.repository.UserRepository;
import com.talleres.talleres.repository.VehicleRepository;
import com.talleres.talleres.response.ApiResponse;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class MainController {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public VehicleRepository vehicleRepository;

    @GetMapping("/saludo")
    public String saludo(){
        return "hola mundo";
    }



    @GetMapping("/vehicle")
    public ApiResponse getVehicle(){

        User user = new User("Pakisman Leal","email@domain.com");
        user.setAge(15);
        userRepository.save(user);



        Vehicle carro = new Vehicle();
        carro.setMark("ford");
        carro.setModel("fiesta");
        carro.setTuition("123-abc");
        carro.setUser(user);

        vehicleRepository.save(carro);

        ApiResponse respuesta = ApiResponse.success("vehiculo encontrado", carro);


        return respuesta;
    }



    @GetMapping("/vehicle/{id}")
    public ApiResponse getVehicleById(@PathVariable Long id){
        Optional<Vehicle> vehiculoSolicitado = vehicleRepository.findById(id);

        if (vehiculoSolicitado.isEmpty()){
            return ApiResponse.errorNotFound("vehiculo no encontrado");
        }
        Vehicle vehiculo = vehiculoSolicitado.get();
        vehiculo.getUser();

        return ApiResponse.success("vehiculo encontrado",vehiculo);

    }


}
