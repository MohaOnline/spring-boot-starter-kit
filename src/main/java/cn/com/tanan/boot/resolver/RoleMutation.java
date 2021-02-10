package cn.com.tanan.boot.resolver;

import cn.com.tanan.boot.entity.Role;
import cn.com.tanan.boot.repository.RoleRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleMutation implements GraphQLMutationResolver {
  private final RoleRepository repo;

  @Autowired
  public RoleMutation(RoleRepository repo) {
    this.repo = repo;
  }

  public Role newRole(String name, String description) {
    Role role = new Role(name, description);
    repo.save(role);
    return role;
  }

}
