import React, { useState, useEffect } from 'react'
import M from 'materialize-css'
import './Sidenav.css'

export default function Sidenav() {
  const [isPrices, setIsPrices] = useState(true)
  const [isStatistics, setIsStatistics] = useState(false)

  useEffect(() => {
    const elems = document.querySelectorAll('.sidenav')
    M.Sidenav.init(elems)
  })

  return (
    <ul id="sidenav-1" className="sidenav sidenav-fixed">
      <li>
        <div className="user-view">
          <div className="background">
            <img src="images/buckweat_sidenav_1.jpeg" />
          </div>
        </div>
      </li>
      <li>
        <a className="subheader">About:</a>
      </li>
      <li>
        <blockquote>
          <p>
            This site allows compare prices for buckwheat porridge from
            different Ukraine online stores.
          </p>
          <p>The information are taken from Google Content API for Shopping.</p>
          <p>
            The general dynamic of buckweat price rate is available in statistic
            section.
          </p>
        </blockquote>
      </li>
      <li>
        <div className="divider"></div>
      </li>
      <li
        className={isPrices ? 'active' : undefined}
        onClick={() => {
          setIsPrices(true)
          setIsStatistics(false)
        }}
      >
        <a href="#">Prices</a>
      </li>
      <li>
        <div className="divider"></div>
      </li>
      <li
        className={isStatistics ? 'active' : undefined}
        onClick={() => {
          setIsPrices(false)
          setIsStatistics(true)
        }}
      >
        <a href="#statistics">Statistics</a>
      </li>
      <li>
        <div className="divider"></div>
      </li>
    </ul>
  )
}
