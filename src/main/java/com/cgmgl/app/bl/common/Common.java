package com.cgmgl.app.bl.common;

public abstract class Common {
	
	public String getImageExtension(String base64String) {
		String[] strings = base64String.split(",");
		String extension;
		switch (strings[0]) {// check image's extension
		case "data:image/jpeg;base64":
			extension = "jpeg";
			break;
		case "data:image/png;base64":
			extension = "png";
			break;
		case "data:image/webp;base64":
			extension = "webp";
			break;
		case "data:image/gif;base64":
			extension = "gif";
			break;
		default:
			extension = "jpg";
			break;
		}
		return extension;
	}
}
