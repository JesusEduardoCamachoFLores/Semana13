package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity 
public class Usuario {
    @Id @GeneratedValue 
    private long id;
    private String usuario;
    private String clave;
    private String nombre;
    private int intentos;
    private boolean bloqueado;
    public Usuario(){}
    public Usuario(String usuario, String clave, String nombre) {
        this.usuario = usuario;
        this.clave = clave;
        this.nombre = nombre;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getIntentos() {
        return intentos;
    }
    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }
    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }
    public boolean isBloqueado() {
        return bloqueado;
    }
    
}
