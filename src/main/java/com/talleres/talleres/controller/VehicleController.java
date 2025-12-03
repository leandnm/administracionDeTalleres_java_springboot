package com.talleres.talleres.controller;

import com.talleres.talleres.dto.VehicleRequest;
import com.talleres.talleres.model.User;
import com.talleres.talleres.model.Vehicle;
import com.talleres.talleres.repository.UserRepository;
import com.talleres.talleres.repository.VehicleRepository;
import com.talleres.talleres.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    public VehicleRepository vehicleRepository;

    @Autowired
    public UserRepository userRepository;

    @PostMapping("/save")
    public ApiResponse crearVehiculo(@RequestBody VehicleRequest vehicle){

        Optional<User> dataUser = userRepository.findById(vehicle.getUserId());

        if (dataUser.isEmpty()){
            return ApiResponse.errorNotFound("Usuario no encontrado");
        }

        User usuario = dataUser.get();

        Vehicle vehiculo = new Vehicle();
        vehiculo.setMark(vehicle.getMark());
        vehiculo.setModel(vehicle.getModel());
        vehiculo.setTuition(vehicle.getTuition());
        vehiculo.setUser(usuario);

        vehicleRepository.save(vehiculo);

        return ApiResponse.recursoCreado("Vehiculo creado exitosamente", vehiculo);
    }



    @GetMapping("/{id}")
    public ApiResponse getVehicleById(@PathVariable Long id){
        Optional<Vehicle> vehiculoSolicitado = vehicleRepository.findById(id);

        if (vehiculoSolicitado.isEmpty()){
            return ApiResponse.errorNotFound("vehiculo no encontrado");
        }
        Vehicle vehiculo = vehiculoSolicitado.get();
        vehiculo.getUser();

        return ApiResponse.success("vehiculo encontrado",vehiculo);

    }

    @PutMapping("/{id}")
    public ApiResponse actualizarVehicle(@PathVariable Long id, @RequestBody VehicleRequest vehicle){

        Optional<Vehicle> dataVehicle = vehicleRepository.findById(id);

        if (dataVehicle.isEmpty()){
            return ApiResponse.errorNotFound("Vehiculo no encontrado");
        }

        Optional<User> dataUser = userRepository.findById(vehicle.getUserId());

        if (dataUser.isEmpty()){
            return ApiResponse.errorNotFound("Usuario no encontrado");
        }

        User usuario = dataUser.get();

        Vehicle vehiculo = dataVehicle.get();
        vehiculo.setMark(vehicle.getMark());
        vehiculo.setModel(vehicle.getModel());
        vehiculo.setTuition(vehicle.getTuition());
        vehiculo.setUser(usuario);

        vehicleRepository.save(vehiculo);

        return ApiResponse.success("Vehiculo actualizado exitosamente", vehicle);

    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse eliminarVehicles(@PathVariable Long id){

        Optional<Vehicle> dataVehicle = vehicleRepository.findById(id);

        if (dataVehicle.isEmpty()){
            return ApiResponse.errorNotFound("Vehiculo no encontrado");
        }

        vehicleRepository.deleteById(id);

        return ApiResponse.success("Vehiculo eliminado exitosamente", null);
    }



}
