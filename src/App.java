public class App {

  public static void main(String[] args) throws Exception {
    LinkedList list = new LinkedList();
    list.addLast(10);
    list.addLast(20);
    list.addLast(30);
    list.addLast(40);
    list.addLast(50);
    list.addLast(60);

    System.out.println(list.getKthNodeFromLast(2));
  }
}
