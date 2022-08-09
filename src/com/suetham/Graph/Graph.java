package com.suetham.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Graph implements IGraph {
    private List[][] matriz;
    private final List<Vertice> vertices;

    private int qtdVertices;

    public Graph() {
        matriz = new ArrayList[0][0];
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

                List listOfArestas = matriz[i][j];

                if (listOfArestas == null) continue;

                if (listOfArestas.contains(vertice1) && listOfArestas.contains(vertice2)) {
                    return true;
                } else if (listOfArestas.contains(vertice2) && listOfArestas.contains(vertice1)) {
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

        // nova
//        Aresta[][] novaMatriz = new Aresta[qtdVertices + 1][qtdVertices + 1];
        List[][] novaMatriz = new ArrayList[qtdVertices + 1][qtdVertices + 1];

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
            List[][] novaMatriz = new List[matriz.length + count][matriz.length + count];

            if (matriz.length != 0) {
                for (int i = 0; i < matriz.length; i++) {
                    for (int j = 0; j < matriz[i].length; j++) {
                        if (i == j) continue;

                        novaMatriz[i][j] = matriz[i][j];
                    }
                }
            }

            if (novaMatriz[indexOfVerticeInicio][indexOfVerticeFim] == null) {
                novaMatriz[indexOfVerticeInicio][indexOfVerticeFim] = new ArrayList<Aresta>();
            }

            novaMatriz[indexOfVerticeInicio][indexOfVerticeFim].add(aresta);
            if (!direcionada) {
                if (novaMatriz[indexOfVerticeFim][indexOfVerticeInicio] == null) {
                    novaMatriz[indexOfVerticeFim][indexOfVerticeInicio] = new ArrayList<Aresta>();
                }

                novaMatriz[indexOfVerticeFim][indexOfVerticeInicio].add(aresta);
            }

            matriz = novaMatriz;

            qtdVertices += count;
        } else {
            if (matriz[indexOfVerticeInicio][indexOfVerticeFim] == null) {
                matriz[indexOfVerticeInicio][indexOfVerticeFim] = new ArrayList<Aresta>();
            }

            matriz[indexOfVerticeInicio][indexOfVerticeFim].add(aresta);
            if (!direcionada) {
                if (matriz[indexOfVerticeFim][indexOfVerticeInicio] == null) {
                    matriz[indexOfVerticeFim][indexOfVerticeInicio] = new ArrayList<Aresta>();
                }

                matriz[indexOfVerticeFim][indexOfVerticeInicio].add(aresta);
            }
        }

        return aresta;
    }

    public Vertice removeVertice(Vertice vertice) {
        int indexOfVertice = vertices.indexOf(vertice);

        List[][] novaMatriz = new List[qtdVertices - 1][qtdVertices - 1];

        for (int i = 0; i < matriz.length; i++) {
            if (i == indexOfVertice) {
                continue;
            }

            for (int j = 0; j < matriz[i].length; j++) {
                if (i == j) continue;

                if (j == indexOfVertice) {
                    continue;
                }

                else if (i > indexOfVertice && j > indexOfVertice) {
                    novaMatriz[i - 1][j - 1] = matriz[i][j];
                } if (i > indexOfVertice) {
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

                if (matriz[i][j].contains(aresta)) {
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
                    for (Object aresta : matriz[i][j]) {
                        arestas.add((Aresta) aresta);
                    }
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
                List listOfArestas = matriz[i][j];

                if (listOfArestas == null) {
                    continue;
                }

                for (Object aresta : arestas) {
                    if (((Aresta) aresta).getDirecionado() && ((Aresta) aresta).getVerticeInicio() == vertice) {
                        arestas.add((Aresta) aresta);
                    } else if (((Aresta) aresta).getVerticeInicio() == vertice || ((Aresta) aresta).getVerticeFim() == vertice) {
                        arestas.add((Aresta) aresta);
                    }
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

                List listOfArestas = matriz[i][j];

                if (listOfArestas == null) {
                    continue;
                }

                for (Object aresta : listOfArestas) {
                    if (!arestaPrinted.contains((Aresta) aresta)) {
                        arestaPrinted.add((Aresta) aresta);

                        Vertice vertice1 = ((Aresta) aresta).getVerticeInicio();
                        Vertice vertice2 = ((Aresta) aresta).getVerticeFim();
                        System.out.println(((Aresta) aresta).getValue() + " " + vertice1.getElement() + " " + vertice2.getElement() + " " + ((Aresta) aresta).getDirecionado());
                    }
                }

            }
        }
    }
}
