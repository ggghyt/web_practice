function modalShow(arg) {
	modalArg = arg;
	let body = document.querySelector("body");
	body.className = "modal-open";
	body.style.overflow = "hidden";
	body.style.paddingRight = "17px";

	let div = document.createElement("div");
	div.className = "modal-backdrop fade show";
	body.appendChild(div);

	let modal = document.querySelector("#exampleModal")
	modal.classList.add("show");
	modal.setAttribute("aria-modal", true);
	modal.setAttribute("role", "dialog");
	modal.removeAttribute("aria-hidden");
	modal.style.display = "block";

	console.log(modalArg)
	start.value = date_time_view(modalArg.start);
	end.value = date_time_view(modalArg.end);
}

function date_time(date) {
	let result = new Date(date);
	result = "" + date.getFullYear() + "-" + ('0' + (date.getMonth() + 1)).slice(-2) + "-" + ('0' + date.getDate()).slice(-2);
	result = result + "T" + ('0' + date.getHours()).slice(-2) + ":" + ('0' + date.getMinutes()).slice(-2) + ":" + ('0' + date.getSeconds()).slice(-2);

	return result;
}

function date_time_view(date) {
	let result = new Date(date);
	result = "" + date.getFullYear() + "-" + ('0' + (date.getMonth() + 1)).slice(-2) + "-" + ('0' + date.getDate()).slice(-2);
	result = result + "T" + ('0' + date.getHours()).slice(-2) + ":" + ('0' + date.getMinutes()).slice(-2);

	return result;
}

function modalClose() {
	let body = document.querySelector("body");
	body.removeAttribute("className");
	body.removeAttribute("style");

	let div = document.querySelector(".modal-backdrop.fade.show");
	div.remove();

	let modal = document.querySelector("#exampleModal")
	modal.classList.remove("show");
	modal.removeAttribute("aria-modal");
	modal.removeAttribute("role");
	modal.setAttribute("aria-hidden", true);
	modal.style.display = "none";
}

function modalSave() {
	console.log(modalArg);
	let title = document.querySelector("#title").value;
	if (title == "") {
		title = "unknown";
	}
	if (modalArg.allDay) {
		fetch("eventInsert.do?title=" + title + "&start=" + modalArg.startStr + "&end=" + modalArg.endStr)
			.then(resolve => resolve.json())
			.then(result => {
				console.log(result.retCode)
				if (result.retCode == "success") {
					(calendar.addEvent({
						title: title,
						start: modalArg.startStr,
						end: modalArg.endStr,
						allDay: modalArg.allDay
					}))
					modalClose();
				} else if (result.retCode == "something error") {
					console.log("error")
				}
			})
	} else {
		fetch("eventInsert.do?title=" + title + "&start=" + date_time(modalArg.start) + "&end=" + date_time(modalArg.end))
			.then(resolve => resolve.json())
			.then(result => {
				console.log(result.retCode)
				if (result.retCode == "success") {
					(calendar.addEvent({
						title: title,
						start: date_time(modalArg.start),
						end: date_time(modalArg.end),
						allDay: modalArg.allDay
					}))
					modalClose();
				} else if (result.retCode == "something error") {
					console.log("error")
				}
			})
	}	
}


window.onclick = function(event) {
	if (event.target == document.querySelector("#exampleModal")) {
		modalClose();
	}
}

function startChange(event) {
	start = new Date(event.target.value)
	end = new Date(modalArg.endStr)
	if (start < end) {
		console.log("good")
		modalArg.start = start
		modalArg.startStr = event.target.value;
	} else if (start > end) {
		console.log("bad")
		document.querySelector("#start").value = date_time_view(modalArg.start);
	}
}

function endChange(event) {
	start = new Date(modalArg.startStr)
	end = new Date(event.target.value)
	if (start < end) {
		console.log("good")
		modalArg.end = end
		modalArg.endStr = event.target.value;
	} else if (start > end) {
		console.log("bad")
		document.querySelector("#end").value = date_time_view(modalArg.end);
	}
}