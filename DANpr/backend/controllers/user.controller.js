const db = require('../db')
class UserController{
    
    async createUser(reg, res){
        let i = 0
        const {name, email,  phone, role, password} = reg.body
        console.log(reg.body)
        const q = await db.query(`select * from users`)
        q.rows.forEach(e => {
            if (e.email == email) {
                i = i+1
            }
        })
        if(i > 0){
            res.json({message:"Пользователь с таким email уже существует"})
        }else{
            const newUser = await db.query(`insert into users (name, email,  phone, role, password) values ($1, $2, $3, $4, $5) returning *`, 
                                            [name, email,  phone, role, password])
            res.json(newUser.rows[0])
        }
        
        
     

    }
    async loginUser(reg, res){
        console.log(reg.body)
        let c = false
        const {password, email} = reg.body
        const q = await db.query(`select * from users`)
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
        const users = await db.query(`select * from users`)
        res.json(users.rows)
    }
    async getOneUser(reg, res){
        const id = reg.params.id
        const oneUser = await db.query(`select * from users where id = $1`, [id])
        res.json(oneUser.rows[0])
    }
    
}
module.exports = new UserController()