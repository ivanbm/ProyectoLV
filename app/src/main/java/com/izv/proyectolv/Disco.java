package com.izv.proyectolv;

import android.graphics.Bitmap;

/**
 * Created by Ivan on 30/09/2014.
 */
public class Disco {

    private String album, autor, discografica;
    private Bitmap imagen;

    public Disco(String album, String autor, String discografica, Bitmap imagen) {
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

    public Bitmap getImagen() {
        return imagen;
    }

    public void setImagen(Bitmap imagen) {
        this.imagen = imagen;
    }


}
