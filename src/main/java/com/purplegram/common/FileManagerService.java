package com.purplegram.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManagerService {

	// ���� �̹����� ����Ǵ� ���
	public final static String FILE_UPLOAD_PATH = "C:\\6_spring_project\\quiz_sns\\workspace\\images/";

	// input: file
	// output: image path
	public String saveFile(String loginId, MultipartFile file) throws IOException {
		// ���� ���丮 ��� ��: hss8559_16205748673/sun.png
		// ���ϸ��� ��ġ�� �ʰ� �ϱ� ���� ����ð��� ��ο� �ٿ��ش�.
		String directoryName = loginId + "_" + System.currentTimeMillis() + "/";
		String filePath = FILE_UPLOAD_PATH + directoryName;
		
		File directory = new File(filePath);
		if (directory.mkdir() == false) {
			return null;	// ���丮 ���� ���н� path null ����
		}
		
		// ���� ���ε�: byte ������ ���ε� �Ѵ�.
		byte[] bytes = file.getBytes();
		Path path = Paths.get(filePath + file.getOriginalFilename());
		Files.write(path, bytes);
		
		// http://localhost/images/hss8559_165498/sun.png
		return "/images/" + directoryName + file.getOriginalFilename();
	}
}
