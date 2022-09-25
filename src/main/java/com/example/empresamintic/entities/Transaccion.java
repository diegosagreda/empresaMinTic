package com.example.empresamintic.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "transacciones")
public class Transaccion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idtransaccion;
    private String monto;
    private String concepto;
    private String fecha;

    private String tipo;

    @ManyToOne
    private Empresa empresa;


    @ManyToOne
    private Empleado empleado;



    public Transaccion() {
    }

    public Transaccion(Long idtransaccion, String monto, String concepto, String fecha, String tipo, Empresa empresa, Empleado empleado) {
        this.idtransaccion = idtransaccion;
        this.monto = monto;
        this.concepto = concepto;
        this.fecha = fecha;
        this.tipo = tipo;
        this.empresa = empresa;
        this.empleado = empleado;
    }

    public Long getIdtransaccion() {
        return idtransaccion;
    }

    public void setIdtransaccion(Long idtransaccion) {
        this.idtransaccion = idtransaccion;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
