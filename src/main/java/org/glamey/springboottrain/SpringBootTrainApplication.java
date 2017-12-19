package org.glamey.springboottrain;

import java.util.Iterator;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

@SpringBootApplication
public class SpringBootTrainApplication {

  public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(SpringBootTrainApplication.class, args);
    System.out.println(context.getBeanFactory());
    //打印环境变量内容
    //printEnvironment(context);
  }

  private static void printEnvironment(ConfigurableApplicationContext context) {

    System.out.println("----------------------[Environment]------------------------------");
    MutablePropertySources propertySources = context.getEnvironment().getPropertySources();
    if(propertySources != null) {
      System.out.println("----------[Properties Sources]------------------>");
      Iterator<PropertySource<?>> iterator = propertySources.iterator();
      while (iterator.hasNext()) {
        PropertySource<?> propertySource = iterator.next();
        String name = propertySource.getName();
        System.out.printf("%s --> %s\n", name, propertySource.getProperty(name));
      }
      System.out.println();
    }

    System.out.println("----------[System Properties]------------------>");
    Map<String, Object> systemProperties = context.getEnvironment().getSystemProperties();
    for (Map.Entry<String, Object> entry : systemProperties.entrySet()) {
      System.out.printf("%s --> %s\n", entry.getKey(), entry.getValue());
    }
    System.out.println();

    System.out.println("----------[System Environment]------------------>");
    Map<String, Object> systemEnvironment = context.getEnvironment().getSystemEnvironment();
    for (Map.Entry<String, Object> entry : systemEnvironment.entrySet()) {
      System.out.printf("%s --> %s\n", entry.getKey(), entry.getValue());
    }
    System.out.println();
  }
}
