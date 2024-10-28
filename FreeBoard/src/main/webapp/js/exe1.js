document.querySelector("#delBtn").addEventListener("click", delete_txt)

function delete_txt() {
	str = document.querySelector("#userValue").value;
	del_span = document.querySelectorAll("span");
	for (let i = 0 ; i < del_span.length ; i++) {
		if (del_span[i].innerText == str) {
			del_span[i].remove();
		}
	}
	document.querySelector("#userValue").value = "";
}