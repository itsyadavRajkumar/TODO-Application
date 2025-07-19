import { useState } from "react";
import PostListData from "./PostListData";
import GetListData from "./GetListData";
import UpdateListData from "./UpdateListData";
import DeleteListData from "./DeleteListData";

export default function TodoMenu() {

    const [avtiveTab, setActiveTab] = useState("get");

    const todoMenu = () => {
        switch (avtiveTab) {
            case "create":
                return <PostListData />;
            case "get":
                return <GetListData />;
            case "update":
                return <UpdateListData />
            case "delete":
                return <DeleteListData />
            default:
                return <GetListData />;
        }
    }

    return (
        <div>
            <h2>TODO List Operation</h2>
            <div style={{marginBottom: "10px"}}>
                <button onClick={() => setActiveTab("create")}>Create</button>
                <button onClick={() => setActiveTab("update")}>Update</button>
                <button onClick={() => setActiveTab("get")}>Get</button>
                <button onClick={() => setActiveTab("delete")}>Delete</button>
            </div>
            <div>
                {todoMenu()}
            </div>
        </div>
    );
}