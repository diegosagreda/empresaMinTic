package com.example.empresamintic.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "empresas")
public class Empresa implements Serializable {

    @Id
    private long nitempresa;
    private String nombre;
    private String direccion;
    private String telefono;
    private String tipo;

    private  boolean estado;

    @JsonIgnore
    @OneToMany(mappedBy = "empresa")
    private List<Empleado> empleado;

    @JsonIgnore
    @OneToMany(mappedBy = "empresa")
    private List<Transaccion> transaccion;

    public Empresa() {
    }

    public Empresa(long nitempresa, String nombre, String direccion, String telefono, String tipo, List<Empleado> empleado, List<Transaccion> transaccion, boolean estado) {
        this.nitempresa = nitempresa;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipo = tipo;
        this.empleado = empleado;
        this.transaccion = transaccion;
        this.estado=true;
    }

    public long getNitempresa() {
        return nitempresa;
    }

    public void setNitempresa(long nitempresa) {
        this.nitempresa = nitempresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Empleado> getEmpleado() {
        return empleado;
    }

    public void setEmpleado(List<Empleado> empleado) {
        this.empleado = empleado;
    }

    public List<Transaccion> getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(List<Transaccion> transaccion) {
        this.transaccion = transaccion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
