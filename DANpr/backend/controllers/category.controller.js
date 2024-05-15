const db = require('../db')
class CategoryController{
    async createCategory(reg, res){
        const {name} = reg.body
        const newCategory = await db.query(`insert into category(name) values ($1) returning *`, [name])
        res.json(newCategory.rows[0])
    }
    async getCategorys(reg, res){
        const categorys = await db.query(`select * from category`)
        res.json(categorys.rows)
    }
    async getOneCategory(reg, res){
        const id = reg.params.id
        const oneCategorys = await db.query(`select * from categorys where id = $1`, [id])
        res.json(oneCategorys.rows)
    }
    async updateGroup(reg, res){
        
    }
    async deleteGroup(reg, res){
        
    }
}
module.exports = new CategoryController()