package swd20.movieDB.aws;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AWSS3ServiceImpl implements AWSS3Service {

    private static Logger logger = LoggerFactory.getLogger(AWSS3ServiceImpl.class);

    @Autowired
    private AmazonS3 s3;
    @Value("${aws.s3.bucket}")
    private String bucketName;

    @Override
    @Async
    public String uploadImage(MultipartFile image) {
        logger.info("Uploading image...");

        try {
            File file = convertMultiPartFileToFile(image);
            String uploadedImage = uploadFileToS3Bucket(bucketName, file);
            logger.info("Image uploaded.");
            file.delete();
            return uploadedImage;
        } catch (AmazonServiceException exception) {
            logger.info("Upload failed.");
            logger.error("Error = {} while uploading file.", exception.getMessage());
            return null;
        }
    }

    private File convertMultiPartFileToFile(MultipartFile multipartFile) {
        File file = new File(multipartFile.getOriginalFilename());
        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            outputStream.write(multipartFile.getBytes());
        } catch (IOException exception) {
            logger.error("Error converting the multi-part file to file = ", exception.getMessage());
        }
        return file;
    }

    private String uploadFileToS3Bucket(String bucketName, File file) {
        UUID generatedName = UUID.randomUUID();
        logger.info("Uploading file with name= " + generatedName);
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, generatedName.toString(), file);
        s3.putObject(putObjectRequest);
        return s3.getUrl(bucketName, generatedName.toString()).toString();
    }

}
