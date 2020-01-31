<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CoderBy</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/css/swiper.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/js/swiper.min.js"></script>


</head>


<style>
body, html {
	width: 100%;
	height: 100%;
	padding: 0;
	margin: 0;
}

.swiper-container {
	width: 100%;
	height: 100%;
}

.swiper-slide {
	text-align: center;
	display: flex; /* 내용을 중앙정렬 하기위해 flex 사용 */
	align-items: center; /* 위아래 기준 중앙정렬 */
	justify-content: center; /* 좌우 기준 중앙정렬 */
	width: 100%;
	height: 100%;
	
}
</style>
<body>
	<div class="swiper-container">
		<div class="swiper-wrapper">
			<div class="swiper-slide">
				<img src="./images/masterPic3.jpg" width="100%" height="100%">
			</div>
			<div class="swiper-slide">
				<img src="./images/masterPic4.png" width="100%" height="100%">
			</div>
			<div class="swiper-slide">
				<img src="./images/masterPic.jpg" width="100%" height="100%">
			</div>
			<div class="swiper-slide">
				<img src="./images/masterPic2.png" width="100%" height="100%">
			</div>



		</div>

		<!-- 네비게이션 버튼 -->
		<div class="swiper-button-next"></div>
		<!-- 다음 버튼 (오른쪽에 있는 버튼) -->
		<div class="swiper-button-prev"></div>
		<!-- 이전 버튼 -->

		<!-- 페이징 -->
		<div class="swiper-pagination"></div>
	</div>
	<script>
		new Swiper('.swiper-container', {

			loop : true, // 슬라이드 반복

			autoplay : { // 자동 재생
				delay : 0, // 딜레이 0
			},
			speed : 4000, // 슬라이드 속도 2초
			pagination : { // 페이징 설정
				el : '.swiper-pagination',
				clickable : true, // 페이징을 클릭하면 해당 영역으로 이동, 필요시 지정해 줘야 기능 작동
			},
			navigation : { // 네비게이션 설정
				nextEl : '.swiper-button-next', // 다음 버튼 클래스명
				prevEl : '.swiper-button-prev', // 이번 버튼 클래스명
			},
		});
	</script>

</body>
</html>

