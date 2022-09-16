package com.example.empresamintic.serivices;

import com.example.empresamintic.entities.Empresa;
import com.example.empresamintic.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaServiceImpl implements EmpresaService{

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public List<Empresa> listarEmpresas() {
        return empresaRepository.findAll();
    }

    @Override
    public Empresa guardarEmpresa(Empresa empresa) {
       return empresaRepository.save(empresa);

    }

    @Override
    public Empresa buscarEmpresaId(Long id)throws Exception {
        Optional<Empresa> empresaOptional= empresaRepository.findById(id);
        if(empresaOptional.isPresent()){
            return empresaOptional.get();
        }else {
            throw  new Exception("La empresa no existe");
        }
    }
    @Override
    public Empresa guardarEmpresaActualizada(Empresa empresa) throws Exception{
        try {
            Empresa empresaDb=buscarEmpresaId(empresa.getNitempresa());
            if(empresa.getNombre()!=null){
                empresaDb.setNombre(empresa.getNombre());
            }
            if(empresa.getDireccion()!=null){
                empresaDb.setDireccion(empresa.getDireccion());
            }
            if(empresa.getTelefono()!=null){
                empresaDb.setTelefono(empresa.getTelefono());
            }
            if (empresa.getTipo()!=null){
                empresaDb.setTipo(empresa.getTipo());
            }
            return guardarEmpresa(empresaDb);
        }catch (Exception e){
            throw new Exception("No existe usuario para actualizar");
        }
    }

    @Override
    public String eliminarEmpresa(Long id) {
        empresaRepository.deleteById(id);
        return "Empresa eliminada exitosamente";
    }
}
