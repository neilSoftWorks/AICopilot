document.addEventListener('DOMContentLoaded', function() {
    const urlParams = new URLSearchParams(window.location.search);
    const id = urlParams.get('id');

    if (id) {
        fetch(`http://localhost:8080/applications/${id}`)
            .then(response => response.json())
            .then(detail => {
                document.getElementById('id').value = detail.id;
                document.getElementById('name').value = detail.name;
                document.getElementById('address').value = detail.address;
                document.getElementById('contactDetails').value = detail.contactDetails;
                document.getElementById('phoneNumber').value = detail.phoneNumber;
                document.getElementById('emailAddress').value = detail.emailAddress;
                document.getElementById('industry').value = detail.industry;
                document.getElementById('financialInformation').value = detail.financialInformation;
            })
            .catch(error => console.error('Error fetching business details:', error));
    }

    document.getElementById('editForm').addEventListener('submit', function(event) {
        event.preventDefault();
        const updatedDetail = {
            id: document.getElementById('id').value,
            name: document.getElementById('name').value,
            address: document.getElementById('address').value,
            contactDetails: document.getElementById('contactDetails').value,
            phoneNumber: document.getElementById('phoneNumber').value,
            emailAddress: document.getElementById('emailAddress').value,
            industry: document.getElementById('industry').value,
            financialInformation: document.getElementById('financialInformation').value
        };

        fetch(`http://localhost:8080/applications/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(updatedDetail)
        })
        .then(response => {
            if (response.ok) {
                alert('Business details updated successfully.');
                window.location.href = 'index.html';
            } else {
                alert('Failed to update business details.');
            }
        })
        .catch(error => console.error('Error updating business details:', error));
    });
});
