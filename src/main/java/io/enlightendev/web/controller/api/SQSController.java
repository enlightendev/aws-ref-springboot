package io.enlightendev.web.controller.api;

import io.enlightendev.aws.services.sqs.SQSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class SQSController {

    @Autowired
    SQSService sqsService;

    @RequestMapping(value = "/api/sqs/create/{queueName}", method = RequestMethod.POST)
    public String createQueue(@PathVariable String queueName){

        return sqsService.createQueue(queueName);
    }

}
