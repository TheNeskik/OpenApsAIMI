package app.aaps.plugins.aps.openAPSLSTM.utils

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class DataRepository(context: Context) {

    private val dbHelper = DatabaseHelper(context)
    private val db: SQLiteDatabase = dbHelper.writableDatabase

    fun insertData(
        timestamp: String, glucose: Double, insulinBasal: Double, insulinBolus: Double, carbs: Double,
        activityLevel: Int, timeOfDay: String, timeSinceLastInsulin: Int, timeSinceLastMeal: Int,
        delta: Double, shortAvgDelta: Double, longAvgDelta: Double, insulinSensitivity: Double,
        environmentalFactors: String, stressEvents: String, dayOfWeek: String
    ) {
        val values = ContentValues().apply {
            put("timestamp", timestamp)
            put("glucose", glucose)
            put("insulin_basal", insulinBasal)
            put("insulin_bolus", insulinBolus)
            put("carbs", carbs)
            put("activity_level", activityLevel)
            put("time_of_day", timeOfDay)
            put("time_since_last_insulin", timeSinceLastInsulin)
            put("time_since_last_meal", timeSinceLastMeal)
            put("delta", delta)
            put("short_avg_delta", shortAvgDelta)
            put("long_avg_delta", longAvgDelta)
            put("insulin_sensitivity", insulinSensitivity)
            put("environmental_factors", environmentalFactors)
            put("stress_events", stressEvents)
            put("day_of_week", dayOfWeek)
        }
        db.insert("data", null, values)
    }

    fun getAllData(): List<Map<String, Any>> {
        val dataList = mutableListOf<Map<String, Any>>()
        val cursor = db.query("data", null, null, null, null, null, "timestamp ASC")
        with(cursor) {
            while (moveToNext()) {
                val data = mapOf(
                    "timestamp" to getString(getColumnIndexOrThrow("timestamp")),
                    "glucose" to getDouble(getColumnIndexOrThrow("glucose")),
                    "insulin_basal" to getDouble(getColumnIndexOrThrow("insulin_basal")),
                    "insulin_bolus" to getDouble(getColumnIndexOrThrow("insulin_bolus")),
                    "carbs" to getDouble(getColumnIndexOrThrow("carbs")),
                    "activity_level" to getInt(getColumnIndexOrThrow("activity_level")),
                    "time_of_day" to getString(getColumnIndexOrThrow("time_of_day")),
                    "time_since_last_insulin" to getInt(getColumnIndexOrThrow("time_since_last_insulin")),
                    "time_since_last_meal" to getInt(getColumnIndexOrThrow("time_since_last_meal")),
                    "delta" to getDouble(getColumnIndexOrThrow("delta")),
                    "short_avg_delta" to getDouble(getColumnIndexOrThrow("short_avg_delta")),
                    "long_avg_delta" to getDouble(getColumnIndexOrThrow("long_avg_delta")),
                    "insulin_sensitivity" to getDouble(getColumnIndexOrThrow("insulin_sensitivity")),
                    "environmental_factors" to getString(getColumnIndexOrThrow("environmental_factors")),
                    "stress_events" to getString(getColumnIndexOrThrow("stress_events")),
                    "day_of_week" to getString(getColumnIndexOrThrow("day_of_week"))
                )
                dataList.add(data)
            }
        }
        cursor.close()
        return dataList
    }
}