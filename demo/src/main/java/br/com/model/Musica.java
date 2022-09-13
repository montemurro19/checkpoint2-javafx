package br.com.model;

public class Musica {

    private String titulo;
    private String album;
    private String artista;
    private String genero;
    private String nota;

    public Musica(String titulo, String album, String artista, String genero, String nota) {
        this.titulo = titulo;
        this.album = album;
        this.artista = artista;
        this.genero = genero;
        this.nota = nota;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Musica [album=" + album + ", artista=" + artista + ", genero=" + genero + ", nota=" + nota + ", titulo=" + titulo + "]";
    }

}
