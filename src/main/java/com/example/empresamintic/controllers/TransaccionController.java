package com.example.empresamintic.controllers;
import com.example.empresamintic.entities.Transaccion;
import com.example.empresamintic.serivices.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TransaccionController {

    @Autowired
    private TransaccionService transaccionService;


        //Listar transacciones
    @GetMapping("/transacciones")
    public String listarTransacciones(){
         List<Transaccion> listadoTransaccion=transaccionService.listarTransacciones();
        return listadoTransaccion.toString();
    }

        //crear transaccion
    @PostMapping("/transacciones/")
    public String guardarTransaccion(@RequestBody Transaccion transaccion){
        return transaccionService.guardarTransaccion(transaccion);
    }

    @PatchMapping("/transacciones/{id}")
        public void editarTransaccion (@PathVariable("id") Long idtransaccion, @RequestBody Transaccion transaccion){
      transaccionService.guardarTransaccion(transaccion);
    }

    @DeleteMapping("/transacciones/{id}")
    public void eliminarTransaccion(@PathVariable("id") Long idtransaccion){
        transaccionService.eliminarTransaccion(idtransaccion);
    }
}
