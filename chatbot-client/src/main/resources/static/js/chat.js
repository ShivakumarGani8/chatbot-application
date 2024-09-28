function sendMessage() {
    const userInput = document.getElementById("user-input").value;
    if (userInput.trim() === "") return;

    // Append user message to chat box
    appendMessage(userInput, "user-message");

    // Clear input field
    document.getElementById("user-input").value = "";

    // Send the user input to the Spring Boot backend using fetch
    fetch('/chat', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(userInput)
    })
    .then(response => response.text())
    .then(botMessage => {
        // Append the bot response to chat box
        appendMessage(botMessage, "bot-message");
    })
    .catch(error => {
        console.error("Error:", error);
        appendMessage("Sorry, something went wrong!", "bot-message");
    });
}

function appendMessage(message, className) {
    const chatBox = document.getElementById("chat-box");
    const messageElement = document.createElement("div");
    messageElement.classList.add(className);
    messageElement.textContent = message;
    chatBox.appendChild(messageElement);
    chatBox.scrollTop = chatBox.scrollHeight;
}

function checkSubmit(event) {
    if (event.key === 'Enter') {
        sendMessage();
    }
}
