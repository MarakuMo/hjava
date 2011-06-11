package org.huys.dp.behavioral.visitor;

abstract class Transaction
{
    public abstract void accept(TransactionVisitor v);
}

interface TransactionVisitor
{
    public void visit(DepositTransaction dt);
    public void visit(WithdrawlTransaction wt);
}

class DepositTransaction extends Transaction
{
    public void accept(TransactionVisitor v) {
        v.visit(this);
    }
}

class WithdrawlTransaction extends Transaction
{
    public void accept(TransactionVisitor v) {
        v.visit(this);
    }
}

abstract class UI
{
    public abstract void show();
}

class DepositUI extends UI
{
    DepositUI(DepositTransaction dt) {

    }

    public void show() {
        System.out.println("DepositUI::show");
    }
}

class WithdrawlUI extends UI
{
    WithdrawlUI(WithdrawlTransaction wt) {

    }

    public void show() {
        System.out.println("WithdrawlUI::show");
    }
}

class TransactionUIFactory implements TransactionVisitor
{
    private UI itsUI;
    public UI getUI() {return itsUI;}
    public void visit(DepositTransaction dt) {
        itsUI = new DepositUI(dt);
    }
    public void visit(WithdrawlTransaction wt) {
        itsUI = new WithdrawlUI(wt);
    }
}

interface CarElementVisitor {
    void visit(Wheel wheel);
    void visit(Engine engine);
    void visit(Body body);
    void visit(Car car);
}

interface CarElement {
    void accept(CarElementVisitor visitor); // CarElements have to provide accept().
}

class Wheel implements CarElement {
    private String name;
    Wheel(String name) {
        this.name = name;
    }
    String getName() {
        return this.name;
    }
    public void accept(CarElementVisitor visitor) {
        visitor.visit(this);
    }
}

class Engine implements CarElement {
    public void accept(CarElementVisitor visitor) {
        visitor.visit(this);
    }
}

class Body implements CarElement {
    public void accept(CarElementVisitor visitor) {
        visitor.visit(this);
    }
}

class Car implements CarElement{
    CarElement[] elements;
    public CarElement[] getElements() {
        return elements.clone(); // Return a copy of the array of references.
    }
    public Car() {
        this.elements = new CarElement[]
          { new Wheel("front left"), new Wheel("front right"),
            new Wheel("back left") , new Wheel("back right"),
            new Body(), new Engine() };
    }
    public void accept(CarElementVisitor visitor) {
        for(CarElement element : this.getElements()) {
            element.accept(visitor);
        }
        visitor.visit(this);
    }

}

class CarElementPrintVisitor implements CarElementVisitor {
    public void visit(Wheel wheel) {
        System.out.println("Visiting "+ wheel.getName()
                            + " wheel");
    }
    public void visit(Engine engine) {
        System.out.println("Visiting engine");
    }
    public void visit(Body body) {
        System.out.println("Visiting body");
    }

    public void visit(Car car) {
        System.out.println("Visited car");
    }
}

class CarElementDoVisitor implements CarElementVisitor {
    public void visit(Wheel wheel) {
        System.out.println("Kicking my "+ wheel.getName() + " wheel");
    }
    public void visit(Engine engine) {
        System.out.println("Starting my engine");
    }
    public void visit(Body body) {
        System.out.println("Moving my body");
    }
    public void visit(Car car) {
        System.out.println("Started car");
    }

}

public class VisitorDemo
{
    public static void main(String[] args) {
        TransactionUIFactory uiFactory = new TransactionUIFactory();
        Transaction transaction = new DepositTransaction();
        transaction.accept(uiFactory);
        uiFactory.getUI().show();

        Transaction transaction2 = new WithdrawlTransaction();
        transaction2.accept(uiFactory);
        uiFactory.getUI().show();

        Car car = new Car();
        car.accept(new CarElementPrintVisitor());
        car.accept(new CarElementDoVisitor());
    }
}
