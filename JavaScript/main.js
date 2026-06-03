console.log("Welcome to the Community Portal");

window.onload = function () {
    alert("Page has been fully loaded");
};

class Event {
    constructor(name, category, date, seats) {
        this.name = name;
        this.category = category;
        this.date = date;
        this.seats = seats;
    }
}

Event.prototype.checkAvailability = function () {
    return this.seats > 0;
};

let events = [
    new Event("Music Fest", "Music", "2026-07-10", 20),
    new Event("Workshop", "Education", "2026-08-15", 15),
    new Event("Sports Meet", "Sports", "2026-09-20", 10)
];

function displayEvents(eventList = events) {

    const container =
        document.querySelector("#eventContainer");

    container.innerHTML = "";

    eventList.forEach((event, index) => {

        const card =
            document.createElement("div");

        card.className = "card";

        card.innerHTML = `
            <h3>${event.name}</h3>
            <p>Category: ${event.category}</p>
            <p>Date: ${event.date}</p>
            <p>Seats: ${event.seats}</p>
            <button onclick="registerUser(${index})">
                Register
            </button>
        `;

        container.appendChild(card);
    });
}

displayEvents();

function addEvent(event) {
    events.push(event);
    displayEvents();
}

function registerUser(index) {

    try {

        if (!events[index]) {
            throw new Error("Event not found");
        }

        if (events[index].seats <= 0) {
            throw new Error("No seats available");
        }

        events[index].seats--;

        alert(
            `Registered for ${events[index].name}`
        );

        displayEvents();

    } catch (error) {

        alert(error.message);
    }
}

function filterEventsByCategory(category) {

    if (category === "All") {
        displayEvents(events);
        return;
    }

    const filtered =
        events.filter(
            event => event.category === category
        );

    displayEvents(filtered);
}

function registrationTracker() {

    let count = 0;

    return function () {

        count++;

        console.log(
            `Total Registrations: ${count}`
        );
    };
}

const tracker = registrationTracker();

function dynamicSearch(callback) {
    return events.filter(callback);
}

document
.getElementById("categoryFilter")
.onchange = function () {

    filterEventsByCategory(this.value);
};

document
.getElementById("searchBox")
.addEventListener("keydown", function () {

    const text =
        this.value.toLowerCase();

    const result =
        dynamicSearch(
            event =>
            event.name.toLowerCase()
            .includes(text)
        );

    displayEvents(result);
});

document
.getElementById("registerForm")
.addEventListener("submit", function (event) {

    event.preventDefault();

    const name =
        this.elements["name"].value;

    const email =
        this.elements["email"].value;

    const selectedEvent =
        this.elements["event"].value;

    if (name === "" || email === "") {

        document
        .getElementById("error")
        .textContent =
        "All fields are required";

        return;
    }

    document
    .getElementById("error")
    .textContent = "";

    submitRegistration({
        name,
        email,
        selectedEvent
    });

    tracker();
});

function submitRegistration(user) {

    document
    .getElementById("loading")
    .style.display = "block";

    setTimeout(async () => {

        try {

            const response =
                await fetch(
                "https://jsonplaceholder.typicode.com/posts",
                {
                    method: "POST",
                    headers: {
                        "Content-Type":
                        "application/json"
                    },
                    body: JSON.stringify(user)
                });

            if (response.ok) {
                alert(
                    "Registration submitted successfully"
                );
            }

        } catch (error) {

            alert("Submission failed");
        }

        document
        .getElementById("loading")
        .style.display = "none";

    }, 2000);
}

fetch(
    "https://jsonplaceholder.typicode.com/users"
)
.then(response => response.json())
.then(data => console.log(data))
.catch(error => console.log(error));

async function fetchEvents() {

    try {

        const response =
            await fetch(
            "https://jsonplaceholder.typicode.com/users"
        );

        const data =
            await response.json();

        console.log(data);

    } catch (error) {

        console.log(error);
    }
}

fetchEvents();

const musicEvents =
    events.filter(
        event => event.category === "Music"
    );

console.log(musicEvents);

const formattedCards =
    events.map(
        event => `Workshop on ${event.name}`
    );

console.log(formattedCards);

Object.entries(events[0]).forEach(
    ([key, value]) =>
    console.log(key, value)
);

const clonedEvents = [...events];

console.log(clonedEvents);