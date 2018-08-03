import java.util.Scanner;

public abstract class Shapes {
public static final float pi = (float) 3.14;
public static Scanner sideScanner= new Scanner(System.in);
public Shapes() {

}
protected abstract float getArea();
protected abstract float getPerimeter();
}
