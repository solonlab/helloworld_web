import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "2.1.0"
}

repositories {
    mavenLocal()
    mavenCentral()
    maven { url = uri("https://mirrors.cloud.tencent.com/nexus/repository/maven-public/") }
}

group = "com.example"
version = "1.0"
description = "Demo project for Solon"


dependencies {
    implementation(platform("org.noear:solon-parent:3.6.0"))
    
    implementation("org.noear:solon-web")
    implementation("org.noear:solon-view-freemarker")
    implementation("org.noear:solon-logging-logback")
    implementation("com.zaxxer:HikariCP")
    implementation("com.h2database:h2:1.4.200")

    testImplementation("org.noear:solon-test")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-parameters")
}
tasks.withType<KotlinCompile> {
    kotlinOptions.javaParameters = true
}

tasks.withType<Jar> {
    manifest {
        attributes.apply {
            set("Main-Class", "com.example.demo.DemoAppKt")
        }
    }

    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from(configurations.runtimeClasspath.get().map {
        if (it.isDirectory) it else zipTree(it)
    })

    from(sourceSets.main.get().output)
}