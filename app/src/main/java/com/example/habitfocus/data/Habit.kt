package com.example.habitfocus.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "habits")
data class Habit(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val category: String = "General",
    val streak: Int = 0,
    val lastCompletedDate: String? = null, // "yyyy-MM-dd", null if never done
    val createdDate: String
)
