# Overview
templates for jetpack compose

# Developement Environment
<img width="515" alt="スクリーンショット 2021-12-18 13 53 22" src="https://user-images.githubusercontent.com/16476224/146629502-23441780-4265-4692-ade5-2922ba22168f.png">

# App architecture

<img width="582" alt="スクリーンショット 2021-12-20 15 58 59" src="https://user-images.githubusercontent.com/16476224/146725205-ac598f5f-c5a6-4cc4-8d38-559ca50bdf77.png">

# implementation Rules

- API KEY is managed as confidential information (`local.properties`)
- ui layer
  - State handling is done by `@Composable function`.
  - If simple logic, Call Repository (Interface) directly from ViewModel.
  - Error handling(try catch) is done by ViewModel.
  - [Threading](https://developer.android.com/jetpack/guide/ui-layer#threading-concurrency)
- domain layer
  - Pure Kotlin.
  - hold Model(Serialize).
  - [Threading](https://developer.android.com/jetpack/guide/domain-layer#threading)
- data layer
  - Specify the Dispatcher.
  - One shot processing throws an Exception individually.
  - Coroutines Flow etc. return the processing result in the form of Sealed interface. (Reference: Paging3)
  - [Threading](https://developer.android.com/jetpack/guide/data-layer#threading)
- Proguard / R8
  - [Use only stable libraries](https://github.com/LeoAndo/AndroidAppTemplate/issues/40#issue-925121453)

# Supported OS Version

OS: 8.0 (API Level 26) or later.

# Template01

- [coding flow](https://github.com/LeoAndo/android-compose-templates/pulls?q=is%3Apr+is%3Aclosed)


- Features
  - UI
    - [Material3](https://m3.material.io/)
  - DI
    - Dagger Hilt 
  - Network
    -  (retrofit, okhttp, moshi)
  - local (Under implementation)
    - ( room and datastore )
  - Web API 
    - ([Unsplash](https://unsplash.com/documentation)) 
  - app architecture
    - single module
    - Single Activity, No Fragments
    - Navigation
      - Navigation Graph & Nest Navigation
  - other
    - [buildSrc](https://github.com/LeoAndo/android-compose-templates/pull/4)
    - [Manage secret key](https://github.com/LeoAndo/android-compose-templates/pull/9)
    - [SplashScreen](https://github.com/LeoAndo/android-compose-templates/pull/2)

- capture

| Pixel 4 OS12 |
|:---|
|<img src="https://github.com/LeoAndo/android-compose-templates/blob/main/TemplateApp01/capture/untitled.gif" width=320 /> |

# Other Android Templates
https://github.com/LeoAndo/AndroidAppTemplate<br>
https://github.com/LeoAndo/android-app-teaching-material-templates<br>

# refs

## about app architecture 
https://android-developers.googleblog.com/2021/12/rebuilding-our-guide-to-app-architecture.html?m=1<br>
https://developer.android.com/jetpack/guide/ui-layer<br>
https://developer.android.com/jetpack/guide/domain-layer<br>
https://developer.android.com/jetpack/guide/data-layer<br>

## about compose
https://developer.android.com/jetpack/compose/mental-model<br>
https://github.com/android/compose-samples<br>
https://github.com/LeoAndo/droidkaigi2021-memo/labels/Jetpack%20Compose<br>
https://github.com/LeoAndo/droidkaigi2021-memo/issues?q=is%3Aopen+is%3Aissue+label%3A%22Jetpack+Compose+1.1%22<br>
https://developer.android.com/jetpack/compose/text?hl=ja<br>

## about material3
https://m3.material.io/<br>
https://developer.android.com/reference/kotlin/androidx/compose/material3/package-summary<br>
https://cs.android.com/androidx/platform/frameworks/support/+/androidx-main:compose/material3/material3/samples/src/main/java/androidx/compose/material3/samples/NavigationBarSamples.kt?hl=ja<br>
https://cs.android.com/androidx/platform/frameworks/support/+/androidx-main:navigation/navigation-compose/samples/src/main/java/androidx/navigation/compose/samples/NavigationSamples.kt?hl=ja<br>

