package com.example.empresamintic.serivices;

import com.example.empresamintic.entities.Transaccion;
import com.example.empresamintic.repositories.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransaccionServiceImpl implements TransaccionService{

    @Autowired
    private TransaccionRepository transaccionRepository;
    @Override
    public List<Transaccion> listarTransacciones() {
        return (List<Transaccion>) transaccionRepository.findAll();
    }

    @Override
    public String guardarTransaccion(Transaccion transaccion) {
        transaccionRepository.save(transaccion);
        return null;
    }
    @Override
    public Transaccion buscarPorId(Long id) {
        return transaccionRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarTransaccion(Long id) {
        transaccionRepository.deleteById(id);
    }
}
