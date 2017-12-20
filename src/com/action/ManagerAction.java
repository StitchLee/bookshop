package com.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bean.Manager;
import com.service.ManagerService;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class ManagerAction {
	@Autowired
	private ManagerService managerService;

	public ManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}
	//����Ա��֤��¼
	@RequestMapping("/login")
	public String login(Model model,Manager manager) {
		Manager man = managerService.login(manager);
		if(man==null) {
			model.addAttribute("errormsg", "��½ʧ��");
			return "admin/login";
		}else {
			model.addAttribute("name",man.getAdminName());
			return "admin/index";
		}
	}
}
