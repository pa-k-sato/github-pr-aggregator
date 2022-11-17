package k.sato.pr.aggregator.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class WorkTest {
    @ParameterizedTest
    @CsvSource(delimiter = ' ', value = [
        "2022-11-07T09:00:00Z 2022-11-07T17:00:00Z 8",
        "2022-11-08T09:00:00Z 2022-11-09T11:00:00Z 26",
    ])
    fun testDuration(firstCommitted: String, closedAt: String, expected: Int) {
        val sut = Work(
            "2022-11-07T09:00:00Z",
            "2022-11-07T17:00:00Z",
            1,
            0,
            1
        )

        assertEquals(8, sut.duration)
    }
}