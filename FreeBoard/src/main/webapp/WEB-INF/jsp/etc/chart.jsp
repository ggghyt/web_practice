<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      var chartData = [['Writer', 'Count per Writer']];
      
      fetch("countByWriter.do")
      .then(resolve => resolve.json())
      .then(result => {
    	  console.log(result);
    	  result.forEach((row) => {
    		  chartData.push([row.member_name, row.count]);
    	  });
    	  google.charts.load('current', {'packages':['corechart']});
	      google.charts.setOnLoadCallback(drawChart);
    	  console.log(chartData);
      })
      .catch(err => console.log(err));

      function drawChart() {

        var data = google.visualization.arrayToDataTable(chartData);

        var options = {
          title: 'some datas'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>
  </head>
  <body>
    <div id="piechart" style="width: 900px; height: 500px;"></div>
  </body>
</html>
