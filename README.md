# Проект по тестированию сайта "TELE2"
> <a target="_blank" href="https://tele2.ru/">Ссылка на сайт TELE2</a>

![This is an image](/design/images/tele2.png)

#### Список проверок, реализованных в автотестах
- [x] Проверка поисковой строки
- [x] Проверка смены региона
- [x] Проверка авторизации
- [x] Проверка тарифа Мой онлайн+ 12_2021
- [x] Добваление двух тарифов в корзину
- [x] Удаление тарифа из корзины
- [x] Параметризованные тесты
- [x] Проверка добавления товара в корзину (API)
- [x] Проверка отправки смс с кодом (mobile)
- [x] Проверка кнопки "Вход по паролю" (mobile)

## Проект реализован с использованием
Java Gradle IntelliJ IDEA Selenide Selenoid JUnit5 Jenkins Allure Report Allure TestOps Telegram Jira

![This is an image](/design/icons/Java.png)![This is an image](/design/icons/Gradle.png)![This is an image](/design/icons/Intelij_IDEA.png)![This is an image](/design/icons/Selenide.png)![This is an image](/design/icons/Selenoid.png)![This is an image](/design/icons/JUnit5.png)![This is an image](/design/icons/Jenkins.png)![This is an image](/design/icons/Allure_Report.png)![This is an image](/design/icons/AllureTestOps.png)![This is an image](/design/icons/Telegram.png)![This is an image](/design/icons/Jira.png)


# Запуск автотестов выполняется на сервере Jenkins
> <a target="_blank" href="https://jenkins.autotests.cloud/job/TELE2/">Ссылка на проект в Jenkins</a>

### Параметры сборки

* "-Dtag=${TAG}"
* "-Dbase_url=${BASE_URL}"
* "-DremoteUrl=${REMOTE_URL}"
* "-DbrowserSize=${BROWSER_SIZE}"
* "-Dbrowser=${BROWSER}"
* "-DbrowserVersion=${BROWSER_VERSION}"

### Для запуска автотестов в Jenkins

![This is an image](/design/images/jenkins1.png)

#### 2. Выбрать пункт **Собрать с параметрами**
#### 3. В случае необходимости изменить параметры, выбрав значения из выпадающих списков
#### 4. Нажать **Собрать**
#### 5. Результат запуска сборки можно посмотреть в отчёте Allure

![This is an image](/design/images/jenkins2a.png)

[//]: # (## Локальный запуск автотестов)

[//]: # (Пример командной строки:)

[//]: # (```bash)

[//]: # (gradle clean ui_tests -Dlogin=user1 -Dpassword=1234 -DtestUrl=selenoid.autotests.cloud/wd/hub/)

[//]: # (```)

[//]: # ()
[//]: # (Получение отчёта:)

[//]: # (```bash)

[//]: # (allure serve build/allure-results)

[//]: # (```)

# Полная статистика по прохождению тестпланов, отчёты и приложения к ним хранятся в Allure TestOps
> <a target="_blank" href="https://allure.autotests.cloud/project/804">Сссылка на проект в AllureTestOps</a> (запрос доступа admin@qa.guru)

### Тест-планы проекта
![This is an image](/design/images/testplans.png)
### Кейсы тест-плана выполнения ручного тестирования
![This is an image](/design/images/manual.png)
### Кейсы тест-плана выполнения автотестирования
![This is an image](/design/images/auto.png)
### Общий список всех кейсов, имеющихся в системе (без разделения по тест-планам и виду выполнения тестирования)
![This is an image](/design/images/testcases.png)
### Пример dashboard с общими результатами тестирования
![This is an image](/design/images/dashboard_all.png)
### В том числе сводная статистика запусков
![This is an image](/design/images/dashboard_all2.png)

### Пример отчёта выполнения одного из автотестов
![This is an image](/design/images/onecasereport.png)
#### *После окончания выполнения автотестов по каждому из них в отчёте доступны скриншоты и исходный код страницы, лог консоли браузера и видеозапись выполнения теста.*

### Пример видеозаписи прохождения теста
![This is an image](/design/images/Video.gif)


## По результатам ручного тестирования выявлены дефекты, зафиксированные в соответствующих задачах AllureTestOps
### Тест план выполнения ручного тестирования
![This is an image](/design/images/testplan2.png)
### Сводные результаты ручного тестирования
![This is an image](/design/images/failedresult.png)
### Пример описания дефекта в Allure TestOps
![This is an image](/design/images/testops2.png)
### Список выявленных дефектов, открытых как задачи в Allure TestOps
![This is an image](design/images/defects.png)

# Результаты выполнения тестов и информация о выявленных дефектах интегрированы с Atlassian Jira
> <a target="_blank" href="https://jira.autotests.cloud/browse/HOMEWORK-286">Ссылка на задачу в Jira</a> (запрос доступа admin@qa.guru)

Задачи на выявленные дефекты оформлены как подзадачи к данной. Связаны с соответствующими дефектами в Allure TestOps

![This is an image](/design/images/jira_n.png)

# Настроено автоматическое оповещение о результатах сборки Jenkins в Telegram-бот
![This is an image](/design/images/bot.png)


:heart: <a target="_blank" href="https://qa.guru">qa.guru</a><br/>
:blue_heart: <a target="_blank" href="https://t.me/qa_automation">t.me/qa_automation</a>
