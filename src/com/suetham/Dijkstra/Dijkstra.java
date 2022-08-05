package com.suetham.Dijkstra;

import com.suetham.Graph.Aresta;
import com.suetham.Graph.Graph;
import com.suetham.Graph.Vertice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class Dijkstra {
    private Graph graph;

    public Dijkstra(Graph graph) {
        this.graph = graph;
    }

    public void handle(Vertice vertice) {
        // [0, Inf, Inf, Inf, Inf, Inf] (caminho)
        // [true, false, false, false, false, false] (visited)
        // for each vertice in graph
            // - get the incidentes and calculate the path weight, get the minimum

        List<Vertice> vertices = graph.vertices();
        HashMap<String, Object> visitedVertices = new HashMap<>();

        // Definir valores padrões (como não visitado e o caminho mais curto como infinito (possível))
        for (Vertice verticeItem : vertices) {
            String verticeName = verticeItem.getElement().toString();

            HashMap<String, Object> details = new HashMap<>();
            details.put("visitado", false);
            details.put("caminho_mais_curto", Integer.MAX_VALUE);

            visitedVertices.put(verticeName, details);
        }

        System.out.println(visitedVertices.toString());
        HashMap<String, Object> verticeInicio = (HashMap<String, Object>) visitedVertices.get(vertice.getElement().toString());
        verticeInicio.put("caminho_mais_curto", 0);

        Vertice current = vertice;
        Integer caminhoCusto = 0;

        while (vertice != null) {
            // Definir o minimo para comparação entre os custos das arestas
            Integer min = Integer.MAX_VALUE;
            Vertice verticeEscolhido = null;

            List<Aresta> arestasIncidentes = graph.arestasIncidentes(vertice);

            for (Aresta aresta : arestasIncidentes) {
                System.out.print(aresta.getVerticeFim() + " ");
            }
            System.out.println();

            // Para cada aresta incidente, atualizar o seu custo e define o próximo vertice a trabalhar
            for (Aresta aresta : arestasIncidentes) {
                Integer arestaValue = (Integer) aresta.getValue();

                HashMap<String, Object> details = (HashMap) visitedVertices.get(aresta.getVerticeFim().toString());

                HashMap verticeDetails = (HashMap) visitedVertices.get(vertice.toString());
                caminhoCusto = (Integer) verticeDetails.get("caminho_mais_curto");

                if (arestaValue + caminhoCusto < (Integer) details.get("caminho_mais_curto")) {
                    details.put("caminho_mais_curto", caminhoCusto + arestaValue);
                }

                if (arestaValue < min) {
                    min = arestaValue;
                    verticeEscolhido = aresta.getVerticeFim();
                }
            }

            // Definir vertice trabalhado como visitado
            HashMap<String, Object> details = (HashMap) visitedVertices.get(vertice.toString());
            details.put("visitado", true);

            caminhoCusto += min;

            vertice = verticeEscolhido;

            if (vertice == null) {
                vertice = (Vertice) this.returnUnvisited(visitedVertices, vertices);
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
