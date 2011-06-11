package org.huys.dp.creational.factory;

public class FactoryMethod
{
    public static void main(String[] args)
    {
        FMFactory factory = new FMFactory();
        FMBase product1 = factory.produce("cc", 1);
        FMBase product2 = factory.produce("dd", 0);

        System.out.println("Product1 : " + product1.getName());
        System.out.println("Product2 : " + product2.getName());

    }
}

class FMBase
{
    protected String name;
    public String getName()
    {
        return name;
    }
}

class FMSubFirst extends FMBase
{
    public FMSubFirst(String aName)
    {
        name = aName + "_First";
    }
}

class FMSubSecond extends FMBase
{
    public FMSubSecond(String aName)
    {
        name = aName + "_Second";
    }
}

class FMFactory
{
    public FMBase produce(String aName, int flag)
    {
        if (flag > 0)
            return new FMSubFirst(aName);
        else
            return new FMSubSecond(aName);
    }
}

