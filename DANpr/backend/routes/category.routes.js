const Router = require('express')
const router = new Router()
const categoryController = require('../controllers/category.controller')

router.post('/category', categoryController.createCategory)
router.get('/category', categoryController.getCategorys)
router.get('/category/:id', categoryController.getOneCategory)



module.exports = router