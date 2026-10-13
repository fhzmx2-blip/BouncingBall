package _1213;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 10; i++) {
            Ball a = new Ball();
            System.out.println("i = " + i);
            System.out.println(a.getX()+"/"+a.getY());
        }
    }
}