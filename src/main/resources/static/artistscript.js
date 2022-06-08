// Artist Class
class Artist {
    constructor(id, name) {
        this.id = id;
        this.name = name;
    }
}

// Create Artist
function createArtist(name) {
    if (name == "") {
        console.log("Empty fields.")
        alert("Empty fields.")
    } else {
        fetch(`http://localhost:8080/artist/create`, {
            method: 'post',
            headers: {
                'content-type': 'application/json',
            },
            body: JSON.stringify({
                "name": name,
            }),
        })
            .then((response) => { if (response.status == 201) { location.reload(); } console.log(response) })
            .catch((error) => console.log(error));
    }
}

createArtistButton.onclick = () => createArtist(
    artistInput.value
);

// Delete Artist
let deleteArtist = (id) => {
    if (id == 0) {
        console.log("Empty fields.")
        alert("Empty fields.")
    } else {
        fetch(`http://localhost:8080/artist/delete/${id}`, {
            method: 'delete',
            headers: {
                'content-type': 'application/json',
            }
        })
            .then((response) => console.log(response))
            .catch((error) => console.log(error));
    }
}

deleteArtistButton.onclick = () => deleteArtist(deleteArtistInput.value);

// Update Artist
function updateArtist(id, name) {
    if (id == 0 || name == "") {
        console.log("Empty fields.")
        alert("Empty fields.")
    } else {
        fetch(`http://localhost:8080/artist/update/${id}`, {
            method: 'put',
            headers: {
                'content-type': 'application/json',
            },
            body: JSON.stringify({
                "name": name,
            }),
        })
            .then((response) => { if (response.status == 201) { location.reload(); } console.log(response) })
            .catch((error) => console.log(error));
    }
}

updateArtistButton.onclick = () => updateArtist(
    updateIDArtistInput.value,
    updateNameArtistInput.value,
);

// Create Song
function createSong(id, title, artist, genre, length) {
    if (id == 0 || title == "" || artist == "" || genre == "" || length == 0) {
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
                "artist": { id, artist },
                "genre": genre,
                "length": length,
            }),
        })
            .then((response) => console.log(response))
            .catch((error) => console.log(error));
    }
}

addSongButton.onclick = () => createSong(
    idInput.value,
    titleInput.value,
    artistInput2.value,
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

deleteSongButton.onclick = () => deleteSong(deleteSongInput.value);

// Add item to list on Site
function addItem(data) {
    for (let i in data) {
        let child = document.createElement(`li`);
        child.appendChild(document.createTextNode(
            `${data[i].id} - ${data[i].name}: ${JSON.stringify(data[i].songs)}`))
        // for (let song in data[i]) {
        //     child.appendChild(document.createTextNode(`${data[i].songs[song].title}`))
        // }
        artistList.appendChild(child)
    }
}

showArtistButton.addEventListener("click", () => {
    searchAll();
});

// Update Song
function updateSong(id2, name, id, title, genre, length) {
    if (id == 0 || title == "" || genre == "" || length == 0 || id2 == 0 || name == "") {
        console.log("Empty fields.")
        alert("Empty fields.")
    } else {
        fetch(`http://localhost:8080/song/update/${id}`, {
            method: 'put',
            headers: {
                'content-type': 'application/json',
            },
            body: JSON.stringify({
                "title": title,
                "artist": {
                    "id": id2,
                    "name": name
                },
                "genre": genre,
                "length": length
            }),
        })
            .then((response) => { if (response.status == 201) { location.reload(); } console.log(response) })
            .catch((error) => console.log(error));
    }
}

updateSongButton.onclick = () => updateSong(
    updateSongArtistIDInput.value,
    updateSongArtistNameInput.value,
    updateIDSongInput.value,
    updateTitleInput.value,
    updateGenreInput.value,
    updateLengthInput.value
);

// Show All Artists
let searchAll = () => {
    fetch(`http://localhost:8080/artist/read`)

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