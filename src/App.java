public class App {

  public static void main(String[] args) throws Exception {
    String str = "(1+2))(";
    Expression exp = new Expression();
    boolean result = exp.isBalanced(str);
    System.out.println(result);
  }
}
