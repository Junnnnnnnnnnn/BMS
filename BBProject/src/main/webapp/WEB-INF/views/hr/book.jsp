<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CoderBy</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/css/swiper.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/js/swiper.min.js"></script>



<script>
	
	
	function checkAmount(){
		var name= bookForm['breadName'].value;
		var amount=parseInt(bookForm['count'].value);
		var total;
		
		if(amount <= 0){
			alert("수량 입력 오류(0보다 큰수 입력 ㄱㄱ)")
			return ;
		}
		else{
			switch(name){
			case "소보로빵":
				if(${breadVO.get(0).getBREAD_AMOUNT()}-amount<0){
					alert(name+"부족합니다"+name+"의 남은 수량 : " + ${breadVO.get(0).getBREAD_AMOUNT()});
				}		
				else{
					total = ${breadVO.get(0).getBREAD_PRICE()} * amount;
					alert(name+" "+amount+"개 예약 되었습니다. 가격은:"+total+"입니다.");
				}
			break;
			case "단팥빵":
				if(${breadVO.get(1).getBREAD_AMOUNT()}-amount<0){
					alert(name+"부족합니다"+name+"의 남은 수량 : " + ${breadVO.get(1).getBREAD_AMOUNT()});
				}		
				else{
					total = ${breadVO.get(1).getBREAD_PRICE()} * amount;
					alert(name+" "+amount+"개 예약 되었습니다. 가격은:"+total+"입니다.");
				}
				break;
			case '크림빵':
				if(${breadVO.get(2).getBREAD_AMOUNT()}-amount<0){
					alert(name+"부족합니다"+name+"의 남은 수량 : " + ${breadVO.get(2).getBREAD_AMOUNT()});
				}		
				else{
					total = ${breadVO.get(2).getBREAD_PRICE()} * amount;
					alert(name+" "+amount+"개 예약 되었습니다. 가격은:"+total+"입니다.");
				}
				break;
			case '슈크림빵':
				if(${breadVO.get(3).getBREAD_AMOUNT()}-amount<0){
					alert(name+"부족합니다"+name+"의 남은 수량 : " + ${breadVO.get(3).getBREAD_AMOUNT()});
				}		
				else{
					total = ${breadVO.get(3).getBREAD_PRICE()} * amount;
					alert(name+" "+amount+"개 예약 되었습니다. 가격은:"+total+"입니다.");
				}
				break;
			case '소시지빵':
				if(${breadVO.get(4).getBREAD_AMOUNT()}-amount<0){
					alert(name+"부족합니다"+name+"의 남은 수량 : " + ${breadVO.get(4).getBREAD_AMOUNT()});
				}		
				else{
					total = ${breadVO.get(4).getBREAD_PRICE()} * amount;
					alert(name+" "+amount+"개 예약 되었습니다. 가격은:"+total+"입니다.");
				}
				break;
			default:
				alert("아무것도 안되었다.");
			break;
			}
		}
	}
</script>
<style type="text/css">
#goToleft {
	float: left;
	width: 600px;
	height: 600px;
}

.swiper-container {
	width: 65%;
	height: 65%;
	float: left;
	margin-left:20px;
	margin-top:20px;
}

.swiper-slide {
	text-align: center;
	display: flex; /* 내용을 중앙정렬 하기위해 flex 사용 */
	align-items: left; /* 위아래 기준 중앙정렬 */
	justify-content: left; /* 좌우 기준 중앙정렬 */
	width: 100%;
	height: 100%;
}

#cStyle {
	top: 50%;
	height: 100px;
	margin-top: 10%;
	float: right;
	margin-right:10%;
}
hr{
	border-color: saddlebrown;
	border:1;
}
body{
	background-color: #e7dfd8;
}

</style>
</head>
<body>
	<p style="text-align: center; font-size: 80pt; padding: 0; margin: 0;">MENU</p>
	<hr>
	<div class="swiper-container">
		<div class="swiper-wrapper">
			<div class="swiper-slide">
				<img src="./images/masterPic3.jpg" width="600px" height="600px">
			</div>
			<div class="swiper-slide">
				<img src="./images/masterPic4.png" width="600px" height="600px">
			</div>
			<div class="swiper-slide">
				<img src="./images/masterPic.jpg" width="600px" height="600px">
			</div>
			<div class="swiper-slide">
				<img src="./images/masterPic2.png" width="600px" height="600px">
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
			speed : 8000, // 슬라이드 속도 2초
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
	<c:url var="bookAction" value='/hr/bakeryBook' />
	<form method="POST" action="${bookAction}" name="bookForm" id="cStyle">
	<h1>예약하기</h1>
		전화번호 입력<input class="form-control" type="text" name="num" id="num"
			style="width: 150px;"><br> 빵 선택
			<select class="form-control" style="width: 150px;" name="breadName" id="breadName"">
			<option value="소보로빵">소보로빵
			<option value="단팥빵">단팥빵
			<option value="크림빵">크림빵
			<option value="슈크림빵">슈크림빵
			<option value="소시지빵">소시지빵
		</select> 
		<br>
		수량입력
		<input style="width: 150px;" class="form-control" type=text
			id="count" name="count" value="" placeholder="빵 수량 입력"> 
			<br>
			<input style="width: 150px;" class="form-control" type="submit" onclick="checkAmount()" value="예 약">
	</form>
	<hr>

</body>
</html>