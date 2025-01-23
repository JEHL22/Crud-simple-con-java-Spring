// Creación de la clase LibroController que se encargará de recibir las peticiones del cliente y enviarlas al servicio
package com.crud1.proyecto.controller;

import com.crud1.proyecto.model.Libro;
import com.crud1.proyecto.service.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller // Anotación que indica que la clase es un controlador
@RequestMapping("/libros") // Indica la URL base para acceder a los métodos de la clase
public class LibroController {

    @Autowired // Inyección de dependencias
    private ILibroService libroService;

    @GetMapping("") //Indica que este méttodo se ejecutará al hacer una petición GET a la URL base
    public String listarLibros(Model model){
        model.addAttribute("libros", libroService.getAllLibros());
        return "libros/lista"; // Devuelve la vista lista.html
    }
    // el model.addAttribute sirve para enviar datos a la vista , en attribute se envia el nombre de la variable
    // y en el segundo parametro el valor de la variable

    @GetMapping("/nuevo") // Indica que este méttodo se ejecutará al hacer una petición GET a la URL /nuevo
    public String mostrarFormularioNuevo(Model model){
        model.addAttribute("libro", new Libro());
        return "libros/formulario"; // Devuelve la vista formulario.html
    }

    @PostMapping("/guardar")
    public String guardarLibro(@ModelAttribute Libro libro){ // @ModelAttribute indica que se recibirá un objeto Libro
        libroService.saveLibro(libro);
        return "redirect:/libros"; // Redirige a la URL /libros
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id , Model model){ // @PathVariable indica que se recibirá
        model.addAttribute("libro", libroService.getLibroById(id)); // un parámetro de la URL
        return "libros/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarLibro(@PathVariable Long id){
        libroService.deleteLibro(id);
        return "redirect:/libros";
    }

}
