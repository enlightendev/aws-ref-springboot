package io.enlightendev.web.controller.api;

import io.enlightendev.aws.services.s3.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class S3Controller {

    @Autowired
    S3Service s3Service;

    @RequestMapping("/api/s3/list")
    public String[] listBuckets(){
        return s3Service.listBuckets();
    }

    @RequestMapping(value = "/api/s3/create/{bucketName}", method = RequestMethod.POST)
    public String createBucket(@PathVariable String bucketName){

        return s3Service.createBucket(bucketName);
    }

}
