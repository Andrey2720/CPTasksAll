const db = require('../db')
class MasterController{
    
    async createMaster(reg, res){
        let i = 0
        const {name, email,  phone, role, password, category_id, city, description} = reg.body
        
        const q = await db.query(`select * from masters`)
        q.rows.forEach(e => {
            if (e.email == email) {
                i = i+1
            }
        })
        if(i > 0){
            res.json({message:"Пользователь с таким email уже существует"})
        }else{
            const newUser = await db.query(`insert into masters (name, email,  phone, role, password, category_id, city, description) values ($1, $2, $3, $4, $5, $6, $7, $8) returning *`, [name, email,  phone, role, password, category_id, city, description])
            res.json(newUser.rows[0])
        }
        
        
     

    }
    async loginMaster(reg, res){
        console.log(reg.body)
        let c = false
        const {password, email} = reg.body
        const q = await db.query(`select * from masters`)
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
    async getMasters(reg, res){
        const users = await db.query(`select * from masters`)
        res.json(users.rows)
    }
    async getOneMaster(reg, res){
        const id = reg.params.id
        const oneUser = await db.query(`select * from masters where id = $1`, [id])
        res.json(oneUser.rows[0])
    }
    
}
module.exports = new MasterController()