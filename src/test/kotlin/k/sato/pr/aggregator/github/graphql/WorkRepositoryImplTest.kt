package k.sato.pr.aggregator.github.graphql

import io.mockk.every
import io.mockk.mockk
import java.io.Reader
import java.io.StringReader
import java.time.LocalDateTime
import k.sato.pr.aggregator.github.graphql.models.*
import kotlinx.serialization.StringFormat
import kotlinx.serialization.decodeFromString
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class WorkRepositoryImplTest {
    @Test
    fun testStartOfWorkIsFirstCommitOfPullRequests() {
        // given
        val queryRes = QueryRes(
            QueryData(
                Repository(
                    PullRequests(
                        1,
                        listOf(
                            PullRequestEdge(
                                PullRequestNode(
                                    "pr id",
                                    "pr title",
                                    "CLOSED",
                                    100,
                                    50,
                                    "2022-11-21T10:00:00Z",
                                    "2022-11-21T17:00:00Z",
                                    "2022-11-21T17:00:00Z",
                                    Commits(
                                        listOf(
                                            CommitNode(
                                                Commit(
                                                    "commit id",
                                                    "commit message",
                                                    "2022-11-21T09:00:00Z"
                                                )
                                            ),
                                            CommitNode(
                                                Commit(
                                                    "commit id",
                                                    "commit message",
                                                    "2022-11-21T09:30:00Z"
                                                )
                                            ),
                                        ),
                                        2
                                    ),
                                    Files(3)
                                )
                            )
                        )
                    )
                )
            )
        )
        val stringFormatMock = mockk<StringFormat>(relaxed = true)
        every {
            stringFormatMock.decodeFromString<QueryRes>(any())
        } returns queryRes

        // when
        val sut = WorkRepositoryImpl(stringFormatMock)
        val actual = sut.allOf(StringReader("dummy"))

        // then
        assertEquals(1, actual.size)
        assertEquals(LocalDateTime.of(2022, 11, 21, 9, 0), actual[0].firstCommitted)
        assertEquals(LocalDateTime.of(2022, 11, 21,     17, 0), actual[0].closedAt)
        assertEquals(100, actual[0].additions)
        assertEquals(50, actual[0].deletions)
        assertEquals(3, actual[0].files)
    }

    @Test
    fun testNotClosedPullRequestIsExcluded() {
        // given
        val queryRes = QueryRes(
            QueryData(
                Repository(
                    PullRequests(
                        1,
                        listOf(
                            PullRequestEdge(
                                PullRequestNode(
                                    "pr id",
                                    "pr title",
                                    "CLOSED",
                                    100,
                                    50,
                                    "2022-11-21T10:00:00Z",
                                    null,
                                    null,
                                    Commits(
                                        listOf(
                                            CommitNode(
                                                Commit(
                                                    "commit id",
                                                    "commit message",
                                                    "2022-11-21T09:00:00Z"
                                                )
                                            )
                                        ),
                                        2
                                    ),
                                    Files(3)
                                )
                            )
                        )
                    )
                )
            )
        )
        val stringFormatMock = mockk<StringFormat>(relaxed = true)
        every {
            stringFormatMock.decodeFromString<QueryRes>(any())
        } returns queryRes

        // when
        val sut = WorkRepositoryImpl(stringFormatMock)
        val actual = sut.allOf(StringReader("dummy"))

        // then
        assertEquals(0, actual.size)
    }
}

