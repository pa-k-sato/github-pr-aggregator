package k.sato.pr.aggregator.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class WorkTest {
    @ParameterizedTest
    @CsvSource(delimiter = ' ', value = [
        "2022-11-07T09:00:00Z 2022-11-07T13:00:00Z 2022-11-07T17:00:00Z 8",
        "2022-11-08T09:00:00Z 2022-11-09T09:00:00Z 2022-11-09T11:00:00Z 26",
    ])
    fun testDuration(firstCommitted: String, createdAt: String, closedAt: String, expected: Int) {
        val sut = Work(
            firstCommitted,
            createdAt,
            closedAt,
            1,
            0,
            1
        )

        assertEquals(expected, sut.duration)
    }

    @ParameterizedTest
    @CsvSource(delimiter = ' ', value = [
        "2022-11-07T09:00:00Z 2022-11-07T13:00:00Z 2022-11-07T17:00:00Z 4",
        "2022-11-08T09:00:00Z 2022-11-09T09:00:00Z 2022-11-09T11:00:00Z 24",
    ])
    fun testDurationTillShare(firstCommitted: String, createdAt: String, closedAt: String, expected: Int) {
        val sut = Work(
            firstCommitted,
            createdAt,
            closedAt,
            1,
            0,
            1
        )

        assertEquals(expected, sut.durationTillShare)
    }
}