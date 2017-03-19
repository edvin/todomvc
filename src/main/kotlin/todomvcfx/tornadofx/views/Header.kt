package todomvcfx.tornadofx.views

import todomvcfx.tornadofx.app.Styles
import todomvcfx.tornadofx.controllers.Store
import tornadofx.*

class Header : View() {
    val store: Store by inject()

    override val root = vbox {
        addClass(Styles.header)
        label("todos").setId(Styles.title)
        hbox {
            addClass(Styles.addItemRoot)
            checkbox {
                addClass(Styles.mainCheckBox)
                visibleWhen { booleanBinding(store.todos) { isNotEmpty() } }
                setOnAction { store.toggleCompleted(isSelected) }
            }
            textfield {
                promptText = "What needs to be done?"
                setOnAction {
                    store.addTodo(text)
                    clear()
                }
            }
        }
    }
}
