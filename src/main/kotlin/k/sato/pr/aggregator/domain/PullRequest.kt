package k.sato.pr.aggregator.domain

import java.time.LocalDateTime

class PullRequest(
    val id: String,
    val title: String,
    val closed: LocalDateTime,
    val commits: List<Commit>
)

class Commit(
    val id: String,
    val name: String,
    val committedDate: LocalDateTime
)