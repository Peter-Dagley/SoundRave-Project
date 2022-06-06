"use strict";

const idInput = document.getElementById("idInput")
const idButton = document.getElementById("idButton")
const carList = document.getElementById("songList")

// Making a Car Class

class Song {
  constructor(id, title, artist, genre, length) {
    this.id = id;
    this.title = title;
    this.artist = artist;
    this.genre = genre;
    this.length = length;
  }
}


// Functions

// Read by ID
let search = (id) => {
  fetch(`http://localhost:8080/song/read/${id}`)

    .then((response) => {
      if (response.status !== 200) {
        console.error(`status: ${response.status}`);
        return;
      }
      response.json().then((data) => {
        console.log(response.status);
        console.table(data);
        addItem(data);
      });
    }).catch((error) => console.error(`Request failed: ${error}`));
}

// Add item to list on Site
function addItem(data) {
  for (let i in data) {
    let child = document.createElement(`li`);
    child.appendChild(document.createTextNode(`${data[i]}`))
    songList.appendChild(child)
  }
}

idButton.onclick = () => search(idInput.value);


// Create Song
function createSong(title, artist, genre, length) {
  if (title == "" || artist == "" || genre == "" || length == 0) {
    console.log("Empty fields.")
    alert("Empty fields.")
  } else {
    fetch(`http://localhost:8080/song/create`, {
      method: 'post',
      headers: {
        'content-type': 'application/json',
      },
      body: JSON.stringify({
        "title": title,
        "artist": artist,
        "genre": genre,
        "length": length,
      }),
    })
      .then((response) => console.log(response))
      .catch((error) => console.log(error));
  }
}

createButton.onclick = () => createSong(
  titleInput.value,
  artistInput.value,
  genreInput.value,
  lengthInput.value
);

// Delete Song
let deleteSong = (id) => {
  if (id == 0) {
    console.log("Empty fields.")
    alert("Empty fields.")
  } else {
    fetch(`http://localhost:8080/song/delete/${id}`, {
      method: 'delete',
      headers: {
        'content-type': 'application/json',
      }
    })
      .then((response) => console.log(response))
      .catch((error) => console.log(error));
  }
}

deleteButton.onclick = () => deleteSong(deleteInput.value);