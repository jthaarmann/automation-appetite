import express from 'express'

let app = express()

app.use(function(req, res, next) {
  res.header("Access-Control-Allow-Origin", "*");
  res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
  next();
})

app.get('/hello', (req, res) => {
    res.send('Hello World!')
})


const PORT = 8888

app.listen(PORT, () => {
    console.log(`App's listening on http://localhost:${PORT}/`)
})

