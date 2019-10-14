function getParam(key){
    // search 属性，可返回当前URL的查询部分（问号 ? 之后的部分）  eg：?module=1&moduleName=事前执法检查
    var url = window.location.search;

    // 正则筛选地址栏 eg：(^|&)"+ module +"=([^&]*)(&|$)   以module=或者&module=开始,接着跟着若干个出了&以外的东西，
    // 然后结尾或者跟着&，也就是匹配name=string、&name=string、name=string&、&name=string&这四种情况
    var reg = new RegExp("(^|&)"+ key +"=([^&]*)(&|$)");

    // 匹配目标参数，substr：从字符串第一个位置开始提取字符，剔除掉"?"，
    var result = url.substr(1).match(reg);

    //返回参数值  decodeURIComponent：对URL进行解码
    return result ? decodeURIComponent(result[2]) : null;
}

function resultShow() {
    document.getElementById("searchResult").innerHTML = '';
    // 用keywords来接收搜索框的输入
    var keyword = document.getElementById("searchInput").value;

    $.ajax({
        type: "POST",
        url:  "../law/findItemByKey",    // url [必需]:规定把请求发送到哪个URL上。
        data: {                          // data [可选]:映射或字符串值,规定连同请求发送到服务器的数据。
            module: module,
            keyword: keyword
        },
        dataType: "json",                //dataType [可选]:规定预期的服务器响应的数据类型。默认执行智能判断（xml、json、script 或 html）。
        // async: true,
        success: function (data) {       //success(data, textStatus, jqXHR)	[可选]:请求成功时执行的回调函数。
            if(data.msg == "error"){
                document.getElementById("searchResult").innerHTML = '' +
                    '<div class="weui-cell weui-cell_access">\n' +
                    '                <div class="weui-cell__bd weui-cell_primary">\n' +
                    '                    <p>无相关结果</p>\n' +
                    '                </div>\n' +
                    '            </div>'
            }else {
                var result = data.data;
                for(var i=0;i<result.length;i++){
                    var param = JSON.stringify({param:result[i]}).replace(/\"/g,"'");
                    $("#searchResult").append( '' +
                        '<div class="weui-cell weui-cell_access" onclick="loadhtml('+param+')">\n' +
                        '                <div class="weui-cell__bd weui-cell_primary">\n' +
                        '                    <p>'+result[i]+'</p>\n' +
                        '                </div>\n' +
                        '            </div>')
                }
            }
        }
    });
    // 输入为空，搜索返回为空
    document.getElementById("searchResult").style.display = "";
    if(keyword == ''){
        document.getElementById("searchResult").style.display = "none";
    }
}
function loadhtml(param) {
    var str = "";
    if(param.param.substring(0,2).indexOf("、") != -1){
        var split = param.param.split("、");
        str = split[1];
        if(split>2){
            for (var i = 2; i < split.length; i++) {
                str = str + "、" + split[i];
            }
        }
    }else {
        str = param.param
    }
    if(module == "3"){
        location.href = "../acceptPolice/photo?photoName="+str+"&module="+module;
    }else {
        location.href = "../acceptPolice/txt?txtName="+str+"&module="+module;
    }
}
function searchClear() {
    document.getElementById("searchInput").value = "";
    document.getElementById("searchResult").style.display = "none";
    document.getElementById("searchInput").focus();
}



