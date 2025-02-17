// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id ("com.android.application") version "8.0.2" apply false
    id ("com.android.library") version "8.0.2" apply false
    id ("org.jetbrains.kotlin.android") version "1.7.20" apply false
    id ("com.google.dagger.hilt.android") version "2.44" apply false
    id ("org.jetbrains.kotlin.plugin.serialization") version "1.8.21"


}
buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:8.1.0") // Ensure this is up-to-date
    }
}
