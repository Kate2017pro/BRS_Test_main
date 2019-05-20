Авто-тесты для системы БРС. 
Selenium + Java + TestNG + Doxygen + Maven
Соединять с мастером нежелательно. Содержимоеодинаковое только находится в разных папках. Тут все классу находятся в src\test

Структура проекта:
--------------------------

|	| Пакет			| Класс			| Описание
|------|-----------------------|-----------------------|--------------------------------------|
|src	| RegressionsTest	| SimpleTest		| Переход по заранее заданным ссылкам
|	|			| StudentAccTest	| и проверка существования этих страниц
|	|			| TeacherAccTest	|
|	|			| DekanatAccTest	|
|	| AuthorizationTest	| AuthorizationFormTest	| Тесты авторизации
|	|			| AuthorizationTest	||
|	| UnauthorizedPageTest	| TabsTest		| Тесты элементов на странице для
|	|			| FooterLinks		| неавторизированного пользователя
|	| StudentPageTest	| 	PageOfDisciplin		| Кнопки на странице дисциплины у студента |
| | TeacherTest | TeacherTest | Тесты для преподовательского аккаунта на кнопки и оценки |
| | | AfterClickBtnsTest |
| | | EditDisciplinPageTest |
| | | MarksForSemestrPageTest |
| | | MarksForSessiaPageTest |
| | | MarksOfZachetPageTest |
| | | ProsmotrDisciplinPageTest |



В каждом пакете реализован базовый класс Helper, содержащий основные функции взаимодействия со страницей и сервисом. Так как, например: процесс авторизации, переключение семестров и т.п. (см. в документации)

От пакета к пакету содержимое этого класса может меняться, добавляются новые функции.

Документация
----------------
Для создания документации использовался Doxygen.

Документация к проекту находится в папке "Документация". Формат - html.
Для просмотра зайти в папку и открыть index.html - ярлык в папке

Установка
--------------
Выполнить установку Maven(сборщик проекта) и Java
или можно использовать эти ссылки:

* https://maven.apache.org/download.cgi

* https://www.java.com/en/download/

* https://www.seleniumhq.org/download/

Создать переменную окружения JAVA_HOME=C:\Program Files\Java\jdk-10.0.2

Создать переменную окружения M2_HOME=C:\Program Files\apache-maven-3.5.4

т.е. путь к программе.

Добавить эти переменные в Path с добавлением "\bin"

Среда разработки выбрана IDEA https://www.jetbrains.com/idea/download/index.html#section=windows

Переменная с jdk может не подтянуться после утановки, следует в настройках проекта устанивить путь вручную.

Для изменения документации установить Doxygen http://www.doxygen.nl/download.html#srcbin

Для отображения графов и графиков поставить допольнительно graphviz https://www.graphviz.org/download/

Для создания конфиг файла и работы не через консоль поставить Doxywizard

Запуск
--------
Про первый запуск и настройку проекта здесь написано не будет, т.к. сам проект уже создан и настроен. Создать его можно с помощью консольных команд mvn, конфигурационный файл - pom.xml

Есть разные способы запускать тесты:
* Из среды разработки. Самый простой метод. В настройках запуска к тестовому фрейворку можно выбрать параметры. Или вообще запустить нужный класс/пакет/метод через контексное меню.
* Через xml-файлы. Они имеют четкую-структуру и хранят информацию о то, что должны запускать. Через них можно конфигурировать тестовые наборы, тестироват только то, что надо, а не все сразу.
* Через командную строку. Тут тоже используются xml-файлы.___
https://qa-help.ru/questions/kak-zapustit-testng-iz-komandnoj-stroki

В файле config.ini лежат пути к драйверам для запуска браузеров. Он должен находиться в корне проекта или можно указать путь к нему через системную переменную Driver_Path (там требуется спец. вид пути: вместо одного должно быть два слэша \\). И надо заменить значение флага use_path_from_env на true в каждом Helper классе (неудобно, но пока так).

Для изменения документации doxygen <config file> или через программу Doxywizard. но не забыть проверить пути к программам (например, к graphviz)

Если проект не собирается, то закоментировать или раскоментировать строчки в pom.xml:
```xml
 <source>10.0.2</source>
 <target>10.0.2</target>
```

 
P.S. Часть тестов уже была написана Ангелиной и находится здесь 
http://gitlab.mmcs.sfedu.ru:82/it-lab/gradeUItests/blob/master/UnitTestProject1/
