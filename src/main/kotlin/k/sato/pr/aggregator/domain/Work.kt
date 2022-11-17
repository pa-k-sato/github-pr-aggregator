package k.sato.pr.aggregator.domain

import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Work(
    firstCommitted: String,
    closedAt: String
) {
    val duration: Int =
        Duration.between(
            parseIsoLocalDateTime(firstCommitted),
            parseIsoLocalDateTime(closedAt)
        )
            .toHours().toInt()

    private fun parseIsoLocalDateTime(date: String): LocalDateTime
        = LocalDateTime.parse(date, DateTimeFormatter.ISO_OFFSET_DATE_TIME)
}