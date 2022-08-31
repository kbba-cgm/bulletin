$(document).ready(function() {
	const default_preview_photo = 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSrgTTV3ncyk_ArHQftXJkKB4Jek24P9_sf4T7KQq_XKmVd50PGgwqaFVZJheRJSZCQ-fk&usqp=CAU';
	
	$(".form-select2").select2({
		placeholder: "Select category"
	});
	
	if($("#oldImageData").val()) $("#remove_photo").removeClass("d-none");
	
	const setImageDataValue = fileLists => {
		const reader = new FileReader();
		reader.onload = (e) => $("#imageData").val(e.target.result);
	    reader.readAsDataURL(fileLists[0]);
	}
	
	const showThumbnail = fileLists => {
		const reader = new FileReader();
	    reader.onload = (e) => $("#profile-preview-photo").attr("src", e.target.result);
	    reader.readAsDataURL(fileLists[0]);
	}
	
	const cleanImageData = () => {
		$("#fileUpload").val('');
		$("#profile-preview-photo").attr("src", default_preview_photo);
		$("#imageData").val('');
		// if($('#oldImageData')) $('#oldImageData').val('');
		$("#remove_photo").addClass("d-none");
	}
	
	$("#fileUpload").on("change", function(){
		if(!this.files || !this.files[0]) {
			cleanImageData();
			return false;
		}else if (!this.files[0].type.startsWith('image/')) {
			cleanImageData();
			$("#profile-photo-type-error").text("File type must be image.");
			return false;		
		}
		
		setImageDataValue(this.files);
		showThumbnail(this.files);
		$("#remove_photo").removeClass("d-none");
		// if($('#oldImageData')) $('#oldImageData').val('');
		$("#profile-photo-type-error").text("");
	})
	
	$("#remove_photo").on("click", function() {
		cleanImageData();
	});
})

