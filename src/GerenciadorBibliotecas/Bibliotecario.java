package GerenciadorBibliotecas;

public class Bibliotecario {
    public void emprestarLivro(int codigo, Livro livro, Leitor leitor){
        Emprestimo emprestimo = new Emprestimo(codigo, livro, leitor);
        leitor.adicionarEmprestimo(emprestimo);
    }

    public void pagarMulta(Leitor leitor, double valor){
        if (valor > 0 && valor <= leitor.getDebito()){
            leitor.setDebito(leitor.getDebito() - valor);
            System.out.println("R$" + valor + " descontado do débito de " + leitor.getNome() + ". R$" + leitor.getDebito() + " de débito restante.");
        }else if (valor > leitor.getDebito()){
            double troco = valor - leitor.getDebito();
            leitor.setDebito(0);
            System.out.println("Todas multas foram pagas. Dar troco de R$" + troco);
        }else{
            System.out.println("O valor para pagar multa é inválido.");
        }
    }
}