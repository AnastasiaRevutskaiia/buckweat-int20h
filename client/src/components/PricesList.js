import React, { useCallback } from 'react'
import PropTypes from 'prop-types'

export default function PricesList({ prices }) {
  return (
    <ul className="collection" style={{ margin: '4rem' }}>
      {prices.map(({ name, link, price }, idx) => {
        return (
          <li key={idx} className="collection-item">
            <>
              <p>
                <b>Store name:</b> {name}
              </p>
              <p>Current price: {price}</p>
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
