package cn.com.tanan.boot.controller;

import cn.com.tanan.boot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

  /* 初始化并绑定私有 service 变量 */
  private RoleService roleService;

  @Autowired
  public void setApplicationService(RoleService roleService) {
    this.roleService = roleService;
  }

  @RequestMapping("/admin/role/all")
  public String retrieveRoles(Model model) {
    model.addAttribute("roles", roleService.getRoles());
    return "admin/index";
  }
}
