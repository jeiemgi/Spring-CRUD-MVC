<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Spring MVC CRUD - Edit</title>
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

        <div class="app container">
            <h3>Editar Usuario</h3>
            <form:form method="post" commandName="user">
                <form:errors path ="*" element="div" cssClass=""/>

                <div class="input-field col s6">
                    <form:input placeholder="Nombre"  path="first_name" type="text" id="first_name" cssClass="validate" label="Nombre"></form:input>
                </div>

                <div class="input-field col s6">
                    <form:input placeholder="Apellidos:"  path="last_name" type="text" id="last_name" cssClass="validate" label="Apellidos"></form:input>
                </div>

                <div class="input-field col s6">
                    <form:input placeholder="Email"  path="email" type="email" id="email" cssClass="validate" label="Email"></form:input>
                </div>

                <div class="input-field col s6">
                    <form:input placeholder="Teléfono"  path="phone_number" type="tel" id="phone_number" cssClass="validate" label="Teléfono"></form:input>
                </div>

                <div class="input-field col s6">
                    <form:select  path="gender">
                        <form:option value="" label="Select">Género</form:option>
                        <form:option value="Masculino">Masculino</form:option>
                        <form:option value="Femenino">Femenino</form:option>
                    </form:select>
                </div>
                
                <input type="submit" value="Enviar" class="btn green" />

            </form:form>
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
