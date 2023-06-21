/**
 *  
 */


function DoublebarChart(context, xlabel, ylabel_01, ylabel_02) {
	const datas = {
		labels: xlabel,
		datasets: [
			{
				label: "남",
				backgroundcolor: "blue",
				data: ylabel_01

			},
			{
				label: "여",
				backgroundcolor: "red",
				data: ylabel_02

			}
		]

	}

	const config = {
		type: 'bar',
		data: datas




	}

	const barChart_double = new Chart(context, config);
	return barChart_double;
}



// 한개의 데이터를 한개의 바차트로 보여주는 함수.
function SingleBarChart(context, xlabels, y01, ydatas_01) {

	const datas = {
		labels: xlabels, /* x축을 선언하는 파트. - 위에서 선언한 labels 로 대체할 수 있다.*/

		datasets: [ /* 그려질 그래프의 정보를 입력하는 부분이다. 그래프의 배경색, 테두리색, data 값들이 입력된다. */
			{
				label: y01, /* 그래프(차트)의 제목이다.*/
				fill: false,
				backgroundColor: ['#B4D9FF', '#007AFF', '#5856D6', '#34C759', '#FF2D55', '#FF9500', '#FFCC00', '#8E8E93', '#FF3B30', '#C69C6D'],
				borderColor: ['#B4D9FF', '#007AFF', '#5856D6', '#34C759', '#FF2D55', '#FF9500', '#FFCC00', '#8E8E93', '#FF3B30', '#C69C6D'],
				data: ydatas_01,
				yAxisID: 'y-axis-1'

			} //첫번째 data 셋 입력 끝.(매출액 데이터))

		] //dataset 끝
	};


	const config = {
		type: 'bar',
		data: datas,
		options: {
			maintainAspectRatio: false, /*  가로세로 비율 무시하기*/

			scales: {
				x: {
					grid: {
						display: false
					}
				},
				y: {

					grid: {
						display: false
					},


				},
				yAxes: [
					{
						id: 'y-axis-1',
						position: 'left',
						ticks: {
							beginAtZero: true,
							fontSize: 8,
							fontColor: 'rgb(255,0,0)',
							suggestedMax: 15
						}
					}

				],


				xAxes: [{
					ticks: {
						fontSize: 8, // x축 레이블의 글씨 크기를 10으로 설정 (원하는 크기로 조정)
					}
				}]
			},//scale 끝

			layout: {
				padding: {
					top: 0,
					right: 0,
					bottom: 30,
					left: 0
				}

			},//layout 끝

			legend: {
				display: false,
				labels: {
					fontSize: 12,
					boxWidth: 10,// 범례의 글씨 크기 설정
				},
				elements: {
					line: {
						borderWidth: 1, // 선의 두께 설정 (기본값: 3)
					}
				}

			}//legend 끝 

		}//option 끝
	};//config 끝

	const barChart_single = new Chart(context, config);
	return barChart_single;


}




function PieChart(Title, context, xlabel, ydatas_01) {
  var dataset = {
    label: Title,
    backgroundColor: ['#FF00FF', '#FF69B4', '#FFA500', '#FFD700', '#00FF00', '#00BFFF', '#FF1493', '#00CED1', '#FF7F50', '#FFFF00'],
    data: ydatas_01
  };

  var labels = xlabel;

  var data = {
    datasets: [dataset],
    labels: labels
  };

  var options = {
    responsive: true,
    maintainAspectRatio: true,
    legend: {
      labels: {
        fontColor: 'black'
      },
      align: 'center',
      display: true,
      fullWidth: true
    },
    tooltips: {
      enabled: false
    },

  };

  var myChart = new Chart(context, {
    type: 'pie',
    data: data,
    options: options,
    plugins: {
      datalabels: {
        formatter: function(value, ctx) {
          var sum = 0;
          var dataArr = ctx.chart.data.datasets[0].data;
          dataArr.forEach(function(data) {
            sum += data;
          });
          var percentage = ((value * 100) / sum).toFixed(2) + '%';
          return percentage;
        },
        color: '#fff',
        font: {
          size: 15
        }
      }
    }
  });

  return myChart;
}





