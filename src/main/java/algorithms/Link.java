package main.java.algorithms;

public class Link {
    private int data;
    private Link next = null;

    public void setNext(Link next) {
        this.next = next;
    }
    public Link getNext() {
        return next;
    }

    public boolean hasNext(){
        return next != null;
    }

    public Link(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }


    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        return "Link{" +
                "data='" + data + '\'' +
                '}' /*+ ((next != null)? next :  "")*/;
    }


}
