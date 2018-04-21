package com.bigdata.common.controller;

import org.springframework.stereotype.Controller;

import com.bigdata.common.utils.ShiroUtils;
import com.bigdata.system.domain.SysUserDO;

@Controller
public class BaseController {
	public SysUserDO getUser() {
		return ShiroUtils.getUser();
	}

	public Long getUserId() {
		return getUser().getUserId();
	}

	public String getUsername() {
		return getUser().getUsername();
	}
}