import React from 'react'
import PropTypes from 'prop-types'

export default function PricesList({ prices }) {
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
