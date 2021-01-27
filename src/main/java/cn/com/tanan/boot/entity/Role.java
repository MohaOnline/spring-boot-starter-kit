package cn.com.tanan.boot.entity;

// 自动生成 Setter Getter
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    @Getter @Setter private Integer id;

    @Column(nullable = false)
    private String name; // String 默认 255

    @Column(length = 1024)
    private String description;

}
