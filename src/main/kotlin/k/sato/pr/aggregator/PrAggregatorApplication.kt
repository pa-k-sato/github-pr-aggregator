package k.sato.pr.aggregator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PrAggregatorApplication

fun main(args: Array<String>) {
	runApplication<PrAggregatorApplication>(*args)
}
