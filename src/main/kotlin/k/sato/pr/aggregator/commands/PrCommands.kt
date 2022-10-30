package k.sato.pr.aggregator.commands

import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod

@ShellComponent
class PrCommands {
    @ShellMethod("list pull requests")
    fun list() {
        println("hoge")
    }
}