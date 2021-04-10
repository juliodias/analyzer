#!/bin/sh

set -x

awslocal sqs create-queue --queue-name NEW_CONTRIBUTIONS --region us-east-1 --output json

set +x
