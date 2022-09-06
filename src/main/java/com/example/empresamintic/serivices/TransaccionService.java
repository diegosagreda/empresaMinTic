package com.example.empresamintic.serivices;

import com.example.empresamintic.entities.Transaccion;

import java.util.List;
import java.util.Optional;

public interface TransaccionService {

    public List<Transaccion> listarTransacciones();
    public Transaccion guardarTransaccion(Transaccion transaccion);
    public Optional<Transaccion> buscarTransaccion(Long id);
    public void eliminarTransaccion(Long id);


}
