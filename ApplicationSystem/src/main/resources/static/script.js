function loadBusinessDetails() {
    fetch('/api/applications') // Corrected endpoint
        .then(response => response.json())
        .then(data => {
            const tableBody = document.getElementById('businessDetailsTableBody');
            tableBody.innerHTML = '';

            data.forEach(business => {
                const row = tableBody.insertRow();
                row.insertCell().textContent = business.id;
                row.insertCell().textContent = business.name;
                row.insertCell().textContent = business.address;

                const actionsCell = row.insertCell();
                const editButton = document.createElement('button');
                editButton.textContent = 'Edit';
                editButton.addEventListener('click', () => {
                    window.location.href = `/edit.html?id=${business.id}`;
                });
                actionsCell.appendChild(editButton);
            });
        });
}

loadBusinessDetails();
