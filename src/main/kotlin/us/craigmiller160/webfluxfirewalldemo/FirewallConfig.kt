package us.craigmiller160.webfluxfirewalldemo

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.web.server.firewall.ServerWebExchangeFirewall
import org.springframework.security.web.server.firewall.StrictServerWebExchangeFirewall

/**
 * According to the Spring documentation, this should override and allow
 * the request to succeed. However, it does not.
 */
@Configuration
class FirewallConfig {
    @Bean
    fun firewalll(): ServerWebExchangeFirewall =
        StrictServerWebExchangeFirewall().apply {
            setAllowBackSlash(true)
        }
}