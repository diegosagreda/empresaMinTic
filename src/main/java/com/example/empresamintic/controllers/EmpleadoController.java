package com.example.empresamintic.controllers;

import com.example.empresamintic.entities.Empleado;
import com.example.empresamintic.entities.Empresa;
import com.example.empresamintic.serivices.EmpleadoService;
import com.example.empresamintic.serivices.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/ver/empresas")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;
    @Autowired
    private EmpresaService empresaService;

    //Listar todas los empleados
    @GetMapping("/empleados")
    public String listarEmpleados(){
        List<Empleado> listadoEmpleados= empleadoService.listarEmpleados();
        return (listadoEmpleados.toString());
    }
    //Guardar empleado
    @PostMapping("/empleados")
    public void guardarEmpleado(@RequestBody Empleado empleado){
        List<Empresa> empresas=empresaService.listarEmpresas();
        Empresa empresa=null;
        for(Empresa em:empresas){
            if(em.getTipo().equals("Principal")){
                empresa=em;
            }
        }
        if(empresa!=null){
            empleado.setEmpresa(empresa);
            System.out.println("Empleado a guardar: "+empleado);
            empleadoService.guardarEmpleado(empleado);
        }
    }
    //Editar empleado
    @PatchMapping("/empleados/{id}")
    public String editarEmpleado(@PathVariable("id") Empleado empleado){
        return  empleadoService.guardarEmpleado(empleado);
    }
    //Eliminar empleado
    @DeleteMapping ("/empleados/{id}")
    public void eliminarEmpleado(@PathVariable("id") Long idempleado){
        empleadoService.eliminarEmpleado(idempleado);
    }

}
