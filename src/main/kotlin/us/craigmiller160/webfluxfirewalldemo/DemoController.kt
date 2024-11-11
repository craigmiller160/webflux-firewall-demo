package us.craigmiller160.webfluxfirewalldemo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/demo")
class DemoController {
    @GetMapping("/hello/{name}")
    fun hello(@PathVariable name: String): String = "Hello $name"
}