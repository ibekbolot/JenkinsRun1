plugins {
    id("java")
    id("io.qameta.allure") version "2.11.2"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

allure {
    report {
        version.set("2.27.0")
    }
    adapter {
        allureJavaVersion.set("2.27.0")
        autoconfigure.set(true)
    }
}

dependencies {
    // JUnit 5
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

// Selenide
    implementation("com.codeborne:selenide:7.16.0")

// Lombok
    compileOnly("org.projectlombok:lombok:1.18.38")
    annotationProcessor("org.projectlombok:lombok:1.18.38")
    testCompileOnly("org.projectlombok:lombok:1.18.38")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.38")

// Owner (конфиги через app.properties)
    implementation("org.aeonbits.owner:owner:1.0.12")

// REST Assured
    implementation("io.rest-assured:rest-assured:6.0.0")

// Log4j2 + SLF4J (для @Slf4j)
    implementation("org.apache.logging.log4j:log4j-core:2.25.3")         // 2 had 2.25.3, newer
    implementation("org.apache.logging.log4j:log4j-slf4j2-impl:2.25.0") // only in 1
    implementation("org.slf4j:slf4j-api:2.0.9")                          // only in 1

// Jackson
    implementation("com.fasterxml.jackson.core:jackson-databind:2.21.2") // 2 had 2.21.2, newer

// PostgreSQL
    implementation("org.postgresql:postgresql:42.7.2")
    implementation("commons-dbutils:commons-dbutils:1.8.1")

// Javafaker (only in 1)
    implementation("com.github.javafaker:javafaker:1.0.2")

// AssertJ (only in 1)
    testImplementation("org.assertj:assertj-core:3.27.7")

// Allure JUnit 5 (only in 1)
    testImplementation("io.qameta.allure:allure-junit5:2.27.0")
    testImplementation("io.qameta.allure:allure-rest-assured:2.27.0")

// AspectJ (required by Allure)
    runtimeOnly("org.aspectj:aspectjweaver:1.9.25.1")
}

tasks.test {
    useJUnitPlatform()
    systemProperty("allure.results.directory", "$projectDir/build/allure-results")
}