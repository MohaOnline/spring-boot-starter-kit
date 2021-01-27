package cn.com.tanan.boot.repository;

import cn.com.tanan.boot.entity.Role;
import org.springframework.data.repository.CrudRepository;

/* 准备此接口后可以自动实现 Role 表的增删改查 */
public interface RoleRepository extends CrudRepository<Role, Integer> {}
