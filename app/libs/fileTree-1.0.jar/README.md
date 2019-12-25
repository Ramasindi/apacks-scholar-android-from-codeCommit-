# Prerequisites
In order to compile the generated client, you need:
* Install [Apache Maven](https://maven.apache.org). Tested with version 3.x.
* Install [JDK](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html). Recommended with JDK 1.7+.

# Compile
Make sure `JAVA_HOME` is set, then run

```
mvn install
```

This will install the generated client to your local Maven repository.

# Use it in your project
Copy fileTree-1.0.jar from the `target` folder and all other libraries located in `target/lib` to your project's lib folder.

You can initialize the SDK using the `ApiClientFactory` object.

```
ApiClientFactory factory = new ApiClientFactory();
// create a client
final ApacksscholarvarsitiesapiClient client = factory.build(ApacksscholarvarsitiesapiClient.class);

// Invoke your helloGet method
 output = client.helloGet();

```

# Using AWS IAM for authorization
To use AWS IAM to authorize API calls you pass set of AWS credentials to the SDK through the `ApiClientFactory`.

```
// Use CognitoCachingCredentialsProvider to provide AWS credentials
// for the ApiClientFactory
AWSCredentialsProvider credenetialsProvider = new CognitoCachingCredentialsProvider(
        context,          // activity context
        "identityPoolId", // Cognito identity pool id
        Regions.US_EAST_1 // region of Cognito identity pool
);
ApiClientFactory factory = new ApiClientFactory()
        .credentialsProvider(credentialsProvider);
```

# Using API Keys
You can also use the `ApiClientFactory` to set the API Key in the generated client SDK.

```
ApiClientFactory factory = new ApiClientFactory()
        .apiKey("YOUR_API_KEY");
```
