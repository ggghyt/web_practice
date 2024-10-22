fetch("memberJson.do")
	.then(function(resolve) {
		return resolve.json()
	})
	.then(function(result) {
		console.log(result)
		makelist(result);
	})
	.catch(function(err) {
		console.log(err)
	})

function makelist(obj = []) {
	for (let i = 0; i < obj.length; i++) {
		let tr = makerow(obj[i])
		document.querySelector("#show tbody").appendChild(tr)
	}
}

function makerow(obj = {}) {
	let fields = ["member_id", "member_name", "phone", "responsibility"]
	let tr = document.createElement("tr")
	tr.setAttribute("data-id", obj.member_id)
	tr.addEventListener("mouseover", function(e) {
		tr.style.backgroundColor = "blue"
	});
	tr.addEventListener("mouseout", function(e) {
		tr.style.backgroundColor = "skyblue"
	});
	for (let j = 0; j < fields.length; j++) {
		let td = document.createElement("td")
		td.innerText = obj[fields[j]]
		tr.appendChild(td)
	}
	td = document.createElement("td")
	btn = document.createElement("button")
	btn.innerText = "delete"
	btn.addEventListener("click", delete_row)
	td.appendChild(btn)
	tr.appendChild(td)

	return tr;
}

function delete_row(e) {
		//console.dir(e.target.parentElement.parentElement.firstElementChild.innerText)
		//console.dir(e.target.parentElement.parentElement.dataset.id)
		let id = e.target.parentElement.parentElement.dataset.id
		fetch("removeMemberJson.do?id=" + id)
		.then(resolve => resolve.json())
		.then(result => {
			console.log(result)
			if (result.retCode == "success") {
				e.target.parentElement.parentElement.remove();
			} else if (result.retCode == "something error") {
			}
		})
		.catch(err => console.log(err))
	}

document.querySelector("#save_btn").addEventListener("click", function(e) {
	let member_id = document.querySelector("#member_id").value
	let password = document.querySelector("#password").value
	let member_name = document.querySelector("#member_name").value
	let phone = document.querySelector("#phone").value

	fetch("addMemberJson.do?member_id=" + member_id + "&password=" + password + "&member_name=" + member_name + "&phone=" + phone)
		.then(resolve => resolve.json())
		.then(result => {
			if (result.retCode == "success") {
				let tr = makerow({ member_id: member_id, member_name: member_name, phone: phone, responsibility: "User" });
				document.querySelector("#show tbody").appendChild(tr)
			} else if (result.retCode == "something error") {
			}
		})
		.catch(err => { console.log(err) })
})

/*
	<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>name</th>
				<th>phone</th>
				<th>group</th>
				<th>delete</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>

	<table class="table">
		<tr>
			<th>ID</th><td><input type="text" id="member_id"></td>
		</tr>
		<tr>
			<th>PW</th><td><input type="password" id="password"></td>
		</tr>
		<tr>
			<th>name</th><td><input type="text" id="member_name"></td>
		</tr>
		<tr>
			<th>phone</th><td><input type="text" id="phone"></td>
		</tr>
		<tr>
			<th></th>
			<td><button id="save_btn" class="btn btn-primary">save</button></td>
		</tr>
	</table>
*/