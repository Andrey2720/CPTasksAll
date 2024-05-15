const Router = require('express')
const router = new Router()
const formController = require('../controllers/form.controller')

router.post('/form', formController.createForm)
router.get('/form', formController.getForms)
router.get('/form/:id', formController.getOneForm)
router.get('/formFilterFromUser', formController.getFormFilterFromUser)
router.get('/formFilterFromMaster', formController.getFormFilterFromMaster)




module.exports = router