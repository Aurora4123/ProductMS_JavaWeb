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
<%--    引入外界的js--%>
    <script src="${pageContext.request.contextPath}/js/product.js"></script>
</head>
<body>
   <table>
       <tr>
           <td colspan="7">
               <form action="${pageContext.request.contextPath}/ProductListServlet" method="post">
                   商品名称：<input type="text" name="name" value="${pageUtil.t.name}">
                   商品类型：<select name="category">
                   <option value="">--请选则----</option>
                   <option value="图书" ${pageUtil.t.category=='图书' ? 'selected':''}>图书</option>
                   <option value="水果" ${pageUtil.t.category=='水果' ? 'selected':''}>水果</option>
                   <option value="衣服" ${pageUtil.t.category=='衣服' ? 'selected':''}>衣服</option>
               </select>
                   <input type="radio" value="0" name="state" ${pageUtil.t.state==0 ? 'checked':''}>禁售
                   <input type="radio" value="1" name="state" ${pageUtil.t.state==1 ? 'checked':''}>可售
                   <input type="submit" value="查询" >
                   <input type="reset" value="重置" >
               </form>
           </td>
       </tr>
       <tr>
           <th>编号</th>
           <th>商品名字</th>
           <th>商品价格</th>
           <th>商品类型</th>
           <th>商品库存</th>
           <th>商品状态</th>
           <th>操作</th>
       </tr>
       <c:forEach items="${pageUtil.data}" var="product" varStatus="stat">
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
               <a href="${pageContext.request.contextPath}/ProductListServlet?pageNum=1&name=${pageUtil.t.name}&category=${pageUtil.t.category}&state=${pageUtil.t.state}">首页</a>
               <a href="${pageContext.request.contextPath}/ProductListServlet?pageNum=${pageUtil.hasPre ? pageUtil.pageNum-1:pageUtil.pageNum}&name=${pageUtil.t.name}&category=${pageUtil.t.category}&state=${pageUtil.t.state}">上一页</a>
               <a href="${pageContext.request.contextPath}/ProductListServlet?pageNum=${pageUtil.hasNext ? pageUtil.pageNum+1:pageUtil.lastPage}&name=${pageUtil.t.name}&category=${pageUtil.t.category}&state=${pageUtil.t.state}">下一页</a>
               <a href="${pageContext.request.contextPath}/ProductListServlet?pageNum=${pageUtil.lastPage}&name=${pageUtil.t.name}&category=${pageUtil.t.category}&state=${pageUtil.t.state}">尾页</a>

               当前第${pageUtil.pageNum}/${pageUtil.lastPage}页，共${pageUtil.totalCount}条
               跳转到<input type="text" onchange="changePageNum(this.value,'${pageUtil.t.name}','${pageUtil.t.category}','${pageUtil.t.state}')" size="5" value="${pageUtil.pageNum}">页
           </td>
       </tr>
   </table>
</body>
</html>
