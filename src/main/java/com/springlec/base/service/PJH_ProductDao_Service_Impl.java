package com.springlec.base.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springlec.base.dao.PJH_ProductDao;
import com.springlec.base.model.PJH_ProductDto;

import jakarta.servlet.http.HttpServletRequest;
@Service
public class PJH_ProductDao_Service_Impl implements PJH_ProductDao_Service {
	
	@Autowired
	PJH_ProductDao dao;
	
	
	@Override
	public List<PJH_ProductDto> productList() throws Exception {
	    List<PJH_ProductDto> dtos = dao.productList();
	    
	    for (PJH_ProductDto dto : dtos) {
	        String uploadPath = "image/";
	        String fileName = dto.getPfilename();
	        String imagePath = uploadPath + fileName;
	        dto.setPfilename(imagePath);
	    }
	    
	    return dtos;
	}


	@Override
	public List<PJH_ProductDto> search1(String list, String query) throws Exception {
		System.out.println(list);
		System.out.println(query);
		if (list.equals("pcategory")) {
	        if (query.contains("조") || query.contains("명")) {
	            query = "0";
	        } else if (query.contains("미") || query.contains("니") || query.contains("어") || query.contains("쳐")) {
	            query = "1";
	        } else if (query.contains("의") || query.contains("자")) {
	            query = "2";
	        }
	    }

	    query = '%' + query + '%';

	    List<PJH_ProductDto> dtos = dao.search1(list, query);

	    for (PJH_ProductDto dto : dtos) {
	        String uploadPath = "image/";
	        String fileName = dto.getPfilename();
	        String imagePath = uploadPath + fileName;
	        dto.setPfilename(imagePath);
	    }

	    return dtos;
	}

	@Override
	 public void saveProduct1(String pname, int pprice, int pstock, MultipartFile file, int pcategory, String pcontent, MultipartFile file1, MultipartFile file2, String uploadPath) throws Exception {
		 String fileName = saveFile(file, uploadPath);
		    String newFileName1 = saveFile(file1, uploadPath);
		    String newFileName2 = saveFile(file2, uploadPath);

		    Map<String, Object> params = new HashMap<>();
		    params.put("pname", pname);
		    params.put("pprice", pprice);
		    params.put("pstock", pstock);
		    params.put("file", fileName);
		    params.put("pcategory", pcategory);
		    params.put("pcontent", pcontent);
		    params.put("file1", newFileName1);
		    params.put("file2", newFileName2);

		    dao.saveProduct1(params);
		}
	
	private String saveFile(MultipartFile file, String directory) throws Exception {
	    if (file.isEmpty()) {
	        return null;
	    }

	    String originalFileName = file.getOriginalFilename();

	    Path filePath = Path.of(directory, originalFileName);
	    Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

	    return originalFileName;
	}


	@Override
	public void modify(String pname, int pprice, int pstock, MultipartFile pfilename, String pcontent,
			MultipartFile pcontentfilename1, MultipartFile pcontentfilename2, int pid, String uploadPath) throws Exception {
		String fileName = saveFile(pfilename, uploadPath);
	    String newFileName1 = saveFile(pcontentfilename1, uploadPath);
	    String newFileName2 = saveFile(pcontentfilename2, uploadPath);
	    Map<String, Object> params = new HashMap<>();
	    params.put("pname", pname);
	    params.put("pprice", pprice);
	    params.put("pstock", pstock);
	    params.put("pfilename", fileName);
	    params.put("pcontent", pcontent);
	    params.put("pcontentfilename1", newFileName1);
	    params.put("pcontentfilename2", newFileName2);
	    params.put("pid", pid);
	    dao.modify(params);
		
	}


	@Override
	public void delete(int[] pidArray) throws Exception {
	    for (int pid : pidArray) {
	        dao.delete(pid);
	    }
	}

	


	
	
	
	
	
	
	
	
	
	
	
}//End