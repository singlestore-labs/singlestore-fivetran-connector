---
name: SingleStore
title: SingleStore source connector for Fivetran
description: Read step-by-step instructions on how to connect SingleStore with your destination using Fivetran connectors.
hidden: false
---

# SingleStore Setup Guide {% typeBadge connector="singlestore" /%} {% availabilityBadge connector="singlestore" /%}

Follow our setup guide to connect SingleStore to Fivetran.

> NOTE: This connector is [partner-built](/docs/partner-built-program). For any questions related
> to SingleStore connector and its documentation, contact SingleStore by raising an issue in the
> [SingleStore Fivetran Connector](https://github.com/singlestore-labs/singlestore-fivetran-connector)
> GitHub repository.

-----

## Prerequisites

To connect your SingleStore database to Fivetran, you need:

- A SingleStore instance of version 8.7.16 or higher. Refer
  to [Creating and Using Workspaces](https://docs.singlestore.com/cloud/getting-started-with-singlestore-helios/about-workspaces/creating-and-using-workspaces/)
  for instructions on creating a SingleStore workspace in
  the [Cloud Portal](https://portal.singlestore.com/).
  To deploy a Self-Managed cluster instead, refer
  to [Deploy](https://docs.singlestore.com/db/latest/deploy/). Once the SingleStore
  workspace/cluster is Active, you'll need the following to connect to Fivetran:
    - `Host`
    - `Port`
    - `Username`
    - `Password`
    - `Database`
    - `Table`
- A Fivetran account with
  the [Connector Creator](/docs/using-fivetran/fivetran-dashboard/account-management/role-based-access-control#rbacpermissions)
  permissions.

---

## Setup instructions

To authorize Fivetran to connect to your SinlgeStore database, follow these instructions:

### <span class="step-item">Configure SingleStore</span>

1. Configure your firewall and/or other access control systems to allow incoming connections to your
   SingleStore instance from [Fivetran's IPs](https://fivetran.com/docs/using-fivetran/ips) for your
   region.
2. Ensure that the SingleStore database user has the `SELECT` permission.
3. Enable support of OBSERVE queries

```
SET enable_observe_queries=1
```

### <span class="step-item">Finish Fivetran configuration </span>

1. Log in to your Fivetran account.
2. Go to the [**Connectors** page](https://fivetran.com/dashboard/connectors), and then click *
   *+ Add connector**.
3. Select **SingleStore** as the connector type.
4. Enter the following connection configurations for you SingleStore workspace/cluster:
    * **Host**
    * **Port**
    * **Database**
    * **Table**
    * **Username**
    * **Password**
5. (Optional) Enable SSL and specify related configurations.
6. (Optional) Specify additional **Driver Parameters**. Refer
   to [The SingleStore JDBC Driver](https://docs.singlestore.com/cloud/developer-resources/connect-with-application-development-tools/connect-with-java-jdbc/the-singlestore-jdbc-driver/#connection-string-parameters)
   documentation for a list of supported parameters.
7. Click **Save & Test**.

### Setup tests

Fivetran performs the following SingleStore connection tests:

- The Connection test checks if Fivetran can connect to your SingleStore cluster using credentials
  provided in the setup form
- The Table test checks if specified table exists

---

## Related articles

[<i aria-hidden="true" class="material-icons">description</i> Connector Overview](/docs/connectors/databases/singlestore)

<b> </b>

[<i aria-hidden="true" class="material-icons">account_tree</i> Schema Information](/docs/connectors/databases/singlestore#schemainformation)

<b> </b>

[<i aria-hidden="true" class="material-icons">settings</i> API Connector Configuration](/docs/rest-api/connectors/config#sinlgestore)

<b> </b>

[<i aria-hidden="true" class="material-icons">home</i> Documentation Home](/docs/getting-started)