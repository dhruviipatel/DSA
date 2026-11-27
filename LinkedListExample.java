public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(31);
        list.insertAtStart(21);
        list.insertAtStart(28);
        list.insertAtIndex(2, 18);
        list.insertAtIndex(0, 1);
        list.deleteAt(0);
        list.show();
    }
}

class Node {
    int data;
    Node next;

}

class LinkedList {
    Node head;

    public void insert(int data) {
        Node node = new Node();
        node.data = data;
        node.next = null;

        if (head == null) {
            head = node;
        } else {
            Node n = head;

            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
    }

    public void insertAtStart(int data) {
        Node node = new Node();
        node.data = data;
        node.next = null;
        node.next = head;
        head = node;
    }

    public void insertAtIndex(int index, int data) {
        Node node = new Node();
        node.data = data;
        node.next = null;

        Node n = head;
        if (n == null) {
            return;
        }

        if (index == 0) {
            insertAtStart(data);
        } else {
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            node.next = n.next;
            n.next = node;

        }
    }

    public void deleteAt(int index) {
        if (index == 0) {
            head = head.next;
        } else {
            Node n1 = null;
            Node n = head;
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            n1 = n.next;
            n.next = n1.next;
        }
    }

    public void show() {
        Node node = head;

        while (node.next != null) {
            System.out.println(node.data);
            node = node.next;
        }
        System.out.println(node.data);
    }
}
