package FunctionalInterface.java_predicate;

public class Foo {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Foo(int age) {
        this.age = age;
    }

    public boolean say(int a) {
        System.out.println("年龄差");
        return (this.age - a)>0;
    }

}