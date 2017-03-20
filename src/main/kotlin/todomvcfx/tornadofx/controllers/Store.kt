package todomvcfx.tornadofx.controllers

import todomvcfx.tornadofx.models.FilterState
import todomvcfx.tornadofx.models.FilterState.Active
import todomvcfx.tornadofx.models.FilterState.Completed
import todomvcfx.tornadofx.models.TodoItem
import tornadofx.*

class Store : Controller() {
    val todos = SortedFilteredList<TodoItem>()

    fun addTodo(text: String) = todos.add(TodoItem(text))

    fun removeTodo(todo: TodoItem) = todos.remove(todo)

    fun toggleCompleted(completed: Boolean) = with(todos) {
        filter { it.completed != completed }.forEach { it.completed = completed }
        refilter()
    }

    fun filterBy(state: FilterState) = when (state) {
        Completed -> todos.predicate = { it.completed }
        Active -> todos.predicate = { !it.completed }
        else -> todos.predicate = { true }
    }
}