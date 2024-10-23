const svc = {
	reply_list(param ={board_num, page}, successFnc, errorFnc) {
		fetch("replyList.do?board_num=" + param.board_num +"&page=" + param.page)
			.then(resolve => resolve.json())
			.then(successFnc)
			.catch(errorFnc)
	},
	
	remove_reply(reply_num = 1, successFnc, errorFnc) {
		fetch("removeReply.do?reply_num=" + reply_num)
			.then(resolve => resolve.json())
			.then(successFnc)
			.catch(errorFnc)
	},
	
	add_reply(param = {board_num, reply, replyer}, successFnc, errorFnc) {
		fetch("addReply.do?board_num=" + param.board_num + "&reply=" + param.reply + "&replyer=" + param.replyer)
			.then(resolve => resolve.json())
			.then(successFnc)
			.catch(errorFnc)
	}, 
	
	getReplyCount(board_num = 1, successFnc, errorFnc) {
		fetch("replyCount.do?board_num=" + board_num)
			.then(resolve => resolve.json())
			.then(successFnc)
			.catch(errorFnc)
	}
}