package cn.com.tanan.boot.resolver;

import cn.com.tanan.boot.entity.Role;
import cn.com.tanan.boot.repository.RoleRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleQuery implements GraphQLQueryResolver {
  private final RoleRepository repo;

  @Autowired
  public RoleQuery(RoleRepository repo) {
    this.repo = repo;
  }

  public Iterable<Role> getRoles() {
    return repo.findAll();
  }

  public long countRoles() {
    return repo.count();
  }
}
