package main.java.algorithms;

public class LinkedSortedList {
    Link link = null;

    public void add(Link newL) {
        Link current = link;
        Link previous = null;

        while (current != null && current.getData() < newL.getData()) {

            previous = current;
            current = current.getNext();

        }
        if (previous == null) // начало
            link = newL;
        else // конец или середина
            previous.setNext(newL);
        newL.setNext(current);


    }

    public static void main(String[] args) {
        LinkedSortedList linkedSortedList = new LinkedSortedList();
        System.out.println(linkedSortedList);


        linkedSortedList.add(new Link(1));
        linkedSortedList.add(new Link(2));
        linkedSortedList.add(new Link(9));
        linkedSortedList.add(new Link(5));
        linkedSortedList.add(new Link(6));
        linkedSortedList.add(new Link(4));
        linkedSortedList.add(new Link(11));
        linkedSortedList.add(new Link(3));
        linkedSortedList.add(new Link(7));
        linkedSortedList.add(new Link(0));
        linkedSortedList.add(new Link(-2));

        System.out.println(linkedSortedList);

    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        while (link != null) {

            sb.append(link.toString());
            link = link.getNext();
            sb.append('\n');
        }
        return sb.toString();
    }
}
