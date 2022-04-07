$(function(){
	$(".nn-share-send").click(function(){
		var data = {
				id: id,
				
				sender: $("#send-dialog #sender").val(),// ô iput có id= sender ở trong  Ô #sen-dialog
				receiver: $("#send-dialog #receiver").val(),
				subject: $("#send-dialog #subject").val(),
				content: $("#send-dialog #content").val()
		}
		$("#loading").show();// Mở hộp thoại
		$.ajax({
			url: `/product/share/${id}`,
			data: data,
			method: 'post',
			success: function(resp){
				$("#loading").hide();
				$("#send-dialog").modal('hide');
			}
		})
	})
	
	$(".nn-share-open").click(function(){
		id = $(this).parents("[data-item]").attr("data-item");
		$("#send-dialog").modal('show');
	})
	
	// Đánh dấu yêu thích
	// .nn-favo-add là nút trái tim
	
	$(".nn-favo-add").click(function(){
		// lấy id từ 
		var id = $(this).parents("[data-item]").attr("data-item");
		
		$.ajax({
			url: `/product/like/${id}`,
			success: function(resp){
				$("#favos").html(resp);
			}
		})
	})
})