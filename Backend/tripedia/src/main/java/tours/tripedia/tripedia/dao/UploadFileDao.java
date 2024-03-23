package tours.tripedia.tripedia.dao;

import org.springframework.web.multipart.MultipartFile;

public interface UploadFileDao {
    String uploadFile(MultipartFile file);
}



