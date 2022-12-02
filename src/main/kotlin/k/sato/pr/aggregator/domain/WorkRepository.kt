package k.sato.pr.aggregator.domain

import java.io.Reader

interface WorkRepository {
    fun allOf(reader: Reader): List<Work>
}
