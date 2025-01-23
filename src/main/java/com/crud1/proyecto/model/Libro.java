package com.crud1.proyecto.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
//import lombok.Data; // si usamos el @Data activarlo
import lombok.NoArgsConstructor;

@Entity // Anotación que indica que la clase es una entidad
@Table(name = "libros")
//@Data // Anotación de Lombok que genera los métodos getter, setter, equals, hashcode y toString
//no se por que cuando hago los getters y setters con el @data me da errores al ejecutar
@NoArgsConstructor // Anotación de Lombok que genera un constructor sin argumentos
@AllArgsConstructor // Anotación de Lombok que genera un constructor con todos los argumentos
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera un valor único para la clave primaria
    private Long id;

    @Column(nullable = false) //esta anotación valida que el autor no sea nulo
    private String titulo;

    @Column(nullable = false)
    private String autor;

    @Column(unique = true)
    private String isbn;

    @Column(nullable = false)
    private Integer anioPublicacion;

    private String genero;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(Integer anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
