plugins {
    id("java-library")
    id("kotlin")
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.kotlin)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    jcenter()
}

sourceSets["main"].java.srcDir("src/main/kotlin")
sourceSets["test"].java.srcDir("src/test/kotlin")
sourceSets["test"].resources.srcDirs("src/resources")