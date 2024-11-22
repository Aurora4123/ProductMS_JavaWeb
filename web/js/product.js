
function changePageNum(pageNum,name,category,state) {
    // alert(pageNum)
    // alert(name)
    // alert(category)
    // alert(state)
    params = ""
    if(name.length!=0 && name.trim() != ""){
        params += "&name="+name
    }
    if(category.length!=0 && category.trim() != ""){
        params += "&category="+category
    }
    if(state.length!=0 && state.trim() != ""){
        params += "&state="+state
    }
    // alert(params)
    //通过js提交数据
    window.location.href="ProductListServlet?pageNum="+pageNum+params
}
