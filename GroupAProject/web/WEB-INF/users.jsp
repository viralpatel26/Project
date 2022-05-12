<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Notes</title>
        <link rel="stylesheet" type="text/css" href="<c:url value='assets/style/users.css' />" />
    </head>
    <body>
        <h1>Manage Notes</h1>
        <h2>Notes</h2>
        <p>${errorMessage}</p>
        <table cellpadding="0" cellspacing="0">
            <tr>
                <th>Author</th>
                <th>Title</th>
                <th>Contents</th>
                <th>Delete</th>
                <th>Edit</th>
            </tr>
            <c:forEach var="note" items="${notes}">
                <tr>
                    <td>${note.author}</td>
                    <td>${note.title}</td>
                    <td>${note.contents}</td>
                    <td>
                        <form action="users" method="post" >
                            <input type="submit" value="Delete">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="selectedNote" value="${note.noteid}">
                        </form>
                    </td>
                    <td>
                        <form action="users" method="get">
                            <input type="submit" value="Edit">
                            <input type="hidden" name="action" value="view">
                            <input type="hidden" name="selectedNote" value="${note.noteid}">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <c:if test="${selectedNote == null}">
            <h3>Add User</h3>
            <form action="users" method="POST">
                Note ID:<input type="text" name="noteid"><br>
                Author: <input type="text" name="author"><br>
                Title: <input type="text" name="title"><br>
                Contents: <input type="text" name="contents"><br>
                <input type="hidden" name="action" value="add">
                <input type="submit" value="Save">
            </form>
        </c:if>
        <c:if test="${selectedNote != null}">
            <h3>Edit User</h3>
            <form action="users" method="POST">
                Note ID:<input type="text" name="noteid" value="${selectedNote.noteid}" readonly><br>
                Author: <input type="text" name="author" value="${selectedNote.author}"><br>
                Title: <input type="text" name="title" value="${selectedNote.title}"><br>
                Contents: <input type="text" name="contents" value="${selectedNote.contents}"><br><!--If we dont change this page, we should change this to a text area rather than a text input-->
                <input type="hidden" name="action" value="edit">
                <input type="submit" value="Save">
            </form>
        </c:if>
    </body>
</html>
