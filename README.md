
Overview:
=========

- Supported versions : 21[OS - 5.0  Lollipop] - 33[OS - 13 Tiramisu]

- Libraries :
    1. Android Material Design 2 and 3.
    2. Android Jetpack Compose.
    3. Kotlin Coroutines.
    4. Hilt - Dependency Injection.
    5. Retrofit with okhttp3, gson - Network communication and data parsing.
    8. Unit testing - JUnit, MockK and Espresso.

Architecture:
============
![Arch](https://github.com/hithayath/SampleWorks/assets/13219351/c1e03c73-92e8-48c7-945b-193bfeddb342)


Usage:
======
1. Clone/Download from github link.
2. Open from AndroidStudio as  "open an existing Android Studio project" at cloned/extracted drive location.
3. Find below the project structure explanation for details.

Project Structure:
==================

Design pattern : MVVM

Base package : com.sample.myapplication

Depends on the functionaly, components are categorized as sub-packages as below:

- datalayer : For data handling either from api or local or mock

- domainlayer : Business layer to handle application business logics if any.

- uilayer:
    - components: Atomic design component applied on jetpack compose for reusability
    - screens: Different screens of the app.
    - theme: Theme applied on app with Light and Dark themes.

Unit Test:
==========
- Unit test coverage applied on view models and use cases.
- UI test coverage applied on List screen, Details Screen.
	