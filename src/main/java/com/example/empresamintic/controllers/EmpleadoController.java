package com.example.empresamintic.controllers;

import com.example.empresamintic.entities.DatoResponse;
import com.example.empresamintic.entities.Empleado;
import com.example.empresamintic.serivices.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/ver/empresas")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    //Listar todas los empleados
    @GetMapping("/empleados")
    public ResponseEntity<List<Empleado>> listarEmpleados(){
        return new ResponseEntity<List<Empleado>>(
                empleadoService.listarEmpleados(),
                HttpStatus.OK);
    }
    //Obtener empleado por Id
    @GetMapping("/empleado/{id}")
    public ResponseEntity<Object> buscarEmpleadoId(@PathVariable Long id){
        try {
            Empleado empleado=empleadoService.buscarEmpleadoId(id);
            return new ResponseEntity<>(empleado, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.OK);
        }
    }
    //Guardar empleado

    @PostMapping("/empleado")
    public ResponseEntity<Object> guardarEmpleado(@RequestBody Empleado empleado){
        return  new ResponseEntity<>(new DatoResponse("Empleado creado exitosamente",
                empleadoService.guardarEmpleado(empleado), HttpStatus.OK), HttpStatus.OK);
    }

    //Editar empleado
    @PatchMapping("/empleado")
    public ResponseEntity<DatoResponse> actualizarEmpleado(@RequestBody Empleado empleado){
        try {
            return new ResponseEntity<>(
                    new DatoResponse("Actualizacion Exitosa", empleadoService.guardarEmpleadoActualizado(empleado), HttpStatus.OK),
                    HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(
                    new DatoResponse(e.getMessage(), null, HttpStatus.OK),
                    HttpStatus.OK);
        }
    }
    //Eliminar empleado
    @DeleteMapping ("/empleado/{id}")
    public ResponseEntity<DatoResponse> eliminarEmpleado(@PathVariable Long id){
        return new ResponseEntity<>(
                new DatoResponse(empleadoService.eliminarEmpleado(id), null, HttpStatus.OK),
                HttpStatus.OK);
    }
}
