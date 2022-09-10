package com.example.empresamintic.controllers;


import com.example.empresamintic.entities.Transaccion;
import com.example.empresamintic.serivices.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransaccionController {

    //Listar transacciones
    @Autowired
    private TransaccionService transaccionService;

    @GetMapping("/transacciones")
    public String listarTransacciones(){
        List<Transaccion> listadoTransacciones= transaccionService.listarTransacciones();
        return (listadoTransacciones.toString());
    }

    //Guardar Transacciones
    @PostMapping("/transacciones")
    public void guardarTransacciones(@RequestBody Transaccion transaccion, @RequestBody Long idempleado){

        //transaccionService.guardarTransaccion(transaccion);
        System.out.println(transaccion);
        System.out.println(idempleado);
    }
    //Editar Transaccion
    @PatchMapping("/transacciones{id}")
    public void editarTransaccion(@PathVariable("id") Long idtransaccion, @RequestBody Transaccion transaccion ){
        transaccionService.guardarTransaccion(transaccion);
    }

    //Eliminar Transaccion
    @DeleteMapping("/transacciones/{id}")
    public void eliminarTransaccion(@PathVariable("id") Long idtransaccion){
        transaccionService.eliminarTransaccion(idtransaccion);
    }

}
