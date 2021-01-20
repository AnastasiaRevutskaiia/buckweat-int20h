import React, { useCallback } from 'react'
import PropTypes from 'prop-types'
import { CanvasJSChart } from 'canvasjs-react-charts'

function getRandomIntInclusive(min, max) {
  min = Math.ceil(min)
  max = Math.floor(max)
  return Math.floor(Math.random() * (max - min + 1)) + min
}

export default function PricesList({ prices }) {
  const options = useCallback(() => ({
    animationEnabled: true,
    exportEnabled: true,
    theme: 'light2', // "light1", "dark1", "dark2"
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
    <ul className="collection" style={{ margin: '4rem' }}>
      {prices.map(({ storeName, link, currentPrice }, idx) => {
        return (
          <li key={idx} className="collection-item">
            <>
              <p>
                <b>Store name:</b> {storeName}
              </p>
              <p>Current price: {currentPrice}</p>
              <p>
                Visit: <a href={link}>{link}</a>
              </p>

              <CanvasJSChart options={options()} />
            </>
          </li>
        )
      })}
    </ul>
  )
}

PricesList.propTypes = {
  prices: PropTypes.arrayOf(PropTypes.object),
}
