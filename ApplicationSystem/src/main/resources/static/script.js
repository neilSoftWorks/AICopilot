fetch('/api/applications')
    .then(response => {
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        return response.json();
    })
    .then(businessDetailsList => {
        const tableBody = document.getElementById('applicationsTable').getElementsByTagName('tbody')[0];
        tableBody.innerHTML = ''; // Clear table

        businessDetailsList.forEach(businessDetails => {
            const row = tableBody.insertRow();

            // Business details
            const businessNameCell = row.insertCell();
            const addressCell = row.insertCell();
            const tradingNameCell = row.insertCell();

            businessNameCell.textContent = businessDetails.name || '';
            addressCell.textContent = businessDetails.address || '';
            tradingNameCell.textContent = businessDetails.tradingName || '';

            // Application status
            const statusCell = row.insertCell();
            const statusNameCell = row.insertCell();
            const createdAtCell = row.insertCell();

            if (businessDetails.applicationStatus && businessDetails.applicationStatus.length > 0) {
                const status = businessDetails.applicationStatus[0];
                statusCell.textContent = status.status || '';
                statusNameCell.textContent = status.statusName || '';
                createdAtCell.textContent = status.createdAt || '';
            }

            // Actions
            const actionsCell = row.insertCell();
            const editButton = document.createElement('button');
            editButton.textContent = 'Edit';
            editButton.addEventListener('click', () => editRecord(businessDetails.id));
            actionsCell.appendChild(editButton);
        });
    })
    .catch(error => console.error('Fetch error:', error));

// Create Button Functionality
document.getElementById('createButton').addEventListener('click', () => createRecord());

// Functions to Implement (createRecord and editRecord):
function createRecord() {
    alert("create record functionality to be implemented");
}

function editRecord(id) {
    window.location.href = `edit.html?id=${id}`; // Redirect to edit.html with the ID as a query parameter
}
