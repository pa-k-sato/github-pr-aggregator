package k.sato.pr.aggregator.github.graphql.models

import kotlinx.serialization.Serializable

@Serializable
data class QueryRes(
    val data: QueryData
)

@Serializable
data class QueryData(
    val repository: Repository
)
@Serializable
data class Repository(
    val pullRequests: PullRequests
)

@Serializable
data class PullRequests(
    val totalCount: Int,
    val edges: List<PullRequestEdge>
)

@Serializable
data class PullRequestEdge(
    val node: PullRequestNode
)

@Serializable
data class PullRequestNode(
    val id: String,
    val title: String,
    val state: String,
    val additions: Int,
    val deletions: Int,
    val createdAt: String,
    val mergedAt: String?,
    val closedAt: String?,
    val commits: Commits,
    val files: Files
)

@Serializable
data class Commits(
    val nodes: List<CommitNode>,
    val totalCount: Int
)

@Serializable
data class CommitNode(
    val commit: Commit
)

@Serializable
data class Commit(
    val id: String,
    val message: String,
    val committedDate: String
)

@Serializable
data class Files(
    val totalCount: Int
)