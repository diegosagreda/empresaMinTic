package com.example.empresamintic.serivices;
import com.example.empresamintic.entities.Usuario;


public interface UsuarioService {
    public Usuario guardarUsuario(Usuario usuario);
    public void eliminarUsuario(Long id);
}
