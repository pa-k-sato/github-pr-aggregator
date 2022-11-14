package k.sato.pr.aggregator.commands

import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod

@ShellComponent
class PrCommands {
    @ShellMethod("aggregate pull requests")
    fun aggregate() {
        println("hoge")
    }
}
