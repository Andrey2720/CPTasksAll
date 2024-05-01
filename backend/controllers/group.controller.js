const db = require('../db')
class GroupController{
    async createGroup(reg, res){
        const {name} = reg.body
        const newGroup = await db.query(`insert into group_tb (name) values ($1) returning *`, [name])
        res.json(newGroup.rows[0])
    }
    async getGroups(reg, res){
        const groups = await db.query(`select * from group_tb`)
        res.json(groups.rows)
    }
    async getOneGroup(reg, res){
        const id = reg.params.id
        const oneGroup = await db.query(`select * from group_tb where id = $1`, [id])
        res.json(oneGroup.rows)
    }
    async updateGroup(reg, res){
        
    }
    async deleteGroup(reg, res){
        
    }
}
module.exports = new GroupController()