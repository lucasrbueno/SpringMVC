<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <title>Consulta</title>
    </head>
    <body>
        <div class="container">
            <h1>Consulta de alunos</h1>
            <table class="table">
                <thead>
                    <tr>
                        <th>
                            Nome
                        </th>
                        <th>
                            Telefone
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${lista}" var="atributo">
                        <tr>
                            <td>
                                ${atributo.nome}
                            </td>
                            <td>
                                ${atributo.telefone}
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
