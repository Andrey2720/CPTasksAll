const db = require('../db')
class UserController{
    
    async createUser(reg, res){
        let i = 0
        const {name, surename, patronymic, password, email, role, group_tb_id} = reg.body
        // console.log(name, surename, patronymic, email, role, group_tb_id, password) 
        const q = await db.query(`select * from user_tb`)
        q.rows.forEach(e => {
            if (e.email == email) {
                i = i+1
            }
        })
        if(i > 0){
            res.json({message:"Пользователь с таким email уже существует"})
        }else{
            const newUser = await db.query(`insert into user_tb (name, surename, patronymic, password, email, role, group_tb_id) values ($1, $2, $3, $4, $5, $6, $7) returning *`, [name, surename, patronymic, password, email, role, group_tb_id])
            res.json(newUser.rows[0])
        }
        
        
     

    }
    async loginUser(reg, res){
        console.log(reg.body)
        let c = false
        const {password, email} = reg.body
        const q = await db.query(`select * from user_tb`)
        c = q.rows.some(e => {
            if (e.email == email && e.password == password) {
                res.json(e)
                return true
            }
        })
        if(c == false){
            res.json({message:"Неверный логин или пароль"})
        }
        

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