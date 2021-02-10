package cn.com.tanan.boot.controller.admin;

import cn.com.tanan.boot.entity.Role;
import cn.com.tanan.boot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RequestMapping("/rest/admin/role")
@RestController /* @see @RestController = @Controller + @ResponseBody */
public class RestRoleController {

  private RoleService roleService;

  @Autowired
  public void setRoleService(RoleService roleService) {
    this.roleService = roleService;
  }

  @GetMapping("/")
  public ResponseEntity<List<Role>> getRoles() {
    List<Role> list = (List<Role>) roleService.getRoles();
    return new ResponseEntity<>(list, HttpStatus.OK);
  }

  @GetMapping("/id/{id}")
  public ResponseEntity<Role> getRoleById(@PathVariable("id") int id) {
    try {
      return new ResponseEntity<>(roleService.getRoleById(id), HttpStatus.OK);
    } catch (NoSuchElementException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Role doesn't exist.", e);
    }
  }
}
