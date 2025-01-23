//este repositorio se extendera de jparepository para heredar todas las operaciones de crud

package com.crud1.proyecto.repository;

import com.crud1.proyecto.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//esto sirve para que se pueda inyectar en el controlador
@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
}
