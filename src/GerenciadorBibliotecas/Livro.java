package GerenciadorBibliotecas;

public class Livro {
    private String titulo;
    private int codigo;
    private int totPaginas;
    private String autor;
    private String categoria;

    //construtor
    public Livro(String titulo, int codigo, int totPaginas, String autor, String categoria){
        this.setTitulo(titulo);
        this.setCodigo(codigo);
        this.setTotPaginas(totPaginas);
        this.setAutor(autor);
        this.setCategoria(categoria);
    }

    //getters e setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getTotPaginas() {
        return totPaginas;
    }

    public void setTotPaginas(int totPaginas) {
        this.totPaginas = totPaginas;
    }
}