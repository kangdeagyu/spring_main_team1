/**
 *  
 */






// 한개의 데이터를 한개의 바차트로 보여주는 함수.
function SingleBarChart(context, xlabels, y01, ydatas_01) {

  const datas = {
    labels: xlabels,
    datasets: [
      {
        label: y01,
        fill: false,
        backgroundColor: ['#B4D9FF', '#007AFF', '#5856D6', '#34C759', '#FF2D55', '#FF9500', '#FFCC00', '#8E8E93', '#FF3B30', '#C69C6D'],
        borderColor: ['#B4D9FF', '#007AFF', '#5856D6', '#34C759', '#FF2D55', '#FF9500', '#FFCC00', '#8E8E93', '#FF3B30', '#C69C6D'],
        data: ydatas_01,
      },
    ],
  };

  const config = {
    type: 'bar',
    data: datas,
    options: {
      maintainAspectRatio: false,
      scales: {
        y: {
          beginAtZero: true,
          fontSize: 8,
          fontColor: 'rgb(255,0,0)',
          suggestedMax: 15,
          ticks: {
            callback: function (value, index, values) {
              return value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
            },
          },
        },
        x: {
          ticks: {
            fontSize: 8,
          },
        },
      },
      plugins: {
        tooltip: {
          enabled: true,
          callbacks: {
            label: function (context) {
              return context.dataset.label + ': ' + context.parsed.y.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
            },
          },
        },
      },
      legend: {
        display: false,
        labels: {
          fontSize: 12,
          boxWidth: 10,
        },
        elements: {
          line: {
            borderWidth: 1,
          },
        },
      },
    },
  };

  const barChart_single = new Chart(context, config);
  return barChart_single;
}





// 두개 데이터차트를 한 화면에 보여주는 함수.
function SaleChart_double(context, xlabels, y01, ydatas_01, y02, ydatas_02) {

  const datas = {
    labels: xlabels,
    datasets: [
      {
        label: y01,
        type: 'line',
        fill: false,
        backgroundColor: 'rgb(255, 50, 0, 0.8)',
        borderColor: 'rgb(255, 50, 0, 0.8)',
        data: ydatas_01,
      },
      {
        label: y02,
        type: 'bar',
        backgroundColor: 'rgb(0, 200, 200, 0.5)',
        data: ydatas_02,
        yAxisID: 'y2',
      },
    ],
  };

  const config = {
    type: 'bar',
    data: datas,
    options: {
      maintainAspectRatio: false,
      scales: {
        y: 
          {	
            position: 'left',
            beginAtZero: true,
            fontSize: 10,
            fontColor: 'rgb(255,0,0)',
           	grid: {
            drawOnChartArea: false,
          },
          },
          y2:{
			  data: ydatas_02,
            position: 'right',
            beginAtZero: true,
            fontSize: 10,
            fontColor: 'rgb(0,0,255)',
            suggestedMax: 10,
            grid: {
            drawOnChartArea: false,
          },
          },
        
        x: [
          {
            ticks: {
              fontSize: 8,
            },
          },
        ],
      },
      layout: {
        padding: {
          top: 0,
          right: 0,
          bottom: 30,
          left: 0,
        },
      },
      legend: {
        display: true,
        labels: {
          fontSize: 15,
          boxWidth: 10,
        },
        elements: {
          line: {
            borderWidth: 1,
          },
        },
      },
    },
  };

  const SaleChart_double = new Chart(context, config);
  return SaleChart_double;
}









/* 색상을 임의로 지정하기 위해서 만드는 테이블 */





