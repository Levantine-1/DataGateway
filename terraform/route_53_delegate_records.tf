# No delegate-zone record for DataGateway ("2024-07-02 Delegate records
# not required for now" -- the only resource here was already commented
# out). This file previously declared an aws.delegate provider +
# Vault-sourced credentials data source anyway, even with nothing using
# them -- harmless when applied from `service` (which can reach Vault),
# but broken from a GitHub-hosted runner with no route to
# vault.internal.levantine.io, and Terraform evaluates declared data
# sources regardless of whether anything consumes their output. Removed
# entirely.
