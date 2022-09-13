package com.example.empresamintic.serivices;

import com.example.empresamintic.entities.Transaccion;

import java.util.List;

public interface TransaccionService {

    public List<Transaccion> listarTransacciones();
    public String guardarTransaccion(Transaccion transaccion);
    public Transaccion buscarPorId(Long id);
    public  void eliminarTransaccion(Long id);



}
