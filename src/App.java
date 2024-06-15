import java.io.IOException;
import java.util.Scanner;

import Models.ConsultaCep;
import Models.Endereco;
import Models.GeradorDeArquivo;

public class App {
    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);
        ConsultaCep consultaCep = new ConsultaCep();

        System.out.println("Digite um número de CEP  para consulta: ");
        var cep = leitura.nextLine();

        try {
            Endereco novoEndereco = consultaCep.buscaEndereco(cep);
            System.out.println(novoEndereco);
            GeradorDeArquivo gerador = new GeradorDeArquivo();
            gerador.salvaJson(novoEndereco);

        } catch (RuntimeException | IOException e) {

            System.out.println(e.getMessage());
            System.out.println("Finalizando a aplicação");
        }

    }
}
