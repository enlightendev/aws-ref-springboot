package io.enlightendev.aws.auth;

import com.amazonaws.auth.AWSCredentials;

/**
 *
 */
public interface IAWSCredentials {

    AWSCredentials getCredentials();

    AWSCredentials getCredentials(String profileName);
}
