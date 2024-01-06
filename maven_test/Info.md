//maven
mvn archetype:generate -DgroupId=ru.test -DartifactId="Maven_test" -DarchertypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

mvn validate - валидация проекта
mvn package - сборка проекта

java -cp ./target/Maven_test-1.0-SNAPSHOT.jar ru.test/App

//gradle
gradle init --type java-application создание проекта

.gradlew build


