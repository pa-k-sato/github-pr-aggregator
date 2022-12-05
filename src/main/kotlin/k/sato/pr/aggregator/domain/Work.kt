package k.sato.pr.aggregator.domain

import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Work(
    firstCommitted: String,
    createdAt: String,
    closedAt: String,
    val additions: Int,
    val deletions: Int,
    val files: Int
) {
    val firstCommitted = parseIsoLocalDateTime(firstCommitted)
    val createdAt = parseIsoLocalDateTime(createdAt)
    val closedAt = parseIsoLocalDateTime(closedAt)

    val duration: Int = calcDuration(this.firstCommitted, this.closedAt)
    val durationTillShare: Int = calcDuration(this.firstCommitted, this.createdAt)

    private fun parseIsoLocalDateTime(date: String): LocalDateTime
        = LocalDateTime.parse(date, DateTimeFormatter.ISO_OFFSET_DATE_TIME)

    private fun calcDuration(from: LocalDateTime, to: LocalDateTime): Int =
        Duration.between(from, to).toHours().toInt()
}