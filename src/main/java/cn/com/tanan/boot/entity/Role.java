package cn.com.tanan.boot.entity;

// 自动生成 Setter Getter
import cn.com.tanan.boot.common.Constants;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/*
检查数据库结构
H2: SHOW columns FROM role;
 */
@Entity /* Entity annotation 自动创建 role 表 */
public class Role {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY) /* = AUTO_INCREMENT of MySQL */
  @Column(name="id")
  @Getter @Setter private Integer id;

  @Column(name="name", nullable = false)
  @Getter @Setter private String name; // String 默认 255

  @Column(name="status", columnDefinition = "varchar(255) default '" + Constants.STATUS_ACTIVE + "'")
  @Getter @Setter private String status = Constants.STATUS_ACTIVE;

  @Column(length = 1024)
  @Getter @Setter private String description;

  public Role(){}

  public Role (String name, String description) {
    this.name = name;
    this.description = description;
    this.status = Constants.STATUS_ACTIVE;
  }

}
