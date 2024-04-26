const Router = require('express')
const router = new Router()
const groupController = require('../controllers/group.controller')

router.post('/group', groupController.createGroup)
router.get('/group', groupController.getGroups)
router.get('/group/:id', groupController.getOneGroup)

module.exports = router