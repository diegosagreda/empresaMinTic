package com.example.empresamintic.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idusuario;
    private String usuario;
    private String contraseña;

    @OneToOne
    @JoinColumn(name = "idEmpleado")
    private Empleado empleado;

    public long getIdUsuario() {
        return idusuario;
    }

    public void setIdUsuario(long idusuario) {
        this.idusuario = idusuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        contraseña = contraseña;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idusuario +
                ", usuario='" + usuario + '\'' +
                ", Contraseña='" + contraseña + '\'' +
                ", empleado=" + empleado +
                '}';
    }
}
