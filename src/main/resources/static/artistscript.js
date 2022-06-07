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
            .then((response) => console.log(response))
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

// Add item to list on Site
function addItem(data) {
    for (let i in data) {
        let child = document.createElement(`li`);
        child.appendChild(document.createTextNode(`${JSON.stringify(data[i])}`))
        artistList.appendChild(child)
    }
}

//   // Delete List
//   function deleteList() {
//       for (let x in artistList) {
//           delete(x);
//       }
//   }

showArtistButton.onclick = () => {
    // deleteList();   
    searchAll();
}
