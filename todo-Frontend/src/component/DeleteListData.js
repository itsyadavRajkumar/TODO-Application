import { useState } from "react";

export default function DeleteListData() {
    const [id, setId] = useState("");
    const [response, setResponse] = useState(null);

    const deleteListData = () => {
        fetch(`http://localhost:8080/todo/delete/list/data?id=${id}`, {
            method: "DELETE",
            headers: {
                "Content-Type": "application/json"
            }

        })
            .then(res => res.text())
            .then(json => setResponse(json))
            .catch((err) => console.error("Getting error", err))
    }

    return (
        <div>
            <input
                type="number"
                placeholder="Enter the id"
                value={id}
                onChange={e => setId(e.target.value)}
            />

            <button onClick={deleteListData}>Delete</button>

            {
                response
                    ? <pre>{JSON.stringify(response)}</pre>
                    : <h1>Loading error or data </h1>
            }
        </div>
    );
}