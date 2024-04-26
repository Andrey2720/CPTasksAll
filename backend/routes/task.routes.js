const Router = require('express')
const router = new Router()
const taskController = require('../controllers/task.controller')

router.post('/user', userController.createTask)



module.exports = router