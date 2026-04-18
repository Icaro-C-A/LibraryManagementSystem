package GerenciadorBibliotecas;
import java.time.LocalDate;


public class Emprestimo {
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private int codigo;
    private Livro livro;
    private Leitor leitor;

    //construtor
    public Emprestimo(int codigo, Livro livro, Leitor leitor) {
        this.setDataEmprestimo(LocalDate.now());
        this.setDataDevolucao(this.getDataEmprestimo().plusDays(7));
        this.setCodigo(codigo);
        this.setLivro(livro);
        this.setLeitor(leitor);
    }

    //getters e setters
    public Leitor getLeitor() {
        return leitor;
    }

    public void setLeitor(Leitor leitor) {
        this.leitor = leitor;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public LocalDate getDataEmprestimo(){
        return this.dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate data){
        this.dataEmprestimo = data;
    }

    public LocalDate getDataDevolucao(){
        return this.dataDevolucao;
    }

    public void setDataDevolucao(LocalDate data){
        this.dataDevolucao = data;
    }
}
