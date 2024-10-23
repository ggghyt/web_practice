page = 1;
showList()
document.querySelector("#reply_button").addEventListener("click", addReplyHanderFnc);


function addReplyHanderFnc(e) {
	let reply = document.querySelector("#reply").value;
	if (!reply || !login_id) {
		alert("not access");
		return;
	}
	document.querySelector("#reply").value = "";
	svc.add_reply({ board_num, reply, replyer: login_id },
		result => {
			if (result.retCode == "success") {
				let template = makeLi(result.retVal);
				document.querySelector(".container_reply ul li").after(template);
				showList()
			} else if (result.retCode == "something error") {
				alert("something error");
			} else {
				alert("big error");
			}
		},
		err => {
			console.log(err);
		})
}

function linkMove() {
	document.querySelectorAll("nav ul.pagination a").forEach(function(aTag) {
		aTag.addEventListener("click", function(e) {
			e.preventDefault()
			page = aTag.dataset.page;
			showList()
			svc.getReplyCount(board_num, createPageList, err => console.log(err));
		})
	})
}

function showList() {
	document.querySelectorAll(".container_reply .content li").forEach((li, index) => {
		console.log()
		if (index > 0) {
			li.remove()
		}
	})
	svc.reply_list({ board_num, page },
		function(result) {
			console.log(result)
			for (let i = 0; i < result.length; i++) {
				let template = makeLi(result[i]);
				document.querySelector(".container_reply ul").appendChild(template);
				page = 1;
			}
		},
		function(err) {
			console.log(err);
		}
	)
}

svc.getReplyCount(board_num, createPageList, err => console.log(err));

function createPageList(result) {
	let totalCnt = result.totalCount;
	let startPage, endPage, realEnd;
	let prev, next;

	endPage = Math.ceil(page / 5) * 5;
	startPage = endPage - 4;
	realEnd = Math.ceil(totalCnt / 5)
	endPage = endPage > realEnd ? realEnd : endPage;

	prev = startPage > 1;
	next = endPage < realEnd;
	//<li class="page-item"><a class="page-link" href="#">1</a></li>
	list = "";
	list = list + '<li class="page-item">';
	if (prev) {
		list = list + '<a class="page-link" href="#" aria-label="Previous" data-page="' + (startPage - 1) + '">&laquo;</a>';
	} else{ 
		list = list + '<span class="page-link disabled" aria-hidden="true">&laquo;</span>';
	}
	list += '</li>';
	for (let p = startPage; p <= endPage; p++) {
		list = list + '<li class="page-item"><a class="page-link" href="#" data-page="' + p + '">' + p + '</a></li>'
	}
	list = list + '<li class="page-item">'
	if (next) {
		list = list + '<a class="page-link" href="#" aria-label="Next" data-page="' + (endPage + 1) + '">&raquo;</a>';
	} else {
		list = list + '<span class="page-link disabled" aria-hidden="true">&raquo;</span>';
	}
	list += '</a></li>';

	document.querySelector('nav ul.pagination').innerHTML = list;
	
	linkMove()
}

function makeLi(reply_vo = { reply_num, reply, replyer }) {
	let template = document.querySelector(".container_reply ul li").cloneNode(true);
	template.querySelector("span:nth-of-type(1)").innerText = reply_vo.reply_num;
	template.querySelector("span:nth-of-type(2)").innerText = reply_vo.reply;
	template.querySelector("span:nth-of-type(3)").innerText = reply_vo.replyer;
	template.querySelector("span:nth-of-type(4)").innerHTML = "<button onClick=\"delete_row(event)\">delete</button>";

	return template;
}
function delete_row(e) {
	let reply_num = e.target.parentElement.parentElement.firstElementChild.innerText;
	svc.remove_reply(reply_num,
		result => {
			if (result.retCode == "success") {
				alert("success");
				e.target.parentElement.parentElement.remove();
				page = 1;
				showList()
				svc.getReplyCount(board_num, createPageList, err => console.log(err));
			} else if (result.retCode == "something error") {
				alert("something error");
			} else {
				alert("big error");
			}
		},
		err => { })
}

function makelist(obj = []) {
	let fields = ["reply_num", "reply", "replyer"]
	for (let i = 0; i < obj.length; i++) {
		let tr = document.createElement("tr")
		for (let j = 0; j < fields.length; j++) {
			let td = document.createElement("td")
			td.innerText = obj[i][fields[j]]
			tr.appendChild(td)
		}
		document.querySelector("#replyList tbody").appendChild(tr)
	}
}

/*
<table id="replyList" class="table">
	<thead>
		<tr>
			<th>댓글 번호</th>
			<th>내용</th>
			<th>작성자</th>
		</tr>
	</thead>
	<tbody>
	
	</tbody>
</table>
*/