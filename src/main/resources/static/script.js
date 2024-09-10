'use strict'

async function fetchPersons() {
    const response = await fetch("/api/persons");
    const persons = await response.json();

    const personsUl = document.getElementById("persons");
    personsUl.innerHTML = ''; // Clear the existing list

    for (const person of persons) {
        personsUl.innerHTML += `<li>${person.name}</li>`;
    }


}

fetchPersons();

document.getElementById("save-button").addEventListener("click", async () => {
    const inputValue = document.getElementById("name-input").value;
    const personJson = JSON.stringify({name: inputValue})

    const myHeaders = new Headers({
        "Content-Type": "application/json"
    });

    await fetch("api/persons",{
        method: "POST",
        headers: myHeaders,
        body: personJson
    });
    await fetchPersons(); // Reload the list after adding a new person
})
