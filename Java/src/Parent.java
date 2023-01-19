
public class Parent {
    private int num1;
    int num2;

    public Parent() {
        this.num1 = 1234;
        this.num2 = 4321;
    }

    protected int methodA() {
        return this.num2 + this.num1;
    }
}
