<!DOCTYPE html>
<html>
<head>
    <title>ONLINE SCHOOL</title>
</head>
<body>
<h1>ONLINE SCHOOL</h1><hr>
<h3>Курс по написанию оконных приложений на C#</h3>


<#--&lt;#&ndash;<#list frontTutors as frontTutor>
    <div>
        <p><b>${frontTutor.firstName}</b> ${frontTutor.lastName}  | <a href="/front-tutor/${frontTutor.id}">Подробнее...</a></p>
    </div>
</#list>-->
<hr>
<h3>Создать нового куратора</h3>
<form action="/front-tutor/create" method="post">
    Имя куратора: <input type="text" name="firstName"/><br><br>
    Описание куратора: <input type="text" name="description"/><br><br>
    Возраст: <input type="number" name="age"/><br><br>
    Город: <input type="text" name="city"/><br><br>
    Почта: <input type="email" name="email"/><br><br>
    <input type="submit" value="Добавить"/>
</form>-->
</body>
</html>