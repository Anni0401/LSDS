package edu.upf.uploader;

import java.util.List;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;

/*Don't know how to initialize an Amazon client using AWS -> ~/.aws/credentials]
[default]
    aws_access_key_id = YOUR_ACCESS_KEY
    aws_secret_access_key = YOUR_SECRET_KEY

    System.setProperty("aws.accessKeyId", "YOUR_ACCESS_KEY");
    System.setProperty("aws.secretKey", "YOUR_SECRET_KEY");
*/


public class S3Uploader implements Uploader {

    final String inputFile;
    final String bucketName;
    final String prefix;
    private AmazonS3 s3Client;

    public S3Uploader(String inputFile, String bucketName, String prefix){
        this.inputFile = inputFile;
        this.bucketName = bucketName;
        this.prefix = prefix;
        this.s3Client = AmazonS3ClientBuilder.defaultClient();
    }
    @Override

    public void upload(List<String> files) {
        for (String file:files){
            PutObjectRequest request = new PutObjectRequest(bucketName, prefix, file);
            s3Client.putObject(request);
        }
    }
}
