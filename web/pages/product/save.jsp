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
    <title>商品添加</title>
</head>
<body>
   <form method="post" action="${pageContext.request.contextPath}/ProductAddServlet">
     <table>
         <tr>
             <td>商品名称</td>
             <td><input type="text" name="name"></td>
         </tr>
         <tr>
             <td>商品价格</td>
             <td><input type="number" name="price"></td>
         </tr>
         <tr>
             <td>商品类型</td>
             <td>
                 <select name="category">
                     <option value="">--请选则----</option>
                     <option value="图书">图书</option>
                     <option value="水果">水果</option>
                     <option value="衣服">衣服</option>
                 </select>
             </td>
         </tr>
         <tr>
             <td>商品数量</td>
             <td><input type="number" name="stock"></td>
         </tr>
         <tr>
             <td>商品状态</td>
             <td>
                 <input type="radio" value="0" name="state">禁售
                 <input type="radio" value="1" name="state">可售
             </td>
         </tr>
         <tr>

             <td colspan="2">
                 <input type="submit" value="提交" >
                 <input type="reset" value="重置" >
             </td>
         </tr>
     </table>
   </form>
</body>
</html>
