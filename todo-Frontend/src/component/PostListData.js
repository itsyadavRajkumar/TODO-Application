import { useState } from "react";

function PostListData() {

    const [response, setResponse] = useState(null);
    const [title, setTitle] = useState("");
    const [description, setDescription] = useState("");

    const postToDOListData = () => {

        fetch(`http://localhost:8080/todo/create/list`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                title,
                description
            })
        })
            .then((res) => {
                if (!res.ok) {
                    throw new Error("Something went wrong");
                }
                return res.text();
            })
            .then(json => setResponse(json))
            .catch((err) => console.log("Getting exection ", err))
    }

    return (
        <div>
            <input
                type="text"
                placeholder="Enter the title"
                value={title}
                onChange={e => setTitle(e.target.value)}
            />
            <br></br>
            <input
                type="text"
                placeholder="Enter The Description"
                value={description}
                onChange={e => setDescription(e.target.value)}
            />

            <button onClick={postToDOListData}>save</button>

            {
                response ?
                    <div>
                        <pre> <p>Response: </p> {
                            JSON.stringify(response)
                        }</pre>
                    </div>
                    : <p>Loading error or data</p>
            }
        </div>
    );
}

export default PostListData;