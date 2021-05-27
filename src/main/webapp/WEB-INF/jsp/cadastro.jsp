<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="<c:url value="recursos/style.css"/>"/>
        <title>Cadastramento</title>
    </head>
    <body>
        <div class="container">
        <h1>Cadastro Aluno</h1>
            <div>
                <form action="cadastrar" method="post">
                    <div class="form-group">
                        Nome:
                        <input type="text" name="nome" id="nome" class="form-control" required="">
                    </div>
                    <div class="form-group">
                        Telefone:
                        <input type="text" name="telefone" id="telefone" class="form-control" required="">
                    </div>
                    <input type="submit" id="submit" class="btn-primary" value="Cadastrar">
                </form>
            </div>
        </div>
    </body>
</html>
