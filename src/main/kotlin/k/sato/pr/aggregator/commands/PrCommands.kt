package k.sato.pr.aggregator.commands

import k.sato.pr.aggregator.domain.WorkAggregator
import k.sato.pr.aggregator.domain.WorkRepository
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod



@ShellComponent
class PrCommands(
    private val workRepository: WorkRepository
) {
    @ShellMethod("aggregate pull requests")
    fun aggregate() {
        val aggregator = WorkAggregator()
        workRepository.allOf("202212")
            .forEach(aggregator::add)

        println("平均期間： ${aggregator.durationAverage()}")
    }
}
