package in.lnt.day1;
public class Example<B> {
B b;
public <B> void printMe(B b) {
System.out.println(b.getClass().getName());
}
public static void main(String args[]) {
Example<Example> b = new Example<Example>();
b.printMe("Hello, World");
}
}