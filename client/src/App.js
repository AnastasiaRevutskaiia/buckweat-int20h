import React from 'react'
import { BuckwheatPrices } from './components/BuckwheatPrices.js'
import { PricesPlot } from './components/PricesPlot.js'
import './App.css'

function App() {
  return (
    <div className="container">
      <div className="section-container">
        <div id="prices">
          <BuckwheatPrices />
        </div>
      </div>
      <div className="section-container">
        <div id="plot">
          <PricesPlot />
        </div>
      </div>
    </div>
  )
}

export default App
