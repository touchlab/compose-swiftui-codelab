# Multiplatform Compose + SwiftUI = The Native App Future

In this codelab, we will look in KMP's killer feature, interop! Compose and SwiftUI can work together.
Render “native” UI or shared Compose UI, with the same underlying logic.
Make more UI “native”, or build more features with shared UI, and make those decisions incrementally.

## Requirements

You will need the following:

- JVM 17
- Android SDK and the latest stable Android Studio (2023.3+)
- Mac with Xcode 15.1+ for the iOS build

You can validate if everything is setup properly by using [kdoctor](https://github.com/Kotlin/kdoctor).

## Getting Started

Clone this repository at your machine

`git clone git@github.com:touchlab/compose-swiftui-codelab.git`

Once cloned, open the project in Android Studio. Wait for Gradle to complete sync and run the Android app.

Next, open `iosApp/iosApp.xcodeproj` in Xcode or execute in terminal `xed iosApp/`. Run the project in a real device or iOS Simulator.

On Android, we will use Google Maps, it requires setup the Maps Key on the `gradle.properties`. [Google Maps Documentation for setup key](https://developers.google.com/maps/documentation/android-sdk/get-api-key)

`MAPS_API_KEY=Your Api Key`

## Stack

- [Compose KMP](https://github.com/JetBrains/compose-multiplatform)
- [Voyager](https://github.com/adrielcafe/voyager) for Compose Multiplatform navigation
- [Jetpack ViewModel KMP](https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-lifecycle.html#viewmodel-implementation) recently announced ViewModel KMP with Voyager experimental support
- [SKIE](https://github.com/touchlab/SKIE) Swift friendly API
