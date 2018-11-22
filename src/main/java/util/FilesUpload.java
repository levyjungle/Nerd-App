package util;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import br.com.caelum.vraptor.observer.upload.UploadedFile;

public class FilesUpload {

	@SuppressWarnings(value = { "unchecked" })
	public String upload(UploadedFile fileUpload) {
		try {
			File file = new File("", "");
			Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "nerdzonia",
				"api_key","", 
				"api_secret", ""
				));
			
			FileUtils.copyInputStreamToFile(fileUpload.getFile(), file);
			Map<String, String> uploadResult = cloudinary.uploader().upload(file, ObjectUtils.asMap("public_id", "Nerdzonia"));
			
			return uploadResult.get("url");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
