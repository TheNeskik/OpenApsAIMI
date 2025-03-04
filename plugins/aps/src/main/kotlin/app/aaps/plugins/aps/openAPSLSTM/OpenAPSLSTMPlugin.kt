package app.aaps.plugins.aps.openAPSLSTM

import app.aaps.plugins.aps.openAPSLSTM.utils.DataPreparation
import app.aaps.plugins.aps.openAPSLSTM.utils.DataRepository

class OpenAPSLSTMPlugin(private val context: Context) {

    private val dataRepository = DataRepository(context)

    fun trainModel() {
        val rawData = dataRepository.getAllData().map { data ->
            floatArrayOf(
                data["glucose"] as Float,
                data["insulin_basal"] as Float,
                data["insulin_bolus"] as Float,
                data["carbs"] as Float,
                data["activity_level"] as Float,
                data["time_since_last_insulin"] as Float,
                data["time_since_last_meal"] as Float,
                data["delta"] as Float,
                data["short_avg_delta"] as Float,
                data["long_avg_delta"] as Float,
                data["insulin_sensitivity"] as Float
            )
        }

        val normalizedData = DataPreparation.normalizeData(rawData)
        val (sequences, targets) = DataPreparation.createSequences(normalizedData, sequenceLength = 10)

        val trainData = sequences.toTypedArray()
        val trainLabels = targets.toTypedArray()

        val lstmModel = LSTMModel(sequenceLength = 10, inputDim = trainData.first().size, outputDim = 1)
        lstmModel.train(trainData, trainLabels, epochs = 100, batchSize = 32)
    }

    fun predict(inputData: FloatArray): FloatArray {
        val lstmModel = LSTMModel(sequenceLength = 10, inputDim = inputData.size, outputDim = 1)
        return lstmModel.predict(arrayOf(inputData))
    }
}