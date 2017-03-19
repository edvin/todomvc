package todomvcfx.tornadofx.views

import tornadofx.*

class MainView : View("TodoTornadoFX") {
    override val root = borderpane {
        top(Header::class)
        center(TodoList::class)
        bottom(Footer::class)
    }
}