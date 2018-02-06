

/**
 * @author Pankaj
 */

public class LinkedList {

    public static void main(String[] args) {
        myLinkedList lList = new myLinkedList();

        lList.add(12);
        lList.add(22);
        lList.add(39);
        lList.add(41);
        lList.add(5);

 
        System.out.println("lList - print linkedlist    : " + lList);
        System.out.println("lList.size() - print linkedlist size   : " + lList.size());
        System.out.println("lList.get(last element) - get last element   : " + lList.get(lList.size()));
        System.out.println("lList.remove("+lList.size()+") - remove tail element: " + lList.remove(lList.size()));
        System.out.println("lList.get(last element) - get last element  : " + lList.get(lList.size()));
        System.out.println("lList.size() - print linkedlist size   : " + lList.size());
        System.out.println("lList - print linkedlist   : " + lList);
        System.out.println("Remove greater than - 30   " + lList.removeAllElement(lList,30));
        System.out.println("lList - print linkedlist After remove all: " + lList);

    }
}

class myLinkedList {
    private Node head;
    private int listCount;

    public myLinkedList() {
        head = new Node(null);
        listCount = 0;
    }

    public void add(Integer data)
    {
        Node lTemp = new Node(data);
        Node lCurrent = head;
        while (lCurrent.getNext() != null) {
            lCurrent = lCurrent.getNext();
        }
        lCurrent.setNext(lTemp);
        listCount++;
    }

    public void add(Integer data, int index)
    {
        Node lTemp = new Node(data);
        Node lCurrent = head;
        for (int i = 1; i < index && lCurrent.getNext() != null; i++) {
            lCurrent = lCurrent.getNext();
        }
        lTemp.setNext(lCurrent.getNext());
        lCurrent.setNext(lTemp);
        listCount++;
    }

    public Integer get(int index)
    {
        if (index <= 0)
            return null;

        Node lCurrent = head.getNext();
        for (int i = 1; i < index; i++) {
            if (lCurrent.getNext() == null)
                return null;

            lCurrent = lCurrent.getNext();
        }
        return lCurrent.getData();
    }

    public boolean remove(int index)
    
    {
        if (index < 1 || index > size())
            return false;

        Node lCurrent = head;
        for (int i = 1; i < index; i++) {
            if (lCurrent.getNext() == null)
                return false;

            lCurrent = lCurrent.getNext();
        }
        lCurrent.setNext(lCurrent.getNext().getNext());
        listCount--; 
        return true;
    }
    boolean removeAllElement( myLinkedList  llist, Integer targetval) {  
    	 for(int i=llist.size();i>0;i--){
    		 if( llist.get(i) >  targetval )
    		 
    		 llist.remove(i);
    		}
    	return true ;
    } 

    public int size()
    {
        return listCount;
    }

    public String toString() {
        Node lCurrent = head.getNext();
        String output = "";
        while (lCurrent != null) {
            output += "[" + lCurrent.getData().toString() + "]";
            lCurrent = lCurrent.getNext();
        }
        return output;
    }

    private class Node {
        Node next;
       Integer data;

        public Node(Integer dataValue) {
            next = null;
            data = dataValue;
        }

        public Node(Integer dataValue, Node nextValue) {
            next = nextValue;
            data = dataValue;
        }

        public Integer getData() {
            return data;
        }

        public void setData(Integer dataValue) {
            data = dataValue;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node nextValue) {
            next = nextValue;
        }
    }
}
