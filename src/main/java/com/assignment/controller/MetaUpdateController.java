package com.assignment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.assignment.beans.ErrorResponse;
import com.assignment.beans.MetaUploadResponse;
import com.assignment.entiry.MetaInformation;
import com.assignment.service.MetaInfoUploaderService;

@RestController
@RequestMapping("/api")
public class MetaUpdateController {


	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping(value="/echo/{msg}")
	public String echoMsg(@PathVariable(value="msg") String msg) {
		logger.debug("Inside echoMsg()");
		return "You Said :"+msg;
	}
	
	
	@Autowired
	private MetaInfoUploaderService metaUploadService;
	
	@PostMapping(value = "/metaupload", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<MetaUploadResponse> uploadMetaData(@RequestParam("ufile") MultipartFile ufile) throws Exception {

		MetaUploadResponse response = metaUploadService.uploadMetaInfo(ufile);
		return new ResponseEntity<MetaUploadResponse>(response,HttpStatus.OK);
	}
	
	
	
	@GetMapping(value = "/metainfo/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<MetaInformation> getMetaInfoById(@PathVariable("id") Integer id){
		MetaInformation response = metaUploadService.getMetaInfoById(id);
		return new ResponseEntity<MetaInformation>(response,HttpStatus.OK);
	}
	
	@GetMapping(value = "/metainfo/", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<MetaInformation>> getAllMetaInfo(){
		List<MetaInformation> response = metaUploadService.getAllMetaInfo();
		return new ResponseEntity<List<MetaInformation>>(response,HttpStatus.OK);
	}
	
	
}
