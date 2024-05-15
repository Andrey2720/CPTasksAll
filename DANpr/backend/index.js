process.env.TZ = 'Etc/UTC';
const express = require('express')
const bodyParser = require('body-parser');
const cors = require('cors')
const app = express()

const categoryRouter = require('./routes/category.routes')
const userRouter = require('./routes/user.routes')
const masterRouter = require('./routes/master.routes')
const formRouter = require('./routes/form.routes')



app.use(bodyParser.json());
app.use(cors())
// app.use(express.json())
let port = 3002

app.listen(port, '192.168.1.46', () => {
    console.log("сервер запущен на порту 3002")
})

app.use('/api', categoryRouter)
app.use('/api', userRouter)
app.use('/api', masterRouter)
app.use('/api', formRouter)
