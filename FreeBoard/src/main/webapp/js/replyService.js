const svc = {
	reply_list(board_num = 1, successFnc, errorFnc) {
		fetch("replyList.do?board_num=" + board_num)
			.then(resolve => resolve.json())
			.then(successFnc)
			.catch(errorFnc)
	}
}