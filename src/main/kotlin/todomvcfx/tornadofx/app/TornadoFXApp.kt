package todomvcfx.tornadofx.app

import javafx.application.Application
import todomvcfx.tornadofx.views.MainView
import tornadofx.*

class TornadoFXApp : App(MainView::class, Styles::class)

fun main(args: Array<String>) {
    Application.launch(TornadoFXApp::class.java, *args)
}