package todomvcfx.tornadofx.views

import javafx.scene.layout.Priority
import todomvcfx.tornadofx.app.Styles
import todomvcfx.tornadofx.controllers.Store
import todomvcfx.tornadofx.models.TodoItem
import todomvcfx.tornadofx.models.TodoItemModel
import tornadofx.*

class TodoItemFragment : ListCellFragment<TodoItem>() {
    val store: Store by inject()
    val todo = TodoItemModel(itemProperty)

    override val root = hbox {
        // Enable if you want ellipsis instead of text overflow
//        cellProperty.onChange { cell ->
//            if (cell != null)
//                maxWidthProperty().cleanBind(cell.widthProperty().minus(15))
//        }
        addClass(Styles.itemRoot)
        checkbox(property = todo.completed) {
            action {
                startEdit()
                commitEdit(item)
            }
        }
        label(todo.text) {
            setId(Styles.contentLabel)
            hgrow = Priority.ALWAYS
            useMaxSize = true
            removeWhen { editingProperty }
            toggleClass(Styles.strikethrough, todo.completed)
        }
        textfield(todo.text) {
            hgrow = Priority.ALWAYS
            removeWhen { editingProperty.not() }
            whenVisible { requestFocus() }
            action { commitEdit(item) }
        }
        button(graphic = Styles.closeIcon()) {
            removeWhen { parent.hoverProperty().not().or(editingProperty) }
            action { store.removeTodo(item) }
        }
    }

}