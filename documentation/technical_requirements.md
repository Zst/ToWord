# Technical requirements

This document covers general technical requirements and provides brief overview of the app architecture.
 Business requirements are described in the [separate document](./requirements.md)

## Summary

The app should be designed with multi module architectural approach following MVVM structural pattern.
 Screen transitions should be animated with shared elements complying material design guidelines.

All code in the project should be written in Kotlin and built upon SOLID principles.
The list of dependencies includes but is not limited to:

- [Dagger 2](https://github.com/google/dagger) - dependency injection.
- [Kotlin coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) for asynchronous operations.
- Android Jetpack
-- [view binding](https://developer.android.com/topic/libraries/view-binding) - library for type safe and high performance interaction with views (widgets).
-- [live data](https://developer.android.com/topic/libraries/architecture/livedata) - lifecycle aware implementation of observable pattern. 
-- [navigation](https://developer.android.com/guide/navigation) - screen navigation library.
-- [view model](https://developer.android.com/topic/libraries/architecture/viewmodel) - library supporting MVVM architecture.
-- [Room](https://developer.android.com/topic/libraries/architecture/room) - ORM library.

## Modules



