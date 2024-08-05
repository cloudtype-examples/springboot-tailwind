plugins {
    id("org.springframework.boot") version "3.2.8"
    id("io.spring.dependency-management") version "1.1.6"
    kotlin("jvm") version "1.9.24"
    kotlin("plugin.spring") version "1.9.24"
}

group = "io.cloudtype"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

val npmInstall by tasks.register<Exec>("npmInstall") {
    workingDir = file("${project.projectDir}")
    commandLine("npm", "install")
}

val npmBuildCss by tasks.register<Exec>("npmBuildCss") {
    workingDir = file("${project.projectDir}")
    commandLine("npm", "run", "build:css")
    dependsOn(npmInstall)
}

tasks.named("processResources") {
    dependsOn(npmBuildCss)
}

tasks.named("bootJar") {
    dependsOn(npmBuildCss)
}