package tn.esprit.esponline.services;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;



public interface IFileStorageService {
	public String storeFile(MultipartFile file) throws IOException;

	public Resource loadFileAsResource(String fileName);

}
