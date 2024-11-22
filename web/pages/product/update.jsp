<%--
  Created by IntelliJ IDEA.
  User: qiwenyong
  Date: 2024/10/23
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品修改</title>
</head>
<body>
   <form method="post" action="${pageContext.request.contextPath}/ProductUpdateServlet">
<%--       使用隐藏域实现id的数据提交--%>
       <input type="hidden" name="id" value="${product.id}">
     <table>
         <tr>
             <td>商品名称</td>
             <td><input type="text" name="name" value="${product.name}"></td>
         </tr>
         <tr>
             <td>商品价格</td>
             <td><input type="number" name="price" value="${product.price}"></td>
         </tr>
         <tr>
             <td>商品类型</td>
             <td>
                 <select name="category">
                     <option value="">--请选则----</option>
                     <option value="图书" ${product.category=='图书'?'selected':''}>图书</option>
                     <option value="水果" ${product.category=='水果'?'selected':''}>水果</option>
                     <option value="衣服" ${product.category=='衣服'?'selected':''}>衣服</option>
                 </select>
             </td>
         </tr>
         <tr>
             <td>商品数量</td>
             <td><input type="number" name="stock" value="${product.stock}"></td>
         </tr>
         <tr>
             <td>商品状态</td>
             <td>
                 <input type="radio" value="0" name="state" ${product.state==0?'checked':''}>禁售
                 <input type="radio" value="1" name="state" ${product.state==1?'checked':''}>可售
             </td>
         </tr>
         <tr>

             <td colspan="2">
                 <input type="submit" value="修改" >
                 <input type="reset" value="重置" >
             </td>
         </tr>
     </table>
   </form>
</body>
</html>
