@file:Suppress("unused")

package todomvcfx.tornadofx.models

import javafx.beans.property.ObjectProperty
import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*
import java.util.*

class TodoItem(text: String) {
    val id = UUID.randomUUID()

    val textProperty = SimpleStringProperty(text)
    var text by textProperty

    val completedProperty = SimpleBooleanProperty()
    var completed by completedProperty

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as TodoItem

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}

class TodoItemModel(property: ObjectProperty<TodoItem>) : ItemViewModel<TodoItem>(itemProperty = property) {
    val text = bind(autocommit = true) { item?.textProperty }
    val completed = bind(autocommit = true) { item?.completedProperty }
}

enum class FilterState { All, Active, Completed }