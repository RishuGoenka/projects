package com.zycus.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zycus.service.CompileExecuteService;

@Controller
public class CompileExecuteController {

	private final String CONFIG_LOCATION = "C:" + File.separator
			+ "Program Files" + File.separator + "Apache Software Foundation"
			+ File.separator + "Tomcat 7.0" + File.separator + "Files"
			+ File.separator + "config" + File.separator + "Run.java";

	@Autowired
	CompileExecuteService service;

	@RequestMapping(value = "/code/onSubmit", method = RequestMethod.POST)
	private String onSubmit(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws IOException,
			InterruptedException {

		// String userId = request.getParameter("userId");
		// String problemId = request.getParameter("problemId");
		int versionNumber = getVersion();
		String userId = "123";
		String problemId = "xyz";
		String code = request.getParameter("text");
		String path = setPath(versionNumber, userId, problemId);

		createDirectory(path);
		System.setProperty("dir", path);
		saveCode(code, path);

		service.compile("Run.java");
		service.execute("Run", userId);

		return "index";
	}

	private void createDirectory(String path) {
		File folder = new File(path);
		if (folder.exists() == false)
			folder.mkdirs();
	}

	private String setPath(int versionNumber, String userId, String problemId) {
		return System.getProperty("catalina.home") + File.separator + "Files"
				+ File.separator + "entries" + File.separator + problemId
				+ File.separator + userId + File.separator + versionNumber
				+ File.separator;
	}

	private int getVersion() {
		// Write code to get latest version from Database
		// Return next version number. if last stored was 2, return 3
		return 0;
	}

	private void saveCode(String code, String path) throws IOException,
			InterruptedException {
		initializeEnvironment(path);
		File file = new File(path + "Main.java");
		FileWriter fw = new FileWriter(file);
		fw.write(code);
		fw.close();
	}

	private void initializeEnvironment(String path) throws IOException {
		File destination = new File(path + "Run.java");
		File source = new File(this.CONFIG_LOCATION);
		Files.copy(source.toPath(), destination.toPath(),
				StandardCopyOption.REPLACE_EXISTING);
	}

}
