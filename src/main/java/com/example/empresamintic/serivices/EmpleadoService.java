package com.example.empresamintic.serivices;

import com.example.empresamintic.entities.Empleado;
import com.example.empresamintic.entities.Empresa;

import java.util.List;

public interface EmpleadoService {

    public List<Empleado> listarEmpleados();
    public Empleado guardarEmpleado(Empleado empleado);
    public Empleado buscarEmpleadoId(Long id) throws Exception;
    public Empleado guardarEmpleadoActualizado(Empleado empleado) throws Exception;
    public String eliminarEmpleado(Long id);
}
