package io.enlightendev.aws.services;

import com.amazonaws.auth.AWSCredentials;
import io.enlightendev.aws.auth.AWSCredentialsFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Abstract base class for AWS Service Wrappers.
 */
@Component
@ConfigurationProperties(prefix="awsservice")
public class AWSServiceBase {

    private AWSCredentials credentials = null;

    private String profile;

    public AWSServiceBase(){}

    private void init(){
        credentials = AWSCredentialsFactory.getCredentials(AWSCredentialsFactory.AWS_CONFIG_USER_HOME, profile);
    }

    public AWSCredentials getCredentials(){
        if(credentials == null){
            init();
        }

        return credentials;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}