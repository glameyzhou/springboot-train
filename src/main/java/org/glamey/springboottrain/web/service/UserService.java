package org.glamey.springboottrain.web.service;

import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.lang3.StringUtils;
import org.glamey.springboottrain.web.dao.UserDao;
import org.glamey.springboottrain.web.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhouyang.zhou.
 * @date 2017.12.15.12.
 */

@Service
public class UserService {

  @Autowired
  private UserDao userDao;

  public List<User> listByName(String name) {
    return userDao.listByName(name);
  }

  public User get(Long id) {
    if(id == null) {
      return null;
    }

    return userDao.getById(id);
  }

  public User get(String email) {
    if(StringUtils.isBlank(email)) {
      return null;
    }
    return userDao.getByEmail(email);
  }

  public int delete(Long id) {
    if(id == null || id == 0) {
      return 0;
    }
    return userDao.deleteById(id);
  }

  public int saveBatch(List<User> users) {
    if(CollectionUtils.isEmpty(users)) {
      return 0;
    }
    IterableUtils.forEach(users, user -> userDao.save(user));
    return users.size();
  }
}
