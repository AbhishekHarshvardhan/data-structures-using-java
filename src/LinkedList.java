import java.util.NoSuchElementException;

public class LinkedList {

  private Node first;
  private Node last;
  private int size;

  public LinkedList() {
    first = null;
    last = null;
  }

  public void addLast(int num) {
    Node newNode = new Node(num);
    if (isEmpty()) {
      first = last = newNode;
    } else {
      last.setNext(newNode);
      last = newNode;
    }
    size++;
  }

  public void addFirst(int num) {
    Node newNode = new Node(num);
    if (isEmpty()) {
      first = last = newNode;
    } else {
      newNode.setNext(first);
      first = newNode;
    }
    size++;
  }

  public int indexOf(int item) {
    int index = 0;
    Node current = first;
    while (current.getNext() != null) {
      if (current.getValue() == item) {
        return index;
      }
      current = current.getNext();
      index++;
    }
    return -1;
  }

  public boolean contains(int item) {
    return indexOf(item) != -1;
  }

  public void removeFirst() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    if (first.getNext() == null) {
      first = last = null;
    } else {
      Node second = first.getNext();
      first.setNext(null);
      first = second;
    }
    size--;
  }

  public void removeLast() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    if (first == last) {
      first = last = null;
    } else {
      Node previous = getPrevious(last);
      last = previous;
      last.setNext(null);
    }
    size--;
  }

  private Node getPrevious(Node node) {
    Node current = first;
    while (current.getNext() != null) {
      if (current.getNext() == node) {
        return current;
      }
      current = current.getNext();
    }
    return null;
  }

  private boolean isEmpty() {
    return first == null;
  }

  public int size() {
    return size;
  }

  public int[] toArray() {
    int[] array = new int[size];
    Node current = first;
    int index = 0;
    while (current != null) {
      array[index++] = current.getValue();
      current = current.getNext();
    }
    return array;
  }

  public void reverse() {
    if (first == null) {
      return;
    }
    Node previous = first;
    Node current = first.getNext();
    while (current != null) {
      Node next = current.getNext();
      current.setNext(previous);
      previous = current;
      current = next;
    }

    last = first;
    last.setNext(null);
    first = previous;
  }

  public Node getKthNodeFromLast(int k) {
    Node a = first;
    Node b = first;
    for (int i = 0; i < k - 1; i++) {
      b = b.getNext();
    }
    while (b != last) {
      a = a.getNext();
      b = b.getNext();
    }
    return a;
  }

  public Node getMiddle() {
    Node a = first;
    Node b = first;

    while (b != last && b.getNext() != last) {
      a = a.getNext();
      b = b.getNext();
      if (b.getNext() != null) {
        b = b.getNext();
      }
    }

    return a;
  }
}
