package tours.tripedia.tripedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tours.tripedia.tripedia.dao.UploadFileDao;

@Service
public class UploadFileService {
    @Autowired
    private UploadFileDao uploadFileDao;

    public UploadFileService(UploadFileDao uploadFileDao) {
        this.uploadFileDao = uploadFileDao;
    }

    public String uploadFile(MultipartFile file) {
        return uploadFileDao.uploadFile(file);
    }
}
