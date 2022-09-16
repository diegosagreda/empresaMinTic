package com.example.empresamintic.controllers;

import com.example.empresamintic.entities.DatoResponse;
import com.example.empresamintic.entities.Empleado;
import com.example.empresamintic.entities.Usuario;
import com.example.empresamintic.serivices.EmpleadoService;
import com.example.empresamintic.serivices.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        return new ResponseEntity<List<Usuario>>(
                usuarioService.listarUsuarios(),
                HttpStatus.OK);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Object> buscarUsuarioId(@PathVariable Long id){
        try {
            Usuario usuario=usuarioService.buscarUsuarioId(id);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.OK);
        }
    }
    @PostMapping("/usuario")
    public ResponseEntity<Object> guardarUsuario(@RequestBody Usuario usuario){
        return  new ResponseEntity<>(new DatoResponse("Usuario creado exitosamente",
                usuarioService.guardarUsuario(usuario), HttpStatus.OK), HttpStatus.OK);
    }

    @PatchMapping("/usuario")
    public ResponseEntity<DatoResponse> actualizarUsuario(@RequestBody Usuario usuario){
        try {
            return new ResponseEntity<>(
                    new DatoResponse("Actualizacion Exitosa", usuarioService.guardarUsuarioActualizado(usuario), HttpStatus.OK),
                    HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(
                    new DatoResponse(e.getMessage(), null, HttpStatus.OK),
                    HttpStatus.OK);
        }
    }
    @DeleteMapping ("/usuario/{id}")
    public ResponseEntity<DatoResponse> eliminarUsuario(@PathVariable Long id){
        return new ResponseEntity<>(
                new DatoResponse(usuarioService.eliminarUsuario(id), null, HttpStatus.OK),
                HttpStatus.OK);
    }
}
