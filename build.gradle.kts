plugins {
    id("java")
}

group = "at.ac.tgm.msyllaba"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.json:json:20240303")
}

tasks.test {
    useJUnitPlatform()
}