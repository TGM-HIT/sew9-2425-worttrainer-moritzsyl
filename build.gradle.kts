plugins {
    id("java")
}

group = "at.ac.tgm.msyllaba"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.json:json:20240303")
}

tasks.test {
    useJUnitPlatform()
}