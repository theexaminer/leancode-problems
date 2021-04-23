import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    kotlin("jvm") version "1.4.30"
    java
    application
}

group = "leetcode-problems"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    jcenter()
    mavenCentral()
    maven("https://oss.sonatype.org/content/repositories/snapshots/")

}


val logback_version = "1.2.3"

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    implementation("ch.qos.logback:logback-classic:$logback_version")


    testImplementation("org.junit.jupiter:junit-jupiter:5.6.0")
    testImplementation("org.assertj:assertj-core:3.17.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.0")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

sourceSets.getByName("main") {
    java.srcDirs("src/")
    resources.srcDirs("resources/")
    withConvention(org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet::class) {
        kotlin.srcDirs("src/")
    }
}

sourceSets.getByName("test") {
    java.srcDirs("test/")
    withConvention(org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet::class) {
        kotlin.srcDirs("test/")
    }
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "11"
        freeCompilerArgs = listOf("-Xinline-classes", "-Xopt-in=kotlin.RequiresOptIn")
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform {
        includeEngines("junit-jupiter")
        excludeEngines("junit-vintage")
    }
    testLogging {
        events("passed", "skipped", "failed")
    }
}

application {
    applicationName = "leetcode-problems"
    mainClass.set("leetcode-problems.MainKt")
}

tasks.withType<Jar> {
    archiveClassifier.set("")
    archiveAppendix.set("")
    manifest {
        attributes(
            mapOf(
                "Main-Class" to application.mainClass
            )
        )
    }
}

val run by tasks.getting(JavaExec::class) {
    standardInput = System.`in`
}

tasks.withType<Wrapper> {
    gradleVersion = "6.3"
    distributionType = Wrapper.DistributionType.BIN
}



