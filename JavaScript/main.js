console.log("Welcome to Community Portal")
window.onload = function(){
    alert("Page has been fully loaded")
}
const eventName = "Cultural Events 2026 ";
const eventDate = "15-06-2026";
let seats = 50;
document.getElementById("events-info").textContent = `${eventName}: ${eventDate}`;
document.getElementById("seats").textContent = `Available Seats : ${seats}`;
    
function RegisterEvent(){
    if(seats>0){
        seats--;
        document.getElementById("seats").textContent = `Available seats : ${seats}`;
        alert("Registration successful");
    }
    else{
        alert("No seats available");
    }
}