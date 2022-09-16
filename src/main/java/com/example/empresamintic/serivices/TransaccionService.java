package com.example.empresamintic.serivices;

import com.example.empresamintic.entities.Transaccion;

import java.util.List;

public interface TransaccionService {

    public List<Transaccion> listarTransacciones();
    public Transaccion guardarTransaccion(Transaccion transaccion);
    public Transaccion buscarTransaccionId(Long id) throws Exception;
    public Transaccion guardarTransaccionActualizada(Transaccion transaccion) throws Exception;
    public  String eliminarTransaccion(Long id);



}
