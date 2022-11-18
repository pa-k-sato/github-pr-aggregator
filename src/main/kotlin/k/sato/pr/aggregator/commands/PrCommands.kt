package k.sato.pr.aggregator.commands

import k.sato.pr.aggregator.domain.Work
import k.sato.pr.aggregator.domain.WorkAggregator
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod

@ShellComponent
class PrCommands {
    @ShellMethod("aggregate pull requests")
    fun aggregate() {
        val aggregator = WorkAggregator()
        aggregator.add(
            Work("2022-11-07T09:00:00Z", "2022-11-07T17:00:00Z", 150, 20, 3)
        )
        aggregator.add(
            Work("2022-11-08T09:00:00Z", "2022-11-09T11:00:00Z", 50, 50, 10)
        )

        println("平均期間： ${aggregator.durationAverage()}")
    }
}
