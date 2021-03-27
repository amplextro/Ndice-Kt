import java.io.FileInputStream
import java.util.*

plugins {
    id("java")
    kotlin("jvm")  version "1.4.30"
    id("com.github.gmazzo.buildconfig") version "3.0.0"
}

allprojects {
    group = "net.amplextro.ndice_kt"
    version = "0.1.0"
}

repositories {
    mavenCentral()
    jcenter()
}

val ktorVersion = "1.5.2"

val localProperties = Properties()
localProperties.load(FileInputStream(rootProject.file("local.properties")))

buildConfig {
    // import bot token from local.properties
    buildConfigField("String", "BOT_TOKEN", localProperties.getProperty("botToken"))
}

dependencies {
    implementation(gradleKotlinDsl())
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-cio:$ktorVersion")
    implementation("net.dv8tion:JDA:4.2.0_168")
}

tasks.test {
    useJUnitPlatform()
}