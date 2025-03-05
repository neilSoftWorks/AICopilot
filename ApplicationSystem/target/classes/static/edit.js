// Get the ID from the query parameter
const urlParams = new URLSearchParams(window.location.search);
const id = urlParams.get('id');

// Fetch the data for the record with the given ID
fetch(`/api/applications/${id}`) // Replace with your actual API endpoint
    .then(response => response.json())
    .then(businessDetails => {
        // Populate the form fields with the data
        document.getElementById('businessName').value = businessDetails.name || '';
        document.getElementById('address').value = businessDetails.address || '';
        document.getElementById('tradingName').value = businessDetails.tradingName || '';
        document.getElementById('contactDetails').value = businessDetails.contactDetails || '';
        document.getElementById('phoneNumber').value = businessDetails.phoneNumber || '';
        document.getElementById('emailAddress').value = businessDetails.emailAddress || '';
        document.getElementById('industry').value = businessDetails.industry || '';
        document.getElementById('financialInformation').value = businessDetails.financialInformation || '';

        if (businessDetails.applicationStatus && businessDetails.applicationStatus.length > 0) {
            const status = businessDetails.applicationStatus[0];
            document.getElementById('status').value = status.status || '';
            document.getElementById('statusName').value = status.statusName || '';
            if (status.createdAt) {
                const createdAt = new Date(status.createdAt);
                const formattedDate = createdAt.toISOString().slice(0, 16);
                document.getElementById('createdAt').value = formattedDate;
            }
        }
    })
    .catch(error => console.error('Error fetching application:', error));

// Handle form submission
document.getElementById('editForm').addEventListener('submit', (event) => {
    event.preventDefault(); // Prevent default form submission

    // Get the updated data from the form fields
    const updatedBusinessDetails = {
        name: document.getElementById('businessName').value,
        address: document.getElementById('address').value,
        tradingName: document.getElementById('tradingName').value,
        contactDetails: document.getElementById('contactDetails').value,
        phoneNumber: document.getElementById('phoneNumber').value,
        emailAddress: document.getElementById('emailAddress').value,
        industry: document.getElementById('industry').value,
        financialInformation: document.getElementById('financialInformation').value,
        applicationStatus: [{
            status: document.getElementById('status').value,
            statusName: document.getElementById('statusName').value,
            createdAt: document.getElementById('createdAt').value,
        }]
    };

    // Send a PUT or PATCH request to your backend API to update the record
    fetch(`/api/applications/${id}`, { // Replace with your actual API endpoint
        method: 'PUT', // Or 'PATCH'
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(updatedBusinessDetails),
    })
        .then(response => {
            if (response.ok) {
                // Redirect back to the main page or display a success message
                window.location.href = 'index.html';
            } else {
                console.error('Error updating application:', response.status);
            }
        })
        .catch(error => console.error('Error updating application:', error));
});