public class Main {
    public static void main(String[] args) {
        DoublyLinkedListCustom list = new DoublyLinkedListCustom();

        // Test addFirst
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        System.out.print("List after addFirst: ");
        list.printList();  // Output: 3 2 1

        // Test addLast
        list.addLast(4);
        list.addLast(5);
        System.out.print("List after addLast: ");
        list.printList();  // Output: 3 2 1 4 5

        // Test addAtIndex
        list.addAtIndex(2, 6);
        System.out.print("List after addAtIndex: ");
        list.printList();  // Output: 3 2 6 1 4 5

        // Test addElementAtRandomIndex
        list.addElementAtRandomIndex(7);
        System.out.print("List after addElementAtRandomIndex: ");
        list.printList();  // Output: Randomly placed 7 in the list

        // Test removeFirst
        Node removedFirst = list.removeFirst();
        System.out.println("Removed first element: " + removedFirst.getValue());
        System.out.print("List after removeFirst: ");
        list.printList();  // Output: 2 6 1 4 5

        // Test removeLast
        Node removedLast = list.removeLast();
        System.out.println("Removed last element: " + removedLast.getValue());
        System.out.print("List after removeLast: ");
        list.printList();  // Output: 2 6 1 4

        // Test removeAtIndex
        Node removedAtIndex = list.removeAtIndex(1);
        System.out.println("Removed element at index 1: " + removedAtIndex.getValue());
        System.out.print("List after removeAtIndex: ");
        list.printList();  // Output: 2 1 4

        // Test getSize
        System.out.println("Current size of the list: " + list.getSize());  // Output: 3

        // Test isEmpty
        System.out.println("Is the list empty? " + list.isEmpty());  // Output: false

        // Test printList
        System.out.print("Current list: ");
        list.printList();  // Output: 2 1 4

        // Test printListBackwards
        System.out.print("Current list backwards: ");
        list.printListBackwards();  // Output: 4 1 2

        // Test get
        System.out.println("Element at index 1: " + list.get(1));  // Output: 1

        // Test reverseList
        list.reverseList();
        System.out.print("Reversed list: ");
        list.printList();  // Output: 4 1 2

        // Test copyList
        DoublyLinkedListCustom copy = list.copyList();
        System.out.print("Copied list: ");
        copy.printList();  // Output: 4 1 2

        // Test clear
        list.clear();
        System.out.println("List cleared. Is the list empty now? " + list.isEmpty());  // Output: true

        // Test insertAfter
        list.addLast(10);
        list.addLast(20);
        list.insertAfter(10, 15);
        System.out.print("List after insertAfter: ");
        list.printList();  // Output: 10 15 20

        // Test deleteKey
        Node deletedKey = list.deleteKey(15);
        System.out.println("Deleted key: " + deletedKey.getValue());
        System.out.print("List after deleteKey: ");
        list.printList();  // Output: 10 20
    }
}