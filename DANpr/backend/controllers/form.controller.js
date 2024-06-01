const db = require('../db')
class FormController{
    
    async createForm(reg, res){
        const {nameobj, typeobj, description, files, status, city, users_id, masters_id, category_id} = reg.body
       
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
        
        const id = reg.params.id
        
        console.log(reg.params.id)
        const filt = await db.query(`select masters.name, form.nameobj, form.city, form.status from form inner join masters on form.masters_id = masters.id where form.users_id = $1;`, [id])
        res.json(filt.rows)
    }

    async getFormFilterFromMaster(reg, res){
        
        const id = reg.params.id
        
       
        const filt = await db.query(`select form.id, users.name, form.nameobj, form.status, form.city, form.typeobj, form.description, users.email, users.phone from form inner join users on form.users_id = users.id where form.masters_id = $1;`, [id])
        res.json(filt.rows)
    }

    async updateStatus(reg, res){
        
        const {status, id} = reg.body
        
        console.log(reg.body)
        const filt = await db.query(`update form set status = $1 where id = $2;`, [status, id])
        res.json(filt.rows)
    }
    
}
module.exports = new FormController()