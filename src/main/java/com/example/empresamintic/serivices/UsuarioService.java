package com.example.empresamintic.serivices;
import com.example.empresamintic.entities.Usuario;

import java.util.List;


public interface UsuarioService {
    public List<Usuario> listarUsuarios();
    public Usuario guardarUsuario(Usuario usuario);
    public Usuario buscarUsuarioId(Long id) throws  Exception;
    public Usuario guardarUsuarioActualizado(Usuario usuario) throws Exception;
    public String eliminarUsuario(Long id);

}
