# TodoMVC TornadoFX

This is the TornadoFX take on the Todo MVC application.

## Description of Views

`MainView` encapsulates the `Header`, `TodoList` and `Footer` while the `TodoList` uses `TodoItemFragment` for each ListView cell.

![](http://i.imgur.com/WMQ9ebV.png)

## Filtering

The `Footer` contains three toggle buttons that allow you to select what todo items to show. The selection
represents a predicate set on a `SortedFilteredList`.

## Editing todo items

We leverage the built in `ListView` editing support to toggle between a label and a textfield for the
text of the todo item. When the edit is committed, the underlying `SortedFilteredList` will update
automatically to reflect the changes. If the edited todo item no longer satisfies the current filtering
predicate, the item will no longer be visible. This all comes for free by leveraging the `SortedFilteredList`
together with the native `ListView` editing support.

## Declarative programming

I opted for using builders together with declarative constructs like `removeWhen`, `toggleClass` and `whenVisible`
to configure actions and changes in UI state. This makes for source code that is easy to read and understand
as well as being a pleasure to maintain. I believe this showcases some of the greatest advantages TornadoFX
offers compared to almost every other UI framework.

## Alternative approaches

I opted for a model with some coupling, by injecting the controller and calling functions instead of
using the event bus. If there is any interest I'll create an alternative implementation with events.
