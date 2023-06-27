import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    private String path;

    public CSVReader(String path) {
        this.path = path;
    }

    public void read() {

        // Obtengo una lista con las lineas del archivo
        // lines.get(0) tiene la primer linea del archivo
        // lines.get(1) tiene la segunda linea del archivo... y así
        ArrayList<String[]> lines = this.readContent();

        GrafoDirigido<Integer> grafo = new GrafoDirigido<>();

        for (String[] line : lines) {
            // Cada linea es un arreglo de Strings, donde cada posicion guarda un elemento
            Integer origen = Integer.parseInt(line[0].trim().substring(1));
            Integer destino = Integer.parseInt(line[1].trim().substring(1));
            Integer etiqueta = Integer.parseInt(line[2].trim());

            grafo.agregarVertice(origen);
            grafo.agregarVertice(destino);
            grafo.agregarArco(origen, destino, etiqueta);
        }
        Backtracking backtracking = new Backtracking();
        List<Integer> rutaOptimaBktr = backtracking.backtr(grafo);
        int distanciaBacktracking = calcularDistanciaRuta(grafo, rutaOptimaBktr);
        verificarSolucion("Backtracking", rutaOptimaBktr, distanciaBacktracking, 0);

        // Backtracking

        // Greedy
        Greedy greedy = new Greedy();
        List<Integer> tunelesGreedy = greedy.solve(grafo);
        System.out.println(tunelesGreedy);
        int distanciaGreedy = calcularDistanciaRuta(grafo, tunelesGreedy);
        verificarSolucion("Greedy", tunelesGreedy, distanciaGreedy, 0);

    }

    private int calcularDistanciaRuta(GrafoDirigido<Integer> grafo, List<Integer> ruta) {
        int distanciaTotal = 0;
        for (int i = 0; i < ruta.size() - 1; i++) {
            int origen = ruta.get(i);
            int destino = ruta.get(i + 1);
            Arco<Integer> arco = grafo.obtenerArco(origen, destino);

            if (arco != null) {
                int distancia = arco.getEtiqueta();
                distanciaTotal += distancia;
            } 
        }
        return distanciaTotal;
    }

    public void verificarSolucion(String tecnica, List<Integer> tuneles, int metrosTotales, int costo) {
        //salto de linea
        System.out.println("\n");
       
        System.out.println("Técnica utilizada: " + tecnica);

        System.out.println("Lista de túneles a construir:");
        for (int i = 0; i < tuneles.size() - 1; i += 2) {
            int estacion1 = tuneles.get(i);
            int estacion2 = tuneles.get(i + 1);
            System.out.println("Estación " + estacion1 + " - Estación " + estacion2);
        }

        System.out.println("Cantidad de metros totales a construir: " + metrosTotales);
        System.out.println("Costo de encontrar la solución: " + costo);

        System.out.println("\n");

    }

    private ArrayList<String[]> readContent() {
        ArrayList<String[]> lines = new ArrayList<String[]>();

        File file = new File(this.path);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                line = line.trim();
                lines.add(line.split(";"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (bufferedReader != null)
                try {
                    bufferedReader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
        }

        return lines;
    }

}