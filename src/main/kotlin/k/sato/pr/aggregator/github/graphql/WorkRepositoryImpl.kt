package k.sato.pr.aggregator.github.graphql

import java.io.File
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
    override fun allOf(jsonFilename: String): List<Work> {
        val data = jsonStringDecoder.decodeFromString<QueryRes>(File("./prs-202212.json").readText(Charsets.UTF_8))
        println("================================")
        println(data)

        return data.data.repository.pullRequests.edges
            .map { pr ->
                Work(
                    checkNotNull(
                        pr.node.commits.nodes.minByOrNull { it.commit.committedDate }
                    ).commit.committedDate,
                    pr.node.closedAt!!,
                    pr.node.additions,
                    pr.node.deletions,
                    pr.node.files.totalCount
                )
            }
    }
}