package com.suetham.Dijkstra;

import com.suetham.Graph.Aresta;
import com.suetham.Graph.Graph;
import com.suetham.Graph.Vertice;

import java.util.HashMap;
import java.util.List;

public class Dijkstra {
    private Graph graph;

    public Dijkstra(Graph graph) {
        this.graph = graph;
    }

    private int heuristicFn(Coordinate current, Coordinate goal) {
        return (int) Math.sqrt(Math.abs(current.xAxis() - goal.xAxis()) * 2 + Math.abs(current.yAxis() - goal.yAxis()) * 2);
    }

    public void handle(Vertice inicio, Vertice destino, int heuristic) {
        // [0, Inf, Inf, Inf, Inf, Inf] (caminho)
        // [true, false, false, false, false, false] (visited)
        // for each inicio in graph
            // - get the incidentes and calculate the path weight, get the minimum

        List<Vertice> vertices = graph.vertices();
        HashMap<String, Object> visitedVertices = new HashMap<>();
        int heuristicValue = 0;

        // Definir valores padrões (como não visitado e o caminho mais curto como infinito (possível))
        for (Vertice verticeItem : vertices) {
            String verticeName = verticeItem.getElement().toString();

            HashMap<String, Object> details = new HashMap<>();
            details.put("visitado", false);
            details.put("caminho_mais_curto", Integer.MAX_VALUE);

            visitedVertices.put(verticeName, details);
        }

        HashMap<String, Object> verticeInicio = (HashMap<String, Object>) visitedVertices.get(inicio.getElement().toString());
        verticeInicio.put("caminho_mais_curto", 0);

//        Vertice current = inicio;
        Integer caminhoCusto = 0;

        while (inicio != null) {
            // Definir o minimo para comparação entre os custos das arestas
            Integer min = Integer.MAX_VALUE;
            Vertice verticeEscolhido = null;

            List<Aresta> arestasIncidentes = graph.arestasIncidentes(inicio);

            // Para cada aresta incidente, atualizar o seu custo e define o próximo inicio a trabalhar
            for (Aresta aresta : arestasIncidentes) {
                Integer arestaValue = (Integer) aresta.getValue();

                HashMap<String, Object> details = (HashMap) visitedVertices.get(aresta.getVerticeFim().toString());

                HashMap verticeDetails = (HashMap) visitedVertices.get(inicio.toString());
                caminhoCusto = (Integer) verticeDetails.get("caminho_mais_curto");

                if (heuristic == 1) {
                    int sourceY = vertices.indexOf(inicio);
                    int sourceX = vertices.indexOf(aresta.getVerticeFim());

                    int destinationY = vertices.indexOf(destino);
                    int destinationX = vertices.indexOf(destino);

                    Coordinate source = new Coordinate(sourceX, sourceY);
                    Coordinate destination = new Coordinate(destinationX, destinationX);

                    heuristicValue = heuristicFn(source, destination);
                }

                System.out.println(heuristicValue);
                System.out.println("CC: " + caminhoCusto);
                if ((caminhoCusto + arestaValue) + heuristicValue < (Integer) details.get("caminho_mais_curto")) {
                    details.put("caminho_mais_curto", caminhoCusto + arestaValue);
                }

                if (arestaValue < min) {
                    min = arestaValue;
                    verticeEscolhido = aresta.getVerticeFim();
                }
            }

            // Definir inicio trabalhado como visitado
            HashMap<String, Object> details = (HashMap) visitedVertices.get(inicio.toString());
            details.put("visitado", true);

            caminhoCusto += min;

            inicio = verticeEscolhido;

            if (inicio == null && heuristic == 0) {
                inicio = (Vertice) this.returnUnvisited(visitedVertices, vertices);
            }
        }

        System.out.println(visitedVertices.toString());
    }

    public Object returnUnvisited(HashMap<String, Object> verticesDetails, List<Vertice> vertices) {
        Vertice verticeUnvisited = null;

        for (Vertice vertice: vertices) {
            String verticeName = vertice.getElement().toString();

            HashMap details = (HashMap) verticesDetails.get(verticeName);

            if ((Boolean) details.get("visitado") == false) {
                verticeUnvisited = vertice;
            }
        }

        return verticeUnvisited;
    }
}
