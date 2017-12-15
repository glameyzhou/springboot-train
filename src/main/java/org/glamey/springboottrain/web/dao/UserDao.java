package org.glamey.springboottrain.web.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.glamey.springboottrain.web.domain.User;
import org.springframework.stereotype.Repository;

/**
 * @author zhouyang.zhou.
 * @date 2017.12.15.12.
 */
@Mapper
@Repository
public interface UserDao {

  List<User> listByName(String name);

  User getById(Long id);

  User getByEmail(String email);

  int deleteById(Long id);

  Integer save(User user);
}
