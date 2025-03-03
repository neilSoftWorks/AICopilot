function loadBusinessDetails() {
    fetch('/api/business-details')
        .then(response => response.json())
        .then(data => {
            const tableBody = document.getElementById('businessDetailsTableBody');
            tableBody.innerHTML = ''; // Clear existing data

            data.forEach(business => {
                const row = tableBody.insertRow();
                row.insertCell().textContent = business.id;
                row.insertCell().textContent = business.name;
                row.insertCell().textContent = business.address;

                // Actions
                const actionsCell = row.insertCell();
                const editButton = document.createElement('button');
                editButton.textContent = 'Edit';
                editButton.addEventListener('click', () => {
                    // Redirect to edit.html with the business ID
                    window.location.href = `/edit.html?id=${business.id}`;
                });
                actionsCell.appendChild(editButton);
            });
        });
}

loadBusinessDetails(); // Load data on page load
