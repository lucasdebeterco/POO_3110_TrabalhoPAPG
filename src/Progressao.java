import com.sun.jdi.PrimitiveValue;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;

public class Progressao {

    private int primeiro;
    private int razao;
    private int total;
    private TipoProgressao tipo;

    public Progressao(int primeiro, int razao, int total, TipoProgressao tipo) {
        this.primeiro = primeiro;
        this.razao = razao;
        this.total = total;
        this.tipo = tipo;
    }

    public float razaoMaisAparecePG(int[] vetor) {
        List<Float> listaRazoesPA = new ArrayList<Float>();
        for (int i = 0; i < (vetor.length)-1; i++){
            float razaoPg =  (float) vetor[i+1] / vetor[i];
            listaRazoesPA.add(razaoPg);
        }
        float razaoPG = 0;
        int cont = 0;
        int cont2 = 0;
        float contMaisApareceu = 0;
        for (Float i : listaRazoesPA){
            for (Float j : listaRazoesPA){
                if(i.equals(j)){
                    cont++;
                }
            }
            cont2++;
            if (cont2 == 0){
                razaoPG = i;
                contMaisApareceu = cont;
            } else {
                if (cont > contMaisApareceu ){
                    contMaisApareceu = cont;
                    razaoPG = i;
                }
            }
            cont = 0;
        }
        return razaoPG;
    }

    public float razaoMaisAparecePA(int[] vetor) {
        List<Float> listaRazoesPA = new ArrayList<Float>();
        for (int i = 0; i < (vetor.length)-1; i++){
            float razaoPa =  vetor[i+1] - vetor[i];
            listaRazoesPA.add(razaoPa);
        }
        float razaoPA = 0;
        int cont = 0;
        int cont2 = 0;
        float contMaisApareceu = 0;
        for (Float i : listaRazoesPA){
            for (Float j : listaRazoesPA){
                if(i.equals(j)){
                    cont++;
                }
            }
            cont2++;
            if (cont2 == 0){
                razaoPA = i;
                contMaisApareceu = cont;
            } else {
                if (cont > contMaisApareceu ){
                    contMaisApareceu = cont;
                    razaoPA = i;
                }
            }
            cont = 0;
        }
        return razaoPA;
    }

    public void verificaTipoProg(int[] vetor) {
        float razaoPa = razaoMaisAparecePA(vetor);
        float razaoPg = razaoMaisAparecePG(vetor);
        int contPa = 0;
        int contPg = 0;

        for (int i = 0; i < vetor.length-1; i++){
            if (vetor[i+1] == razaoPa + vetor[i]) {
                contPa++;
            }
            if (vetor[i+1] == vetor[i]*razaoPg){
                contPg++;
            }
        }
        if (contPa == vetor.length-1){
            System.out.println("O vetor é 100% " + TipoProgressao.PA); ;
        }
        else if (contPg == vetor.length-1){
            System.out.println("O vetor é 100% " + TipoProgressao.PG); ;
        }
        else {
            System.out.println("O vetor foi modificado e não é nem uma PA nem uma PG completa..");
            if (contPa > contPg){
                System.out.println("O vetor é " + ((contPa+1)*100/(vetor.length)) + "% PA");
                System.out.println(contPa);
            }
            else if (contPg > contPa){
                System.out.println("O vetor é " + ((contPg+1)*100/(vetor.length-1)) + "% PG");
            }
            else
                System.out.println("Vetor é 50% PA e 50% PG");
        }
    }

    public int qntElementos(int[] vetor) {
        return vetor.length;
    }

    public int soma(int[] vetor) {
        int total = 0;
        for (int i : vetor){
            total = total + i;
        }
        return total;
    }

    public float media(int[] vetor) {
        return (float) soma(vetor)/qntElementos(vetor);
    }

    public int[] gerar() {
        int[] vetor = new int[0];
        if (tipo == TipoProgressao.PA) {
            int[] pa = new int[total];
            pa[0] = primeiro;
            for (int i = 1; i < total; i++) {
                pa[i] = pa[i - 1] + razao;
            }
            vetor = pa;
        }

        if (tipo == TipoProgressao.PG) {
            int[] pa = new int[total];
            pa[0] = primeiro;
            for (int i = 1; i < total; i++) {
                pa[i] = pa[i - 1] * razao;
            }
            vetor = pa;
        }
        return vetor;
    }
}
