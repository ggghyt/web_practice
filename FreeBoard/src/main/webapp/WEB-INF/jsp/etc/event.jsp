<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<script src='./dist/index.global.js'></script>
<script src="js/eventModal.js"></script>
<script>
	let modalArg = null;
	let calendar = null;
	document.addEventListener('DOMContentLoaded', async function() {
		var eventDate = [];
		
		let resolve = await fetch("eventInput.do")
		let result = await resolve.json()
		//.then(resolve => resolve.json())
		//.then(result => {
		eventDate = result;
		//})
		//.catch(err => console.log(err));
	var calendarEl = document.getElementById('calendar');
	calendar = new FullCalendar.Calendar(calendarEl, {
		headerToolbar : {
			left : 'prev,next today',
			center : 'title',
			right : 'dayGridMonth,timeGridWeek,timeGridDay'
			},
			initialDate : '2024-10-24',
			navLinks : true, // can click day/week names to navigate views
			selectable : true,
			selectMirror : true,
			select : function(arg) {
				modalShow(arg);
				<%--
				var title = prompt('Event Title:');
				if (title) {		
					fetch("eventInsert.do?title=" + title + "&start=" +  arg.startStr + "&end=" + arg.endStr)
					.then(calendar.addEvent({
							title : title,
							start : arg.start,
							end : arg.end,
							allDay : arg.allDay
					}))
				}
				--%>
				calendar.unselect()
			},
			eventClick : function(arg) {
				console.log(arg);
				if (confirm('Are you sure you want to delete this event?')) {
					fetch("eventDelete.do?title=" + arg.event._def.title)
					.then(arg.event.remove())
				}
			},
			editable : true,
			dayMaxEvents : true, // allow "more" link when too many events
			events : eventDate
		});

		calendar.render();
	});
</script>
<style>
body {
	margin: 40px 10px;
	padding: 0;
	font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
	font-size: 14px;
}

#calendar {
	max-width: 1100px;
	margin: 0 auto;
}
</style>
</head>
<body>

	<div id='calendar'></div>

	<!-- Button trigger modal -->
	<button type="button" class="btn btn-primary" data-bs-toggle="modal"
		data-bs-target="#exampleModal">Launch demo modal</button>
	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close" onclick="modalClose()"></button>
				</div>
				<div class="modal-body">
					title : <input type="text" id="title"><br> 
					start date : <input type="datetime-local" id="start" onchange="startChange(event)"><br>
					end date : <input type="datetime-local" id="end" onchange="endChange(event)"><br>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-bs-dismiss="modal" onclick="modalClose()">Close</button>
					<button type="button" class="btn btn-primary" onclick="modalSave()">Save</button>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
