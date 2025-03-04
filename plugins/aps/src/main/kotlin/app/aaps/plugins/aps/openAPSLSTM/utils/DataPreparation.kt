package app.aaps.plugins.aps.openAPSLSTM.utils

import kotlin.math.sqrt

object DataPreparation {

    fun normalizeData(data: List<FloatArray>): List<FloatArray> {
        if (data.isEmpty()) return emptyList()
        val dim = data.first().size
        val means = DoubleArray(dim) { 0.0 }
        val stdDevs = DoubleArray(dim) { 0.0 }

        data.forEach { row ->
            for (i in row.indices) {
                means[i] += row[i]
            }
        }
        for (i in means.indices) {
            means[i] /= data.size
        }
        data.forEach { row ->
            for (i in row.indices) {
                stdDevs[i] += (row[i] - means[i]).pow(2)
            }
        }
        for (i in stdDevs.indices) {
            stdDevs[i] = sqrt(stdDevs[i] / data.size)
        }
        return data.map { row ->
            FloatArray(dim) { i ->
                (row[i] - means[i]).toFloat() / stdDevs[i].toFloat()
            }
        }
    }

    fun createSequences(data: List<FloatArray>, sequenceLength: Int): Pair<List<FloatArray>, List<FloatArray>> {
        val sequences = mutableListOf<FloatArray>()
        val targets = mutableListOf<FloatArray>()
        for (i in 0 until data.size - sequenceLength) {
            val sequence = data.subList(i, i + sequenceLength).flatten().toFloatArray()
            sequences.add(sequence)
            targets.add(data[i + sequenceLength])
        }
        return Pair(sequences, targets)
    }
}