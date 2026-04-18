package GerenciadorBibliotecas;

public class Bibliotecario {
    public void emprestarLivro(int codigo, Livro livro, Leitor leitor){
        Emprestimo emprestimo = new Emprestimo(codigo, livro, leitor);
        leitor.adicionarEmprestimo(emprestimo);
    }
}