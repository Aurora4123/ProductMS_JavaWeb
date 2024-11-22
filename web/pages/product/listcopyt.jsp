<%--
  Created by IntelliJ IDEA.
  User: qiwenyong
  Date: 2024/10/23
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品列表</title>
</head>
<body>
   <table>
       <tr>
           <th>编号</th>
           <th>商品名字</th>
           <th>商品价格</th>
           <th>商品类型</th>
           <th>商品库存</th>
           <th>商品状态</th>
           <th>操作</th>
       </tr>
       <c:forEach items="${productList}" var="product" varStatus="stat">
           <tr>
               <td>${stat.count}</td>
               <td>${product.name}</td>
               <td>${product.price}</td>
               <td>${product.category}</td>
               <td>${product.stock}</td>
               <td>${product.state == 0 ?'禁售':'可售'}</td>
               <td>
                   <a href="${pageContext.request.contextPath}/ProductFindByIdServlet?id=${product.id}">修改</a>
                   <a href="${pageContext.request.contextPath}/ProductDeleteByIdServlet?id=${product.id}">删除</a>
               </td>
           </tr>
       </c:forEach>
       <tr>
           <td colspan="7">
               <a href="pages/product/save.jsp">继续添加</a>
           </td>
       </tr>
   </table>
</body>
</html>
