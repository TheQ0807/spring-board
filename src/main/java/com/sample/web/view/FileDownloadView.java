package com.sample.web.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class FileDownloadView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String directory = (String) model.get("directory");
		String filename = (String) model.get("filename");
		String originalFilename = URLEncoder.encode(filename.substring(13), "utf-8");
		
		File file = new File(directory, filename);
		FileInputStream in = new FileInputStream(file);
		
		
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Length", String.valueOf(file.length()));
		response.setHeader("Content-Disposition", "attachment; filename='"+originalFilename+"'");
		
		OutputStream out = response.getOutputStream();
		
		FileCopyUtils.copy(in, out);
		
	}
	
}
