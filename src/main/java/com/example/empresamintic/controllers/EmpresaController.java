package com.example.empresamintic.controllers;

import com.example.empresamintic.entities.Empresa;
import com.example.empresamintic.serivices.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/ver/empresas")
public class EmpresaController{

    @Autowired
    private EmpresaService empresaService;

    //Listar todas las empresas
    @GetMapping("/empresas")
    public String listarEmpresas(){
        List<Empresa> listadoEmpresas= empresaService.listarEmpresas();
        return (listadoEmpresas.toString());
    }
    //ver empresa por id


    //Guardar empresa
    @PostMapping("/empresas")
    public String guardarEmpresa(@RequestBody Empresa empresa){
        return empresaService.guardarEmpresa(empresa);
    }

    //Editar empresa
    @PatchMapping("/empresas/{id}")
    public void editarEmpresa(@PathVariable("id") Long idempresa, @RequestBody Empresa empresa){
        empresaService.guardarEmpresa(empresa);
    }

    //Eliminar empresa
    @DeleteMapping ("/empresas/{id}")
    public void eliminarEmpresa(@PathVariable("id") Long idempresa){
        empresaService.eliminarEmpresa(idempresa);
    }

}
