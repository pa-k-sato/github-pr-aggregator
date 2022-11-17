package k.sato.pr.aggregator.domain

import java.time.LocalDateTime
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class PullRequestTest {
    // 目的に辿り着くのが遠い。github の GraphQL の構造に引っ張られすぎだと思う
//    @Test
//    fun testCalcWorkingDuration() {
//        val prs = listOf(
//            PullRequest("id1",
//                "story A - api",
//                LocalDateTime.of(2022, 11, 8, 17, 0),
//                listOf(
//                    Commit("commit1", "entry point", LocalDateTime.of(2022, 11, 8, 9, 0))
//                )
//            ),
//            PullRequest("id1",
//                "story A - api",
//                LocalDateTime.of(2022, 11, 10, 17, 0),
//                listOf(
//                    Commit("commit1", "entry point", LocalDateTime.of(2022, 11, 9, 9, 0))
//                )
//            )
//        )
//        assertEquals(prs.workingDurationAvarage(), 1.5)
//    }

    // 振り分けは後回し
//    @Test
//    fun testDistributePullRequest() {
//        val periods = listOf(
//            Period.weekFrom(2022, 11, 7),
//            Period.weekFrom(2022, 11, 14),
//        )
//
//        val prs = listOf(
//            PullRequest("id1", "story A - api", LocalDateTime.of(2022, 11, 8, 17, 0)),
//            PullRequest("id2", "story A - view", LocalDateTime.of(2022, 11, 12, 17, 0)),
//            PullRequest("id3", "story A - css", LocalDateTime.of(2022, 11, 13, 17, 0)),
//        )
//
//        val weeklyPrs = PeriodPullRequest.distribute(
//            prs,
//            periods
//        )
//
//        assertEquals(weeklyPrs[0].prs.size, 1)
//        assertEquals(weeklyPrs[2].prs.size, 2)
//    }
}