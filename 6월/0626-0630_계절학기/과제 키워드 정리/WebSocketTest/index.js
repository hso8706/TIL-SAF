const express = require("express");
const { WebSocketServer } = require("ws");
const app = express();

app.use(express.static("front"));

const wss = new WebSocketServer({ port: 8080 })

let userCount = 0;
wss.on("connection", (ws) => {
    ws.send(" 현재 접속 인원 : " + ++userCount);
    wss.clients.forEach((client) => {
        if (client !== ws && client.readyState === ws.OPEN && client.location === ws.location) 
            client.send(" 현재 접속 인원 : " + userCount);
    })

    ws.on("message", (data) => {
        const ToJsonValue = JSON.parse(data);
        console.log(ToJsonValue);
        ws.send(ToJsonValue.nickname + " 님 : " + ToJsonValue.value);
        wss.clients.forEach((client) => {
            if (client !== ws && client.readyState === ws.OPEN && client.location === ws.location) client.send(ToJsonValue.nickname + " 님 : " + ToJsonValue.value);
        })
    })
    ws.on("close", () => {
        ws.send(" 현재 접속 인원 : " + --userCount);
        wss.clients.forEach((client) => {
            if (client !== ws && client.readyState === ws.OPEN && client.location === ws.location) 
            client.send(" 현재 접속 인원 : " + userCount);
        })
    })
})

app.listen(3000, () => {
    console.log("hi");
});