package swd20.movieDB.aws;

import org.springframework.web.multipart.MultipartFile;

public interface AWSS3Service {

	String uploadImage(MultipartFile image);
}
