package com.suetham.Graph;

import java.util.List;

public interface IGraph {
    Vertice[] finalVertices(Aresta aresta);
    Vertice oposto(Vertice vertice, Aresta aresta);
    boolean éAdjacente(Vertice vertice1, Vertice vertice2);
    void substituir(Vertice vertice, Object element);
    void substituir(Aresta aresta, Object value);
    Vertice inserirVertice(Object element);
    Aresta inserirAresta(Vertice vertice1, Vertice vertice2, Object value);
    Vertice removeVertice(Vertice vertice);
    Aresta removeAresta(Aresta aresta);
    List<Vertice> vertices();
    List<Aresta> arestas();
    boolean éDirecionada(Aresta aresta);
    List<Aresta> arestasIncidentes(Vertice vertice);
}
