package GerenciadorBibliotecas;
import java.util.ArrayList;
import java.util.List;


public class Acervo {
    private List<Livro> livros = new ArrayList<>();

    //construtor
    public Acervo() {
    }

    //metodos personalizados
    public void adicionarLivro(Livro novoLivro){
        this.livros.add(novoLivro);
    }

    public void removerLivro (Livro livro){
        this.livros.remove(livro);
    }

    //getters e setters
    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public int getQtdLivros() {
        return this.livros.size();
    }
}
