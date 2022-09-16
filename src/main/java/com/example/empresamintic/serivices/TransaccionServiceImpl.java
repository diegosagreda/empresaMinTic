package com.example.empresamintic.serivices;

import com.example.empresamintic.entities.Empresa;
import com.example.empresamintic.entities.Transaccion;
import com.example.empresamintic.repositories.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransaccionServiceImpl implements TransaccionService{

    @Autowired
    private TransaccionRepository transaccionRepository;

    @Override
    public List<Transaccion> listarTransacciones() {
        return transaccionRepository.findAll();
    }

    @Override
    public Transaccion guardarTransaccion(Transaccion transaccion) {
        return transaccionRepository.save(transaccion);
    }
    @Override
    public Transaccion buscarTransaccionId(Long id) throws Exception {
        Optional<Transaccion> transaccionOptional=transaccionRepository.findById(id);
        if (transaccionOptional.isPresent()){
            return transaccionOptional.get();
        }else {
            throw new Exception("La transaccion no existe");
        }
    }
    @Override
    public Transaccion guardarTransaccionActualizada(Transaccion transaccion)throws Exception{
        try {
            Transaccion transaccionDb=buscarTransaccionId(transaccion.getIdtransaccion());
            if (transaccion.getMonto()!=null){
                transaccionDb.setMonto(transaccion.getMonto());
            }
            if (transaccion.getConcepto()!=null){
                transaccionDb.setConcepto(transaccion.getConcepto());
            }
            if (transaccion.getFecha()!=null){
                transaccionDb.setFecha(transaccion.getFecha());
            }
            return guardarTransaccion(transaccionDb);
        }catch (Exception e){
            throw new Exception("No existe transacción para actualizar");
        }
    }

    @Override
    public String eliminarTransaccion(Long id){
        transaccionRepository.deleteById(id);
        return "Transaccion eliminada exitosamente";
    }
}
