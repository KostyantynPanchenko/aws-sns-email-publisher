# About

This app is used to publish email to SNS topic.

## Prerequisites

* You have active AWS account
* Maven installed
* Java 17+ installed

## How To

* [Getting started with Amazon SNS](https://docs.aws.amazon.com/sns/latest/dg/sns-getting-started.html)
* [Configuring Amazon SNS](https://docs.aws.amazon.com/sns/latest/dg/sns-configuring.html)

## Test

* Run in your favourite IDE

OR

* `mvn clean package`
* `java -jar target/*.jar <topicArn> <message>`
