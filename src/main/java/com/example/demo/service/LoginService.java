package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.exception.CredencialesInvalidasException;
import com.example.demo.exception.CuentaBloqueadaException;
import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service 
public class LoginService {
    private final UsuarioRepository repo;

    public LoginService(UsuarioRepository repo) {
        this.repo = repo;
    }
    public String login(String usuario, String clave){
        if(usuario==null || usuario.isBlank() || clave == null || clave.isBlank())
            throw new IllegalArgumentException("Datos obligatorios");
        Usuario u= repo.findByUsuario(usuario).orElseThrow(CredencialesInvalidasException::new);
        if(u.isBloqueado()) throw new CuentaBloqueadaException();
        if(!u.getClave().equals(clave)){
            u.setIntentos(u.getIntentos()+1);
            if(u.getIntentos()>= 3) u.setBloqueado(true);
            repo.save(u);
            throw new CredencialesInvalidasException();
        }
        u.setIntentos(0);
        repo.save(u);
        return "Bienvenido, "+u.getNombre();
    }
}
