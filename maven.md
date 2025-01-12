# Apache Maven

Apache Maven is a project management and build tool for Java developers.  It handles several tasks including:

1. **Dependency management**: when you use versioned libraries, Maven can pull the appropriate versions from the cloud.
1. **Build management**: Maven can compile your program and all dependencies.
1. **Project metadata**: Maven can assign information about your project when it compiles your program(s).
1. **Program execution**: Maven will allow you to run your code and/or test cases.

## Maven Projects

A Maven project is specified in a file called `pom.xml` in the root directory of the project.

By default, the project is laid out as follows:

- `src/` represents the source files to be compiled
  - `src/main/java` represents Java source
  - `src/main/resources` represents **files that are copied into the same directory as the Java project at compile time**

  - `src/test/java` represents **source files that are only used as test cases** during `mvn test` -- typically these are [JUnit tests](junit.md).
  - `src/testresources` represents **files that are copied into the same directory as the Java project at test time**.
- `target/` represents the compiled code. Normally this is created as needed. You can run `mvn clean` to delete the target.
- `~/.m2/repository` is where Maven downloads versioned dependencies.

## Maven Goals

When you run Maven, you typically do this with a *goal*.  Some common goals include:

- `compile` -- compile main source
- `test-compile` -- compile test cases
- `test` -- run test cases
- `exec` (with additional options) -- run source code
- `package` -- generate a jar package of your code (and optionally all dependencies)
- `install` -- copies the jar file into `~/.m2/repository` after building and creating it

### What Happens When You Run `mvn compile`

When you run `mvn compile`, all of the libraries your program depends upon should be downloaded to a directory called `.m2` in your home directory.  Then your program should get compiled to `target/classes` inside your project directory.  Any files in `src/main/resources` will also be copied into `target`.

When you run `mvn exec:java`, it will run the main class (from the `pom.xml`) from the `target/classes` directory, also adding all dependencies to the class path.

## What Happens When You Run `mvn test`

When you run `mvn test-compile`, similarly to how `mvn compile` generates classes in `target/classes`, you will get additional classes in `target/test-classes`. (These will be your `src/test/java` classes.) Again, anything from `src/test/resources` will get copied in.

When you run `mvn test`, this will run all test cases from `target/test-classes`. Due to a special Maven plugin, the results will get summarized in `target/surefire-reports`.

### What Happens When You Run `mvn clean`

If you run `mvn clean`, this will delete the `target` subdirectory and all of its content.

## What Happens When You Run `mvn exec:java@`*goal*

When you run `mvn exec`, Maven first tries to determine what to run (often, Java, as in `mvn exec:java`).  Next it looks in the `pom.xml` file for the `exec-maven-plugin`.  Within the related XML, there should be a definition of the `goal` (named as the ID) and the `mainClass`.  You can see this illustrated here:

```XML
    <plugin>
      <groupId>org.codehaus.mojo</groupId>
      <artifactId>exec-maven-plugin</artifactId>
      <version>3.1.0</version>
      <executions>
        <execution>
          <id>loader</id>
          <goals>
            <goal>java</goal>
          </goals>
        <configuration>
          <mainClass>edu.upenn.cis.nets2120.hw1.LoadData</mainClass>
          <arguments>
          </arguments>
        </configuration>
        </execution>
      </executions>
    </plugin>
```