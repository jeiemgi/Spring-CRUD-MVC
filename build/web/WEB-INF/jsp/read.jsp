<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Spring MVC CRUD - Read</title>
        <meta charset="UTF-8"/>

        <link rel="stylesheet" href= "<c:url value="/public/vendor/styles/materialize.min.css"/>"/>
        <link rel="stylesheet" href= "<c:url value="/public/css/app.css"/>"/>
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons"/>
    </head>

    <body>
          <nav class="blue">
            <div class="nav-wrapper">
                <div class="container">
                    <a href="#!" class="brand-logo ">Spring MVC</a>
                    <a href="#" data-activates="mobile-demo" class="button-collapse">
                        <i class="material-icons">menu</i>
                    </a>
                    <ul class="right hide-on-med-and-down">
                        <li><a href="<c:url value="/read.htm"/>"> Inicio</a></li>
                        <li><a href="<c:url value="/add.htm"/>" class="green"> <i class="material-icons left">add</i> Agregar</a></li>
                    </ul>
                    <ul class="side-nav" id="mobile-demo">
                        <li><a href="<c:url value="/read.htm"/>"> Inicio</a></li>
                        <li><a href="<c:url value="/add.htm"/>" class="green"> <i class="material-icons left">add</i> Agregar</a></li>
                    </ul>  
                </div>

            </div>
        </nav>
        <!-- Modal Structure -->
        <div id="modal_1" class="modal">
            <div class="modal-content">
                <h4>Eliminar</h4>
                <p>¿Estás seguro que quieres eliminar este elemento?</p>
            </div>
            <div class="modal-footer">
                <a id="confirmDelete" href="#!" class="modal-action waves-effect waves-red btn-flat">ELIMINAR</a>
                <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">CANCELAR</a>
            </div>
        </div>        

        <div class="app container">
            <h3>Lista de Usuarios</h3>
            <table class="responsive-table striped centered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombres</th>
                        <th>Apellidos</th>
                        <th>Email</th>
                        <th>Teléfono</th>
                        <th>Género</th>
                        <th>Acciones</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${usersData}" var="userData">
                        <tr>
                            <td><c:out value = "${userData.id}"/></td>
                            <td><c:out value = "${userData.first_name}"/></td>
                            <td><c:out value = "${userData.last_name}"/></td>
                            <td><c:out value = "${userData.email}"/></td>
                            <td><c:out value = "${userData.phone_number}"/></td>
                            <td><c:out value = "${userData.gender}"/></td>
                            <td>
                                <a class = "waves-effect waves-light btn-floating light-blue accent-3" href="edit.htm?id=${userData.id}">
                                    <i class="tiny material-icons">mode_edit</i>
                                </a>
                                <a class="waves-effect waves-light btn-floating light-blue accent-3 deleteButton" data-user="${userData.id}">
                                    <i class="tiny material-icons">delete</i>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>
        <footer class="page-footer blue">
            <div class="container">
                <div class="row">
                    <div class="col l6 s12">
                        <h5 class="white-text">SPRING MVC </h5>
                        <p class="grey-text text-lighten-4">CRUD desarrollado para la materia de Desarrollo de Aplicaciones II, con Materialize CSS</p>
                    </div>
                </div>
            </div>
            <div class="footer-copyright">
                <div class="container">
                    © 2017 José Miguel Gutiérrez Delgado
                    <a class="grey-text text-lighten-4 right" href="#!">More Links</a>
                </div>
            </div>
        </footer>
        <script src="<c:url value="/public/vendor/scripts/jquery-3.2.1.min.js"/>"></script>
        <script src="<c:url value="/public/vendor/scripts/materialize.min.js"/>"></script>
        <script src="<c:url value="/public/js/app.js"/>"></script>
    </body>
</html>
