ESchool 
Backend

1. Установка  
  1.1. Для того, чтобы скачать бэкенд проекта, вводим в командную строку 'git clone https://github.com/moooge89/eschool.git' .
  Перед этим на устройстве должен быть установлен Git.  
  1.2. Папку, которую только что скачали (называется eschool-master), надо открыть в IDE (в моем случае - Intellij Idea) как проект.
  После того, как проект откроется, maven начнет загрузить нужные зависимости.
  
  
2. Работа с проектом  
  2.1. На данном этапе уже можно запустить проект. Однако, перед этим запустите маленькое тестирование: запустите класс StudentControllerTest, 
  который находится в src/test/java/kz/greetgo/eschool/controllers. После запуска класса ждем результата тестировании.  
  2.2. После тестировании уже можно запускать проект. Для этого запускаем класс ESchoolApplication, который находится в 
  src/main/java/kz/greetgo/eschool. После этого надо немножко подождать, пока проект соберется. Далее можно самому убедится 
  в работоспособности проекта, зайдя в 'http://localhost:8080/student/test'. На экране должно отображаться данные одного тестового школьника.  
  2.3. Теперь оставляем проект включенным, потому что он будет отправлять данные фронт-энду.
