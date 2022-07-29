package com.suetham.Graph;

import java.util.List;
import java.util.Vector;

public class Graph implements IGraph {
    private Aresta[][] matriz;
    private final List<Vertice> vertices;

    private int qtdVertices;

    public Graph() {
        matriz = new Aresta[0][0];
        vertices = new Vector<>();
        qtdVertices = 0;
    }


    public Vertice[] finalVertices(Aresta aresta) {
        Vertice[] array = new Vertice[1];

        array[0] = aresta.getVerticeFim();
        return array;
    }

    public Vertice oposto(Vertice vertice, Aresta aresta) {
        if (vertice == aresta.getVerticeInicio()) {
            return aresta.getVerticeFim();
        } else if (vertice == aresta.getVerticeFim()) {
            return aresta.getVerticeInicio();
        }

        throw new Error("Vertice não faz parte dessa aresta");
    }

    public boolean éAdjacente(Vertice vertice1, Vertice vertice2) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i == j) continue;

                Aresta aresta = matriz[i][j];

                if (aresta == null) continue;

                if (aresta.getVerticeInicio() == vertice1 && aresta.getVerticeFim() == vertice2) {
                    return true;
                } else if (aresta.getVerticeInicio() == vertice2 && aresta.getVerticeFim() == vertice1) {
                    return true;
                }
            }
        }

        return false;
    }

    public void substituir(Vertice vertice, Object element) {
        vertice.setElement(element);
    }

    public void substituir(Aresta aresta, Object value) {
        aresta.setValue(value);
    }

    public Vertice inserirVertice(Object element) {
        Vertice vertice = new Vertice(element);

        Aresta[][] novaMatriz = new Aresta[qtdVertices + 1][qtdVertices + 1];

        if (matriz.length != 0) {
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    novaMatriz[i][j] = matriz[i][j];
                }
            }
        }

        vertices.add(vertice);

        matriz = novaMatriz;

        qtdVertices++;

        return vertice;
    }

    public Aresta inserirAresta(Vertice verticeInicio, Vertice verticeFim, Object value, boolean direcionada) {
        Aresta aresta = new Aresta(verticeInicio, verticeFim, value, direcionada);

        int count = 0;

        int indexOfVerticeInicio = vertices.indexOf(verticeInicio);
        int indexOfVerticeFim = vertices.indexOf(verticeFim);

        if (!vertices.contains(verticeInicio)) {
            count += 1;
            vertices.add(verticeInicio);
            indexOfVerticeInicio = vertices.indexOf(verticeInicio);
        }

        if (!vertices.contains(verticeFim)) {
            count += 1;
            vertices.add(verticeFim);
            indexOfVerticeFim = vertices.indexOf(verticeFim);
        }


        if (count > 0) {
            Aresta[][] novaMatriz = new Aresta[matriz.length + count][matriz.length + count];

            if (matriz.length != 0) {
                for (int i = 0; i < matriz.length; i++) {
                    for (int j = 0; j < matriz[i].length; j++) {
                        if (i == j) continue;

                        novaMatriz[i][j] = matriz[i][j];
                    }
                }
            }

            novaMatriz[indexOfVerticeInicio][indexOfVerticeFim] = aresta;
            if (direcionada) {
                novaMatriz[indexOfVerticeFim][indexOfVerticeInicio] = aresta;
            }

            matriz = novaMatriz;

            qtdVertices += count;
        } else {
            matriz[indexOfVerticeInicio][indexOfVerticeFim] = aresta;
            if (direcionada) {
                matriz[indexOfVerticeFim][indexOfVerticeInicio] = aresta;
            }
        }

        return aresta;
    }

    public Vertice removeVertice(Vertice vertice) {
        int indexOfVertice = vertices.indexOf(vertice);

        Aresta[][] novaMatriz = new Aresta[qtdVertices - 1][qtdVertices - 1];

        for (int i = 0; i < matriz.length; i++) {
            if (i == indexOfVertice) {
                continue;
            }

            for (int j = 0; j < matriz[i].length; j++) {
                if (i == j) continue;

                if (j == indexOfVertice) {
                    continue;
                }

                if (i > indexOfVertice) {
                    novaMatriz[i - 1][j] = matriz[i][j];
                } else if (j > indexOfVertice) {
                    novaMatriz[i][j - 1] = matriz[i][j];
                } else {
                    novaMatriz[i][j] = matriz[i][j];
                }
            }
        }

        matriz = novaMatriz;

        return vertice;
    }

    public Aresta removeAresta(Aresta aresta) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i == j) continue;

                if (matriz[i][j] == aresta) {
                    matriz[i][j] = null;
                }
            }
        }

        return aresta;
    }

    public List<Vertice> vertices() {
        return vertices;
    }

    public List<Aresta> arestas() {
        Vector<Aresta> arestas = new Vector<>();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i == j) continue;

                if (matriz[i][j] != null) {
                    arestas.add(matriz[i][j]);
                }
            }
        }

        return arestas;
    }

    public boolean éDirecionada(Aresta aresta) {
        return aresta.getDirecionado();
    }

    public List<Aresta> arestasIncidentes(Vertice vertice) {
        List<Aresta> arestas = new Vector<>();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                Aresta aresta = matriz[i][j];

                if (aresta.getVerticeInicio() == vertice || aresta.getVerticeFim() == vertice) {
                    arestas.add(aresta);
                }
            }
        }

        return arestas;
    }

    public void printGraph() {
        Vector<Aresta> arestaPrinted = new Vector<>();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i == j) {
                    continue;
                }

                Aresta aresta = matriz[i][j];
                if (aresta == null || arestaPrinted.contains(aresta)) {
                    continue;
                }

                arestaPrinted.add(aresta);

                Vertice vertice1 = aresta.getVerticeInicio();
                Vertice vertice2 = aresta.getVerticeFim();
                System.out.println(aresta.getValue() + " " + vertice1.getElement() + " " + vertice2.getElement());
            }
        }
    }
}
