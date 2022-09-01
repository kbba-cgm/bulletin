package com.cgmgl.app.bl.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import javax.servlet.ServletRequest;

import org.apache.commons.codec.binary.Base64;

public abstract class Common {

	public static String getImageExtension(String base64String) {
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

	public static String getProfileImgStorePath(String base64String, ServletRequest request) throws IOException {
		if (base64String == null || base64String.length() <= 0)
			return null;

		String file_path = getRootStoragePath(request) + "profiles";
		if (!Files.exists(Paths.get(file_path)))
			Files.createDirectories(Paths.get(file_path));

		String fileExtension = getImageExtension(base64String);
		UUID fileName = UUID.randomUUID();

		file_path = Paths.get(file_path) + "/" + fileName + "." + fileExtension;

		return file_path;
	}

	public static String getRootStoragePath(ServletRequest request) {
		return request.getServletContext().getRealPath("/") + "resources/images/";
	}

	@SuppressWarnings("resource")
	public static String fileToBase64String(String file_path) throws IOException {
		if (file_path == null || file_path.length() <= 0)
			return null;
		
		String imageString = null;
		File file = new File(file_path);
		if (file.getAbsoluteFile().exists()) {
			FileInputStream fis = new FileInputStream(file);
			byte byteArray[] = new byte[(int) file.length()];
			fis.read(byteArray);
			imageString = "data:image/png;base64," + Base64.encodeBase64String(byteArray);
		}

		return imageString;
	}

}
