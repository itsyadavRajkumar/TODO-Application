import React, { useState } from "react";

function GetListData() {

    const [response, setResponse] = useState(null);
    const [id, setId] = useState("");
    const [errorMessage, setErrorMessage] = useState("");

    const getListData = () => {

        setErrorMessage("");
        setResponse(null);

        fetch(`http://localhost:8080/todo/get/list/data?id=${id}`, {
            method: "GET",
            headers: {
                "Content-Type": "application/json"
            }
        })
            .then((res) => {
                if (!res.ok) {
                    throw new Error("Data Not Found!!");
                }
                return res.json();
            })
            .then(json => {
                if (json === null || Object.keys(json).length === 0) {
                    setErrorMessage("Data Not Found!");
                } else {
                    setResponse(json);
                }
            })
            .catch(err => {
                console.log(err);
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

            <button onClick={getListData}>Fetch</button>

            {
                errorMessage && <p style={{ color: "red" }}>{errorMessage}</p>
            }

            {
                response && (
                    <div>
                        <p>Response: </p>
                        <pre style={{ color: "green" }}>{JSON.stringify(response)}</pre>
                    </div>
                )
            }
        </div>
    );

}

export default GetListData;