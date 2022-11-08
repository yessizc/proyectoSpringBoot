package com.hotel.demo.controller;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hotel.demo.models.entity.Usuario;
import com.hotel.demo.models.service.IUsuarioService;

@Controller
@RequestMapping("/Usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/litarUs")
    public String listar(Model model){
        model.addAttribute("titulo", "listado de ususarios");
        model.addAttribute("usuarios", usuarioService.findAll());
         return "listarUs";


    
        
    }
    @GetMapping("/formularioUs")
    public String crear (Map<String,Object>model){
        Usuario usuario =new Usuario();
        model.put("usuario",usuario);
        model.put("titulo","formulario usuario");
        return "formularioUs";
    }
    
    @PostMapping ("/formularioUs")//peticion para guarda los datos en db
    public String guardar (@Valid Usuario usuario, BindingResult result, Model model){
        System.out.println(usuario.getNombre());
        System.out.println(usuario.getEmail());
        System.out.println(usuario.getTelefono());
        if (result.hasErrors()){
            model.addAttribute("titulo", "formulario de usuario");
            return "formularioUs";
        }
        usuarioService.save(usuario);
        return "redirect:/Usuario/listar";
    }

    @GetMapping("/formularioUs/{id}")
    public String editar(@PathVariable Long id,Map<String,Object>model){
        Optional<Usuario> Usuario =null;
        if (id >0){
            Usuario = usuarioService.findOne(id);
        }
        else{
            return "redirect:usuario/listar";
        }
        model.put("usuario",Usuario);
        model.put("titulo","editar usuario");
        return "formularioUs";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar (@PathVariable Long id){
        if(id >0)
        usuarioService.delete(id);
        return "redirect:/Usuario/listar";
    }


    
}
