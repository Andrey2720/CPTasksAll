const db = require('../db')
class TaskController{
    
    async createTask(reg, res){
        const {name, description, files, status, date_start, date_end, time_start, time_end, user_tb_id} = reg.body
        // console.log(name, surename, patronymic, email, role, group_tb_id)
        
        console.log(typeof(group_tb_id))
        const newUser = await db.query(`insert into tasks (name, description, files, status, date_start, date_end, time_start, time_end, user_tb_id) values ($1, $2, $3, $4, $5, $6, $7, $8, $9) returning *`, [name, description, files, status, date_start, date_end, time_start, time_end, user_tb_id])
        res.json(newUser.rows[0])
    }
    async getTask(reg, res){
        const users = await db.query(`select * from tasks`)
        res.json(users.rows)
    }
    async getOneTask(reg, res){
        const id = reg.params.id
        const oneUser = await db.query(`select * from tasks where id = $1`, [id])
        res.json(oneUser.rows)
    }

    async getTaskFilter(reg, res){
        const {status, date_start, date_end, user_tb_id} = reg.body
        // console.log(name, surename, patronymic, email, role, group_tb_id)
        console.log(status)
        const filt = await db.query(`SELECT * FROM tasks WHERE date_start BETWEEN $1 AND $2 AND user_tb_id = $3 AND status = $4;`, [date_start, date_end, user_tb_id, status])
        res.json(filt.rows)
    }
    async updateUser(reg, res){
        
    }
    async deleteUser(reg, res){
        
    }
}
module.exports = new TaskController()