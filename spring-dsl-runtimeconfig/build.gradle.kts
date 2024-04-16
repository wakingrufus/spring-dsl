plugins {
    id("java-library")
    kotlin("jvm")
    `jvm-test-suite`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":spring-dsl-base"))
    implementation(spring.context)
    implementation(spring.boot)
    implementation(spring.cloud.context)
    implementation(libs.slf4j)
    implementation(libs.oshai)
    implementation(kotlin("reflect"))

    testImplementation(project(":spring-dsl-test"))
    testImplementation(spring.boot.test)
    testImplementation(libs.oshai)
    testImplementation(libs.assertj)
}

testing {
    suites {
        named<JvmTestSuite>("test") {
            useJUnitJupiter()
        }
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}