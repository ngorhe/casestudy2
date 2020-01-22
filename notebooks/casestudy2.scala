// Databricks notebook source
val configs = Map(
  "fs.azure.account.auth.type" -> "OAuth",
  "fs.azure.account.oauth.provider.type" -> "org.apache.hadoop.fs.azurebfs.oauth2.ClientCredsTokenProvider",
  "fs.azure.account.oauth2.client.id" -> "4ac202ab-c262-470d-be73-c6eb9ad53d4f",
  "fs.azure.account.oauth2.client.secret" -> dbutils.secrets.get(scope = "training-scope", key = "dlstoken"),
  "fs.azure.account.oauth2.client.endpoint" -> "https://login.microsoftonline.com/36a5e6f0-55a7-4e96-9b59-26f624357c38/oauth2/token")

dbutils.fs.mount(
  source = "abfss://data@newstorageaccountnish.dfs.core.windows.net/",
  mountPoint = "/mnt/data",
  extraConfigs = configs)

// COMMAND ----------

// MAGIC %fs
// MAGIC 
// MAGIC ls /mnt/data