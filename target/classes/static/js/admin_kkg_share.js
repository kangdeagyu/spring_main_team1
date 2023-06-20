/**
 * 
 */

function thisWeek() {
  var startday = new Date();
  startday.setDate(startday.getDate() - 7);
  var endday = new Date();

  var startYear = startday.getFullYear();
  var startMonth = String(startday.getMonth() + 1).padStart(2, '0');
  var startDay = String(startday.getDate()).padStart(2, '0');
  var startDateString = startYear + '-' + startMonth + '-' + startDay;

  var endYear = endday.getFullYear();
  var endMonth = String(endday.getMonth() + 1).padStart(2, '0');
  var endDay = String(endday.getDate()).padStart(2, '0');
  var endDateString = endYear + '-' + endMonth + '-' + endDay;

  document.getElementById("startdayInput").value = startDateString;
  document.getElementById("enddayInput").value = endDateString;

  document.getElementById("myForm").submit();
}




  // 그림 보여주는 함수
  function showChart(chartId_01,chartId_02) {
    var chart_01 = document.getElementById(chartId_01);
    var chart_02 = document.getElementById(chartId_02);
    if (chart_01.style.display === "none") {
      chart_01.style.display = "block";
      chart_02.style.display = "none";
    } else {
      chart_01.style.display = "none";
      chart_02.style.display = "block";
    }
  }
  
