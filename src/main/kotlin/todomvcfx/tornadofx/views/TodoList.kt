package todomvcfx.tornadofx.views

import todomvcfx.tornadofx.controllers.Store
import tornadofx.*

class TodoList : View() {
    val store: Store by inject()

    override val root = listview(store.todos) {
        isEditable = true
        cellFragment(TodoItemFragment::class)
    }
}