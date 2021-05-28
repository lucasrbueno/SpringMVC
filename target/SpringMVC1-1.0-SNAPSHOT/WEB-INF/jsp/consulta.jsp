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
            <form method="get" action="pesquisa">
                <input type="text" name="palavra">
                <input type="submit" value="Procurar">              
            </form>
            <h3><a href="cadastro">Novo Aluno</a></h3>
            <table class="table">
                <thead>
                    <tr>
                        <th>
                            Nome
                        </th>
                        <th>
                            Telefone
                        </th>
                        <th>
                            Ações
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
                            <td>
                                <a href="alterar?id=${atributo.id}">Alterar</a>
                                <a href="excluir?id=${atributo.id}">Excluir</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
