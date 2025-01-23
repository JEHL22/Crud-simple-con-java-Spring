/*
    * Clase que implementa los métodos de la interfaz LibroServiceInterface
    * La implementacion sirve para definir la lógica de negocio de los métodos
    *
*/
package com.crud1.proyecto.service;

import com.crud1.proyecto.model.Libro;
import com.crud1.proyecto.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Anotación que indica que la clase es un servicio
public class LibroService implements ILibroService {

    @Autowired // Inyección de dependencias
    private LibroRepository libroRepository;

    @Override // Sobreescribir el método de la interfaz
    public List<Libro> getAllLibros() {
        return libroRepository.findAll(); // Devuelve todos los libros
    }

    @Override
    public Libro saveLibro(Libro libro) {
        return libroRepository.save(libro); // Guarda un libro
    }

    @Override
    public Libro getLibroById(Long id) {
        return libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
    }// Devuelve un libro por su id y si no lo encuentra lanza una excepción.

    @Override
    public void deleteLibro(Long id) {
        libroRepository.deleteById(id);
    }

}
