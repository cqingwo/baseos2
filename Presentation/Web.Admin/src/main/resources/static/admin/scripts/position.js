


//绑定部门列表
function bindDepartMentList(departMentSelectObj,positionSelectObj,id) {
    $.get("/oadmin/tool/departmentlist?id=" + id, function (data) {
        var departMentList = eval("(" + data + ")");
        if (departMentList.length > 0) {
            var optionStr = "<option value='-1'>请选择部门</option>";
            var optionStr2 = "<option value='-1'>请选择职位</option>";
            for (var i = 0; i < departMentList.length; i++) {
                optionStr = optionStr + "<option value='" + departMentList[i].id + "'>" + departMentList[i].name + "</option>";
            }
            departMentSelectObj.html(optionStr);
			
            positionSelectObj.html(optionStr2);
			
        } else {
            alert("加载部门列表时出错！");
        }
    });
}

//绑定部门列表
function bindPositionList(positionSelectObj,id) {
    $.get("/oadmin/tool/positionlist?id=" + id, function (data) {
        var positionList = eval("(" + data + ")");
        if (positionList.length > 0) {
            var optionStr = "<option value='-1'>请选择职位</option>";
            for (var i = 0; i < positionList.length; i++) {
                optionStr = optionStr + "<option value='" + positionList[i].id + "'>" + positionList[i].name + "</option>";
            }
            positionSelectObj.html(optionStr);
			
        } else {
            alert("加载职位列表时出错！");
        }
    });
}


$(function(){
	
	$("#ComId").change(function(){
		var id = $(this).val();
		if(id<=0) return;
		var departMentSelectObj = $("#DepartMentId");
		var positionSelectObj = $("#PositionId");			
		bindDepartMentList(departMentSelectObj,positionSelectObj,id);
	});
	
	$("#DepartMentId").change(function(){
		var id = $(this).val();
		if(id<=0) return;
		var positionSelectObj = $("#PositionId");		
		bindPositionList(positionSelectObj,id);
	});
	
})

