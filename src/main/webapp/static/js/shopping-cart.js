$(function(){
	function show_cart_info(info){
		$(".cart-cnt").html(info.count);
		$(".cart-amt").html(Math.round(info.amount * 100) / 100);
	}
	// initializing
	$.ajax({
		url: `/cart/info`,
		success: function(resp){
			show_cart_info(resp);
		}
	})
	
	$(".nn-cart-add").click(function(){
		var id = $(this).parents("[data-item]").attr("data-item");
		$.ajax({
			url: `/cart/add/${id}`,
			success: function(resp){
				show_cart_info(resp);
			}
		});
		
		
		
		
		
		
		
		// Hiệu ứng giỏ hàng
		// tìm ảnh khung cha <class = nn-prod>  --> tìm ảnh <img class = panel-body img>
		var img = $(this).parents(".nn-prod").find(".panel-body img");
		//alert(img.attr("src"));
		
		// thay hình ảnh lúc bay vô giỏ hàng -- bên file _aside-cart.jsp
		var effect_css = `
			.cart-effect{
				background-image: url("${img.attr("src")}");
				background-size: 100% 100%;
			}`;
		$("#cart-effect").html(effect_css);  // bỏ chuỗi effect_css chứa hình ảnh của sp
		// bỏ vào thẻ có id = cart-effect
		var options = {
				to:".nn-cart-icon",
				className: "cart-effect"
		}// hiệu ứng, 1000 mili giây
		img.effect("transfer", options, 2000);
	});
	
	
	
	
	
	$(".nn-cart-remove").click(function(){
		var item = JSON.parse($(this).parents("[data-item]").attr("data-item"));
		$.ajax({
			url: `/cart/remove/${item.id}`,// bên trong item.id và item.price đã định nghĩa bên cartview
			success: function(resp){
				show_cart_info(resp);
			}
		});
		$(this).parents("[data-item]").hide(500); // ẩn dòng sau khi bị xóa xóa trong vòn g500 mili igây
	});
	
	$(".nn-cart-change").on("input", function(){
		var item = JSON.parse($(this).parents("[data-item]").attr("data-item"));
		var qty = $(this).val();
		$.ajax({
			url: `/cart/update/${item.id}/${qty}`,
			success: function(resp){
				show_cart_info(resp);
			}
		});
		var amt = Math.round(100 * qty * item.price * (1 - item.disc)) / 100;
		$(this).parents("[data-item]").find(".nn-item-amt").html("$" + amt);
	});
	
	$(".nn-cart-clear").on("click", function(){
		$.ajax({
			url: `/cart/clear`,
			success: function(resp){
				show_cart_info(resp);
				$("tbody.nn-cart-items").empty(); // xóa toàn bộ thẻ <tr> bên trong <tbody>
			}
		});
	});
})