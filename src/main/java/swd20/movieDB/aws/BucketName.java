package swd20.movieDB.aws;

public enum BucketName {

    POSTER_IMAGE("moviedb-image-upload");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }

}
