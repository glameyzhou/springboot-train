package org.glamey.springboottrain.properties;

import java.util.List;
import org.glamey.springboottrain.BaseTester;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhouyang.zhou.
 * @date 2017.12.15.23.
 */
public class UserPropertiesTest extends BaseTester {

  @Autowired
  private UserProperties userProperties;

  @Test
  public void testProperties() {

    Assert.assertEquals("glamey", userProperties.getName());
    Assert.assertTrue(userProperties.getAge().intValue() == 33);
    Assert.assertEquals("glamey@glamey.com", userProperties.getEmail());
    List<String> addresses = userProperties.getAddresses();
    for (String address : addresses) {
      System.out.println(address);
    }
  }
}