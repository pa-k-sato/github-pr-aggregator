package k.sato.pr.aggregator.domain

class WorkAggregator {
    private val works: MutableList<Work> = emptyList<Work>().toMutableList()

    fun add(work: Work) {
        works.add(work)
    }

    fun durationAverage(): Int {
        return works.sumOf { it.duration } / works.size
    }

    fun additionsAverage(): Int {
        return works.sumOf { it.additions } / works.size
    }

    fun deletionsAverage(): Int {
        return works.sumOf { it.deletions } / works.size
    }

    fun filesAverage(): Int {
        return works.sumOf { it.files } / works.size
    }
}