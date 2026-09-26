package com.example.habitfocus.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.habitfocus.data.AppDatabase
import com.example.habitfocus.data.Todo
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TodoViewModel(application: Application) : AndroidViewModel(application) {

    private val todoDao = AppDatabase.getInstance(application).todoDao()

    val todos: StateFlow<List<Todo>> = todoDao.getAllTodos()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun addTodo(title: String, dueDate: String?) {
        if (title.isBlank()) return
        viewModelScope.launch {
            todoDao.insertTodo(Todo(title = title.trim(), dueDate = dueDate?.ifBlank { null }))
        }
    }

    fun toggleDone(todo: Todo) {
        viewModelScope.launch {
            todoDao.updateTodo(todo.copy(isDone = !todo.isDone))
        }
    }

    fun deleteTodo(todo: Todo) {
        viewModelScope.launch { todoDao.deleteTodo(todo) }
    }
}
