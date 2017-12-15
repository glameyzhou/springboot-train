package org.glamey.springboottrain.web.controller;

import com.google.common.collect.Lists;
import java.util.Date;
import java.util.List;
import org.glamey.springboottrain.web.domain.User;
import org.glamey.springboottrain.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouyang.zhou.
 * @date 2017.12.15.12.
 */

@RestController(value = "user")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping(value = "/hello")
  public String hell() {
    return "hello spring boot.";
  }

  @GetMapping(value = "/show/{id}")
  public User getById(@PathVariable(value = "id") Long id) {
    return userService.get(id);
  }

  @GetMapping(value = "/show")
  public User getByEmail(@RequestParam(value = "email") String email) {
    return userService.get(email);
  }

  @GetMapping(value = "/list")
  public List<User> list(@RequestParam(value = "name", required = false) String name) {
    return userService.listByName(name);
  }

  @PostMapping(value = "create")
  public String save(@RequestBody User user) {
    if(user == null) {
      return "error:parameter is null";
    }
    Date date = new Date();
    user.setCreateTime(date);
    user.setUpdateTime(date);
    int count = userService.saveBatch(Lists.newArrayList(user));
    return "create " + count + " users";
  }
}