//한개 데이터를 한화면에 보여주는 함수
function SingleLineChart(context, xlabels, y01, ydatas_01) {


	const datas = {
		labels: xlabels, /* x축을 선언하는 파트. - 위에서 선언한 labels 로 대체할 수 있다.*/

		datasets: [ /* 그려질 그래프의 정보를 입력하는 부분이다. 그래프의 배경색, 테두리색, data 값들이 입력된다. */
			{
				label: y01, /* 그래프(차트)의 제목이다.*/
				fill: false,
				backgroundColor: 'rgb(255, 0, 0)',
				borderColor: 'rgb(255, 0, 0)',
				data: ydatas_01,
				yAxisID: 'y-axis-1'

			} //첫번째 data 셋 입력 끝.(매출액 데이터))

		] //dataset 끝
	};

	/* 차트 발생 코드에 넣을 값들을 하단에 몰아 넣는다면  여기에는 이 코드가 들어가야 한다.
	
	var context = document      
	  .getElementById('myChart') 
	  .getContext('2d');	
	
	 */

	const config = {
		type: 'line',
		data: datas,
		options: {
			maintainAspectRatio: false, /*  가로세로 비율 무시하기*/

			scales: {
				x: {
					grid: {
						display: false
					}
				},
				y: {
					grid: {
						display: false
					}

				},
				yAxes: [
					{
						id: 'y-axis-1',
						position: 'left',
						ticks: {
							fontSize: 8,
							fontColor: 'rgb(255,0,0)',
							/* max : 1600000 */
						}
					}

				],


				xAxes: [{
					ticks: {
						fontSize: 8, // x축 레이블의 글씨 크기를 10으로 설정 (원하는 크기로 조정)
					}
				}]
			},//scale 끝

			layout: {
				padding: {
					top: 0,
					right: 0,
					bottom: 30,
					left: 0
				}

			},//layout 끝

			legend: {
				display: true,
				labels: {
					fontSize: 20,
					boxWidth: 15,// 범례의 글씨 크기 설정
				},
				elements: {
					line: {
						borderWidth: 1, // 선의 두께 설정 (기본값: 3)
					}
				}

			}//legend 끝 

		}//option 끝
	};//config 끝

	const LineChart_single = new Chart(context, config);
	return LineChart_single;


}

// 두개 데이터차트를 한 화면에 보여주는 함수.
function SaleChart_double(context, xlabels, y01, ydatas_01, y02, ydatas_02) {


	const datas = {
		labels: xlabels, /* x축을 선언하는 파트. - 위에서 선언한 labels 로 대체할 수 있다.*/

		datasets: [ /* 그려질 그래프의 정보를 입력하는 부분이다. 그래프의 배경색, 테두리색, data 값들이 입력된다. */
			{
				label: y01, /* 그래프(차트)의 제목이다.*/
				type: 'line',
				fill: false,
				backgroundColor: 'rgb(255, 50, 0,0.8)',
				borderColor: 'rgb(255, 50, 0,0.8)',
				data: ydatas_01,
				yAxisID: 'y-axis-1',
				
			}, //첫번째 data 셋 입력 끝.(매출액 데이터))

			{
				label: y02, /* 그래프(차트)의 제목이다.*/
				type: 'bar',
				backgroundColor: 'rgb(0, 200, 200, 0.5)',
				data: ydatas_02,
				yAxisID: 'y-axis-2',
				

			}


		] //dataset 끝

	}; //datas 끝


	const config = {
		type: 'bar',
		data: datas,
		options: {
			maintainAspectRatio: false, /*  가로세로 비율 무시하기*/

			scales: {

				yAxes: [
					{
						id: 'y-axis-1',
						position: 'left',
						ticks: {
							beginAtZero: true,
							fontSize: 10,
							fontColor: 'rgb(255,0,0)',
				            callback: function(value, index, values) {	 // 세 자리마다 쉼표 추가

				              return (value/1000).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
				            }							
							
							/* max : 1600000 */
						},
			         	 gridLines: { // 가로선 지울지 말지 결정 하는 옵션.
            				drawOnChartArea: false 
         				 }
					},
					{
						id: 'y-axis-2',
						position: 'right',
						ticks: {
							beginAtZero: true,
							
							fontSize: 10,
							fontColor: 'rgb(0,0,255)',
							suggestedMax: 20,
							/* max : 16 */
						},
			          gridLines: {
            				drawOnChartArea: false // 가로선 지울지 말지 결정 하는 옵션.
         				 }
					},
					
				],


				xAxes: [{
					ticks: {
						fontSize: 8, // x축 레이블의 글씨 크기를 10으로 설정 (원하는 크기로 조정)
					}
				}]
			},//scale 끝

			layout: {
				padding: {
					top: 0,
					right: 0,
					bottom: 30,
					left: 0
				}

			},//layout 끝

			legend: {
				display: true,
				labels: {
					fontSize: 15,
					boxWidth: 10,// 범례의 글씨 크기 설정
				},
				elements: {
					line: {
						borderWidth: 1, // 선의 두께 설정 (기본값: 3)
					}
				}

			}//legend 끝 

		}//option 끝
	};//config 끝

	const SaleChart_double = new Chart(context, config);
	return SaleChart_double;
}









/* 색상을 임의로 지정하기 위해서 만드는 테이블 */





