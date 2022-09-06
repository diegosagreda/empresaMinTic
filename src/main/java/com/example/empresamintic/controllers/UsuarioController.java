package com.example.empresamintic.controllers;

import com.example.empresamintic.entities.Empleado;
import com.example.empresamintic.entities.Usuario;
import com.example.empresamintic.serivices.EmpleadoService;
import com.example.empresamintic.serivices.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private EmpleadoService empleadoService;


    //Eliminar Usuario
    @DeleteMapping("/usuarios/{id}")
    public void eliminarUsuario(@PathVariable("id") long idusuario){
        usuarioService.eliminarUsuario(idusuario);
    }
}
