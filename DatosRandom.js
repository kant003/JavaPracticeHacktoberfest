import fetch from "node-fetch";

fetch('https://randomuser.me/api')
    .then(Response => Response.json())
    .then(json => {
        console.log(json.results[0].name.first + " " + json.results[0].name.last)
        console.log(json.results[0].email)
        console.log(json.results[0].location.street.name + ", " + json.results[0].location.street.number)
    })