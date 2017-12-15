package org.glamey.springboottrain.web.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import lombok.Data;

/**
 * @author zhouyang.zhou.
 * @date 2017.12.15.12.
 */

@Data
public class User implements java.io.Serializable {
  private Long id;
  private String name;
  private String email;
  @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
  private Date createTime;
  @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
  private Date updateTime;
}
