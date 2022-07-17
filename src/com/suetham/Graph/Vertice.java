package com.suetham.Graph;

public class Vertice {
    private Object element;

    public Vertice(Object element) {
        this.element = element;
    }

    public Object getElement() {
        return this.element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return this.element.toString();
    }
}
