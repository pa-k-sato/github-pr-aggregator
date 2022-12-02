package k.sato.pr.aggregator.domain

import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Work(
    aFirstCommitted: String,
    aClosedAt: String,
    val additions: Int,
    val deletions: Int,
    val files: Int
) {
    val firstCommitted = parseIsoLocalDateTime(aFirstCommitted)
    val closedAt = parseIsoLocalDateTime(aClosedAt)

    val duration: Int =
        Duration.between(
            firstCommitted,
            closedAt
        )
            .toHours().toInt()

    private fun parseIsoLocalDateTime(date: String): LocalDateTime
        = LocalDateTime.parse(date, DateTimeFormatter.ISO_OFFSET_DATE_TIME)
}