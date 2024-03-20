package tours.tripedia.tripedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tours.tripedia.tripedia.service.UploadFileService;

import java.security.Signature;
import java.util.HashMap;
import java.util.Map;

import static tours.tripedia.tripedia.Component.GlobalVariables.crossOriginUrl;

@RestController
@RequestMapping("/api/file")
@CrossOrigin(origins = crossOriginUrl)
public class UploadFileController {
    @Autowired
    public UploadFileService uploadFileService;

    public UploadFileController(UploadFileService uploadFileService) {
        this.uploadFileService = uploadFileService;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> uploadFile(@RequestParam("file")MultipartFile file) {
        String publicUrl = uploadFileService.uploadFile(file);
        Map<String, String> response = new HashMap<>();
        response.put("publicUrl", publicUrl);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
