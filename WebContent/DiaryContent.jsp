<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>日記内容</title>
			<script type="text/javascript">
			
			function posting(){
				
				var posted = confirm('投稿しますか？');
				
				if(posted){
					
					window.alert('投稿しました');
					
					
				}else{
					
					window.alert('キャンセルしました');
					
				}
					
			}
		</script>
			<script type="text/javascript">
				function deletion(){
					
					var deleted = confirm('削除しますか？');
					
					if(deleted){
						
						window.alert('削除しました');
						
					}else{
						
						window.alert('キャンセルしました');
						
					}
						
				}
			</script>
	</head>

	<body>
		<form action="DiaryContent" method="post">
		日付:<input type="date" name="diary_date" >
		題名:<input type="text" name="diary_title" id="title">
		<br>
		内容<textarea rows="20" cols="50" id="diary_content" name="diary_content"></textarea>
		<button type="submit" name="posted" id="diary_post"  onclick="posting()">投稿</button>
		<button type="submit" name="deleted" id="diary_delete" onclick="deletion()">削除</button>
		<br>
		<button type="submit" name="back" onclick="Mypage.jsp">戻る</button>
		</form>
	</body>
</html>