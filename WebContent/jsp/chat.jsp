<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Chat Room</title>

    <style>
        body {
            margin: 0;
            padding: 0;
            height: 100vh;
            background: linear-gradient(135deg, #3b82f6, #06b6d4);
            font-family: "Poppins", sans-serif;
            display: flex;
            flex-direction: column;
            align-items: center;
            color: white;
        }
        .container {
            margin-top: 30px;
            width: 70%;
            max-width: 800px;
            background: rgba(255, 255, 255, 0.15);
            backdrop-filter: blur(10px);
            padding: 25px;
            border-radius: 16px;
            box-shadow: 0 6px 25px rgba(0,0,0,0.2);
            animation: fadeIn 0.6s ease-in-out;
        }
        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(10px); }
            to { opacity: 1; transform: translateY(0); }
        }
        h2, h3 {
            text-align: center;
            margin: 5px 0;
        }
        .chat-box {
            border-radius: 12px;
            background: rgba(255, 255, 255, 0.25);
            padding: 15px;
            height: 300px;
            overflow-y: auto;
            color: #f0f0f0;
            box-shadow: inset 0 0 10px rgba(0,0,0,0.1);
        }
        .msg {
            margin: 8px 0;
            padding: 8px 12px;
            background: rgba(255,255,255,0.2);
            border-radius: 8px;
            width: fit-content;
            max-width: 90%;
        }
        .msg b {
            color: #ffe082;
        }

        form {
            margin-top: 15px;
            text-align: center;
        }

        input[type="text"] {
            width: 60%;
            padding: 12px;
            border-radius: 8px;
            border: none;
            outline: none;
            font-size: 15px;
        }

        button {
            padding: 12px 20px;
            border: none;
            border-radius: 8px;
            background: #2563eb;
            color: white;
            font-size: 15px;
            cursor: pointer;
            transition: 0.3s;
            margin-left: 10px;
        }

        button:hover {
            background: #1e40af;
        }

        a {
            color: #ffe082;
            text-decoration: none;
            font-size: 14px;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>

<body>

<div class="container">
    <h2>Welcome, <%= session.getAttribute("uname") %></h2>
    <h3>Chat Room</h3>

    <div class="chat-box">
        <%
            List<Message> list = (List<Message>) request.getAttribute("messages");
            if(list != null){
                for(Message m : list){
        %>
            <div class="msg"><b><%= m.getUsername() %>:</b> <%= m.getText() %></div>
        <%
                }
            }
        %>
    </div>

    <form action="chat" method="post">
        <input type="text" name="text" placeholder="Type a message..." required />
        <button type="submit">Send</button>
    </form>

    <br>
    <div style="text-align:center;">
        <a href="logout">Logout</a>
    </div>
</div>

</body>
</html>