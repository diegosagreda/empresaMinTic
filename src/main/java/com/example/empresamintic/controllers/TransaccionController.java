package com.example.empresamintic.controllers;
import com.example.empresamintic.entities.DatoResponse;
import com.example.empresamintic.entities.Transaccion;
import com.example.empresamintic.serivices.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TransaccionController {

    @Autowired
    private TransaccionService transaccionService;


        //Listar transacciones
    @GetMapping("/transacciones")
    public ResponseEntity<List<Transaccion>> listarTransacciones(){
        return new ResponseEntity<List<Transaccion>>(
                transaccionService.listarTransacciones(),
                HttpStatus.OK);
    }

    //Obtener una transaccion por id
    @GetMapping("/transaccion/{id}")
    public ResponseEntity<Object> buscarTransaccionId(@PathVariable Long id){
        try {
            Transaccion transaccion=transaccionService.buscarTransaccionId(id);
                return new ResponseEntity<>(transaccion, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.OK);
        }
    }

        //crear transaccion
    @PostMapping("/transaccion")
    public ResponseEntity<Object> guardarTransaccion(@RequestBody Transaccion transaccion){
        return  new ResponseEntity<>(new DatoResponse("Transaccion creada con exito",
                transaccionService.guardarTransaccion(transaccion), HttpStatus.OK), HttpStatus.OK);
    }

    @PatchMapping("/transaccion")
        public ResponseEntity<DatoResponse> actualizarTransaccion(@RequestBody Transaccion transaccion){
        try {
            return new ResponseEntity<>(
                    new DatoResponse("Actualizacion exitosa", transaccionService.guardarTransaccionActualizada(transaccion), HttpStatus.OK),
            HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(
                    new DatoResponse(e.getMessage(), null, HttpStatus.OK),
                    HttpStatus.OK);
        }
    }
    @DeleteMapping("/transaccion/{id}")
    public ResponseEntity<DatoResponse> eliminarTransaccion(@PathVariable Long id){
        return new ResponseEntity<>(
                new DatoResponse(transaccionService.eliminarTransaccion(id),null, HttpStatus.OK),
                HttpStatus.OK);
    }
}
