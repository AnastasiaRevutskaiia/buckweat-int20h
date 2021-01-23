import React, { useCallback } from 'react'
import { CanvasJSChart } from 'canvasjs-react-charts'

function getRandomIntInclusive(min, max) {
  min = Math.ceil(min)
  max = Math.floor(max)
  return Math.floor(Math.random() * (max - min + 1)) + min
}

export const PricesPlot = () => {
  const options = useCallback(() => ({
    animationEnabled: true,
    exportEnabled: true,
    theme: 'light1', // "light1", "dark1", "dark2"
    title: {
      text: 'Buckweat rate',
    },
    axisY: {
      title: 'Buckweat price',
      suffix: ' y.o.',
    },
    axisX: {
      title: 'Day',
      interval: 2,
    },
    data: [
      {
        type: 'line',
        toolTipContent: 'Day {x}: {y}y.o.',
        dataPoints: [...Array(30).keys()].map((i) => ({
          x: i + 1,
          y: getRandomIntInclusive(20, 60),
        })),
      },
    ],
  }))
  return (
    <div id="plot">
      <h1>This is plot</h1>
      <CanvasJSChart options={options()} />
    </div>
  )
}
