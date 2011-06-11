package org.huys.spring.person;

public  class  PersonFactory
{
	public Person getPerson(String ethnic)
	{
		if (ethnic.equalsIgnoreCase( "chin") )
			return  new  Chinese();
		else
			return  new  American();
	}
}
