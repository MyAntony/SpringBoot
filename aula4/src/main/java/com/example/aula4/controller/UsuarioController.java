package com.example.aula4.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aula4.model.Usuario;
import com.example.aula4.service.UsuarioService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController
{
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService)
    {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> listarTodos()
    {
        return usuarioService.listarTodos();
    }

    // @PostMapping
    // public ResponseEntity<String> salvar(@Valid @RequestBody Usuario usuario)
    // {
    //     usuarioService.salvar(usuario);
    //     String mensagem = "Usuário " + usuario.getNome() + " cadastrado com sucesso!";
    //     return ResponseEntity.status(HttpStatus.CREATED).body(mensagem);
    // }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody Usuario usuario)
    {
        usuarioService.salvar(usuario);
        String mensagem = "Usuário " + usuario.getNome() + " cadastrado com sucesso!";
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("Mensagem", mensagem));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizar(@Valid @RequestBody Usuario usuario)
    {
        usuarioService.atualizar(usuario);
        String mensagem = "Usuário " + usuario.getNome() + " atualizado com sucesso!";
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("Mensagem", mensagem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> excluir(@PathVariable Long id)
    {
        usuarioService.excluir(id);
        // return ResponseEntity.noContent().build();
        String mensagem = "Usuário deletado com sucesso!";
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("Mensagem", mensagem));
    }
}