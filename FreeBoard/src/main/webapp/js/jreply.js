$.ajax("replyList.do?board_num=" + board_num + "&page=1").done(function(result) {
	result.forEach((item) => {
		$("<li />").append(
			$("<span />").addClass("col-sm-2").text(item.reply_num),
			$("<span />").addClass("col-sm-5").text(item.reply),
			$("<span />").addClass("col-sm-2").text(item.replyer),
			$("<span />").addClass("col-sm-2").append($("<button>delete</button>"))
		).appendTo($("div.content ul"));
	});
})
	.fail(function(err) {
		console.log(err)
	})

$("div.content ul").on("click", "button", function(e) {
	let reply_num = ($(e.target).parent().parent().find("span:eq(0)").text())
	$.ajax({
		url: "removeReply.do",
		data: { reply_num: reply_num },
		method: "get",
		dataType: "json"
	})
		.done(function(result) {
			if (result.retCode == "success") {
				$(e.target).parent().parent().remove();
			}
		})
		.fail(function(err) {
			console.log(err);
		})
});

$("#reply_button").on("click", function(e) {
	let reply = $("#reply").val();
	if (!reply || !login_id) {
		return
	}

	$.ajax({
		url: "addReply.do",
		data: { board_num: board_num, reply: reply, replyer: login_id },
		method: "post",
		dataType: "json"
	})
		.done(function(result) {
			if (result.retCode == "success") {
				let item = result.retVal;

				$("<li />").append(
					$("<span />").addClass("col-sm-2").text(item.reply_num),
					$("<span />").addClass("col-sm-5").text($(e.target).parent().find("input").val()),
					$("<span />").addClass("col-sm-2").text(login_id),
					$("<span />").addClass("col-sm-2").append($("<button>delete</button>"))
				).insertAfter($("div.content ul li:eq(0)"));


			}
		})
		.fail(function(err) {
			console.log(err)
		})
})