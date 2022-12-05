package k.sato.pr.aggregator.github.graphql

import java.io.Reader
import k.sato.pr.aggregator.domain.Work
import k.sato.pr.aggregator.domain.WorkRepository
import k.sato.pr.aggregator.github.graphql.models.QueryRes
import kotlinx.serialization.StringFormat
import kotlinx.serialization.decodeFromString
import org.springframework.stereotype.Repository

@Repository
class WorkRepositoryImpl(
    private val jsonStringDecoder: StringFormat
): WorkRepository {
    override fun allOf(reader: Reader): List<Work> {
        val data = jsonStringDecoder.decodeFromString<QueryRes>(reader.readText())

        return data.data.repository.pullRequests.edges
            .filterNot { it.node.closedAt == null }
            .map { pr ->
                Work(
                    checkNotNull(
                        pr.node.commits.nodes.minByOrNull { it.commit.committedDate }
                    ).commit.committedDate,
                    pr.node.createdAt,
                    pr.node.closedAt!!,
                    pr.node.additions,
                    pr.node.deletions,
                    pr.node.files.totalCount
                )
            }
    }
}