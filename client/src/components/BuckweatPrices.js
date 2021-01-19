import React, { useEffect, useState } from 'react'
import { useAsyncRequest } from '../hooks/useAsyncRequest'
import PricesList from './PricesList.js'
import Loader from './Loader.js'

export const BuckweatPrices = () => {
  const [prices, setPrices] = useState([])
  const { isLoading, asyncRequest } = useAsyncRequest()

  useEffect(() => {
    async function fetchPrices() {
      const data = await asyncRequest(
        // 'https://jsonplaceholder.typicode.com/todos?_limit=3'
        '/storePrices'
      )
      setPrices(
        data ? data.sort((a, b) => a.currentPrice - b.currentPrice) : []
      )
    }
    fetchPrices()
  }, [asyncRequest])

  if (isLoading) {
    return <Loader />
  }
  return <PricesList prices={prices} />
}
