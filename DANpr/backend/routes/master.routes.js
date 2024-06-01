const Router = require('express')
const router = new Router()
const masterController = require('../controllers/master.controller')

router.post('/master', masterController.createMaster)
router.get('/master', masterController.getMasters)
router.post('/masterLogin', masterController.loginMaster)
router.get('/master/:id', masterController.getOneMaster)
router.post('/masterfilter', masterController.getFilterMasters)



module.exports = router