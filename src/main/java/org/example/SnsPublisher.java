package org.example;

import java.util.UUID;
import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
import software.amazon.awssdk.core.exception.SdkClientException;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;

/**
 * Hello world!
 */
public class SnsPublisher {

  public static void main(final String[] args) {
    if (args.length != 2) {
      System.out.println("Invalid program arguments!");
      System.out.println("Usage: <topicArn> <message>");
      System.exit(1);
    }

    final var topicArn = args[0];
    System.out.println("ARN: " + topicArn);
    final var message = args[1];
    System.out.println("Message: " + message);

    try (final SnsClient snsClient = SnsClient.builder()
        .region(Region.US_EAST_1)
        .credentialsProvider(EnvironmentVariableCredentialsProvider.create())
        .build()) {

      final PublishRequest request = PublishRequest.builder()
          .subject("Notification from AWS SNS")
          .message(message)
          .topicArn(topicArn)
          .build();

      snsClient.publish(request);
      System.out.println("Message '" + message + "' sent!");
    } catch (final SdkClientException exception) {
      System.out.println("Could not send the message '" + message + "'");
      exception.printStackTrace();
    }
  }

}
