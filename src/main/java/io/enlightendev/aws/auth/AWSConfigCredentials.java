package io.enlightendev.aws.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;

/**
 *
 */
public class AWSConfigCredentials implements IAWSCredentials {


    @Override
    public AWSCredentials getCredentials() {
        return getCredentials(null);
    }

    @Override
    public AWSCredentials getCredentials(String profileName) {
        /*
         * The ProfileCredentialsProvider will return your [default]
         * credential profile by reading from the credentials file located at
         * (~/.aws/credentials).
         */
        AWSCredentials credentials = null;
        try {
            credentials = new ProfileCredentialsProvider(profileName).getCredentials();
        } catch (Exception e) {
            throw new AmazonClientException(
                    "Cannot load the credentials from the credential profiles file. " +
                            "Please make sure that your credentials file is at the correct " +
                            "location (~/.aws/credentials), and is in valid format.", e);
        }

        return credentials;
    }
}
