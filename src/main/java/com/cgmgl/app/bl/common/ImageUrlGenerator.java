package com.cgmgl.app.bl.common;

import javax.servlet.ServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ImageUrlGenerator {

	@RequestMapping("resources/images/{image_path}")
	@ResponseBody
	public String getPhoto(@PathVariable String image_path, ServletRequest request) {
		return Common.getRootStoragePath(request) + image_path;
	}
}
