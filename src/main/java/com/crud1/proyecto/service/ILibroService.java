/*
Las interfaces sirven para definir un contrato, en este caso, la interfaz ILibroService define los métodos que se
pueden realizar sobre la entidad Libro.
Se diferencian de las clases en que no se pueden instanciar, y en que una clase puede implementar varias interfaces.
En este caso, la interfaz ILibroService no tiene métodos, pero se pueden agregar en caso de que se requiera.
*/

package com.crud1.proyecto.service;

import com.crud1.proyecto.model.Libro;

import java.util.List;

public interface ILibroService {
    List<Libro> getAllLibros();
    Libro saveLibro(Libro libro);
    Libro getLibroById(Long id);
    void deleteLibro(Long id);
}
