package com.example.empresamintic.serivices;

import com.example.empresamintic.entities.Empresa;
import com.example.empresamintic.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaServiceImpl implements EmpresaService{

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public List<Empresa> listarEmpresas() {
        return (List<Empresa>)empresaRepository.findAll();
    }

    @Override
    public String guardarEmpresa(Empresa empresa) {
        empresaRepository.save(empresa);
        return null;
    }

    @Override
    public Empresa buscarEmpresaId(Long id) {
        return empresaRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarEmpresa(Long id) {
        empresaRepository.deleteById(id);

    }
}
