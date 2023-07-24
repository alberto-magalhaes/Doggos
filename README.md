# Doggos

This is a simple application that utilizes Dog API (https://dog.ceo/dog-api/) to enlist dog breeds.

To achieve the results, the application has the following characteristics:

- 100% developed using Kotlin as the programming language
- Uses Retrofit to manage REST API calls
- Uses Room to manage data persistence
- Uses Koin to manage dependency injection
- Uses Coil to load images from URL
- Uses Coroutine Flows to manage the data stream
- Uses Single Activity and MVVM architecture principles
- Has a simple UI with Light and Dark modes

It is worth mentioning that the app was not modularized because of its simple nature, which would not benefit from a multi-module architecture, but in case of scalability needs, its packages are simple to transform into modules.

With more time, it would be possible to add animations to the transitions between fragments and a loading state.
