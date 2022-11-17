package k.sato.pr.aggregator.domain

class WorkAggregator {
    private val works: MutableList<Work> = emptyList<Work>().toMutableList()

    fun add(work: Work) {
        works.add(work)
    }

    fun durationAverage(): Int {
        return works.sumOf { it.duration } / works.size
    }
}