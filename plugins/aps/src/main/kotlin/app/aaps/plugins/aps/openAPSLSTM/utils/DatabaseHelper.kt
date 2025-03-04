package app.aaps.plugins.aps.openAPSLSTM.utils

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = """
            CREATE TABLE data (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                timestamp TEXT,
                glucose REAL,
                insulin_basal REAL,
                insulin_bolus REAL,
                carbs REAL,
                activity_level INTEGER,
                time_of_day TEXT,
                time_since_last_insulin INTEGER,
                time_since_last_meal INTEGER,
                delta REAL,
                short_avg_delta REAL,
                long_avg_delta REAL,
                insulin_sensitivity REAL,
                environmental_factors TEXT,
                stress_events TEXT,
                day_of_week TEXT
            )
        """.trimIndent()
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS data")
        onCreate(db)
    }

    companion object {
        private const val DATABASE_NAME = "openaps_lstm.db"
        private const val DATABASE_VERSION = 1
    }
}