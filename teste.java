import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class teste {
    public static void main(String[] args) {
        
    }

    public  static ArrayList<String> lerArquivo(String caminho){
        ArrayList<String> linhas= new ArrayList<>();
        try(BufferedReader leitor= new BufferedReader(new FileReader(caminho))){
            String linha;
            while((linha=leitor.readLine())!=null){
                linhas.add(linha);
            }
        } catch (IOException e){
            System.out.println(e);
            e.printStackTrace();
        }
        return linhas;
    }


        public void heapSort(String caminho) {
        // Ler o arquivo
        ArrayList<String> linhas = lerArquivo(caminho);
        
        // Converter para array de inteiros
        this.lista = new int[linhas.size()];
        this.quant = linhas.size();
        
        for (int i = 0; i < linhas.size(); i++) {
            this.lista[i] = Integer.parseInt(linhas.get(i).trim());
        }
        
        // Agora fazer o HeapSort
        int dir = quant-1, esq = (dir-1)/2, temp;
        
        while (esq >= 0) {
            refazHeap(esq, this.quant-1);
            esq--;
        }
        
        while (dir > 0) {
            temp = this.lista[0];
            this.lista[0] = this.lista[dir];
            this.lista[dir] = temp;
            dir--;
            refazHeap(0, dir);
        }
    }
    
    private void refazHeap(int esq, int dir) {
        int i = esq, mF = 2*i+1;
        int raiz = this.lista[i];
        boolean heap = false;
        
        while ((mF <= dir) && (!heap)) {
            if (mF < dir) {
                if (this.lista[mF] < this.lista[mF+1]) {
                    mF++;
                }
            }
            
            if (raiz < this.lista[mF]) {
                this.lista[i] = this.lista[mF];
                i = mF;
                mF = 2*i+1;
            } else {
                heap = true;
            }
            
            this.lista[i] = raiz;
        }
    }
}