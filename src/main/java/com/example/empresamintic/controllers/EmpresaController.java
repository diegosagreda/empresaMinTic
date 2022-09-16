package com.example.empresamintic.controllers;

import com.example.empresamintic.entities.Empresa;
import com.example.empresamintic.entities.DatoResponse;
import com.example.empresamintic.serivices.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/ver/empresas")
public class EmpresaController{

    @Autowired
    private EmpresaService empresaService;

    //Listar todas las empresas
    @GetMapping("/empresas")
    public ResponseEntity<List<Empresa>> getEmpresas(){
        return  new ResponseEntity<List<Empresa>>(
                empresaService.listarEmpresas(),
                HttpStatus.OK
        );
    }
    //ver empresa por id
    @GetMapping("/empresa/{id}")
    public ResponseEntity<Object> buscarEmpresaId(@PathVariable Long id){
        try {
            Empresa empresa = empresaService.buscarEmpresaId(id);
            return new ResponseEntity<>(empresa, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),
            HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //Guardar empresa
    @PostMapping("/empresa")
    public ResponseEntity<Object> guardarEmpresa(@RequestBody Empresa empresa){
        return new ResponseEntity<>(new DatoResponse("Empresa creada exitosamente",
                    empresaService.guardarEmpresa(empresa), HttpStatus.OK), HttpStatus.OK);

    }

    //Editar empresa
    @PatchMapping("/empresa")
    public ResponseEntity<DatoResponse> actualizarEmpresa(@RequestBody Empresa empresa){
        try {
            return  new ResponseEntity<>(
                    new DatoResponse("Actualizacion exitosa", empresaService.guardarEmpresaActualizada(empresa), HttpStatus.OK),
                    HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(
                    new DatoResponse(e.getMessage(), null, HttpStatus.OK),
                    HttpStatus.OK);
        }
    }

    //Eliminar empresa
    @DeleteMapping ("/empresa/{id}")
    public ResponseEntity<DatoResponse> eliminarEmpresa(@PathVariable Long id){
        return new ResponseEntity<>(
                new DatoResponse(empresaService.eliminarEmpresa(id), null, HttpStatus.OK),
                HttpStatus.OK);
    }
}
