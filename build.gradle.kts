plugins {
    java
    id("io.quarkus")
}

repositories {
    mavenCentral()
    mavenLocal()
}

val lombokVersion = "1.18.42"
val quarkusVersion = "3.28.4"
val quarkusAmazonDynamoDbVersion = "3.10.0"
val mapStructVersion = "1.6.3"
val mockitoVersion = "5.20.0"
val restAssuredVersion = "5.5.6"
val awsJavaSdkVersion = "2.35.9"
val sdkRestConnection = "2.25.30"

val quarkusPlatformGroupId: String by project
val quarkusPlatformArtifactId: String by project
val quarkusPlatformVersion: String by project

dependencies {
    annotationProcessor("org.projectlombok:lombok:${lombokVersion}")
    compileOnly("org.projectlombok:lombok:${lombokVersion}")
    implementation("org.projectlombok:lombok:${lombokVersion}")
    implementation("software.amazon.awssdk:dynamodb:${awsJavaSdkVersion}")
    implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))
    implementation("io.quarkus:quarkus-rest:${quarkusVersion}")
    implementation("io.quarkus:quarkus-smallrye-openapi:${quarkusVersion}")
    implementation("io.quarkiverse.amazonservices:quarkus-amazon-dynamodb:${quarkusAmazonDynamoDbVersion}")
    implementation("io.quarkiverse.amazonservices:quarkus-amazon-dynamodb-enhanced:${quarkusAmazonDynamoDbVersion}")
    implementation("io.quarkus:quarkus-arc:${quarkusVersion}")
    implementation("io.quarkus:quarkus-rest-jackson:${quarkusVersion}")
    implementation("io.quarkus:quarkus-rest-jsonb:${quarkusVersion}")
    implementation("org.mapstruct:mapstruct:${mapStructVersion}")
    implementation("org.mapstruct:mapstruct-processor:${mapStructVersion}")
    implementation("software.amazon.awssdk:url-connection-client:${sdkRestConnection}")
    runtimeOnly("software.amazon.awssdk:bom:${awsJavaSdkVersion}")
    testImplementation("io.quarkus:quarkus-bom:${quarkusVersion}")
    testImplementation("io.quarkus:quarkus-junit5:${quarkusVersion}")
    testImplementation("io.quarkus:quarkus-junit5-mockito:${quarkusVersion}")
    testImplementation("org.mockito:mockito-core:${mockitoVersion}")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
    }
}

group = "com.rct"
version = "1.0.0-SNAPSHOT"


tasks.withType<Test> {
    systemProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager")
}
tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-parameters")
}
