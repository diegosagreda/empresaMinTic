package com.example.empresamintic.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "empleados")
public class Empleado implements Serializable {
    @Id
    private Long cedulaempleado;
    private String nombre;
    private String email;
    private String telefono;
    private String rol;

    @JsonIgnore
    @OneToOne(mappedBy = "empleado")
    private Usuario usuario;


    @ManyToOne
    private Empresa empresa;

    @JsonIgnore
    @OneToMany(mappedBy = "empleado")
    private  List<Transaccion> transaccion;
    public Empleado() {
    }

    public Empleado(Long cedulaempleado, String nombre, String email, String telefono, String rol, Usuario usuario, Empresa empresa, List<Transaccion> transaccion) {
        this.cedulaempleado = cedulaempleado;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.rol = rol;
        this.usuario = usuario;
        this.empresa = empresa;
        this.transaccion = transaccion;
    }

    public Long getCedulaempleado() {
        return cedulaempleado;
    }

    public void setCedulaempleado(Long cedulaempleado) {
        this.cedulaempleado = cedulaempleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Transaccion> getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(List<Transaccion> transaccion) {
        this.transaccion = transaccion;
    }
}
