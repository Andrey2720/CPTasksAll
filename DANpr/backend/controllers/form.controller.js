const db = require('../db')
class FormController{
    
    async createForm(reg, res){
        const {nameobj, typeobj, description, files, status, city, users_id, masters_id, category_id} = reg.body
        // console.log(name, surename, patronymic, email, role, group_tb_id)
        
        
        const newForm = await db.query(`insert into form (nameobj, typeobj, description, files, status, city, users_id, masters_id, category_id) values ($1, $2, $3, $4, $5, $6, $7, $8, $9) returning *`, [nameobj, typeobj, description, files, status, city, users_id, masters_id, category_id])
        res.json(newForm.rows[0])
    }
    async getForms(reg, res){
        const forms = await db.query(`select * from form`)
        res.json(forms.rows)
    }
    async getOneForm(reg, res){
        const id = reg.params.id
        const oneForm = await db.query(`select * from form where id = $1`, [id])
        res.json(oneForm.rows[0])
    }

    async getFormFilterFromUser(reg, res){
        
        const {users_id} = reg.body
        
        console.log(reg.body)
        const filt = await db.query(`SELECT * FROM form WHERE users_id = $1;`, [users_id])
        res.json(filt.rows)
    }

    async getFormFilterFromMaster(reg, res){
        
        const {city, masters_id, category_id} = reg.body
        
        console.log(reg.body)
        const filt = await db.query(`SELECT * FROM form WHERE city = $1 AND masters_id = $2 AND category_id = $3;`, [city, masters_id, category_id])
        res.json(filt.rows)
    }
    
}
module.exports = new FormController()