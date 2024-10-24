<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<script src='./dist/index.global.js'></script>
<script>
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
	var calendar = new FullCalendar.Calendar(calendarEl, {
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
				calendar.unselect()
			},
			eventClick : function(arg) {
				console.log(arg);
				if (confirm('Are you sure you want to delete this event?')) {
					console.log(arg.event._def.title)
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

</body>
</html>
