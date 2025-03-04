package app.aaps.plugins.aps.openAPSLSTM

import org.tensorflow.keras.Sequential
import org.tensorflow.keras.layers.LSTM
import org.tensorflow.keras.layers.Dense
import org.tensorflow.keras.optimizers.Adam

class LSTMModel(sequenceLength: Int, inputDim: Int, outputDim: Int) {

    private val model: Sequential

    init {
        model = Sequential().apply {
            add(LSTM(50, input_shape = intArrayOf(sequenceLength, inputDim)))
            add(Dense(outputDim))
            compile(optimizer = Adam(learningRate = 0.001), loss = "mean_squared_error")
        }
    }

    fun train(trainData: Array<FloatArray>, trainLabels: Array<FloatArray>, epochs: Int, batchSize: Int) {
        model.fit(trainData, trainLabels, epochs = epochs, batch_size = batchSize)
    }

    fun predict(inputData: Array<FloatArray>): Array<FloatArray> {
        return model.predict(inputData)
    }
}