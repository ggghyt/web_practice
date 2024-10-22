console.log("basic.js")

let name = "some name"
let age = 20;
let obj = {name : "some name", 
           age : 20, 
           showInfo : function() {
			   return this.name + ", " + this.age
		   }}
           
console.log(obj.name)
console.log(obj['age'])
console.log(obj.showInfo())


let li = document.createElement("li")
li.innerText = 'Do nothing'

let ul = document.querySelector('#show ul')
ul.appendChild(li)

document.querySelectorAll('#show ul li').forEach(function(fruit) {
	fruit.style.color = 'blue'
	fruit.addEventListener('click', function(e) {
		fruit.remove();
	})
	console.log(fruit.innerHTML)
})

let tr = document.createElement("tr")
let th = document.createElement("th")
let td = document.createElement("td")
th.innerText = "name"
td.innerText = "nothing"
tr.appendChild(th)
tr.appendChild(td)
document.querySelector("#tbody1").appendChild(tr)



let data = [obj]
data.push({name : "1st", age : 11})
data.push({name : "2ed", age : 22})
data.push({name : "3rd", age : 33})


data.forEach(function(num) {
	let tr1 = document.createElement("tr")
	let th1 = document.createElement("th")
	let th2 = document.createElement("th")
	th1.innerText = num.name
	th2.innerText = num.age
	tr1.appendChild(th1)
	tr1.appendChild(th2)
	document.querySelector("#tbody2").appendChild(tr1)
})

/*
<ul>
		<li>Apple</li>
		<li>Banana</li>
		<li>Carrot</li>
	</ul>
	<table border="1">
		<tbody id = "tbody1">
			<tr>
				<th>name</th>
				<td>something</td>
			</tr>
		</tbody>
	</table>
	
	<table border="1">
		<thead>
			<tr>
				<th>name</th>
				<th>age</th>
			</tr>
		</thead>
		<tbody id = "tbody2">
			
		</tbody>
	</table>
*/