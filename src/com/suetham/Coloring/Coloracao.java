package com.suetham.Coloring;

import com.suetham.Graph.Graph;
import com.suetham.Graph.Vertice;

import java.util.ArrayList;
import java.util.Vector;

public class Coloracao {
    private Graph graph;
    // Primeiro ArrayList
    private ArrayList<ArrayList<Vertice>> verticesColorado = new ArrayList<>();

    public Coloracao(Graph graph) {
        this.graph = graph;
    }

    public ArrayList<ArrayList<Vertice>> handle() {
        Vector<Vertice> vertices = (Vector<Vertice>) graph.vertices();

        ArrayList<Vertice> verticesOrdenadoPorGrau = new ArrayList<>();

//        int index = 0;
//        int menorGrauIndex = 0;
//        int menorGrau = Integer.MAX_VALUE;

        // ver todos os vertices
        // comparar o grau de cada com os outros

        /*
        * Ordernar os vertices pelo seu grau
        * */

        // Enquanto tiver vertices
//        while (!vertices.isEmpty()) {
//            // Pegar o vertice
//            Vertice vertice = vertices.get(index);
//
//            // Ver o seu grau
//            int grau = graph.arestasIncidentes(vertice).size();
//
//            // Se o grau for menor que o menor grau encontrado
//            if (grau < menorGrau) {
//                // se for guardar o seu index e o definir o seu grau como o menor
//                menorGrauIndex = index;
//                menorGrau = grau;
//            }
//
//            // Ir para o próximo vertice
//            index++;
//
//            // Se chegar no último elemento, definir o index como 0
//            if (index == vertices.size() - 1) {
//                index = 0;
//            }
//        }

        int index = 0;

        /*
        * Enquanto vertices não estiver vazio, percorrer
        * */
        while (!vertices.isEmpty()) {
            // Pegar o vertice
            Vertice vertice = vertices.get(index);

            // Definir o menor grau como o grau do vertice pego
            int menorGrau = graph.arestasIncidentes(vertice).size();

            // Definir o vertice escolhido como padrão
            Vertice verticeEscolhido = vertice;

            // Comparar o vertice pego com os outros vertices
            for (Vertice verticeParaComparar : vertices) {

                // Não comparar o vertice consigo mesmo
                if (vertice == verticeParaComparar) {
                    continue;
                }

                // Pegar o grau do vertice de comparação
                int grauDeComparacao = graph.arestasIncidentes(verticeParaComparar).size();

                // Se for menor o grau de comparação definir o vertice de comparação como o vertice escolhido
                if (grauDeComparacao < menorGrau) {
                    menorGrau = grauDeComparacao;
                    verticeEscolhido = verticeParaComparar;
                }
            }

            // Remover o vertice escolhido da lista de vertices
            vertices.remove(verticeEscolhido);

            // Adicionar o vertice escolhido a lista de vertices ordenado
            verticesOrdenadoPorGrau.add(verticeEscolhido);
        }

        index = 0;

        /*
         * Percorrer os vertices ordenado por grau e adicionar os não adjacentes a lista
         * */

        int comparacaoIndex = 1;
//        System.out.println(verticesOrdenadoPorGrau.toString());
        while (!verticesOrdenadoPorGrau.isEmpty()) {
            // Instanciar a lista
            ArrayList<Vertice> coloracaoAtual = new ArrayList<>();

            // Pegar o vertice principal
            Vertice vertice = verticesOrdenadoPorGrau.get(0);

            // Adicionar o vertice a lista de coloracao (cor atual)
            coloracaoAtual.add(vertice);

            // Index para comparação com o vertice principal
            comparacaoIndex = index + 1;

            // Comparar o vertice principal com os outros vertices
            while (comparacaoIndex < verticesOrdenadoPorGrau.size()) {
                // Se o vertice não é adjacente, adicione a lista de coloração e remover da lista de vertices
                if (!graph.éAdjacente(vertice, verticesOrdenadoPorGrau.get(comparacaoIndex))) {
                    coloracaoAtual.add(verticesOrdenadoPorGrau.get(comparacaoIndex));
                    verticesOrdenadoPorGrau.remove(comparacaoIndex);
                }

                // Ir para o proximo vertice de comparação
                comparacaoIndex++;
            }

            // Remover vertice principal
            verticesOrdenadoPorGrau.remove(vertice);

            // Adicionar lista de coloração, a lista de listas
            verticesColorado.add(coloracaoAtual);
        }

        return verticesColorado;
    }

}
