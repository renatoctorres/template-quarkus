plugins {
    java
    id("io.quarkus")
}

repositories {
    mavenCentral()
    mavenLocal()
}

val lombokVersion = "1.18.26"
val quarkusVersion = "3.9.1"
val quarkusAmazonDynamoDbVersion = "2.13.1"
val mapStructVersion = "1.5.5.Final"
val mockitoVersion = "5.11.0"
val restAssuredVersion = "5.4.0"
val awsJavaSdkVersion = "1.12.692"
val sdkRestConnection = "2.25.30"

val quarkusPlatformGroupId: String by project
val quarkusPlatformArtifactId: String by project
val quarkusPlatformVersion: String by project

dependencies {
    annotationProcessor("org.projectlombok:lombok:${lombokVersion}")
    compileOnly("org.projectlombok:lombok:${lombokVersion}")
    implementation("org.projectlombok:lombok:${lombokVersion}")
    implementation("com.amazonaws:aws-java-sdk-bom:${awsJavaSdkVersion}")
    implementation("com.amazonaws:aws-java-sdk-dynamodb:${awsJavaSdkVersion}")
    implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))
    implementation("io.quarkus:quarkus-rest:${quarkusVersion}")
    implementation("io.quarkus:quarkus-smallrye-openapi:${quarkusVersion}")
    implementation("io.quarkiverse.amazonservices:quarkus-amazon-dynamodb:${quarkusAmazonDynamoDbVersion}")
    implementation("io.quarkiverse.amazonservices:quarkus-amazon-dynamodb-enhanced:${quarkusAmazonDynamoDbVersion}")
    implementation("io.quarkus:quarkus-arc:${quarkusVersion}")
    implementation("io.quarkus:quarkus-rest-jackson")
    implementation("io.quarkus:quarkus-rest-jsonb:${quarkusVersion}")
    implementation("org.mapstruct:mapstruct:${mapStructVersion}")
    implementation("org.mapstruct:mapstruct-processor:${mapStructVersion}")
    implementation("software.amazon.awssdk:url-connection-client:${sdkRestConnection}")
    testImplementation("io.quarkus:quarkus-bom:${quarkusVersion}")
    testImplementation("io.quarkus:quarkus-junit5:${quarkusVersion}")
    testImplementation("io.quarkus:quarkus-junit5-mockito:${quarkusVersion}")
    testImplementation("org.mockito:mockito-core:${mockitoVersion}")
}

group = "com.rct"
version = "1.0.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<Test> {
    systemProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager")
}
tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-parameters")
}
