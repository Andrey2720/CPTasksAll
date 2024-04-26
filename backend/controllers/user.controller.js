const db = require('../db')
class UserController{
    
    async createUser(reg, res){
        const {name, surname, patronymic, email, role, group_tb_id} = reg.body
        // console.log(name, surename, patronymic, email, role, group_tb_id)
        
        console.log(typeof(group_tb_id))
        const newUser = await db.query(`insert into user_tb (name, surname, patronymic, email, role, group_tb_id) values ($1, $2, $3, $4, $5, $6) returning *`, [name, surname, patronymic, email, role, group_tb_id])
        res.json(newUser.rows[0])
    }
    async getUsers(reg, res){
        const users = await db.query(`select * from user_tb`)
        res.json(users.rows)
    }
    async getOneUser(reg, res){
        const id = reg.params.id
        const oneUser = await db.query(`select * from user_tb where id = $1`, [id])
        res.json(oneUser.rows)
    }
    async updateUser(reg, res){
        
    }
    async deleteUser(reg, res){
        
    }
}
module.exports = new UserController()