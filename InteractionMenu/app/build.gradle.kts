plugins {
    application
    id("org.openjfx.javafxplugin") version "0.1.0"
}

repositories {
    mavenCentral()
}

dependencies {
    // Use JUnit test framework.
    testImplementation(libs.junit)

    // This dependency is used by the application.
    implementation(libs.guava)
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

application {
    mainClass.set("interactionmenu.App")
}

javafx {
    modules("javafx.controls")
}
