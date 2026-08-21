terraform {
  backend "s3" {
    bucket       = "prod-levantine-terraform-bucket"
    key          = "DataGateway/terraform.tfstate"
    region       = "us-west-2"
    use_lockfile = true
  }
}

variable "region" {}
variable "environment" {}
variable "levantine_io_hosted_zone_id" {}

# Auth is via GitHub Actions OIDC role assumption (see iam_oidc_role.tf),
# not a long-lived Vault-stored static key. aws-actions/configure-aws-credentials
# sets AWS_ACCESS_KEY_ID/AWS_SECRET_ACCESS_KEY/AWS_SESSION_TOKEN as env vars
# before terraform runs, which the AWS provider's default credential chain
# picks up automatically -- nothing to configure here.
provider "aws" {
  region = var.region
}