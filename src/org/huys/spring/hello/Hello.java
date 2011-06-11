package org.huys.spring.hello;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class Hello {
  public static void main(String[] args) throws Exception {
    BeanFactory factory =  new XmlBeanFactory(new FileSystemResource("bean.xml"));
    GreetingService greetingService = (GreetingService) factory.getBean("greetingService");
    greetingService.sayGreeting();
  }
}
