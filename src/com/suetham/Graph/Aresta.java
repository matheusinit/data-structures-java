package com.suetham.Graph;

public class Aresta {
    private Vertice verticeInicio;
    private Vertice verticeFim;
    private Object value;
    private final boolean direcionado;

    public Aresta(Vertice verticeInicio, Vertice verticeFim, Object value, boolean direcionado) {
        this.verticeInicio = verticeInicio;
        this.verticeFim = verticeFim;
        this.value = value;
        this.direcionado = direcionado;
    }

    public Vertice getVerticeInicio() {
        return this.verticeInicio;
    }

    public void setVerticeInicio(Vertice verticeInicio) {
        this.verticeInicio = verticeInicio;
    }

    public Vertice getVerticeFim() {
        return this.verticeFim;
    }

    public void setVerticeFim(Vertice verticeFim) {
        this.verticeFim = verticeFim;
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public boolean getDirecionado() {
        return this.direcionado;
    }

    public String toString() {
        return verticeInicio.getElement() + " " + verticeFim.getElement() + " " + value + " " + direcionado;
    }
}
