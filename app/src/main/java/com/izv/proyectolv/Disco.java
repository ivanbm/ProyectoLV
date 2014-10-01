package com.izv.proyectolv;

/**
 * Created by Ivan on 30/09/2014.
 */
public class Disco {

    private String titulo, autor, discografica, imagen;

    public Disco(String titulo, String autor, String discografica, String imagen) {
        this.titulo = titulo;
        this.autor = autor;
        this.discografica = discografica;
        this.imagen = imagen;
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

    public String getDiscografica() {
        return discografica;
    }

    public void setDiscografica(String discografica) {
        this.discografica = discografica;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Disco disco = (Disco) o;

        if (autor != null ? !autor.equals(disco.autor) : disco.autor != null) return false;
        if (discografica != null ? !discografica.equals(disco.discografica) : disco.discografica != null)
            return false;
        if (imagen != null ? !imagen.equals(disco.imagen) : disco.imagen != null) return false;
        if (titulo != null ? !titulo.equals(disco.titulo) : disco.titulo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = titulo != null ? titulo.hashCode() : 0;
        result = 31 * result + (autor != null ? autor.hashCode() : 0);
        result = 31 * result + (discografica != null ? discografica.hashCode() : 0);
        result = 31 * result + (imagen != null ? imagen.hashCode() : 0);
        return result;
    }
}
