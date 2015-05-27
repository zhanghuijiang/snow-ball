function getView(url,page,titleid) {

	return getJSON(url,page).done(
			
			function(data) {

				$('#page-titles').html($('#' + titleid).html());
				
				$('#page-content').empty();
				
				$.each(data.list, function(index,obj) {
					var name = obj.truename;
					if(name == '' || name == null)
						name = obj.nickname;
					if('titles-01' == titleid || 'titles-02' == titleid){
                    	$('#page-content').append('<tr><td>' +name+ '</td><td>' + obj.ids + '</td><td>'+ obj.createtime + '</td></tr>');
					}
                    if('titles-03' == titleid || 'titles-04' == titleid){
                    	var content = obj.content;
                    	var str = content.replace(/<[^>].*?>/g,"");     
                    	$('#page-content').append('<tr><td>' + name + '</td><td>' + obj.ids + '</td><td>'+ obj.createtime + '</td><td>'+obj.total+'</td><td style="width:50%">'+str+'</td></tr>');
					}
				});
				
				if(!data.totalPages){
					return;
				}
				
				$('#pagination-footer').twbsPagination({
					first : '首页',
					prev : '前一页',
					next : '下一页',
					last : '尾页',
					totalPages : data.totalPages,
					visiblePages : 5,
					startPage : data.page,
					onPageClick : function(event, page) {
						getView(url,page,titleid);
					}
				});
				
				$('.table-responsive').show();
				
			});
}
