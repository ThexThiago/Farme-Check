
package com.thiago.farme_check.controller;

import com.thiago.farme_check.entity.Usuario;
import com.thiago.farme_check.repository.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    UsuarioRepository repository;

    @GetMapping ("/")
    public String login (){
        return "login";
    }

    @GetMapping ("cadastro")
    public String cadastro (){
        return "cadastro";
    }

    @PostMapping("efetuar-cadastro")
    public String efetuarCadastro(String nome, String email, String pwd){
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setPassword(pwd);

        repository.save(usuario);
        return "login";
    }

    @PostMapping("efetuar-login")
    public String efetuarLogin(String email, String pwd, HttpSession session){ // Recebe a sessão

        var usuario = repository.findByEmail(email);
        if (usuario != null && usuario.getPassword().equals(pwd)){

            session.setAttribute("usuarioLogado", usuario);
            return "home";
        }

        return "login";
    }
}