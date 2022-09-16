package com.example.empresamintic.serivices;

import com.example.empresamintic.entities.Usuario;
import com.example.empresamintic.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private  UsuarioRepository usuarioRepository;
    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario buscarUsuarioId(Long id) throws Exception {
        Optional<Usuario> usuarioOptional=usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()){
            return usuarioOptional.get();
        }else {
            throw new Exception("El usuario no existe");
        }
    }

    @Override
    public Usuario guardarUsuarioActualizado(Usuario usuario) throws Exception {
       try {
           Usuario usuarioDb=buscarUsuarioId(usuario.getIdusuario());
           if (usuario.getUsuario()!=null){
               usuarioDb.setUsuario(usuario.getUsuario());
           }
           if(usuario.getContraseña()!=null){
               usuarioDb.setContraseña(usuario.getContraseña());
           }
           return guardarUsuario(usuarioDb);
       }catch (Exception e){
           throw new Exception("Usuario no existe para actualizar");
       }
    }
    @Override
    public String eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
        return "Usuario eliminado correctamente";
    }
}
