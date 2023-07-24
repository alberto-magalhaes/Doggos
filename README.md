# Doggos

This is a simple application that utilizes Dog API (https://dog.ceo/dog-api/) to enlist dog breeds.

In order to achieve the results, the application has the followin characteristics:

- 100% developed using Kotlin as programming language
- Uses Retrofit to manage REST API calls
- Uses Room to manage data persistence
- Uses Koin to manage dependency injection
- Uses Coil to load images from URL
- Uses Coroutine Flows to manage data stream
- Uses Single Activity and MVVM architecture principles
- Has as simple UI with Light and Dark modes

It worth mention that the app was not modularized because of its simple nature, which would not benefit from a multi-module architecture, but in case of scalability need, its packages are simple to transform into modules.

With more time, it would be possible to add animations to the transitions between fragments and a loading state.
