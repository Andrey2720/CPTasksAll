
async function getRes(){
    let res = await fetch("http://25.70.146.171:3001")
let content = await res.json()
console.log(content)
document.getElementById("cont").innerHTML = content.name
}
getRes()