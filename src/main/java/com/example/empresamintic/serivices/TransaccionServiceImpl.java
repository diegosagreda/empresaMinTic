package com.example.empresamintic.serivices;

import com.example.empresamintic.entities.Empleado;
import com.example.empresamintic.entities.Transaccion;
import com.example.empresamintic.repositories.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransaccionServiceImpl implements TransaccionService{

    @Autowired
    TransaccionRepository transaccionRepository;

    @Override
    public List<Transaccion> listarTransacciones() {
        return (List<Transaccion>)transaccionRepository.findAll();
    }

    @Override
    public Transaccion guardarTransaccion(Transaccion transaccion) {
        return transaccionRepository.save(transaccion);
    }

    @Override
    public Optional<Transaccion> buscarTransaccion(Long id) {
        return transaccionRepository.findById(id);
    }

    @Override
    public void eliminarTransaccion(Long id) {
        transaccionRepository.deleteById(id);
    }
}
