var storeId = 0; //店铺id

var categorySelectLayerHtml = "<div class='selectBoxProgressBar'><p><textarea id='message' class='message'></textarea></p></div>";
var showLayerHtml = "<div class='tip' id='showLayerHtml'><p></p></div>";


function ajaxReturnedBankRoll(id) {
	$.jBox('html:categorySelectLayerHtml', {
		title:'提现失败描述',
		
		bottomText: '请认真填写提现失败原因!',		
    	buttons: { '提交': true },
		submit:function(){
			message = $("#message").val();
			$.get("/oadmin/bank/returned?t=" + new Date(),
				{
					'id':id,
					'message':message
				},function (data) {
				 var result = eval("(" + data + ")");
				  if (result.state == "success") {
					  $("#operation"+id).html('');            				
					  alert("提现失败处理成功");
    			  }
				  else {				
					  alert(result.content);
				  }
							
			});
		}
	});
	
    $.jBox.setContent(categorySelectLayerHtml);
	
}

function ajaxLockedBankRoll(id) {
	$.jBox('html:categorySelectLayerHtml', {
		title:'提现冻结描述',
		
		bottomText: '请认真填写冻结原因!',		
    	buttons: { '提交': true },
		submit:function(){
			message = $("#message").val();
			$.get("/oadmin/bank/locked?t=" + new Date(),
				{
					'id':id,
					'message':message
				},function (data) {
				 var result = eval("(" + data + ")");
				  if (result.state == "success") {
					  $("#operation"+id).html('<a class="editOperate"  href="javascript:void(0)" onclick="ajaxCancelledBankRoll(' + id + ')">[取消]</a>');     				
					  alert("提现冻结处理成功");
    			  }
				  else {
					  alert(result.content);
				  }
							
			});
		}
	});  
	
    $.jBox.setContent(categorySelectLayerHtml);
}

function ajaxCancelledBankRoll(id) {
	$.jBox('html:categorySelectLayerHtml', {
		title:'提现取消描述',
		
		bottomText: '请认真填写取消原因!',		
    	buttons: { '提交': true },
		submit:function(){
			message = $("#message").val();
			$.get("/oadmin/bank/cancelled?t=" + new Date(),
				{
					'id':id,
					'message':message
				},function (data) {
				 var result = eval("(" + data + ")");
				  if (result.state == "success") {    
					  $("#operation"+id).html('');    				
					  alert("提现取消处理成功");
    			  }
				  else {
					  alert(result.content);
				  }
							
			});
		}
	});  
	
    $.jBox.setContent(categorySelectLayerHtml);
}

function showMessage(content){
	$.jBox('html:showLayerHtml', {
	title:'详细流水',		
	bottomText: '详细流水!',		
	buttons: { '关闭': true }
	});
	
    $.jBox.setContent(showLayerHtml);
	$("#showLayerHtml p").html(decodeURI(content));
	
}