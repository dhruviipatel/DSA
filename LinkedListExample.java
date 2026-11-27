public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.insert(22);
        l1.insert(12);
        l1.insert(11);
        l1.insertAt(2, 90);
        l1.insertAtStart(15);
        l1.deleteAt(0);
        l1.show();
    }
}

class Node {
    int data;
    Node next;
}

class LinkedList {
    Node head;

    public int getTotalLength(String operation) {
        int count = 0;
        Node n = head;

        while (n.next != null) {
            count++;
            n = n.next;
        }
        count = count + 1;

        System.out.println(operation + " " + count);
        return count;

    }

    public void show() {
        Node n = head;

        while (n.next != null) {
            System.out.println(n.data);
            n = n.next;
        }
        System.out.println(n.data);
    }

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

    public void insertAt(int index, int data) {
        Node node = new Node();
        node.data = data;
        node.next = null;

        Node n = head;

        int totalLength = getTotalLength("Before Insert AT");

        if (index < totalLength) {
            if (index == 0) {
                insertAtStart(data);

            } else {
                for (int i = 0; i < index - 1; i++) {
                    n = n.next;
                }
                node.next = n.next;
                n.next = node;
            }

            int l1 = getTotalLength("After Insert AT");

        } else {
            System.out.println("Insert at Invalid index");
        }
    }

    public void deleteAt(int index) {
        int totalLength = getTotalLength("Before delete");

        if (index < totalLength) {
            if (index == 0) {
                head = head.next;
            } else {
                Node n = head;
                for (int i = 0; i < index - 1; i++) {
                    n = n.next;
                }
                n.next = n.next.next;
            }
            int after = getTotalLength("After delete");
        } else {
            System.out.println("Invalid index to be delete ");
        }
    }
}