package com.example.empresamintic.serivices;

import com.example.empresamintic.entities.Empleado;

import java.util.List;

public interface EmpleadoService {

    public List<Empleado> listarEmpleados();
    public String guardarEmpleado(Empleado empleado);
    public Empleado buscarEmpleadoId(Long id);
    public void eliminarEmpleado(Long id);
}
