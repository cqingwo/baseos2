/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

var provinceId = 500000; //省id
var cityId = 500100; //市id
var countyId = 500107; //县或区id

document.write("<script src=\"/static/admin/scripts/getprovincelist.js\" type=\"text/javascript\"><\/script>");

//绑定省列表
function bindProvinceList(provinceSelectObj, selectProvinceId) {

    var provinceList = getprovincelist;

    if (provinceList.length > 0) {
        var optionStr = "<option value='-1'>请选择</option>";
        for (var i = 0; i < provinceList.length; i++) {
            optionStr = optionStr + "<option value='" + provinceList[i].regionId + "'>" + provinceList[i].name + "</option>";
        }
        provinceSelectObj.html(optionStr);
        if (selectProvinceId == undefined)
            selectProvinceId = -1;
        provinceSelectObj.find("option[value=" + selectProvinceId + "]").prop("selected", true);
    } else {
        alert("加载省列表时出错！");
    }
}
//绑定市列表
function bindCityList(provinceId, citySelectObj, selectCityId) {
    $.get("/admin/tool/getcitylist.do?provinceId=" + provinceId, function (data) {


        var data = eval("(" + data + ")");


        var cityList = data.content;
        var message = data.message;
        var state = data.state;

        if (state != 1) {
            alert("加载市列表时出错！");
        }


        if (cityList.length > 0) {
            var optionStr = "<option value='-1'>请选择</option>";
            for (var i = 0; i < cityList.length; i++) {
                optionStr = optionStr + "<option value='" + cityList[i].regionId + "'>" + cityList[i].name + "</option>";
            }
            citySelectObj.html(optionStr);
            if (selectCityId == undefined)
                selectCityId = -1;
            citySelectObj.find("option[value=" + selectCityId + "]").prop("selected", true);
        } else {
            alert("加载市列表时出错！");
        }
    });
}

//绑定县或区列表
function bindCountyList(cityId, countySelectObj, selectCountyId) {


    $.get("/admin/tool/getcountylist.do?cityId=" + cityId, function (data) {

        var data = eval("(" + data + ")");


        var countyList = data.content;
        var message = data.message;
        var state = data.state;

        if (state != 1) {
            alert("加载县或区列表时出错！");
        }


        if (countyList.length > 0) {
            var optionStr = "<option value='-1'>请选择</option>";
            for (var i = 0; i < countyList.length; i++) {
                optionStr = optionStr + "<option value='" + countyList[i].regionId + "'>" + countyList[i].name + "</option>";
            }
            countySelectObj.html(optionStr);
            if (selectCountyId == undefined)
                selectCountyId = -1;
            countySelectObj.find("option[value=" + selectCountyId + "]").prop("selected", true);
        } else {
            alert("加载县或区列表时出错！");
        }
    });
}

$(function () {
    //绑定省列表的改变事件
    $("#provinceSelect").change(function () {
        var selectedProvinceSelect = $(this);
        var selectedProvinceId = selectedProvinceSelect.find('option:selected').val();

        console.log(selectedProvinceId);

        if (selectedProvinceId > 0) {
            selectedProvinceSelect.parent().find(".countySelect").html("<option value='-1'>请选择</option>")
            bindCityList(selectedProvinceId, selectedProvinceSelect.parent().find(".citySelect"));
        }

    })


    //绑定市列表的改变事件
    $("#citySelect").change(function () {
        var selectedCitySelect = $(this);
        var selectedCityId = selectedCitySelect.find('option:selected').val();
        if (selectedCityId > 0) {
            bindCountyList(selectedCityId, selectedCitySelect.parent().find(".countySelect"));
        }
    })

    //绑定省列表
    bindProvinceList($("#provinceSelect"), provinceId);

    if (cityId > 0) {
        bindCityList(provinceId, $("#provinceSelect").parent().find(".citySelect"), cityId);
        bindCountyList(cityId, $("#citySelect").parent().find(".countySelect"), countyId);
    }
});