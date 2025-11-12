import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class teste {
    private String[] listaNomes;
    private int quant;
    public static void main(String[] args) {
        teste t = new teste();
        t.heapSort("arquivos_base/Reserva1000ord.txt");
        t.exibirListaNomes("HeapSort Nomes");
    }
    public static ArrayList<String> lerArquivo(String caminho) {
        ArrayList<String> linhas = new ArrayList<>();
        try (BufferedReader leitor = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                linhas.add(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            e.printStackTrace();
        }
        return linhas;
    }
    public void heapSort(String caminho) {
        ArrayList<String> linhas = lerArquivo(caminho);
        quant = linhas.size();
        listaNomes = new String[quant];

        for (int i = 0; i < linhas.size(); i++) {
            String[] partes = linhas.get(i).split(";");
            listaNomes[i] = partes[1].trim();
        }
        int dir = quant - 1, esq = (dir - 1) / 2;
        while (esq >= 0) {
            refazHeapNomes(esq, quant - 1);
            esq--;
        }
        while (dir > 0) {
            String temp = listaNomes[0];
            listaNomes[0] = listaNomes[dir];
            listaNomes[dir] = temp;
            dir--;
            refazHeapNomes(0, dir);
        }
    }

    private void refazHeapNomes(int esq, int dir) {
        int i = esq, mF = 2 * i + 1;
        String raiz = listaNomes[i];
        boolean heap = false;

        while (mF <= dir && !heap) {
            if (mF < dir && listaNomes[mF].compareTo(listaNomes[mF + 1]) < 0) {
                mF++;
            }
            if (raiz.compareTo(listaNomes[mF]) < 0) {
                listaNomes[i] = listaNomes[mF];
                i = mF;
                mF = 2 * i + 1;
            } else {
                heap = true;
            }
        }
        listaNomes[i] = raiz;
    }
    public void exibirListaNomes(String metodo) {
        System.out.println("=== " + metodo + " ===");
        long inicio = System.currentTimeMillis();
        for (String nome : listaNomes) {
            System.out.println(nome);
        }
        long fim = System.currentTimeMillis();
        System.out.println("Tempo total: " + (fim - inicio) + " ms");
    }
}
