process.env.TZ = 'Etc/UTC';
const express = require('express')
const bodyParser = require('body-parser');
const cors = require('cors')
const app = express()
const groupRouter = require('./routes/group.routes')
const userRouter = require('./routes/user.routes')
const taskRouter = require('./routes/task.routes')



app.use(bodyParser.json());
app.use(cors())
// app.use(express.json())
let port = 3001

app.listen(port, '192.168.1.46', () => {
    console.log("сервер запущен на порту 3001")
})

app.use('/api', groupRouter)
app.use('/api', userRouter)
app.use('/api', taskRouter)