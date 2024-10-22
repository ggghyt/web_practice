let xhtp = new XMLHttpRequest();
xhtp.open("get", "memberJson.do");
xhtp.send();

let data = [];
xhtp.onload = function() {
	let obj = JSON.parse(xhtp.responseText);
	console.log(obj);
	data = obj;
	console.log("1", data)
	for (let i = 0; i < data.length; i++) {
		console.log(data[i])
	}
}
console.log("2", data)