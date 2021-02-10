package cn.com.tanan.boot.service;

import cn.com.tanan.boot.entity.Role;

import java.util.NoSuchElementException;

/**
 * 角色业务接口
 */
public interface RoleService {
  Iterable<Role> getRoles();
  Role getRoleById(int id) throws NoSuchElementException;
}
