package k.sato.pr.aggregator.config

import kotlinx.serialization.StringFormat
import kotlinx.serialization.json.Json
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Config {
    @Bean
    fun jsonStringDecoder(): StringFormat {
        return Json { ignoreUnknownKeys = true}
    }
}