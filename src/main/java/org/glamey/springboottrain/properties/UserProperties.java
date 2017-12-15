package org.glamey.springboottrain.properties;

import java.util.List;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zhouyang.zhou.
 * @date 2017.12.15.23.
 */
@Data
@ConfigurationProperties(prefix = "propertiesDemo.user")
@EnableConfigurationProperties
@Component
public class UserProperties {
  private String name;
  private Integer age;
  private String email;
  private List<String> addresses;
}
