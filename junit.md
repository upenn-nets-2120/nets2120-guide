# JUnit

JUnit is a popular testing framework in Java. A **unit test** typically aims to test a small "unit" of your code in
isolation from the rest of the program. This helps ensure that each part of your code works correctly as intended. In
our case, we will be adapting these unit tests to validate the DynamoDB table populated by your loader. This involves
querying the database by field and checking the results against expected values. JUnit's annotations and assertions
provide a structured way to create these tests and verify the outcomes. 

### JUnit 4

For this class, we are using JUnit 4.

Each function marked with `@Test` is an individual unit test. Within each unit test, you can include several assertions
of the data returned from querying the DynamoDB table. Common assertions include:

- `assertEquals(expected, actual)`: Checks if two values are equal.
- `assertTrue(condition)`: Checks if a given condition is true.
- `assertFalse(condition)`: Checks if a given condition is false.
- `assertNotNull(object)`: Checks if an object is not null.

Each of the above calls can take one additional parameter at the start --- a string `message` useful in generating error messages.

If any of these assertions fail, the unit test fails. When you run `mvn test`, any failed unit tests will show up and
the exact assertion that failed will also be identified.

If you are looking for a more comprehensive guide, we recommend you check out
the [CIS 1210 JUnit 4 Testing Guide](https://www.cis.upenn.edu/~cis1210/current/testing_guide.html).

### ApiTestUtils Test Harness and Helper Functions

To make unit tests easier for REST services, we have provided a utility "test harness" library for you.  See [test/.../ApiTestUtils.java](test/edu/upenn/cis/nets2120/ApiTestUtils.java).

You can assemble `GET` requests by calling the `get()` method, also supplying a path and an HTTP port.  Some of the different methods will even take a map of key/value pairs for queries in the GET request.

You can also assemble `POST` requests by calling the `post()` method. Here there are parameters for the content type (most commonly `application/xml`, `application/json`, `application/x-form-urlencoded`, `text/plain`. `application/octet-stream`).  See [here](https://developer.mozilla.org/en-US/docs/Web/HTTP/MIME_types/Common_types) for more info on content types.

For REST handlers that return JSON, you may wish to use Gson() and the `fromJson` function to parse the JSON and turn the results directly into an instance of a Java class.
