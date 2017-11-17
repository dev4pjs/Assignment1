package com.assignment.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.assignment.beans.MetaUploadResponse;
import com.assignment.entiry.MetaInformation;
import com.assignment.exceptions.MyAppCustomeException1;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MetaInfoUploaderService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	List<MetaInformation> tmp_storage = new ArrayList<MetaInformation>(
			Arrays.asList(new MetaInformation(1, "field1Value1", "field2Value1", "field3Value1"),
					new MetaInformation(2, "field1Value2", "field2Value2", "field3Value2")));

	@Value("${myapp.var.fileStorage}")
	private String fileStoragePath;

	// For simplicity i am throwing generic Exceptions.

	public MetaUploadResponse uploadMetaInfo(MultipartFile ufile) throws Exception {

		MetaUploadResponse response = new MetaUploadResponse();
		try {
			
			if (ufile != null) {
				
				// parsist the meta obj in memory storage
				ObjectMapper jsonMapper = new ObjectMapper();
				MetaInformation newMetaInfo = jsonMapper.readValue(ufile.getBytes(), MetaInformation.class);
				
				if(tmp_storage.add(newMetaInfo)) {
					// Save the file
					ufile.transferTo(new File(fileStoragePath + ufile.getOriginalFilename()));					
				}else {
					throw new MyAppCustomeException1(10001, "Duplicate MetaInfo, Please varify the Input!");
				}
				
				response.setError("No Error");
				response.setMessage("Successfully Uploaded!");
			} else {
				throw new MyAppCustomeException1(10001, "Null input sent! Please varify!");
			}
		} catch (Exception e) {
			throw new MyAppCustomeException1(10002, e.getMessage());
		}
		return response;
	}

	public MetaInformation getMetaInfoById(Integer id) {
		return tmp_storage.stream().filter(a->a.getMetaInfoId()==id).findFirst().get();
	}

	public List<MetaInformation> getAllMetaInfo() {
		return tmp_storage;
	}

}
