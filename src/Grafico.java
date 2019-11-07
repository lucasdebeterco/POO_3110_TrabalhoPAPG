import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

public class Grafico {
    private int[] vetor;

    public Grafico(int[] vetor) {
        this.vetor = vetor;
    }

    public boolean gerarGrafico(String nome) throws IOException {

        HashSet<Float> numeros = new HashSet<Float>();
        for (float num : vetor){
            numeros.add(num);
        }

        Scanner entrada = new Scanner(System.in);
        FileWriter arq = new FileWriter( nome + ".html");
        PrintWriter gravarArq = new PrintWriter(arq);

        gravarArq.printf("<html>\r\n  <head>\r\n    <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\r\n    <script type=\"text/javascript\">\r\n      google.charts.load(\"current\", {packages:[\"corechart\"]});\r\n      google.charts.setOnLoadCallback(drawChart);\r\n      function drawChart() {\r\n        var data = google.visualization.arrayToDataTable([\r\n          ['Domínio', 'Quantidade'],\r\n");
        for(Float num : numeros) {
            int cont2 = 0;
            for(int num2 : vetor) {
                if (num == num2){
                    cont2++;
                }
            }
            gravarArq.printf("          ['" + num + "'," + num + "],\r\n");
        }

        gravarArq.printf("]);\r\n\r\n        var options = {\r\n          title: 'Grafico de dominios de email',\r\n          is3D: true,\r\n        };\r\n\r\n        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));\r\n        chart.draw(data, options);\r\n      }\r\n    </script>\r\n  </head>\r\n  <body>\r\n    <div id=\"piechart_3d\" style=\"width: 1800px; height: 750px;\"></div>\r\n  </body>\r\n</html>");
        arq.close();
        entrada.close();
        return true;
    }

    public boolean gerarGraficoLinha(String nome) throws IOException {

        HashSet<Float> numeros = new HashSet<Float>();
        for (float num : vetor){
            numeros.add(num);
        }

        Scanner entrada = new Scanner(System.in);
        FileWriter arq = new FileWriter( nome + ".html");
        PrintWriter gravarArq = new PrintWriter(arq);

        gravarArq.printf("<html>\n" +
                "  <head>\n" +
                "    <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\n" +
                "    <script type=\"text/javascript\">\n" +
                "            google.charts.load('current', {'packages':['corechart']});\n" +
                "      google.charts.setOnLoadCallback(drawChart);\n" +
                "\n" +
                "    function drawChart() {\n" +
                "        var data = google.visualization.arrayToDataTable([\n" +
                "          ['Valores', 'Valor'],\n");
        for(Float num : numeros) {
            int cont2 = 0;
            for(int num2 : vetor) {
                if (num == num2){
                    cont2++;
                }
            }
            gravarArq.printf("          ['" + num + "'," + num + "],\r\n");
        }
        gravarArq.printf(
                "        ]);\n" +
                "\n" +
                "        var options = {\n" +
                "                title: 'PROGREÇÃO EM GRÁFICO DE LINHA',\n" +
                "                curveType: 'function',\n" +
                "                legend: { position: 'bottom' }\n" +
                "        };\n" +
                "\n" +
                "        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));\n" +
                "\n" +
                "        chart.draw(data, options);\n" +
                "    }\n" +
                "    </script>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    <div id=\"curve_chart\" style=\"width: 900px; height: 500px\"></div>\n" +
                "  </body>\n" +
                "</html>");
        arq.close();
        entrada.close();
        return true;
    }

    public boolean gerarGraficoColuna(String nome) throws IOException {

        HashSet<Float> numeros = new HashSet<Float>();
        for (float num : vetor){
            numeros.add(num);
        }

        Scanner entrada = new Scanner(System.in);
        FileWriter arq = new FileWriter( nome + ".html");
        PrintWriter gravarArq = new PrintWriter(arq);

        gravarArq.printf("<html>\n" +
                "  <head>\n" +
                "    <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\n" +
                "    <script type=\"text/javascript\">\n" +
                "      google.charts.load('current', {'packages':['bar']});\n" +
                "      google.charts.setOnLoadCallback(drawChart);\n" +
                "\n" +
                "      function drawChart() {\n" +
                "        var data = google.visualization.arrayToDataTable([\n" +
                "          ['Valores', 'Valor'],\n");
        for(Float num : numeros) {
            int cont2 = 0;
            for(int num2 : vetor) {
                if (num == num2){
                    cont2++;
                }
            }
            gravarArq.printf("          ['" + num + "'," + num + "],\r\n");
        }
        gravarArq.printf(
                "        ]);\n" +
                "\n" +
                "        var options = {\n" +
                "          chart: {\n" +
                "            title: 'Company Performance',\n" +
                "            subtitle: 'Sales, Expenses, and Profit: 2014-2017',\n" +
                "          }\n" +
                "        };\n" +
                "\n" +
                "        var chart = new google.charts.Bar(document.getElementById('columnchart_material'));\n" +
                "\n" +
                "        chart.draw(data, google.charts.Bar.convertOptions(options));\n" +
                "      }\n" +
                "    </script>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    <div id=\"columnchart_material\" style=\"width: 800px; height: 500px;\"></div>\n" +
                "  </body>\n" +
                "</html>\n");
        arq.close();
        entrada.close();
        return true;
    }



















}
