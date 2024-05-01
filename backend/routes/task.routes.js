const Router = require('express')
const router = new Router()
const taskController = require('../controllers/task.controller')

router.post('/task', taskController.createTask)
router.get('/task', taskController.getTask)
router.get('/task/:id', taskController.getOneTask)
router.get('/taskFilter', taskController.getTaskFilter)



module.exports = router