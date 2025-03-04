package app.aaps.plugins.aps.openAPSLSTM

import org.junit.Test
import kotlin.test.assertEquals

class LSTMPluginTest {

    @Test
    fun testDetermineBasal() {
        val plugin = OpenAPSLSTMPlugin(context = mockContext)
        plugin.trainModel()

        val determineBasalLSTM = DetermineBasalLSTM(plugin)
        val inputData = listOf(120.0, 0.5, 0.0, 30.0, 0.0, 15.0, 15.0, 10.0, 5.0, 3.0, 1.0)
        val basal = determineBasalLSTM.determineBasal(inputData)

        assertEquals(expectedBasal, basal, 0.1)
    }
}