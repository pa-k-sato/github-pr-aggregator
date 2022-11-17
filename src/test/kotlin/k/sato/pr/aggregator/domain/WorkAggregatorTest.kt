package k.sato.pr.aggregator.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class WorkAggregatorTest {
    @Test
    fun testDurationAverage() {
        val sut = WorkAggregator()
        sut.add(Work("2022-11-07T09:00:00Z", "2022-11-07T17:00:00Z"))
        sut.add(Work("2022-11-08T09:00:00Z", "2022-11-09T11:00:00Z"))

        assertEquals(17, sut.durationAverage())
    }
}