package k.sato.pr.aggregator.domain

import java.time.LocalDate
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class WorkAggregatorTest {
    @Test
    fun testDurationAverage() {
        val sut = WorkAggregator()
        sut.add(Work("2022-11-07T09:00:00Z", "2022-11-07T13:00:00Z", "2022-11-07T17:00:00Z", 1, 0, 1))
        sut.add(Work("2022-11-08T09:00:00Z", "2022-11-08T17:00:00Z", "2022-11-09T11:00:00Z", 1, 0, 1))

        assertEquals(17, sut.durationAverage())
    }

    @Test
    fun testChangesAverage() {
        val sut = WorkAggregator()
        sut.add(Work("2022-11-07T09:00:00Z", "2022-11-07T13:00:00Z", "2022-11-07T17:00:00Z", 100, 50, 2))
        sut.add(Work("2022-11-08T09:00:00Z", "2022-11-08T17:00:00Z", "2022-11-09T11:00:00Z", 50, 60, 10))

        assertEquals(75, sut.additionsAverage())
        assertEquals(55, sut.deletionsAverage())
        assertEquals(6, sut.filesAverage())
    }

    @Test
    fun testCalculateMondayOfFirstWeek() {
        val sut = WorkAggregator()
        sut.add(Work("2022-11-08T09:00:00Z", "2022-11-08T13:00:00Z", "2022-11-09T11:00:00Z", 50, 60, 10))
        sut.add(Work("2022-11-09T17:00:00Z", "2022-11-10T13:00:00Z", "2022-11-11T11:00:00Z", 50, 60, 10))
        sut.add(Work("2022-11-14T17:00:00Z", "2022-11-25T09:00:00Z", "2022-11-15T11:00:00Z", 50, 60, 10))

        assertEquals(LocalDate.of(2022, 11, 7), sut.firstMonday())
    }
}