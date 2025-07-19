import React, { useState } from "react";

export default function UpdateListData() {
    const [id, setId] = useState("");
    const [title, setTitle] = useState("");
    const [description, setDescription] = useState("");
    const [response, setResponse] = useState(null);
    const [errorMessage, setErrorMessage] = useState(null);

    const updateListData = () => {
        setResponse(null);
        setErrorMessage("");

        fetch(`http://localhost:8080/todo/update/list/data`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                id,
                title,
                description
            })
        })
            .then(res => {
                if (!res.ok) {
                    throw new Error("Data Not Found!!");
                }
                return res.text();
            })
            .then(json => {
                if (json === null || Object.keys(json).length === 0) {
                    setErrorMessage("Data Not Found!");
                } else {
                    setResponse(json);
                }
            })
            .catch((err) => {
                console.log("Getting some error: ", err);
                setErrorMessage("Data Not Found!!");
            });
    }

    return (
        <div>
            <input
                type="number"
                placeholder="Enter the id"
                value={id}
                onChange={e => setId(e.target.value)}
            />
            <br></br>
            <input
                type="text"
                placeholder="Enter the title"
                value={title}
                onChange={e => setTitle(e.target.value)}
            />
            <br></br>
            <input
                type="text"
                placeholder="Enter the description"
                value={description}
                onChange={e => setDescription(e.target.value)}
            />

            <button onClick={updateListData}>Update</button>

            {
                errorMessage && <p style={{ color: "red" }}>{errorMessage}</p>
            }

            {
                <div> {
                    response && (
                        <pre style={{ color: "green" }}>{JSON.stringify(response)}</pre>
                    )
                }
                </div>
            }
        </div>
    );
}