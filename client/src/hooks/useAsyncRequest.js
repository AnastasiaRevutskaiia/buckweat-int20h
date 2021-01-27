import { useState, useCallback } from 'react'

function useAsyncRequest() {
  const [isLoading, setIsLoading] = useState(false)
  const [error, setError] = useState(null)

  const request = async (url, method = 'GET', body = null, headers = {}) => {
    try {
      if (body) {
        body = JSON.stringify(body)
        headers['Content-Type'] = 'application/json'
      }

      const response = await fetch(url, {
        method,
        body,
        headers,
      })
      const data = await response.json()

      if (!response.ok) {
        throw new Error(data.message || 'Request error')
      }

      return { data, error: null }
    } catch (error) {
      return { data: null, error }
    }
  }

  const asyncRequest = useCallback(async (url, method, body, headers) => {
    setIsLoading(true)
    setError(null)

    const requestResult = await request(url, method, body, headers)

    setIsLoading(false)
    setError(requestResult.error)

    return requestResult.data
  }, [])

  return { isLoading, asyncRequest, error }
}

export { useAsyncRequest }
