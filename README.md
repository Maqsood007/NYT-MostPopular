# NYT-MostPopular

# NYT-MostViewed
New-York-Time's most popular articles using MVVM approach. A design pattern help to have the separation of concerns &amp; batter testability.

# Requirements to run the code:

**Pre-Requisite Installations**

- Java development kit(JDK) 11
- Android Studio Arctic Fox + SDK installation
- Android gradle plugin version: 7.0.0
- Min API Level: 21
- Gradle version: 7.0.2
- TargetSdkVersion: 30

# Technologies stack(Features):

- Android MVVM (ModelView-View-Model) design pattern.
- Programing Language: Kotlin.
- Architectural Navigation.
- Material them (Day(Light) & Night(Dark) support)
- Network library: Retrofit + logging Interceptors.
- Kotlin Coroutines & Coroutine+live data builders
- Encrypted Shared Preferences.
- Android Data Binding
- Hilt for dependency Injection.
- Leak canary added for memory leaks detection.
- Spotless for linting. A wrapper to ktlint.
- Picasso added for image loading & rendering.
- Pre commit hook for lint check & auto fix(i.e unused imports).
- Github actions workflow added. run(unit tests, instrumentations tests, lint checks with spotless, build project)
- Work with development branch, lets raise the PR from development to main branch. in multi-team members, we can use the feature branch or forked repository mechanism.
- Support for multi-languages.
- Support for Dark and Light theme.
- Junit4 + Mockito for unit testing.


# Running Tests:

I have written a test task inside app_test_runner.gradle

- Run ./gradlew runUnitTests to run the unit tests.
- Run ./gradlew runInstrumentationTests to run the instrumentations tests.
- Run ./gradlew spotlessApply to fix linting issues automatically.
- Run ./gradlew spotlessCheck for verifying the code via spotless(ktLint).
- Run ./gradlew build to build the project with gradle.

Test reports can be found under /app/build/reports/tests.

![alt text](https://github.com/Maqsood007/NYT-MostPopular/blob/development/demo_res/test_reports.png)


# Spotless Linting Klint:

- Reports can be found at 'app/build/reports/lint-results.html'

![alt text](https://github.com/Maqsood007/NYT-MostPopular/blob/development/demo_res/sportless_linting_reports.png)

# GitHub Action added for CI:

On each push to main branch & each pull request created to the main branch.

- setting up the jdk 11.
- Setting emulator with default, google API's.
- Check linting with spotless.
- Running unit tests.
- Running instrumentation unit tests.
- Build the Project with gradle.

![alt text](https://github.com/Maqsood007/NYT-MostPopular/blob/development/demo_res/android-ci.png)

# Dark & Light Theme support using Material dependency:

- Added a setting screen to forcefully toggle between Dark/Light mode.
- Once user has set the preference internally, user preference will be upon device theme preference.

![alt text](https://github.com/Maqsood007/NYT-MostViewed/blob/development/demo_res/dark-light_theme-support.gif)

# RTL support:

- Add a support for RTL layout. i.e Arabic language.

![alt text](https://github.com/Maqsood007/NYT-MostViewed/blob/development/demo_res/rtl-support.gif) 
 
   
