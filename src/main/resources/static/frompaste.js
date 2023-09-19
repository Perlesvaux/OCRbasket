const imageContainer = document.getElementById('imageContainer');
const resultDiv      = document.getElementById('result');

imageContainer.addEventListener('paste', async (event) => {
                resultDiv.innerText = "Please wait..."
try
    {
        const item     = event.clipboardData.items[0];
        const blob     = item.getAsFile();
        const formData = new FormData();
        formData.append('file', blob);

        const response = await fetch('/upload', {
            method: 'POST',
            body: formData,
            headers: {},// Important: Omit 'Content-Type' header to let Spring handle it
        });

        if (response.ok) {
            const text = await response.text();
            resultDiv.innerText = text;
        } else {
            resultDiv.innerText = 'Error uploading the file.';
        }
    }
catch (error)
    {
        resultDiv.innerText = 'An error occurred: ' + error.message;
    }
});

