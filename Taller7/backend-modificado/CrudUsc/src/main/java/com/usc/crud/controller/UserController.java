package com.usc.crud.controller;

import com.usc.crud.Login;
import com.usc.crud.model.Empleado;
import com.usc.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class UserController {

    @Autowired
    private UserService service;


    @GetMapping("/consultar/{id}")
    public ResponseEntity<?> filtrar(@PathVariable long id) {
        return ResponseEntity.ok(service.finByUser(id));

    }

    @RequestMapping(value = "/login")
    public ResponseEntity<?> loginValidation(@RequestBody Login loginForm) {
        Empleado empleadoEncontrado = service.findByEmail(loginForm.getEmail());

        if (empleadoEncontrado != null) {
            if (loginForm.getPassword().equals(empleadoEncontrado.getPassword())) {
                return ResponseEntity.ok(empleadoEncontrado);
            }
            return ResponseEntity.status(409).body("El correo o contraseña no son correctos");
        }
        return ResponseEntity.status(404).body("Empleado no encontrado");
    }


    // create employee rest api
    @PostMapping("/guardar")
    public Empleado createEmployee(@RequestBody Empleado empleado) {
        return service.guardarUser(empleado);
    }

    @GetMapping("/consultarAll")
    public ResponseEntity<?> consultarByUser() {

        return ResponseEntity.ok(service.buscarTdoso()
        );
    }

    // update employee rest api


    // delete employee rest api
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        String msj = service.eliminarUser(id);
        return ResponseEntity.ok(msj);
    }

}
