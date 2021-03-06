package io.enlightendev.aws.services.s3;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import io.enlightendev.aws.services.AWSServiceBase;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 */
@Component
public class S3Service extends AWSServiceBase {

    private AmazonS3 s3;

    public S3Service(){

        s3 = new AmazonS3Client(getCredentials());
        s3.setRegion(Region.getRegion(Regions.US_EAST_1));

    }

    @Cacheable("buckets")
    public String[] listBuckets(){

        List<String> buckets = new ArrayList<>();

        try {

            for (Bucket bucket : s3.listBuckets()) {
                buckets.add(bucket.getName());
            }

        } catch (AmazonServiceException ase) {
            System.out.println("Caught an AmazonServiceException, which means your request made it "
                    + "to Amazon S3, but was rejected with an error response for some reason.");
            System.out.println("Error Message:    " + ase.getMessage());
            System.out.println("HTTP Status Code: " + ase.getStatusCode());
            System.out.println("AWS Error Code:   " + ase.getErrorCode());
            System.out.println("Error Type:       " + ase.getErrorType());
            System.out.println("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            System.out.println("Caught an AmazonClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with S3, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message: " + ace.getMessage());
        }

        return buckets.toArray(new String[buckets.size()]);
    }

    @CacheEvict(cacheNames="buckets", allEntries=true)
    public String createBucket(String bucketName){
        Bucket bucket = s3.createBucket(bucketName);
        return bucket.getName();
    }



}