fetch("js/MOCK_DATA.json")
	.then(function(resolve) {
	console.log(resolve)
		return resolve.json()
	})
	.then(function(result) {
		console.log(result)
		makelist(result)
	})
//obj = JSON.parse(data)
//console.log(obj)

function makelist(obj = []) {
	let fields = ["id", "first_name", "last_name", "email", "salary"]
	for (let i = 0 ; i < obj.length ; i++) {
		let tr = document.createElement("tr")
		tr.addEventListener("mouseover", function(e) {
			tr.style.backgroundColor = "blue"
		});
		tr.addEventListener("mouseout", function(e) {
			tr.style.backgroundColor = "skyblue"
		});
		for (let j = 0 ; j < fields.length ; j++) {
			let td = document.createElement("td")
			td.innerText = obj[i][fields[j]]
			tr.appendChild(td)
		}
		td = document.createElement("td")
		btn = document.createElement("button")
		btn.innerText = "delete"
		btn.addEventListener("click", function(e) {
			//btn.parentElement.parentElement.remove();
			tr.remove();
		})
		td.appendChild(btn)
		tr.appendChild(td)
		document.querySelector("#show tbody").appendChild(tr)
	}
}
//makelist()
/*
	<table class="table">
		<tr>
			<th>ID</th>
			<th>first name</th>
			<th>last name</th>
			<th>email</th>
			<th>salary</th>
			<th>delete</th>
		</tr>
		<tbody>
		
		</tbody>
	</table>
*/
