package Ficheiros;
import GerenciadorBibliotecas.*;
import java.io.File;

public class GerenciadorFicheiros {
    private void criarFicheiro(String caminho, String nome){
        File ficheiro = new File(caminho, nome);
        try {
            if (ficheiro.createNewFile()){
                System.out.println("Ficheiro criado com sucesso:" + ficheiro.getName());
            }
        }
        catch (Exception e){
            System.out.println("Algo deu errado.");
        }
    }
}
