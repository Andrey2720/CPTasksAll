const Router = require('express')
const router = new Router()
const userController = require('../controllers/user.controller')

router.post('/user', userController.createUser)
router.get('/user', userController.getUsers)
router.get('/userLogin', userController.loginUser)
router.get('/user/:id', userController.getOneUser)



module.exports = router