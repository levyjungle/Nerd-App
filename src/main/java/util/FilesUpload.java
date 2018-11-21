package util;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

public class FilesUpload {
	
	public void upload() {
		
	
	Cloudinary cloudnary = new Cloudinary(ObjectUtils.asMap(
			"cloud_name","nerdzonia",
			"cloud_key","966118315853311",
			"api_secret","HRv2x14ZTrL-YtfzIsgyrmBIcDw"));
	
	File toUpload = new File("../Upload/gamer.jpg");
	
	try {
		
		Map<String,String> uploadResult = cloudnary.uploader().upload(toUpload, ObjectUtils.asMap());
		System.out.println(uploadResult);
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	
}
