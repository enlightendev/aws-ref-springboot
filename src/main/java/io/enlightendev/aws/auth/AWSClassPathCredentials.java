package io.enlightendev.aws.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;

/**
 * loads AWS security credentials from a properties file on the classpath. The default
 * constructor creates a credentials provider that loads the credentials
 * from a file named <code>AwsCredentials.properties</code> on the
 * classpath, but which file to use from the classpath can also be controled
 * through the one-argument constructor.
 * <p>
 * The AWS access key ID is expected to be in the <code>accessKey</code>
 * property and the AWS secret key is expected to be in the
 * <code>secretKey</code> property.
 */
public class AWSClassPathCredentials implements IAWSCredentials {


    @Override
    public AWSCredentials getCredentials() {
        /*
         * The ProfileCredentialsProvider will return your [default]
         * credential profile by reading from the credentials file located at
         * (~/.aws/credentials).
         */
        AWSCredentials credentials = null;
        try {
            credentials = new ClasspathPropertiesFileCredentialsProvider().getCredentials();
        } catch (Exception e) {
            throw new AmazonClientException(
                    "Cannot load the credentials from the AwsCredentials.properties file. " +
                            "Please make sure that your credentials file is at the root " +
                            "of the class path and is in valid format.", e);
        }

        return credentials;
    }

    @Override
    public AWSCredentials getCredentials(String profileName) {
        return getCredentials();
    }
}
