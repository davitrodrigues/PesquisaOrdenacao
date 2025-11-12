import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class teste {
    public static void main(String[] args) {
        // Chamando a função
        lerArquivo("arquivos_base/nome.txt");
    }
    
    // Função para ler arquivo
    public static void lerArquivo(String caminhoArquivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}