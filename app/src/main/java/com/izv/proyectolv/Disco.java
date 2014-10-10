package com.izv.proyectolv;

/**
 * Created by Ivan on 30/09/2014.
 */
public class Disco {

    private String album, autor, discografica, imagen;

    public Disco(String album, String autor, String discografica, String imagen) {
        this.album = album;
        this.autor = autor;
        this.discografica = discografica;
        this.imagen = imagen;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
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


}
