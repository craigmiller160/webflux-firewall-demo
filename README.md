# Spring-Security-Web Firewall Defect With Spring Webflux

This is the minimal reproduce-able example to support https://github.com/spring-projects/spring-security/issues/16060.

## Issue Summary

In spring-security-web's 6.3.4 release, the `org.springframework.security.web.server.WebFilterChainProxy` class now contains a hard-coded implementation of `org.springframework.security.web.server.firewall.StrictServerWebExchangeFirewall`. The hard-coded nature of this implementation means it cannot be overridden by defining a bean of the same type, as the documentation says. This results in any requests that contain encoded characters being rejected in a Spring WebFlux application.

## How to Use This Example

1. Run the application using `mvn spring-boot:run`.
2. There are two example requests configured for the IntelliJ HTTP Client. They can be easily interpreted to use in Postman or any other client if you prefer.
   1. `say-hello.http` = This performs a request to the /demo/hello endpoint without any encoded characters. It will succeed.
   2. `say-hello-with-encoding.http` = This performs a request to the /demo/hello endpoint with encoded characters. It will fail with a 400 response.

## Additional Items to Note

1. The logging has been configured so that in the failure scenario described above, the logs will show that it is the firewall rejecting the request due to the `%5C` character.
2. The application contains a [FirewallConfig](./src/main/kotlin/us/craigmiller160/webfluxfirewalldemo/FirewallConfig.kt) class that configures the `StrictServerWebExchangeFirewall` to ignore encoded backslashes. This is to demonstrate that the bean is clearly being ignored.