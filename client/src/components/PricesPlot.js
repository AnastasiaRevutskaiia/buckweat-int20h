import React, { useMemo } from 'react'
import { CanvasJSChart } from 'canvasjs-react-charts'

// http://www.ukrstat.gov.ua/operativ/operativ2018/ct/sctp/Arch_sctp_u.htm
const pricesByMonth = [
  27.77,
  28.36,
  28.5,
  30.02,
  35.42,
  36.74,
  36.96,
  37.18,
  36.92,
  36.86,
  36.99,
  37.28,
  // 37.43,
]

export const PricesPlot = () => {
  const options = useMemo(() => ({
    animationEnabled: true,
    exportEnabled: true,
    theme: 'light1', // "light1", "dark1", "dark2"
    title: {
      text: 'Average consumer prices for goods in Ukraine in 2020',
    },
    axisY: {
      title: 'Buckwheat price',
      suffix: ' UAH',
      interval: 4,
    },
    axisX: {
      title: 'Month',
      interval: 1,
      intervalType: 'month',
      valueFormatString: 'MMMM',
    },
    data: [
      {
        type: 'line',
        toolTipContent: '{x}: {y}(UAH)',
        dataPoints: pricesByMonth.map((v, i) => ({
          x: new Date(2020, i, 1),
          y: v,
        })),
      },
    ],
  }))
  return <CanvasJSChart options={options} />
}
