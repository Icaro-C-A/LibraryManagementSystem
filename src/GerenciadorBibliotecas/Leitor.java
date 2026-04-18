package GerenciadorBibliotecas;
import java.util.ArrayList;
import java.util.List;

public class Leitor {
    private String nome;
    private int cadastro;
    private boolean cadastrado;
    private List<Emprestimo> emprestimos = new ArrayList<>();
    private double debito;

    //construtor
    public Leitor(String nome, int cadastro){
        this.setNome(nome);
        this.setCadastro(cadastro);
        this.setCadastrado(true);
        this.setDebito(0d);
    }

    //getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCadastro() {
        return cadastro;
    }

    public void setCadastro(int cadastro) {
        this.cadastro = cadastro;
    }

    public boolean isCadastrado() {
        return cadastrado;
    }

    public void setCadastrado(boolean cadastrado) {
        this.cadastrado = cadastrado;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public double getDebito() {
        return debito;
    }

    public void setDebito(double debito) {
        this.debito = debito;
    }
}
