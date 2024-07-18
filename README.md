# DataGateway

The service is built with Java using Spring Boot and Gradle for building and dependency management.
Please visit [Data Gateway portfolio page](https://levantine.io/documents/portfolio/datagateway.html) for more information.

## Features

- **Infrastructure as Code**: Managed with Terraform to ensure consistency and reproducibility across environments.
- **Continuous Integration and Deployment**: Automated with GitHub Actions to run Terraform state, compile and build docker images, upload to ECR and deploy images into a Kubernetes cluster.
- **Spring Boot Application**: Leverages Spring Boot because it's popular and something that's not another Flask app.