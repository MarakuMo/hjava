package org.huys.spring.person;

public class FactoryTest
{
	public static void main(String[] args)
	{
		PersonFactory pf = new PersonFactory();
		Person p = null;
		p = pf.getPerson("chin");
		
		System.out.println(p.sayHello("wawa"));
		System.out.println(p.sayGoodBye("wawa"));
		
		p = pf.getPerson("ame");
		
		System.out.println(p.sayHello("wawa"));
		System.out.println(p.sayGoodBye("wawa"));		
	}
}