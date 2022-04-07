<%@ page pageEncoding="utf-8"%>
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      var myData = [['Loại', 'Giá trị']];
      
      function drawChart() {
    	  $.ajax({
    		  url:"/admin/report/inventory-by-category",
    		  success: function(resp){
    			  resp.forEach(item => {
    				  myData.push([item.group.nameVN, item.sum]);
    			  });
    			  drawChart2();
    		  }
    	  })
      }
      
      function drawChart2(){
    	  var data = google.visualization.arrayToDataTable(myData);
	        var options = {
	          title: 'My Daily Activities',
	          is3D: true,
	        };
	        var chart = new google.visualization.ColumnChart(document.getElementById('piechart_3d'));
	        chart.draw(data, options);
      }
      $(function(){
    	  $(window).resize(function(){
    		  drawChart2();
    	  });
      })
    </script>
  </head>
  <body>
<div class="wrapper">
    <div class="chart" id="piechart_3d"></div>
</div>
  </body>
</html>
<style>
.wrapper {
  position: relative;
  padding-bottom: 56.25%; /* 16:9 */
  height: 0;
}
.wrapper .chart {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
}
</style>