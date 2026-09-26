package com.example.habitfocus.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.habitfocus.data.AppDatabase
import com.example.habitfocus.data.Habit
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class HabitViewModel(application: Application) : AndroidViewModel(application) {

    private val habitDao = AppDatabase.getInstance(application).habitDao()
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

    val habits: StateFlow<List<Habit>> = habitDao.getAllHabits()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun addHabit(name: String, category: String) {
        if (name.isBlank()) return
        viewModelScope.launch {
            val today = dateFormat.format(Date())
            habitDao.insertHabit(Habit(name = name.trim(), category = category, createdDate = today))
        }
    }

    fun markDoneToday(habit: Habit) {
        viewModelScope.launch {
            val today = dateFormat.format(Date())
            if (habit.lastCompletedDate == today) return@launch // already done today

            val newStreak = if (wasYesterday(habit.lastCompletedDate)) habit.streak + 1 else 1
            habitDao.updateHabit(habit.copy(streak = newStreak, lastCompletedDate = today))
        }
    }

    fun deleteHabit(habit: Habit) {
        viewModelScope.launch { habitDao.deleteHabit(habit) }
    }

    private fun wasYesterday(dateStr: String?): Boolean {
        if (dateStr == null) return false
        val date = runCatching { dateFormat.parse(dateStr) }.getOrNull() ?: return false
        val cal = Calendar.getInstance()
        cal.add(Calendar.DAY_OF_YEAR, -1)
        val yesterday = dateFormat.format(cal.time)
        return dateStr == yesterday
    }
}
