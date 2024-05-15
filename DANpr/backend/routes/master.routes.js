const Router = require('express')
const router = new Router()
const userController = require('../controllers/master.controller')

router.post('/master', userController.createMaster)
router.get('/master', userController.getMasters)
router.post('/masterLogin', userController.loginMaster)
router.get('/master/:id', userController.getOneMaster)



module.exports = router