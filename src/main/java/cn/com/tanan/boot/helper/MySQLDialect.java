package cn.com.tanan.boot.helper;

import org.hibernate.dialect.MySQL8Dialect;

/**
 * Usage: spring.jpa.properties.hibernate.dialect=cn.com.tanan.boot.MySQLDialect
 */
public class MySQLDialect extends MySQL8Dialect {
  @Override
  public String getTableTypeString() {
    return " ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_cs";
  }
}
