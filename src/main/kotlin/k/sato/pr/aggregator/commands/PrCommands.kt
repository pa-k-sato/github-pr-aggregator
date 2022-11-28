package k.sato.pr.aggregator.commands

import java.io.File
import k.sato.pr.aggregator.domain.WorkAggregator
import k.sato.pr.aggregator.domain.WorkRepository
import org.springframework.shell.CompletionContext
import org.springframework.shell.CompletionProposal
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod
import org.springframework.shell.standard.ShellOption
import org.springframework.shell.standard.ValueProvider
import org.springframework.stereotype.Component


@ShellComponent
class PrCommands(
    private val workRepository: WorkRepository
) {
    @ShellMethod("aggregate pull requests")
    fun aggregate(@ShellOption(valueProvider = DataSourceFileCompletionProvider::class) filename: String) {
        val aggregator = WorkAggregator()
        workRepository.allOf(filename)
            .forEach(aggregator::add)

        println("ファイル： $filename")
        println("平均期間： ${aggregator.durationAverage()}")
        println("追加行数： ${aggregator.additionsAverage()}")
        println("削除行数： ${aggregator.deletionsAverage()}")
        println("ファイル数： ${aggregator.filesAverage()}")
    }
}

@Component
class DataSourceFileCompletionProvider: ValueProvider {
    override fun complete(completionContext: CompletionContext?): MutableList<CompletionProposal> {
        return File("./").list()
            .filter { it.endsWith(".json") }
            .map(::CompletionProposal)
            .toMutableList()
    }
}