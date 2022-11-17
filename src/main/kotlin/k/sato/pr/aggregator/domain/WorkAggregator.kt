package k.sato.pr.aggregator.domain

class WorkAggregator {
    private val works: MutableList<Work> = emptyList<Work>().toMutableList()

    fun add(work: Work) {
        works.add(work)
    }

    fun durationAverage(): Int {
        return averageOf(Work::duration)
    }

    fun additionsAverage(): Int {
        return averageOf(Work::additions)
    }

    fun deletionsAverage(): Int {
        return averageOf(Work::deletions)
    }

    fun filesAverage(): Int {
        return averageOf(Work::files)
    }

    private fun averageOf(f: Work.() -> Int): Int {
        return works.sumOf(f) / works.size
    }
}