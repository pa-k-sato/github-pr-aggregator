package k.sato.pr.aggregator.domain

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalDateTime

class WorkAggregator {
    private val works: MutableList<Work> = emptyList<Work>().toMutableList()

    fun add(work: Work) {
        works.add(work)
    }

    fun durationAverage(): Int {
        return averageOf(Work::duration)
    }

    fun durationTillShareAverage(): Int {
        return averageOf(Work::durationTillShare)
    }

    fun additionsAverage(): Int {
        return averageOf(Work::additions)
    }

    fun deletionsAverage(): Int {
        return averageOf(Work::deletions)
    }

    fun filesAverage(): Int {
        return averageOf(Work::files)
    }

    private fun averageOf(f: Work.() -> Int): Int {
        return works.sumOf(f) / works.size
    }

    fun firstMonday(): LocalDate {
        val earliestWork = checkNotNull(works.minByOrNull { it.firstCommitted })
        val earliestStartedAt = earliestWork.firstCommitted
        return toMonday(earliestStartedAt)
    }

    private fun toMonday(dt: LocalDateTime): LocalDate {
        val dateDiff = mapOf(
            DayOfWeek.MONDAY to 0,
            DayOfWeek.TUESDAY to 1,
            DayOfWeek.WEDNESDAY to 2,
            DayOfWeek.THURSDAY to 3,
            DayOfWeek.FRIDAY to 4,
            DayOfWeek.SATURDAY to 5,
            DayOfWeek.SUNDAY to 6,
        ).getValue(dt.dayOfWeek)
        return dt.toLocalDate().minusDays(dateDiff.toLong())
    }
}