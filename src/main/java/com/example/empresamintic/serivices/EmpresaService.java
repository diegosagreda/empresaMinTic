package com.example.empresamintic.serivices;

import com.example.empresamintic.entities.Empresa;


import java.util.List;

public interface EmpresaService {

    public List<Empresa> listarEmpresas();
    public Empresa guardarEmpresa(Empresa empresa);
    public Empresa buscarEmpresaId(Long id) throws Exception;
    public Empresa guardarEmpresaActualizada(Empresa empresa) throws Exception;
    public String eliminarEmpresa(Long id);
}
