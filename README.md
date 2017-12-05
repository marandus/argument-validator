# argument-validator

Collection of simple utility classes to allow validation of method arguments.

## Add as project dependency

To use this library in your project simply add this to your Maven pom.xml.

```xml
<dependency>
    <groupId>com.github.marandus</groupId>
    <artifactId>argument-validator</artifactId>
    <version>0.2</version>
</dependency>
```

This library should be available via Maven Central. If you are unable to obtain it from there,
you may build and install it into your local Maven repository by using the following commands.

```bash
git clone git@github.com:marandus/argument-validator.git
cd argument-validator
git checkout argument-validator-0.2
mvn install
```

## Usage

Basic usage is possible in two ways. Either by using the static-only utility class
`ArgumentValidator` or by getting and instance of the `ArgumentValidatorBean` class and using it.

```java
/* Using the static-only utility class */
public class FooClass {

    public void foo(String bar) {
        ArgumentValidator.requireNonBlank(bar, "foo parameter");

        // do something here
    }
}

/* Using the bean class */
public class FooClass {

    private final ArgumentValidatorBean argVal = new ArgumentValidatorBean();

    public void foo(String bar) {
        this.argVal.requireNonBlank(bar, "foo parameter");

        // do something here
    }
}
```

For simple usage, the first variant should be the easiest. The second variant becomes interesting,
if paired with a DI framework such as Spring. Then one could register the bean class as a DI bean
and inject it into component classes that make use of it.

```java
/* Spring configuration class */
@Configuraion
public class FooConfig {

    @Bean
    public ArgumentValidatorBean argumentValidatorBean() {
        return new ArgumentValidatorBean();
    }
}

/* Using the bean class with dependecy injection */
public class FooClass {

    @Autowired
    private ArgumentValidatorBean argVal;

    public void foo(String bar) {
        this.argVal.requireNonBlank(bar, "foo parameter");

        // do something here
    }
}
```

### Using custom validator implementations

If you are unhappy with my validator implementations, the library allows you to use your own. Simply
implement one or more of the interfaces `CollectionArgumentValidator`, `ObjectArgumentValidator`,
and `StringArgumentValidator`. Then provide instances of you class to the constructor of the
`ArgumentValidatorBean` and it will use yours instead of the reference implementations.

**Please note:** Custom implementations cannot be used with the `ArgumentValidator` static-only
approach. Since the dependency on the `ArgumentValidatorBean` is initialized in static context, it
is not possible to pass your custom implementations.

## Contribution guidelines

* Fork the repository and provide pull requests with your changes
* Use verbose commit messages to tell what you have done
* Make sure your code builds successfully and is stable

## License

    Copyright 2017 Thomas Rix

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.