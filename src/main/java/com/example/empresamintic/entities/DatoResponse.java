package com.example.empresamintic.entities;

import org.springframework.http.HttpStatus;

public class DatoResponse {
    private String mensaje;
    private Object object;

    public DatoResponse() {
    }

    public DatoResponse(String mensaje, Object object, HttpStatus ok) {
        this.mensaje = mensaje;
        this.object = object;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
