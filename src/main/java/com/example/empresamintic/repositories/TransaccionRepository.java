package com.example.empresamintic.repositories;

import com.example.empresamintic.entities.Transaccion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionRepository extends CrudRepository<Transaccion, Long> {
}
