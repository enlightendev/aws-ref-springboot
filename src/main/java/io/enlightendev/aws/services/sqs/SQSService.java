package io.enlightendev.aws.services.sqs;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.CreateQueueResult;
import io.enlightendev.aws.services.AWSServiceBase;
import org.springframework.stereotype.Component;

/**
 * AWS SQS service wrapper.
 */
@Component
public class SQSService extends AWSServiceBase {

    private AmazonSQSClient sqsClient;

    public SQSService(){

        sqsClient = new AmazonSQSClient(getCredentials());
        sqsClient.setRegion(Region.getRegion(Regions.US_EAST_1));

    }

    public String createQueue(String queueName){

        CreateQueueRequest createQueueRequest = new CreateQueueRequest();
        createQueueRequest.withQueueName(queueName);

        CreateQueueResult createQueueResult = sqsClient.createQueue(createQueueRequest);

        return createQueueResult.getQueueUrl();

    }

}