function validateLoginForm() {
    console.log("Test");
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;
    const errorMessage = document.getElementById("error-message");
    console.log(username);

    errorMessage.textContent = "";

    if (!username || !password) {
        errorMessage.textContent = "Username and password are required.";
        return false;
    }

    console.log("invalid");
    return true;
}
