$(function(){
	
	var shopId = getQueryString('shopId');
	// 有 shopId 为编辑，无 shopId 为编辑
	var isEdit = shopId ? true : false;
	
	// 注册
	var initUrl = '/campu-shop/shopadmin/getshopinitinfo';
	var registerShopUrl = '/campu-shop/shopadmin/registershop';
	// 编辑
	var shopInfoUrl = '/campu-shop/shopadmin/getshopbyid?shopId=' + shopId;
	var editShopUrl = '/campu-shop/shopadmin/modifyshop';
	
	// 判断是注册还是编辑
	if(!isEdit){
		getShopInitInfo();
	}else{
		getShopInfo(shopId);
	}
	
	// 店铺编辑
	function getShopInfo(shopId){
		$.getJSON(shopInfoUrl, function(data){
			if(data.success){
				var shop = data.shop;
				$('#shop-name').val(shop.shopName);
				$('#shop-addr').val(shop.shopAddr);
				$('#shop-phone').val(shop.phone);
				$('#shop-desc').val(shop.shopDesc);
				var shopCategory = '<option data-id="' + shop.shopCategory.shopCategoryId + '"selected>' + shop.shopCategory.shopCategoryName + '</option>';
				var tempAreaHtml = '';
				data.areaList.map(function(item, index){
					tempAreaHtml += '<option data-id="' + item.areaId + '">' + item.areaName + '</option>';
				});
				$('#shop-category').html(shopCategory);
				// 不能修改
				$('#shop-category').attr('disabled', 'disabled');
				$('#area').html(tempAreaHtml);
				// 默认选择当前商铺的区域信息
				$("#area option[data-id='" + shop.area.areaId + "']").attr("selected", "selected");
			}
		});
	}
	
	// 店铺注册
	function getShopInitInfo(){
		// 获取商铺类别和区域的下拉信息
		$.getJSON(initUrl, function(data){
			if(data.success){
				var tempHtml = '';
				var tempAreaHtml = '';
				data.shopCategoryList.map(function(item, index){
					tempHtml += '<option data-id="' + item.shopCategoryId + '">' + item.shopCategoryName + '</option>';
				});
				data.areaList.map(function(item, index){
					tempAreaHtml += '<option data-id="' + item.areaId + '">' + item.areaName + '</option>';
				});
				$('#shop-category').html(tempHtml);
				$('#area').html(tempAreaHtml);
			}
		});
	}
	
	// 表单提交事件 
	$('#submit').click(function(){
		var shop = {};
		if(isEdit){
			shop.shopId = shopId;
		}
		shop.shopName = $('#shop-name').val();
		shop.shopAddr = $('#shop-addr').val();
		shop.phone = $('#shop-phone').val();
		shop.shopDesc = $('#shop-desc').val();
		shop.shopCategory = {
				shopCategoryId:$('#shop-category').find('option').not(function(){
					return !this.selected;
				}).data('id')
		};
		shop.area = {
				areaId:$('#area').find('option').not(function(){
					return !this.selected;
				}).data('id')
		};
		var shopImg = $('#shop-img')[0].files[0];
		var formData = new FormData();
		formData.append('shopImg', shopImg);
		formData.append('shopStr', JSON.stringify(shop));
		var verifyCodeActual = $('#j_captcha').val();
		if (!verifyCodeActual) {
			$.toast('请输入验证码!');
			return;
		}
		formData.append('verifyCodeActual', verifyCodeActual);
		// 提交表单
		$.ajax({
			url:(isEdit?editShopUrl:registerShopUrl),
			type:'POST',
			data:formData,
			contentType:false,
			processData:false,
			cache:false,
			success:function(data){
				if(data.success){
					$.toast('提交成功!');
				}else {
					$.toast('提交失败!' + data.errMsg);
				}
				$('#captcha_img').click();
			}
		});
	});
	
})