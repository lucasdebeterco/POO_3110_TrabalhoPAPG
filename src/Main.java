import javax.sound.midi.Soundbank;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite o primeiro elemento: ");
        int primeiro = Integer.parseInt(entrada.nextLine());
        System.out.println("Digite a razão: ");
        int razao = Integer.parseInt(entrada.nextLine());
        System.out.println("Digite o total de elementos: ");
        int total = Integer.parseInt(entrada.nextLine());
        System.out.println("Digite 1 para PA e 2 para PG");
        int opcao = Integer.parseInt(entrada.nextLine());
        TipoProgressao tipo;
        if (opcao == 1) {
            tipo = TipoProgressao.PA;
        } else{
            tipo = TipoProgressao.PG;
        }

        Progressao p = new Progressao(primeiro, razao, total, tipo);
        System.out.println(Arrays.toString(p.gerar()));


        System.out.println("Digite o nome do arquivo Json: ");
        String nome = entrada.nextLine();

        PersistenciaJSON json = new PersistenciaJSON(nome);
        json.gravarVetor(p.gerar());

        System.out.println("--- Leitura ---");
        int[] vetor = json.ler();
        System.out.println("Vetor: " + Arrays.toString(vetor));
        System.out.println("Tanhanho: " + vetor.length);
        System.out.println("A1 (Primeiro elemento): " + vetor[0]);
        System.out.println("Quantidade de elementos: " + p.qntElementos(vetor));
        System.out.println("Somatória: " + p.soma(vetor));
        System.out.println("Média: " + p.media(vetor));
        System.out.println("Tipo de progressão (com porcentagem): ");
        p.verificaTipoProg(vetor);

        Grafico g = new Grafico(vetor);
        g.gerarGrafico("pizza");
        g.gerarGraficoLinha("linha");
        g.gerarGraficoColuna("coluna");








    }
}
