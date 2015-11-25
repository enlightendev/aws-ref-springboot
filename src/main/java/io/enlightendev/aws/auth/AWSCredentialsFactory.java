package io.enlightendev.aws.auth;

import com.amazonaws.auth.AWSCredentials;

/**
 *
 */
public class AWSCredentialsFactory {

    public static final String CLASSPATH_PROPERTIES = "class_path_properties_file";
    public static final String AWS_CONFIG_USER_HOME = "aws_config";

    public static AWSCredentials getCredentials(String type){
        return getCredentials(type,null);
    }

    public static AWSCredentials getCredentials(String type, String profile){

        AWSCredentials credentials;

        if(type.equalsIgnoreCase(AWS_CONFIG_USER_HOME)){
            credentials = new AWSConfigCredentials().getCredentials(profile);
        }else{
            credentials = new AWSClassPathCredentials().getCredentials(null);
        }

        return credentials;

    }
}

