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
        backgroundColor: [
  '#B4D9FF', '#007AFF', '#5856D6', '#34C759', '#FF2D55', '#FF9500', '#FFCC00', '#8E8E93', '#FF3B30', '#C69C6D'
],
        borderColor: [
  '#B4D9FF', '#007AFF', '#5856D6', '#34C759', '#FF2D55', '#FF9500', '#FFCC00', '#8E8E93', '#FF3B30', '#C69C6D'
],
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
 
        },
        x: {
          ticks: {
            fontSize: 8,
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




