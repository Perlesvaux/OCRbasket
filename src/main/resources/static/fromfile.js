const fileInput = document.getElementById('fileInput');
const resultDiv = document.getElementById('result');

document.getElementById('uploadbtn').addEventListener('click', async () => {
    const file = fileInput.files[0];
    if (!file) {
        resultDiv.innerText = 'Please select a file.';
        return;
    }

    resultDiv.innerText = "Please wait..."

    try {
        const formData = new FormData();
        formData.append('file', file);

        const response = await fetch('/upload', {
            method: 'POST',
            body: formData,
            headers: {},
        });

        if (response.ok) {
            const text = await response.text();
            resultDiv.innerText = text;
        } else {
            resultDiv.innerText = 'Error uploading the file.';
        }
    } catch (error) {
        resultDiv.innerText = 'An error occurred: ' + error.message;
    }
});

