package cn.com.tanan.boot.service;

import cn.com.tanan.boot.entity.Role;
import cn.com.tanan.boot.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

  private final RoleRepository roleRepository;

  @Autowired
  public RoleServiceImpl(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }


  /** 返回全部角色 */
  @Override
  public Iterable<Role> getRoles() {
    return roleRepository.findAll();
  }
}
