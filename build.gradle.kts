plugins {
    id("java")
}

group = "at.ac.tgm.msyllaba"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.11.3")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.11.3")
    implementation("org.json:json:20240303")
}

tasks.test {
    useJUnitPlatform()
}