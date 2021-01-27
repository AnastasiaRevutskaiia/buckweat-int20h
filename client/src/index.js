import React from 'react'
import ReactDOM from 'react-dom'
import './index.css'
import App from './App'
import Sidenav from './components/Sidenav.js'

ReactDOM.render(
  <React.StrictMode>
    <Sidenav />
  </React.StrictMode>,
  document.getElementById('sidenav-section')
)

ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById('root')
)
