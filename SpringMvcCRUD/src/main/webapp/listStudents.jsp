<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  <center>
<h1>Students List</h1>  
<table border="5" cellpadding= '8' >  
<tr>
<th>Id</th>
<th>Name</th>
<th>Age</th>
<th>Gender</th>
<th>Dept</th>
</tr>  
   <c:forEach var="emp" items="${list}">   
   <tr>  
   <td>${emp.id}</td>  
   <td>${emp.sName}</td>  
   <td>${emp.age}</td>  
   <td>${emp.gender}</td>  
   <td>${emp.dept}</td>

   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="RegisterStudent">Add New Student</a> 
   </center>> 