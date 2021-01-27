const path = require('path')
const jsonServer = require('json-server')
const server = jsonServer.create()
const router = jsonServer.router('db.json')
const middlewares = jsonServer.defaults({
  static: path.resolve(__dirname, '..', 'client', 'build'),
})
const port = process.env.PORT || 5000

server.use(middlewares)
// server.use(router)

server.get('*', (req, res) => {
  res.sendFile(path.resolve(__dirname, '..', 'client', 'build', 'index.html'))
})

server.listen(port, () => {
  console.log('Server started at port ' + port)
})
