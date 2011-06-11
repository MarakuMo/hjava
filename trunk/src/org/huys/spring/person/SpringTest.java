package org.huys.spring.person;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class SpringTest
{
	public static void main(String[] args)
	{
		ApplicationContext ctx = new FileSystemXmlApplicationContext("bean.xml");
		Person p = null;
		p = (Person)ctx.getBean("chinese");
		System.out.println(p.sayHello("wawa"));
		System.out.println(p.sayGoodBye("wawa"));
		p = (Person)ctx.getBean("american");
		System.out.println(p.sayHello("wawa"));
		System.out.println(p.sayGoodBye("wawa"));
		Person p2 = null;
		p2 = (Person)ctx.getBean("american");
		System.out.println(p == p2);
	}
}
