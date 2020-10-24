;(function () {
	$(function () {
		var questions = [];
		var idx = 0;
		function getHelpList() {
			var data = {
			  "data": {},
			  "pageNo": 0,
			  "pageSize": 100
			};
			ajaxHengyun({
	            type: 'POST',
	            data: JSON.stringify(data),
	            contentType: 'application/json',
	            url: _GATE_URL + '/api/mt/help/page',
	            success:function (res) {
	                var html = [];
	                questions = res.data.list;
	                for (var i = 0; i < questions.length; i++) {
	                	html.push('<div class="list">'+questions[i].title+'</div>');
	                }
	                $('.list-container').html(html.join(''));
	            },
	            error: function(err) {
	                console.log(err);
	            }
	        });
		}

		function bindEvent() {
			$('.list-container').on('click', '.list', function () {
				idx = $(this).index();
				window.location.hash = '#detail';
			});

			$(window).on('hashchange', function () {
				var hash = window.location.hash;
				if (hash == '#detail') {
					$('.list-container').hide();
					$('.detail').text(questions[idx].content).show();
				} else {
					$('.detail').hide();
					$('.list-container').show();
				}
			});
		}

		getHelpList();
		bindEvent();
	});
})();