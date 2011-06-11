package org.huys.spring.person;

public class Chinese implements Person
{
	public String sayHello(String name)
	{
		return name + ", ÄúºÃ" ;
	}

	public String sayGoodBye(String name)
	{
		return name + ", ÔÙ¼û";
	}
}
