const Pool = require('pg').Pool
const pool = new Pool({
    user: 'postgres',
    password: '1234',
    host: 'localhost',
    port: 5433,
    database: 'danpostgres',
    timezone: 'utc'
})


module.exports = pool