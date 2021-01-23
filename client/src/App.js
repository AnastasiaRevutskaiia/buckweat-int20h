import React, { useEffect } from 'react'
import { BuckweatPrices } from './components/BuckweatPrices.js'
import { PricesPlot } from './components/PricesPlot.js'
import M from 'materialize-css'
import './App.css'

function App() {
  useEffect(() => {
    // const elems = document.querySelectorAll('.sidenav')
    // M.Sidenav.init(elems)
  })
  return (
    <div className="container">
      <BuckweatPrices />
      <PricesPlot />
    </div>
  )
}

export default App
