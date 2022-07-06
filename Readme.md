## Что это
Практика по курсу  Udemy "Gradle for java developers"

## Полезные сведения
### Опции и команды
|Флаг|Описание|
|-|-|
|--rerun-tasks|выполнить все задачи, даже если их входные данные не изменились|

|задача|Описание|
|-|-|
|javaToolchains|Вывести найденные JDK|

## Интеграция с SonarQube
[Быстрая настройка](https://docs.sonarqube.org/latest/setup/get-started-2-minutes/)

В /gradle.properties прописать настройки:
```properties
sonar.login=admin
sonar.password=some-password
#sonar.scm.provider=git
```
Веб-интерфейс будет доступен по адресу http://localhost:9000. Логин и пароль по умолчанию - **admin**.

Запуск в докере:

    docker run -d --name sonarqube -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true -p 9000:9000 --stop-timeout 3600 sonarqube:9.5.0-community
Повторный запуск в докере:

    docker start sonarqube

## Сборка при помощи jenkins
### Установка Jenkins
    docker run -d --name jenkins -p 8080:8080 -p 50000:50000 --restart=on-failure jenkins/jenkins:lts
Пароль админа:

    docker exec jenkins cat /var/jenkins_home/secrets/initialAdminPassword

  - Зайти на http://localhost:8080/pluginManager/installed и убедиться, что установлен плагин gradle
  - зайти на http://localhost:8080/configureTools/ и добавить там установку gradle нужной версии
  - на странице http://localhost:8080/view/all/newJob выбрать "Создать задачу со свободной конфигурацией".
    - Задать описание (First webapp Jenkins job)
    - Опционально сконфигурировать интеграцию с git
    - Добавить шаг сборки "Invoke Gradle script"
      - Use Gradle Wrapper
      - tasks: clean build

Дальше автор добавляет путь к сборочному файлу прямо в файловой системе. Я повторять не стал

## Миграция с maven
Если сделать ```gradle init``` в папке с проектом maven, то будет предложено создать проект Gradle на основе maven.
