package com.example.empresamintic.serivices;

import com.example.empresamintic.entities.Empresa;


import java.util.List;

public interface EmpresaService {

    public List<Empresa> listarEmpresas();
    public String guardarEmpresa(Empresa empresa);
    public Empresa buscarEmpresaId(Long id);
    public void eliminarEmpresa(Long id);
}
