svc.reply_list(205,
	function(result) {
		makelist(result)
	},
	function() {
		console.log(err)
	}
)

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