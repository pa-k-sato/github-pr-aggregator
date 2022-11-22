package k.sato.pr.aggregator.domain

interface WorkRepository {
    fun allOf(jsonFilename: String): List<Work>
}
