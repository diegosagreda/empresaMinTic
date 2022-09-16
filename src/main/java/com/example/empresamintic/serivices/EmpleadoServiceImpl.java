package com.example.empresamintic.serivices;

import com.example.empresamintic.entities.Empleado;
import com.example.empresamintic.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

    @Autowired
    private EmpleadoRepository empleadoRepository;


    @Override
    public List<Empleado> listarEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
       return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado buscarEmpleadoId(Long id) throws Exception {
        Optional<Empleado> empleadoOptional=empleadoRepository.findById(id);
        if(empleadoOptional.isPresent()){
            return empleadoOptional.get();
        }else{
            throw  new Exception("El empleado no existe");
        }
    }
    @Override
    public Empleado guardarEmpleadoActualizado(Empleado empleado)throws Exception{
        try {
            Empleado empleadoDb=buscarEmpleadoId(empleado.getCedulaempleado());
            if (empleado.getNombre()!=null){
                empleadoDb.setNombre(empleado.getNombre());
            }
            if (empleado.getEmail()!=null){
                empleadoDb.setEmail(empleado.getEmail());
            }
            if (empleado.getTelefono()!=null){
                empleadoDb.setTelefono(empleado.getTelefono());
            }
            if (empleado.getRol()!=null){
                empleadoDb.setRol(empleado.getRol());
            }
            return guardarEmpleado(empleadoDb);
        }catch (Exception e){
            throw new Exception("No existe el empleado para actualizar");
        }
    }
    @Override
    public String eliminarEmpleado(Long id) {
        empleadoRepository.deleteById(id);
        return "Empleado eliminado exitosamente";
    }
}
