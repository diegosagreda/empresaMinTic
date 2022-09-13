package com.example.empresamintic.entities;

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

    @ManyToOne
    @JoinColumn(name = "idempleado")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "idempresa")
    private Empresa empresa;

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

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "idtransaccion=" + idtransaccion +
                ", monto='" + monto + '\'' +
                ", concepto='" + concepto + '\'' +
                ", fecha='" + fecha + '\'' +
                ", empleado=" + empleado +
                ", empresa=" + empresa +
                '}';
    }
}
