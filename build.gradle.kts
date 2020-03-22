import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.61"
}

group = "ru.eda.bot"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    jcenter()
    mavenCentral()
    maven(url = "https://jitpack.io")
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation("io.ktor:ktor-client-cio:1.3.2")

    implementation("org.telegram:telegrambots:4.6")

    implementation("commons-io:commons-io:2.5")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.10.3")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.10.3")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.10.3")

    implementation("javax.validation:validation-api:2.0.1.Final")
    implementation("org.hibernate.validator:hibernate-validator:6.1.2.Final")
    implementation("org.glassfish:javax.el:3.0.0")

    testImplementation("org.jetbrains.kotlin:kotlin-test:1.3.70")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:1.3.70")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.6.0")
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "ru.eda.bot.feedchecker.BotStarter"
    }

    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}
