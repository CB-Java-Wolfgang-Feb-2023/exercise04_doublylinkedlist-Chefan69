public class DoublyLinkedListCustom implements MyListInterface {
    private Node head;
    private Node tail;
    private int size;

    @Override
    public void addFirst(int item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(int item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }
        size++;
    }

    @Override
    public void addAtIndex(int index, int item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        } else {
            Node newNode = new Node(item);
            Node current = getNodeAtIndex(index - 1);

            newNode.setNext(current.getNext());
            newNode.setPrevious(current);
            current.getNext().setPrevious(newNode);
            current.setNext(newNode);

            size++;
        }
    }

    @Override
    public void addElementAtRandomIndex(int value) {
        // Add element at a random index (between 0 and size)
        int index = (int) (Math.random() * (size + 1));
        addAtIndex(index, value);
    }

    @Override
    public Node removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node removedNode = head;
        if (size == 1) {
            head = tail = null;
        } else {
            head = head.getNext();
            head.setPrevious(null);
        }
        size--;
        return removedNode;
    }

    @Override
    public Node removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node removedNode = tail;
        if (size == 1) {
            head = tail = null;
        } else {
            tail = tail.getPrevious();
            tail.setNext(null);
        }
        size--;
        return removedNode;
    }

    @Override
    public Node removeAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node removedNode;

        if (index == 0) {
            removedNode = removeFirst();
        } else if (index == size - 1) {
            removedNode = removeLast();
        } else {
            Node current = getNodeAtIndex(index);
            removedNode = current;
            current.getPrevious().setNext(current.getNext());
            current.getNext().setPrevious(current.getPrevious());
            size--;
        }

        return removedNode;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    @Override
    public void printListBackwards() {
        Node current = tail;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getPrevious();
        }
        System.out.println();
    }

    @Override
    public int get(int index) throws IllegalArgumentException {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        return getNodeAtIndex(index).getValue();
    }

    @Override
    public void removeDuplicates() {
        // Implement removing duplicate elements if needed
    }

    @Override
    public void reverseList() {
        Node current = head;
        Node temp;
        while (current != null) {
            temp = current.getNext();
            current.setNext(current.getPrevious());
            current.setPrevious(temp);
            current = temp;
        }
        temp = head;
        head = tail;
        tail = temp;
    }

    @Override
    public DoublyLinkedListCustom copyList() {
        DoublyLinkedListCustom copy = new DoublyLinkedListCustom();
        Node current = head;
        while (current != null) {
            copy.addLast(current.getValue());
            current = current.getNext();
        }
        return copy;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public boolean insertAfter(int key, int data) {
        Node current = head;
        while (current != null) {
            if (current.getValue() == key) {
                Node newNode = new Node(data);
                newNode.setNext(current.getNext());
                newNode.setPrevious(current);
                if (current.getNext() != null) {
                    current.getNext().setPrevious(newNode);
                }
                current.setNext(newNode);
                size++;
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public Node deleteKey(int key) {
        Node current = head;
        while (current != null) {
            if (current.getValue() == key) {
                if (current == head) {
                    return removeFirst();
                } else if (current == tail) {
                    return removeLast();
                } else {
                    current.getPrevious().setNext(current.getNext());
                    current.getNext().setPrevious(current.getPrevious());
                    size--;
                    return current;
                }
            }
            current = current.getNext();
        }
        return null;
    }

    private Node getNodeAtIndex(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }
}
